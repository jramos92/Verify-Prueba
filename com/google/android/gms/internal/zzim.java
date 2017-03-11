package com.google.android.gms.internal;

import android.app.Activity;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.google.android.gms.ads.internal.zzp;

public final class zzim
{
  private Activity zzJn;
  private boolean zzJo;
  private boolean zzJp;
  private boolean zzJq;
  private ViewTreeObserver.OnGlobalLayoutListener zzJr;
  private ViewTreeObserver.OnScrollChangedListener zzJs;
  
  public zzim(Activity paramActivity, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener paramOnScrollChangedListener)
  {
    this.zzJn = paramActivity;
    this.zzJr = paramOnGlobalLayoutListener;
    this.zzJs = paramOnScrollChangedListener;
  }
  
  private void zzgQ()
  {
    if (this.zzJn == null) {}
    while (this.zzJo) {
      return;
    }
    if (this.zzJr != null) {
      zzp.zzbv().zza(this.zzJn, this.zzJr);
    }
    if (this.zzJs != null) {
      zzp.zzbv().zza(this.zzJn, this.zzJs);
    }
    this.zzJo = true;
  }
  
  private void zzgR()
  {
    if (this.zzJn == null) {}
    while (!this.zzJo) {
      return;
    }
    if (this.zzJr != null) {
      zzp.zzbx().zzb(this.zzJn, this.zzJr);
    }
    if (this.zzJs != null) {
      zzp.zzbv().zzb(this.zzJn, this.zzJs);
    }
    this.zzJo = false;
  }
  
  public void onAttachedToWindow()
  {
    this.zzJp = true;
    if (this.zzJq) {
      zzgQ();
    }
  }
  
  public void onDetachedFromWindow()
  {
    this.zzJp = false;
    zzgR();
  }
  
  public void zzgO()
  {
    this.zzJq = true;
    if (this.zzJp) {
      zzgQ();
    }
  }
  
  public void zzgP()
  {
    this.zzJq = false;
    zzgR();
  }
  
  public void zzk(Activity paramActivity)
  {
    this.zzJn = paramActivity;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzim.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */