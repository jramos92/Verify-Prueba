package com.veryfit.multi.ui.activity.mine;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings.System;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.database.AlarmNotify;
import com.project.library.device.cmd.DeviceRestartCmd;
import com.project.library.device.cmd.getinfo.GetInfoCmd;
import com.project.library.device.cmd.health.HealthSyncRequest;
import com.project.library.device.cmd.settings.AntilostInfos;
import com.project.library.device.cmd.settings.MultiTarget;
import com.project.library.device.cmd.settings.Sedentariness;
import com.project.library.device.cmd.settings.SettingsCmd;
import com.project.library.device.cmd.settings.Units;
import com.project.library.device.cmd.settings.Userinfos;
import com.project.library.share.LibSharedPreferences;
import com.project.library.util.DebugLog;
import com.project.library.util.LongDateUtil;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.net.AVolleyResponse;
import com.veryfit.multi.net.VolleyUtil;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.Constant;
import com.veryfit.multi.util.NetUtils;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.util.UpdateApkUtil;
import com.veryfit.multi.util.XZip;
import com.veryfit.multi.util.XZip.Zip;
import com.veryfit.multi.view.BufferDialog;
import com.veryfit.multi.view.DialogUtil;
import com.veryfit.multi.view.DialogUtil.OnDialogClickListener;
import com.veryfit.multi.view.DialogUtil.OnTimePickerSelectListener;
import com.veryfit.multi.view.DialogUtil.OnWheelSelectorListener;
import com.veryfit.multi.view.group.ItemLableValue;
import com.veryfit.multi.vo.AppUpdateInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.channels.FileChannel;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

public class SysSettingsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private static final String CONFIG_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/veryfit2" + "/log";
  private AppUpdateInfo apInfo;
  private ImageView back;
  private boolean canUpdate = false;
  private long clickCount;
  private long clickTime;
  private Dialog dialog;
  private Dialog dialogCircle = null;
  long exportClickTime = 0L;
  private Handler handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 1: 
        int i = ((Integer)paramAnonymousMessage.obj).intValue();
        Log.d("abc", "Down load apk:" + i);
        return;
      case 2: 
        Toast.makeText(SysSettingsActivity.this, "下载完成", 0).show();
        UpdateApkUtil.InstallNewApp(SysSettingsActivity.this, new File(Constant.FILE_PATH, "VeryFitMulti.apk"));
        return;
      case 3: 
        Toast.makeText(SysSettingsActivity.this, SysSettingsActivity.this.getString(((Integer)paramAnonymousMessage.obj).intValue()), 0).show();
        return;
      }
      SysSettingsActivity.this.hideProgress();
      SysSettingsActivity.this.isOutTime = true;
      Toast.makeText(SysSettingsActivity.this, SysSettingsActivity.this.getString(2131296673), 0).show();
    }
  };
  private boolean isOutTime = false;
  private ItemLableValue item_app;
  private ImageView iv_about_us;
  private ImageView iv_normal_problem;
  private LinearLayout llSendEmail;
  private ConcurrentLinkedQueue<AlarmNotify> mAlarmList = new ConcurrentLinkedQueue();
  private APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onBLEConnected()
    {
      if (SysSettingsActivity.this.reboot)
      {
        SysSettingsActivity.this.startSyncScanTimer(false);
        SysSettingsActivity.this.isOutTime = false;
        SysSettingsActivity.this.hideProgress();
        SysSettingsActivity.this.showCircleDialog();
        SysSettingsActivity.this.onDeviceNeedInit();
      }
    }
    
    public void onGetInfo(byte paramAnonymousByte)
    {
      if (paramAnonymousByte == 2) {
        SysSettingsActivity.this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)1));
      }
      if (paramAnonymousByte == 1)
      {
        DebugLog.i(">>获取设备信息成功,需要初始化设置值，正在发送个人信息设置");
        SysSettingsActivity.this.sendUnitSet();
      }
    }
    
    public void onOtherDataReceive(byte[] paramAnonymousArrayOfByte)
    {
      if ((paramAnonymousArrayOfByte[0] == 240) && (paramAnonymousArrayOfByte[1] == 1)) {
        switch (paramAnonymousArrayOfByte[2])
        {
        }
      }
      for (;;)
      {
        SysSettingsActivity.this.hideProgress();
        return;
        SysSettingsActivity.this.tv_restartDevice.setValue(SysSettingsActivity.this.getString(2131296508));
        SysSettingsActivity.this.reboot = true;
        continue;
        SysSettingsActivity.this.tv_restartDevice.setValue(SysSettingsActivity.this.getString(2131296509));
        continue;
        SysSettingsActivity.this.tv_restartDevice.setValue(SysSettingsActivity.this.getString(2131296510));
      }
    }
    
    public void onSettingsSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean)
      {
        switch (paramAnonymousByte)
        {
        default: 
          return;
        case 1: 
          DebugLog.i(">>时间设置成功,获取设备信息");
          SysSettingsActivity.this.setUserInfo();
          return;
        case 2: 
          DebugLog.i(">>闹钟设置成功");
          SysSettingsActivity.this.onReciveSettingAlarm();
          return;
        case 32: 
          DebugLog.i(">>久坐设置成功");
          SysSettingsActivity.this.onReviceSettingRemindSport();
          return;
        case 33: 
          DebugLog.i(">>防丢设置成功");
          SysSettingsActivity.this.onReciveLost();
          return;
        case 16: 
          DebugLog.i(">>用户信息设置成功");
          SysSettingsActivity.this.onReciveUserInfo();
          return;
        case 3: 
          DebugLog.i(">>运动目标设置成功");
          SysSettingsActivity.this.onReciveMultiTarget();
          return;
        case 17: 
          DebugLog.i(">>单位设置成功");
          SysSettingsActivity.this.onRecivesendUnit();
          return;
        }
        DebugLog.i(">>寻找手机设置成功");
        SysSettingsActivity.this.onReciveFindPhone();
        return;
      }
      DebugLog.e("设置失败： " + paramAnonymousByte);
    }
    
    public void onSyncData(int paramAnonymousInt)
    {
      DebugLog.d("正在同步数据" + paramAnonymousInt + "%");
      if (!SysSettingsActivity.this.isOutTime) {
        SysSettingsActivity.this.showProgress(SysSettingsActivity.this.getString(2131296674, new Object[] { paramAnonymousInt + "%" }));
      }
      if (paramAnonymousInt == 100)
      {
        AppSharedPreferences.getInstance().setDeviceSyncEndTime(Calendar.getInstance());
        DebugLog.d("正在同步数据，已完成100%");
        if (SysSettingsActivity.this.reboot)
        {
          if ((SysSettingsActivity.this.mProgress != null) && (SysSettingsActivity.this.mProgress.isShowing())) {
            SysSettingsActivity.this.mProgress.setMessage(SysSettingsActivity.this.getString(2131296675));
          }
          SysSettingsActivity.this.mCore.write(DeviceRestartCmd.getInstance().getDeviceRestartCmd());
        }
      }
    }
  };
  private AppSharedPreferences mAppSharedPreferences = AppSharedPreferences.getInstance();
  private BufferDialog mBufferDialog;
  CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private FindPhoneRunnable mFindPhoneRunnable = null;
  private Handler mHandler = new Handler();
  private ProgressDialog mProgress;
  private SettingTimeoutRunnable mSettingTimeoutRunnable = null;
  private boolean noNetWork = false;
  private boolean reboot = false;
  private Timer syncTimer = new Timer();
  private Toast toast;
  private TextView tv;
  private ItemLableValue tv_restartDevice;
  private TextView tv_time_notice;
  private TextView tv_units;
  private ItemLableValue version;
  
  private void closeCircleDialog()
  {
    if (this.dialogCircle != null) {
      this.dialogCircle.dismiss();
    }
    if (this.mSettingTimeoutRunnable != null) {
      this.handler.removeCallbacks(this.mSettingTimeoutRunnable);
    }
  }
  
  private void cpDb2Sdcard(String paramString1, String paramString2)
  {
    String str = "cp -f " + paramString1 + "  " + paramString2;
    try
    {
      Runtime.getRuntime().exec(str);
      paramString1 = new File(paramString1);
      Environment.getExternalStorageDirectory().getAbsolutePath();
      paramString2 = new File(paramString2);
      if (!paramString1.exists()) {}
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          paramString2 = new FileOutputStream(paramString2).getChannel();
          new FileInputStream(paramString1).getChannel().transferTo(0L, paramString1.length(), paramString2);
          return;
        }
        catch (FileNotFoundException paramString1)
        {
          paramString1.printStackTrace();
          return;
        }
        catch (IOException paramString1)
        {
          paramString1.printStackTrace();
        }
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
    }
  }
  
  private void cpDb2Sdcard2(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2);
    if (paramString1.exists()) {}
    try
    {
      paramString2 = new FileOutputStream(paramString2).getChannel();
      new FileInputStream(paramString1).getChannel().transferTo(0L, paramString1.length(), paramString2);
      return;
    }
    catch (FileNotFoundException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private void createLogFileDir()
  {
    File localFile = new File(Constant.LOG_PATH);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  /* Error */
  private void exportDb2File()
  {
    // Byte code:
    //   0: new 100	java/lang/StringBuilder
    //   3: dup
    //   4: invokestatic 106	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   7: invokevirtual 112	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: ldc 124
    //   18: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc_w 358
    //   24: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore 6
    //   32: new 360	java/lang/StringBuffer
    //   35: dup
    //   36: invokespecial 361	java/lang/StringBuffer:<init>	()V
    //   39: astore 5
    //   41: invokestatic 366	com/project/library/util/DBTool:getInstance	()Lcom/project/library/util/DBTool;
    //   44: invokevirtual 370	com/project/library/util/DBTool:getDaoSession	()Lcom/project/library/database/DaoSession;
    //   47: astore 7
    //   49: aload 7
    //   51: invokevirtual 376	com/project/library/database/DaoSession:getSportDataDayDao	()Lcom/project/library/database/SportDataDayDao;
    //   54: invokevirtual 382	com/project/library/database/SportDataDayDao:queryBuilder	()Lde/greenrobot/dao/query/QueryBuilder;
    //   57: astore_2
    //   58: aload_2
    //   59: iconst_1
    //   60: anewarray 384	de/greenrobot/dao/Property
    //   63: dup
    //   64: iconst_0
    //   65: getstatic 390	com/project/library/database/SportDataDayDao$Properties:Date	Lde/greenrobot/dao/Property;
    //   68: aastore
    //   69: invokevirtual 396	de/greenrobot/dao/query/QueryBuilder:orderDesc	([Lde/greenrobot/dao/Property;)Lde/greenrobot/dao/query/QueryBuilder;
    //   72: pop
    //   73: aload_2
    //   74: invokevirtual 400	de/greenrobot/dao/query/QueryBuilder:list	()Ljava/util/List;
    //   77: astore_2
    //   78: aload_2
    //   79: invokeinterface 405 1 0
    //   84: ifne +15 -> 99
    //   87: iconst_0
    //   88: istore_1
    //   89: iload_1
    //   90: aload_2
    //   91: invokeinterface 409 1 0
    //   96: if_icmplt +737 -> 833
    //   99: new 108	java/io/File
    //   102: dup
    //   103: aload 6
    //   105: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: astore_2
    //   109: aload_2
    //   110: invokevirtual 320	java/io/File:exists	()Z
    //   113: ifne +8 -> 121
    //   116: aload_2
    //   117: invokevirtual 356	java/io/File:mkdirs	()Z
    //   120: pop
    //   121: new 108	java/io/File
    //   124: dup
    //   125: new 100	java/lang/StringBuilder
    //   128: dup
    //   129: aload 6
    //   131: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   134: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: ldc_w 411
    //   140: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: astore_2
    //   150: aload_2
    //   151: invokevirtual 414	java/io/File:delete	()Z
    //   154: pop
    //   155: aconst_null
    //   156: astore 4
    //   158: aconst_null
    //   159: astore_3
    //   160: new 416	java/io/FileWriter
    //   163: dup
    //   164: aload_2
    //   165: iconst_1
    //   166: invokespecial 419	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   169: astore_2
    //   170: aload_2
    //   171: aload 5
    //   173: invokevirtual 420	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   176: invokevirtual 423	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   179: pop
    //   180: aload_2
    //   181: invokevirtual 426	java/io/FileWriter:flush	()V
    //   184: aload_2
    //   185: ifnull +788 -> 973
    //   188: aload_2
    //   189: invokevirtual 429	java/io/FileWriter:close	()V
    //   192: aload 7
    //   194: invokevirtual 433	com/project/library/database/DaoSession:getSportDataItemDao	()Lcom/project/library/database/SportDataItemDao;
    //   197: invokevirtual 436	com/project/library/database/SportDataItemDao:queryBuilder	()Lde/greenrobot/dao/query/QueryBuilder;
    //   200: astore_3
    //   201: aload_3
    //   202: iconst_1
    //   203: anewarray 384	de/greenrobot/dao/Property
    //   206: dup
    //   207: iconst_0
    //   208: getstatic 439	com/project/library/database/SportDataItemDao$Properties:Date	Lde/greenrobot/dao/Property;
    //   211: aastore
    //   212: invokevirtual 396	de/greenrobot/dao/query/QueryBuilder:orderDesc	([Lde/greenrobot/dao/Property;)Lde/greenrobot/dao/query/QueryBuilder;
    //   215: pop
    //   216: aload_3
    //   217: invokevirtual 400	de/greenrobot/dao/query/QueryBuilder:list	()Ljava/util/List;
    //   220: astore_3
    //   221: aload 5
    //   223: iconst_0
    //   224: invokevirtual 443	java/lang/StringBuffer:setLength	(I)V
    //   227: aload_3
    //   228: invokeinterface 405 1 0
    //   233: ifne +15 -> 248
    //   236: iconst_0
    //   237: istore_1
    //   238: iload_1
    //   239: aload_3
    //   240: invokeinterface 409 1 0
    //   245: if_icmplt +731 -> 976
    //   248: new 108	java/io/File
    //   251: dup
    //   252: new 100	java/lang/StringBuilder
    //   255: dup
    //   256: aload 6
    //   258: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   261: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   264: ldc_w 445
    //   267: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   276: astore_3
    //   277: aload_3
    //   278: invokevirtual 414	java/io/File:delete	()Z
    //   281: pop
    //   282: aload_2
    //   283: astore 4
    //   285: new 416	java/io/FileWriter
    //   288: dup
    //   289: aload_3
    //   290: iconst_1
    //   291: invokespecial 419	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   294: astore_3
    //   295: aload_3
    //   296: aload 5
    //   298: invokevirtual 420	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   301: invokevirtual 423	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   304: pop
    //   305: aload_3
    //   306: invokevirtual 426	java/io/FileWriter:flush	()V
    //   309: aload_3
    //   310: ifnull +857 -> 1167
    //   313: aload_3
    //   314: invokevirtual 429	java/io/FileWriter:close	()V
    //   317: aload_3
    //   318: astore_2
    //   319: aload 7
    //   321: invokevirtual 449	com/project/library/database/DaoSession:getSleepDataDayDao	()Lcom/project/library/database/SleepDataDayDao;
    //   324: invokevirtual 452	com/project/library/database/SleepDataDayDao:queryBuilder	()Lde/greenrobot/dao/query/QueryBuilder;
    //   327: astore_3
    //   328: aload_3
    //   329: iconst_1
    //   330: anewarray 384	de/greenrobot/dao/Property
    //   333: dup
    //   334: iconst_0
    //   335: getstatic 455	com/project/library/database/SleepDataDayDao$Properties:Date	Lde/greenrobot/dao/Property;
    //   338: aastore
    //   339: invokevirtual 396	de/greenrobot/dao/query/QueryBuilder:orderDesc	([Lde/greenrobot/dao/Property;)Lde/greenrobot/dao/query/QueryBuilder;
    //   342: pop
    //   343: aload_3
    //   344: invokevirtual 400	de/greenrobot/dao/query/QueryBuilder:list	()Ljava/util/List;
    //   347: astore_3
    //   348: aload 5
    //   350: iconst_0
    //   351: invokevirtual 443	java/lang/StringBuffer:setLength	(I)V
    //   354: aload_3
    //   355: invokeinterface 405 1 0
    //   360: ifne +15 -> 375
    //   363: iconst_0
    //   364: istore_1
    //   365: iload_1
    //   366: aload_3
    //   367: invokeinterface 409 1 0
    //   372: if_icmplt +800 -> 1172
    //   375: new 108	java/io/File
    //   378: dup
    //   379: new 100	java/lang/StringBuilder
    //   382: dup
    //   383: aload 6
    //   385: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   388: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   391: ldc_w 457
    //   394: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   403: astore_3
    //   404: aload_3
    //   405: invokevirtual 414	java/io/File:delete	()Z
    //   408: pop
    //   409: aload_2
    //   410: astore 4
    //   412: new 416	java/io/FileWriter
    //   415: dup
    //   416: aload_3
    //   417: iconst_1
    //   418: invokespecial 419	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   421: astore_3
    //   422: aload_3
    //   423: aload 5
    //   425: invokevirtual 420	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   428: invokevirtual 423	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   431: pop
    //   432: aload_3
    //   433: invokevirtual 426	java/io/FileWriter:flush	()V
    //   436: aload_3
    //   437: ifnull +935 -> 1372
    //   440: aload_3
    //   441: invokevirtual 429	java/io/FileWriter:close	()V
    //   444: aload_3
    //   445: astore_2
    //   446: aload 7
    //   448: invokevirtual 461	com/project/library/database/DaoSession:getSleepDataItemDao	()Lcom/project/library/database/SleepDataItemDao;
    //   451: invokevirtual 464	com/project/library/database/SleepDataItemDao:queryBuilder	()Lde/greenrobot/dao/query/QueryBuilder;
    //   454: astore_3
    //   455: aload_3
    //   456: iconst_1
    //   457: anewarray 384	de/greenrobot/dao/Property
    //   460: dup
    //   461: iconst_0
    //   462: getstatic 467	com/project/library/database/SleepDataItemDao$Properties:Date	Lde/greenrobot/dao/Property;
    //   465: aastore
    //   466: invokevirtual 396	de/greenrobot/dao/query/QueryBuilder:orderDesc	([Lde/greenrobot/dao/Property;)Lde/greenrobot/dao/query/QueryBuilder;
    //   469: pop
    //   470: aload_3
    //   471: invokevirtual 400	de/greenrobot/dao/query/QueryBuilder:list	()Ljava/util/List;
    //   474: astore_3
    //   475: aload 5
    //   477: iconst_0
    //   478: invokevirtual 443	java/lang/StringBuffer:setLength	(I)V
    //   481: aload_3
    //   482: invokeinterface 405 1 0
    //   487: ifne +15 -> 502
    //   490: iconst_0
    //   491: istore_1
    //   492: iload_1
    //   493: aload_3
    //   494: invokeinterface 409 1 0
    //   499: if_icmplt +878 -> 1377
    //   502: new 108	java/io/File
    //   505: dup
    //   506: new 100	java/lang/StringBuilder
    //   509: dup
    //   510: aload 6
    //   512: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   515: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   518: ldc_w 469
    //   521: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   530: astore_3
    //   531: aload_3
    //   532: invokevirtual 414	java/io/File:delete	()Z
    //   535: pop
    //   536: aload_2
    //   537: astore 4
    //   539: new 416	java/io/FileWriter
    //   542: dup
    //   543: aload_3
    //   544: iconst_1
    //   545: invokespecial 419	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   548: astore_3
    //   549: aload_3
    //   550: aload 5
    //   552: invokevirtual 420	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   555: invokevirtual 423	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   558: pop
    //   559: aload_3
    //   560: invokevirtual 426	java/io/FileWriter:flush	()V
    //   563: aload_3
    //   564: ifnull +946 -> 1510
    //   567: aload_3
    //   568: invokevirtual 429	java/io/FileWriter:close	()V
    //   571: aload_3
    //   572: astore_2
    //   573: aload 7
    //   575: invokevirtual 473	com/project/library/database/DaoSession:getHeartRateDao	()Lcom/project/library/database/HeartRateDao;
    //   578: invokevirtual 476	com/project/library/database/HeartRateDao:queryBuilder	()Lde/greenrobot/dao/query/QueryBuilder;
    //   581: astore_3
    //   582: aload_3
    //   583: iconst_1
    //   584: anewarray 384	de/greenrobot/dao/Property
    //   587: dup
    //   588: iconst_0
    //   589: getstatic 479	com/project/library/database/HeartRateDao$Properties:Date	Lde/greenrobot/dao/Property;
    //   592: aastore
    //   593: invokevirtual 396	de/greenrobot/dao/query/QueryBuilder:orderDesc	([Lde/greenrobot/dao/Property;)Lde/greenrobot/dao/query/QueryBuilder;
    //   596: pop
    //   597: aload_3
    //   598: invokevirtual 400	de/greenrobot/dao/query/QueryBuilder:list	()Ljava/util/List;
    //   601: astore_3
    //   602: aload 5
    //   604: iconst_0
    //   605: invokevirtual 443	java/lang/StringBuffer:setLength	(I)V
    //   608: aload_3
    //   609: invokeinterface 405 1 0
    //   614: ifne +15 -> 629
    //   617: iconst_0
    //   618: istore_1
    //   619: iload_1
    //   620: aload_3
    //   621: invokeinterface 409 1 0
    //   626: if_icmplt +889 -> 1515
    //   629: new 108	java/io/File
    //   632: dup
    //   633: new 100	java/lang/StringBuilder
    //   636: dup
    //   637: aload 6
    //   639: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   642: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   645: ldc_w 481
    //   648: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   654: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   657: astore_3
    //   658: aload_3
    //   659: invokevirtual 414	java/io/File:delete	()Z
    //   662: pop
    //   663: aload_2
    //   664: astore 4
    //   666: new 416	java/io/FileWriter
    //   669: dup
    //   670: aload_3
    //   671: iconst_1
    //   672: invokespecial 419	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   675: astore_3
    //   676: aload_3
    //   677: aload 5
    //   679: invokevirtual 420	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   682: invokevirtual 423	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   685: pop
    //   686: aload_3
    //   687: invokevirtual 426	java/io/FileWriter:flush	()V
    //   690: aload_3
    //   691: ifnull +957 -> 1648
    //   694: aload_3
    //   695: invokevirtual 429	java/io/FileWriter:close	()V
    //   698: aload_3
    //   699: astore_2
    //   700: aload 7
    //   702: invokevirtual 485	com/project/library/database/DaoSession:getHeartRateTresholdDao	()Lcom/project/library/database/HeartRateTresholdDao;
    //   705: invokevirtual 488	com/project/library/database/HeartRateTresholdDao:queryBuilder	()Lde/greenrobot/dao/query/QueryBuilder;
    //   708: astore_3
    //   709: aload_3
    //   710: iconst_1
    //   711: anewarray 384	de/greenrobot/dao/Property
    //   714: dup
    //   715: iconst_0
    //   716: getstatic 491	com/project/library/database/HeartRateTresholdDao$Properties:Date	Lde/greenrobot/dao/Property;
    //   719: aastore
    //   720: invokevirtual 396	de/greenrobot/dao/query/QueryBuilder:orderDesc	([Lde/greenrobot/dao/Property;)Lde/greenrobot/dao/query/QueryBuilder;
    //   723: pop
    //   724: aload_3
    //   725: invokevirtual 400	de/greenrobot/dao/query/QueryBuilder:list	()Ljava/util/List;
    //   728: astore_3
    //   729: aload 5
    //   731: iconst_0
    //   732: invokevirtual 443	java/lang/StringBuffer:setLength	(I)V
    //   735: aload_3
    //   736: invokeinterface 405 1 0
    //   741: ifne +15 -> 756
    //   744: iconst_0
    //   745: istore_1
    //   746: iload_1
    //   747: aload_3
    //   748: invokeinterface 409 1 0
    //   753: if_icmplt +900 -> 1653
    //   756: new 108	java/io/File
    //   759: dup
    //   760: new 100	java/lang/StringBuilder
    //   763: dup
    //   764: aload 6
    //   766: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   769: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   772: ldc_w 493
    //   775: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   781: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   784: astore 4
    //   786: aload 4
    //   788: invokevirtual 414	java/io/File:delete	()Z
    //   791: pop
    //   792: aload_2
    //   793: astore_3
    //   794: new 416	java/io/FileWriter
    //   797: dup
    //   798: aload 4
    //   800: iconst_1
    //   801: invokespecial 419	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   804: astore 4
    //   806: aload 4
    //   808: aload 5
    //   810: invokevirtual 420	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   813: invokevirtual 423	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   816: pop
    //   817: aload 4
    //   819: invokevirtual 426	java/io/FileWriter:flush	()V
    //   822: aload 4
    //   824: ifnull +1027 -> 1851
    //   827: aload 4
    //   829: invokevirtual 429	java/io/FileWriter:close	()V
    //   832: return
    //   833: aload_2
    //   834: iload_1
    //   835: invokeinterface 497 2 0
    //   840: checkcast 499	com/project/library/database/SportDataDay
    //   843: astore_3
    //   844: aload 5
    //   846: ldc_w 501
    //   849: iconst_5
    //   850: anewarray 503	java/lang/Object
    //   853: dup
    //   854: iconst_0
    //   855: aload_3
    //   856: invokevirtual 507	com/project/library/database/SportDataDay:getDate	()Ljava/lang/Long;
    //   859: aastore
    //   860: dup
    //   861: iconst_1
    //   862: aload_3
    //   863: invokevirtual 510	com/project/library/database/SportDataDay:getTotalstepCount	()I
    //   866: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   869: aastore
    //   870: dup
    //   871: iconst_2
    //   872: aload_3
    //   873: invokevirtual 518	com/project/library/database/SportDataDay:getTotalCalory	()I
    //   876: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   879: aastore
    //   880: dup
    //   881: iconst_3
    //   882: aload_3
    //   883: invokevirtual 521	com/project/library/database/SportDataDay:getTotalDistance	()I
    //   886: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   889: aastore
    //   890: dup
    //   891: iconst_4
    //   892: aload_3
    //   893: invokevirtual 524	com/project/library/database/SportDataDay:getTotalActiveTime	()I
    //   896: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   899: aastore
    //   900: invokestatic 528	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   903: invokevirtual 531	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   906: pop
    //   907: iload_1
    //   908: iconst_1
    //   909: iadd
    //   910: istore_1
    //   911: goto -822 -> 89
    //   914: astore_2
    //   915: aload_3
    //   916: astore 4
    //   918: aload_2
    //   919: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   922: aload_3
    //   923: astore_2
    //   924: aload_3
    //   925: ifnull -733 -> 192
    //   928: aload_3
    //   929: invokevirtual 429	java/io/FileWriter:close	()V
    //   932: aload_3
    //   933: astore_2
    //   934: goto -742 -> 192
    //   937: astore_2
    //   938: aload_2
    //   939: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   942: aload_3
    //   943: astore_2
    //   944: goto -752 -> 192
    //   947: astore_2
    //   948: aload 4
    //   950: ifnull +8 -> 958
    //   953: aload 4
    //   955: invokevirtual 429	java/io/FileWriter:close	()V
    //   958: aload_2
    //   959: athrow
    //   960: astore_3
    //   961: aload_3
    //   962: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   965: goto -7 -> 958
    //   968: astore_3
    //   969: aload_3
    //   970: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   973: goto -781 -> 192
    //   976: aload_3
    //   977: iload_1
    //   978: invokeinterface 497 2 0
    //   983: checkcast 533	com/project/library/database/SportDataItem
    //   986: astore 4
    //   988: aload 5
    //   990: ldc_w 535
    //   993: bipush 8
    //   995: anewarray 503	java/lang/Object
    //   998: dup
    //   999: iconst_0
    //   1000: aload 4
    //   1002: invokevirtual 537	com/project/library/database/SportDataItem:getDate	()J
    //   1005: invokestatic 542	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1008: aastore
    //   1009: dup
    //   1010: iconst_1
    //   1011: aload 4
    //   1013: invokevirtual 545	com/project/library/database/SportDataItem:getHour	()I
    //   1016: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1019: aastore
    //   1020: dup
    //   1021: iconst_2
    //   1022: aload 4
    //   1024: invokevirtual 548	com/project/library/database/SportDataItem:getMinute	()I
    //   1027: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1030: aastore
    //   1031: dup
    //   1032: iconst_3
    //   1033: aload 4
    //   1035: invokevirtual 551	com/project/library/database/SportDataItem:getMode	()I
    //   1038: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1041: aastore
    //   1042: dup
    //   1043: iconst_4
    //   1044: aload 4
    //   1046: invokevirtual 554	com/project/library/database/SportDataItem:getStepCount	()I
    //   1049: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1052: aastore
    //   1053: dup
    //   1054: iconst_5
    //   1055: aload 4
    //   1057: invokevirtual 557	com/project/library/database/SportDataItem:getActiveTime	()I
    //   1060: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1063: aastore
    //   1064: dup
    //   1065: bipush 6
    //   1067: aload 4
    //   1069: invokevirtual 560	com/project/library/database/SportDataItem:getCalory	()I
    //   1072: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1075: aastore
    //   1076: dup
    //   1077: bipush 7
    //   1079: aload 4
    //   1081: invokevirtual 563	com/project/library/database/SportDataItem:getDistance	()I
    //   1084: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1087: aastore
    //   1088: invokestatic 528	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1091: invokevirtual 531	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1094: pop
    //   1095: iload_1
    //   1096: iconst_1
    //   1097: iadd
    //   1098: istore_1
    //   1099: goto -861 -> 238
    //   1102: astore 4
    //   1104: aload_2
    //   1105: astore_3
    //   1106: aload 4
    //   1108: astore_2
    //   1109: aload_3
    //   1110: astore 4
    //   1112: aload_2
    //   1113: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1116: aload_3
    //   1117: astore_2
    //   1118: aload_3
    //   1119: ifnull -800 -> 319
    //   1122: aload_3
    //   1123: invokevirtual 429	java/io/FileWriter:close	()V
    //   1126: aload_3
    //   1127: astore_2
    //   1128: goto -809 -> 319
    //   1131: astore_2
    //   1132: aload_2
    //   1133: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1136: aload_3
    //   1137: astore_2
    //   1138: goto -819 -> 319
    //   1141: astore_2
    //   1142: aload 4
    //   1144: ifnull +8 -> 1152
    //   1147: aload 4
    //   1149: invokevirtual 429	java/io/FileWriter:close	()V
    //   1152: aload_2
    //   1153: athrow
    //   1154: astore_3
    //   1155: aload_3
    //   1156: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1159: goto -7 -> 1152
    //   1162: astore_2
    //   1163: aload_2
    //   1164: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1167: aload_3
    //   1168: astore_2
    //   1169: goto -850 -> 319
    //   1172: aload_3
    //   1173: iload_1
    //   1174: invokeinterface 497 2 0
    //   1179: checkcast 565	com/project/library/database/SleepDataDay
    //   1182: astore 4
    //   1184: aload 5
    //   1186: ldc_w 567
    //   1189: bipush 9
    //   1191: anewarray 503	java/lang/Object
    //   1194: dup
    //   1195: iconst_0
    //   1196: aload 4
    //   1198: invokevirtual 568	com/project/library/database/SleepDataDay:getDate	()Ljava/lang/Long;
    //   1201: aastore
    //   1202: dup
    //   1203: iconst_1
    //   1204: aload 4
    //   1206: invokevirtual 571	com/project/library/database/SleepDataDay:getEndTimeHour	()I
    //   1209: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1212: aastore
    //   1213: dup
    //   1214: iconst_2
    //   1215: aload 4
    //   1217: invokevirtual 574	com/project/library/database/SleepDataDay:getEndTimeMinute	()I
    //   1220: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1223: aastore
    //   1224: dup
    //   1225: iconst_3
    //   1226: aload 4
    //   1228: invokevirtual 577	com/project/library/database/SleepDataDay:getTotalSleepMinutes	()I
    //   1231: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1234: aastore
    //   1235: dup
    //   1236: iconst_4
    //   1237: aload 4
    //   1239: invokevirtual 580	com/project/library/database/SleepDataDay:getLightSleepCount	()I
    //   1242: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1245: aastore
    //   1246: dup
    //   1247: iconst_5
    //   1248: aload 4
    //   1250: invokevirtual 583	com/project/library/database/SleepDataDay:getDeepSleepCount	()I
    //   1253: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1256: aastore
    //   1257: dup
    //   1258: bipush 6
    //   1260: aload 4
    //   1262: invokevirtual 586	com/project/library/database/SleepDataDay:getAwakeCount	()I
    //   1265: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1268: aastore
    //   1269: dup
    //   1270: bipush 7
    //   1272: aload 4
    //   1274: invokevirtual 589	com/project/library/database/SleepDataDay:getLightSleepMinutes	()I
    //   1277: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1280: aastore
    //   1281: dup
    //   1282: bipush 8
    //   1284: aload 4
    //   1286: invokevirtual 592	com/project/library/database/SleepDataDay:getDeepSleepMinutes	()I
    //   1289: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1292: aastore
    //   1293: invokestatic 528	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1296: invokevirtual 531	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1299: pop
    //   1300: iload_1
    //   1301: iconst_1
    //   1302: iadd
    //   1303: istore_1
    //   1304: goto -939 -> 365
    //   1307: astore 4
    //   1309: aload_2
    //   1310: astore_3
    //   1311: aload 4
    //   1313: astore_2
    //   1314: aload_3
    //   1315: astore 4
    //   1317: aload_2
    //   1318: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1321: aload_3
    //   1322: astore_2
    //   1323: aload_3
    //   1324: ifnull -878 -> 446
    //   1327: aload_3
    //   1328: invokevirtual 429	java/io/FileWriter:close	()V
    //   1331: aload_3
    //   1332: astore_2
    //   1333: goto -887 -> 446
    //   1336: astore_2
    //   1337: aload_2
    //   1338: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1341: aload_3
    //   1342: astore_2
    //   1343: goto -897 -> 446
    //   1346: astore_2
    //   1347: aload 4
    //   1349: ifnull +8 -> 1357
    //   1352: aload 4
    //   1354: invokevirtual 429	java/io/FileWriter:close	()V
    //   1357: aload_2
    //   1358: athrow
    //   1359: astore_3
    //   1360: aload_3
    //   1361: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1364: goto -7 -> 1357
    //   1367: astore_2
    //   1368: aload_2
    //   1369: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1372: aload_3
    //   1373: astore_2
    //   1374: goto -928 -> 446
    //   1377: aload_3
    //   1378: iload_1
    //   1379: invokeinterface 497 2 0
    //   1384: checkcast 594	com/project/library/database/SleepDataItem
    //   1387: astore 4
    //   1389: aload 5
    //   1391: ldc_w 596
    //   1394: iconst_3
    //   1395: anewarray 503	java/lang/Object
    //   1398: dup
    //   1399: iconst_0
    //   1400: aload 4
    //   1402: invokevirtual 597	com/project/library/database/SleepDataItem:getDate	()J
    //   1405: invokestatic 542	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1408: aastore
    //   1409: dup
    //   1410: iconst_1
    //   1411: aload 4
    //   1413: invokevirtual 600	com/project/library/database/SleepDataItem:getSleepStatus	()I
    //   1416: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1419: aastore
    //   1420: dup
    //   1421: iconst_2
    //   1422: aload 4
    //   1424: invokevirtual 603	com/project/library/database/SleepDataItem:getSleepMinutes	()I
    //   1427: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1430: aastore
    //   1431: invokestatic 528	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1434: invokevirtual 531	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1437: pop
    //   1438: iload_1
    //   1439: iconst_1
    //   1440: iadd
    //   1441: istore_1
    //   1442: goto -950 -> 492
    //   1445: astore 4
    //   1447: aload_2
    //   1448: astore_3
    //   1449: aload 4
    //   1451: astore_2
    //   1452: aload_3
    //   1453: astore 4
    //   1455: aload_2
    //   1456: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1459: aload_3
    //   1460: astore_2
    //   1461: aload_3
    //   1462: ifnull -889 -> 573
    //   1465: aload_3
    //   1466: invokevirtual 429	java/io/FileWriter:close	()V
    //   1469: aload_3
    //   1470: astore_2
    //   1471: goto -898 -> 573
    //   1474: astore_2
    //   1475: aload_2
    //   1476: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1479: aload_3
    //   1480: astore_2
    //   1481: goto -908 -> 573
    //   1484: astore_2
    //   1485: aload 4
    //   1487: ifnull +8 -> 1495
    //   1490: aload 4
    //   1492: invokevirtual 429	java/io/FileWriter:close	()V
    //   1495: aload_2
    //   1496: athrow
    //   1497: astore_3
    //   1498: aload_3
    //   1499: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1502: goto -7 -> 1495
    //   1505: astore_2
    //   1506: aload_2
    //   1507: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1510: aload_3
    //   1511: astore_2
    //   1512: goto -939 -> 573
    //   1515: aload_3
    //   1516: iload_1
    //   1517: invokeinterface 497 2 0
    //   1522: checkcast 605	com/project/library/database/HeartRate
    //   1525: astore 4
    //   1527: aload 5
    //   1529: ldc_w 596
    //   1532: iconst_3
    //   1533: anewarray 503	java/lang/Object
    //   1536: dup
    //   1537: iconst_0
    //   1538: aload 4
    //   1540: invokevirtual 606	com/project/library/database/HeartRate:getDate	()J
    //   1543: invokestatic 542	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1546: aastore
    //   1547: dup
    //   1548: iconst_1
    //   1549: aload 4
    //   1551: invokevirtual 607	com/project/library/database/HeartRate:getMinute	()I
    //   1554: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1557: aastore
    //   1558: dup
    //   1559: iconst_2
    //   1560: aload 4
    //   1562: invokevirtual 610	com/project/library/database/HeartRate:getRate	()I
    //   1565: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1568: aastore
    //   1569: invokestatic 528	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1572: invokevirtual 531	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1575: pop
    //   1576: iload_1
    //   1577: iconst_1
    //   1578: iadd
    //   1579: istore_1
    //   1580: goto -961 -> 619
    //   1583: astore 4
    //   1585: aload_2
    //   1586: astore_3
    //   1587: aload 4
    //   1589: astore_2
    //   1590: aload_3
    //   1591: astore 4
    //   1593: aload_2
    //   1594: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1597: aload_3
    //   1598: astore_2
    //   1599: aload_3
    //   1600: ifnull -900 -> 700
    //   1603: aload_3
    //   1604: invokevirtual 429	java/io/FileWriter:close	()V
    //   1607: aload_3
    //   1608: astore_2
    //   1609: goto -909 -> 700
    //   1612: astore_2
    //   1613: aload_2
    //   1614: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1617: aload_3
    //   1618: astore_2
    //   1619: goto -919 -> 700
    //   1622: astore_2
    //   1623: aload 4
    //   1625: ifnull +8 -> 1633
    //   1628: aload 4
    //   1630: invokevirtual 429	java/io/FileWriter:close	()V
    //   1633: aload_2
    //   1634: athrow
    //   1635: astore_3
    //   1636: aload_3
    //   1637: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1640: goto -7 -> 1633
    //   1643: astore_2
    //   1644: aload_2
    //   1645: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1648: aload_3
    //   1649: astore_2
    //   1650: goto -950 -> 700
    //   1653: aload_3
    //   1654: iload_1
    //   1655: invokeinterface 497 2 0
    //   1660: checkcast 612	com/project/library/database/HeartRateTreshold
    //   1663: astore 4
    //   1665: aload 5
    //   1667: ldc_w 614
    //   1670: bipush 10
    //   1672: anewarray 503	java/lang/Object
    //   1675: dup
    //   1676: iconst_0
    //   1677: aload 4
    //   1679: invokevirtual 615	com/project/library/database/HeartRateTreshold:getDate	()J
    //   1682: invokestatic 542	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1685: aastore
    //   1686: dup
    //   1687: iconst_1
    //   1688: aload 4
    //   1690: invokevirtual 618	com/project/library/database/HeartRateTreshold:getMinThreshold	()I
    //   1693: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1696: aastore
    //   1697: dup
    //   1698: iconst_2
    //   1699: aload 4
    //   1701: invokevirtual 621	com/project/library/database/HeartRateTreshold:getBurnFatThreshold	()I
    //   1704: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1707: aastore
    //   1708: dup
    //   1709: iconst_3
    //   1710: aload 4
    //   1712: invokevirtual 624	com/project/library/database/HeartRateTreshold:getAerobicThreshold	()I
    //   1715: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1718: aastore
    //   1719: dup
    //   1720: iconst_4
    //   1721: aload 4
    //   1723: invokevirtual 627	com/project/library/database/HeartRateTreshold:getLimitThreshold	()I
    //   1726: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1729: aastore
    //   1730: dup
    //   1731: iconst_5
    //   1732: aload 4
    //   1734: invokevirtual 630	com/project/library/database/HeartRateTreshold:getMaxThreshold	()I
    //   1737: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1740: aastore
    //   1741: dup
    //   1742: bipush 6
    //   1744: aload 4
    //   1746: invokevirtual 633	com/project/library/database/HeartRateTreshold:getSilentHeartRate	()I
    //   1749: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1752: aastore
    //   1753: dup
    //   1754: bipush 7
    //   1756: aload 4
    //   1758: invokevirtual 636	com/project/library/database/HeartRateTreshold:getBurnFatMins	()I
    //   1761: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1764: aastore
    //   1765: dup
    //   1766: bipush 8
    //   1768: aload 4
    //   1770: invokevirtual 639	com/project/library/database/HeartRateTreshold:getAerobicMins	()I
    //   1773: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1776: aastore
    //   1777: dup
    //   1778: bipush 9
    //   1780: aload 4
    //   1782: invokevirtual 642	com/project/library/database/HeartRateTreshold:getLimitMins	()I
    //   1785: invokestatic 515	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1788: aastore
    //   1789: invokestatic 528	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1792: invokevirtual 531	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1795: pop
    //   1796: iload_1
    //   1797: iconst_1
    //   1798: iadd
    //   1799: istore_1
    //   1800: goto -1054 -> 746
    //   1803: astore 4
    //   1805: aload_2
    //   1806: astore_3
    //   1807: aload 4
    //   1809: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1812: aload_2
    //   1813: ifnull -981 -> 832
    //   1816: aload_2
    //   1817: invokevirtual 429	java/io/FileWriter:close	()V
    //   1820: return
    //   1821: astore_2
    //   1822: aload_2
    //   1823: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1826: return
    //   1827: astore_2
    //   1828: aload_3
    //   1829: ifnull +7 -> 1836
    //   1832: aload_3
    //   1833: invokevirtual 429	java/io/FileWriter:close	()V
    //   1836: aload_2
    //   1837: athrow
    //   1838: astore_3
    //   1839: aload_3
    //   1840: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1843: goto -7 -> 1836
    //   1846: astore_2
    //   1847: aload_2
    //   1848: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   1851: return
    //   1852: astore_2
    //   1853: aload 4
    //   1855: astore_3
    //   1856: goto -28 -> 1828
    //   1859: astore_3
    //   1860: aload 4
    //   1862: astore_2
    //   1863: aload_3
    //   1864: astore 4
    //   1866: goto -61 -> 1805
    //   1869: astore_2
    //   1870: aload_3
    //   1871: astore 4
    //   1873: goto -250 -> 1623
    //   1876: astore_2
    //   1877: goto -287 -> 1590
    //   1880: astore_2
    //   1881: aload_3
    //   1882: astore 4
    //   1884: goto -399 -> 1485
    //   1887: astore_2
    //   1888: goto -436 -> 1452
    //   1891: astore_2
    //   1892: aload_3
    //   1893: astore 4
    //   1895: goto -548 -> 1347
    //   1898: astore_2
    //   1899: goto -585 -> 1314
    //   1902: astore_2
    //   1903: aload_3
    //   1904: astore 4
    //   1906: goto -764 -> 1142
    //   1909: astore_2
    //   1910: goto -801 -> 1109
    //   1913: astore_3
    //   1914: aload_2
    //   1915: astore 4
    //   1917: aload_3
    //   1918: astore_2
    //   1919: goto -971 -> 948
    //   1922: astore 4
    //   1924: aload_2
    //   1925: astore_3
    //   1926: aload 4
    //   1928: astore_2
    //   1929: goto -1014 -> 915
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1932	0	this	SysSettingsActivity
    //   88	1712	1	i	int
    //   57	777	2	localObject1	Object
    //   914	5	2	localIOException1	IOException
    //   923	11	2	localObject2	Object
    //   937	2	2	localIOException2	IOException
    //   943	1	2	localObject3	Object
    //   947	158	2	localObject4	Object
    //   1108	20	2	localObject5	Object
    //   1131	2	2	localIOException3	IOException
    //   1137	1	2	localObject6	Object
    //   1141	12	2	localObject7	Object
    //   1162	2	2	localIOException4	IOException
    //   1168	165	2	localObject8	Object
    //   1336	2	2	localIOException5	IOException
    //   1342	1	2	localObject9	Object
    //   1346	12	2	localObject10	Object
    //   1367	2	2	localIOException6	IOException
    //   1373	98	2	localObject11	Object
    //   1474	2	2	localIOException7	IOException
    //   1480	1	2	localObject12	Object
    //   1484	12	2	localObject13	Object
    //   1505	2	2	localIOException8	IOException
    //   1511	98	2	localObject14	Object
    //   1612	2	2	localIOException9	IOException
    //   1618	1	2	localObject15	Object
    //   1622	12	2	localObject16	Object
    //   1643	2	2	localIOException10	IOException
    //   1649	168	2	localObject17	Object
    //   1821	2	2	localIOException11	IOException
    //   1827	10	2	localObject18	Object
    //   1846	2	2	localIOException12	IOException
    //   1852	1	2	localObject19	Object
    //   1862	1	2	localObject20	Object
    //   1869	1	2	localObject21	Object
    //   1876	1	2	localIOException13	IOException
    //   1880	1	2	localObject22	Object
    //   1887	1	2	localIOException14	IOException
    //   1891	1	2	localObject23	Object
    //   1898	1	2	localIOException15	IOException
    //   1902	1	2	localObject24	Object
    //   1909	6	2	localIOException16	IOException
    //   1918	11	2	localObject25	Object
    //   159	784	3	localObject26	Object
    //   960	2	3	localIOException17	IOException
    //   968	9	3	localIOException18	IOException
    //   1105	32	3	localObject27	Object
    //   1154	19	3	localIOException19	IOException
    //   1310	32	3	localObject28	Object
    //   1359	19	3	localIOException20	IOException
    //   1448	32	3	localObject29	Object
    //   1497	19	3	localIOException21	IOException
    //   1586	32	3	localObject30	Object
    //   1635	19	3	localIOException22	IOException
    //   1806	27	3	localObject31	Object
    //   1838	2	3	localIOException23	IOException
    //   1855	1	3	localIOException24	IOException
    //   1859	45	3	localIOException25	IOException
    //   1913	5	3	localObject32	Object
    //   1925	1	3	localObject33	Object
    //   156	924	4	localObject34	Object
    //   1102	5	4	localIOException26	IOException
    //   1110	175	4	localObject35	Object
    //   1307	5	4	localIOException27	IOException
    //   1315	108	4	localObject36	Object
    //   1445	5	4	localIOException28	IOException
    //   1453	108	4	localObject37	Object
    //   1583	5	4	localIOException29	IOException
    //   1591	190	4	localObject38	Object
    //   1803	58	4	localIOException30	IOException
    //   1864	52	4	localObject39	Object
    //   1922	5	4	localIOException31	IOException
    //   39	1627	5	localStringBuffer	StringBuffer
    //   30	735	6	str	String
    //   47	654	7	localDaoSession	com.project.library.database.DaoSession
    // Exception table:
    //   from	to	target	type
    //   160	170	914	java/io/IOException
    //   928	932	937	java/io/IOException
    //   160	170	947	finally
    //   918	922	947	finally
    //   953	958	960	java/io/IOException
    //   188	192	968	java/io/IOException
    //   285	295	1102	java/io/IOException
    //   1122	1126	1131	java/io/IOException
    //   285	295	1141	finally
    //   1112	1116	1141	finally
    //   1147	1152	1154	java/io/IOException
    //   313	317	1162	java/io/IOException
    //   412	422	1307	java/io/IOException
    //   1327	1331	1336	java/io/IOException
    //   412	422	1346	finally
    //   1317	1321	1346	finally
    //   1352	1357	1359	java/io/IOException
    //   440	444	1367	java/io/IOException
    //   539	549	1445	java/io/IOException
    //   1465	1469	1474	java/io/IOException
    //   539	549	1484	finally
    //   1455	1459	1484	finally
    //   1490	1495	1497	java/io/IOException
    //   567	571	1505	java/io/IOException
    //   666	676	1583	java/io/IOException
    //   1603	1607	1612	java/io/IOException
    //   666	676	1622	finally
    //   1593	1597	1622	finally
    //   1628	1633	1635	java/io/IOException
    //   694	698	1643	java/io/IOException
    //   794	806	1803	java/io/IOException
    //   1816	1820	1821	java/io/IOException
    //   794	806	1827	finally
    //   1807	1812	1827	finally
    //   1832	1836	1838	java/io/IOException
    //   827	832	1846	java/io/IOException
    //   806	822	1852	finally
    //   806	822	1859	java/io/IOException
    //   676	690	1869	finally
    //   676	690	1876	java/io/IOException
    //   549	563	1880	finally
    //   549	563	1887	java/io/IOException
    //   422	436	1891	finally
    //   422	436	1898	java/io/IOException
    //   295	309	1902	finally
    //   295	309	1909	java/io/IOException
    //   170	184	1913	finally
    //   170	184	1922	java/io/IOException
  }
  
  private void hideProgress()
  {
    if (this.mProgress != null)
    {
      this.mProgress.dismiss();
      this.mProgress = null;
    }
  }
  
  /* Error */
  private void importFile2Db()
  {
    // Byte code:
    //   0: new 100	java/lang/StringBuilder
    //   3: dup
    //   4: invokestatic 106	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   7: invokevirtual 112	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   10: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: ldc 124
    //   18: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc_w 358
    //   24: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: astore_1
    //   31: new 360	java/lang/StringBuffer
    //   34: dup
    //   35: invokespecial 361	java/lang/StringBuffer:<init>	()V
    //   38: pop
    //   39: invokestatic 366	com/project/library/util/DBTool:getInstance	()Lcom/project/library/util/DBTool;
    //   42: invokevirtual 370	com/project/library/util/DBTool:getDaoSession	()Lcom/project/library/database/DaoSession;
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 376	com/project/library/database/DaoSession:getSportDataDayDao	()Lcom/project/library/database/SportDataDayDao;
    //   50: astore_3
    //   51: new 108	java/io/File
    //   54: dup
    //   55: aload_1
    //   56: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: invokevirtual 320	java/io/File:exists	()Z
    //   62: ifne +32 -> 94
    //   65: aload_0
    //   66: new 100	java/lang/StringBuilder
    //   69: dup
    //   70: aload_1
    //   71: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   74: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: ldc_w 647
    //   80: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: iconst_0
    //   87: invokestatic 653	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   90: invokevirtual 656	android/widget/Toast:show	()V
    //   93: return
    //   94: new 108	java/io/File
    //   97: dup
    //   98: new 100	java/lang/StringBuilder
    //   101: dup
    //   102: aload_1
    //   103: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   106: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   109: ldc_w 411
    //   112: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: astore 4
    //   123: aload 4
    //   125: invokevirtual 320	java/io/File:exists	()Z
    //   128: ifeq +58 -> 186
    //   131: new 331	java/io/FileInputStream
    //   134: dup
    //   135: aload 4
    //   137: invokespecial 332	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   140: astore 4
    //   142: aload 4
    //   144: ifnull +42 -> 186
    //   147: new 658	java/io/BufferedReader
    //   150: dup
    //   151: new 660	java/io/InputStreamReader
    //   154: dup
    //   155: aload 4
    //   157: invokespecial 663	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   160: invokespecial 666	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   163: astore 5
    //   165: aload_3
    //   166: invokevirtual 669	com/project/library/database/SportDataDayDao:deleteAll	()V
    //   169: aload 5
    //   171: invokevirtual 672	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   174: astore 6
    //   176: aload 6
    //   178: ifnonnull +497 -> 675
    //   181: aload 4
    //   183: invokevirtual 675	java/io/InputStream:close	()V
    //   186: aload_2
    //   187: invokevirtual 433	com/project/library/database/DaoSession:getSportDataItemDao	()Lcom/project/library/database/SportDataItemDao;
    //   190: astore_3
    //   191: new 108	java/io/File
    //   194: dup
    //   195: new 100	java/lang/StringBuilder
    //   198: dup
    //   199: aload_1
    //   200: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   203: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   206: ldc_w 445
    //   209: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   218: astore 4
    //   220: aload 4
    //   222: invokevirtual 320	java/io/File:exists	()Z
    //   225: ifeq +58 -> 283
    //   228: new 331	java/io/FileInputStream
    //   231: dup
    //   232: aload 4
    //   234: invokespecial 332	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   237: astore 4
    //   239: aload 4
    //   241: ifnull +42 -> 283
    //   244: new 658	java/io/BufferedReader
    //   247: dup
    //   248: new 660	java/io/InputStreamReader
    //   251: dup
    //   252: aload 4
    //   254: invokespecial 663	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   257: invokespecial 666	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   260: astore 5
    //   262: aload_3
    //   263: invokevirtual 676	com/project/library/database/SportDataItemDao:deleteAll	()V
    //   266: aload 5
    //   268: invokevirtual 672	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   271: astore 6
    //   273: aload 6
    //   275: ifnonnull +559 -> 834
    //   278: aload 4
    //   280: invokevirtual 675	java/io/InputStream:close	()V
    //   283: aload_2
    //   284: invokevirtual 449	com/project/library/database/DaoSession:getSleepDataDayDao	()Lcom/project/library/database/SleepDataDayDao;
    //   287: astore_3
    //   288: new 108	java/io/File
    //   291: dup
    //   292: new 100	java/lang/StringBuilder
    //   295: dup
    //   296: aload_1
    //   297: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   300: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   303: ldc_w 457
    //   306: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   315: astore 4
    //   317: aload 4
    //   319: invokevirtual 320	java/io/File:exists	()Z
    //   322: ifeq +58 -> 380
    //   325: new 331	java/io/FileInputStream
    //   328: dup
    //   329: aload 4
    //   331: invokespecial 332	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   334: astore 4
    //   336: aload 4
    //   338: ifnull +42 -> 380
    //   341: new 658	java/io/BufferedReader
    //   344: dup
    //   345: new 660	java/io/InputStreamReader
    //   348: dup
    //   349: aload 4
    //   351: invokespecial 663	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   354: invokespecial 666	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   357: astore 5
    //   359: aload_3
    //   360: invokevirtual 677	com/project/library/database/SleepDataDayDao:deleteAll	()V
    //   363: aload 5
    //   365: invokevirtual 672	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   368: astore 6
    //   370: aload 6
    //   372: ifnonnull +696 -> 1068
    //   375: aload 4
    //   377: invokevirtual 675	java/io/InputStream:close	()V
    //   380: aload_2
    //   381: invokevirtual 461	com/project/library/database/DaoSession:getSleepDataItemDao	()Lcom/project/library/database/SleepDataItemDao;
    //   384: astore_3
    //   385: new 108	java/io/File
    //   388: dup
    //   389: new 100	java/lang/StringBuilder
    //   392: dup
    //   393: aload_1
    //   394: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   397: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   400: ldc_w 469
    //   403: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   412: astore 4
    //   414: aload 4
    //   416: invokevirtual 320	java/io/File:exists	()Z
    //   419: ifeq +58 -> 477
    //   422: new 331	java/io/FileInputStream
    //   425: dup
    //   426: aload 4
    //   428: invokespecial 332	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   431: astore 4
    //   433: aload 4
    //   435: ifnull +42 -> 477
    //   438: new 658	java/io/BufferedReader
    //   441: dup
    //   442: new 660	java/io/InputStreamReader
    //   445: dup
    //   446: aload 4
    //   448: invokespecial 663	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   451: invokespecial 666	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   454: astore 5
    //   456: aload_3
    //   457: invokevirtual 678	com/project/library/database/SleepDataItemDao:deleteAll	()V
    //   460: aload 5
    //   462: invokevirtual 672	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   465: astore 6
    //   467: aload 6
    //   469: ifnonnull +855 -> 1324
    //   472: aload 4
    //   474: invokevirtual 675	java/io/InputStream:close	()V
    //   477: aload_2
    //   478: invokevirtual 473	com/project/library/database/DaoSession:getHeartRateDao	()Lcom/project/library/database/HeartRateDao;
    //   481: astore_3
    //   482: new 108	java/io/File
    //   485: dup
    //   486: new 100	java/lang/StringBuilder
    //   489: dup
    //   490: aload_1
    //   491: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   494: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   497: ldc_w 481
    //   500: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   509: astore 4
    //   511: aload 4
    //   513: invokevirtual 320	java/io/File:exists	()Z
    //   516: ifeq +58 -> 574
    //   519: new 331	java/io/FileInputStream
    //   522: dup
    //   523: aload 4
    //   525: invokespecial 332	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   528: astore 4
    //   530: aload 4
    //   532: ifnull +42 -> 574
    //   535: new 658	java/io/BufferedReader
    //   538: dup
    //   539: new 660	java/io/InputStreamReader
    //   542: dup
    //   543: aload 4
    //   545: invokespecial 663	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   548: invokespecial 666	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   551: astore 5
    //   553: aload_3
    //   554: invokevirtual 679	com/project/library/database/HeartRateDao:deleteAll	()V
    //   557: aload 5
    //   559: invokevirtual 672	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   562: astore 6
    //   564: aload 6
    //   566: ifnonnull +874 -> 1440
    //   569: aload 4
    //   571: invokevirtual 675	java/io/InputStream:close	()V
    //   574: aload_2
    //   575: invokevirtual 485	com/project/library/database/DaoSession:getHeartRateTresholdDao	()Lcom/project/library/database/HeartRateTresholdDao;
    //   578: astore_2
    //   579: new 108	java/io/File
    //   582: dup
    //   583: new 100	java/lang/StringBuilder
    //   586: dup
    //   587: aload_1
    //   588: invokestatic 118	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   591: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   594: ldc_w 493
    //   597: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: invokespecial 316	java/io/File:<init>	(Ljava/lang/String;)V
    //   606: astore_1
    //   607: aload_1
    //   608: invokevirtual 320	java/io/File:exists	()Z
    //   611: ifeq -518 -> 93
    //   614: new 331	java/io/FileInputStream
    //   617: dup
    //   618: aload_1
    //   619: invokespecial 332	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   622: astore_1
    //   623: aload_1
    //   624: ifnull -531 -> 93
    //   627: new 658	java/io/BufferedReader
    //   630: dup
    //   631: new 660	java/io/InputStreamReader
    //   634: dup
    //   635: aload_1
    //   636: invokespecial 663	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   639: invokespecial 666	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   642: astore_3
    //   643: aload_2
    //   644: invokevirtual 680	com/project/library/database/HeartRateTresholdDao:deleteAll	()V
    //   647: aload_3
    //   648: invokevirtual 672	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   651: astore 4
    //   653: aload 4
    //   655: ifnonnull +901 -> 1556
    //   658: aload_1
    //   659: invokevirtual 675	java/io/InputStream:close	()V
    //   662: return
    //   663: astore_1
    //   664: ldc_w 682
    //   667: ldc_w 684
    //   670: invokestatic 690	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   673: pop
    //   674: return
    //   675: new 499	com/project/library/database/SportDataDay
    //   678: dup
    //   679: invokespecial 691	com/project/library/database/SportDataDay:<init>	()V
    //   682: astore 7
    //   684: aload 7
    //   686: aload 6
    //   688: iconst_0
    //   689: bipush 20
    //   691: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   694: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   697: invokestatic 701	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   700: invokevirtual 705	com/project/library/database/SportDataDay:setDate	(Ljava/lang/Long;)V
    //   703: aload 7
    //   705: aload 6
    //   707: bipush 20
    //   709: bipush 40
    //   711: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   714: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   717: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   720: invokevirtual 711	java/lang/Integer:intValue	()I
    //   723: invokevirtual 714	com/project/library/database/SportDataDay:setTotalstepCount	(I)V
    //   726: aload 7
    //   728: aload 6
    //   730: bipush 40
    //   732: bipush 60
    //   734: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   737: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   740: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   743: invokevirtual 711	java/lang/Integer:intValue	()I
    //   746: invokevirtual 717	com/project/library/database/SportDataDay:setTotalCalory	(I)V
    //   749: aload 7
    //   751: aload 6
    //   753: bipush 60
    //   755: bipush 80
    //   757: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   760: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   763: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   766: invokevirtual 711	java/lang/Integer:intValue	()I
    //   769: invokevirtual 720	com/project/library/database/SportDataDay:setTotalDistance	(I)V
    //   772: aload 7
    //   774: aload 6
    //   776: bipush 80
    //   778: bipush 100
    //   780: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   783: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   786: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   789: invokevirtual 711	java/lang/Integer:intValue	()I
    //   792: invokevirtual 723	com/project/library/database/SportDataDay:setTotalActiveTime	(I)V
    //   795: aload_3
    //   796: aload 7
    //   798: invokevirtual 727	com/project/library/database/SportDataDayDao:insert	(Ljava/lang/Object;)J
    //   801: pop2
    //   802: goto -633 -> 169
    //   805: astore_3
    //   806: ldc_w 682
    //   809: ldc_w 684
    //   812: invokestatic 690	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   815: pop
    //   816: goto -630 -> 186
    //   819: astore_3
    //   820: ldc_w 682
    //   823: aload_3
    //   824: invokevirtual 730	java/io/IOException:getMessage	()Ljava/lang/String;
    //   827: invokestatic 690	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   830: pop
    //   831: goto -645 -> 186
    //   834: new 533	com/project/library/database/SportDataItem
    //   837: dup
    //   838: invokespecial 731	com/project/library/database/SportDataItem:<init>	()V
    //   841: astore 7
    //   843: aload 7
    //   845: aload 6
    //   847: iconst_0
    //   848: bipush 20
    //   850: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   853: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   856: invokestatic 701	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   859: invokevirtual 734	java/lang/Long:longValue	()J
    //   862: invokevirtual 737	com/project/library/database/SportDataItem:setDate	(J)V
    //   865: aload 7
    //   867: aload 6
    //   869: bipush 20
    //   871: bipush 40
    //   873: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   876: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   879: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   882: invokevirtual 711	java/lang/Integer:intValue	()I
    //   885: invokevirtual 740	com/project/library/database/SportDataItem:setHour	(I)V
    //   888: aload 7
    //   890: aload 6
    //   892: bipush 40
    //   894: bipush 60
    //   896: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   899: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   902: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   905: invokevirtual 711	java/lang/Integer:intValue	()I
    //   908: invokevirtual 743	com/project/library/database/SportDataItem:setMinute	(I)V
    //   911: aload 7
    //   913: aload 6
    //   915: bipush 60
    //   917: bipush 80
    //   919: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   922: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   925: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   928: invokevirtual 711	java/lang/Integer:intValue	()I
    //   931: invokevirtual 746	com/project/library/database/SportDataItem:setMode	(I)V
    //   934: aload 7
    //   936: aload 6
    //   938: bipush 80
    //   940: bipush 100
    //   942: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   945: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   948: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   951: invokevirtual 711	java/lang/Integer:intValue	()I
    //   954: invokevirtual 749	com/project/library/database/SportDataItem:setStepCount	(I)V
    //   957: aload 7
    //   959: aload 6
    //   961: bipush 100
    //   963: bipush 120
    //   965: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   968: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   971: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   974: invokevirtual 711	java/lang/Integer:intValue	()I
    //   977: invokevirtual 752	com/project/library/database/SportDataItem:setActiveTime	(I)V
    //   980: aload 7
    //   982: aload 6
    //   984: bipush 120
    //   986: sipush 140
    //   989: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   992: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   995: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   998: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1001: invokevirtual 755	com/project/library/database/SportDataItem:setCalory	(I)V
    //   1004: aload 7
    //   1006: aload 6
    //   1008: sipush 140
    //   1011: sipush 160
    //   1014: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1017: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1020: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1023: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1026: invokevirtual 758	com/project/library/database/SportDataItem:setDistance	(I)V
    //   1029: aload_3
    //   1030: aload 7
    //   1032: invokevirtual 759	com/project/library/database/SportDataItemDao:insert	(Ljava/lang/Object;)J
    //   1035: pop2
    //   1036: goto -770 -> 266
    //   1039: astore_3
    //   1040: ldc_w 682
    //   1043: ldc_w 684
    //   1046: invokestatic 690	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1049: pop
    //   1050: goto -767 -> 283
    //   1053: astore_3
    //   1054: ldc_w 682
    //   1057: aload_3
    //   1058: invokevirtual 730	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1061: invokestatic 690	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1064: pop
    //   1065: goto -782 -> 283
    //   1068: new 565	com/project/library/database/SleepDataDay
    //   1071: dup
    //   1072: invokespecial 760	com/project/library/database/SleepDataDay:<init>	()V
    //   1075: astore 7
    //   1077: aload 7
    //   1079: aload 6
    //   1081: iconst_0
    //   1082: bipush 20
    //   1084: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1087: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1090: invokestatic 701	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1093: invokevirtual 761	com/project/library/database/SleepDataDay:setDate	(Ljava/lang/Long;)V
    //   1096: aload 7
    //   1098: aload 6
    //   1100: bipush 20
    //   1102: bipush 40
    //   1104: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1107: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1110: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1113: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1116: invokevirtual 764	com/project/library/database/SleepDataDay:setEndTimeHour	(I)V
    //   1119: aload 7
    //   1121: aload 6
    //   1123: bipush 40
    //   1125: bipush 60
    //   1127: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1130: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1133: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1136: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1139: invokevirtual 767	com/project/library/database/SleepDataDay:setEndTimeMinute	(I)V
    //   1142: aload 7
    //   1144: aload 6
    //   1146: bipush 60
    //   1148: bipush 80
    //   1150: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1153: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1156: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1159: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1162: invokevirtual 770	com/project/library/database/SleepDataDay:setTotalSleepMinutes	(I)V
    //   1165: aload 7
    //   1167: aload 6
    //   1169: bipush 80
    //   1171: bipush 100
    //   1173: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1176: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1179: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1182: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1185: invokevirtual 773	com/project/library/database/SleepDataDay:setLightSleepCount	(I)V
    //   1188: aload 7
    //   1190: aload 6
    //   1192: bipush 100
    //   1194: bipush 120
    //   1196: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1199: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1202: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1205: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1208: invokevirtual 776	com/project/library/database/SleepDataDay:setDeepSleepCount	(I)V
    //   1211: aload 7
    //   1213: aload 6
    //   1215: bipush 120
    //   1217: sipush 140
    //   1220: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1223: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1226: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1229: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1232: invokevirtual 779	com/project/library/database/SleepDataDay:setAwakeCount	(I)V
    //   1235: aload 7
    //   1237: aload 6
    //   1239: sipush 140
    //   1242: sipush 160
    //   1245: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1248: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1251: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1254: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1257: invokevirtual 782	com/project/library/database/SleepDataDay:setLightSleepMinutes	(I)V
    //   1260: aload 7
    //   1262: aload 6
    //   1264: sipush 160
    //   1267: sipush 180
    //   1270: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1273: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1276: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1279: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1282: invokevirtual 785	com/project/library/database/SleepDataDay:setDeepSleepMinutes	(I)V
    //   1285: aload_3
    //   1286: aload 7
    //   1288: invokevirtual 786	com/project/library/database/SleepDataDayDao:insert	(Ljava/lang/Object;)J
    //   1291: pop2
    //   1292: goto -929 -> 363
    //   1295: astore_3
    //   1296: ldc_w 682
    //   1299: ldc_w 684
    //   1302: invokestatic 690	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1305: pop
    //   1306: goto -926 -> 380
    //   1309: astore_3
    //   1310: ldc_w 682
    //   1313: aload_3
    //   1314: invokevirtual 730	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1317: invokestatic 690	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1320: pop
    //   1321: goto -941 -> 380
    //   1324: new 594	com/project/library/database/SleepDataItem
    //   1327: dup
    //   1328: invokespecial 787	com/project/library/database/SleepDataItem:<init>	()V
    //   1331: astore 7
    //   1333: aload 7
    //   1335: aload 6
    //   1337: iconst_0
    //   1338: bipush 20
    //   1340: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1343: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1346: invokestatic 701	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1349: invokevirtual 734	java/lang/Long:longValue	()J
    //   1352: invokevirtual 788	com/project/library/database/SleepDataItem:setDate	(J)V
    //   1355: aload 7
    //   1357: aload 6
    //   1359: bipush 20
    //   1361: bipush 40
    //   1363: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1366: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1369: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1372: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1375: invokevirtual 791	com/project/library/database/SleepDataItem:setSleepStatus	(I)V
    //   1378: aload 7
    //   1380: aload 6
    //   1382: bipush 40
    //   1384: bipush 60
    //   1386: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1389: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1392: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1395: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1398: invokevirtual 794	com/project/library/database/SleepDataItem:setSleepMinutes	(I)V
    //   1401: aload_3
    //   1402: aload 7
    //   1404: invokevirtual 795	com/project/library/database/SleepDataItemDao:insert	(Ljava/lang/Object;)J
    //   1407: pop2
    //   1408: goto -948 -> 460
    //   1411: astore_3
    //   1412: ldc_w 682
    //   1415: ldc_w 684
    //   1418: invokestatic 690	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1421: pop
    //   1422: goto -945 -> 477
    //   1425: astore_3
    //   1426: ldc_w 682
    //   1429: aload_3
    //   1430: invokevirtual 730	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1433: invokestatic 690	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1436: pop
    //   1437: goto -960 -> 477
    //   1440: new 605	com/project/library/database/HeartRate
    //   1443: dup
    //   1444: invokespecial 796	com/project/library/database/HeartRate:<init>	()V
    //   1447: astore 7
    //   1449: aload 7
    //   1451: aload 6
    //   1453: iconst_0
    //   1454: bipush 20
    //   1456: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1459: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1462: invokestatic 701	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1465: invokevirtual 734	java/lang/Long:longValue	()J
    //   1468: invokevirtual 797	com/project/library/database/HeartRate:setDate	(J)V
    //   1471: aload 7
    //   1473: aload 6
    //   1475: bipush 20
    //   1477: bipush 40
    //   1479: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1482: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1485: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1488: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1491: invokevirtual 798	com/project/library/database/HeartRate:setMinute	(I)V
    //   1494: aload 7
    //   1496: aload 6
    //   1498: bipush 40
    //   1500: bipush 60
    //   1502: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1505: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1508: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1511: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1514: invokevirtual 801	com/project/library/database/HeartRate:setRate	(I)V
    //   1517: aload_3
    //   1518: aload 7
    //   1520: invokevirtual 802	com/project/library/database/HeartRateDao:insert	(Ljava/lang/Object;)J
    //   1523: pop2
    //   1524: goto -967 -> 557
    //   1527: astore_3
    //   1528: ldc_w 682
    //   1531: ldc_w 684
    //   1534: invokestatic 690	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1537: pop
    //   1538: goto -964 -> 574
    //   1541: astore_3
    //   1542: ldc_w 682
    //   1545: aload_3
    //   1546: invokevirtual 730	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1549: invokestatic 690	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1552: pop
    //   1553: goto -979 -> 574
    //   1556: new 612	com/project/library/database/HeartRateTreshold
    //   1559: dup
    //   1560: invokespecial 803	com/project/library/database/HeartRateTreshold:<init>	()V
    //   1563: astore 5
    //   1565: aload 5
    //   1567: aload 4
    //   1569: iconst_0
    //   1570: bipush 20
    //   1572: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1575: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1578: invokestatic 701	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   1581: invokevirtual 734	java/lang/Long:longValue	()J
    //   1584: invokevirtual 804	com/project/library/database/HeartRateTreshold:setDate	(J)V
    //   1587: aload 5
    //   1589: aload 4
    //   1591: bipush 20
    //   1593: bipush 40
    //   1595: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1598: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1601: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1604: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1607: invokevirtual 807	com/project/library/database/HeartRateTreshold:setMinThreshold	(I)V
    //   1610: aload 5
    //   1612: aload 4
    //   1614: bipush 40
    //   1616: bipush 60
    //   1618: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1621: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1624: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1627: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1630: invokevirtual 810	com/project/library/database/HeartRateTreshold:setBurnFatThreshold	(I)V
    //   1633: aload 5
    //   1635: aload 4
    //   1637: bipush 60
    //   1639: bipush 80
    //   1641: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1644: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1647: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1650: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1653: invokevirtual 813	com/project/library/database/HeartRateTreshold:setAerobicThreshold	(I)V
    //   1656: aload 5
    //   1658: aload 4
    //   1660: bipush 80
    //   1662: bipush 100
    //   1664: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1667: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1670: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1673: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1676: invokevirtual 816	com/project/library/database/HeartRateTreshold:setLimitThreshold	(I)V
    //   1679: aload 5
    //   1681: aload 4
    //   1683: bipush 100
    //   1685: bipush 120
    //   1687: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1690: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1693: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1696: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1699: invokevirtual 819	com/project/library/database/HeartRateTreshold:setMaxThreshold	(I)V
    //   1702: aload 5
    //   1704: aload 4
    //   1706: bipush 120
    //   1708: sipush 140
    //   1711: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1714: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1717: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1720: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1723: invokevirtual 822	com/project/library/database/HeartRateTreshold:setSilentHeartRate	(I)V
    //   1726: aload 5
    //   1728: aload 4
    //   1730: sipush 140
    //   1733: sipush 160
    //   1736: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1739: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1742: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1745: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1748: invokevirtual 825	com/project/library/database/HeartRateTreshold:setBurnFatMins	(I)V
    //   1751: aload 5
    //   1753: aload 4
    //   1755: sipush 160
    //   1758: sipush 180
    //   1761: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1764: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1767: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1770: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1773: invokevirtual 828	com/project/library/database/HeartRateTreshold:setAerobicMins	(I)V
    //   1776: aload 5
    //   1778: aload 4
    //   1780: sipush 180
    //   1783: sipush 200
    //   1786: invokevirtual 695	java/lang/String:substring	(II)Ljava/lang/String;
    //   1789: invokevirtual 698	java/lang/String:trim	()Ljava/lang/String;
    //   1792: invokestatic 708	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1795: invokevirtual 711	java/lang/Integer:intValue	()I
    //   1798: invokevirtual 831	com/project/library/database/HeartRateTreshold:setLimitMins	(I)V
    //   1801: aload_2
    //   1802: aload 5
    //   1804: invokevirtual 832	com/project/library/database/HeartRateTresholdDao:insert	(Ljava/lang/Object;)J
    //   1807: pop2
    //   1808: goto -1161 -> 647
    //   1811: astore_1
    //   1812: ldc_w 682
    //   1815: aload_1
    //   1816: invokevirtual 730	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1819: invokestatic 690	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1822: pop
    //   1823: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1824	0	this	SysSettingsActivity
    //   30	629	1	localObject1	Object
    //   663	1	1	localFileNotFoundException1	FileNotFoundException
    //   1811	5	1	localIOException1	IOException
    //   45	1757	2	localObject2	Object
    //   50	746	3	localObject3	Object
    //   805	1	3	localFileNotFoundException2	FileNotFoundException
    //   819	211	3	localIOException2	IOException
    //   1039	1	3	localFileNotFoundException3	FileNotFoundException
    //   1053	233	3	localIOException3	IOException
    //   1295	1	3	localFileNotFoundException4	FileNotFoundException
    //   1309	93	3	localIOException4	IOException
    //   1411	1	3	localFileNotFoundException5	FileNotFoundException
    //   1425	93	3	localIOException5	IOException
    //   1527	1	3	localFileNotFoundException6	FileNotFoundException
    //   1541	5	3	localIOException6	IOException
    //   121	1658	4	localObject4	Object
    //   163	1640	5	localObject5	Object
    //   174	1323	6	str	String
    //   682	837	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   614	623	663	java/io/FileNotFoundException
    //   627	647	663	java/io/FileNotFoundException
    //   647	653	663	java/io/FileNotFoundException
    //   658	662	663	java/io/FileNotFoundException
    //   1556	1808	663	java/io/FileNotFoundException
    //   131	142	805	java/io/FileNotFoundException
    //   147	169	805	java/io/FileNotFoundException
    //   169	176	805	java/io/FileNotFoundException
    //   181	186	805	java/io/FileNotFoundException
    //   675	802	805	java/io/FileNotFoundException
    //   131	142	819	java/io/IOException
    //   147	169	819	java/io/IOException
    //   169	176	819	java/io/IOException
    //   181	186	819	java/io/IOException
    //   675	802	819	java/io/IOException
    //   228	239	1039	java/io/FileNotFoundException
    //   244	266	1039	java/io/FileNotFoundException
    //   266	273	1039	java/io/FileNotFoundException
    //   278	283	1039	java/io/FileNotFoundException
    //   834	1036	1039	java/io/FileNotFoundException
    //   228	239	1053	java/io/IOException
    //   244	266	1053	java/io/IOException
    //   266	273	1053	java/io/IOException
    //   278	283	1053	java/io/IOException
    //   834	1036	1053	java/io/IOException
    //   325	336	1295	java/io/FileNotFoundException
    //   341	363	1295	java/io/FileNotFoundException
    //   363	370	1295	java/io/FileNotFoundException
    //   375	380	1295	java/io/FileNotFoundException
    //   1068	1292	1295	java/io/FileNotFoundException
    //   325	336	1309	java/io/IOException
    //   341	363	1309	java/io/IOException
    //   363	370	1309	java/io/IOException
    //   375	380	1309	java/io/IOException
    //   1068	1292	1309	java/io/IOException
    //   422	433	1411	java/io/FileNotFoundException
    //   438	460	1411	java/io/FileNotFoundException
    //   460	467	1411	java/io/FileNotFoundException
    //   472	477	1411	java/io/FileNotFoundException
    //   1324	1408	1411	java/io/FileNotFoundException
    //   422	433	1425	java/io/IOException
    //   438	460	1425	java/io/IOException
    //   460	467	1425	java/io/IOException
    //   472	477	1425	java/io/IOException
    //   1324	1408	1425	java/io/IOException
    //   519	530	1527	java/io/FileNotFoundException
    //   535	557	1527	java/io/FileNotFoundException
    //   557	564	1527	java/io/FileNotFoundException
    //   569	574	1527	java/io/FileNotFoundException
    //   1440	1524	1527	java/io/FileNotFoundException
    //   519	530	1541	java/io/IOException
    //   535	557	1541	java/io/IOException
    //   557	564	1541	java/io/IOException
    //   569	574	1541	java/io/IOException
    //   1440	1524	1541	java/io/IOException
    //   614	623	1811	java/io/IOException
    //   627	647	1811	java/io/IOException
    //   647	653	1811	java/io/IOException
    //   658	662	1811	java/io/IOException
    //   1556	1808	1811	java/io/IOException
  }
  
  private void initTimeMode()
  {
    String str = Settings.System.getString(getContentResolver(), "time_12_24");
    if ("24".equals(str)) {
      AppSharedPreferences.getInstance().setTimeMode(true);
    }
    while (!"12".equals(str)) {
      return;
    }
    AppSharedPreferences.getInstance().setTimeMode(false);
  }
  
  private void onReciveSettingAlarm()
  {
    if (this.mAlarmList.size() > 0) {
      this.mAlarmList.poll();
    }
    AlarmNotify localAlarmNotify = (AlarmNotify)this.mAlarmList.peek();
    if (localAlarmNotify == null)
    {
      DebugLog.d(">>闹钟发送完毕,发送防丢");
      sendLost();
    }
    while (localAlarmNotify == null) {
      return;
    }
    this.mCore.write(SettingsCmd.getInstance().getAlarmClockSettingsCmd(localAlarmNotify));
  }
  
  private void openTest()
  {
    if (System.currentTimeMillis() - this.clickTime < 1000L)
    {
      this.clickCount += 1L;
      this.clickTime = System.currentTimeMillis();
      if ((this.clickCount <= 2L) || (this.clickCount >= 10)) {
        break label118;
      }
      if (this.toast != null) {
        this.toast.cancel();
      }
      this.toast = Toast.makeText(this, getString(2131296511, new Object[] { Long.valueOf(10 - this.clickCount) }), 0);
      this.toast.show();
    }
    label118:
    while (this.clickCount < 10)
    {
      return;
      this.clickCount = 1L;
      break;
    }
    Toast.makeText(this, 2131296512, 0).show();
    AppSharedPreferences.getInstance().setOpenTest(true);
    findViewById(2131230901).setVisibility(0);
    findViewById(2131230902).setVisibility(0);
    findViewById(2131230903).setVisibility(0);
    findViewById(2131230904).setVisibility(0);
  }
  
  /* Error */
  public static void saveConfig(String paramString)
  {
    // Byte code:
    //   0: invokestatic 936	com/project/library/share/LibSharedPreferences:getInstance	()Lcom/project/library/share/LibSharedPreferences;
    //   3: invokevirtual 939	com/project/library/share/LibSharedPreferences:getDebug	()Z
    //   6: ifeq +61 -> 67
    //   9: new 108	java/io/File
    //   12: dup
    //   13: getstatic 353	com/veryfit/multi/util/Constant:LOG_PATH	Ljava/lang/String;
    //   16: ldc_w 941
    //   19: invokespecial 943	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: astore_2
    //   23: aload_2
    //   24: invokevirtual 320	java/io/File:exists	()Z
    //   27: ifeq +8 -> 35
    //   30: aload_2
    //   31: invokevirtual 414	java/io/File:delete	()Z
    //   34: pop
    //   35: aconst_null
    //   36: astore_1
    //   37: aconst_null
    //   38: astore_3
    //   39: new 416	java/io/FileWriter
    //   42: dup
    //   43: aload_2
    //   44: iconst_1
    //   45: invokespecial 419	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   48: astore_2
    //   49: aload_2
    //   50: aload_0
    //   51: invokevirtual 423	java/io/FileWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   54: pop
    //   55: aload_2
    //   56: invokevirtual 426	java/io/FileWriter:flush	()V
    //   59: aload_2
    //   60: ifnull +7 -> 67
    //   63: aload_2
    //   64: invokevirtual 429	java/io/FileWriter:close	()V
    //   67: return
    //   68: astore_2
    //   69: aload_3
    //   70: astore_0
    //   71: aload_0
    //   72: astore_1
    //   73: aload_2
    //   74: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   77: aload_0
    //   78: ifnull -11 -> 67
    //   81: aload_0
    //   82: invokevirtual 429	java/io/FileWriter:close	()V
    //   85: return
    //   86: astore_0
    //   87: aload_0
    //   88: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   91: return
    //   92: astore_0
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 429	java/io/FileWriter:close	()V
    //   101: aload_0
    //   102: athrow
    //   103: astore_1
    //   104: aload_1
    //   105: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   108: goto -7 -> 101
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 346	java/io/IOException:printStackTrace	()V
    //   116: return
    //   117: astore_0
    //   118: aload_2
    //   119: astore_1
    //   120: goto -27 -> 93
    //   123: astore_1
    //   124: aload_2
    //   125: astore_0
    //   126: aload_1
    //   127: astore_2
    //   128: goto -57 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramString	String
    //   36	62	1	str	String
    //   103	2	1	localIOException1	IOException
    //   119	1	1	localIOException2	IOException
    //   123	4	1	localIOException3	IOException
    //   22	42	2	localObject1	Object
    //   68	57	2	localIOException4	IOException
    //   127	1	2	localObject2	Object
    //   38	32	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   39	49	68	java/io/IOException
    //   81	85	86	java/io/IOException
    //   39	49	92	finally
    //   73	77	92	finally
    //   97	101	103	java/io/IOException
    //   63	67	111	java/io/IOException
    //   49	59	117	finally
    //   49	59	123	java/io/IOException
  }
  
  private void sendAlarms()
  {
    this.mAlarmList.clear();
    Iterator localIterator = TempUtil.getAlarms().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (!this.mAlarmList.isEmpty()) {
          break;
        }
        DebugLog.d(">>闹钟发送完毕,发送防丢");
        sendLost();
        return;
      }
      AlarmNotify localAlarmNotify = (AlarmNotify)localIterator.next();
      this.mAlarmList.add(localAlarmNotify);
    }
    this.mCore.write(SettingsCmd.getInstance().getAlarmClockSettingsCmd((AlarmNotify)this.mAlarmList.peek()));
  }
  
  private void sendFindPhone()
  {
    if ((LibSharedPreferences.getInstance().getDeviceFunOtherNotify() & 0x8) >> 3 == 1)
    {
      boolean bool = this.mAppSharedPreferences.getDeviceFoundPhoneSwitch();
      if (bool)
      {
        if ((!this.mCore.writeForce(SettingsCmd.getInstance().getFindPhoneCmd(bool))) && (!this.mCore.writeForce(SettingsCmd.getInstance().getFindPhoneCmd(bool)))) {
          this.mCore.writeForce(SettingsCmd.getInstance().getFindPhoneCmd(bool));
        }
        AppSharedPreferences.getInstance().setDeviceFoundPhoneSwitch(bool);
        this.mFindPhoneRunnable = new FindPhoneRunnable();
        this.handler.postDelayed(this.mFindPhoneRunnable, 3000L);
        return;
      }
      DebugLog.d(">>寻找手机发送成功，发送完毕");
      settingsSuccess();
      return;
    }
    DebugLog.d(">>不支持寻找手机，发送完毕");
    settingsSuccess();
  }
  
  private void sendLogToEmail()
  {
    this.mBufferDialog = new BufferDialog(this);
    this.mBufferDialog.show();
    final File localFile = new File(Constant.APP_ROOT_PATH, "log.zip");
    if (localFile.exists()) {
      localFile.delete();
    }
    final XZip localXZip = new XZip();
    localXZip.OnZip(new XZip.Zip()
    {
      public void onFinish()
      {
        SysSettingsActivity.this.mHandler.post(new Runnable()
        {
          public void run()
          {
            SysSettingsActivity.this.mBufferDialog.dismiss();
            Intent localIntent = new Intent("android.intent.action.SEND");
            localIntent.setType("message/rfc822");
            localIntent.putExtra("android.intent.extra.EMAIL", new String[] { "ido@idoosmart.com" });
            localIntent.putExtra("android.intent.extra.SUBJECT", "android_log");
            localIntent.putExtra("android.intent.extra.TEXT", "日志");
            localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(this.val$logZipFile));
            SysSettingsActivity.this.startActivity(Intent.createChooser(localIntent, SysSettingsActivity.this.getResources().getString(2131296741)));
          }
        });
      }
    });
    new AsyncTask()
    {
      protected Object doInBackground(Object... paramAnonymousVarArgs)
      {
        paramAnonymousVarArgs = SysSettingsActivity.this.getApplicationContext().getDatabasePath("db_veryfit2.db").getAbsolutePath();
        String str = Constant.LOG_PATH + "/db_veryfit2.db";
        SysSettingsActivity.this.cpDb2Sdcard2(paramAnonymousVarArgs, str);
        return null;
      }
      
      protected void onPostExecute(Object paramAnonymousObject)
      {
        try
        {
          localXZip.ZipFolder(Constant.LOG_PATH, localFile.getAbsolutePath());
          return;
        }
        catch (Exception paramAnonymousObject)
        {
          ((Exception)paramAnonymousObject).printStackTrace();
        }
      }
    }.execute(new Object[] { "" });
  }
  
  private void sendLost()
  {
    if ((LibSharedPreferences.getInstance().getDeviceFunOtherNotify() >> 1 & 0x1) == 1)
    {
      if (1 == AppSharedPreferences.getInstance().getAntilost())
      {
        localAntilostInfos = new AntilostInfos();
        localAntilostInfos.mode = 1;
        this.mCore.write(SettingsCmd.getInstance().getAntilostSettingsCmd(localAntilostInfos));
        return;
      }
      AntilostInfos localAntilostInfos = new AntilostInfos();
      localAntilostInfos.mode = 0;
      this.mCore.write(SettingsCmd.getInstance().getAntilostSettingsCmd(localAntilostInfos));
      return;
    }
    DebugLog.d(">>不支持防丢，发送久坐");
    sendRemindSport();
  }
  
  private void sendRemindSport()
  {
    if ((LibSharedPreferences.getInstance().getDeviceFunOtherNotify() & 0x1) == 1)
    {
      Sedentariness localSedentariness = new Sedentariness();
      AppSharedPreferences localAppSharedPreferences = AppSharedPreferences.getInstance();
      localSedentariness.repetitions = localAppSharedPreferences.getDeviceRemindSportRepetitions();
      localSedentariness.startHour = localAppSharedPreferences.getDeviceRemindSportStartHour();
      localSedentariness.startMinute = localAppSharedPreferences.getDeviceRemindSportStartMin();
      localSedentariness.endHour = localAppSharedPreferences.getDeviceRemindSportEndHour();
      localSedentariness.endMinute = localAppSharedPreferences.getDeviceRemindSportEndMin();
      localSedentariness.interval = localAppSharedPreferences.getDeviceRemindSportInterval();
      this.mCore.write(SettingsCmd.getInstance().getSedentarinessSettingsCmd(localSedentariness));
      return;
    }
    DebugLog.d(">>不支持久坐，发送寻找手机");
    sendFindPhone();
  }
  
  private void sendUnitSet()
  {
    int i = 1;
    initTimeMode();
    DebugLog.i(">>设置单位");
    Units localUnits = new Units();
    localUnits.setMode(AppSharedPreferences.getInstance().getUnitType());
    String str = getResources().getConfiguration().locale.toString();
    if (str.contains("zh"))
    {
      localUnits.language = 1;
      if (!this.mAppSharedPreferences.getUserSex()) {
        break label134;
      }
      localUnits.stride = ((int)(this.mAppSharedPreferences.getUserHeight() * 0.415D));
      label86:
      if (!AppSharedPreferences.getInstance().is24TimeMode()) {
        break label154;
      }
    }
    for (;;)
    {
      localUnits.timeMode = i;
      this.mCore.write(SettingsCmd.getInstance().getUnitSettingsCmd(localUnits));
      return;
      if (!str.contains("en")) {
        break;
      }
      localUnits.language = 2;
      break;
      label134:
      localUnits.stride = ((int)(this.mAppSharedPreferences.getUserHeight() * 0.413D));
      break label86;
      label154:
      i = 2;
    }
  }
  
  private void settingsSuccess()
  {
    closeCircleDialog();
    setResult(1);
    finish();
  }
  
  private void showCircleDialog()
  {
    if (this.dialogCircle == null)
    {
      this.dialogCircle = DialogUtil.showCircleProgressDialog(this, 2131296604, true);
      this.mSettingTimeoutRunnable = new SettingTimeoutRunnable();
      this.handler.postDelayed(this.mSettingTimeoutRunnable, 60000L);
    }
  }
  
  private void showDialog()
  {
    if ((this.dialog != null) && (this.dialog.isShowing())) {
      return;
    }
    this.dialog = DialogUtil.showMsgDialog(this, 2131296404, new DialogUtil.OnDialogClickListener()
    {
      public void onDialogCancel() {}
      
      public void onDialogShare()
      {
        SysSettingsActivity.this.reboot = true;
        SysSettingsActivity.this.restartDevice(null);
      }
    });
  }
  
  private void showProgress(String paramString)
  {
    if (this.mProgress == null)
    {
      this.mProgress = new ProgressDialog(this);
      this.mProgress.setProgressStyle(0);
      this.mProgress.setIndeterminate(true);
      this.mProgress.setCancelable(false);
    }
    this.mProgress.setMessage(paramString);
    this.mProgress.show();
  }
  
  private void startSync()
  {
    byte b = 0;
    if (this.mCore.isDeviceConnected())
    {
      startSyncScanTimer(true);
      this.mCore.addListener(this.mAppListener);
      LibSharedPreferences.getInstance().setSyncData(true);
      if (AppSharedPreferences.getInstance().getSyncHealdataMode()) {
        b = 1;
      }
      this.mCore.writeForce(HealthSyncRequest.getInstance().getHealthSyncRequestCmd((byte)1, b));
      return;
    }
    DebugLog.d("设备未连接");
    this.reboot = false;
    Toast.makeText(this, 2131296616, 0).show();
    this.mCore.connect(AppSharedPreferences.getInstance().getBindDeviceAddr());
  }
  
  private void startSyncScanTimer(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      local3 = new TimerTask()
      {
        public void run()
        {
          SysSettingsActivity.this.handler.sendEmptyMessage(4);
        }
      };
      this.syncTimer.schedule(local3, 120000L);
    }
    while (this.syncTimer == null)
    {
      TimerTask local3;
      return;
    }
    this.syncTimer.cancel();
  }
  
  public void UnitSettings(int paramInt)
  {
    Units localUnits = new Units();
    if (paramInt == 1)
    {
      localUnits.dist = 1;
      localUnits.weight = 1;
      localUnits.temp = 1;
    }
    for (;;)
    {
      this.mCore.writeForce(SettingsCmd.getInstance().getUnitSettingsCmd(localUnits));
      return;
      if (paramInt == 2)
      {
        localUnits.dist = 2;
        localUnits.weight = 2;
        localUnits.temp = 2;
      }
    }
  }
  
  public void checkAppVersion()
  {
    if (NetUtils.isConnected(this))
    {
      VolleyUtil.getInstance().loadGetStr("http://www.youduoyun.com/apps/veryfit2.json", this, new AVolleyResponse(this)
      {
        public void onError(VolleyError paramAnonymousVolleyError, String paramAnonymousString) {}
        
        public void onSuccess(String paramAnonymousString)
        {
          System.out.println("response = " + paramAnonymousString);
          try
          {
            Object localObject = new JSONObject(paramAnonymousString);
            int i = ((JSONObject)localObject).getInt("versionCode");
            paramAnonymousString = ((JSONObject)localObject).getString("versionName");
            String str1 = ((JSONObject)localObject).getString("updateInfo_cn");
            String str2 = ((JSONObject)localObject).getString("updateInfo_en");
            localObject = ((JSONObject)localObject).getString("url");
            SysSettingsActivity.this.apInfo = new AppUpdateInfo();
            SysSettingsActivity.this.apInfo.setVersionCode(i);
            SysSettingsActivity.this.apInfo.setVersionName(paramAnonymousString);
            SysSettingsActivity.this.apInfo.setUpdateInfo_cn(str1);
            SysSettingsActivity.this.apInfo.setUpdateInfo_en(str2);
            SysSettingsActivity.this.apInfo.setUrl((String)localObject);
            if (UpdateApkUtil.getAppVersionCode(SysSettingsActivity.this) < i)
            {
              SysSettingsActivity.this.item_app.setValueState(true, 2131296451);
              SysSettingsActivity.this.canUpdate = true;
              return;
            }
            new Handler().postDelayed(new Runnable()
            {
              public void run()
              {
                SysSettingsActivity.this.item_app.setValueState(false, SysSettingsActivity.this.getString(2131296452, new Object[] { UpdateApkUtil.getAppVersionName(SysSettingsActivity.this) }));
              }
            }, 10L);
            SysSettingsActivity.this.canUpdate = false;
            return;
          }
          catch (Exception paramAnonymousString)
          {
            paramAnonymousString.printStackTrace();
          }
        }
      });
      return;
    }
    this.noNetWork = true;
    this.item_app.setValueState(false, UpdateApkUtil.getAppVersionName(this));
  }
  
  public void downLoadApk(String paramString1, String paramString2)
  {
    UpdateApkUtil.downloadApk(this.handler, paramString1, paramString2);
  }
  
  protected void initData()
  {
    super.initData();
    this.item_app.setValueState(false, UpdateApkUtil.getAppVersionName(this));
    checkAppVersion();
  }
  
  protected void initEvent()
  {
    super.initEvent();
    this.tv_units.setOnClickListener(this);
    this.llSendEmail.setOnClickListener(this);
    this.back.setOnClickListener(this);
    this.tv_time_notice.setOnClickListener(this);
    this.iv_about_us.setOnClickListener(this);
    this.iv_normal_problem.setOnClickListener(this);
    this.item_app.setOnClickListener(this);
    this.tv_restartDevice.setOnClickListener(this);
  }
  
  protected void initView()
  {
    super.initView();
    AppSharedPreferences.getInstance().setOpenTest(false);
    this.llSendEmail = ((LinearLayout)findViewById(2131230760));
    this.tv_units = ((TextView)findViewById(2131230889));
    this.tv_time_notice = ((TextView)findViewById(2131230893));
    this.back = ((ImageView)findViewById(2131230729));
    this.iv_about_us = ((ImageView)findViewById(2131230895));
    this.item_app = ((ItemLableValue)findViewById(2131230898));
    this.iv_normal_problem = ((ImageView)findViewById(2131230897));
    this.tv_restartDevice = ((ItemLableValue)findViewById(2131230900));
    this.version = ((ItemLableValue)findViewById(2131230899));
    this.tv = ((TextView)findViewById(2131230730));
    if (LibSharedPreferences.getInstance().getDebug()) {
      this.tv.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (AppSharedPreferences.getInstance().isOpenTest())
          {
            Toast.makeText(SysSettingsActivity.this, 2131296512, 0).show();
            return;
          }
          SysSettingsActivity.this.openTest();
        }
      });
    }
    String[] arrayOfString = getResources().getStringArray(2131361793);
    if (AppSharedPreferences.getInstance().getUnitType() == 1) {
      this.tv_units.setText(arrayOfString[0]);
    }
    try
    {
      for (;;)
      {
        this.version.setValue("V" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName);
        try
        {
          saveConfig("appVersion:V" + getPackageManager().getPackageInfo(getPackageName(), 0).versionName + "   phoneType:" + Build.MODEL + "   androidApi:" + Build.VERSION.SDK + "," + Build.VERSION.RELEASE + "   deviceVersion:" + LibSharedPreferences.getInstance().getDeviceFirmwareVersion() + "   deviceName:" + AppSharedPreferences.getInstance().getBindDeviceName());
          return;
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException2)
        {
          localNameNotFoundException2.printStackTrace();
        }
        this.tv_units.setText(arrayOfString[1]);
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException1)
    {
      for (;;)
      {
        localNameNotFoundException1.printStackTrace();
      }
    }
  }
  
  public void onClick(final View paramView)
  {
    switch (paramView.getId())
    {
    case 2131230730: 
    case 2131230897: 
    default: 
    case 2131230760: 
    case 2131230889: 
    case 2131230898: 
      do
      {
        return;
        if (!NetUtils.isConnected(this))
        {
          Toast.makeText(this, 2131296632, 0).show();
          return;
        }
        startActivity(new Intent(this, FeedBackActivity.class));
        return;
        if (AppSharedPreferences.getInstance().getUnitType() != 1) {}
        for (int i = 1;; i = 0)
        {
          DialogUtil.showUnitSetDialog(this, i, new DialogUtil.OnWheelSelectorListener()
          {
            public void onWheelSelect(Object paramAnonymousObject)
            {
              paramAnonymousObject = (String)paramAnonymousObject;
              SysSettingsActivity.this.tv_units.setText((CharSequence)paramAnonymousObject);
              if (((String)paramAnonymousObject).equals(SysSettingsActivity.this.getResources().getStringArray(2131361793)[0])) {
                if (AppSharedPreferences.getInstance().getUnitType() != 1)
                {
                  AppSharedPreferences.getInstance().setUnitType(1);
                  LibSharedPreferences.getInstance().setUnits(true);
                  SysSettingsActivity.this.UnitSettings(1);
                }
              }
              while (AppSharedPreferences.getInstance().getUnitType() == 2) {
                return;
              }
              AppSharedPreferences.getInstance().setUnitType(2);
              LibSharedPreferences.getInstance().setUnits(true);
              SysSettingsActivity.this.UnitSettings(2);
            }
          });
          return;
        }
      } while ((!this.canUpdate) || (!NetUtils.isConnected(this)));
      paramView = new Intent(this, AppUpdateActivity.class);
      if (this.apInfo != null) {
        paramView.putExtra("updateInfo", this.apInfo);
      }
      startActivity(paramView);
      return;
    case 2131230729: 
      finish();
      return;
    case 2131230895: 
      startActivity(new Intent(this, AboutUsActivity.class));
      return;
    case 2131230893: 
      DialogUtil.showWheelTimeDialog(this, 8, 55, new DialogUtil.OnTimePickerSelectListener()
      {
        public void OnTimePickerSelect(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          SysSettingsActivity.this.tv_time_notice.setText(SysSettingsActivity.this.getString(2131296428, new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) }));
        }
      });
      return;
    case 2131230900: 
      showDialog();
      return;
    case 2131230902: 
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        if (this.dialogCircle == null) {
          this.dialogCircle = DialogUtil.showCircleProgressDialog(this, 2131296764, true);
        }
        new Thread()
        {
          public void run()
          {
            SysSettingsActivity.this.exportDb2File();
            SysSettingsActivity.this.closeCircleDialog();
            SysSettingsActivity.this.dialogCircle = null;
          }
        }.start();
        return;
      }
      Toast.makeText(this, "SD卡不存在", 1).show();
      return;
    case 2131230903: 
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        if (this.dialogCircle == null) {
          this.dialogCircle = DialogUtil.showCircleProgressDialog(this, 2131296765, true);
        }
        paramView = getApplicationContext().getDatabasePath("db_veryfit2.db").getAbsolutePath();
        final String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/veryfit2" + "/db/db_veryfit2.db";
        new Thread()
        {
          public void run()
          {
            SysSettingsActivity.this.cpDb2Sdcard(paramView, str);
            SysSettingsActivity.this.closeCircleDialog();
            SysSettingsActivity.this.dialogCircle = null;
          }
        }.start();
        Toast.makeText(this, "拷贝数据库文件到:" + str, 1).show();
        return;
      }
      Toast.makeText(this, "SD卡不存在", 1).show();
      return;
    }
    if (Environment.getExternalStorageState().equals("mounted"))
    {
      if (this.dialogCircle == null) {
        this.dialogCircle = DialogUtil.showCircleProgressDialog(this, 2131296763, true);
      }
      new Thread()
      {
        public void run()
        {
          SysSettingsActivity.this.importFile2Db();
          SysSettingsActivity.this.closeCircleDialog();
          SysSettingsActivity.this.dialogCircle = null;
        }
      }.start();
      return;
    }
    Toast.makeText(this, "SD卡不存在", 1).show();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903071);
    createLogFileDir();
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mCore.removeListener(this.mAppListener);
    hideProgress();
  }
  
  public void onDeviceNeedInit()
  {
    if (this.mCore.isDeviceConnected())
    {
      sendGetDeviceFun();
      return;
    }
    this.mCore.connect(AppSharedPreferences.getInstance().getBindDeviceAddr());
  }
  
  protected void onReciveFindPhone()
  {
    if (this.mFindPhoneRunnable != null) {
      this.handler.removeCallbacks(this.mFindPhoneRunnable);
    }
    DebugLog.d(">>寻找手机发送成功，发送完毕");
    settingsSuccess();
  }
  
  protected void onReciveLost()
  {
    DebugLog.d(">>防丢发送成功，发送久坐");
    sendRemindSport();
  }
  
  protected void onReciveMultiTarget()
  {
    DebugLog.i(">>设置运动目标信息成功，设置闹钟");
    sendAlarms();
  }
  
  protected void onReciveUserInfo()
  {
    DebugLog.i(">>设置用户信息成功，设置运动目标信息");
    setMultiTarget();
  }
  
  protected void onRecivesendUnit()
  {
    DebugLog.i(">>设置单位成功，设置时间、。");
    this.mCore.write(SettingsCmd.getInstance().getTimeSettingsCmd());
  }
  
  protected void onReviceSettingRemindSport()
  {
    DebugLog.d(">>久坐发送成功，发送寻找手机");
    sendFindPhone();
  }
  
  protected void onThemeChanged() {}
  
  public void restartDevice(View paramView)
  {
    this.isOutTime = false;
    startSync();
  }
  
  protected void sendGetDeviceFun()
  {
    if (LibSharedPreferences.getInstance().getDeviceFunMain() == -1)
    {
      DebugLog.d(">>获取功能表");
      this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)2));
      return;
    }
    DebugLog.d(">>功能表已获取，获取设备信息");
    this.mCore.writeForce(GetInfoCmd.getInstance().getGetInfoCmd((byte)1));
  }
  
  public void setMultiTarget()
  {
    int[] arrayOfInt = TempUtil.getGoal(LongDateUtil.Calendar2LongDate(Calendar.getInstance()));
    MultiTarget localMultiTarget = new MultiTarget();
    localMultiTarget.sportType = 0;
    localMultiTarget.sportTarget = arrayOfInt[0];
    localMultiTarget.sleepFlag = 0;
    localMultiTarget.sleepHour = (arrayOfInt[1] / 60);
    localMultiTarget.sleepMinute = (arrayOfInt[1] % 60);
    this.mCore.writeForce(SettingsCmd.getInstance().getMultiTargetSettingsCmd(localMultiTarget));
  }
  
  protected void setUserInfo()
  {
    Userinfos localUserinfos = new Userinfos();
    localUserinfos.height = this.mAppSharedPreferences.getUserHeight();
    localUserinfos.weight = this.mAppSharedPreferences.getUserWeight();
    if (this.mAppSharedPreferences.getUserSex()) {}
    for (int i = 0;; i = 1)
    {
      localUserinfos.gender = i;
      localUserinfos.year = this.mAppSharedPreferences.getUserBirthdayYear();
      localUserinfos.month = this.mAppSharedPreferences.getUserBirthdayMonth();
      localUserinfos.day = this.mAppSharedPreferences.getUserBirthdayDay();
      this.mCore.write(SettingsCmd.getInstance().getUserinfosSettingsCmd(localUserinfos));
      return;
    }
  }
  
  class FindPhoneRunnable
    implements Runnable
  {
    FindPhoneRunnable() {}
    
    public void run()
    {
      SysSettingsActivity.this.settingsSuccess();
    }
  }
  
  class SettingTimeoutRunnable
    implements Runnable
  {
    SettingTimeoutRunnable() {}
    
    public void run()
    {
      SysSettingsActivity.this.closeCircleDialog();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\mine\SysSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */