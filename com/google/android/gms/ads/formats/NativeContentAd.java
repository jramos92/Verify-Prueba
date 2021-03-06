package com.google.android.gms.ads.formats;

import android.os.Bundle;
import java.util.List;

public abstract class NativeContentAd
  extends NativeAd
{
  public abstract CharSequence getAdvertiser();
  
  public abstract CharSequence getBody();
  
  public abstract CharSequence getCallToAction();
  
  public abstract Bundle getExtras();
  
  public abstract CharSequence getHeadline();
  
  public abstract List<NativeAd.Image> getImages();
  
  public abstract NativeAd.Image getLogo();
  
  public static abstract interface OnContentAdLoadedListener
  {
    public abstract void onContentAdLoaded(NativeContentAd paramNativeContentAd);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\formats\NativeContentAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */