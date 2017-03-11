package com.veryfit.multi.view.group;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FreshView
  extends LinearLayout
{
  public static final int STATE_CONNING = 7;
  public static final int STATE_DISCONN = 6;
  public static final int STATE_FAILED = 5;
  public static final int STATE_FREE = 2;
  public static final int STATE_FRESHING = 3;
  public static final int STATE_PULLING = 1;
  public static final int STATE_SUCCESS = 4;
  public static final int STATE_UBOUND = 8;
  public static final int STATE_UOPEN = 9;
  private ImageView img;
  private Context mContext;
  private int state;
  private TextView text;
  
  public FreshView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(paramContext).inflate(2130903122, this);
    setOrientation(0);
    setGravity(17);
    setBackgroundColor(getResources().getColor(2131099660));
    this.mContext = paramContext;
    this.img = ((ImageView)findViewById(2131231095));
    this.text = ((TextView)findViewById(2131231096));
  }
  
  public int getState()
  {
    return this.state;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
    this.img.clearAnimation();
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.img.setImageResource(2130837568);
      this.text.setText(2131296567);
      return;
    case 2: 
      this.img.setImageResource(2130837567);
      this.text.setText(2131296568);
      return;
    case 3: 
      this.img.setImageResource(2130837569);
      this.text.setText(String.format(this.mContext.getString(2131296569), new Object[] { "0%" }));
      this.img.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968579));
      return;
    case 4: 
      this.img.setImageBitmap(null);
      this.text.setText(2131296570);
      return;
    case 5: 
      this.img.setImageResource(2130837566);
      this.text.setText(2131296571);
      return;
    case 6: 
      this.img.setImageResource(2130837725);
      this.text.setText(2131296572);
      return;
    case 7: 
      this.img.setImageResource(2130837569);
      this.text.setText(2131296488);
      this.img.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968579));
      return;
    case 8: 
      this.img.setImageResource(2130837569);
      this.text.setText(2131296573);
      this.img.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968579));
      return;
    }
    this.img.setImageResource(2130837569);
    this.text.setText(2131296574);
    this.img.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968579));
  }
  
  public void setState(int paramInt1, int paramInt2)
  {
    this.state = paramInt1;
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      this.img.setImageResource(2130837568);
      this.text.setText(2131296567);
      return;
    case 2: 
      this.img.setImageResource(2130837567);
      this.text.setText(2131296568);
      return;
    }
    this.img.setImageResource(2130837569);
    this.text.setText(String.format(this.mContext.getString(2131296569), new Object[] { paramInt2 + "%" }));
    this.img.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968579));
  }
  
  public void setText(String paramString)
  {
    this.text.setText(paramString);
  }
  
  public void startSyncAnim()
  {
    if (this.state == 3)
    {
      this.img.clearAnimation();
      this.img.setImageResource(2130837569);
      this.img.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968579));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\group\FreshView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */