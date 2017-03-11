package com.google.android.gms.nearby.messages.devices;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class NearbyDeviceId
  implements SafeParcelable
{
  public static final Parcelable.Creator<NearbyDeviceId> CREATOR = new zzh();
  public static final NearbyDeviceId zzaQD = new NearbyDeviceId();
  final int mVersionCode;
  private final int zzWJ;
  private final zzb zzaQE;
  private final zzd zzaQF;
  final byte[] zzaQw;
  
  private NearbyDeviceId()
  {
    this(1, 1, null);
  }
  
  NearbyDeviceId(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.mVersionCode = paramInt1;
    this.zzWJ = paramInt2;
    this.zzaQw = paramArrayOfByte;
    if (paramInt2 == 2) {}
    for (Object localObject1 = new zzb(paramArrayOfByte);; localObject1 = null)
    {
      this.zzaQE = ((zzb)localObject1);
      localObject1 = localObject2;
      if (paramInt2 == 3) {
        localObject1 = new zzd(paramArrayOfByte);
      }
      this.zzaQF = ((zzd)localObject1);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof NearbyDeviceId)) {
        return false;
      }
      paramObject = (NearbyDeviceId)paramObject;
    } while ((zzw.equal(Integer.valueOf(this.zzWJ), Integer.valueOf(((NearbyDeviceId)paramObject).zzWJ))) && (zzw.equal(this.zzaQw, ((NearbyDeviceId)paramObject).zzaQw)));
    return false;
  }
  
  public int getType()
  {
    return this.zzWJ;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.zzWJ), this.zzaQw });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("NearbyDeviceId{");
    switch (this.zzWJ)
    {
    }
    for (;;)
    {
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      localStringBuilder.append("eddystoneUid=").append(this.zzaQE);
      continue;
      localStringBuilder.append("iBeaconId=").append(this.zzaQF);
      continue;
      localStringBuilder.append("UNKNOWN");
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\devices\NearbyDeviceId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */