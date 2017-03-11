package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceStatsResult
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSourceStatsResult> CREATOR = new zzd();
  final int mVersionCode;
  public final long zzRr;
  public final DataSource zzapM;
  public final boolean zzatg;
  public final long zzath;
  public final long zzati;
  
  DataSourceStatsResult(int paramInt, DataSource paramDataSource, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    this.mVersionCode = paramInt;
    this.zzapM = paramDataSource;
    this.zzRr = paramLong1;
    this.zzatg = paramBoolean;
    this.zzath = paramLong2;
    this.zzati = paramLong3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\DataSourceStatsResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */