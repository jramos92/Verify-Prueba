package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class NearbyDeviceFilter
  implements SafeParcelable
{
  public static final Parcelable.Creator<NearbyDeviceFilter> CREATOR = new zzg();
  final int mVersionCode;
  final int zzaQB;
  final byte[] zzaQC;
  
  NearbyDeviceFilter(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.mVersionCode = paramInt1;
    this.zzaQB = paramInt2;
    this.zzaQC = paramArrayOfByte;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\devices\NearbyDeviceFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */