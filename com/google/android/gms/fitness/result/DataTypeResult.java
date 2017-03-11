package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.DataType;

public class DataTypeResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<DataTypeResult> CREATOR = new zzg();
  private final int mVersionCode;
  private final Status zzSC;
  private final DataType zzapL;
  
  DataTypeResult(int paramInt, Status paramStatus, DataType paramDataType)
  {
    this.mVersionCode = paramInt;
    this.zzSC = paramStatus;
    this.zzapL = paramDataType;
  }
  
  public DataTypeResult(Status paramStatus, DataType paramDataType)
  {
    this.mVersionCode = 2;
    this.zzSC = paramStatus;
    this.zzapL = paramDataType;
  }
  
  public static DataTypeResult zzR(Status paramStatus)
  {
    return new DataTypeResult(paramStatus, null);
  }
  
  private boolean zzb(DataTypeResult paramDataTypeResult)
  {
    return (this.zzSC.equals(paramDataTypeResult.zzSC)) && (zzw.equal(this.zzapL, paramDataTypeResult.zzapL));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataTypeResult)) && (zzb((DataTypeResult)paramObject)));
  }
  
  public DataType getDataType()
  {
    return this.zzapL;
  }
  
  public Status getStatus()
  {
    return this.zzSC;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzSC, this.zzapL });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("status", this.zzSC).zzg("dataType", this.zzapL).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\DataTypeResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */