package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataDeleteRequest> CREATOR = new zzd();
  private final int mVersionCode;
  private final long zzNY;
  private final long zzapN;
  private final List<DataType> zzapW;
  private final zzoj zzasb;
  private final List<DataSource> zzasd;
  private final List<Session> zzase;
  private final boolean zzasf;
  private final boolean zzasg;
  
  DataDeleteRequest(int paramInt, long paramLong1, long paramLong2, List<DataSource> paramList, List<DataType> paramList1, List<Session> paramList2, boolean paramBoolean1, boolean paramBoolean2, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzNY = paramLong1;
    this.zzapN = paramLong2;
    this.zzasd = Collections.unmodifiableList(paramList);
    this.zzapW = Collections.unmodifiableList(paramList1);
    this.zzase = paramList2;
    this.zzasf = paramBoolean1;
    this.zzasg = paramBoolean2;
    this.zzasb = zzoj.zza.zzbJ(paramIBinder);
  }
  
  public DataDeleteRequest(long paramLong1, long paramLong2, List<DataSource> paramList, List<DataType> paramList1, List<Session> paramList2, boolean paramBoolean1, boolean paramBoolean2, zzoj paramzzoj)
  {
    this.mVersionCode = 3;
    this.zzNY = paramLong1;
    this.zzapN = paramLong2;
    this.zzasd = Collections.unmodifiableList(paramList);
    this.zzapW = Collections.unmodifiableList(paramList1);
    this.zzase = paramList2;
    this.zzasf = paramBoolean1;
    this.zzasg = paramBoolean2;
    this.zzasb = paramzzoj;
  }
  
  private DataDeleteRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), Builder.zzg(paramBuilder), null);
  }
  
  public DataDeleteRequest(DataDeleteRequest paramDataDeleteRequest, zzoj paramzzoj)
  {
    this(paramDataDeleteRequest.zzNY, paramDataDeleteRequest.zzapN, paramDataDeleteRequest.zzasd, paramDataDeleteRequest.zzapW, paramDataDeleteRequest.zzase, paramDataDeleteRequest.zzasf, paramDataDeleteRequest.zzasg, paramzzoj);
  }
  
  private boolean zzb(DataDeleteRequest paramDataDeleteRequest)
  {
    return (this.zzNY == paramDataDeleteRequest.zzNY) && (this.zzapN == paramDataDeleteRequest.zzapN) && (zzw.equal(this.zzasd, paramDataDeleteRequest.zzasd)) && (zzw.equal(this.zzapW, paramDataDeleteRequest.zzapW)) && (zzw.equal(this.zzase, paramDataDeleteRequest.zzase)) && (this.zzasf == paramDataDeleteRequest.zzasf) && (this.zzasg == paramDataDeleteRequest.zzasg);
  }
  
  public boolean deleteAllData()
  {
    return this.zzasf;
  }
  
  public boolean deleteAllSessions()
  {
    return this.zzasg;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataDeleteRequest)) && (zzb((DataDeleteRequest)paramObject)));
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
  
  public List<Session> getSessions()
  {
    return this.zzase;
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
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzNY), Long.valueOf(this.zzapN) });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("startTimeMillis", Long.valueOf(this.zzNY)).zzg("endTimeMillis", Long.valueOf(this.zzapN)).zzg("dataSources", this.zzasd).zzg("dateTypes", this.zzapW).zzg("sessions", this.zzase).zzg("deleteAllData", Boolean.valueOf(this.zzasf)).zzg("deleteAllSessions", Boolean.valueOf(this.zzasg)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public long zzkX()
  {
    return this.zzNY;
  }
  
  public IBinder zzsO()
  {
    if (this.zzasb == null) {
      return null;
    }
    return this.zzasb.asBinder();
  }
  
  public boolean zzsP()
  {
    return this.zzasf;
  }
  
  public boolean zzsQ()
  {
    return this.zzasg;
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
    private List<DataSource> zzasd = new ArrayList();
    private List<Session> zzase = new ArrayList();
    private boolean zzasf = false;
    private boolean zzasg = false;
    
    private void zzsR()
    {
      if (this.zzase.isEmpty()) {
        return;
      }
      Iterator localIterator = this.zzase.iterator();
      label23:
      Session localSession;
      if (localIterator.hasNext())
      {
        localSession = (Session)localIterator.next();
        if ((localSession.getStartTime(TimeUnit.MILLISECONDS) < this.zzNY) || (localSession.getEndTime(TimeUnit.MILLISECONDS) > this.zzapN)) {
          break label111;
        }
      }
      label111:
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Session %s is outside the time interval [%d, %d]", new Object[] { localSession, Long.valueOf(this.zzNY), Long.valueOf(this.zzapN) });
        break label23;
        break;
      }
    }
    
    public Builder addDataSource(DataSource paramDataSource)
    {
      boolean bool2 = true;
      if (!this.zzasf)
      {
        bool1 = true;
        zzx.zzb(bool1, "All data is already marked for deletion.  addDataSource() cannot be combined with deleteAllData()");
        if (paramDataSource == null) {
          break label60;
        }
      }
      label60:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zzb(bool1, "Must specify a valid data source");
        if (!this.zzasd.contains(paramDataSource)) {
          this.zzasd.add(paramDataSource);
        }
        return this;
        bool1 = false;
        break;
      }
    }
    
    public Builder addDataType(DataType paramDataType)
    {
      boolean bool2 = true;
      if (!this.zzasf)
      {
        bool1 = true;
        zzx.zzb(bool1, "All data is already marked for deletion.  addDataType() cannot be combined with deleteAllData()");
        if (paramDataType == null) {
          break label60;
        }
      }
      label60:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zzb(bool1, "Must specify a valid data type");
        if (!this.zzapW.contains(paramDataType)) {
          this.zzapW.add(paramDataType);
        }
        return this;
        bool1 = false;
        break;
      }
    }
    
    public Builder addSession(Session paramSession)
    {
      boolean bool2 = true;
      if (!this.zzasg)
      {
        bool1 = true;
        zzx.zzb(bool1, "All sessions already marked for deletion.  addSession() cannot be combined with deleteAllSessions()");
        if (paramSession == null) {
          break label67;
        }
        bool1 = true;
        label23:
        zzx.zzb(bool1, "Must specify a valid session");
        if (paramSession.getEndTime(TimeUnit.MILLISECONDS) <= 0L) {
          break label72;
        }
      }
      label67:
      label72:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zzb(bool1, "Cannot delete an ongoing session. Please stop the session prior to deleting it");
        this.zzase.add(paramSession);
        return this;
        bool1 = false;
        break;
        bool1 = false;
        break label23;
      }
    }
    
    public DataDeleteRequest build()
    {
      boolean bool2 = false;
      boolean bool1;
      int i;
      if ((this.zzNY > 0L) && (this.zzapN > this.zzNY))
      {
        bool1 = true;
        zzx.zza(bool1, "Must specify a valid time interval");
        if ((!this.zzasf) && (this.zzasd.isEmpty()) && (this.zzapW.isEmpty())) {
          break label124;
        }
        i = 1;
        label65:
        if ((!this.zzasg) && (this.zzase.isEmpty())) {
          break label129;
        }
      }
      label124:
      label129:
      for (int j = 1;; j = 0)
      {
        if (i == 0)
        {
          bool1 = bool2;
          if (j == 0) {}
        }
        else
        {
          bool1 = true;
        }
        zzx.zza(bool1, "No data or session marked for deletion");
        zzsR();
        return new DataDeleteRequest(this, null);
        bool1 = false;
        break;
        i = 0;
        break label65;
      }
    }
    
    public Builder deleteAllData()
    {
      zzx.zzb(this.zzapW.isEmpty(), "Specific data type already added for deletion. deleteAllData() will delete all data types and cannot be combined with addDataType()");
      zzx.zzb(this.zzasd.isEmpty(), "Specific data source already added for deletion. deleteAllData() will delete all data sources and cannot be combined with addDataSource()");
      this.zzasf = true;
      return this;
    }
    
    public Builder deleteAllSessions()
    {
      zzx.zzb(this.zzase.isEmpty(), "Specific session already added for deletion. deleteAllData() will delete all sessions and cannot be combined with addSession()");
      this.zzasg = true;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      if (paramLong1 > 0L)
      {
        bool = true;
        zzx.zzb(bool, "Invalid start time :%d", new Object[] { Long.valueOf(paramLong1) });
        if (paramLong2 <= paramLong1) {
          break label82;
        }
      }
      label82:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Invalid end time :%d", new Object[] { Long.valueOf(paramLong2) });
        this.zzNY = paramTimeUnit.toMillis(paramLong1);
        this.zzapN = paramTimeUnit.toMillis(paramLong2);
        return this;
        bool = false;
        break;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\DataDeleteRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */