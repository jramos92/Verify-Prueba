package com.veryfit.multi.view.anim;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout.LayoutParams;

public class ViewExpandAnimation
  extends Animation
{
  private View mAnimationView = null;
  private int mEnd = 0;
  private int mStart = 0;
  private RelativeLayout.LayoutParams mViewLayoutParams = null;
  
  public ViewExpandAnimation(View paramView)
  {
    animationSettings(paramView, 500);
  }
  
  public ViewExpandAnimation(View paramView, int paramInt)
  {
    animationSettings(paramView, paramInt);
  }
  
  private void animationSettings(View paramView, int paramInt)
  {
    setDuration(paramInt);
    this.mAnimationView = paramView;
    this.mViewLayoutParams = ((RelativeLayout.LayoutParams)paramView.getLayoutParams());
    this.mStart = this.mViewLayoutParams.bottomMargin;
    if (this.mStart == 0) {}
    for (paramInt = 0 - paramView.getHeight();; paramInt = 0)
    {
      this.mEnd = paramInt;
      paramView.setVisibility(0);
      return;
    }
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat < 1.0F)
    {
      this.mViewLayoutParams.bottomMargin = (this.mStart + (int)((this.mEnd - this.mStart) * paramFloat));
      this.mAnimationView.requestLayout();
    }
    do
    {
      return;
      this.mViewLayoutParams.bottomMargin = this.mEnd;
      this.mAnimationView.requestLayout();
    } while (this.mEnd == 0);
    this.mAnimationView.setVisibility(8);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\anim\ViewExpandAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */