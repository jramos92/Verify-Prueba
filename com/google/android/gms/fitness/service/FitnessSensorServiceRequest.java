package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzj.zza;
import java.util.concurrent.TimeUnit;

public class FitnessSensorServiceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<FitnessSensorServiceRequest> CREATOR = new zza();
  public static final int UNSPECIFIED = -1;
  private final int mVersionCode;
  private final DataSource zzapM;
  private final zzj zzasF;
  private final long zzatp;
  private final long zzatq;
  
  FitnessSensorServiceRequest(int paramInt, DataSource paramDataSource, IBinder paramIBinder, long paramLong1, long paramLong2)
  {
    this.mVersionCode = paramInt;
    this.zzapM = paramDataSource;
    this.zzasF = zzj.zza.zzbl(paramIBinder);
    this.zzatp = paramLong1;
    this.zzatq = paramLong2;
  }
  
  private boolean zza(FitnessSensorServiceRequest paramFitnessSensorServiceRequest)
  {
    return (zzw.equal(this.zzapM, paramFitnessSensorServiceRequest.zzapM)) && (this.zzatp == paramFitnessSensorServiceRequest.zzatp) && (this.zzatq == paramFitnessSensorServiceRequest.zzatq);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof FitnessSensorServiceRequest)) && (zza((FitnessSensorServiceRequest)paramObject)));
  }
  
  public long getBatchInterval(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.zzatq, TimeUnit.MICROSECONDS);
  }
  
  public DataSource getDataSource()
  {
    return this.zzapM;
  }
  
  public SensorEventDispatcher getDispatcher()
  {
    return new zzb(this.zzasF);
  }
  
  public long getSamplingRate(TimeUnit paramTimeUnit)
  {
    if (this.zzatp == -1L) {
      return -1L;
    }
    return paramTimeUnit.convert(this.zzatp, TimeUnit.MICROSECONDS);
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzapM, Long.valueOf(this.zzatp), Long.valueOf(this.zzatq) });
  }
  
  public String toString()
  {
    return String.format("FitnessSensorServiceRequest{%s}", new Object[] { this.zzapM });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public long zzsB()
  {
    return this.zzatp;
  }
  
  IBinder zztf()
  {
    return this.zzasF.asBinder();
  }
  
  public long zztw()
  {
    return this.zzatq;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\service\FitnessSensorServiceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */