package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class StopScanRequest
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  final int versionCode;
  private final zzpp zzaPu;
  
  StopScanRequest(int paramInt, IBinder paramIBinder)
  {
    this.versionCode = paramInt;
    zzx.zzw(paramIBinder);
    this.zzaPu = zzpp.zza.zzde(paramIBinder);
  }
  
  public int describeContents()
  {
    zzh localzzh = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh localzzh = CREATOR;
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzaPu == null) {
      return null;
    }
    return this.zzaPu.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\bootstrap\request\StopScanRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */