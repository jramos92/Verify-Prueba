package com.veryfit.multi.vpeffect;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

public class InRightUpTransformer
  implements ViewPager.PageTransformer
{
  public void transformPage(View paramView, float paramFloat)
  {
    int i = paramView.getHeight();
    if (paramFloat < -1.0F)
    {
      paramView.setAlpha(1.0F);
      paramView.setTranslationY(0.0F);
      return;
    }
    if (paramFloat <= 0.0F)
    {
      paramView.setTranslationY(i * -paramFloat);
      paramView.setAlpha(1.0F + paramFloat);
      return;
    }
    if (paramFloat <= 1.0F)
    {
      paramView.setTranslationY(paramView.getHeight() * -paramFloat);
      paramView.setAlpha(1.0F - paramFloat);
      return;
    }
    paramView.setTranslationY(0.0F);
    paramView.setAlpha(1.0F);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\vpeffect\InRightUpTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */