package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;

public class ClaimBleDeviceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ClaimBleDeviceRequest> CREATOR = new zzb();
  private final int mVersionCode;
  private final String zzarZ;
  private final BleDevice zzasa;
  private final zzoj zzasb;
  
  ClaimBleDeviceRequest(int paramInt, String paramString, BleDevice paramBleDevice, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzarZ = paramString;
    this.zzasa = paramBleDevice;
    this.zzasb = zzoj.zza.zzbJ(paramIBinder);
  }
  
  public ClaimBleDeviceRequest(String paramString, BleDevice paramBleDevice, zzoj paramzzoj)
  {
    this.mVersionCode = 4;
    this.zzarZ = paramString;
    this.zzasa = paramBleDevice;
    this.zzasb = paramzzoj;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDeviceAddress()
  {
    return this.zzarZ;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String toString()
  {
    return String.format("ClaimBleDeviceRequest{%s %s}", new Object[] { this.zzarZ, this.zzasa });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public BleDevice zzsN()
  {
    return this.zzasa;
  }
  
  public IBinder zzsO()
  {
    if (this.zzasb == null) {
      return null;
    }
    return this.zzasb.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\ClaimBleDeviceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */