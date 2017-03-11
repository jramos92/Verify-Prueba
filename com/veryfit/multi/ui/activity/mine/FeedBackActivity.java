package com.veryfit.multi.ui.activity.mine;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.view.BufferDialog;
import com.veryfit.multi.view.CustomToggleButton;
import com.veryfit.multi.view.CustomToggleButton.OnSwitchListener;

public class FeedBackActivity
  extends Activity
{
  private LinearLayout llSendEmail;
  private BufferDialog mBufferDialog;
  private Handler mHandler = new Handler();
  private AppSharedPreferences share = AppSharedPreferences.getInstance();
  private CustomToggleButton toggleBtn1;
  
  public void addListener()
  {
    this.toggleBtn1.setOnSwitchListener(new CustomToggleButton.OnSwitchListener()
    {
      public void onSwitched(boolean paramAnonymousBoolean)
      {
        FeedBackActivity.this.share.setSendLog(paramAnonymousBoolean);
      }
    });
    this.llSendEmail.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new SendLogModel(FeedBackActivity.this);
        if (FeedBackActivity.this.share.getSendLog())
        {
          paramAnonymousView.sendLogToEmail();
          return;
        }
        paramAnonymousView.realSendToEmail(false);
      }
    });
  }
  
  public void initView()
  {
    this.toggleBtn1 = ((CustomToggleButton)findViewById(2131230759));
    CustomToggleButton localCustomToggleButton = this.toggleBtn1;
    if (this.share.getSendLog()) {}
    for (boolean bool = true;; bool = false)
    {
      localCustomToggleButton.setSwitchState(bool);
      this.llSendEmail = ((LinearLayout)findViewById(2131230760));
      findViewById(2131230729).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          FeedBackActivity.this.finish();
        }
      });
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903048);
    initView();
    addListener();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\mine\FeedBackActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */