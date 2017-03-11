package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zzon
  implements BleApi
{
  public PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, final BleDevice paramBleDevice)
  {
    paramGoogleApiClient.zzb(new zznm.zzc(paramGoogleApiClient)
    {
      protected void zza(zznm paramAnonymouszznm)
        throws RemoteException
      {
        zzou localzzou = new zzou(this);
        ((zznx)paramAnonymouszznm.zzpc()).zza(new ClaimBleDeviceRequest(paramBleDevice.getAddress(), paramBleDevice, localzzou));
      }
    });
  }
  
  public PendingResult<Status> claimBleDevice(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zzb(new zznm.zzc(paramGoogleApiClient)
    {
      protected void zza(zznm paramAnonymouszznm)
        throws RemoteException
      {
        zzou localzzou = new zzou(this);
        ((zznx)paramAnonymouszznm.zzpc()).zza(new ClaimBleDeviceRequest(paramString, null, localzzou));
      }
    });
  }
  
  public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zznm.zza(paramGoogleApiClient)
    {
      protected BleDevicesResult zzH(Status paramAnonymousStatus)
      {
        return BleDevicesResult.zzP(paramAnonymousStatus);
      }
      
      protected void zza(zznm paramAnonymouszznm)
        throws RemoteException
      {
        zzon.zza localzza = new zzon.zza(this, null);
        ((zznx)paramAnonymouszznm.zzpc()).zza(new ListClaimedBleDevicesRequest(localzza));
      }
    });
  }
  
  public PendingResult<Status> startBleScan(GoogleApiClient paramGoogleApiClient, final StartBleScanRequest paramStartBleScanRequest)
  {
    paramGoogleApiClient.zza(new zznm.zzc(paramGoogleApiClient)
    {
      protected void zza(zznm paramAnonymouszznm)
        throws RemoteException
      {
        zzou localzzou = new zzou(this);
        ((zznx)paramAnonymouszznm.zzpc()).zza(new StartBleScanRequest(paramStartBleScanRequest, localzzou));
      }
    });
  }
  
  public PendingResult<Status> stopBleScan(GoogleApiClient paramGoogleApiClient, final BleScanCallback paramBleScanCallback)
  {
    paramGoogleApiClient.zza(new zznm.zzc(paramGoogleApiClient)
    {
      protected void zza(zznm paramAnonymouszznm)
        throws RemoteException
      {
        zzou localzzou = new zzou(this);
        ((zznx)paramAnonymouszznm.zzpc()).zza(new StopBleScanRequest(paramBleScanCallback, localzzou));
      }
    });
  }
  
  public PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, BleDevice paramBleDevice)
  {
    return unclaimBleDevice(paramGoogleApiClient, paramBleDevice.getAddress());
  }
  
  public PendingResult<Status> unclaimBleDevice(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zzb(new zznm.zzc(paramGoogleApiClient)
    {
      protected void zza(zznm paramAnonymouszznm)
        throws RemoteException
      {
        zzou localzzou = new zzou(this);
        ((zznx)paramAnonymouszznm.zzpc()).zza(new UnclaimBleDeviceRequest(paramString, localzzou));
      }
    });
  }
  
  private static class zza
    extends zzow.zza
  {
    private final zzlb.zzb<BleDevicesResult> zzagy;
    
    private zza(zzlb.zzb<BleDevicesResult> paramzzb)
    {
      this.zzagy = paramzzb;
    }
    
    public void zza(BleDevicesResult paramBleDevicesResult)
    {
      this.zzagy.zzp(paramBleDevicesResult);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */