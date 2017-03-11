package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;

public class AddEventListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddEventListenerRequest> CREATOR = new zza();
  final int mVersionCode;
  final int zzaho;
  final DriveId zzaiA;
  final ChangesAvailableOptions zzajx;
  
  AddEventListenerRequest(int paramInt1, DriveId paramDriveId, int paramInt2, ChangesAvailableOptions paramChangesAvailableOptions)
  {
    this.mVersionCode = paramInt1;
    this.zzaiA = paramDriveId;
    this.zzaho = paramInt2;
    this.zzajx = paramChangesAvailableOptions;
  }
  
  public AddEventListenerRequest(DriveId paramDriveId, int paramInt, ChangesAvailableOptions paramChangesAvailableOptions)
  {
    this(1, paramDriveId, paramInt, paramChangesAvailableOptions);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\AddEventListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */