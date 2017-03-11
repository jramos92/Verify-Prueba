package cn.sharesdk.tencent.qq;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.R;
import java.io.File;

public class i
  extends FakeActivity
{
  private Platform a;
  private String b;
  private PlatformActionListener c;
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    paramString2 = b(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8);
    paramString1 = new Intent("android.intent.action.VIEW");
    paramString1.setData(Uri.parse(paramString2));
    try
    {
      paramString2 = a();
      paramString3 = new h();
      paramString3.a(this.b);
      paramString3.a(this.a, this.c);
      FakeActivity.registerExecutor(this.b, paramString3);
      if ((paramString2.length <= 1) || ((paramString2[0] < 4) && (paramString2[1] < 6))) {
        paramString1.putExtra("key_request_code", 0);
      }
      paramString1.putExtra("pkg_name", this.activity.getPackageName());
      this.activity.startActivityForResult(paramString1, 0);
      return;
    }
    catch (Throwable paramString1)
    {
      do
      {
        this.activity.finish();
      } while (this.c == null);
      this.c.onError(this.a, 9, paramString1);
    }
  }
  
  private int[] a()
  {
    int[] arrayOfInt;
    try
    {
      localObject = this.a.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
      localObject = ((String)localObject).split("\\.");
      arrayOfInt = new int[localObject.length];
      i = 0;
      if (i >= arrayOfInt.length) {}
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        for (;;)
        {
          Object localObject;
          arrayOfInt[i] = R.parseInt(localObject[i]);
          i += 1;
        }
        localThrowable1 = localThrowable1;
        d.a().w(localThrowable1);
        String str = "0";
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          int i;
          d.a().w(localThrowable2);
          arrayOfInt[i] = 0;
        }
      }
    }
    return arrayOfInt;
  }
  
  private String b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    String str = "mqqapi://share/to_fri?src_type=app&version=1&file_type=news";
    if (!TextUtils.isEmpty(paramString4)) {
      str = "mqqapi://share/to_fri?src_type=app&version=1&file_type=news" + "&image_url=" + Base64.encodeToString(paramString4.getBytes(), 2);
    }
    paramString4 = str;
    if (!TextUtils.isEmpty(paramString5)) {
      paramString4 = str + "&file_data=" + Base64.encodeToString(paramString5.getBytes(), 2);
    }
    str = paramString4;
    if (!TextUtils.isEmpty(paramString1)) {
      str = paramString4 + "&title=" + Base64.encodeToString(paramString1.getBytes(), 2);
    }
    paramString4 = str;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString4 = str + "&description=" + Base64.encodeToString(paramString3.getBytes(), 2);
    }
    str = paramString4;
    if (!TextUtils.isEmpty(paramString7))
    {
      str = paramString7;
      if (paramString7.length() > 20) {
        str = paramString7.substring(0, 20) + "...";
      }
      str = paramString4 + "&app_name=" + Base64.encodeToString(str.getBytes(), 2);
    }
    paramString4 = str;
    if (!TextUtils.isEmpty(paramString8)) {
      paramString4 = str + "&share_id=" + paramString8;
    }
    paramString7 = paramString4;
    if (!TextUtils.isEmpty(paramString2)) {
      paramString7 = paramString4 + "&url=" + Base64.encodeToString(paramString2.getBytes(), 2);
    }
    paramString4 = paramString7;
    if (!TextUtils.isEmpty(paramString3)) {
      paramString4 = paramString7 + "&share_qq_ext_str=" + Base64.encodeToString(paramString3.getBytes(), 2);
    }
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString3)) && (TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString5))) {
      paramString1 = paramString4 + "&req_type=" + Base64.encodeToString("5".getBytes(), 2);
    }
    for (;;)
    {
      return paramString1 + "&cflag=" + Base64.encodeToString("0".getBytes(), 2);
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (TextUtils.isEmpty(paramString2)))
      {
        paramString1 = paramString4 + "&req_type=" + Base64.encodeToString("6".getBytes(), 2);
      }
      else if (!TextUtils.isEmpty(paramString6))
      {
        paramString1 = paramString4 + "&req_type=" + Base64.encodeToString("2".getBytes(), 2);
        paramString1 = paramString1 + "&audioUrl=" + Base64.encodeToString(paramString6.getBytes(), 2);
      }
      else
      {
        paramString1 = paramString4 + "&req_type=" + Base64.encodeToString("1".getBytes(), 2);
      }
    }
  }
  
  public void a(Platform paramPlatform, PlatformActionListener paramPlatformActionListener)
  {
    this.a = paramPlatform;
    this.c = paramPlatformActionListener;
  }
  
  public void a(String paramString)
  {
    this.b = ("tencent" + paramString);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    finish();
  }
  
  public void onCreate()
  {
    Object localObject = this.activity.getIntent().getExtras();
    String str1 = ((Bundle)localObject).getString("title");
    String str2 = ((Bundle)localObject).getString("titleUrl");
    String str3 = ((Bundle)localObject).getString("summary");
    String str4 = ((Bundle)localObject).getString("imageUrl");
    String str5 = ((Bundle)localObject).getString("musicUrl");
    String str6 = DeviceHelper.getInstance(this.activity).getAppName();
    String str7 = ((Bundle)localObject).getString("appId");
    localObject = ((Bundle)localObject).getString("imagePath");
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str2)) && ((TextUtils.isEmpty((CharSequence)localObject)) || (!new File((String)localObject).exists())) && (!TextUtils.isEmpty(str4)))
    {
      new j(this, str4, str1, str2, str3, str5, str6, str7).start();
      return;
    }
    a(str1, str2, str3, str4, (String)localObject, str5, str6, str7);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qq\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */