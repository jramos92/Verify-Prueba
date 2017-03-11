package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class TrustedDevicesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<TrustedDevicesRequest> CREATOR = new zzk();
  final int versionCode;
  public zzc zzaRu;
  public String zzaRw;
  public byte[] zzaRx;
  
  TrustedDevicesRequest(int paramInt, String paramString, byte[] paramArrayOfByte, IBinder paramIBinder)
  {
    this.versionCode = paramInt;
    this.zzaRw = ((String)zzx.zzw(paramString));
    this.zzaRx = ((byte[])zzx.zzw(paramArrayOfByte));
    this.zzaRu = zzc.zza.zzdt(paramIBinder);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzBd()
  {
    return this.zzaRu.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\sharing\internal\TrustedDevicesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */