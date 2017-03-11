package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznj;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataPoint> CREATOR = new zzd();
  private final int mVersionCode;
  private final DataSource zzapM;
  private long zzaqb;
  private long zzaqc;
  private final Value[] zzaqd;
  private DataSource zzaqe;
  private long zzaqf;
  private long zzaqg;
  
  DataPoint(int paramInt, DataSource paramDataSource1, long paramLong1, long paramLong2, Value[] paramArrayOfValue, DataSource paramDataSource2, long paramLong3, long paramLong4)
  {
    this.mVersionCode = paramInt;
    this.zzapM = paramDataSource1;
    this.zzaqe = paramDataSource2;
    this.zzaqb = paramLong1;
    this.zzaqc = paramLong2;
    this.zzaqd = paramArrayOfValue;
    this.zzaqf = paramLong3;
    this.zzaqg = paramLong4;
  }
  
  private DataPoint(DataSource paramDataSource)
  {
    this.mVersionCode = 4;
    this.zzapM = ((DataSource)zzx.zzb(paramDataSource, "Data source cannot be null"));
    paramDataSource = paramDataSource.getDataType().getFields();
    this.zzaqd = new Value[paramDataSource.size()];
    paramDataSource = paramDataSource.iterator();
    int i = 0;
    while (paramDataSource.hasNext())
    {
      Field localField = (Field)paramDataSource.next();
      this.zzaqd[i] = new Value(localField.getFormat());
      i += 1;
    }
  }
  
  public DataPoint(DataSource paramDataSource1, DataSource paramDataSource2, RawDataPoint paramRawDataPoint)
  {
    this(4, paramDataSource1, zza(Long.valueOf(paramRawDataPoint.zzaqb), 0L), zza(Long.valueOf(paramRawDataPoint.zzaqc), 0L), paramRawDataPoint.zzaqd, paramDataSource2, zza(Long.valueOf(paramRawDataPoint.zzaqf), 0L), zza(Long.valueOf(paramRawDataPoint.zzaqg), 0L));
  }
  
  DataPoint(List<DataSource> paramList, RawDataPoint paramRawDataPoint)
  {
    this(zza(paramList, paramRawDataPoint.zzaqU), zza(paramList, paramRawDataPoint.zzaqV), paramRawDataPoint);
  }
  
  public static DataPoint create(DataSource paramDataSource)
  {
    return new DataPoint(paramDataSource);
  }
  
  public static DataPoint extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (DataPoint)zzc.zza(paramIntent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
  }
  
  private static long zza(Long paramLong, long paramLong1)
  {
    if (paramLong != null) {
      paramLong1 = paramLong.longValue();
    }
    return paramLong1;
  }
  
  private static DataSource zza(List<DataSource> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramList.size())) {
      return (DataSource)paramList.get(paramInt);
    }
    return null;
  }
  
  private boolean zza(DataPoint paramDataPoint)
  {
    return (zzw.equal(this.zzapM, paramDataPoint.zzapM)) && (this.zzaqb == paramDataPoint.zzaqb) && (this.zzaqc == paramDataPoint.zzaqc) && (Arrays.equals(this.zzaqd, paramDataPoint.zzaqd)) && (zzw.equal(this.zzaqe, paramDataPoint.zzaqe));
  }
  
  private void zzew(int paramInt)
  {
    List localList = getDataType().getFields();
    int i = localList.size();
    if (paramInt == i) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Attempting to insert %s values, but needed %s: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), localList });
      return;
    }
  }
  
  private boolean zzsj()
  {
    return getDataType() == DataType.TYPE_LOCATION_SAMPLE;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataPoint)) && (zza((DataPoint)paramObject)));
  }
  
  public DataSource getDataSource()
  {
    return this.zzapM;
  }
  
  public DataType getDataType()
  {
    return this.zzapM.getDataType();
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzaqb, TimeUnit.NANOSECONDS);
  }
  
  public DataSource getOriginalDataSource()
  {
    return this.zzaqe;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzaqc, TimeUnit.NANOSECONDS);
  }
  
  public long getTimestamp(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzaqb, TimeUnit.NANOSECONDS);
  }
  
  public long getTimestampNanos()
  {
    return this.zzaqb;
  }
  
  public Value getValue(Field paramField)
  {
    int i = getDataType().indexOf(paramField);
    return this.zzaqd[i];
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzapM, Long.valueOf(this.zzaqb), Long.valueOf(this.zzaqc) });
  }
  
  public DataPoint setFloatValues(float... paramVarArgs)
  {
    zzew(paramVarArgs.length);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.zzaqd[i].setFloat(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public DataPoint setIntValues(int... paramVarArgs)
  {
    zzew(paramVarArgs.length);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.zzaqd[i].setInt(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
  
  public DataPoint setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    this.zzaqc = paramTimeUnit.toNanos(paramLong1);
    this.zzaqb = paramTimeUnit.toNanos(paramLong2);
    return this;
  }
  
  public DataPoint setTimestamp(long paramLong, TimeUnit paramTimeUnit)
  {
    this.zzaqb = paramTimeUnit.toNanos(paramLong);
    if ((zzsj()) && (zznj.zza(paramTimeUnit)))
    {
      Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
      this.zzaqb = zznj.zza(this.zzaqb, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
    }
    return this;
  }
  
  public String toString()
  {
    String str2 = Arrays.toString(this.zzaqd);
    long l1 = this.zzaqc;
    long l2 = this.zzaqb;
    long l3 = this.zzaqf;
    long l4 = this.zzaqg;
    String str3 = this.zzapM.toDebugString();
    if (this.zzaqe != null) {}
    for (String str1 = this.zzaqe.toDebugString();; str1 = "N/A") {
      return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", new Object[] { str2, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), str3, str1 });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public Value[] zzsk()
  {
    return this.zzaqd;
  }
  
  public long zzsl()
  {
    return this.zzaqf;
  }
  
  public long zzsm()
  {
    return this.zzaqg;
  }
  
  public void zzsn()
  {
    DataSource localDataSource = getDataSource();
    zzx.zzb(getDataType().getName().equals(localDataSource.getDataType().getName()), "Conflicting data types found %s vs %s", new Object[] { getDataType(), getDataType() });
    if (this.zzaqb > 0L)
    {
      bool = true;
      zzx.zzb(bool, "Data point does not have the timestamp set: %s", new Object[] { this });
      if (this.zzaqc > this.zzaqb) {
        break label107;
      }
    }
    label107:
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Data point with start time greater than end time found: %s", new Object[] { this });
      return;
      bool = false;
      break;
    }
  }
  
  public long zzso()
  {
    return this.zzaqc;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\DataPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */