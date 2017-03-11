package com.veryfit.multi.ui.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.veryfit.multi.base.BaseActivity;

public class AboutUsActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView mBack;
  private RelativeLayout rl_app;
  private RelativeLayout rl_fun;
  
  protected void initEvent()
  {
    this.mBack.setOnClickListener(this);
    this.rl_fun.setOnClickListener(this);
    this.rl_app.setOnClickListener(this);
  }
  
  protected void initView()
  {
    this.mBack = ((ImageView)findViewById(2131230729));
    this.rl_fun = ((RelativeLayout)findViewById(2131230734));
    this.rl_app = ((RelativeLayout)findViewById(2131230735));
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
    case 2131230735: 
      GuideActivity.startActivity(this, GuideActivity.Guide.App);
      return;
    }
    GuideActivity.startActivity(this, GuideActivity.Guide.Function);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903041);
    super.onCreate(paramBundle);
  }
  
  protected void onThemeChanged() {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\mine\AboutUsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */