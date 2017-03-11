package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawBucket
  implements SafeParcelable
{
  public static final Parcelable.Creator<RawBucket> CREATOR = new zzm();
  final int mVersionCode;
  public final long zzNY;
  public final long zzapN;
  public final Session zzapP;
  public final List<RawDataSet> zzapY;
  public final int zzapZ;
  public final int zzaqT;
  public final boolean zzaqa;
  
  public RawBucket(int paramInt1, long paramLong1, long paramLong2, Session paramSession, int paramInt2, List<RawDataSet> paramList, int paramInt3, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzNY = paramLong1;
    this.zzapN = paramLong2;
    this.zzapP = paramSession;
    this.zzaqT = paramInt2;
    this.zzapY = paramList;
    this.zzapZ = paramInt3;
    this.zzaqa = paramBoolean;
  }
  
  public RawBucket(Bucket paramBucket, List<DataSource> paramList, List<DataType> paramList1)
  {
    this.mVersionCode = 2;
    this.zzNY = paramBucket.getStartTime(TimeUnit.MILLISECONDS);
    this.zzapN = paramBucket.getEndTime(TimeUnit.MILLISECONDS);
    this.zzapP = paramBucket.getSession();
    this.zzaqT = paramBucket.zzsg();
    this.zzapZ = paramBucket.getBucketType();
    this.zzaqa = paramBucket.zzsh();
    paramBucket = paramBucket.getDataSets();
    this.zzapY = new ArrayList(paramBucket.size());
    paramBucket = paramBucket.iterator();
    while (paramBucket.hasNext())
    {
      DataSet localDataSet = (DataSet)paramBucket.next();
      this.zzapY.add(new RawDataSet(localDataSet, paramList, paramList1));
    }
  }
  
  private boolean zza(RawBucket paramRawBucket)
  {
    return (this.zzNY == paramRawBucket.zzNY) && (this.zzapN == paramRawBucket.zzapN) && (this.zzaqT == paramRawBucket.zzaqT) && (zzw.equal(this.zzapY, paramRawBucket.zzapY)) && (this.zzapZ == paramRawBucket.zzapZ) && (this.zzaqa == paramRawBucket.zzaqa);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof RawBucket)) && (zza((RawBucket)paramObject)));
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzNY), Long.valueOf(this.zzapN), Integer.valueOf(this.zzapZ) });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("startTime", Long.valueOf(this.zzNY)).zzg("endTime", Long.valueOf(this.zzapN)).zzg("activity", Integer.valueOf(this.zzaqT)).zzg("dataSets", this.zzapY).zzg("bucketType", Integer.valueOf(this.zzapZ)).zzg("serverHasMoreData", Boolean.valueOf(this.zzaqa)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\RawBucket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */