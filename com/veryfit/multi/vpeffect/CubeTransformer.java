package com.veryfit.multi.vpeffect;

import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import com.nineoldandroids.view.ViewHelper;

public class CubeTransformer
  implements ViewPager.PageTransformer
{
  public void transformPage(View paramView, float paramFloat)
  {
    if (paramFloat <= 0.0F)
    {
      ViewHelper.setPivotX(paramView, paramView.getMeasuredWidth());
      ViewHelper.setPivotY(paramView, paramView.getMeasuredHeight() * 0.5F);
      ViewHelper.setRotationY(paramView, 90.0F * paramFloat);
    }
    while (paramFloat > 1.0F) {
      return;
    }
    ViewHelper.setPivotX(paramView, 0.0F);
    ViewHelper.setPivotY(paramView, paramView.getMeasuredHeight() * 0.5F);
    ViewHelper.setRotationY(paramView, 90.0F * paramFloat);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\vpeffect\CubeTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */