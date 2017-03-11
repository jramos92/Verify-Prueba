package com.veryfit.multi.vpeffect;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;

public class DefaultTransformer
  implements ViewPager.PageTransformer
{
  public void transformPage(View paramView, float paramFloat)
  {
    paramView.setAlpha(1.0F);
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
    paramView.setPivotX(paramView.getWidth() / 2);
    paramView.setPivotY(paramView.getHeight() / 2);
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setRotation(0.0F);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\vpeffect\DefaultTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */