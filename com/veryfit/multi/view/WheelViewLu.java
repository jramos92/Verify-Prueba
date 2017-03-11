package com.veryfit.multi.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WheelViewLu
  extends ScrollView
{
  public static final int OFF_SET_DEFAULT = 1;
  private static final int SCROLL_DIRECTION_DOWN = 1;
  private static final int SCROLL_DIRECTION_UP = 0;
  public static final String TAG = WheelViewLu.class.getSimpleName();
  private Context context;
  int displayItemCount;
  private DisplayMetrics dm;
  int initialY;
  int itemHeight = 0;
  List<String> items;
  private int mt;
  int newCheck = 50;
  int offset = 1;
  private OnWheelViewListener onWheelViewListener;
  Paint paint;
  private int scrollDirection = -1;
  Runnable scrollerTask;
  int[] selectedAreaBorder;
  int selectedIndex = 1;
  int viewWidth;
  private LinearLayout views;
  
  public WheelViewLu(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public WheelViewLu(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public WheelViewLu(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private TextView createView(String paramString)
  {
    TextView localTextView = new TextView(this.context);
    localTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    localTextView.setSingleLine(true);
    localTextView.setTextSize(2, 24.0F);
    localTextView.setText(paramString);
    localTextView.setGravity(17);
    if (this.itemHeight == 0)
    {
      this.itemHeight = getViewMeasuredHeight(localTextView);
      Log.d(TAG, "itemHeight: " + this.itemHeight);
      this.views.setLayoutParams(new FrameLayout.LayoutParams(-1, this.itemHeight * this.displayItemCount));
      setLayoutParams(new LinearLayout.LayoutParams(((LinearLayout.LayoutParams)getLayoutParams()).width, this.itemHeight * this.displayItemCount));
    }
    return localTextView;
  }
  
  private int dip2px(float paramFloat)
  {
    return (int)(paramFloat * this.context.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  private List<String> getItems()
  {
    return this.items;
  }
  
  private int getViewMeasuredHeight(View paramView)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    return paramView.getMeasuredHeight();
  }
  
  private void init(Context paramContext)
  {
    this.context = paramContext;
    this.dm = paramContext.getResources().getDisplayMetrics();
    Log.d(TAG, "parent: " + getParent());
    setVerticalScrollBarEnabled(false);
    this.views = new LinearLayout(paramContext);
    this.views.setOrientation(1);
    addView(this.views);
    this.scrollerTask = new Runnable()
    {
      public void run()
      {
        final int i = WheelViewLu.this.getScrollY();
        if (WheelViewLu.this.initialY - i == 0)
        {
          i = WheelViewLu.this.initialY % WheelViewLu.this.itemHeight;
          final int j = WheelViewLu.this.initialY / WheelViewLu.this.itemHeight;
          if (i == 0)
          {
            WheelViewLu.this.selectedIndex = (WheelViewLu.this.offset + j);
            WheelViewLu.this.onSeletedCallBack();
            return;
          }
          if (i > WheelViewLu.this.itemHeight / 2)
          {
            WheelViewLu.this.post(new Runnable()
            {
              public void run()
              {
                WheelViewLu.this.smoothScrollTo(0, WheelViewLu.this.initialY - i + WheelViewLu.this.itemHeight);
                WheelViewLu.this.selectedIndex = (j + WheelViewLu.this.offset + 1);
                WheelViewLu.this.onSeletedCallBack();
              }
            });
            return;
          }
          WheelViewLu.this.post(new Runnable()
          {
            public void run()
            {
              WheelViewLu.this.smoothScrollTo(0, WheelViewLu.this.initialY - i);
              WheelViewLu.this.selectedIndex = (j + WheelViewLu.this.offset);
              WheelViewLu.this.onSeletedCallBack();
            }
          });
          return;
        }
        WheelViewLu.this.initialY = WheelViewLu.this.getScrollY();
        WheelViewLu.this.postDelayed(WheelViewLu.this.scrollerTask, WheelViewLu.this.newCheck);
      }
    };
  }
  
  private void initData()
  {
    this.displayItemCount = (this.offset * 2 + 1);
    this.views.removeAllViews();
    Iterator localIterator = this.items.iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        refreshItemView(0);
        return;
      }
      String str = (String)localIterator.next();
      this.views.addView(createView(str));
    }
  }
  
  private int[] obtainSelectedAreaBorder()
  {
    if (this.selectedAreaBorder == null)
    {
      this.selectedAreaBorder = new int[2];
      this.selectedAreaBorder[0] = (this.itemHeight * this.offset);
      this.selectedAreaBorder[1] = (this.itemHeight * (this.offset + 1));
    }
    return this.selectedAreaBorder;
  }
  
  private void onSeletedCallBack()
  {
    if (this.onWheelViewListener != null) {
      this.onWheelViewListener.onSelected(this.selectedIndex, (String)this.items.get(this.selectedIndex));
    }
  }
  
  public void fling(int paramInt)
  {
    super.fling(paramInt / 3);
  }
  
  public int getOffset()
  {
    return this.offset;
  }
  
  public OnWheelViewListener getOnWheelViewListener()
  {
    return this.onWheelViewListener;
  }
  
  public int getSeletedIndex()
  {
    return this.selectedIndex - this.offset;
  }
  
  public String getSeletedItem()
  {
    return (String)this.items.get(this.selectedIndex);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d(TAG, "l: " + paramInt1 + ", t: " + paramInt2 + ", oldl: " + paramInt3 + ", oldt: " + paramInt4);
    this.mt = paramInt2;
    refreshItemView(paramInt2);
    if (paramInt2 > paramInt4)
    {
      this.scrollDirection = 1;
      return;
    }
    this.scrollDirection = 0;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.d(TAG, "w: " + paramInt1 + ", h: " + paramInt2 + ", oldw: " + paramInt3 + ", oldh: " + paramInt4);
    this.viewWidth = paramInt1;
    setBackgroundDrawable(null);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      startScrollerTask();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void refreshItemView(int paramInt)
  {
    int i = paramInt / this.itemHeight + this.offset;
    int j = paramInt % this.itemHeight;
    int k = paramInt / this.itemHeight;
    if (j == 0)
    {
      paramInt = k + this.offset;
      j = this.views.getChildCount();
      i = 0;
      if (i < j) {
        break label80;
      }
    }
    label80:
    TextView localTextView;
    do
    {
      return;
      paramInt = i;
      if (j <= this.itemHeight / 2) {
        break;
      }
      paramInt = this.offset + k + 1;
      break;
      localTextView = (TextView)this.views.getChildAt(i);
    } while (localTextView == null);
    if (paramInt == i) {
      localTextView.setTextColor(Color.parseColor("#000000"));
    }
    for (;;)
    {
      i += 1;
      break;
      localTextView.setTextColor(Color.parseColor("#bbbbbb"));
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.viewWidth == 0)
    {
      this.viewWidth = ((Activity)this.context).getWindowManager().getDefaultDisplay().getWidth();
      Log.d(TAG, "viewWidth: " + this.viewWidth);
    }
    if (this.paint == null)
    {
      this.paint = new Paint();
      this.paint.setColor(Color.parseColor("#000000"));
      this.paint.setStrokeWidth(dip2px(0.5F));
    }
    super.setBackgroundDrawable(new Drawable()
    {
      public void draw(Canvas paramAnonymousCanvas)
      {
        paramAnonymousCanvas.drawLine(0.0F, WheelViewLu.this.obtainSelectedAreaBorder()[0], WheelViewLu.this.viewWidth, WheelViewLu.this.obtainSelectedAreaBorder()[0], WheelViewLu.this.paint);
        paramAnonymousCanvas.drawLine(0.0F, WheelViewLu.this.obtainSelectedAreaBorder()[1], WheelViewLu.this.viewWidth, WheelViewLu.this.obtainSelectedAreaBorder()[1], WheelViewLu.this.paint);
      }
      
      public int getOpacity()
      {
        return 0;
      }
      
      public void setAlpha(int paramAnonymousInt) {}
      
      public void setColorFilter(ColorFilter paramAnonymousColorFilter) {}
    });
  }
  
  public void setItems(List<String> paramList)
  {
    if (this.items == null) {
      this.items = new ArrayList();
    }
    this.items.clear();
    this.items.addAll(paramList);
    this.items.add(0, "");
    this.items.add("");
    initData();
  }
  
  public void setOffset(int paramInt)
  {
    this.offset = paramInt;
  }
  
  public void setOnWheelViewListener(OnWheelViewListener paramOnWheelViewListener)
  {
    this.onWheelViewListener = paramOnWheelViewListener;
  }
  
  public void setSeletion(final int paramInt)
  {
    this.selectedIndex = (this.offset + paramInt);
    post(new Runnable()
    {
      public void run()
      {
        WheelViewLu.this.smoothScrollTo(0, paramInt * WheelViewLu.this.itemHeight);
      }
    });
  }
  
  public void startScrollerTask()
  {
    this.initialY = getScrollY();
    postDelayed(this.scrollerTask, this.newCheck);
  }
  
  public static class OnWheelViewListener
  {
    public void onSelected(int paramInt, String paramString) {}
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\WheelViewLu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */