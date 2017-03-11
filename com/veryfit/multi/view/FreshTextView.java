package com.veryfit.multi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class FreshTextView
  extends TextView
{
  private static final int[] FREE_FRESH_SET = { 2130771983 };
  private static final int[] FRESHING_SET = { 2130771984 };
  private static final int[] PULL_FRESH_SET = { 2130771982 };
  public static final int STATE_FREE = 2;
  public static final int STATE_FRESHING = 3;
  public static final int STATE_PULLING = 1;
  private int state;
  private boolean stateHasChange;
  
  public FreshTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getState()
  {
    return this.state;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 3);
    switch (this.state)
    {
    default: 
      return arrayOfInt;
    case 1: 
      mergeDrawableStates(arrayOfInt, PULL_FRESH_SET);
      return arrayOfInt;
    case 2: 
      mergeDrawableStates(arrayOfInt, FREE_FRESH_SET);
      return arrayOfInt;
    }
    mergeDrawableStates(arrayOfInt, FRESHING_SET);
    return arrayOfInt;
  }
  
  public void setState(int paramInt)
  {
    if (paramInt != this.state) {}
    for (boolean bool = true;; bool = false)
    {
      this.stateHasChange = bool;
      this.state = paramInt;
      refreshDrawableState();
      return;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\view\FreshTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */