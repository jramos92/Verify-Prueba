package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  private final int mVersionCode;
  private Boolean zzaIB;
  private Boolean zzaIH = Boolean.valueOf(true);
  private StreetViewPanoramaCamera zzaJo;
  private String zzaJp;
  private LatLng zzaJq;
  private Integer zzaJr;
  private Boolean zzaJs = Boolean.valueOf(true);
  private Boolean zzaJt = Boolean.valueOf(true);
  private Boolean zzaJu = Boolean.valueOf(true);
  
  public StreetViewPanoramaOptions()
  {
    this.mVersionCode = 1;
  }
  
  StreetViewPanoramaOptions(int paramInt, StreetViewPanoramaCamera paramStreetViewPanoramaCamera, String paramString, LatLng paramLatLng, Integer paramInteger, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5)
  {
    this.mVersionCode = paramInt;
    this.zzaJo = paramStreetViewPanoramaCamera;
    this.zzaJq = paramLatLng;
    this.zzaJr = paramInteger;
    this.zzaJp = paramString;
    this.zzaJs = zza.zza(paramByte1);
    this.zzaIH = zza.zza(paramByte2);
    this.zzaJt = zza.zza(paramByte3);
    this.zzaJu = zza.zza(paramByte4);
    this.zzaIB = zza.zza(paramByte5);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Boolean getPanningGesturesEnabled()
  {
    return this.zzaJt;
  }
  
  public String getPanoramaId()
  {
    return this.zzaJp;
  }
  
  public LatLng getPosition()
  {
    return this.zzaJq;
  }
  
  public Integer getRadius()
  {
    return this.zzaJr;
  }
  
  public Boolean getStreetNamesEnabled()
  {
    return this.zzaJu;
  }
  
  public StreetViewPanoramaCamera getStreetViewPanoramaCamera()
  {
    return this.zzaJo;
  }
  
  public Boolean getUseViewLifecycleInFragment()
  {
    return this.zzaIB;
  }
  
  public Boolean getUserNavigationEnabled()
  {
    return this.zzaJs;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public Boolean getZoomGesturesEnabled()
  {
    return this.zzaIH;
  }
  
  public StreetViewPanoramaOptions panningGesturesEnabled(boolean paramBoolean)
  {
    this.zzaJt = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
  {
    this.zzaJo = paramStreetViewPanoramaCamera;
    return this;
  }
  
  public StreetViewPanoramaOptions panoramaId(String paramString)
  {
    this.zzaJp = paramString;
    return this;
  }
  
  public StreetViewPanoramaOptions position(LatLng paramLatLng)
  {
    this.zzaJq = paramLatLng;
    return this;
  }
  
  public StreetViewPanoramaOptions position(LatLng paramLatLng, Integer paramInteger)
  {
    this.zzaJq = paramLatLng;
    this.zzaJr = paramInteger;
    return this;
  }
  
  public StreetViewPanoramaOptions streetNamesEnabled(boolean paramBoolean)
  {
    this.zzaJu = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    this.zzaIB = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public StreetViewPanoramaOptions userNavigationEnabled(boolean paramBoolean)
  {
    this.zzaJs = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public StreetViewPanoramaOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.zzaIH = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  byte zzxA()
  {
    return zza.zze(this.zzaIB);
  }
  
  byte zzxE()
  {
    return zza.zze(this.zzaIH);
  }
  
  byte zzxP()
  {
    return zza.zze(this.zzaJs);
  }
  
  byte zzxQ()
  {
    return zza.zze(this.zzaJt);
  }
  
  byte zzxR()
  {
    return zza.zze(this.zzaJu);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\StreetViewPanoramaOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */