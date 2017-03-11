package com.veryfit.multi.view.group;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.veryfit.multi.R.styleable;
import com.veryfit.multi.view.CustomToggleButton;
import com.veryfit.multi.view.CustomToggleButton.OnSwitchListener;

public class ItemToggleLayout
  extends ItemLableValue
{
  private TextView lableView;
  private OnToggleListener onToggleListener;
  private ProgressBar progressBar;
  private CustomToggleButton toggleBtn;
  
  public ItemToggleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void cancelProgressBar()
  {
    this.progressBar.setVisibility(8);
  }
  
  protected void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2130903112, this, true);
    this.lableView = ((TextView)findViewById(2131231063));
    this.toggleBtn = ((CustomToggleButton)findViewById(2131230759));
    this.progressBar = ((ProgressBar)findViewById(2131230738));
    ImageView localImageView = (ImageView)findViewById(2131231072);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ItemLableValue);
    paramAttributeSet = paramContext.getString(2);
    this.hasBottomLine = paramContext.getBoolean(8, true);
    if (this.hasBottomLine)
    {
      this.bottomLineColor = paramContext.getColor(9, getResources().getColor(2131099656));
      initDraw();
    }
    Drawable localDrawable = paramContext.getDrawable(5);
    paramContext.recycle();
    localImageView.setImageDrawable(localDrawable);
    this.lableView.setText(paramAttributeSet);
    this.toggleBtn.setOnSwitchListener(new CustomToggleButton.OnSwitchListener()
    {
      public void onSwitched(boolean paramAnonymousBoolean)
      {
        if (ItemToggleLayout.this.onToggleListener != null) {
          ItemToggleLayout.this.onToggleListener.onToggle(paramAnonymousBoolean);
        }
      }
    });
    this.progressBar.setVisibility(8);
  }
  
  public boolean isOpen()
  {
    return this.toggleBtn.getSwitchState();
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\group\ItemToggleLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */