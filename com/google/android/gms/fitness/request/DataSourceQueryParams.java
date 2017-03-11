package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceQueryParams
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSourceQueryParams> CREATOR = new zzg();
  final int mVersionCode;
  public final long zzRr;
  public final DataSource zzapM;
  public final long zzaqc;
  public final int zzasm;
  public final long zzasr;
  public final int zzass;
  
  DataSourceQueryParams(int paramInt1, DataSource paramDataSource, long paramLong1, long paramLong2, long paramLong3, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzapM = paramDataSource;
    this.zzRr = paramLong1;
    this.zzaqc = paramLong2;
    this.zzasr = paramLong3;
    this.zzasm = paramInt2;
    this.zzass = paramInt3;
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\DataSourceQueryParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */