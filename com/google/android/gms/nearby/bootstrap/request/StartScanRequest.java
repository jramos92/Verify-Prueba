package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzpr.zza;

public class StartScanRequest
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  final int versionCode;
  private final zzpp zzaPu;
  private final zzpr zzaPx;
  
  StartScanRequest(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2)
  {
    this.versionCode = paramInt;
    zzx.zzw(paramIBinder1);
    this.zzaPx = zzpr.zza.zzdg(paramIBinder1);
    zzx.zzw(paramIBinder2);
    this.zzaPu = zzpp.zza.zzde(paramIBinder2);
  }
  
  public int describeContents()
  {
    zzg localzzg = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg localzzg = CREATOR;
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzAN()
  {
    if (this.zzaPx == null) {
      return null;
    }
    return this.zzaPx.asBinder();
  }
  
  public IBinder zzsO()
  {
    if (this.zzaPu == null) {
      return null;
    }
    return this.zzaPu.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\bootstrap\request\StartScanRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */