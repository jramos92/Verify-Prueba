package com.veryfit.multi.ui.activity.device;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.project.library.database.HeartRate;
import com.project.library.database.HeartRateTreshold;
import com.project.library.share.LibSharedPreferences;
import com.veryfit.multi.VeryFitApplication;
import com.veryfit.multi.base.BaseActivity;
import com.veryfit.multi.util.TempUtil;
import com.veryfit.multi.view.LineChartView;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HeartRateActivity
  extends BaseActivity
{
  private int avgHeart = 0;
  private long dt;
  private Handler handler;
  private int heart;
  int i = 0;
  private boolean isDynamicHeart;
  private TextView mAvgRateTv;
  private TextView mHeartBpmTv;
  private LinearLayout mLayoutDynamicHeart;
  private LinearLayout mLayoutMainDownDynamic;
  private RelativeLayout mLayoutMainDownResting;
  private LinearLayout mLayoutRestingHeart;
  LineChartView mLineChartView;
  private TextView mMaxRateTv;
  private int mRestingRate = 0;
  private TextView mRestingRateTv;
  private int maxHeart = 0;
  List<HeartRate> points;
  private TimerTask task;
  private Timer timer = new Timer();
  private TextView title_text;
  
  private int dp2px(int paramInt)
  {
    float f = getResources().getDisplayMetrics().density;
    return (int)(paramInt * f + 0.5F);
  }
  
  private void updatedata()
  {
    Object localObject = Calendar.getInstance();
    long l = ((Calendar)localObject).get(1) * 10000 + (((Calendar)localObject).get(2) + 1) * 100 + ((Calendar)localObject).get(5);
    localObject = TempUtil.getHeartRate(l);
    HeartRateTreshold localHeartRateTreshold = TempUtil.getHeartRateTreshold(l);
    if (localHeartRateTreshold != null)
    {
      int j = localHeartRateTreshold.getMinThreshold();
      int k = localHeartRateTreshold.getAerobicThreshold();
      int m = localHeartRateTreshold.getBurnFatThreshold();
      int n = localHeartRateTreshold.getLimitThreshold();
      int i1 = localHeartRateTreshold.getMaxThreshold();
      this.mLineChartView.SetInfo(new int[] { j, k, m, n, i1 }, (List)localObject);
      return;
    }
    this.mLineChartView.SetInfo((List)localObject);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    setContentView(2130903054);
    super.onCreate(paramBundle);
    Object localObject1 = (LinearLayout)findViewById(2131230779);
    Object localObject5 = (TextView)findViewById(2131230787);
    Object localObject4 = (ImageView)findViewById(2131230788);
    TextView localTextView1 = (TextView)findViewById(2131230789);
    Object localObject3 = (ImageView)findViewById(2131230790);
    TextView localTextView2 = (TextView)findViewById(2131230785);
    ImageView localImageView = (ImageView)findViewById(2131230786);
    TextView localTextView3 = (TextView)findViewById(2131230784);
    this.title_text = ((TextView)findViewById(2131230730));
    paramBundle = (ImageView)findViewById(2131230729);
    this.mHeartBpmTv = ((TextView)findViewById(2131230781));
    this.mRestingRateTv = ((TextView)findViewById(2131230792));
    this.mAvgRateTv = ((TextView)findViewById(2131230793));
    this.mMaxRateTv = ((TextView)findViewById(2131230794));
    paramBundle.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        HeartRateActivity.this.finish();
      }
    });
    Object localObject2 = Calendar.getInstance();
    this.dt = (((Calendar)localObject2).get(1) * 10000 + (((Calendar)localObject2).get(2) + 1) * 100 + ((Calendar)localObject2).get(5));
    VeryFitApplication.getInstance();
    if (VeryFitApplication.date != -1L)
    {
      long l = this.dt;
      VeryFitApplication.getInstance();
      if (l != VeryFitApplication.date)
      {
        VeryFitApplication.getInstance();
        this.dt = VeryFitApplication.date;
      }
    }
    List localList = TempUtil.getHeartRate(this.dt);
    HeartRateTreshold localHeartRateTreshold = TempUtil.getHeartRateTreshold(this.dt);
    paramBundle = null;
    int[] arrayOfInt = new int[5];
    arrayOfInt[1] = 6;
    arrayOfInt[2] = 12;
    arrayOfInt[3] = 18;
    arrayOfInt[4] = 24;
    if (localHeartRateTreshold != null)
    {
      ((TextView)localObject5).setText(localHeartRateTreshold.getAerobicMins() / 60 + getString(2131296408) + localHeartRateTreshold.getAerobicMins() % 60 + getString(2131296409));
      localTextView1.setText(localHeartRateTreshold.getBurnFatMins() / 60 + getString(2131296408) + localHeartRateTreshold.getBurnFatMins() % 60 + getString(2131296409));
      localTextView2.setText(localHeartRateTreshold.getLimitMins() / 60 + getString(2131296408) + localHeartRateTreshold.getLimitMins() % 60 + getString(2131296409));
      this.mRestingRate = localHeartRateTreshold.getSilentHeartRate();
      localTextView3.setText(this.mRestingRate);
      paramBundle = ((ImageView)localObject4).getLayoutParams();
      if ((localHeartRateTreshold.getAerobicMins() == 1) || (localHeartRateTreshold.getAerobicMins() == 2))
      {
        paramBundle.width = 1;
        ((ImageView)localObject4).setLayoutParams(paramBundle);
        ((ImageView)localObject4).setScaleType(ImageView.ScaleType.FIT_XY);
        paramBundle = ((ImageView)localObject3).getLayoutParams();
        if ((localHeartRateTreshold.getBurnFatMins() != 1) && (localHeartRateTreshold.getBurnFatMins() != 2)) {
          break label1124;
        }
        paramBundle.width = 1;
        label589:
        ((ImageView)localObject3).setLayoutParams(paramBundle);
        ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
        paramBundle = localImageView.getLayoutParams();
        if ((localHeartRateTreshold.getLimitMins() != 1) && (localHeartRateTreshold.getLimitMins() != 2)) {
          break label1158;
        }
        paramBundle.width = 1;
        label632:
        localImageView.setLayoutParams(paramBundle);
        localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        paramBundle = new int[6];
        paramBundle[1] = 65;
        paramBundle[2] = localHeartRateTreshold.getBurnFatThreshold();
        paramBundle[3] = localHeartRateTreshold.getAerobicThreshold();
        paramBundle[4] = localHeartRateTreshold.getLimitThreshold();
        paramBundle[5] = 220;
        label686:
        this.mLineChartView = new LineChartView(this);
        if (localHeartRateTreshold == null) {
          break label1410;
        }
        this.mLineChartView.SetInfo(paramBundle, localList);
        label713:
        ((LinearLayout)localObject1).addView(this.mLineChartView);
        this.handler = new Handler()
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            HeartRateActivity.this.updatedata();
            super.handleMessage(paramAnonymousMessage);
          }
        };
        this.task = new TimerTask()
        {
          public void run()
          {
            Message localMessage = new Message();
            localMessage.what = 1;
            HeartRateActivity.this.handler.sendMessage(localMessage);
          }
        };
        ((Calendar)localObject2).get(1);
        ((Calendar)localObject2).get(2);
        ((Calendar)localObject2).get(5);
        paramBundle = TempUtil.getMaxHeartRate(this.dt);
        if ((paramBundle != null) && (paramBundle.size() > 0)) {
          localObject1 = paramBundle.iterator();
        }
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext())
      {
        this.avgHeart = (this.heart / paramBundle.size());
        Log.e("debug", "heart :" + this.heart + "--hear.size()" + paramBundle.size());
        this.maxHeart = ((HeartRate)paramBundle.get(0)).getRate();
        this.isDynamicHeart = LibSharedPreferences.getInstance().getDeviceFunOther2Staticheart();
        this.mLayoutMainDownDynamic = ((LinearLayout)findViewById(2131230783));
        this.mLayoutDynamicHeart = ((LinearLayout)findViewById(2131230782));
        this.mLayoutMainDownResting = ((RelativeLayout)findViewById(2131230791));
        this.mLayoutRestingHeart = ((LinearLayout)findViewById(2131230780));
        if (!this.isDynamicHeart) {
          break label1451;
        }
        this.mLayoutMainDownDynamic.setVisibility(8);
        this.mLayoutDynamicHeart.setVisibility(8);
        this.mLayoutMainDownResting.setVisibility(0);
        this.mLayoutRestingHeart.setVisibility(0);
        this.mHeartBpmTv.setText(this.mRestingRate + " bpm");
        this.mRestingRateTv.setText(this.mRestingRate);
        this.mAvgRateTv.setText(this.avgHeart);
        this.mMaxRateTv.setText(this.maxHeart);
        return;
        paramBundle.width = ((getResources().getDisplayMetrics().widthPixels - dp2px(30)) * localHeartRateTreshold.getAerobicMins() / 1440);
        break;
        label1124:
        paramBundle.width = ((getResources().getDisplayMetrics().widthPixels - dp2px(30)) * localHeartRateTreshold.getBurnFatMins() / 1440);
        break label589;
        label1158:
        paramBundle.width = ((getResources().getDisplayMetrics().widthPixels - dp2px(30)) * localHeartRateTreshold.getLimitMins() / 1440);
        break label632;
        ((TextView)localObject5).setText(0 + getString(2131296408) + 0 + getString(2131296409));
        localTextView1.setText(0 + getString(2131296408) + 0 + getString(2131296409));
        localTextView2.setText(0 + getString(2131296408) + 0 + getString(2131296409));
        localTextView3.setText("0");
        localObject5 = ((ImageView)localObject4).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject5).width = 0;
        ((ImageView)localObject4).setLayoutParams((ViewGroup.LayoutParams)localObject5);
        ((ImageView)localObject4).setScaleType(ImageView.ScaleType.FIT_XY);
        localObject4 = ((ImageView)localObject3).getLayoutParams();
        ((ViewGroup.LayoutParams)localObject4).width = 0;
        ((ImageView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((ImageView)localObject3).setScaleType(ImageView.ScaleType.FIT_XY);
        localObject3 = localImageView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = 0;
        localImageView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        break label686;
        label1410:
        this.mLineChartView.SetInfo(localList);
        break label713;
      }
      localObject2 = (HeartRate)((Iterator)localObject1).next();
      this.heart += ((HeartRate)localObject2).getRate();
    }
    label1451:
    this.mLayoutMainDownDynamic.setVisibility(0);
    this.mLayoutDynamicHeart.setVisibility(0);
    this.mLayoutMainDownResting.setVisibility(8);
    this.mLayoutRestingHeart.setVisibility(8);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.timer.cancel();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.get(1);
    localCalendar.get(2);
    localCalendar.get(5);
  }
  
  protected void onThemeChanged() {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\activity\device\HeartRateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */