package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest
{
  public static final int ACCURACY_MODE_DEFAULT = 2;
  public static final int ACCURACY_MODE_HIGH = 3;
  public static final int ACCURACY_MODE_LOW = 1;
  private final DataType zzapL;
  private final DataSource zzapM;
  private final long zzarc;
  private final int zzard;
  private final long zzasI;
  private final long zzasJ;
  private final LocationRequest zzasN;
  private final long zzasO;
  
  private SensorRequest(DataSource paramDataSource, LocationRequest paramLocationRequest)
  {
    this.zzasN = paramLocationRequest;
    this.zzarc = TimeUnit.MILLISECONDS.toMicros(paramLocationRequest.getInterval());
    this.zzasJ = TimeUnit.MILLISECONDS.toMicros(paramLocationRequest.getFastestInterval());
    this.zzasI = this.zzarc;
    this.zzapL = paramDataSource.getDataType();
    this.zzard = zza(paramLocationRequest);
    this.zzapM = paramDataSource;
    long l = paramLocationRequest.getExpirationTime();
    if (l == Long.MAX_VALUE)
    {
      this.zzasO = Long.MAX_VALUE;
      return;
    }
    this.zzasO = TimeUnit.MILLISECONDS.toMicros(l - SystemClock.elapsedRealtime());
  }
  
  private SensorRequest(Builder paramBuilder)
  {
    this.zzapM = Builder.zza(paramBuilder);
    this.zzapL = Builder.zzb(paramBuilder);
    this.zzarc = Builder.zzc(paramBuilder);
    this.zzasJ = Builder.zzd(paramBuilder);
    this.zzasI = Builder.zze(paramBuilder);
    this.zzard = Builder.zzf(paramBuilder);
    this.zzasN = null;
    this.zzasO = Builder.zzg(paramBuilder);
  }
  
  public static SensorRequest fromLocationRequest(DataSource paramDataSource, LocationRequest paramLocationRequest)
  {
    return new SensorRequest(paramDataSource, paramLocationRequest);
  }
  
  private static int zza(LocationRequest paramLocationRequest)
  {
    switch (paramLocationRequest.getPriority())
    {
    default: 
      return 2;
    case 100: 
      return 3;
    }
    return 1;
  }
  
  private boolean zza(SensorRequest paramSensorRequest)
  {
    return (zzw.equal(this.zzapM, paramSensorRequest.zzapM)) && (zzw.equal(this.zzapL, paramSensorRequest.zzapL)) && (this.zzarc == paramSensorRequest.zzarc) && (this.zzasJ == paramSensorRequest.zzasJ) && (this.zzasI == paramSensorRequest.zzasI) && (this.zzard == paramSensorRequest.zzard) && (zzw.equal(this.zzasN, paramSensorRequest.zzasN)) && (this.zzasO == paramSensorRequest.zzasO);
  }
  
  public static int zzff(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    case 2: 
    default: 
      i = 2;
    }
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SensorRequest)) && (zza((SensorRequest)paramObject)));
  }
  
  public int getAccuracyMode()
  {
    return this.zzard;
  }
  
  public DataSource getDataSource()
  {
    return this.zzapM;
  }
  
  public DataType getDataType()
  {
    return this.zzapL;
  }
  
  public long getFastestRate(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzasJ, TimeUnit.MICROSECONDS);
  }
  
  public long getMaxDeliveryLatency(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzasI, TimeUnit.MICROSECONDS);
  }
  
  public long getSamplingRate(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzarc, TimeUnit.MICROSECONDS);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzapM, this.zzapL, Long.valueOf(this.zzarc), Long.valueOf(this.zzasJ), Long.valueOf(this.zzasI), Integer.valueOf(this.zzard), this.zzasN, Long.valueOf(this.zzasO) });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("dataSource", this.zzapM).zzg("dataType", this.zzapL).zzg("samplingRateMicros", Long.valueOf(this.zzarc)).zzg("deliveryLatencyMicros", Long.valueOf(this.zzasI)).zzg("timeOutMicros", Long.valueOf(this.zzasO)).toString();
  }
  
  public long zztg()
  {
    return this.zzasO;
  }
  
  public static class Builder
  {
    private DataType zzapL;
    private DataSource zzapM;
    private long zzarc = -1L;
    private int zzard = 2;
    private long zzasI = 0L;
    private long zzasJ = 0L;
    private long zzasO = Long.MAX_VALUE;
    private boolean zzasP = false;
    
    public SensorRequest build()
    {
      boolean bool2 = false;
      if ((this.zzapM != null) || (this.zzapL != null)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        zzx.zza(bool1, "Must call setDataSource() or setDataType()");
        if ((this.zzapL != null) && (this.zzapM != null))
        {
          bool1 = bool2;
          if (!this.zzapL.equals(this.zzapM.getDataType())) {}
        }
        else
        {
          bool1 = true;
        }
        zzx.zza(bool1, "Specified data type is incompatible with specified data source");
        return new SensorRequest(this, null);
      }
    }
    
    public Builder setAccuracyMode(int paramInt)
    {
      this.zzard = SensorRequest.zzff(paramInt);
      return this;
    }
    
    public Builder setDataSource(DataSource paramDataSource)
    {
      this.zzapM = paramDataSource;
      return this;
    }
    
    public Builder setDataType(DataType paramDataType)
    {
      this.zzapL = paramDataType;
      return this;
    }
    
    public Builder setFastestRate(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Cannot use a negative interval");
        this.zzasP = true;
        this.zzasJ = paramTimeUnit.toMicros(paramInt);
        return this;
      }
    }
    
    public Builder setMaxDeliveryLatency(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Cannot use a negative delivery interval");
        this.zzasI = paramTimeUnit.toMicros(paramInt);
        return this;
      }
    }
    
    public Builder setSamplingRate(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Cannot use a negative sampling interval");
        this.zzarc = paramTimeUnit.toMicros(paramLong);
        if (!this.zzasP) {
          this.zzasJ = (this.zzarc / 2L);
        }
        return this;
      }
    }
    
    public Builder setTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool2 = true;
      if (paramLong > 0L)
      {
        bool1 = true;
        zzx.zzb(bool1, "Invalid time out value specified: %d", new Object[] { Long.valueOf(paramLong) });
        if (paramTimeUnit == null) {
          break label62;
        }
      }
      label62:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zzb(bool1, "Invalid time unit specified");
        this.zzasO = paramTimeUnit.toMicros(paramLong);
        return this;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\SensorRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */