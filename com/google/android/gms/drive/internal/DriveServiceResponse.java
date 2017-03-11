package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzq.zza;

public class DriveServiceResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveServiceResponse> CREATOR = new zzad();
  final int mVersionCode;
  final IBinder zzals;
  
  DriveServiceResponse(int paramInt, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzals = paramIBinder;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzad.zza(this, paramParcel, paramInt);
  }
  
  public zzq zzrr()
  {
    return zzq.zza.zzaI(this.zzals);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\DriveServiceResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */