package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;

public class ListClaimedBleDevicesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ListClaimedBleDevicesRequest> CREATOR = new zzo();
  private final int mVersionCode;
  private final zzow zzasA;
  
  ListClaimedBleDevicesRequest(int paramInt, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzasA = zzow.zza.zzbL(paramIBinder);
  }
  
  public ListClaimedBleDevicesRequest(zzow paramzzow)
  {
    this.mVersionCode = 2;
    this.zzasA = paramzzow;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    return this.zzasA.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\ListClaimedBleDevicesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */