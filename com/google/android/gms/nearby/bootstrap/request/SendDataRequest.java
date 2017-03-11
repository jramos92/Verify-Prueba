package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;
import com.google.android.gms.nearby.bootstrap.Device;

public class SendDataRequest
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  private final byte[] data;
  final int versionCode;
  private final Device zzaPr;
  private final zzpp zzaPu;
  
  SendDataRequest(int paramInt, Device paramDevice, byte[] paramArrayOfByte, IBinder paramIBinder)
  {
    this.versionCode = paramInt;
    this.zzaPr = ((Device)zzx.zzw(paramDevice));
    this.data = ((byte[])zzx.zzw(paramArrayOfByte));
    zzx.zzw(paramIBinder);
    this.zzaPu = zzpp.zza.zzde(paramIBinder);
  }
  
  public int describeContents()
  {
    zzf localzzf = CREATOR;
    return 0;
  }
  
  public byte[] getData()
  {
    return this.data;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf localzzf = CREATOR;
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public Device zzAI()
  {
    return this.zzaPr;
  }
  
  public IBinder zzsO()
  {
    if (this.zzaPu == null) {
      return null;
    }
    return this.zzaPu.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\bootstrap\request\SendDataRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */