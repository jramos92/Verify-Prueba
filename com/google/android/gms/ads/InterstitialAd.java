package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzaa;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

public final class InterstitialAd
{
  private final zzaa zznU;
  
  public InterstitialAd(Context paramContext)
  {
    this.zznU = new zzaa(paramContext);
  }
  
  public AdListener getAdListener()
  {
    return this.zznU.getAdListener();
  }
  
  public String getAdUnitId()
  {
    return this.zznU.getAdUnitId();
  }
  
  public InAppPurchaseListener getInAppPurchaseListener()
  {
    return this.zznU.getInAppPurchaseListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return this.zznU.getMediationAdapterClassName();
  }
  
  public boolean isLoaded()
  {
    return this.zznU.isLoaded();
  }
  
  public boolean isLoading()
  {
    return this.zznU.isLoading();
  }
  
  public void loadAd(AdRequest paramAdRequest)
  {
    this.zznU.zza(paramAdRequest.zzaF());
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.zznU.setAdListener(paramAdListener);
    if ((paramAdListener != null) && ((paramAdListener instanceof zza))) {
      this.zznU.zza((zza)paramAdListener);
    }
    while (paramAdListener != null) {
      return;
    }
    this.zznU.zza(null);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.zznU.setAdUnitId(paramString);
  }
  
  public void setInAppPurchaseListener(InAppPurchaseListener paramInAppPurchaseListener)
  {
    this.zznU.setInAppPurchaseListener(paramInAppPurchaseListener);
  }
  
  public void setPlayStorePurchaseParams(PlayStorePurchaseListener paramPlayStorePurchaseListener, String paramString)
  {
    this.zznU.setPlayStorePurchaseParams(paramPlayStorePurchaseListener, paramString);
  }
  
  public void show()
  {
    this.zznU.show();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\InterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */