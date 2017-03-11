package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;
import com.google.android.gms.fitness.result.DataTypeResult;

public class zzoo
  implements ConfigApi
{
  public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient paramGoogleApiClient, final DataTypeCreateRequest paramDataTypeCreateRequest)
  {
    paramGoogleApiClient.zzb(new zznn.zza(paramGoogleApiClient)
    {
      protected DataTypeResult zzI(Status paramAnonymousStatus)
      {
        return DataTypeResult.zzR(paramAnonymousStatus);
      }
      
      protected void zza(zznn paramAnonymouszznn)
        throws RemoteException
      {
        zzoo.zza localzza = new zzoo.zza(this, null);
        ((zzny)paramAnonymouszznn.zzpc()).zza(new DataTypeCreateRequest(paramDataTypeCreateRequest, localzza));
      }
    });
  }
  
  public PendingResult<Status> disableFit(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zznn.zzc(paramGoogleApiClient)
    {
      protected void zza(zznn paramAnonymouszznn)
        throws RemoteException
      {
        zzou localzzou = new zzou(this);
        ((zzny)paramAnonymouszznn.zzpc()).zza(new DisableFitRequest(localzzou));
      }
    });
  }
  
  public PendingResult<DataTypeResult> readDataType(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zza(new zznn.zza(paramGoogleApiClient)
    {
      protected DataTypeResult zzI(Status paramAnonymousStatus)
      {
        return DataTypeResult.zzR(paramAnonymousStatus);
      }
      
      protected void zza(zznn paramAnonymouszznn)
        throws RemoteException
      {
        zzoo.zza localzza = new zzoo.zza(this, null);
        ((zzny)paramAnonymouszznn.zzpc()).zza(new DataTypeReadRequest(paramString, localzza));
      }
    });
  }
  
  private static class zza
    extends zznw.zza
  {
    private final zzlb.zzb<DataTypeResult> zzagy;
    
    private zza(zzlb.zzb<DataTypeResult> paramzzb)
    {
      this.zzagy = paramzzb;
    }
    
    public void zza(DataTypeResult paramDataTypeResult)
    {
      this.zzagy.zzp(paramDataTypeResult);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzoo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */