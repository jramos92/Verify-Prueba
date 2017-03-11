package com.veryfit.multi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ScrollView;
import com.project.library.util.DebugLog;

public class MainPageScrollView
  extends ScrollView
{
  private int freshHeight;
  private FreshTextView freshView;
  
  public MainPageScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getFreshViewHeight()
  {
    if (this.freshHeight == 0) {
      this.freshHeight = this.freshView.getMeasuredHeight();
    }
    return this.freshHeight;
  }
  
  public void init()
  {
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        MainPageScrollView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        MainPageScrollView.this.scrollTo(0, MainPageScrollView.this.getFreshViewHeight());
      }
    });
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    DebugLog.d("t = " + paramInt2 + "******oldt = " + paramInt4 + "****height = " + getFreshViewHeight());
    if ((paramInt2 < getFreshViewHeight()) && (paramInt4 >= getFreshViewHeight()))
    {
      DebugLog.e("*******************");
      this.freshView.setState(1);
    }
    while ((paramInt2 != 0) || (paramInt4 >= getFreshViewHeight())) {
      return;
    }
    this.freshView.setState(2);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\MainPageScrollView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */