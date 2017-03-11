package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.internal.zzni;
import java.util.Collections;
import java.util.List;

public class BleDevice
  implements SafeParcelable
{
  public static final Parcelable.Creator<BleDevice> CREATOR = new zzb();
  private final String mName;
  private final int mVersionCode;
  private final String zzapU;
  private final List<String> zzapV;
  private final List<DataType> zzapW;
  
  BleDevice(int paramInt, String paramString1, String paramString2, List<String> paramList, List<DataType> paramList1)
  {
    this.mVersionCode = paramInt;
    this.zzapU = paramString1;
    this.mName = paramString2;
    this.zzapV = Collections.unmodifiableList(paramList);
    this.zzapW = Collections.unmodifiableList(paramList1);
  }
  
  private boolean zza(BleDevice paramBleDevice)
  {
    return (this.mName.equals(paramBleDevice.mName)) && (this.zzapU.equals(paramBleDevice.zzapU)) && (zzni.zza(paramBleDevice.zzapV, this.zzapV)) && (zzni.zza(this.zzapW, paramBleDevice.zzapW));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof BleDevice)) && (zza((BleDevice)paramObject)));
  }
  
  public String getAddress()
  {
    return this.zzapU;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.zzapW;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public List<String> getSupportedProfiles()
  {
    return this.zzapV;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.mName, this.zzapU, this.zzapV, this.zzapW });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("name", this.mName).zzg("address", this.zzapU).zzg("dataTypes", this.zzapW).zzg("supportedProfiles", this.zzapV).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\BleDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */