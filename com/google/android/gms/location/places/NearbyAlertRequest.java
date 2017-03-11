package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.Set;

public final class NearbyAlertRequest
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  private final int mVersionCode;
  private final int zzaEi;
  private final int zzaGd;
  @Deprecated
  private final PlaceFilter zzaGe;
  private final NearbyAlertFilter zzaGf;
  private final boolean zzaGg;
  private final int zzaGh;
  
  NearbyAlertRequest(int paramInt1, int paramInt2, int paramInt3, PlaceFilter paramPlaceFilter, NearbyAlertFilter paramNearbyAlertFilter, boolean paramBoolean, int paramInt4)
  {
    this.mVersionCode = paramInt1;
    this.zzaEi = paramInt2;
    this.zzaGd = paramInt3;
    this.zzaGg = paramBoolean;
    if (paramNearbyAlertFilter != null) {
      this.zzaGf = paramNearbyAlertFilter;
    }
    for (;;)
    {
      this.zzaGe = null;
      this.zzaGh = paramInt4;
      return;
      if (paramPlaceFilter != null)
      {
        if (zza(paramPlaceFilter)) {
          this.zzaGf = NearbyAlertFilter.zza(paramPlaceFilter.getPlaceIds(), paramPlaceFilter.getPlaceTypes(), paramPlaceFilter.zzwS());
        } else {
          this.zzaGf = null;
        }
      }
      else {
        this.zzaGf = null;
      }
    }
  }
  
  @Deprecated
  private static boolean zza(PlaceFilter paramPlaceFilter)
  {
    return ((paramPlaceFilter.getPlaceTypes() != null) && (!paramPlaceFilter.getPlaceTypes().isEmpty())) || ((paramPlaceFilter.getPlaceIds() != null) && (!paramPlaceFilter.getPlaceIds().isEmpty())) || ((paramPlaceFilter.zzwS() != null) && (!paramPlaceFilter.zzwS().isEmpty()));
  }
  
  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof NearbyAlertRequest)) {
        return false;
      }
      paramObject = (NearbyAlertRequest)paramObject;
    } while ((this.zzaEi == ((NearbyAlertRequest)paramObject).zzaEi) && (this.zzaGd == ((NearbyAlertRequest)paramObject).zzaGd) && (zzw.equal(this.zzaGe, ((NearbyAlertRequest)paramObject).zzaGe)) && (zzw.equal(this.zzaGf, ((NearbyAlertRequest)paramObject).zzaGf)));
    return false;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.zzaEi), Integer.valueOf(this.zzaGd) });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("transitionTypes", Integer.valueOf(this.zzaEi)).zzg("loiteringTimeMillis", Integer.valueOf(this.zzaGd)).zzg("nearbyAlertFilter", this.zzaGf).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }
  
  public int zzwK()
  {
    return this.zzaEi;
  }
  
  public int zzwN()
  {
    return this.zzaGd;
  }
  
  @Deprecated
  public PlaceFilter zzwO()
  {
    return null;
  }
  
  public NearbyAlertFilter zzwP()
  {
    return this.zzaGf;
  }
  
  public boolean zzwQ()
  {
    return this.zzaGg;
  }
  
  public int zzwR()
  {
    return this.zzaGh;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\NearbyAlertRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */