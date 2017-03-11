package com.google.android.gms.internal;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.formats.zzc;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzgr
public class zzew
  extends zzer.zza
{
  private final NativeContentAdMapper zzzO;
  
  public zzew(NativeContentAdMapper paramNativeContentAdMapper)
  {
    this.zzzO = paramNativeContentAdMapper;
  }
  
  public String getAdvertiser()
  {
    return this.zzzO.getAdvertiser();
  }
  
  public String getBody()
  {
    return this.zzzO.getBody();
  }
  
  public String getCallToAction()
  {
    return this.zzzO.getCallToAction();
  }
  
  public Bundle getExtras()
  {
    return this.zzzO.getExtras();
  }
  
  public String getHeadline()
  {
    return this.zzzO.getHeadline();
  }
  
  public List getImages()
  {
    Object localObject = this.zzzO.getImages();
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
    return this.zzzO.getOverrideClickHandling();
  }
  
  public boolean getOverrideImpressionRecording()
  {
    return this.zzzO.getOverrideImpressionRecording();
  }
  
  public void recordImpression()
  {
    this.zzzO.recordImpression();
  }
  
  public void zzc(zzd paramzzd)
  {
    this.zzzO.handleClick((View)zze.zzp(paramzzd));
  }
  
  public void zzd(zzd paramzzd)
  {
    this.zzzO.trackView((View)zze.zzp(paramzzd));
  }
  
  public zzcm zzdA()
  {
    NativeAd.Image localImage = this.zzzO.getLogo();
    if (localImage != null) {
      return new zzc(localImage.getDrawable(), localImage.getUri(), localImage.getScale());
    }
    return null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */