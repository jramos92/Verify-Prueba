package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer
{
  private static boolean zznp = false;
  
  public static int initialize(Context paramContext)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        zzx.zzb(paramContext, "Context is null");
        boolean bool = zznp;
        if (!bool) {
          continue;
        }
      }
      finally
      {
        try
        {
          paramContext = zzy.zzaG(paramContext);
          zza(paramContext);
          zznp = true;
        }
        catch (GooglePlayServicesNotAvailableException paramContext)
        {
          i = paramContext.errorCode;
        }
        paramContext = finally;
      }
      return i;
    }
  }
  
  public static void zza(zzc paramzzc)
  {
    try
    {
      CameraUpdateFactory.zza(paramzzc.zzxT());
      BitmapDescriptorFactory.zza(paramzzc.zzxU());
      return;
    }
    catch (RemoteException paramzzc)
    {
      throw new RuntimeRemoteException(paramzzc);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\MapsInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */