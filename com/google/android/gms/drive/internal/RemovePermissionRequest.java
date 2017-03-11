package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemovePermissionRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RemovePermissionRequest> CREATOR = new zzbp();
  final int mVersionCode;
  final DriveId zzaiA;
  final String zzaiX;
  final boolean zzajW;
  final String zzajj;
  
  RemovePermissionRequest(int paramInt, DriveId paramDriveId, String paramString1, boolean paramBoolean, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.zzaiA = paramDriveId;
    this.zzajj = paramString1;
    this.zzajW = paramBoolean;
    this.zzaiX = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbp.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\RemovePermissionRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */