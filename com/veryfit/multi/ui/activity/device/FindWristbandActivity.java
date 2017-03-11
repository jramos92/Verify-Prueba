package com.veryfit.multi.ui.activity.device;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.project.library.core.APPCoreServiceListener;
import com.project.library.core.CoreServiceProxy;
import com.project.library.device.cmd.appcontrol.AppControlCmd;
import com.project.library.util.DebugLog;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.util.VibratorUtil;

public class FindWristbandActivity
  extends BaseActivity
{
  private static final byte MODE_EXIT = 1;
  private static final byte MODE_OPEN = 0;
  private APPCoreServiceListener mAppListener = new APPCoreServiceListener()
  {
    public void onAppControlSuccess(byte paramAnonymousByte, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousByte == 4) && (paramAnonymousBoolean)) {
        new Handler().postDelayed(new Runnable()
        {
          public void run()
          {
            FindWristbandActivity.this.finish();
          }
        }, 10000L);
      }
    }
    
    public void onBLEConnected()
    {
      DebugLog.e("发送命令：" + AppControlCmd.getInstance().getSearchWristbandCmd((byte)0));
    }
    
    public void onBLEDisConnected(String paramAnonymousString) {}
    
    public void onBleControlReceive(byte paramAnonymousByte1, byte paramAnonymousByte2)
    {
      if (paramAnonymousByte1 == 2) {
        VibratorUtil.Vibrate(FindWristbandActivity.this, 1000L);
      }
    }
    
    public void onDataSendTimeOut(byte[] paramAnonymousArrayOfByte) {}
  };
  private ImageView mBarLeft;
  protected CoreServiceProxy mCore = CoreServiceProxy.getInstance();
  private ImageView radar;
  private TextView signalStrength;
  
  protected void initData()
  {
    super.initData();
    Animation localAnimation = AnimationUtils.loadAnimation(this, 2130968588);
    this.radar.setAnimation(localAnimation);
    this.signalStrength.setText(getString(2131296641, new Object[] { Integer.valueOf(76) }));
    this.mCore.writeForce(AppControlCmd.getInstance().getSearchWristbandCmd((byte)0));
  }
  
  protected void initEvent()
  {
    super.initEvent();
    this.mBarLeft.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        FindWristbandActivity.this.finish();
      }
    });
  }
  
  protected void initView()
  {
    super.initView();
    this.radar = ((ImageView)findViewById(2131230774));
    this.signalStrength = ((TextView)findViewById(2131230775));
    this.mBarLeft = ((ImageView)findViewById(2131230729));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.mCore.addListener(this.mAppListener);
    setContentView(2130903052);
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mCore.removeListener(this.mAppListener);
  }
  
  protected void onThemeChanged() {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\device\FindWristbandActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */