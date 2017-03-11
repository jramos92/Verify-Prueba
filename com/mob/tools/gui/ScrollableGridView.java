package com.mob.tools.gui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.GridView;

public class ScrollableGridView
  extends GridView
  implements Scrollable
{
  private Scrollable.OnScrollListener osListener;
  private boolean pullEnable;
  
  public ScrollableGridView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public ScrollableGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public ScrollableGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    setCacheColorHint(0);
    setSelector(new ColorDrawable());
    this.osListener = new Scrollable.OnScrollListener()
    {
      public void onScrollChanged(Scrollable paramAnonymousScrollable, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        paramAnonymousScrollable = ScrollableGridView.this;
        if ((paramAnonymousInt2 <= 0) && (paramAnonymousInt4 <= 0)) {}
        for (boolean bool = true;; bool = false)
        {
          ScrollableGridView.access$002(paramAnonymousScrollable, bool);
          return;
        }
      }
    };
  }
  
  protected int computeVerticalScrollOffset()
  {
    int i = super.computeVerticalScrollOffset();
    if (this.osListener != null) {
      this.osListener.onScrollChanged(this, 0, i, 0, 0);
    }
    return i;
  }
  
  public boolean isReadyToPull()
  {
    return this.pullEnable;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\gui\ScrollableGridView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */