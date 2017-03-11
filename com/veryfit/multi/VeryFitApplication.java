package com.veryfit.multi;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.text.TextUtils;
import cn.sharesdk.framework.ShareSDK;
import com.project.library.core.CoreServiceProxy;
import com.project.library.device.cmd.health.HealthDataDetailsCache;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.BleScanTool;
import com.project.library.util.DBTool;
import com.project.library.util.DebugLog;
import com.umeng.analytics.MobclickAgent;
import com.veryfit.multi.net.VolleyUtil;
import com.veryfit.multi.service.AssistService;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.LOGThread;
import com.veryfit.multi.util.TempUtil;
import java.io.File;
import java.io.IOException;

public class VeryFitApplication
  extends Application
{
  public static long date = -1L;
  public static int dateOffset;
  public static Context mUIContext;
  private static VeryFitApplication sInstance;
  
  public static VeryFitApplication getInstance()
  {
    return sInstance;
  }
  
  private void init()
  {
    sInstance = this;
    new LOGThread(Process.myPid()).start();
    LibSharedPreferences.getInstance().init(this);
    LibSharedPreferences.getInstance().setDebug(true);
    AppSharedPreferences.getInstance().init(this);
    TempUtil.init(this);
    DBTool.getInstance().init(this);
    HealthDataDetailsCache.getInstance();
    BleScanTool.getInstance().init(this);
    CoreServiceProxy.init(this);
    ShareSDK.initSDK(getApplicationContext(), "9b44ae9714f8");
    VolleyUtil.init(getApplicationContext());
    startService(new Intent(this, AssistService.class));
    try
    {
      String str = AppSharedPreferences.getInstance().getAppThemePackage();
      if (!TextUtils.isEmpty(str)) {
        mUIContext = createPackageContext(str, 3);
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      DebugLog.e("theme package not exist !");
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    String str1 = getDatabasePath("db_veryfit2_.db").getAbsolutePath();
    String str2 = getDatabasePath("db_veryfit2.db").getAbsolutePath();
    if (new File(str1).exists()) {
      str1 = "rm -rf " + str2 + "; mv -f " + str1 + "  " + str2;
    }
    try
    {
      Runtime.getRuntime().exec(str1);
      MobclickAgent.openActivityDurationTrack(false);
      init();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
  }
  
  public void onTerminate()
  {
    super.onTerminate();
    CoreServiceProxy.fini();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\VeryFitApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */