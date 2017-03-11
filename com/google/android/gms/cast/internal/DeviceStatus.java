package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class DeviceStatus
  implements SafeParcelable
{
  public static final Parcelable.Creator<DeviceStatus> CREATOR = new zzg();
  private final int mVersionCode;
  private double zzWA;
  private boolean zzWB;
  private int zzYO;
  private int zzYP;
  private ApplicationMetadata zzYZ;
  
  public DeviceStatus()
  {
    this(3, NaN.0D, false, -1, null, -1);
  }
  
  DeviceStatus(int paramInt1, double paramDouble, boolean paramBoolean, int paramInt2, ApplicationMetadata paramApplicationMetadata, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzWA = paramDouble;
    this.zzWB = paramBoolean;
    this.zzYO = paramInt2;
    this.zzYZ = paramApplicationMetadata;
    this.zzYP = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof DeviceStatus)) {
        return false;
      }
      paramObject = (DeviceStatus)paramObject;
    } while ((this.zzWA == ((DeviceStatus)paramObject).zzWA) && (this.zzWB == ((DeviceStatus)paramObject).zzWB) && (this.zzYO == ((DeviceStatus)paramObject).zzYO) && (zzf.zza(this.zzYZ, ((DeviceStatus)paramObject).zzYZ)) && (this.zzYP == ((DeviceStatus)paramObject).zzYP));
    return false;
  }
  
  public ApplicationMetadata getApplicationMetadata()
  {
    return this.zzYZ;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Double.valueOf(this.zzWA), Boolean.valueOf(this.zzWB), Integer.valueOf(this.zzYO), this.zzYZ, Integer.valueOf(this.zzYP) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public double zzmU()
  {
    return this.zzWA;
  }
  
  public int zzmV()
  {
    return this.zzYO;
  }
  
  public int zzmW()
  {
    return this.zzYP;
  }
  
  public boolean zznd()
  {
    return this.zzWB;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\internal\DeviceStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */