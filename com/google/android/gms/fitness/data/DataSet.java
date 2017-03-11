package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class DataSet
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSet> CREATOR = new zze();
  private final int mVersionCode;
  private final DataType zzapL;
  private final DataSource zzapM;
  private boolean zzaqa = false;
  private final List<DataPoint> zzaqh;
  private final List<DataSource> zzaqi;
  
  DataSet(int paramInt, DataSource paramDataSource, DataType paramDataType, List<RawDataPoint> paramList, List<DataSource> paramList1, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzapM = paramDataSource;
    this.zzapL = paramDataSource.getDataType();
    this.zzaqa = paramBoolean;
    this.zzaqh = new ArrayList(paramList.size());
    if (paramInt >= 2) {}
    for (;;)
    {
      this.zzaqi = paramList1;
      paramDataSource = paramList.iterator();
      while (paramDataSource.hasNext())
      {
        paramDataType = (RawDataPoint)paramDataSource.next();
        this.zzaqh.add(new DataPoint(this.zzaqi, paramDataType));
      }
      paramList1 = Collections.singletonList(paramDataSource);
    }
  }
  
  public DataSet(DataSource paramDataSource)
  {
    this.mVersionCode = 3;
    this.zzapM = ((DataSource)zzx.zzw(paramDataSource));
    this.zzapL = paramDataSource.getDataType();
    this.zzaqh = new ArrayList();
    this.zzaqi = new ArrayList();
    this.zzaqi.add(this.zzapM);
  }
  
  public DataSet(RawDataSet paramRawDataSet, List<DataSource> paramList)
  {
    this.mVersionCode = 3;
    this.zzapM = ((DataSource)zzb(paramList, paramRawDataSet.zzaqU));
    this.zzapL = this.zzapM.getDataType();
    this.zzaqi = paramList;
    this.zzaqa = paramRawDataSet.zzaqa;
    paramRawDataSet = paramRawDataSet.zzaqX;
    this.zzaqh = new ArrayList(paramRawDataSet.size());
    paramRawDataSet = paramRawDataSet.iterator();
    while (paramRawDataSet.hasNext())
    {
      paramList = (RawDataPoint)paramRawDataSet.next();
      this.zzaqh.add(new DataPoint(this.zzaqi, paramList));
    }
  }
  
  public static DataSet create(DataSource paramDataSource)
  {
    zzx.zzb(paramDataSource, "DataSource should be specified");
    return new DataSet(paramDataSource);
  }
  
  private boolean zza(DataSet paramDataSet)
  {
    return (zzw.equal(getDataType(), paramDataSet.getDataType())) && (zzw.equal(this.zzapM, paramDataSet.zzapM)) && (zzw.equal(this.zzaqh, paramDataSet.zzaqh)) && (this.zzaqa == paramDataSet.zzaqa);
  }
  
  private static <T> T zzb(List<T> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramList.size())) {
      return (T)paramList.get(paramInt);
    }
    return null;
  }
  
  public void add(DataPoint paramDataPoint)
  {
    DataSource localDataSource = paramDataPoint.getDataSource();
    zzx.zzb(localDataSource.getStreamIdentifier().equals(this.zzapM.getStreamIdentifier()), "Conflicting data sources found %s vs %s", new Object[] { localDataSource, this.zzapM });
    paramDataPoint.zzsn();
    zzb(paramDataPoint);
  }
  
  public void addAll(Iterable<DataPoint> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      add((DataPoint)paramIterable.next());
    }
  }
  
  public DataPoint createDataPoint()
  {
    return DataPoint.create(this.zzapM);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataSet)) && (zza((DataSet)paramObject)));
  }
  
  public List<DataPoint> getDataPoints()
  {
    return Collections.unmodifiableList(this.zzaqh);
  }
  
  public DataSource getDataSource()
  {
    return this.zzapM;
  }
  
  public DataType getDataType()
  {
    return this.zzapM.getDataType();
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzapM });
  }
  
  public boolean isEmpty()
  {
    return this.zzaqh.isEmpty();
  }
  
  public String toString()
  {
    Object localObject = zzsp();
    String str = this.zzapM.toDebugString();
    if (this.zzaqh.size() < 10) {}
    for (;;)
    {
      return String.format("DataSet{%s %s}", new Object[] { str, localObject });
      localObject = String.format("%d data points, first 5: %s", new Object[] { Integer.valueOf(this.zzaqh.size()), ((List)localObject).subList(0, 5) });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
  
  public void zzb(DataPoint paramDataPoint)
  {
    this.zzaqh.add(paramDataPoint);
    paramDataPoint = paramDataPoint.getOriginalDataSource();
    if ((paramDataPoint != null) && (!this.zzaqi.contains(paramDataPoint))) {
      this.zzaqi.add(paramDataPoint);
    }
  }
  
  public void zzb(Iterable<DataPoint> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      zzb((DataPoint)paramIterable.next());
    }
  }
  
  List<RawDataPoint> zzr(List<DataSource> paramList)
  {
    ArrayList localArrayList = new ArrayList(this.zzaqh.size());
    Iterator localIterator = this.zzaqh.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawDataPoint((DataPoint)localIterator.next(), paramList));
    }
    return localArrayList;
  }
  
  public boolean zzsh()
  {
    return this.zzaqa;
  }
  
  List<RawDataPoint> zzsp()
  {
    return zzr(this.zzaqi);
  }
  
  List<DataSource> zzsq()
  {
    return this.zzaqi;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\DataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */