package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OpenContentsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<OpenContentsRequest> CREATOR = new zzbk();
  final int mVersionCode;
  final int zzaiz;
  final DriveId zzakc;
  final int zzamo;
  
  OpenContentsRequest(int paramInt1, DriveId paramDriveId, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzakc = paramDriveId;
    this.zzaiz = paramInt2;
    this.zzamo = paramInt3;
  }
  
  public OpenContentsRequest(DriveId paramDriveId, int paramInt1, int paramInt2)
  {
    this(1, paramDriveId, paramInt1, paramInt2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbk.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\OpenContentsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */