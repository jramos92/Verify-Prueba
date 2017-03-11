package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdOptions.Builder;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzgr
public final class zzex
  implements NativeMediationAdRequest
{
  private final Date zzaT;
  private final Set<String> zzaV;
  private final boolean zzaW;
  private final Location zzaX;
  private final NativeAdOptionsParcel zzoY;
  private final List<String> zzoZ;
  private final int zzsR;
  private final int zzzI;
  
  public zzex(Date paramDate, int paramInt1, Set<String> paramSet, Location paramLocation, boolean paramBoolean, int paramInt2, NativeAdOptionsParcel paramNativeAdOptionsParcel, List<String> paramList)
  {
    this.zzaT = paramDate;
    this.zzsR = paramInt1;
    this.zzaV = paramSet;
    this.zzaX = paramLocation;
    this.zzaW = paramBoolean;
    this.zzzI = paramInt2;
    this.zzoY = paramNativeAdOptionsParcel;
    this.zzoZ = paramList;
  }
  
  public Date getBirthday()
  {
    return this.zzaT;
  }
  
  public int getGender()
  {
    return this.zzsR;
  }
  
  public Set<String> getKeywords()
  {
    return this.zzaV;
  }
  
  public Location getLocation()
  {
    return this.zzaX;
  }
  
  public NativeAdOptions getNativeAdOptions()
  {
    if (this.zzoY == null) {
      return null;
    }
    return new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzoY.zzwR).setImageOrientation(this.zzoY.zzwS).setRequestMultipleImages(this.zzoY.zzwT).build();
  }
  
  public boolean isAppInstallAdRequested()
  {
    return (this.zzoZ != null) && (this.zzoZ.contains("2"));
  }
  
  public boolean isContentAdRequested()
  {
    return (this.zzoZ != null) && (this.zzoZ.contains("1"));
  }
  
  public boolean isTesting()
  {
    return this.zzaW;
  }
  
  public int taggedForChildDirectedTreatment()
  {
    return this.zzzI;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */