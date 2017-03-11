package com.veryfit.multi.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.Constant;
import com.veryfit.multi.util.NetUtils;
import com.veryfit.multi.util.ShareCtrl;
import com.veryfit.multi.util.ShareCtrl.OnShareListener;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.view.CircleImageView;
import com.veryfit.multi.view.DialogUtil;
import com.veryfit.multi.view.DialogUtil.OnShareSelectListener;
import com.veryfit.multi.view.RebView;
import com.veryfit.multi.view.RebView.Data;
import com.veryfit.multi.view.SportPieView;
import com.veryfit.multi.vo.SportData;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ShareAcitvity
  extends BaseActivity
  implements ShareCtrl.OnShareListener
{
  private int goal = 10000;
  private CircleImageView header;
  private TextView name_date;
  private SportPieView pie;
  private RebView rebView;
  private SportData sportData;
  
  protected void initData()
  {
    super.initData();
    String str = AppSharedPreferences.getInstance().getUserName();
    Object localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "游客";
    }
    this.name_date.setText(localObject + "@" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    localObject = BitmapFactory.decodeFile(Constant.PIC_PATH + DialogUtil.photoPath);
    if (localObject != null) {
      this.header.setImageBitmap((Bitmap)localObject);
    }
    for (;;)
    {
      this.sportData = TempUtil.getSprotByDate(Calendar.getInstance(), 0);
      this.goal = TempUtil.getGoal(com.project.library.util.LongDateUtil.Calendar2LongDate(this.sportData.date))[0];
      this.pie.setGoal(this.goal);
      this.pie.setSteps(this.sportData.steps, true);
      this.rebView.datas = new RebView.Data[3];
      this.rebView.datas[0] = new RebView.Data(getString(2131296648, new Object[] { Float.valueOf(this.sportData.distance * 1.0F) }), getString(2131296651));
      this.rebView.datas[1] = new RebView.Data(getString(2131296649, new Object[] { Float.valueOf(this.sportData.activityTime / 60.0F) }), getString(2131296652));
      this.rebView.datas[2] = new RebView.Data(getString(2131296650, new Object[] { Float.valueOf(this.sportData.calorie * 1.0F) }), getString(2131296653));
      this.rebView.setData(this.rebView.datas);
      return;
      this.header.setImageBitmap(BitmapFactory.decodeResource(getResources(), 2130837537));
    }
  }
  
  protected void initFirst()
  {
    super.initFirst();
  }
  
  protected void initView()
  {
    super.initView();
    this.rebView = ((RebView)findViewById(2131230885));
    this.pie = ((SportPieView)findViewById(2131230884));
    this.header = ((CircleImageView)findViewById(2131230731));
    this.name_date = ((TextView)findViewById(2131230883));
    DialogUtil.showShareDialog(this, new DialogUtil.OnShareSelectListener()
    {
      public void onCancel()
      {
        ShareAcitvity.this.finish();
      }
      
      public void onShareSelect(int paramAnonymousInt)
      {
        ShareAcitvity.this.shareTo(paramAnonymousInt);
      }
    });
  }
  
  public void onCancel(int paramInt)
  {
    switch (paramInt)
    {
    }
  }
  
  public void onComplete(final int paramInt)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        switch (paramInt)
        {
        }
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903070);
    super.onCreate(paramBundle);
  }
  
  public void onError(int paramInt) {}
  
  protected void onThemeChanged() {}
  
  public void shareTo(int paramInt)
  {
    if (NetUtils.isConnected(this))
    {
      switch (paramInt)
      {
      case 4: 
      default: 
        return;
      case 5: 
        ShareCtrl.shareToFacebook(this, this);
        return;
      case 2: 
        ShareCtrl.shareToWeChat(this, this);
        return;
      case 3: 
        ShareCtrl.shareToMoments(this, this);
        return;
      case 1: 
        ShareCtrl.shareToQQ(this, this);
        return;
      }
      ShareCtrl.shareToTwitter(this, this);
      return;
    }
    Toast.makeText(this, 2131296632, 0).show();
  }
  
  public void showToastShort(int paramInt)
  {
    Toast.makeText(this, paramInt, 0).show();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\ShareAcitvity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */