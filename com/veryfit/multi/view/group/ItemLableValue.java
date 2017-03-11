package com.veryfit.multi.view.group;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.project.library.util.DebugLog;
import com.veryfit.multi.R.styleable;
import com.veryfit.multi.view.ValueStateTextView;

public class ItemLableValue
  extends RelativeLayout
{
  protected int bottomLineColor;
  protected boolean hasBottomLine;
  protected boolean hasTopLine;
  private String lable;
  private TextView lableView;
  private View.OnClickListener onClick = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      DebugLog.e("onClick : targetActivty = " + ItemLableValue.this.targetActivty);
      if ((ItemLableValue.this.targetActivty != null) && (ItemLableValue.this.valueView.isEnabled()))
      {
        paramAnonymousView = new Intent();
        paramAnonymousView.setClassName(ItemLableValue.this.getContext(), ItemLableValue.this.targetActivty);
        ItemLableValue.this.getContext().startActivity(paramAnonymousView);
      }
    }
  };
  protected Paint paint;
  private String targetActivty;
  protected int topLineColor;
  private String value;
  private ValueStateTextView valueView;
  
  public ItemLableValue(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ItemLableValue(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  protected void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2130903110, this, true);
    this.lableView = ((TextView)findViewById(2131231063));
    this.valueView = ((ValueStateTextView)findViewById(2131231064));
    ImageView localImageView = (ImageView)findViewById(2131231072);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ItemLableValue);
    this.lable = paramContext.getString(2);
    this.value = paramContext.getString(3);
    this.targetActivty = paramContext.getString(6);
    int i = paramContext.getColor(1, 0);
    this.hasBottomLine = paramContext.getBoolean(8, true);
    this.hasTopLine = paramContext.getBoolean(10, false);
    if (this.hasBottomLine)
    {
      this.bottomLineColor = paramContext.getColor(9, getResources().getColor(2131099656));
      initDraw();
    }
    if (this.hasTopLine)
    {
      this.topLineColor = paramContext.getColor(11, getResources().getColor(2131099656));
      initTopDraw();
    }
    paramAttributeSet = paramContext.getDrawable(4);
    Drawable localDrawable = paramContext.getDrawable(5);
    if (localDrawable == null) {
      localImageView.setVisibility(8);
    }
    localImageView.setImageDrawable(localDrawable);
    paramContext.recycle();
    if (paramAttributeSet != null)
    {
      paramAttributeSet.setBounds(0, 0, paramAttributeSet.getIntrinsicWidth(), paramAttributeSet.getIntrinsicHeight());
      this.valueView.setCompoundDrawables(null, null, paramAttributeSet, null);
    }
    if (i != 0) {
      this.valueView.setTextColor(i);
    }
    this.lableView.setText(this.lable);
    this.valueView.setText(this.value);
    if (this.targetActivty != null) {
      setOnClickListener(this.onClick);
    }
  }
  
  protected void initDraw()
  {
    setWillNotDraw(false);
    this.paint = new Paint(1);
    this.paint.setColor(this.bottomLineColor);
    this.paint.setStrokeWidth(2.0F);
  }
  
  protected void initTopDraw()
  {
    setWillNotDraw(false);
    this.paint = new Paint(1);
    this.paint.setColor(this.topLineColor);
    this.paint.setStrokeWidth(2.0F);
  }
  
  public boolean isEnable()
  {
    return this.valueView.isEnabled();
  }
  
  public boolean isOpen()
  {
    return this.valueView.isOpen();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.hasBottomLine) {
      paramCanvas.drawLine(0.0F, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), this.paint);
    }
    if (this.hasTopLine) {
      paramCanvas.drawLine(0.0F, 0.0F, getMeasuredWidth(), 0.0F, this.paint);
    }
  }
  
  public void setEnable(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    this.valueView.setEnabled(paramBoolean);
  }
  
  public void setOpen(boolean paramBoolean)
  {
    this.valueView.setOpen(paramBoolean);
    ValueStateTextView localValueStateTextView = this.valueView;
    if (paramBoolean) {}
    for (int i = 2131296437;; i = 2131296438)
    {
      localValueStateTextView.setText(i);
      return;
    }
  }
  
  public void setValue(String paramString)
  {
    this.valueView.setText(paramString);
  }
  
  public void setValueState(boolean paramBoolean, int paramInt)
  {
    setEnable(paramBoolean);
    setOpen(paramBoolean);
    this.valueView.setText(paramInt);
  }
  
  public void setValueState(boolean paramBoolean, String paramString)
  {
    setEnable(paramBoolean);
    setOpen(paramBoolean);
    this.valueView.setText(paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\group\ItemLableValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */