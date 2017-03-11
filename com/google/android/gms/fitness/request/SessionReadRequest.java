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
import com.google.android.gms.internal.zzoh;
import com.google.android.gms.internal.zzoh.zza;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionReadRequest> CREATOR = new zzv();
  private final int mVersionCode;
  private final String zzHP;
  private final long zzNY;
  private final long zzapN;
  private final List<DataType> zzapW;
  private final String zzasS;
  private boolean zzasT;
  private final List<String> zzasU;
  private final zzoh zzasV;
  private final List<DataSource> zzasd;
  private final boolean zzaso;
  
  SessionReadRequest(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, List<DataType> paramList, List<DataSource> paramList1, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList2, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzasS = paramString1;
    this.zzHP = paramString2;
    this.zzNY = paramLong1;
    this.zzapN = paramLong2;
    this.zzapW = paramList;
    this.zzasd = paramList1;
    this.zzasT = paramBoolean1;
    this.zzaso = paramBoolean2;
    this.zzasU = paramList2;
    this.zzasV = zzoh.zza.zzbH(paramIBinder);
  }
  
  private SessionReadRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder), Builder.zze(paramBuilder), Builder.zzf(paramBuilder), Builder.zzg(paramBuilder), Builder.zzh(paramBuilder), Builder.zzi(paramBuilder), null);
  }
  
  public SessionReadRequest(SessionReadRequest paramSessionReadRequest, zzoh paramzzoh)
  {
    this(paramSessionReadRequest.zzasS, paramSessionReadRequest.zzHP, paramSessionReadRequest.zzNY, paramSessionReadRequest.zzapN, paramSessionReadRequest.zzapW, paramSessionReadRequest.zzasd, paramSessionReadRequest.zzasT, paramSessionReadRequest.zzaso, paramSessionReadRequest.zzasU, paramzzoh);
  }
  
  public SessionReadRequest(String paramString1, String paramString2, long paramLong1, long paramLong2, List<DataType> paramList, List<DataSource> paramList1, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList2, zzoh paramzzoh) {}
  
  private boolean zzb(SessionReadRequest paramSessionReadRequest)
  {
    return (zzw.equal(this.zzasS, paramSessionReadRequest.zzasS)) && (this.zzHP.equals(paramSessionReadRequest.zzHP)) && (this.zzNY == paramSessionReadRequest.zzNY) && (this.zzapN == paramSessionReadRequest.zzapN) && (zzw.equal(this.zzapW, paramSessionReadRequest.zzapW)) && (zzw.equal(this.zzasd, paramSessionReadRequest.zzasd)) && (this.zzasT == paramSessionReadRequest.zzasT) && (this.zzasU.equals(paramSessionReadRequest.zzasU)) && (this.zzaso == paramSessionReadRequest.zzaso);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionReadRequest)) && (zzb((SessionReadRequest)paramObject)));
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
  
  public List<String> getExcludedPackages()
  {
    return this.zzasU;
  }
  
  public String getSessionId()
  {
    return this.zzHP;
  }
  
  public String getSessionName()
  {
    return this.zzasS;
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
    return zzw.hashCode(new Object[] { this.zzasS, this.zzHP, Long.valueOf(this.zzNY), Long.valueOf(this.zzapN) });
  }
  
  public boolean includeSessionsFromAllApps()
  {
    return this.zzasT;
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("sessionName", this.zzasS).zzg("sessionId", this.zzHP).zzg("startTimeMillis", Long.valueOf(this.zzNY)).zzg("endTimeMillis", Long.valueOf(this.zzapN)).zzg("dataTypes", this.zzapW).zzg("dataSources", this.zzasd).zzg("sessionsFromAllApps", Boolean.valueOf(this.zzasT)).zzg("excludedPackages", this.zzasU).zzg("useServer", Boolean.valueOf(this.zzaso)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzv.zza(this, paramParcel, paramInt);
  }
  
  public long zzkX()
  {
    return this.zzNY;
  }
  
  public IBinder zzsO()
  {
    if (this.zzasV == null) {
      return null;
    }
    return this.zzasV.asBinder();
  }
  
  public boolean zzsT()
  {
    return this.zzaso;
  }
  
  public long zzsi()
  {
    return this.zzapN;
  }
  
  public boolean zzti()
  {
    return this.zzasT;
  }
  
  public static class Builder
  {
    private String zzHP;
    private long zzNY = 0L;
    private long zzapN = 0L;
    private List<DataType> zzapW = new ArrayList();
    private String zzasS;
    private boolean zzasT = false;
    private List<String> zzasU = new ArrayList();
    private List<DataSource> zzasd = new ArrayList();
    private boolean zzaso = false;
    
    public SessionReadRequest build()
    {
      if (this.zzNY > 0L)
      {
        bool = true;
        zzx.zzb(bool, "Invalid start time: %s", new Object[] { Long.valueOf(this.zzNY) });
        if ((this.zzapN <= 0L) || (this.zzapN <= this.zzNY)) {
          break label89;
        }
      }
      label89:
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Invalid end time: %s", new Object[] { Long.valueOf(this.zzapN) });
        return new SessionReadRequest(this, null);
        bool = false;
        break;
      }
    }
    
    public Builder enableServerQueries()
    {
      this.zzaso = true;
      return this;
    }
    
    public Builder excludePackage(String paramString)
    {
      zzx.zzb(paramString, "Attempting to use a null package name");
      if (!this.zzasU.contains(paramString)) {
        this.zzasU.add(paramString);
      }
      return this;
    }
    
    public Builder read(DataSource paramDataSource)
    {
      zzx.zzb(paramDataSource, "Attempting to add a null data source");
      if (!this.zzasd.contains(paramDataSource)) {
        this.zzasd.add(paramDataSource);
      }
      return this;
    }
    
    public Builder read(DataType paramDataType)
    {
      zzx.zzb(paramDataType, "Attempting to use a null data type");
      if (!this.zzapW.contains(paramDataType)) {
        this.zzapW.add(paramDataType);
      }
      return this;
    }
    
    public Builder readSessionsFromAllApps()
    {
      this.zzasT = true;
      return this;
    }
    
    public Builder setSessionId(String paramString)
    {
      this.zzHP = paramString;
      return this;
    }
    
    public Builder setSessionName(String paramString)
    {
      this.zzasS = paramString;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      this.zzNY = paramTimeUnit.toMillis(paramLong1);
      this.zzapN = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\SessionReadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */