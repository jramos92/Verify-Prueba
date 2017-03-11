package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class ContinueConnectRequest
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  final int versionCode;
  private final zzpp zzaPu;
  private final String zzaPv;
  
  ContinueConnectRequest(int paramInt, String paramString, IBinder paramIBinder)
  {
    this.versionCode = paramInt;
    this.zzaPv = ((String)zzx.zzw(paramString));
    this.zzaPu = zzpp.zza.zzde(paramIBinder);
  }
  
  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }
  
  public String getToken()
  {
    return this.zzaPv;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzaPu == null) {
      return null;
    }
    return this.zzaPu.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\bootstrap\request\ContinueConnectRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */