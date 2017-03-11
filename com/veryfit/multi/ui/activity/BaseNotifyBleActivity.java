package com.veryfit.multi.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.device.cmd.DeviceBaseCommand;
import com.project.library.util.DebugLog;
import com.veryfit.multi.base.BaseActivity;

public abstract class BaseNotifyBleActivity
  extends BaseActivity
{
  protected byte cmdKey;
  protected APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onBLEDisConnected(String paramAnonymousString)
    {
      BaseNotifyBleActivity.this.sendingData = false;
    }
    
    public void onDataSendTimeOut(byte[] paramAnonymousArrayOfByte)
    {
      if (BaseNotifyBleActivity.this.cmdKey == BaseNotifyBleActivity.this.cmdKey)
      {
        DebugLog.e("设置失败： " + BaseNotifyBleActivity.this.cmdKey);
        BaseNotifyBleActivity.this.sendingData = false;
        Toast.makeText(BaseNotifyBleActivity.this, 2131296398, 0).show();
        BaseNotifyBleActivity.this.onDataSendFailed();
      }
    }
    
    public void onSettingsSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean)
    {
      if (paramAnonymousByte == BaseNotifyBleActivity.this.cmdKey)
      {
        if (paramAnonymousBoolean)
        {
          DebugLog.e("设置成功： " + paramAnonymousByte);
          BaseNotifyBleActivity.this.onSettingsSuccess();
        }
      }
      else {
        return;
      }
      DebugLog.e("设置失败： " + paramAnonymousByte);
      BaseNotifyBleActivity.this.sendingData = false;
      Toast.makeText(BaseNotifyBleActivity.this, 2131296398, 0).show();
      BaseNotifyBleActivity.this.onDataSendFailed();
    }
  };
  protected CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  protected LinearLayout progress;
  protected boolean sendingData;
  protected TextView sureBtn;
  
  protected void initView()
  {
    this.progress = ((LinearLayout)findViewById(2131230738));
    this.sureBtn = ((TextView)findViewById(2131230737));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131230729: 
      finish();
      return;
    }
    saveDate();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initView();
  }
  
  protected abstract void onDataSendFailed();
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mCore.removeListener(this.mAppListener);
  }
  
  protected abstract void onSettingsSuccess();
  
  protected void onThemeChanged() {}
  
  protected abstract void saveDate();
  
  protected void showProgress()
  {
    this.progress.setVisibility(0);
    this.sureBtn.setVisibility(8);
  }
  
  protected void showSureBtn()
  {
    this.sureBtn.setVisibility(0);
    this.progress.setVisibility(8);
  }
  
  protected boolean writeData(byte[] paramArrayOfByte)
  {
    this.cmdKey = DeviceBaseCommand.getCmdKey(paramArrayOfByte);
    if (!this.mCore.isDeviceConnected()) {
      return false;
    }
    return this.mCore.writeForce(paramArrayOfByte);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\BaseNotifyBleActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */