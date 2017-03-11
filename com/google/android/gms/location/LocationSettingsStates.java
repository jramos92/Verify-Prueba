package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;

public final class LocationSettingsStates
  implements SafeParcelable
{
  public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzh();
  private final int mVersionCode;
  private final boolean zzaEQ;
  private final boolean zzaER;
  private final boolean zzaES;
  private final boolean zzaET;
  private final boolean zzaEU;
  private final boolean zzaEV;
  private final boolean zzaEW;
  
  LocationSettingsStates(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    this.mVersionCode = paramInt;
    this.zzaEQ = paramBoolean1;
    this.zzaER = paramBoolean2;
    this.zzaES = paramBoolean3;
    this.zzaET = paramBoolean4;
    this.zzaEU = paramBoolean5;
    this.zzaEV = paramBoolean6;
    this.zzaEW = paramBoolean7;
  }
  
  public static LocationSettingsStates fromIntent(Intent paramIntent)
  {
    return (LocationSettingsStates)zzc.zza(paramIntent, "com.google.android.gms.location.LOCATION_SETTINGS_STATES", CREATOR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean isBlePresent()
  {
    return this.zzaEV;
  }
  
  public boolean isBleUsable()
  {
    return this.zzaES;
  }
  
  public boolean isGpsPresent()
  {
    return this.zzaET;
  }
  
  public boolean isGpsUsable()
  {
    return this.zzaEQ;
  }
  
  public boolean isLocationPresent()
  {
    return (this.zzaET) || (this.zzaEU);
  }
  
  public boolean isLocationUsable()
  {
    return (this.zzaEQ) || (this.zzaER);
  }
  
  public boolean isNetworkLocationPresent()
  {
    return this.zzaEU;
  }
  
  public boolean isNetworkLocationUsable()
  {
    return this.zzaER;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzwA()
  {
    return this.zzaEW;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\LocationSettingsStates.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */