package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;

public class UnclaimBleDeviceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UnclaimBleDeviceRequest> CREATOR = new zzad();
  private final int mVersionCode;
  private final String zzarZ;
  private final zzoj zzasb;
  
  UnclaimBleDeviceRequest(int paramInt, String paramString, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzarZ = paramString;
    this.zzasb = zzoj.zza.zzbJ(paramIBinder);
  }
  
  public UnclaimBleDeviceRequest(String paramString, zzoj paramzzoj)
  {
    this.mVersionCode = 5;
    this.zzarZ = paramString;
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
    return String.format("UnclaimBleDeviceRequest{%s}", new Object[] { this.zzarZ });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzad.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzasb == null) {
      return null;
    }
    return this.zzasb.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\UnclaimBleDeviceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */