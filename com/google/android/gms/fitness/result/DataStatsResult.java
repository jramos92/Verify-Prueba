package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class DataStatsResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<DataStatsResult> CREATOR = new zzf();
  private final int mVersionCode;
  private final Status zzSC;
  private final List<DataSourceStatsResult> zzatj;
  
  DataStatsResult(int paramInt, Status paramStatus, List<DataSourceStatsResult> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzSC = paramStatus;
    this.zzatj = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Status getStatus()
  {
    return this.zzSC;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  List<DataSourceStatsResult> zztr()
  {
    return this.zzatj;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\DataStatsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */