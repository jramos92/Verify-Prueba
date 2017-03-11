package com.google.android.gms.fitness.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest;
import com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest;
import com.google.android.gms.fitness.internal.service.zzc.zza;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zzmx;
import com.google.android.gms.internal.zznv;
import com.google.android.gms.internal.zzoj;
import java.util.List;

public abstract class FitnessSensorService
  extends Service
{
  public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
  private zza zzatn;
  
  public IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.fitness.service.FitnessSensorService".equals(paramIntent.getAction()))
    {
      if (Log.isLoggable("FitnessSensorService", 3)) {
        Log.d("FitnessSensorService", "Intent " + paramIntent + " received by " + getClass().getName());
      }
      return this.zzatn.asBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.zzatn = new zza(this, null);
  }
  
  public abstract List<DataSource> onFindDataSources(List<DataType> paramList);
  
  public abstract boolean onRegister(FitnessSensorServiceRequest paramFitnessSensorServiceRequest);
  
  public abstract boolean onUnregister(DataSource paramDataSource);
  
  protected void zztv()
    throws SecurityException
  {
    int i = Binder.getCallingUid();
    if (zzmx.zzqB())
    {
      ((AppOpsManager)getSystemService("appops")).checkPackage(i, "com.google.android.gms");
      return;
    }
    String[] arrayOfString = getPackageManager().getPackagesForUid(i);
    if (arrayOfString != null)
    {
      int j = arrayOfString.length;
      i = 0;
      for (;;)
      {
        if (i >= j) {
          break label67;
        }
        if (arrayOfString[i].equals("com.google.android.gms")) {
          break;
        }
        i += 1;
      }
    }
    label67:
    throw new SecurityException("Unauthorized caller");
  }
  
  private static class zza
    extends zzc.zza
  {
    private final FitnessSensorService zzato;
    
    private zza(FitnessSensorService paramFitnessSensorService)
    {
      this.zzato = paramFitnessSensorService;
    }
    
    public void zza(FitnessDataSourcesRequest paramFitnessDataSourcesRequest, zznv paramzznv)
      throws RemoteException
    {
      this.zzato.zztv();
      paramzznv.zza(new DataSourcesResult(this.zzato.onFindDataSources(paramFitnessDataSourcesRequest.getDataTypes()), Status.zzabb));
    }
    
    public void zza(FitnessUnregistrationRequest paramFitnessUnregistrationRequest, zzoj paramzzoj)
      throws RemoteException
    {
      this.zzato.zztv();
      if (this.zzato.onUnregister(paramFitnessUnregistrationRequest.getDataSource()))
      {
        paramzzoj.zzo(Status.zzabb);
        return;
      }
      paramzzoj.zzo(new Status(13));
    }
    
    public void zza(FitnessSensorServiceRequest paramFitnessSensorServiceRequest, zzoj paramzzoj)
      throws RemoteException
    {
      this.zzato.zztv();
      if (this.zzato.onRegister(paramFitnessSensorServiceRequest))
      {
        paramzzoj.zzo(Status.zzabb);
        return;
      }
      paramzzoj.zzo(new Status(13));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\service\FitnessSensorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */