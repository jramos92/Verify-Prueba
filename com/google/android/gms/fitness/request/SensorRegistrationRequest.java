package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzj.zza;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SensorRegistrationRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SensorRegistrationRequest> CREATOR = new zzs();
  private final PendingIntent mPendingIntent;
  private final int mVersionCode;
  private DataType zzapL;
  private DataSource zzapM;
  private final long zzarc;
  private final int zzard;
  private zzj zzasF;
  int zzasG;
  int zzasH;
  private final long zzasI;
  private final long zzasJ;
  private final List<LocationRequest> zzasK;
  private final long zzasL;
  private final List<Object> zzasM;
  private final zzoj zzasb;
  
  SensorRegistrationRequest(int paramInt1, DataSource paramDataSource, DataType paramDataType, IBinder paramIBinder1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, PendingIntent paramPendingIntent, long paramLong3, int paramInt4, List<LocationRequest> paramList, long paramLong4, IBinder paramIBinder2)
  {
    this.mVersionCode = paramInt1;
    this.zzapM = paramDataSource;
    this.zzapL = paramDataType;
    if (paramIBinder1 == null) {}
    for (paramDataSource = null;; paramDataSource = zzj.zza.zzbl(paramIBinder1))
    {
      this.zzasF = paramDataSource;
      long l = paramLong1;
      if (paramLong1 == 0L) {
        l = paramInt2;
      }
      this.zzarc = l;
      this.zzasJ = paramLong3;
      paramLong1 = paramLong2;
      if (paramLong2 == 0L) {
        paramLong1 = paramInt3;
      }
      this.zzasI = paramLong1;
      this.zzasK = paramList;
      this.mPendingIntent = paramPendingIntent;
      this.zzard = paramInt4;
      this.zzasM = Collections.emptyList();
      this.zzasL = paramLong4;
      this.zzasb = zzoj.zza.zzbJ(paramIBinder2);
      return;
    }
  }
  
  public SensorRegistrationRequest(DataSource paramDataSource, DataType paramDataType, zzj paramzzj, PendingIntent paramPendingIntent, long paramLong1, long paramLong2, long paramLong3, int paramInt, List<LocationRequest> paramList, List<Object> paramList1, long paramLong4, zzoj paramzzoj)
  {
    this.mVersionCode = 6;
    this.zzapM = paramDataSource;
    this.zzapL = paramDataType;
    this.zzasF = paramzzj;
    this.mPendingIntent = paramPendingIntent;
    this.zzarc = paramLong1;
    this.zzasJ = paramLong2;
    this.zzasI = paramLong3;
    this.zzard = paramInt;
    this.zzasK = paramList;
    this.zzasM = paramList1;
    this.zzasL = paramLong4;
    this.zzasb = paramzzoj;
  }
  
  public SensorRegistrationRequest(SensorRequest paramSensorRequest, zzj paramzzj, PendingIntent paramPendingIntent, zzoj paramzzoj)
  {
    this(paramSensorRequest.getDataSource(), paramSensorRequest.getDataType(), paramzzj, paramPendingIntent, paramSensorRequest.getSamplingRate(TimeUnit.MICROSECONDS), paramSensorRequest.getFastestRate(TimeUnit.MICROSECONDS), paramSensorRequest.getMaxDeliveryLatency(TimeUnit.MICROSECONDS), paramSensorRequest.getAccuracyMode(), null, Collections.emptyList(), paramSensorRequest.zztg(), paramzzoj);
  }
  
  private boolean zzb(SensorRegistrationRequest paramSensorRegistrationRequest)
  {
    return (zzw.equal(this.zzapM, paramSensorRegistrationRequest.zzapM)) && (zzw.equal(this.zzapL, paramSensorRegistrationRequest.zzapL)) && (this.zzarc == paramSensorRegistrationRequest.zzarc) && (this.zzasJ == paramSensorRegistrationRequest.zzasJ) && (this.zzasI == paramSensorRegistrationRequest.zzasI) && (this.zzard == paramSensorRegistrationRequest.zzard) && (zzw.equal(this.zzasK, paramSensorRegistrationRequest.zzasK));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SensorRegistrationRequest)) && (zzb((SensorRegistrationRequest)paramObject)));
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
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzapM, this.zzapL, this.zzasF, Long.valueOf(this.zzarc), Long.valueOf(this.zzasJ), Long.valueOf(this.zzasI), Integer.valueOf(this.zzard), this.zzasK });
  }
  
  public String toString()
  {
    return String.format("SensorRegistrationRequest{type %s source %s interval %s fastest %s latency %s}", new Object[] { this.zzapL, this.zzapM, Long.valueOf(this.zzarc), Long.valueOf(this.zzasJ), Long.valueOf(this.zzasI) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzs.zza(this, paramParcel, paramInt);
  }
  
  public long zzsB()
  {
    return this.zzarc;
  }
  
  public IBinder zzsO()
  {
    if (this.zzasb == null) {
      return null;
    }
    return this.zzasb.asBinder();
  }
  
  public PendingIntent zzta()
  {
    return this.mPendingIntent;
  }
  
  public long zztb()
  {
    return this.zzasJ;
  }
  
  public long zztc()
  {
    return this.zzasI;
  }
  
  public List<LocationRequest> zztd()
  {
    return this.zzasK;
  }
  
  public long zzte()
  {
    return this.zzasL;
  }
  
  IBinder zztf()
  {
    if (this.zzasF == null) {
      return null;
    }
    return this.zzasF.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\SensorRegistrationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */