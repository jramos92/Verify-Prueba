package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class NearbyDevice
  implements SafeParcelable
{
  public static final Parcelable.Creator<NearbyDevice> CREATOR = new zzf();
  public static final NearbyDevice zzaQz = new NearbyDevice(NearbyDeviceId.zzaQD);
  final int mVersionCode;
  private final NearbyDeviceId zzaQA;
  
  NearbyDevice(int paramInt, NearbyDeviceId paramNearbyDeviceId)
  {
    this.mVersionCode = paramInt;
    this.zzaQA = paramNearbyDeviceId;
  }
  
  public NearbyDevice(NearbyDeviceId paramNearbyDeviceId)
  {
    this(1, paramNearbyDeviceId);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof NearbyDevice)) {
      return false;
    }
    paramObject = (NearbyDevice)paramObject;
    return zzw.equal(this.zzaQA, ((NearbyDevice)paramObject).zzaQA);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaQA });
  }
  
  public String toString()
  {
    return "NearbyDevice{id=" + this.zzaQA + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public NearbyDeviceId zzBc()
  {
    return this.zzaQA;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\devices\NearbyDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */