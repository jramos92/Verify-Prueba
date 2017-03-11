package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;
import com.google.android.gms.nearby.bootstrap.Device;

public class DisconnectRequest
  implements SafeParcelable
{
  public static final zzd CREATOR = new zzd();
  final int versionCode;
  private final Device zzaPr;
  private final zzpp zzaPu;
  
  DisconnectRequest(int paramInt, Device paramDevice, IBinder paramIBinder)
  {
    this.versionCode = paramInt;
    this.zzaPr = ((Device)zzx.zzw(paramDevice));
    zzx.zzw(paramIBinder);
    this.zzaPu = zzpp.zza.zzde(paramIBinder);
  }
  
  public int describeContents()
  {
    zzd localzzd = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd localzzd = CREATOR;
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public Device zzAI()
  {
    return this.zzaPr;
  }
  
  public IBinder zzsO()
  {
    return this.zzaPu.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\bootstrap\request\DisconnectRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */