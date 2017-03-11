package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class DisableTargetRequest
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  final int versionCode;
  private final zzpp zzaPu;
  
  DisableTargetRequest(int paramInt, IBinder paramIBinder)
  {
    this.versionCode = paramInt;
    zzx.zzw(paramIBinder);
    this.zzaPu = zzpp.zza.zzde(paramIBinder);
  }
  
  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzaPu == null) {
      return null;
    }
    return this.zzaPu.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\bootstrap\request\DisableTargetRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */