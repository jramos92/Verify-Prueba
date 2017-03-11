package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

public class AddPermissionRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddPermissionRequest> CREATOR = new zzb();
  final int mVersionCode;
  final DriveId zzaiA;
  final String zzaiX;
  final Permission zzajT;
  final boolean zzajU;
  final String zzajV;
  final boolean zzajW;
  
  AddPermissionRequest(int paramInt, DriveId paramDriveId, Permission paramPermission, boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.zzaiA = paramDriveId;
    this.zzajT = paramPermission;
    this.zzajU = paramBoolean1;
    this.zzajV = paramString1;
    this.zzajW = paramBoolean2;
    this.zzaiX = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\AddPermissionRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */