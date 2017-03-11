package com.veryfit.multi.ui.fragment.inter;

import android.view.View;

public abstract interface NotifyParentFragment
{
  public abstract void notifyParentReloadMyDate(int paramInt, boolean paramBoolean);
  
  public abstract void onClickGoToTheDay(int paramInt);
  
  public abstract void onDateScrolling(int paramInt);
  
  public abstract void onHealthDataChanged();
  
  public abstract void onRootViewCreate(View paramView);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\ui\fragment\inter\NotifyParentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */