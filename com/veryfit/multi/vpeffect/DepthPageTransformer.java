package com.veryfit.multi.vpeffect;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

public class DepthPageTransformer
  implements ViewPager.PageTransformer
{
  private static float MIN_SCALE = 0.5F;
  
  public void transformPage(View paramView, float paramFloat)
  {
    int i = paramView.getWidth();
    if (paramFloat < -1.0F)
    {
      paramView.setAlpha(0.0F);
      paramView.setTranslationX(0.0F);
      return;
    }
    if (paramFloat <= 0.0F)
    {
      paramView.setAlpha(1.0F);
      paramView.setTranslationX(0.0F);
      paramView.setScaleX(1.0F);
      paramView.setScaleY(1.0F);
      return;
    }
    if (paramFloat <= 1.0F)
    {
      paramView.setAlpha(1.0F - paramFloat);
      paramView.setTranslationX(i * -paramFloat);
      paramFloat = MIN_SCALE + (1.0F - MIN_SCALE) * (1.0F - Math.abs(paramFloat));
      paramView.setScaleX(paramFloat);
      paramView.setScaleY(paramFloat);
      return;
    }
    paramView.setAlpha(0.0F);
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\vpeffect\DepthPageTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */