package com.veryfit.multi.view.wheel;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.project.library.util.DebugLog;
import com.veryfit.multi.R.styleable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WheelView
  extends View
{
  private static final int ADDITIONAL_ITEMS_SPACE = 10;
  private static final int ADDITIONAL_ITEM_HEIGHT = 15;
  private static final int DEF_VISIBLE_ITEMS = 5;
  private static int ITEMS_TEXT_COLOR = 0;
  private static final int ITEM_OFFSET = TEXT_SIZE / 5;
  private static final int LABEL_OFFSET = 8;
  private static final int MIN_DELTA_FOR_SCROLLING = 1;
  private static final int PADDING = 10;
  private static final int SCROLLING_DURATION = 400;
  private static final int[] SHADOWS_COLORS;
  private static int TEXT_SIZE;
  private static int VALUE_TEXT_COLOR = -1;
  private final int MESSAGE_JUSTIFY = 1;
  private final int MESSAGE_SCROLL = 0;
  private WheelAdapter adapter = null;
  private Handler animationHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      WheelView.this.scroller.computeScrollOffset();
      int i = WheelView.this.scroller.getCurrY();
      int j = WheelView.this.lastScrollY - i;
      WheelView.this.lastScrollY = i;
      if (j != 0) {
        WheelView.this.doScroll(j);
      }
      if (Math.abs(i - WheelView.this.scroller.getFinalY()) < 1)
      {
        WheelView.this.scroller.getFinalY();
        WheelView.this.scroller.forceFinished(true);
      }
      if (!WheelView.this.scroller.isFinished())
      {
        WheelView.this.animationHandler.sendEmptyMessage(paramAnonymousMessage.what);
        return;
      }
      if (paramAnonymousMessage.what == 0)
      {
        WheelView.this.justify();
        return;
      }
      WheelView.this.finishScrolling();
    }
  };
  private GradientDrawable bottomShadow;
  private Drawable centerDrawable;
  private List<OnWheelChangedListener> changingListeners = new LinkedList();
  private int currentItem = 0;
  private GestureDetector gestureDetector;
  private GestureDetector.SimpleOnGestureListener gestureListener = new GestureDetector.SimpleOnGestureListener()
  {
    public boolean onDown(MotionEvent paramAnonymousMotionEvent)
    {
      if (WheelView.this.isScrollingPerformed)
      {
        WheelView.this.scroller.forceFinished(true);
        WheelView.this.clearMessages();
        return true;
      }
      return false;
    }
    
    public boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      WheelView.this.lastScrollY = (WheelView.this.currentItem * WheelView.this.getItemHeight() + WheelView.this.scrollingOffset);
      int i;
      if (WheelView.this.isCyclic)
      {
        i = Integer.MAX_VALUE;
        if (!WheelView.this.isCyclic) {
          break label125;
        }
      }
      label125:
      for (int j = -i;; j = 0)
      {
        WheelView.this.scroller.fling(0, WheelView.this.lastScrollY, 0, (int)-paramAnonymousFloat2 / 2, 0, 0, j, i);
        WheelView.this.setNextMessage(0);
        return true;
        i = WheelView.this.adapter.getItemsCount() * WheelView.this.getItemHeight();
        break;
      }
    }
    
    public boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      WheelView.this.startScrolling();
      WheelView.this.doScroll((int)-paramAnonymousFloat2);
      return true;
    }
  };
  boolean isCyclic = true;
  private boolean isScrollingPerformed;
  public int itemHeight = 0;
  private StaticLayout itemsLayout;
  private TextPaint itemsPaint;
  private int itemsWidth = 0;
  private String label;
  private StaticLayout labelLayout;
  private int labelWidth = 0;
  private int lastScrollY;
  private Scroller scroller;
  private List<OnWheelScrollListener> scrollingListeners = new LinkedList();
  private int scrollingOffset;
  private GradientDrawable topShadow;
  private StaticLayout valueLayout;
  private TextPaint valuePaint;
  private int visibleItems = 5;
  
  static
  {
    ITEMS_TEXT_COLOR = 1291845631;
    SHADOWS_COLORS = new int[] { -15658735, 11184810, 11184810 };
    TEXT_SIZE = 24;
  }
  
  public WheelView(Context paramContext)
  {
    super(paramContext);
    initData(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WheelView);
    TEXT_SIZE = (int)paramAttributeSet.getDimension(0, TEXT_SIZE);
    VALUE_TEXT_COLOR = paramAttributeSet.getColor(2, -1);
    ITEMS_TEXT_COLOR = paramAttributeSet.getColor(3, ITEMS_TEXT_COLOR);
    Drawable localDrawable = paramAttributeSet.getDrawable(1);
    paramAttributeSet.recycle();
    setBackground(localDrawable);
    initData(paramContext);
  }
  
  public WheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initData(paramContext);
  }
  
  private String buildText(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = this.visibleItems / 2 + 1;
    int i = this.currentItem - j;
    for (;;)
    {
      if (i > this.currentItem + j)
      {
        DebugLog.d("..............itemsText:" + localStringBuilder.toString());
        return localStringBuilder.toString();
      }
      if ((paramBoolean) || (i != this.currentItem))
      {
        String str = getTextItem(i);
        if (str != null) {
          localStringBuilder.append(str);
        }
      }
      if (i < this.currentItem + j) {
        localStringBuilder.append("\n");
      }
      i += 1;
    }
  }
  
  private int calculateLayoutWidth(int paramInt1, int paramInt2)
  {
    initResourcesIfNecessary();
    int i = getMaxTextLength();
    int k;
    int j;
    if (i > 0)
    {
      float f = FloatMath.ceil(Layout.getDesiredWidth("0", this.itemsPaint));
      this.itemsWidth = ((int)(i * f));
      this.itemsWidth += 10;
      this.labelWidth = 0;
      if ((this.label != null) && (this.label.length() > 0)) {
        this.labelWidth = ((int)FloatMath.ceil(Layout.getDesiredWidth(this.label, this.valuePaint)));
      }
      k = 0;
      if (paramInt2 != 1073741824) {
        break label205;
      }
      j = 1;
      i = paramInt1;
      label106:
      if (j != 0)
      {
        paramInt1 = i - 8 - 20;
        if (paramInt1 <= 0)
        {
          this.labelWidth = 0;
          this.itemsWidth = 0;
        }
        if (this.labelWidth <= 0) {
          break label286;
        }
        this.itemsWidth = ((int)(this.itemsWidth * paramInt1 / (this.itemsWidth + this.labelWidth)));
        this.labelWidth = (paramInt1 - this.itemsWidth);
      }
    }
    for (;;)
    {
      if (this.itemsWidth > 0) {
        createLayouts(this.itemsWidth, this.labelWidth);
      }
      return i;
      this.itemsWidth = 0;
      break;
      label205:
      j = this.itemsWidth + this.labelWidth + 20;
      i = j;
      if (this.labelWidth > 0) {
        i = j + 8;
      }
      int m = Math.max(i, getSuggestedMinimumWidth());
      j = k;
      i = m;
      if (paramInt2 != Integer.MIN_VALUE) {
        break label106;
      }
      j = k;
      i = m;
      if (paramInt1 >= m) {
        break label106;
      }
      j = 1;
      i = paramInt1;
      break label106;
      label286:
      this.itemsWidth = (paramInt1 + 8);
    }
  }
  
  private void clearMessages()
  {
    this.animationHandler.removeMessages(0);
    this.animationHandler.removeMessages(1);
  }
  
  private void createLayouts(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    DebugLog.d("createLayouts widthItems:" + paramInt1 + ",widthLabel:" + paramInt2);
    Object localObject3;
    Object localObject1;
    if ((this.itemsLayout == null) || (this.itemsLayout.getWidth() > paramInt1))
    {
      localObject3 = buildText(this.isScrollingPerformed);
      TextPaint localTextPaint = this.itemsPaint;
      if (paramInt2 > 0)
      {
        localObject1 = Layout.Alignment.ALIGN_OPPOSITE;
        this.itemsLayout = new StaticLayout((CharSequence)localObject3, localTextPaint, paramInt1, (Layout.Alignment)localObject1, 1.0F, 15.0F, false);
        label97:
        if ((this.isScrollingPerformed) || ((this.valueLayout != null) && (this.valueLayout.getWidth() <= paramInt1))) {
          break label312;
        }
        localObject1 = localObject2;
        if (getAdapter() != null) {
          localObject1 = getAdapter().getItem(this.currentItem);
        }
        if (localObject1 == null) {
          break label296;
        }
        localObject2 = localObject1;
        label153:
        localTextPaint = this.valuePaint;
        if (paramInt2 <= 0) {
          break label304;
        }
        localObject3 = Layout.Alignment.ALIGN_OPPOSITE;
        label168:
        this.valueLayout = new StaticLayout((CharSequence)localObject2, localTextPaint, paramInt1, (Layout.Alignment)localObject3, 1.0F, 15.0F, false);
        DebugLog.d("text:" + (String)localObject1 + ",valueLayout.getWidth():" + this.valueLayout.getWidth());
      }
    }
    for (;;)
    {
      if (paramInt2 > 0)
      {
        if ((this.labelLayout != null) && (this.labelLayout.getWidth() <= paramInt2)) {
          break label338;
        }
        this.labelLayout = new StaticLayout(this.label, this.valuePaint, paramInt2, Layout.Alignment.ALIGN_NORMAL, 1.0F, 15.0F, false);
      }
      return;
      localObject1 = Layout.Alignment.ALIGN_CENTER;
      break;
      this.itemsLayout.increaseWidthTo(paramInt1);
      break label97;
      label296:
      localObject2 = "";
      break label153;
      label304:
      localObject3 = Layout.Alignment.ALIGN_CENTER;
      break label168;
      label312:
      if (this.isScrollingPerformed) {
        this.valueLayout = null;
      } else {
        this.valueLayout.increaseWidthTo(paramInt1);
      }
    }
    label338:
    this.labelLayout.increaseWidthTo(paramInt2);
  }
  
  private void doScroll(int paramInt)
  {
    this.scrollingOffset += paramInt;
    int i = this.scrollingOffset / getItemHeight();
    int j = this.currentItem - i;
    if ((this.isCyclic) && (this.adapter.getItemsCount() > 0)) {
      if (j >= 0)
      {
        paramInt = j % this.adapter.getItemsCount();
        label62:
        j = this.scrollingOffset;
        if (paramInt == this.currentItem) {
          break label229;
        }
        setCurrentItem(paramInt, false);
      }
    }
    for (;;)
    {
      this.scrollingOffset = (j - getItemHeight() * i);
      if (this.scrollingOffset > getHeight()) {
        this.scrollingOffset = (this.scrollingOffset % getHeight() + getHeight());
      }
      return;
      j += this.adapter.getItemsCount();
      break;
      if (this.isScrollingPerformed)
      {
        if (j < 0)
        {
          i = this.currentItem;
          paramInt = 0;
          break label62;
        }
        paramInt = j;
        if (j < this.adapter.getItemsCount()) {
          break label62;
        }
        i = this.currentItem - this.adapter.getItemsCount() + 1;
        paramInt = this.adapter.getItemsCount() - 1;
        break label62;
      }
      paramInt = Math.min(Math.max(j, 0), this.adapter.getItemsCount() - 1);
      break label62;
      label229:
      invalidate();
    }
  }
  
  private void drawCenterRect(Canvas paramCanvas)
  {
    int i = getHeight() / 2;
    int j = getItemHeight() / 2;
    this.centerDrawable.setBounds(-5, i - j, getWidth() + 5, i + j);
    this.centerDrawable.draw(paramCanvas);
  }
  
  private void drawItems(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(0.0F, -this.itemsLayout.getLineTop(1) + this.scrollingOffset);
    this.itemsPaint.setColor(ITEMS_TEXT_COLOR);
    this.itemsPaint.drawableState = getDrawableState();
    this.itemsLayout.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  private void drawShadows(Canvas paramCanvas)
  {
    this.topShadow.setBounds(0, 0, getWidth(), getHeight() / this.visibleItems);
    this.topShadow.draw(paramCanvas);
    this.bottomShadow.setBounds(0, getHeight() - getHeight() / this.visibleItems, getWidth(), getHeight());
    this.bottomShadow.draw(paramCanvas);
  }
  
  private void drawValue(Canvas paramCanvas)
  {
    this.valuePaint.setColor(VALUE_TEXT_COLOR);
    this.valuePaint.drawableState = getDrawableState();
    Rect localRect = new Rect();
    this.itemsLayout.getLineBounds(this.visibleItems / 2, localRect);
    if (this.labelLayout != null)
    {
      paramCanvas.save();
      paramCanvas.translate(this.itemsLayout.getWidth() + 8, localRect.top);
      this.labelLayout.draw(paramCanvas);
      paramCanvas.restore();
    }
    if (this.valueLayout != null)
    {
      paramCanvas.save();
      paramCanvas.translate(0.0F, localRect.top + this.scrollingOffset);
      this.valueLayout.draw(paramCanvas);
      paramCanvas.restore();
    }
  }
  
  private int getDesiredHeight(Layout paramLayout)
  {
    if (paramLayout == null) {
      return 0;
    }
    return Math.max(getItemHeight() * this.visibleItems - ITEM_OFFSET * 2 - 15, getSuggestedMinimumHeight());
  }
  
  private int getItemHeight()
  {
    if (this.itemHeight != 0) {
      return this.itemHeight;
    }
    if ((this.itemsLayout != null) && (this.itemsLayout.getLineCount() > 2))
    {
      this.itemHeight = (this.itemsLayout.getLineTop(2) - this.itemsLayout.getLineTop(1));
      return this.itemHeight;
    }
    return getHeight() / this.visibleItems;
  }
  
  private int getMaxTextLength()
  {
    WheelAdapter localWheelAdapter = getAdapter();
    if (localWheelAdapter == null) {
      return 0;
    }
    int i = localWheelAdapter.getMaximumLength();
    if (i > 0) {
      return i;
    }
    Object localObject1 = null;
    i = this.visibleItems / 2;
    i = Math.max(this.currentItem - i, 0);
    for (;;)
    {
      if (i >= Math.min(this.currentItem + this.visibleItems, localWheelAdapter.getItemsCount()))
      {
        if (localObject1 == null) {
          break;
        }
        return ((String)localObject1).length();
      }
      String str = localWheelAdapter.getItem(i);
      Object localObject2 = localObject1;
      if (str != null) {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          if (((String)localObject1).length() >= str.length()) {}
        }
        else
        {
          localObject2 = str;
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
  }
  
  private String getTextItem(int paramInt)
  {
    if ((this.adapter == null) || (this.adapter.getItemsCount() == 0)) {}
    int j;
    do
    {
      return null;
      j = this.adapter.getItemsCount();
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < j) {
          break;
        }
      }
    } while (!this.isCyclic);
    int i = paramInt;
    for (;;)
    {
      if (i >= 0) {
        return this.adapter.getItem(i % j);
      }
      i += j;
    }
  }
  
  private void initData(Context paramContext)
  {
    this.gestureDetector = new GestureDetector(paramContext, this.gestureListener);
    this.gestureDetector.setIsLongpressEnabled(false);
    this.scroller = new Scroller(paramContext, new DecelerateInterpolator(0.1F));
  }
  
  private void initResourcesIfNecessary()
  {
    if (this.itemsPaint == null)
    {
      this.itemsPaint = new TextPaint(1);
      this.itemsPaint.density = getResources().getDisplayMetrics().density;
      this.itemsPaint.setTextSize(TEXT_SIZE);
    }
    if (this.valuePaint == null)
    {
      this.valuePaint = new TextPaint(133);
      this.valuePaint.density = getResources().getDisplayMetrics().density;
      this.valuePaint.setTextSize(TEXT_SIZE);
      this.valuePaint.setStyle(Paint.Style.FILL);
      this.valuePaint.setShadowLayer(0.1F, 0.0F, 0.1F, -4144960);
    }
    if (this.centerDrawable == null) {
      this.centerDrawable = getContext().getResources().getDrawable(2130837736);
    }
    if (this.topShadow == null) {
      this.topShadow = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, SHADOWS_COLORS);
    }
    if (this.bottomShadow == null) {
      this.bottomShadow = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, SHADOWS_COLORS);
    }
  }
  
  private void invalidateLayouts()
  {
    this.itemsLayout = null;
    this.valueLayout = null;
    this.scrollingOffset = 0;
  }
  
  private void justify()
  {
    if (this.adapter == null) {
      return;
    }
    this.lastScrollY = 0;
    int k = this.scrollingOffset;
    int m = getItemHeight();
    int i;
    if (k > 0) {
      if (this.currentItem < this.adapter.getItemsCount())
      {
        i = 1;
        if (!this.isCyclic)
        {
          j = k;
          if (i == 0) {}
        }
        else
        {
          j = k;
          if (Math.abs(k) > m / 2.0F) {
            if (k >= 0) {
              break label136;
            }
          }
        }
      }
    }
    label136:
    for (int j = k + (m + 1);; j = k - (m + 1))
    {
      if (Math.abs(j) <= 1) {
        break label146;
      }
      this.scroller.startScroll(0, 0, 0, j, 400);
      setNextMessage(1);
      return;
      i = 0;
      break;
      if (this.currentItem > 0)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
    }
    label146:
    finishScrolling();
  }
  
  private void setNextMessage(int paramInt)
  {
    clearMessages();
    this.animationHandler.sendEmptyMessage(paramInt);
  }
  
  private void startScrolling()
  {
    if (!this.isScrollingPerformed)
    {
      this.isScrollingPerformed = true;
      notifyScrollingListenersAboutStart();
    }
  }
  
  public void addChangingListener(OnWheelChangedListener paramOnWheelChangedListener)
  {
    this.changingListeners.add(paramOnWheelChangedListener);
  }
  
  public void addScrollingListener(OnWheelScrollListener paramOnWheelScrollListener)
  {
    this.scrollingListeners.add(paramOnWheelScrollListener);
  }
  
  void finishScrolling()
  {
    if (this.isScrollingPerformed)
    {
      notifyScrollingListenersAboutEnd();
      this.isScrollingPerformed = false;
    }
    invalidateLayouts();
    invalidate();
  }
  
  public WheelAdapter getAdapter()
  {
    return this.adapter;
  }
  
  public int getCurrentItem()
  {
    return this.currentItem;
  }
  
  public String getLabel()
  {
    return this.label;
  }
  
  public int getVisibleItems()
  {
    return this.visibleItems;
  }
  
  public boolean isCyclic()
  {
    return this.isCyclic;
  }
  
  protected void notifyChangingListeners(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.changingListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((OnWheelChangedListener)localIterator.next()).onChanged(this, paramInt1, paramInt2);
    }
  }
  
  protected void notifyScrollingListenersAboutEnd()
  {
    Iterator localIterator = this.scrollingListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((OnWheelScrollListener)localIterator.next()).onScrollingFinished(this);
    }
  }
  
  protected void notifyScrollingListenersAboutStart()
  {
    Iterator localIterator = this.scrollingListeners.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return;
      }
      ((OnWheelScrollListener)localIterator.next()).onScrollingStarted(this);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.itemsLayout == null)
    {
      if (this.itemsWidth != 0) {
        break label75;
      }
      calculateLayoutWidth(getWidth(), 1073741824);
    }
    for (;;)
    {
      if (this.itemsWidth > 0)
      {
        paramCanvas.save();
        paramCanvas.translate(10.0F, -ITEM_OFFSET);
        drawItems(paramCanvas);
        drawValue(paramCanvas);
        paramCanvas.restore();
      }
      drawCenterRect(paramCanvas);
      return;
      label75:
      createLayouts(this.itemsWidth, this.labelWidth);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int k = calculateLayoutWidth(paramInt1, i);
    if (j == 1073741824) {
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      setMeasuredDimension(k, paramInt1);
      return;
      i = getDesiredHeight(this.itemsLayout);
      paramInt1 = i;
      if (j == Integer.MIN_VALUE) {
        paramInt1 = Math.min(i, paramInt2);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getAdapter() == null) {}
    while ((this.gestureDetector.onTouchEvent(paramMotionEvent)) || (paramMotionEvent.getAction() != 1)) {
      return true;
    }
    justify();
    return true;
  }
  
  public void removeChangingListener(OnWheelChangedListener paramOnWheelChangedListener)
  {
    this.changingListeners.remove(paramOnWheelChangedListener);
  }
  
  public void removeScrollingListener(OnWheelScrollListener paramOnWheelScrollListener)
  {
    this.scrollingListeners.remove(paramOnWheelScrollListener);
  }
  
  public void scroll(int paramInt1, int paramInt2)
  {
    this.scroller.forceFinished(true);
    this.lastScrollY = this.scrollingOffset;
    int i = getItemHeight();
    this.scroller.startScroll(0, this.lastScrollY, 0, paramInt1 * i - this.lastScrollY, paramInt2);
    setNextMessage(0);
    startScrolling();
  }
  
  public void setAdapter(WheelAdapter paramWheelAdapter)
  {
    this.adapter = paramWheelAdapter;
    invalidateLayouts();
    invalidate();
  }
  
  public void setCurrentItem(int paramInt)
  {
    setCurrentItem(paramInt, false);
  }
  
  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    if ((this.adapter == null) || (this.adapter.getItemsCount() == 0)) {}
    int i;
    do
    {
      return;
      if (paramInt >= 0)
      {
        i = paramInt;
        if (paramInt < this.adapter.getItemsCount()) {
          break;
        }
      }
    } while (!this.isCyclic);
    for (;;)
    {
      if (paramInt >= 0)
      {
        i = paramInt % this.adapter.getItemsCount();
        if (i == this.currentItem) {
          break;
        }
        if (!paramBoolean) {
          break label103;
        }
        scroll(i - this.currentItem, 400);
        return;
      }
      paramInt += this.adapter.getItemsCount();
    }
    label103:
    invalidateLayouts();
    paramInt = this.currentItem;
    this.currentItem = i;
    notifyChangingListeners(paramInt, this.currentItem);
    invalidate();
  }
  
  public void setCyclic(boolean paramBoolean)
  {
    this.isCyclic = paramBoolean;
    invalidate();
    invalidateLayouts();
  }
  
  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.scroller.forceFinished(true);
    this.scroller = new Scroller(getContext(), paramInterpolator);
  }
  
  public void setLabel(String paramString)
  {
    if ((this.label == null) || (!this.label.equals(paramString)))
    {
      this.label = paramString;
      this.labelLayout = null;
      invalidate();
    }
  }
  
  public void setVisibleItems(int paramInt)
  {
    this.visibleItems = paramInt;
    invalidate();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\wheel\WheelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */