package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class DataSourcesResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<DataSourcesResult> CREATOR = new zze();
  private final int mVersionCode;
  private final Status zzSC;
  private final List<DataSource> zzasd;
  
  DataSourcesResult(int paramInt, List<DataSource> paramList, Status paramStatus)
  {
    this.mVersionCode = paramInt;
    this.zzasd = Collections.unmodifiableList(paramList);
    this.zzSC = paramStatus;
  }
  
  public DataSourcesResult(List<DataSource> paramList, Status paramStatus)
  {
    this.mVersionCode = 3;
    this.zzasd = Collections.unmodifiableList(paramList);
    this.zzSC = paramStatus;
  }
  
  public static DataSourcesResult zzQ(Status paramStatus)
  {
    return new DataSourcesResult(Collections.emptyList(), paramStatus);
  }
  
  private boolean zzb(DataSourcesResult paramDataSourcesResult)
  {
    return (this.zzSC.equals(paramDataSourcesResult.zzSC)) && (zzw.equal(this.zzasd, paramDataSourcesResult.zzasd));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataSourcesResult)) && (zzb((DataSourcesResult)paramObject)));
  }
  
  public List<DataSource> getDataSources()
  {
    return this.zzasd;
  }
  
  public List<DataSource> getDataSources(DataType paramDataType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzasd.iterator();
    while (localIterator.hasNext())
    {
      DataSource localDataSource = (DataSource)localIterator.next();
      if (localDataSource.getDataType().equals(paramDataType)) {
        localArrayList.add(localDataSource);
      }
    }
    return Collections.unmodifiableList(localArrayList);
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
    return zzw.hashCode(new Object[] { this.zzSC, this.zzasd });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("status", this.zzSC).zzg("dataSets", this.zzasd).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\DataSourcesResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */