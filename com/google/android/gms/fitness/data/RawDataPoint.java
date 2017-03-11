package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawDataPoint
  implements SafeParcelable
{
  public static final Parcelable.Creator<RawDataPoint> CREATOR = new zzn();
  final int mVersionCode;
  public final int zzaqU;
  public final int zzaqV;
  public final long zzaqb;
  public final long zzaqc;
  public final Value[] zzaqd;
  public final long zzaqf;
  public final long zzaqg;
  
  public RawDataPoint(int paramInt1, long paramLong1, long paramLong2, Value[] paramArrayOfValue, int paramInt2, int paramInt3, long paramLong3, long paramLong4)
  {
    this.mVersionCode = paramInt1;
    this.zzaqb = paramLong1;
    this.zzaqc = paramLong2;
    this.zzaqU = paramInt2;
    this.zzaqV = paramInt3;
    this.zzaqf = paramLong3;
    this.zzaqg = paramLong4;
    this.zzaqd = paramArrayOfValue;
  }
  
  RawDataPoint(DataPoint paramDataPoint, List<DataSource> paramList)
  {
    this.mVersionCode = 4;
    this.zzaqb = paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS);
    this.zzaqc = paramDataPoint.getStartTime(TimeUnit.NANOSECONDS);
    this.zzaqd = paramDataPoint.zzsk();
    this.zzaqU = zzs.zza(paramDataPoint.getDataSource(), paramList);
    this.zzaqV = zzs.zza(paramDataPoint.getOriginalDataSource(), paramList);
    this.zzaqf = paramDataPoint.zzsl();
    this.zzaqg = paramDataPoint.zzsm();
  }
  
  private boolean zza(RawDataPoint paramRawDataPoint)
  {
    return (this.zzaqb == paramRawDataPoint.zzaqb) && (this.zzaqc == paramRawDataPoint.zzaqc) && (Arrays.equals(this.zzaqd, paramRawDataPoint.zzaqd)) && (this.zzaqU == paramRawDataPoint.zzaqU) && (this.zzaqV == paramRawDataPoint.zzaqV) && (this.zzaqf == paramRawDataPoint.zzaqf);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof RawDataPoint)) && (zza((RawDataPoint)paramObject)));
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzaqb), Long.valueOf(this.zzaqc) });
  }
  
  public String toString()
  {
    return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[] { Arrays.toString(this.zzaqd), Long.valueOf(this.zzaqc), Long.valueOf(this.zzaqb), Integer.valueOf(this.zzaqU), Integer.valueOf(this.zzaqV) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\RawDataPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */