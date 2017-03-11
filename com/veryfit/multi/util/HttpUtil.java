package com.veryfit.multi.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.google.gson.JsonObject;
import com.project.library.util.DebugLog;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

public class HttpUtil
{
  public static final int CONN_ERROR = 2;
  public static final int DOWN_LOAD_PROGRESS = 1;
  public static final String ERROR_PATH = "http://www.youduoyun.com/api/app_ota_feedback";
  public static final String OTA_REPEAT_COUNT = "ota_repeat_count";
  public static final String PATH = "http://www.youduoyun.com/apps/firmwares/firmware.json";
  public static final String SP_NAME = "veryfit_multi_app";
  public static final MediaType jsonReq = MediaType.parse("application/json;charset=utf-8");
  
  public static void downLoad(Handler paramHandler, String paramString1, String paramString2)
  {
    Object localObject = new OkHttpClient();
    paramString2 = new Request.Builder().url(paramString2).build();
    try
    {
      paramString2 = ((OkHttpClient)localObject).newCall(paramString2).execute();
      if (paramString2.isSuccessful())
      {
        paramString2 = paramString2.body();
        long l2 = paramString2.contentLength();
        long l1 = 0L;
        paramString2 = paramString2.byteStream();
        paramString1 = new FileOutputStream(paramString1);
        localObject = new byte['Ȁ'];
        for (;;)
        {
          int i = paramString2.read((byte[])localObject);
          if (i == -1)
          {
            paramString1.close();
            return;
          }
          paramString1.write((byte[])localObject, 0, i);
          l1 += i;
          paramHandler.sendMessage(paramHandler.obtainMessage(1, Integer.valueOf(Math.round((float)(100L * l1) / ((float)l2 * 1.0F)))));
        }
      }
      return;
    }
    catch (IOException paramString1)
    {
      paramHandler.sendMessage(paramHandler.obtainMessage(2, Integer.valueOf(2131296402)));
      paramString1.printStackTrace();
    }
  }
  
  public static String get(String paramString, Map<String, Object> paramMap)
  {
    paramMap = null;
    Object localObject = new OkHttpClient();
    paramString = new Request.Builder().url(paramString).build();
    try
    {
      localObject = ((OkHttpClient)localObject).newCall(paramString).execute();
      paramString = paramMap;
      if (((Response)localObject).isSuccessful()) {
        paramString = ((Response)localObject).body().string();
      }
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String getAppVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return " ";
  }
  
  public static String getApplicationName(Context paramContext)
  {
    Object localObject = null;
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      localObject = localPackageManager;
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
      localObject = localPackageManager;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
    return (String)((PackageManager)localObject).getApplicationLabel(paramContext);
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null) {
        return paramContext.isAvailable();
      }
    }
    return false;
  }
  
  public static void postUpdateNote(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("veryfit_multi_app", 0);
    DebugLog.d("postUpdateNote");
    Object localObject = new JsonObject();
    ((JsonObject)localObject).addProperty("device_id", Integer.valueOf(paramInt1));
    ((JsonObject)localObject).addProperty("device_version", Integer.valueOf(paramInt2));
    ((JsonObject)localObject).addProperty("app_name", getApplicationName(paramContext));
    ((JsonObject)localObject).addProperty("app_version", getAppVersion(paramContext));
    ((JsonObject)localObject).addProperty("phone_system", Build.MODEL);
    ((JsonObject)localObject).addProperty("phone_system_version", Build.VERSION.RELEASE);
    ((JsonObject)localObject).addProperty("failed_count", Integer.valueOf(paramInt3));
    ((JsonObject)localObject).addProperty("ota_repeat_count", Integer.valueOf(localSharedPreferences.getInt("ota_repeat_count", 1)));
    ((JsonObject)localObject).addProperty("failed_code", Integer.valueOf(paramInt4));
    ((JsonObject)localObject).addProperty("failed_reason", Integer.valueOf(paramInt5));
    DebugLog.d(((JsonObject)localObject).toString());
    paramContext = new OkHttpClient();
    localObject = RequestBody.create(jsonReq, ((JsonObject)localObject).toString());
    paramContext.newCall(new Request.Builder().url("http://www.youduoyun.com/api/app_ota_feedback").post((RequestBody)localObject).build()).enqueue(new Callback()
    {
      public void onFailure(Request paramAnonymousRequest, IOException paramAnonymousIOException)
      {
        paramAnonymousIOException.printStackTrace();
      }
      
      public void onResponse(Response paramAnonymousResponse)
        throws IOException
      {
        DebugLog.d("onResponse");
        if (paramAnonymousResponse.isSuccessful())
        {
          paramAnonymousResponse = paramAnonymousResponse.body().string();
          DebugLog.d("onResponse result:" + paramAnonymousResponse);
          return;
        }
        throw new IOException("Unexpected code " + paramAnonymousResponse);
      }
    });
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\HttpUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */