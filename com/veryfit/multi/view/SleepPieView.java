package com.veryfit.multi.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.AnimationDrawable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.veryfit.multi.R.styleable;
import com.veryfit.multi.share.AppSharedPreferences;
import com.veryfit.multi.util.Util;
import com.veryfit.multi.vo.SleepData;

public class SleepPieView
  extends RelativeLayout
{
  private TextView awakeTimeView;
  private int colorBg;
  private TextView dataView;
  private TextView fallSleepTimeView;
  private ImageView imageview;
  private Paint paint;
  private String unitHour;
  private String unitMin;
  
  public SleepPieView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130903123, this);
    this.dataView = ((TextView)findViewById(2131231088));
    this.fallSleepTimeView = ((TextView)findViewById(2131231098));
    this.awakeTimeView = ((TextView)findViewById(2131231099));
    this.imageview = ((ImageView)findViewById(2131231097));
    Resources localResources = getResources();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SleepPieView);
    this.colorBg = paramContext.getColor(0, localResources.getColor(2131099662));
    paramContext.recycle();
    this.unitHour = localResources.getString(2131296414);
    this.unitMin = localResources.getString(2131296415);
    this.imageview.setImageResource(2130837700);
    ((AnimationDrawable)this.imageview.getDrawable()).start();
    setWillNotDraw(false);
    this.paint = new Paint(1);
    this.paint.setColor(this.colorBg);
    this.paint.setStyle(Paint.Style.FILL);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, this.paint);
  }
  
  public void setDatas(SleepData paramSleepData)
  {
    int j = paramSleepData.getDuration()[0];
    int i = paramSleepData.getDuration()[1];
    String str = j + this.unitHour + i + this.unitMin;
    SpannableString localSpannableString = new SpannableString(str);
    j = j.length();
    int k = str.indexOf(this.unitMin);
    i = i.length();
    localSpannableString.setSpan(new RelativeSizeSpan(1.3333334F), 0, 0 + j, 33);
    localSpannableString.setSpan(new RelativeSizeSpan(1.3333334F), k - i, k, 33);
    this.dataView.setText(localSpannableString);
    boolean bool = AppSharedPreferences.getInstance().is24TimeMode();
    this.fallSleepTimeView.setText(getResources().getString(2131296579, new Object[] { Util.timeFormatter(paramSleepData.getStartTimeMins(), bool) }));
    this.awakeTimeView.setText(getResources().getString(2131296580, new Object[] { Util.timeFormatter(paramSleepData.getEndTimeMins(), bool) }));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\SleepPieView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */