package com.veryfit.multi.ui.activity.mine;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.util.DebugLog;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.Constant;
import com.veryfit.multi.util.XZip;
import com.veryfit.multi.util.XZip.Zip;
import com.veryfit.multi.view.BufferDialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class SendLogModel
{
  private StringBuffer deviceLog;
  private String deviceLogPath = Constant.LOG_PATH + "/deviceLog.txt";
  private boolean isHaveLogData = true;
  File logZipFile;
  private Activity mActivity;
  private APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onBLEConnected()
    {
      SendLogModel.this.sendLogCmd();
      SendLogModel.this.setTimerOut();
    }
    
    public void onOtherDataReceive(byte[] paramAnonymousArrayOfByte)
    {
      if (SendLogModel.this.timerOut != null)
      {
        SendLogModel.this.timerOut.cancel();
        SendLogModel.this.timerOut = null;
      }
      DebugLog.d("revice--->other");
      if ((paramAnonymousArrayOfByte[0] == 33) && (paramAnonymousArrayOfByte[1] == 6)) {
        if (paramAnonymousArrayOfByte[2] == -86) {
          if (SendLogModel.this.isHaveLogData)
          {
            DebugLog.d("revice--->日志数据已经接收完毕 .日数据打包中......");
            SendLogModel.this.isHaveLogData = false;
            SendLogModel.this.writeDeviceLogToFile();
            SendLogModel.this.preZip();
          }
        }
      }
      while ((paramAnonymousArrayOfByte[0] != 33) || (paramAnonymousArrayOfByte[1] != 7))
      {
        do
        {
          return;
        } while (paramAnonymousArrayOfByte[2] != 85);
        paramAnonymousArrayOfByte = new String(Arrays.copyOfRange(paramAnonymousArrayOfByte, 3, paramAnonymousArrayOfByte.length - 1));
        if (SendLogModel.this.deviceLog == null) {
          SendLogModel.this.deviceLog = new StringBuffer();
        }
        SendLogModel.this.deviceLog.append(paramAnonymousArrayOfByte.trim());
        SendLogModel.this.deviceLog.append("\n");
        SendLogModel.this.sendLogCmd();
        return;
      }
      DebugLog.e("清除日志。。。");
    }
  };
  CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  Handler mHandler = new Handler();
  private BufferDialog progressDialog;
  private Timer timerOut = new Timer();
  
  public SendLogModel(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.mCore.addListener(this.mAppListener);
    this.progressDialog = new BufferDialog(paramActivity);
    this.logZipFile = new File(Constant.APP_ROOT_PATH, "logzip");
  }
  
  private void cpDb2Sdcard2(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2);
    if (paramString2.exists()) {
      paramString2.delete();
    }
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
  
  private String getConfig()
  {
    Object localObject = "";
    try
    {
      str1 = this.mActivity.getPackageManager().getPackageInfo(this.mActivity.getPackageName(), 0).versionName;
      localObject = str1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        String str1;
        String str2;
        String str3;
        String str4;
        StringBuffer localStringBuffer;
        localNameNotFoundException.printStackTrace();
      }
    }
    str1 = Build.MODEL;
    str2 = Build.VERSION.SDK;
    str3 = AppSharedPreferences.getInstance().getBindDeviceName();
    str4 = AppSharedPreferences.getInstance().getUserName();
    localStringBuffer = new StringBuffer();
    localStringBuffer.append("手环产品型号:");
    localStringBuffer.append(str3);
    localStringBuffer.append("\n");
    localStringBuffer.append("Veryfit用户名:");
    localStringBuffer.append(str4);
    localStringBuffer.append("\n");
    localStringBuffer.append("设备品牌/型号:");
    localStringBuffer.append(str1);
    localStringBuffer.append("\n");
    localStringBuffer.append("设备操作系统版本:");
    localStringBuffer.append(str2);
    localStringBuffer.append("\n");
    localStringBuffer.append("Veryfit应用程序版本号:");
    localStringBuffer.append((String)localObject);
    localStringBuffer.append("\n");
    return localStringBuffer.toString();
  }
  
  private void preZip()
  {
    final XZip localXZip = new XZip();
    localXZip.OnZip(new ZipFinished(null));
    new AsyncTask()
    {
      protected Object doInBackground(Object... paramAnonymousVarArgs)
      {
        SendLogModel.this.saveConfig();
        paramAnonymousVarArgs = SendLogModel.this.mActivity.getDatabasePath("db_veryfit2.db").getAbsolutePath();
        String str = Constant.LOG_PATH + "/db_veryfit2.db";
        SendLogModel.this.cpDb2Sdcard2(paramAnonymousVarArgs, str);
        try
        {
          localXZip.ZipFolder(Constant.LOG_PATH, SendLogModel.this.logZipFile.getAbsolutePath());
          return null;
        }
        catch (Exception paramAnonymousVarArgs)
        {
          for (;;)
          {
            paramAnonymousVarArgs.printStackTrace();
          }
        }
      }
    }.execute(new Object[] { "" });
  }
  
  private void sendLogCmd()
  {
    byte[] arrayOfByte = new byte[20];
    arrayOfByte[0] = 33;
    arrayOfByte[1] = 6;
    this.mCore.writeForce(arrayOfByte);
  }
  
  private void setTimerOut()
  {
    if (this.timerOut != null)
    {
      this.timerOut.cancel();
      this.timerOut = null;
    }
    this.timerOut = new Timer();
    this.timerOut.schedule(new TimerTask()
    {
      public void run()
      {
        SendLogModel.this.preZip();
      }
    }, 5000L);
  }
  
  /* Error */
  private void writeDeviceLogToFile()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 148	com/veryfit/multi/ui/activity/mine/SendLogModel:deviceLog	Ljava/lang/StringBuffer;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore_1
    //   10: aconst_null
    //   11: astore_3
    //   12: new 296	java/io/BufferedWriter
    //   15: dup
    //   16: new 298	java/io/FileWriter
    //   19: dup
    //   20: aload_0
    //   21: getfield 76	com/veryfit/multi/ui/activity/mine/SendLogModel:deviceLogPath	Ljava/lang/String;
    //   24: invokespecial 299	java/io/FileWriter:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 302	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   30: astore_2
    //   31: aload_2
    //   32: aload_0
    //   33: getfield 148	com/veryfit/multi/ui/activity/mine/SendLogModel:deviceLog	Ljava/lang/StringBuffer;
    //   36: invokevirtual 262	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   39: invokevirtual 305	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   42: aload_2
    //   43: invokevirtual 308	java/io/BufferedWriter:flush	()V
    //   46: aload_2
    //   47: ifnull +58 -> 105
    //   50: aload_2
    //   51: invokevirtual 311	java/io/BufferedWriter:close	()V
    //   54: return
    //   55: astore_1
    //   56: aload_3
    //   57: astore_2
    //   58: aload_1
    //   59: astore_3
    //   60: aload_2
    //   61: astore_1
    //   62: aload_3
    //   63: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   66: aload_2
    //   67: ifnull -60 -> 7
    //   70: aload_2
    //   71: invokevirtual 311	java/io/BufferedWriter:close	()V
    //   74: return
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   80: return
    //   81: astore_2
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 311	java/io/BufferedWriter:close	()V
    //   90: aload_2
    //   91: athrow
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   97: goto -7 -> 90
    //   100: astore_1
    //   101: aload_1
    //   102: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   105: return
    //   106: astore_3
    //   107: aload_2
    //   108: astore_1
    //   109: aload_3
    //   110: astore_2
    //   111: goto -29 -> 82
    //   114: astore_3
    //   115: goto -55 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	SendLogModel
    //   9	1	1	localObject1	Object
    //   55	4	1	localIOException1	IOException
    //   61	1	1	localObject2	Object
    //   75	12	1	localIOException2	IOException
    //   92	2	1	localIOException3	IOException
    //   100	2	1	localIOException4	IOException
    //   108	1	1	localObject3	Object
    //   30	41	2	localObject4	Object
    //   81	27	2	localObject5	Object
    //   110	1	2	localObject6	Object
    //   11	52	3	localIOException5	IOException
    //   106	4	3	localObject7	Object
    //   114	1	3	localIOException6	IOException
    // Exception table:
    //   from	to	target	type
    //   12	31	55	java/io/IOException
    //   70	74	75	java/io/IOException
    //   12	31	81	finally
    //   62	66	81	finally
    //   86	90	92	java/io/IOException
    //   50	54	100	java/io/IOException
    //   31	46	106	finally
    //   31	46	114	java/io/IOException
  }
  
  public void realSendToEmail(boolean paramBoolean)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("message/rfc822");
    localIntent.putExtra("android.intent.extra.EMAIL", new String[] { "ido@idoosmart.com" });
    localIntent.putExtra("android.intent.extra.SUBJECT", this.mActivity.getResources().getString(2131296750));
    localIntent.putExtra("android.intent.extra.TEXT", this.mActivity.getResources().getString(2131296751));
    if (paramBoolean) {
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(this.logZipFile));
    }
    this.mActivity.startActivity(Intent.createChooser(localIntent, this.mActivity.getResources().getString(2131296741)));
  }
  
  /* Error */
  public void saveConfig()
  {
    // Byte code:
    //   0: new 108	java/io/File
    //   3: dup
    //   4: getstatic 55	com/veryfit/multi/util/Constant:LOG_PATH	Ljava/lang/String;
    //   7: ldc_w 374
    //   10: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   13: astore 4
    //   15: aload 4
    //   17: invokevirtual 167	java/io/File:exists	()Z
    //   20: ifeq +9 -> 29
    //   23: aload 4
    //   25: invokevirtual 170	java/io/File:delete	()Z
    //   28: pop
    //   29: aconst_null
    //   30: astore_1
    //   31: aconst_null
    //   32: astore_3
    //   33: aconst_null
    //   34: astore_2
    //   35: new 298	java/io/FileWriter
    //   38: dup
    //   39: aload 4
    //   41: iconst_1
    //   42: invokespecial 377	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   45: astore 4
    //   47: new 296	java/io/BufferedWriter
    //   50: dup
    //   51: aload 4
    //   53: invokespecial 302	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   56: astore_1
    //   57: aload_1
    //   58: aload_0
    //   59: invokespecial 379	com/veryfit/multi/ui/activity/mine/SendLogModel:getConfig	()Ljava/lang/String;
    //   62: invokevirtual 305	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   65: aload_1
    //   66: invokevirtual 308	java/io/BufferedWriter:flush	()V
    //   69: aload_1
    //   70: ifnull +54 -> 124
    //   73: aload_1
    //   74: invokevirtual 311	java/io/BufferedWriter:close	()V
    //   77: return
    //   78: astore_3
    //   79: aload_2
    //   80: astore_1
    //   81: aload_3
    //   82: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   85: aload_2
    //   86: ifnull -9 -> 77
    //   89: aload_2
    //   90: invokevirtual 311	java/io/BufferedWriter:close	()V
    //   93: return
    //   94: astore_1
    //   95: aload_1
    //   96: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   99: return
    //   100: astore_2
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 311	java/io/BufferedWriter:close	()V
    //   109: aload_2
    //   110: athrow
    //   111: astore_1
    //   112: aload_1
    //   113: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   116: goto -7 -> 109
    //   119: astore_1
    //   120: aload_1
    //   121: invokevirtual 197	java/io/IOException:printStackTrace	()V
    //   124: return
    //   125: astore_2
    //   126: aload_3
    //   127: astore_1
    //   128: goto -27 -> 101
    //   131: astore_2
    //   132: goto -31 -> 101
    //   135: astore_3
    //   136: goto -57 -> 79
    //   139: astore_3
    //   140: aload_1
    //   141: astore_2
    //   142: goto -63 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	SendLogModel
    //   30	51	1	localObject1	Object
    //   94	12	1	localIOException1	IOException
    //   111	2	1	localIOException2	IOException
    //   119	2	1	localIOException3	IOException
    //   127	14	1	localObject2	Object
    //   34	56	2	localObject3	Object
    //   100	10	2	localObject4	Object
    //   125	1	2	localObject5	Object
    //   131	1	2	localObject6	Object
    //   141	1	2	localObject7	Object
    //   32	1	3	localObject8	Object
    //   78	49	3	localIOException4	IOException
    //   135	1	3	localIOException5	IOException
    //   139	1	3	localIOException6	IOException
    //   13	39	4	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   35	47	78	java/io/IOException
    //   89	93	94	java/io/IOException
    //   35	47	100	finally
    //   81	85	100	finally
    //   105	109	111	java/io/IOException
    //   73	77	119	java/io/IOException
    //   47	57	125	finally
    //   57	69	131	finally
    //   47	57	135	java/io/IOException
    //   57	69	139	java/io/IOException
  }
  
  public void sendLogToEmail()
  {
    this.deviceLog = new StringBuffer();
    this.isHaveLogData = true;
    if (!this.progressDialog.isShow()) {
      this.progressDialog.show();
    }
    if (this.mCore.isDeviceConnected()) {
      sendLogCmd();
    }
    for (;;)
    {
      setTimerOut();
      return;
      DebugLog.d("设备未连接");
      this.mCore.connect(AppSharedPreferences.getInstance().getBindDeviceAddr());
    }
  }
  
  private class ZipFinished
    implements XZip.Zip
  {
    private ZipFinished() {}
    
    public void onFinish()
    {
      SendLogModel.this.mHandler.post(new Runnable()
      {
        public void run()
        {
          if (SendLogModel.this.progressDialog.isShow())
          {
            SendLogModel.this.progressDialog.dismiss();
            SendLogModel.this.realSendToEmail(true);
          }
        }
      });
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\mine\SendLogModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */