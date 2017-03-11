package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class SetDrivePreferencesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SetDrivePreferencesRequest> CREATOR = new zzbq();
  final int mVersionCode;
  final DrivePreferences zzamd;
  
  SetDrivePreferencesRequest(int paramInt, DrivePreferences paramDrivePreferences)
  {
    this.mVersionCode = paramInt;
    this.zzamd = paramDrivePreferences;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbq.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\SetDrivePreferencesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */