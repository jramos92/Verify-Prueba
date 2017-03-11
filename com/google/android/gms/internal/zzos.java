package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.data.zzk.zza;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

public class zzos
  implements SensorsApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final zzj paramzzj, final PendingIntent paramPendingIntent, final zza paramzza)
  {
    paramGoogleApiClient.zzb(new zznr.zzc(paramGoogleApiClient)
    {
      protected void zza(zznr paramAnonymouszznr)
        throws RemoteException
      {
        zzos.zzc localzzc = new zzos.zzc(this, paramzza, null);
        ((zzoc)paramAnonymouszznr.zzpc()).zza(new SensorUnregistrationRequest(paramzzj, paramPendingIntent, localzzc));
      }
      
      protected Status zzd(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final SensorRequest paramSensorRequest, final zzj paramzzj, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zza(new zznr.zzc(paramGoogleApiClient)
    {
      protected void zza(zznr paramAnonymouszznr)
        throws RemoteException
      {
        zzou localzzou = new zzou(this);
        ((zzoc)paramAnonymouszznr.zzpc()).zza(new SensorRegistrationRequest(paramSensorRequest, paramzzj, paramPendingIntent, localzzou));
      }
      
      protected Status zzd(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<Status> add(GoogleApiClient paramGoogleApiClient, SensorRequest paramSensorRequest, PendingIntent paramPendingIntent)
  {
    return zza(paramGoogleApiClient, paramSensorRequest, null, paramPendingIntent);
  }
  
  public PendingResult<Status> add(GoogleApiClient paramGoogleApiClient, SensorRequest paramSensorRequest, OnDataPointListener paramOnDataPointListener)
  {
    return zza(paramGoogleApiClient, paramSensorRequest, zzk.zza.zzsx().zza(paramOnDataPointListener), null);
  }
  
  public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient paramGoogleApiClient, final DataSourcesRequest paramDataSourcesRequest)
  {
    paramGoogleApiClient.zza(new zznr.zza(paramGoogleApiClient)
    {
      protected DataSourcesResult zzM(Status paramAnonymousStatus)
      {
        return DataSourcesResult.zzQ(paramAnonymousStatus);
      }
      
      protected void zza(zznr paramAnonymouszznr)
        throws RemoteException
      {
        zzos.zzb localzzb = new zzos.zzb(this, null);
        ((zzoc)paramAnonymouszznr.zzpc()).zza(new DataSourcesRequest(paramDataSourcesRequest, localzzb));
      }
    });
  }
  
  public PendingResult<Status> remove(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return zza(paramGoogleApiClient, null, paramPendingIntent, null);
  }
  
  public PendingResult<Status> remove(GoogleApiClient paramGoogleApiClient, final OnDataPointListener paramOnDataPointListener)
  {
    zzk localzzk = zzk.zza.zzsx().zzb(paramOnDataPointListener);
    if (localzzk == null) {
      return PendingResults.zza(Status.zzabb, paramGoogleApiClient);
    }
    zza(paramGoogleApiClient, localzzk, null, new zza()
    {
      public void zzsL()
      {
        zzk.zza.zzsx().zzc(paramOnDataPointListener);
      }
    });
  }
  
  private static abstract interface zza
  {
    public abstract void zzsL();
  }
  
  private static class zzb
    extends zznv.zza
  {
    private final zzlb.zzb<DataSourcesResult> zzagy;
    
    private zzb(zzlb.zzb<DataSourcesResult> paramzzb)
    {
      this.zzagy = paramzzb;
    }
    
    public void zza(DataSourcesResult paramDataSourcesResult)
    {
      this.zzagy.zzp(paramDataSourcesResult);
    }
  }
  
  private static class zzc
    extends zzoj.zza
  {
    private final zzlb.zzb<Status> zzagy;
    private final zzos.zza zzarO;
    
    private zzc(zzlb.zzb<Status> paramzzb, zzos.zza paramzza)
    {
      this.zzagy = paramzzb;
      this.zzarO = paramzza;
    }
    
    public void zzo(Status paramStatus)
    {
      if ((this.zzarO != null) && (paramStatus.isSuccess())) {
        this.zzarO.zzsL();
      }
      this.zzagy.zzp(paramStatus);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */