package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class ControlProgressRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ControlProgressRequest> CREATOR = new zzj();
  final int mVersionCode;
  final DriveId zzaiA;
  final int zzakj;
  final int zzakk;
  
  ControlProgressRequest(int paramInt1, int paramInt2, int paramInt3, DriveId paramDriveId)
  {
    this.mVersionCode = paramInt1;
    this.zzakj = paramInt2;
    this.zzakk = paramInt3;
    this.zzaiA = paramDriveId;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\ControlProgressRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */