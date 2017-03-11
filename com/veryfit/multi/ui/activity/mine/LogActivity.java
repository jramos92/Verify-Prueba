package com.veryfit.multi.ui.activity.mine;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.util.ByteDataConvertUtil;
import com.project.library.util.DebugLog;
import com.project.library.util.UartLogUtil;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.Constant;
import java.io.File;
import java.util.Arrays;
import java.util.Timer;

public class LogActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Button btn_clear_log;
  private Button btn_open_fun_log;
  private Button btn_send;
  private String deviceLogPath = Constant.LOG_PATH + "/deviceLog.txt";
  private boolean isTimeOut = false;
  File logZipFile;
  private APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onBLEConnected()
    {
      LogActivity.this.sendLogCmd();
    }
    
    public void onOtherDataReceive(byte[] paramAnonymousArrayOfByte)
    {
      DebugLog.d("revice--->other");
      if ((paramAnonymousArrayOfByte[0] == 33) && (paramAnonymousArrayOfByte[1] == 6)) {
        if (paramAnonymousArrayOfByte[2] == -86)
        {
          LogActivity.this.sb.append("<< recive :" + LogActivity.this.getResources().getString(2131296669) + "\n");
          LogActivity.this.sendBtn.setEnabled(false);
        }
      }
      while ((paramAnonymousArrayOfByte[0] != 33) || (paramAnonymousArrayOfByte[1] != 7)) {
        for (;;)
        {
          LogActivity.this.textView.setText(LogActivity.this.sb.toString());
          return;
          if (paramAnonymousArrayOfByte[2] == 85)
          {
            paramAnonymousArrayOfByte = new String(Arrays.copyOfRange(paramAnonymousArrayOfByte, 3, paramAnonymousArrayOfByte.length - 1));
            LogActivity.this.sb.append("<< recive : " + paramAnonymousArrayOfByte + "\n\n");
            LogActivity.this.sendLogCmd();
          }
        }
      }
      DebugLog.e("清除日志。。。");
    }
  };
  CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  Handler mHandler = new Handler();
  private StringBuilder sb = new StringBuilder();
  private View sendBtn;
  private SendLogModel sendLogModel;
  private TextView textView;
  private Timer timeOut = new Timer();
  
  private void sendClearLogCmd()
  {
    byte[] arrayOfByte = new byte[20];
    arrayOfByte[0] = 33;
    arrayOfByte[1] = 7;
    this.mCore.writeForce(arrayOfByte);
    UartLogUtil.recordWrite("发送清除日志命令", arrayOfByte);
    new Handler().postDelayed(new Runnable()
    {
      public void run()
      {
        if (LogActivity.this.sb.length() > 10)
        {
          LogActivity.this.sb.setLength(0);
          LogActivity.this.sb.delete(0, LogActivity.this.sb.length());
          LogActivity.this.textView.setText(LogActivity.this.sb.toString());
        }
      }
    }, 2000L);
    this.sendBtn.setEnabled(true);
  }
  
  private void sendLogCmd()
  {
    Object localObject = new byte[20];
    localObject[0] = 33;
    localObject[1] = 6;
    this.mCore.writeForce((byte[])localObject);
    UartLogUtil.recordWrite("发送测试命令", (byte[])localObject);
    localObject = ByteDataConvertUtil.bytesToHexString((byte[])localObject);
    this.sb.append(">> write : " + (String)localObject + "\n");
    this.textView.setText(this.sb.toString());
  }
  
  private void sendLogToEmail()
  {
    if (this.mCore.isDeviceConnected())
    {
      sendLogCmd();
      return;
    }
    DebugLog.d("设备未连接");
    this.mCore.connect(AppSharedPreferences.getInstance().getBindDeviceAddr());
  }
  
  private void sendOpenFunLogCmd()
  {
    Object localObject = new byte[20];
    localObject[0] = -14;
    localObject[1] = -10;
    this.mCore.writeForce((byte[])localObject);
    UartLogUtil.recordWrite("发送打开函数日志命令", (byte[])localObject);
    localObject = ByteDataConvertUtil.bytesToHexString((byte[])localObject);
    this.sb.append(">> write : " + (String)localObject + "\n");
    this.textView.setText(this.sb.toString());
    this.sendBtn.setEnabled(true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131230804: 
    case 2131230805: 
    case 2131230806: 
      do
      {
        do
        {
          return;
          this.sendBtn = paramView;
          if (this.mCore.isDeviceConnected())
          {
            sendLogCmd();
            return;
          }
          DebugLog.d("设备未连接");
          this.mCore.connect(AppSharedPreferences.getInstance().getBindDeviceAddr());
          return;
        } while (!this.mCore.isDeviceConnected());
        sendClearLogCmd();
        return;
      } while (!this.mCore.isDeviceConnected());
      sendOpenFunLogCmd();
      return;
    }
    sendLogToEmail();
    this.sendLogModel.sendLogToEmail();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903056);
    this.mCore.addListener(this.mAppListener);
    this.sendLogModel = new SendLogModel(this);
    this.textView = ((TextView)findViewById(2131230803));
    this.btn_send = ((Button)findViewById(2131230804));
    this.btn_clear_log = ((Button)findViewById(2131230805));
    this.btn_open_fun_log = ((Button)findViewById(2131230806));
    this.btn_send.setOnClickListener(this);
    this.btn_clear_log.setOnClickListener(this);
    this.btn_open_fun_log.setOnClickListener(this);
    this.sendBtn = this.btn_send;
  }
  
  protected void onThemeChanged() {}
  
  protected void setNavigationBar() {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\mine\LogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */