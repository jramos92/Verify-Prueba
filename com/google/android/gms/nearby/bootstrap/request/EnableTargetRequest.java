package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpn;
import com.google.android.gms.internal.zzpn.zza;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzpo.zza;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class EnableTargetRequest
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  private final String description;
  private final String name;
  final int versionCode;
  private final byte zzaPq;
  private final zzpn zzaPs;
  private final zzpo zzaPt;
  private final zzpp zzaPu;
  
  EnableTargetRequest(int paramInt, String paramString1, String paramString2, byte paramByte, IBinder paramIBinder1, IBinder paramIBinder2, IBinder paramIBinder3)
  {
    this.versionCode = paramInt;
    this.name = zzx.zzcr(paramString1);
    this.description = ((String)zzx.zzw(paramString2));
    this.zzaPq = paramByte;
    zzx.zzw(paramIBinder1);
    this.zzaPs = zzpn.zza.zzdc(paramIBinder1);
    zzx.zzw(paramIBinder2);
    this.zzaPt = zzpo.zza.zzdd(paramIBinder2);
    zzx.zzw(paramIBinder3);
    this.zzaPu = zzpp.zza.zzde(paramIBinder3);
  }
  
  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }
  
  public byte zzAG()
  {
    return this.zzaPq;
  }
  
  public IBinder zzAL()
  {
    if (this.zzaPs == null) {
      return null;
    }
    return this.zzaPs.asBinder();
  }
  
  public IBinder zzAM()
  {
    if (this.zzaPt == null) {
      return null;
    }
    return this.zzaPt.asBinder();
  }
  
  public IBinder zzsO()
  {
    if (this.zzaPu == null) {
      return null;
    }
    return this.zzaPu.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\bootstrap\request\EnableTargetRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */