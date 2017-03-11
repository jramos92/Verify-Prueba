package com.veryfit.multi.ui.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.util.Constant;
import com.veryfit.multi.util.UpdateApkUtil;
import com.veryfit.multi.vo.AppUpdateInfo;
import java.io.File;

public class AppUpdateActivity
  extends BaseActivity
{
  public static final String UPDATEINFO = "updateInfo";
  private AppUpdateInfo apInfo;
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
        AppUpdateActivity.this.progressBar.setProgress(i);
        AppUpdateActivity.this.progressView.setText(i + "%");
        Log.d("abc", "Down load apk:" + i);
        return;
      case 2: 
        UpdateApkUtil.InstallNewApp(AppUpdateActivity.this, new File(Constant.FILE_PATH, "VeryFitMulti.apk"));
        return;
      }
      Toast.makeText(AppUpdateActivity.this, AppUpdateActivity.this.getString(((Integer)paramAnonymousMessage.obj).intValue()), 0).show();
    }
  };
  private ProgressBar progressBar;
  private TextView progressView;
  private Button update;
  
  public void downLoadApk(String paramString1, String paramString2)
  {
    UpdateApkUtil.downloadApk(this.handler, paramString1, paramString2);
  }
  
  public void downLoadNewApk()
  {
    Toast.makeText(this, "下载apk", 0).show();
    File localFile = new File(Constant.APK_PATH);
    if (localFile.exists()) {
      localFile.delete();
    }
    localFile = new File(Constant.FILE_PATH);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    if (!new File(Constant.APK_PATH).exists()) {
      new Thread(new Runnable()
      {
        public void run()
        {
          AppUpdateActivity.this.downLoadApk(Constant.APK_PATH, AppUpdateActivity.this.apInfo.getUrl());
        }
      }).start();
    }
  }
  
  protected void initData()
  {
    super.initData();
  }
  
  protected void initEvent()
  {
    this.update.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        new Thread(new Runnable()
        {
          public void run()
          {
            File localFile = new File(Constant.FILE_PATH);
            if (!localFile.exists()) {
              localFile.mkdir();
            }
            AppUpdateActivity.this.downLoadApk(Constant.APK_PATH, AppUpdateActivity.this.apInfo.getUrl());
          }
        }).start();
      }
    });
    super.initEvent();
  }
  
  protected void initView()
  {
    this.update = ((Button)findViewById(2131230755));
    this.progressView = ((TextView)findViewById(2131230757));
    this.progressBar = ((ProgressBar)findViewById(2131230756));
    this.progressBar.setMax(100);
    TextView localTextView1 = (TextView)findViewById(2131230749);
    TextView localTextView2 = (TextView)findViewById(2131230751);
    TextView localTextView3 = (TextView)findViewById(2131230752);
    localTextView1.setText(UpdateApkUtil.getAppVersionName(this));
    localTextView2.setText(this.apInfo.getVersionName());
    localTextView3.setText(this.apInfo.getUpdateInfo_cn());
    findViewById(2131230754).setVisibility(8);
    ((TextView)findViewById(2131230730)).setText(getString(2131296541));
    super.initView();
  }
  
  public void onClick(View paramView)
  {
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903046);
    this.apInfo = ((AppUpdateInfo)getIntent().getSerializableExtra("updateInfo"));
    super.onCreate(paramBundle);
  }
  
  protected void onThemeChanged() {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\mine\AppUpdateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */