package com.veryfit.multi.view.anim;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ExpandAnimation
{
  private static int maxHeight;
  
  public static Animation expand(final View paramView, boolean paramBoolean, long paramLong)
  {
    final int i;
    if (paramBoolean) {
      if (((ViewGroup)paramView).getChildCount() > 0)
      {
        i = maxHeight;
        maxHeight = 0;
      }
    }
    for (paramView.getLayoutParams().height = 0;; paramView.getLayoutParams().height = i)
    {
      paramView.setVisibility(0);
      paramView = new Animation()
      {
        protected void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
        {
          if (this.val$expand) {}
          for (int i = (int)(i * paramAnonymousFloat);; i = (int)(i * (1.0F - paramAnonymousFloat)))
          {
            paramView.getLayoutParams().height = i;
            paramView.requestLayout();
            return;
          }
        }
        
        public boolean willChangeBounds()
        {
          return true;
        }
      };
      paramView.setDuration(paramLong);
      return paramView;
      i = 0;
      break;
      maxHeight = paramView.getMeasuredHeight();
      i = maxHeight;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\anim\ExpandAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */