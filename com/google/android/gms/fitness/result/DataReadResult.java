package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataReadResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<DataReadResult> CREATOR = new zzc();
  private final int mVersionCode;
  private final Status zzSC;
  private final List<DataSet> zzapY;
  private final List<DataSource> zzaqi;
  private final List<Bucket> zzatd;
  private int zzate;
  private final List<DataType> zzatf;
  
  DataReadResult(int paramInt1, List<RawDataSet> paramList, Status paramStatus, List<RawBucket> paramList1, int paramInt2, List<DataSource> paramList2, List<DataType> paramList3)
  {
    this.mVersionCode = paramInt1;
    this.zzSC = paramStatus;
    this.zzate = paramInt2;
    this.zzaqi = paramList2;
    this.zzatf = paramList3;
    this.zzapY = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramStatus = (RawDataSet)paramList.next();
      this.zzapY.add(new DataSet(paramStatus, paramList2));
    }
    this.zzatd = new ArrayList(paramList1.size());
    paramList = paramList1.iterator();
    while (paramList.hasNext())
    {
      paramStatus = (RawBucket)paramList.next();
      this.zzatd.add(new Bucket(paramStatus, paramList2));
    }
  }
  
  public DataReadResult(List<DataSet> paramList, List<Bucket> paramList1, Status paramStatus)
  {
    this.mVersionCode = 5;
    this.zzapY = paramList;
    this.zzSC = paramStatus;
    this.zzatd = paramList1;
    this.zzate = 1;
    this.zzaqi = new ArrayList();
    this.zzatf = new ArrayList();
  }
  
  public static DataReadResult zza(Status paramStatus, DataReadRequest paramDataReadRequest)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramDataReadRequest.getDataSources().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(DataSet.create((DataSource)((Iterator)localObject).next()));
    }
    paramDataReadRequest = paramDataReadRequest.getDataTypes().iterator();
    while (paramDataReadRequest.hasNext())
    {
      localObject = (DataType)paramDataReadRequest.next();
      localArrayList.add(DataSet.create(new DataSource.Builder().setDataType((DataType)localObject).setType(1).setName("Default").build()));
    }
    return new DataReadResult(localArrayList, Collections.emptyList(), paramStatus);
  }
  
  private void zza(Bucket paramBucket, List<Bucket> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (Bucket)localIterator.next();
      if (paramList.zzb(paramBucket))
      {
        paramBucket = paramBucket.getDataSets().iterator();
        while (paramBucket.hasNext()) {
          zza((DataSet)paramBucket.next(), paramList.getDataSets());
        }
      }
    }
    this.zzatd.add(paramBucket);
  }
  
  private void zza(DataSet paramDataSet, List<DataSet> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (localDataSet.getDataSource().equals(paramDataSet.getDataSource()))
      {
        localDataSet.zzb(paramDataSet.getDataPoints());
        return;
      }
    }
    paramList.add(paramDataSet);
  }
  
  private boolean zzc(DataReadResult paramDataReadResult)
  {
    return (this.zzSC.equals(paramDataReadResult.zzSC)) && (zzw.equal(this.zzapY, paramDataReadResult.zzapY)) && (zzw.equal(this.zzatd, paramDataReadResult.zzatd));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataReadResult)) && (zzc((DataReadResult)paramObject)));
  }
  
  public List<Bucket> getBuckets()
  {
    return this.zzatd;
  }
  
  public DataSet getDataSet(DataSource paramDataSource)
  {
    Iterator localIterator = this.zzapY.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (paramDataSource.equals(localDataSet.getDataSource())) {
        return localDataSet;
      }
    }
    return DataSet.create(paramDataSource);
  }
  
  public DataSet getDataSet(DataType paramDataType)
  {
    Iterator localIterator = this.zzapY.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (paramDataType.equals(localDataSet.getDataType())) {
        return localDataSet;
      }
    }
    return DataSet.create(new DataSource.Builder().setDataType(paramDataType).setType(1).build());
  }
  
  public List<DataSet> getDataSets()
  {
    return this.zzapY;
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
    return zzw.hashCode(new Object[] { this.zzSC, this.zzapY, this.zzatd });
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzv(this).zzg("status", this.zzSC);
    if (this.zzapY.size() > 5)
    {
      localObject = this.zzapY.size() + " data sets";
      localzza = localzza.zzg("dataSets", localObject);
      if (this.zzatd.size() <= 5) {
        break label123;
      }
    }
    label123:
    for (Object localObject = this.zzatd.size() + " buckets";; localObject = this.zzatd)
    {
      return localzza.zzg("buckets", localObject).toString();
      localObject = this.zzapY;
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public void zzb(DataReadResult paramDataReadResult)
  {
    Iterator localIterator = paramDataReadResult.getDataSets().iterator();
    while (localIterator.hasNext()) {
      zza((DataSet)localIterator.next(), this.zzapY);
    }
    paramDataReadResult = paramDataReadResult.getBuckets().iterator();
    while (paramDataReadResult.hasNext()) {
      zza((Bucket)paramDataReadResult.next(), this.zzatd);
    }
  }
  
  List<DataSource> zzsq()
  {
    return this.zzaqi;
  }
  
  public int zztn()
  {
    return this.zzate;
  }
  
  List<RawBucket> zzto()
  {
    ArrayList localArrayList = new ArrayList(this.zzatd.size());
    Iterator localIterator = this.zzatd.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawBucket((Bucket)localIterator.next(), this.zzaqi, this.zzatf));
    }
    return localArrayList;
  }
  
  List<RawDataSet> zztp()
  {
    ArrayList localArrayList = new ArrayList(this.zzapY.size());
    Iterator localIterator = this.zzapY.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(new RawDataSet((DataSet)localIterator.next(), this.zzaqi, this.zzatf));
    }
    return localArrayList;
  }
  
  List<DataType> zztq()
  {
    return this.zzatf;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\DataReadResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */