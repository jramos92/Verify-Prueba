package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;

public class DailyTotalResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<DailyTotalResult> CREATOR = new zzb();
  private final int mVersionCode;
  private final Status zzSC;
  private final DataSet zzarb;
  
  DailyTotalResult(int paramInt, Status paramStatus, DataSet paramDataSet)
  {
    this.mVersionCode = paramInt;
    this.zzSC = paramStatus;
    this.zzarb = paramDataSet;
  }
  
  public DailyTotalResult(DataSet paramDataSet, Status paramStatus)
  {
    this.mVersionCode = 1;
    this.zzSC = paramStatus;
    this.zzarb = paramDataSet;
  }
  
  public static DailyTotalResult zza(Status paramStatus, DataType paramDataType)
  {
    return new DailyTotalResult(DataSet.create(new DataSource.Builder().setDataType(paramDataType).setType(1).build()), paramStatus);
  }
  
  private boolean zzb(DailyTotalResult paramDailyTotalResult)
  {
    return (this.zzSC.equals(paramDailyTotalResult.zzSC)) && (zzw.equal(this.zzarb, paramDailyTotalResult.zzarb));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DailyTotalResult)) && (zzb((DailyTotalResult)paramObject)));
  }
  
  public Status getStatus()
  {
    return this.zzSC;
  }
  
  public DataSet getTotal()
  {
    return this.zzarb;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzSC, this.zzarb });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("status", this.zzSC).zzg("dataPoint", this.zzarb).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\DailyTotalResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */