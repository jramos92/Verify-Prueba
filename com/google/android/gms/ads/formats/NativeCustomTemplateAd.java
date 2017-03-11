package com.google.android.gms.ads.formats;

import java.util.List;

public abstract interface NativeCustomTemplateAd
{
  public abstract List<String> getAvailableAssetNames();
  
  public abstract String getCustomTemplateId();
  
  public abstract NativeAd.Image getImage(String paramString);
  
  public abstract CharSequence getText(String paramString);
  
  public abstract void performClick(String paramString);
  
  public abstract void recordImpression();
  
  public static abstract interface OnCustomClickListener
  {
    public abstract void onCustomClick(NativeCustomTemplateAd paramNativeCustomTemplateAd, String paramString);
  }
  
  public static abstract interface OnCustomTemplateAdLoadedListener
  {
    public abstract void onCustomTemplateAdLoaded(NativeCustomTemplateAd paramNativeCustomTemplateAd);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\formats\NativeCustomTemplateAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */