package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket
  implements SafeParcelable
{
  public static final Parcelable.Creator<Bucket> CREATOR = new zzc();
  public static final int TYPE_ACTIVITY_SEGMENT = 4;
  public static final int TYPE_ACTIVITY_TYPE = 3;
  public static final int TYPE_SESSION = 2;
  public static final int TYPE_TIME = 1;
  private final int mVersionCode;
  private final long zzNY;
  private final long zzapN;
  private final Session zzapP;
  private final int zzapX;
  private final List<DataSet> zzapY;
  private final int zzapZ;
  private boolean zzaqa = false;
  
  Bucket(int paramInt1, long paramLong1, long paramLong2, Session paramSession, int paramInt2, List<DataSet> paramList, int paramInt3, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzNY = paramLong1;
    this.zzapN = paramLong2;
    this.zzapP = paramSession;
    this.zzapX = paramInt2;
    this.zzapY = paramList;
    this.zzapZ = paramInt3;
    this.zzaqa = paramBoolean;
  }
  
  public Bucket(RawBucket paramRawBucket, List<DataSource> paramList)
  {
    this(2, paramRawBucket.zzNY, paramRawBucket.zzapN, paramRawBucket.zzapP, paramRawBucket.zzaqT, zza(paramRawBucket.zzapY, paramList), paramRawBucket.zzapZ, paramRawBucket.zzaqa);
  }
  
  private static List<DataSet> zza(Collection<RawDataSet> paramCollection, List<DataSource> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(new DataSet((RawDataSet)paramCollection.next(), paramList));
    }
    return localArrayList;
  }
  
  private boolean zza(Bucket paramBucket)
  {
    return (this.zzNY == paramBucket.zzNY) && (this.zzapN == paramBucket.zzapN) && (this.zzapX == paramBucket.zzapX) && (zzw.equal(this.zzapY, paramBucket.zzapY)) && (this.zzapZ == paramBucket.zzapZ) && (this.zzaqa == paramBucket.zzaqa);
  }
  
  public static String zzeu(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "bug";
    case 1: 
      return "time";
    case 3: 
      return "type";
    case 4: 
      return "segment";
    case 2: 
      return "session";
    }
    return "unknown";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof Bucket)) && (zza((Bucket)paramObject)));
  }
  
  public String getActivity()
  {
    return FitnessActivities.getName(this.zzapX);
  }
  
  public int getBucketType()
  {
    return this.zzapZ;
  }
  
  public DataSet getDataSet(DataType paramDataType)
  {
    Iterator localIterator = this.zzapY.iterator();
    while (localIterator.hasNext())
    {
      DataSet localDataSet = (DataSet)localIterator.next();
      if (localDataSet.getDataType().equals(paramDataType)) {
        return localDataSet;
      }
    }
    return null;
  }
  
  public List<DataSet> getDataSets()
  {
    return this.zzapY;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzapN, TimeUnit.MILLISECONDS);
  }
  
  public Session getSession()
  {
    return this.zzapP;
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
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzNY), Long.valueOf(this.zzapN), Integer.valueOf(this.zzapX), Integer.valueOf(this.zzapZ) });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("startTime", Long.valueOf(this.zzNY)).zzg("endTime", Long.valueOf(this.zzapN)).zzg("activity", Integer.valueOf(this.zzapX)).zzg("dataSets", this.zzapY).zzg("bucketType", zzeu(this.zzapZ)).zzg("serverHasMoreData", Boolean.valueOf(this.zzaqa)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzb(Bucket paramBucket)
  {
    return (this.zzNY == paramBucket.zzNY) && (this.zzapN == paramBucket.zzapN) && (this.zzapX == paramBucket.zzapX) && (this.zzapZ == paramBucket.zzapZ);
  }
  
  public long zzkX()
  {
    return this.zzNY;
  }
  
  public int zzsg()
  {
    return this.zzapX;
  }
  
  public boolean zzsh()
  {
    if (this.zzaqa) {
      return true;
    }
    Iterator localIterator = this.zzapY.iterator();
    while (localIterator.hasNext()) {
      if (((DataSet)localIterator.next()).zzsh()) {
        return true;
      }
    }
    return false;
  }
  
  public long zzsi()
  {
    return this.zzapN;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\Bucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */