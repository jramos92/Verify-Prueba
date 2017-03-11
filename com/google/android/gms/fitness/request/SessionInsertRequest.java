package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zznj;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionInsertRequest> CREATOR = new zzu();
  private final int mVersionCode;
  private final Session zzapP;
  private final List<DataSet> zzapY;
  private final List<DataPoint> zzasQ;
  private final zzoj zzasb;
  
  SessionInsertRequest(int paramInt, Session paramSession, List<DataSet> paramList, List<DataPoint> paramList1, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzapP = paramSession;
    this.zzapY = Collections.unmodifiableList(paramList);
    this.zzasQ = Collections.unmodifiableList(paramList1);
    this.zzasb = zzoj.zza.zzbJ(paramIBinder);
  }
  
  public SessionInsertRequest(Session paramSession, List<DataSet> paramList, List<DataPoint> paramList1, zzoj paramzzoj)
  {
    this.mVersionCode = 3;
    this.zzapP = paramSession;
    this.zzapY = Collections.unmodifiableList(paramList);
    this.zzasQ = Collections.unmodifiableList(paramList1);
    this.zzasb = paramzzoj;
  }
  
  private SessionInsertRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), null);
  }
  
  public SessionInsertRequest(SessionInsertRequest paramSessionInsertRequest, zzoj paramzzoj)
  {
    this(paramSessionInsertRequest.zzapP, paramSessionInsertRequest.zzapY, paramSessionInsertRequest.zzasQ, paramzzoj);
  }
  
  private boolean zzb(SessionInsertRequest paramSessionInsertRequest)
  {
    return (zzw.equal(this.zzapP, paramSessionInsertRequest.zzapP)) && (zzw.equal(this.zzapY, paramSessionInsertRequest.zzapY)) && (zzw.equal(this.zzasQ, paramSessionInsertRequest.zzasQ));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof SessionInsertRequest)) && (zzb((SessionInsertRequest)paramObject)));
  }
  
  public List<DataPoint> getAggregateDataPoints()
  {
    return this.zzasQ;
  }
  
  public List<DataSet> getDataSets()
  {
    return this.zzapY;
  }
  
  public Session getSession()
  {
    return this.zzapP;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzapP, this.zzapY, this.zzasQ });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("session", this.zzapP).zzg("dataSets", this.zzapY).zzg("aggregateDataPoints", this.zzasQ).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzu.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzasb == null) {
      return null;
    }
    return this.zzasb.asBinder();
  }
  
  public static class Builder
  {
    private Session zzapP;
    private List<DataSet> zzapY = new ArrayList();
    private List<DataPoint> zzasQ = new ArrayList();
    private List<DataSource> zzasR = new ArrayList();
    
    private void zzd(DataPoint paramDataPoint)
    {
      zzf(paramDataPoint);
      zze(paramDataPoint);
    }
    
    private void zze(DataPoint paramDataPoint)
    {
      long l3 = this.zzapP.getStartTime(TimeUnit.NANOSECONDS);
      long l4 = this.zzapP.getEndTime(TimeUnit.NANOSECONDS);
      long l5 = paramDataPoint.getStartTime(TimeUnit.NANOSECONDS);
      long l2 = paramDataPoint.getEndTime(TimeUnit.NANOSECONDS);
      TimeUnit localTimeUnit;
      long l1;
      if ((l5 != 0L) && (l2 != 0L))
      {
        localTimeUnit = TimeUnit.MILLISECONDS;
        l1 = l2;
        if (l2 > l4) {
          l1 = zznj.zza(l2, TimeUnit.NANOSECONDS, localTimeUnit);
        }
        if ((l5 < l3) || (l1 > l4)) {
          break label196;
        }
      }
      label196:
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Data point %s has start and end times outside session interval [%d, %d]", new Object[] { paramDataPoint, Long.valueOf(l3), Long.valueOf(l4) });
        if (l1 != paramDataPoint.getEndTime(TimeUnit.NANOSECONDS))
        {
          Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[] { Long.valueOf(paramDataPoint.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(l1), localTimeUnit }));
          paramDataPoint.setTimeInterval(l5, l1, TimeUnit.NANOSECONDS);
        }
        return;
      }
    }
    
    private void zzf(DataPoint paramDataPoint)
    {
      long l3 = this.zzapP.getStartTime(TimeUnit.NANOSECONDS);
      long l4 = this.zzapP.getEndTime(TimeUnit.NANOSECONDS);
      long l2 = paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS);
      TimeUnit localTimeUnit;
      long l1;
      if (l2 != 0L)
      {
        localTimeUnit = TimeUnit.MILLISECONDS;
        if (l2 >= l3)
        {
          l1 = l2;
          if (l2 <= l4) {}
        }
        else
        {
          l1 = zznj.zza(l2, TimeUnit.NANOSECONDS, localTimeUnit);
        }
        if ((l1 < l3) || (l1 > l4)) {
          break label185;
        }
      }
      label185:
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Data point %s has time stamp outside session interval [%d, %d]", new Object[] { paramDataPoint, Long.valueOf(l3), Long.valueOf(l4) });
        if (paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS) != l1)
        {
          Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[] { Long.valueOf(paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(l1), localTimeUnit }));
          paramDataPoint.setTimestamp(l1, TimeUnit.NANOSECONDS);
        }
        return;
      }
    }
    
    private void zzth()
    {
      Iterator localIterator1 = this.zzapY.iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((DataSet)localIterator1.next()).getDataPoints().iterator();
        while (localIterator2.hasNext()) {
          zzd((DataPoint)localIterator2.next());
        }
      }
      localIterator1 = this.zzasQ.iterator();
      while (localIterator1.hasNext()) {
        zzd((DataPoint)localIterator1.next());
      }
    }
    
    public Builder addAggregateDataPoint(DataPoint paramDataPoint)
    {
      label44:
      DataSource localDataSource;
      if (paramDataPoint != null)
      {
        bool = true;
        zzx.zzb(bool, "Must specify a valid aggregate data point.");
        long l1 = paramDataPoint.getStartTime(TimeUnit.NANOSECONDS);
        long l2 = paramDataPoint.getEndTime(TimeUnit.NANOSECONDS);
        if ((l1 <= 0L) || (l2 <= l1)) {
          break label125;
        }
        bool = true;
        zzx.zzb(bool, "Aggregate data point should have valid start and end times: %s", new Object[] { paramDataPoint });
        localDataSource = paramDataPoint.getDataSource();
        if (this.zzasR.contains(localDataSource)) {
          break label130;
        }
      }
      label125:
      label130:
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Data set/Aggregate data point for this data source %s is already added.", new Object[] { localDataSource });
        this.zzasR.add(localDataSource);
        this.zzasQ.add(paramDataPoint);
        return this;
        bool = false;
        break;
        bool = false;
        break label44;
      }
    }
    
    public Builder addDataSet(DataSet paramDataSet)
    {
      boolean bool2 = true;
      DataSource localDataSource;
      if (paramDataSet != null)
      {
        bool1 = true;
        zzx.zzb(bool1, "Must specify a valid data set.");
        localDataSource = paramDataSet.getDataSource();
        if (this.zzasR.contains(localDataSource)) {
          break label101;
        }
        bool1 = true;
        label36:
        zzx.zza(bool1, "Data set for this data source %s is already added.", new Object[] { localDataSource });
        if (paramDataSet.getDataPoints().isEmpty()) {
          break label106;
        }
      }
      label101:
      label106:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zzb(bool1, "No data points specified in the input data set.");
        this.zzasR.add(localDataSource);
        this.zzapY.add(paramDataSet);
        return this;
        bool1 = false;
        break;
        bool1 = false;
        break label36;
      }
    }
    
    public SessionInsertRequest build()
    {
      boolean bool2 = true;
      if (this.zzapP != null)
      {
        bool1 = true;
        zzx.zza(bool1, "Must specify a valid session.");
        if (this.zzapP.getEndTime(TimeUnit.MILLISECONDS) == 0L) {
          break label59;
        }
      }
      label59:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zza(bool1, "Must specify a valid end time, cannot insert a continuing session.");
        zzth();
        return new SessionInsertRequest(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder setSession(Session paramSession)
    {
      this.zzapP = paramSession;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\SessionInsertRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */