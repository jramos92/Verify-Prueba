package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzgr
public class zzev
  extends zzeq.zza
{
  private final NativeAppInstallAdMapper zzzN;
  
  public zzev(NativeAppInstallAdMapper paramNativeAppInstallAdMapper)
  {
    this.zzzN = paramNativeAppInstallAdMapper;
  }
  
  public String getBody()
  {
    return this.zzzN.getBody();
  }
  
  public String getCallToAction()
  {
    return this.zzzN.getCallToAction();
  }
  
  public Bundle getExtras()
  {
    return this.zzzN.getExtras();
  }
  
  public String getHeadline()
  {
    return this.zzzN.getHeadline();
  }
  
  public List getImages()
  {
    Object localObject = this.zzzN.getImages();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        NativeAd.Image localImage = (NativeAd.Image)((Iterator)localObject).next();
        localArrayList.add(new zzc(localImage.getDrawable(), localImage.getUri(), localImage.getScale()));
      }
      return localArrayList;
    }
    return null;
  }
  
  public boolean getOverrideClickHandling()
  {
    return this.zzzN.getOverrideClickHandling();
  }
  
  public boolean getOverrideImpressionRecording()
  {
    return this.zzzN.getOverrideImpressionRecording();
  }
  
  public String getPrice()
  {
    return this.zzzN.getPrice();
  }
  
  public double getStarRating()
  {
    return this.zzzN.getStarRating();
  }
  
  public String getStore()
  {
    return this.zzzN.getStore();
  }
  
  public void recordImpression()
  {
    this.zzzN.recordImpression();
  }
  
  public void zzc(zzd paramzzd)
  {
    this.zzzN.handleClick((View)zze.zzp(paramzzd));
  }
  
  public void zzd(zzd paramzzd)
  {
    this.zzzN.trackView((View)zze.zzp(paramzzd));
  }
  
  public zzcm zzdw()
  {
    NativeAd.Image localImage = this.zzzN.getIcon();
    if (localImage != null) {
      return new zzc(localImage.getDrawable(), localImage.getUri(), localImage.getScale());
    }
    return null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzev.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */