package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.HashMap;
import java.util.Map;

public class zza
  extends zzn.zza
{
  private final BleScanCallback zzarW;
  
  private zza(BleScanCallback paramBleScanCallback)
  {
    this.zzarW = ((BleScanCallback)zzx.zzw(paramBleScanCallback));
  }
  
  public void onDeviceFound(BleDevice paramBleDevice)
    throws RemoteException
  {
    this.zzarW.onDeviceFound(paramBleDevice);
  }
  
  public void onScanStopped()
    throws RemoteException
  {
    this.zzarW.onScanStopped();
  }
  
  public static class zza
  {
    private static final zza zzarX = new zza();
    private final Map<BleScanCallback, zza> zzarY = new HashMap();
    
    public static zza zzsM()
    {
      return zzarX;
    }
    
    public zza zza(BleScanCallback paramBleScanCallback)
    {
      synchronized (this.zzarY)
      {
        zza localzza2 = (zza)this.zzarY.get(paramBleScanCallback);
        zza localzza1 = localzza2;
        if (localzza2 == null)
        {
          localzza1 = new zza(paramBleScanCallback, null);
          this.zzarY.put(paramBleScanCallback, localzza1);
        }
        return localzza1;
      }
    }
    
    public zza zzb(BleScanCallback paramBleScanCallback)
    {
      synchronized (this.zzarY)
      {
        zza localzza = (zza)this.zzarY.get(paramBleScanCallback);
        if (localzza != null) {
          return localzza;
        }
        paramBleScanCallback = new zza(paramBleScanCallback, null);
        return paramBleScanCallback;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */