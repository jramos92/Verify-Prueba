package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class RemoveEventListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RemoveEventListenerRequest> CREATOR = new zzbo();
  final int mVersionCode;
  final int zzaho;
  final DriveId zzaiA;
  
  RemoveEventListenerRequest(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzaiA = paramDriveId;
    this.zzaho = paramInt2;
  }
  
  public RemoveEventListenerRequest(DriveId paramDriveId, int paramInt)
  {
    this(1, paramDriveId, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbo.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\RemoveEventListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */