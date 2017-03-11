package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.internal.zznu;
import com.google.android.gms.internal.zznu.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DataReadRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataReadRequest> CREATOR = new zzf();
  public static final int NO_LIMIT = 0;
  private final int mVersionCode;
  private final long zzNY;
  private final long zzapN;
  private final List<DataType> zzapW;
  private final int zzapZ;
  private final List<DataSource> zzasd;
  private final List<DataType> zzasi;
  private final List<DataSource> zzasj;
  private final long zzask;
  private final DataSource zzasl;
  private final int zzasm;
  private final boolean zzasn;
  private final boolean zzaso;
  private final zznu zzasp;
  private final List<Device> zzasq;
  
  DataReadRequest(int paramInt1, List<DataType> paramList1, List<DataSource> paramList2, long paramLong1, long paramLong2, List<DataType> paramList3, List<DataSource> paramList4, int paramInt2, long paramLong3, DataSource paramDataSource, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, IBinder paramIBinder, List<Device> paramList)
  {
    this.mVersionCode = paramInt1;
    this.zzapW = paramList1;
    this.zzasd = paramList2;
    this.zzNY = paramLong1;
    this.zzapN = paramLong2;
    this.zzasi = paramList3;
    this.zzasj = paramList4;
    this.zzapZ = paramInt2;
    this.zzask = paramLong3;
    this.zzasl = paramDataSource;
    this.zzasm = paramInt3;
    this.zzasn = paramBoolean1;
    this.zzaso = paramBoolean2;
    if (paramIBinder == null) {}
    for (paramList1 = null;; paramList1 = zznu.zza.zzbu(paramIBinder))
    {
      this.zzasp = paramList1;
      paramList1 = paramList;
      if (paramList == null) {
        paramList1 = Collections.EMPTY_LIST;
      }
      this.zzasq = paramList1;
      return;
    }
  }
  
  private DataReadRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), Builder.zzg(paramBuilder), Builder.zzh(paramBuilder), Builder.zzi(paramBuilder), Builder.zzj(paramBuilder), Builder.zzk(paramBuilder), Builder.zzl(paramBuilder), null, Builder.zzm(paramBuilder));
  }
  
  public DataReadRequest(DataReadRequest paramDataReadRequest, zznu paramzznu)
  {
    this(paramDataReadRequest.zzapW, paramDataReadRequest.zzasd, paramDataReadRequest.zzNY, paramDataReadRequest.zzapN, paramDataReadRequest.zzasi, paramDataReadRequest.zzasj, paramDataReadRequest.zzapZ, paramDataReadRequest.zzask, paramDataReadRequest.zzasl, paramDataReadRequest.zzasm, paramDataReadRequest.zzasn, paramDataReadRequest.zzaso, paramzznu, paramDataReadRequest.zzasq);
  }
  
  public DataReadRequest(List<DataType> paramList1, List<DataSource> paramList2, long paramLong1, long paramLong2, List<DataType> paramList3, List<DataSource> paramList4, int paramInt1, long paramLong3, DataSource paramDataSource, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, zznu paramzznu, List<Device> paramList) {}
  
  private boolean zzb(DataReadRequest paramDataReadRequest)
  {
    return (this.zzapW.equals(paramDataReadRequest.zzapW)) && (this.zzasd.equals(paramDataReadRequest.zzasd)) && (this.zzNY == paramDataReadRequest.zzNY) && (this.zzapN == paramDataReadRequest.zzapN) && (this.zzapZ == paramDataReadRequest.zzapZ) && (this.zzasj.equals(paramDataReadRequest.zzasj)) && (this.zzasi.equals(paramDataReadRequest.zzasi)) && (zzw.equal(this.zzasl, paramDataReadRequest.zzasl)) && (this.zzask == paramDataReadRequest.zzask) && (this.zzaso == paramDataReadRequest.zzaso);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataReadRequest)) && (zzb((DataReadRequest)paramObject)));
  }
  
  public DataSource getActivityDataSource()
  {
    return this.zzasl;
  }
  
  public List<DataSource> getAggregatedDataSources()
  {
    return this.zzasj;
  }
  
  public List<DataType> getAggregatedDataTypes()
  {
    return this.zzasi;
  }
  
  public long getBucketDuration(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzask, TimeUnit.MILLISECONDS);
  }
  
  public int getBucketType()
  {
    return this.zzapZ;
  }
  
  public List<DataSource> getDataSources()
  {
    return this.zzasd;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.zzapW;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzapN, TimeUnit.MILLISECONDS);
  }
  
  public int getLimit()
  {
    return this.zzasm;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzNY, TimeUnit.MILLISECONDS);
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.zzapZ), Long.valueOf(this.zzNY), Long.valueOf(this.zzapN) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DataReadRequest{");
    Iterator localIterator;
    if (!this.zzapW.isEmpty())
    {
      localIterator = this.zzapW.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((DataType)localIterator.next()).zzst()).append(" ");
      }
    }
    if (!this.zzasd.isEmpty())
    {
      localIterator = this.zzasd.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((DataSource)localIterator.next()).toDebugString()).append(" ");
      }
    }
    if (this.zzapZ != 0)
    {
      localStringBuilder.append("bucket by ").append(Bucket.zzeu(this.zzapZ));
      if (this.zzask > 0L) {
        localStringBuilder.append(" >").append(this.zzask).append("ms");
      }
      localStringBuilder.append(": ");
    }
    if (!this.zzasi.isEmpty())
    {
      localIterator = this.zzasi.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((DataType)localIterator.next()).zzst()).append(" ");
      }
    }
    if (!this.zzasj.isEmpty())
    {
      localIterator = this.zzasj.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((DataSource)localIterator.next()).toDebugString()).append(" ");
      }
    }
    localStringBuilder.append(String.format("(%tF %tT - %tF %tT)", new Object[] { Long.valueOf(this.zzNY), Long.valueOf(this.zzNY), Long.valueOf(this.zzapN), Long.valueOf(this.zzapN) }));
    if (this.zzasl != null) {
      localStringBuilder.append("activities: ").append(this.zzasl.toDebugString());
    }
    if (this.zzaso) {
      localStringBuilder.append(" +server");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public long zzkX()
  {
    return this.zzNY;
  }
  
  public IBinder zzsO()
  {
    if (this.zzasp == null) {
      return null;
    }
    return this.zzasp.asBinder();
  }
  
  public boolean zzsT()
  {
    return this.zzaso;
  }
  
  public boolean zzsU()
  {
    return this.zzasn;
  }
  
  public long zzsV()
  {
    return this.zzask;
  }
  
  public List<Device> zzsW()
  {
    return this.zzasq;
  }
  
  public long zzsi()
  {
    return this.zzapN;
  }
  
  public static class Builder
  {
    private long zzNY;
    private long zzapN;
    private List<DataType> zzapW = new ArrayList();
    private int zzapZ = 0;
    private List<DataSource> zzasd = new ArrayList();
    private List<DataType> zzasi = new ArrayList();
    private List<DataSource> zzasj = new ArrayList();
    private long zzask = 0L;
    private DataSource zzasl;
    private int zzasm = 0;
    private boolean zzasn = false;
    private boolean zzaso = false;
    private List<Device> zzasq = new ArrayList();
    
    public Builder aggregate(DataSource paramDataSource, DataType paramDataType)
    {
      zzx.zzb(paramDataSource, "Attempting to add a null data source");
      if (!this.zzasd.contains(paramDataSource)) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Cannot add the same data source for aggregated and detailed");
        DataType localDataType = paramDataSource.getDataType();
        zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(localDataType), "Unsupported input data type specified for aggregation: %s", new Object[] { localDataType });
        zzx.zzb(DataType.getAggregatesForInput(localDataType).contains(paramDataType), "Invalid output aggregate data type specified: %s -> %s", new Object[] { localDataType, paramDataType });
        if (!this.zzasj.contains(paramDataSource)) {
          this.zzasj.add(paramDataSource);
        }
        return this;
      }
    }
    
    public Builder aggregate(DataType paramDataType1, DataType paramDataType2)
    {
      zzx.zzb(paramDataType1, "Attempting to use a null data type");
      if (!this.zzapW.contains(paramDataType1)) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Cannot add the same data type as aggregated and detailed");
        zzx.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(paramDataType1), "Unsupported input data type specified for aggregation: %s", new Object[] { paramDataType1 });
        zzx.zzb(DataType.getAggregatesForInput(paramDataType1).contains(paramDataType2), "Invalid output aggregate data type specified: %s -> %s", new Object[] { paramDataType1, paramDataType2 });
        if (!this.zzasi.contains(paramDataType1)) {
          this.zzasi.add(paramDataType1);
        }
        return this;
      }
    }
    
    public Builder bucketByActivitySegment(int paramInt, TimeUnit paramTimeUnit)
    {
      if (this.zzapZ == 0)
      {
        bool = true;
        zzx.zzb(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzapZ) });
        if (paramInt <= 0) {
          break label74;
        }
      }
      label74:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        this.zzapZ = 4;
        this.zzask = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
      }
    }
    
    public Builder bucketByActivitySegment(int paramInt, TimeUnit paramTimeUnit, DataSource paramDataSource)
    {
      if (this.zzapZ == 0)
      {
        bool = true;
        zzx.zzb(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzapZ) });
        if (paramInt <= 0) {
          break label121;
        }
        bool = true;
        label38:
        zzx.zzb(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramDataSource == null) {
          break label127;
        }
      }
      label121:
      label127:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Invalid activity data source specified");
        zzx.zzb(paramDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[] { paramDataSource });
        this.zzasl = paramDataSource;
        this.zzapZ = 4;
        this.zzask = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
        bool = false;
        break label38;
      }
    }
    
    public Builder bucketByActivityType(int paramInt, TimeUnit paramTimeUnit)
    {
      if (this.zzapZ == 0)
      {
        bool = true;
        zzx.zzb(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzapZ) });
        if (paramInt <= 0) {
          break label74;
        }
      }
      label74:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        this.zzapZ = 3;
        this.zzask = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
      }
    }
    
    public Builder bucketByActivityType(int paramInt, TimeUnit paramTimeUnit, DataSource paramDataSource)
    {
      if (this.zzapZ == 0)
      {
        bool = true;
        zzx.zzb(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzapZ) });
        if (paramInt <= 0) {
          break label121;
        }
        bool = true;
        label38:
        zzx.zzb(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        if (paramDataSource == null) {
          break label127;
        }
      }
      label121:
      label127:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Invalid activity data source specified");
        zzx.zzb(paramDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", new Object[] { paramDataSource });
        this.zzasl = paramDataSource;
        this.zzapZ = 3;
        this.zzask = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
        bool = false;
        break label38;
      }
    }
    
    public Builder bucketBySession(int paramInt, TimeUnit paramTimeUnit)
    {
      if (this.zzapZ == 0)
      {
        bool = true;
        zzx.zzb(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzapZ) });
        if (paramInt <= 0) {
          break label74;
        }
      }
      label74:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        this.zzapZ = 2;
        this.zzask = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
      }
    }
    
    public Builder bucketByTime(int paramInt, TimeUnit paramTimeUnit)
    {
      if (this.zzapZ == 0)
      {
        bool = true;
        zzx.zzb(bool, "Bucketing strategy already set to %s", new Object[] { Integer.valueOf(this.zzapZ) });
        if (paramInt <= 0) {
          break label74;
        }
      }
      label74:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Must specify a valid minimum duration for an activity segment: %d", new Object[] { Integer.valueOf(paramInt) });
        this.zzapZ = 1;
        this.zzask = paramTimeUnit.toMillis(paramInt);
        return this;
        bool = false;
        break;
      }
    }
    
    public DataReadRequest build()
    {
      boolean bool2 = true;
      label69:
      label112:
      int i;
      if ((!this.zzasd.isEmpty()) || (!this.zzapW.isEmpty()) || (!this.zzasj.isEmpty()) || (!this.zzasi.isEmpty()))
      {
        bool1 = true;
        zzx.zza(bool1, "Must add at least one data source (aggregated or detailed)");
        if (this.zzNY <= 0L) {
          break label205;
        }
        bool1 = true;
        zzx.zza(bool1, "Invalid start time: %s", new Object[] { Long.valueOf(this.zzNY) });
        if ((this.zzapN <= 0L) || (this.zzapN <= this.zzNY)) {
          break label210;
        }
        bool1 = true;
        zzx.zza(bool1, "Invalid end time: %s", new Object[] { Long.valueOf(this.zzapN) });
        if ((!this.zzasj.isEmpty()) || (!this.zzasi.isEmpty())) {
          break label215;
        }
        i = 1;
        label158:
        if (i != 0)
        {
          bool1 = bool2;
          if (this.zzapZ == 0) {}
        }
        else
        {
          if ((i != 0) || (this.zzapZ == 0)) {
            break label220;
          }
        }
      }
      label205:
      label210:
      label215:
      label220:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zza(bool1, "Must specify a valid bucketing strategy while requesting aggregation");
        return new DataReadRequest(this, null);
        bool1 = false;
        break;
        bool1 = false;
        break label69;
        bool1 = false;
        break label112;
        i = 0;
        break label158;
      }
    }
    
    public Builder enableServerQueries()
    {
      this.zzaso = true;
      return this;
    }
    
    public Builder read(DataSource paramDataSource)
    {
      zzx.zzb(paramDataSource, "Attempting to add a null data source");
      if (!this.zzasj.contains(paramDataSource)) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Cannot add the same data source as aggregated and detailed");
        if (!this.zzasd.contains(paramDataSource)) {
          this.zzasd.add(paramDataSource);
        }
        return this;
      }
    }
    
    public Builder read(DataType paramDataType)
    {
      zzx.zzb(paramDataType, "Attempting to use a null data type");
      if (!this.zzasi.contains(paramDataType)) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Cannot add the same data type as aggregated and detailed");
        if (!this.zzapW.contains(paramDataType)) {
          this.zzapW.add(paramDataType);
        }
        return this;
      }
    }
    
    public Builder setLimit(int paramInt)
    {
      if (paramInt > 0) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Invalid limit %d is specified", new Object[] { Integer.valueOf(paramInt) });
        this.zzasm = paramInt;
        return this;
      }
    }
    
    public Builder setTimeRange(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      this.zzNY = paramTimeUnit.toMillis(paramLong1);
      this.zzapN = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\DataReadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */