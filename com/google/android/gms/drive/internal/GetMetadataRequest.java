package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetMetadataRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetMetadataRequest> CREATOR = new zzaj();
  final int mVersionCode;
  final DriveId zzakc;
  final boolean zzalF;
  
  GetMetadataRequest(int paramInt, DriveId paramDriveId, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzakc = paramDriveId;
    this.zzalF = paramBoolean;
  }
  
  public GetMetadataRequest(DriveId paramDriveId, boolean paramBoolean)
  {
    this(1, paramDriveId, paramBoolean);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaj.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\GetMetadataRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */