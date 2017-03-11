package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationSettingsResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new zzg();
  private final int mVersionCode;
  private final Status zzSC;
  private final LocationSettingsStates zzaEP;
  
  LocationSettingsResult(int paramInt, Status paramStatus, LocationSettingsStates paramLocationSettingsStates)
  {
    this.mVersionCode = paramInt;
    this.zzSC = paramStatus;
    this.zzaEP = paramLocationSettingsStates;
  }
  
  public LocationSettingsResult(Status paramStatus)
  {
    this(1, paramStatus, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public LocationSettingsStates getLocationSettingsStates()
  {
    return this.zzaEP;
  }
  
  public Status getStatus()
  {
    return this.zzSC;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\LocationSettingsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */