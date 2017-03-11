package com.veryfit.multi.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class CustomRadioGroup
  extends LinearLayout
{
  private int mCheckedId = -1;
  private CompoundButton.OnCheckedChangeListener mChildOnCheckedChangeListener;
  private OnCheckedChangeListener mOnCheckedChangeListener;
  private PassThroughHierarchyChangeListener mPassThroughListener;
  private boolean mProtectFromCheckedChange = false;
  
  public CustomRadioGroup(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CustomRadioGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private static CompoundButton findCheckedView(View paramView)
  {
    if ((paramView instanceof CompoundButton)) {
      return (CompoundButton)paramView;
    }
    int i;
    int j;
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      i = 0;
      j = paramView.getChildCount();
    }
    for (;;)
    {
      if (i >= j) {
        return null;
      }
      CompoundButton localCompoundButton = findCheckedView(paramView.getChildAt(i));
      if (localCompoundButton != null) {
        return localCompoundButton;
      }
      i += 1;
    }
  }
  
  private void init()
  {
    this.mCheckedId = -1;
    this.mChildOnCheckedChangeListener = new CheckedStateTracker(null);
    this.mPassThroughListener = new PassThroughHierarchyChangeListener(null);
    super.setOnHierarchyChangeListener(this.mPassThroughListener);
  }
  
  private void setCheckedId(int paramInt)
  {
    this.mCheckedId = paramInt;
    if (this.mOnCheckedChangeListener != null) {
      this.mOnCheckedChangeListener.onCheckedChanged(this, this.mCheckedId);
    }
  }
  
  private void setCheckedStateForView(int paramInt, boolean paramBoolean)
  {
    View localView = findViewById(paramInt);
    if ((localView != null) && ((localView instanceof CompoundButton))) {
      ((CompoundButton)localView).setChecked(paramBoolean);
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    CompoundButton localCompoundButton = findCheckedView(paramView);
    if ((localCompoundButton != null) && (localCompoundButton.isChecked()))
    {
      this.mProtectFromCheckedChange = true;
      if (this.mCheckedId != -1) {
        setCheckedStateForView(this.mCheckedId, false);
      }
      this.mProtectFromCheckedChange = false;
      setCheckedId(localCompoundButton.getId());
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void check(int paramInt)
  {
    if ((paramInt != -1) && (paramInt == this.mCheckedId)) {
      return;
    }
    if (this.mCheckedId != -1) {
      setCheckedStateForView(this.mCheckedId, false);
    }
    if (paramInt != -1) {
      setCheckedStateForView(paramInt, true);
    }
    setCheckedId(paramInt);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public void clearCheck()
  {
    check(-1);
  }
  
  protected LinearLayout.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public int getCheckedRadioButtonId()
  {
    return this.mCheckedId;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if (this.mCheckedId != -1)
    {
      this.mProtectFromCheckedChange = true;
      setCheckedStateForView(this.mCheckedId, true);
      this.mProtectFromCheckedChange = false;
      setCheckedId(this.mCheckedId);
    }
  }
  
  public void setOnCheckedChangeListener(OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.mOnCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.mPassThroughListener.mOnHierarchyChangeListener = paramOnHierarchyChangeListener;
  }
  
  private class CheckedStateTracker
    implements CompoundButton.OnCheckedChangeListener
  {
    private CheckedStateTracker() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (CustomRadioGroup.this.mProtectFromCheckedChange) {
        return;
      }
      CustomRadioGroup.this.mProtectFromCheckedChange = true;
      if (CustomRadioGroup.this.mCheckedId != -1) {
        CustomRadioGroup.this.setCheckedStateForView(CustomRadioGroup.this.mCheckedId, false);
      }
      CustomRadioGroup.this.mProtectFromCheckedChange = false;
      int i = paramCompoundButton.getId();
      CustomRadioGroup.this.setCheckedId(i);
    }
  }
  
  public static class LayoutParams
    extends LinearLayout.LayoutParams
  {
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, float paramFloat)
    {
      super(paramInt2, paramFloat);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    protected void setBaseAttributes(TypedArray paramTypedArray, int paramInt1, int paramInt2)
    {
      if (paramTypedArray.hasValue(paramInt1)) {}
      for (this.width = paramTypedArray.getLayoutDimension(paramInt1, "layout_width"); paramTypedArray.hasValue(paramInt2); this.width = -2)
      {
        this.height = paramTypedArray.getLayoutDimension(paramInt2, "layout_height");
        return;
      }
      this.height = -2;
    }
  }
  
  public static abstract interface OnCheckedChangeListener
  {
    public abstract void onCheckedChanged(CustomRadioGroup paramCustomRadioGroup, int paramInt);
  }
  
  private class PassThroughHierarchyChangeListener
    implements ViewGroup.OnHierarchyChangeListener
  {
    private ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    
    private PassThroughHierarchyChangeListener() {}
    
    @TargetApi(17)
    public void onChildViewAdded(View paramView1, View paramView2)
    {
      if (paramView1 == CustomRadioGroup.this)
      {
        CompoundButton localCompoundButton = CustomRadioGroup.findCheckedView(paramView2);
        if (localCompoundButton != null)
        {
          if ((localCompoundButton.getId() == -1) && (Build.VERSION.SDK_INT >= 17)) {
            localCompoundButton.setId(View.generateViewId());
          }
          localCompoundButton.setOnCheckedChangeListener(CustomRadioGroup.this.mChildOnCheckedChangeListener);
        }
      }
      if (this.mOnHierarchyChangeListener != null) {
        this.mOnHierarchyChangeListener.onChildViewAdded(paramView1, paramView2);
      }
    }
    
    public void onChildViewRemoved(View paramView1, View paramView2)
    {
      if (paramView1 == CustomRadioGroup.this)
      {
        CompoundButton localCompoundButton = CustomRadioGroup.findCheckedView(paramView2);
        if (localCompoundButton != null) {
          localCompoundButton.setOnCheckedChangeListener(null);
        }
      }
      if (this.mOnHierarchyChangeListener != null) {
        this.mOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\CustomRadioGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */