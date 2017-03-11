package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PointOfInterest
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  private final int mVersionCode;
  public final String name;
  public final LatLng zzaKr;
  public final String zzaKs;
  
  PointOfInterest(int paramInt, LatLng paramLatLng, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.zzaKr = paramLatLng;
    this.zzaKs = paramString1;
    this.name = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\model\PointOfInterest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */