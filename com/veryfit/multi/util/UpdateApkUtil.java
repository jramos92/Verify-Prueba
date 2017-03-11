package com.veryfit.multi.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Handler;
import android.os.Process;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class UpdateApkUtil
{
  public static final int DOWN_LOAD_APK_FINISH = 2;
  public static final int DOWN_LOAD_APK_PROGRESS = 1;
  public static final int DOWN_LOAD_ERROR = 3;
  
  public static void InstallNewApp(Activity paramActivity, File paramFile)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.android.package-archive");
    localIntent.setFlags(268435456);
    paramActivity.startActivity(localIntent);
    Process.killProcess(Process.myPid());
  }
  
  public static void downloadApk(Handler paramHandler, String paramString1, String paramString2)
  {
    paramString2 = new OkHttpClient().newCall(new Request.Builder().url(paramString2).build());
    try
    {
      paramString2 = paramString2.execute();
      if (paramString2.isSuccessful())
      {
        paramString2 = paramString2.body();
        long l2 = paramString2.contentLength();
        long l1 = 0L;
        paramString2 = paramString2.byteStream();
        paramString1 = new FileOutputStream(paramString1);
        byte[] arrayOfByte = new byte['Ѐ'];
        for (;;)
        {
          int i = paramString2.read(arrayOfByte);
          if (i == -1)
          {
            paramHandler.sendMessage(paramHandler.obtainMessage(2, null));
            paramString1.close();
            return;
          }
          paramString1.write(arrayOfByte, 0, i);
          l1 += i;
          paramHandler.sendMessage(paramHandler.obtainMessage(1, Integer.valueOf(Math.round((float)(100L * l1) / ((float)l2 * 1.0F)))));
        }
      }
      return;
    }
    catch (IOException paramString1)
    {
      paramHandler.sendMessage(paramHandler.obtainMessage(3, Integer.valueOf(2131296402)));
      paramString1.printStackTrace();
    }
  }
  
  public static int getAppVersionCode(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return 1;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    Object localObject = paramContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return paramContext.getString(2131296646);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\util\UpdateApkUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */