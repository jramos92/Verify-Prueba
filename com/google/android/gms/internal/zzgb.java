package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

@zzgr
public final class zzgb
  extends zzfw.zza
{
  private final PlayStorePurchaseListener zztJ;
  
  public zzgb(PlayStorePurchaseListener paramPlayStorePurchaseListener)
  {
    this.zztJ = paramPlayStorePurchaseListener;
  }
  
  public boolean isValidPurchase(String paramString)
  {
    return this.zztJ.isValidPurchase(paramString);
  }
  
  public void zza(zzfv paramzzfv)
  {
    this.zztJ.onInAppPurchaseFinished(new zzfz(paramzzfv));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */