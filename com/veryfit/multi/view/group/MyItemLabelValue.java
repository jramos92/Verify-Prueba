package com.veryfit.multi.view.group;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.veryfit.multi.R.styleable;
import com.veryfit.multi.view.CustomToggleButton;
import com.veryfit.multi.view.CustomToggleButton.OnSwitchListener;

public class MyItemLabelValue
  extends RelativeLayout
{
  private int bottomLineColor;
  private boolean hasBottomLine;
  private boolean hasTopLine;
  private boolean isToggleMode = false;
  private ImageView iv_left;
  private ImageView iv_right;
  private String lable;
  private TextView lableView;
  private View.OnClickListener mOnClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (MyItemLabelValue.this.targetActivty != null) {
        MyItemLabelValue.this.getContext().startActivity(new Intent().setClassName(MyItemLabelValue.this.getContext(), MyItemLabelValue.this.targetActivty));
      }
    }
  };
  private OnToggleListener onToggleListener;
  private Paint paint;
  private ProgressBar progressBar;
  private String targetActivty;
  private CustomToggleButton toggleBtn;
  private RelativeLayout toggle_layout;
  private int topLineColor;
  
  public MyItemLabelValue(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MyItemLabelValue(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2130903116, this, true);
    this.lableView = ((TextView)findViewById(2131231083));
    this.iv_left = ((ImageView)findViewById(2131231082));
    this.iv_right = ((ImageView)findViewById(2131231084));
    this.toggle_layout = ((RelativeLayout)findViewById(2131231085));
    this.toggleBtn = ((CustomToggleButton)findViewById(2131230759));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.MyItemLableValue);
    paramAttributeSet = paramContext.getDrawable(0);
    this.iv_left.setImageDrawable(paramAttributeSet);
    this.lable = paramContext.getString(1);
    this.targetActivty = paramContext.getString(4);
    int i = paramContext.getColor(2, -1);
    this.isToggleMode = paramContext.getBoolean(9, false);
    this.hasTopLine = paramContext.getBoolean(7, false);
    this.hasBottomLine = paramContext.getBoolean(6, true);
    if (this.isToggleMode)
    {
      this.iv_right.setVisibility(8);
      this.toggle_layout.setVisibility(0);
      this.progressBar = ((ProgressBar)this.toggle_layout.findViewById(2131230738));
      this.progressBar.setVisibility(8);
    }
    for (;;)
    {
      if (this.hasTopLine)
      {
        this.topLineColor = paramContext.getColor(8, getResources().getColor(2131099656));
        initTopDraw();
      }
      if (this.hasBottomLine)
      {
        this.bottomLineColor = paramContext.getColor(6, getResources().getColor(2131099656));
        initBottomDraw();
      }
      paramContext.recycle();
      if (i != 0) {
        this.lableView.setTextColor(i);
      }
      this.lableView.setText(this.lable);
      if (this.targetActivty != null)
      {
        setClickable(true);
        setOnClickListener(this.mOnClickListener);
      }
      this.toggleBtn.setOnSwitchListener(new CustomToggleButton.OnSwitchListener()
      {
        public void onSwitched(boolean paramAnonymousBoolean)
        {
          if (MyItemLabelValue.this.onToggleListener != null) {
            MyItemLabelValue.this.onToggleListener.onToggle(paramAnonymousBoolean);
          }
        }
      });
      return;
      this.toggle_layout.setVisibility(8);
      this.iv_right.setVisibility(0);
    }
  }
  
  private void initBottomDraw()
  {
    setWillNotDraw(false);
    this.paint = new Paint(1);
    this.paint.setColor(this.bottomLineColor);
    this.paint.setStrokeWidth(2.0F);
  }
  
  private void initTopDraw()
  {
    setWillNotDraw(false);
    this.paint = new Paint(1);
    this.paint.setColor(this.topLineColor);
    this.paint.setStrokeWidth(2.0F);
  }
  
  public void cancelProgressBar()
  {
    this.progressBar.setVisibility(8);
  }
  
  public boolean isOpen()
  {
    return this.toggleBtn.getSwitchState();
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
  
  public void setLabelText(int paramInt)
  {
    this.lableView.setText(paramInt);
  }
  
  public void setLabelText(String paramString)
  {
    this.lableView.setText(paramString);
  }
  
  public void setOnToggleListener(OnToggleListener paramOnToggleListener)
  {
    this.onToggleListener = paramOnToggleListener;
  }
  
  public void setOpen(boolean paramBoolean)
  {
    this.toggleBtn.setSwitchState(paramBoolean);
  }
  
  public void showProgressBar()
  {
    this.progressBar.setVisibility(0);
  }
  
  public static abstract interface OnToggleListener
  {
    public abstract void onToggle(boolean paramBoolean);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\group\MyItemLabelValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */