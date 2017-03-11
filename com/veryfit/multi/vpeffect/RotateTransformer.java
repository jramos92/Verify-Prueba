package com.veryfit.multi.vpeffect;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import com.nineoldandroids.view.ViewHelper;

public class RotateTransformer
  implements ViewPager.PageTransformer
{
  public void transformPage(View paramView, float paramFloat)
  {
    if (paramFloat >= -1.0F)
    {
      if (paramFloat > 0.0F) {
        break label36;
      }
      ViewHelper.setScaleX(paramView, 1.0F + paramFloat);
      ViewHelper.setScaleY(paramView, 1.0F + paramFloat);
      ViewHelper.setRotation(paramView, 360.0F * paramFloat);
    }
    label36:
    while (paramFloat > 1.0F) {
      return;
    }
    ViewHelper.setScaleX(paramView, 1.0F - paramFloat);
    ViewHelper.setScaleY(paramView, 1.0F - paramFloat);
    ViewHelper.setRotation(paramView, 360.0F * paramFloat);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\vpeffect\RotateTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */