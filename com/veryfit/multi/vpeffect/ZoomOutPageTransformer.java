package com.veryfit.multi.vpeffect;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

public class ZoomOutPageTransformer
  implements ViewPager.PageTransformer
{
  private static float MIN_ALPHA = 0.5F;
  private static float MIN_SCALE = 0.85F;
  
  public void transformPage(View paramView, float paramFloat)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if (paramFloat < -1.0F)
    {
      paramView.setAlpha(0.0F);
      paramView.setTranslationX(0.0F);
      return;
    }
    if (paramFloat <= 1.0F)
    {
      float f1 = Math.max(MIN_SCALE, 1.0F - Math.abs(paramFloat));
      float f2 = j * (1.0F - f1) / 2.0F;
      float f3 = i * (1.0F - f1) / 2.0F;
      if (paramFloat < 0.0F) {
        paramView.setTranslationX(f3 - f2 / 2.0F);
      }
      for (;;)
      {
        paramView.setScaleX(f1);
        paramView.setScaleY(f1);
        paramView.setAlpha(MIN_ALPHA + (f1 - MIN_SCALE) / (1.0F - MIN_SCALE) * (1.0F - MIN_ALPHA));
        return;
        paramView.setTranslationX(-f3 + f2 / 2.0F);
      }
    }
    paramView.setAlpha(0.0F);
    paramView.setTranslationX(0.0F);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\vpeffect\ZoomOutPageTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */