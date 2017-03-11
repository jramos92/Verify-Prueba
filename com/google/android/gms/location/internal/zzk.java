package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzc.zza;
import com.google.android.gms.location.zzd;
import com.google.android.gms.location.zzd.zza;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class zzk
{
  private final Context mContext;
  private final zzp<zzi> zzaFb;
  private ContentProviderClient zzaFv = null;
  private boolean zzaFw = false;
  private Map<LocationCallback, zza> zzaFx = new HashMap();
  private Map<LocationListener, zzc> zzaqR = new HashMap();
  
  public zzk(Context paramContext, zzp<zzi> paramzzp)
  {
    this.mContext = paramContext;
    this.zzaFb = paramzzp;
  }
  
  private zza zza(LocationCallback paramLocationCallback, Looper paramLooper)
  {
    synchronized (this.zzaqR)
    {
      zza localzza2 = (zza)this.zzaFx.get(paramLocationCallback);
      zza localzza1 = localzza2;
      if (localzza2 == null) {
        localzza1 = new zza(paramLocationCallback, paramLooper);
      }
      this.zzaFx.put(paramLocationCallback, localzza1);
      return localzza1;
    }
  }
  
  private zzc zza(LocationListener paramLocationListener, Looper paramLooper)
  {
    synchronized (this.zzaqR)
    {
      zzc localzzc2 = (zzc)this.zzaqR.get(paramLocationListener);
      zzc localzzc1 = localzzc2;
      if (localzzc2 == null) {
        localzzc1 = new zzc(paramLocationListener, paramLooper);
      }
      this.zzaqR.put(paramLocationListener, localzzc1);
      return localzzc1;
    }
  }
  
  public Location getLastLocation()
  {
    this.zzaFb.zzpb();
    try
    {
      Location localLocation = ((zzi)this.zzaFb.zzpc()).zzdv(this.mContext.getPackageName());
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void removeAllListeners()
  {
    Object localObject2;
    try
    {
      synchronized (this.zzaqR)
      {
        Iterator localIterator1 = this.zzaqR.values().iterator();
        while (localIterator1.hasNext())
        {
          localObject2 = (zzc)localIterator1.next();
          if (localObject2 != null) {
            ((zzi)this.zzaFb.zzpc()).zza(LocationRequestUpdateData.zza((zzd)localObject2, null));
          }
        }
      }
      this.zzaqR.clear();
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
    Iterator localIterator2 = this.zzaFx.values().iterator();
    while (localIterator2.hasNext())
    {
      localObject2 = (zza)localIterator2.next();
      if (localObject2 != null) {
        ((zzi)this.zzaFb.zzpc()).zza(LocationRequestUpdateData.zza((zzc)localObject2, null));
      }
    }
    this.zzaFx.clear();
  }
  
  public void zza(PendingIntent paramPendingIntent, zzg paramzzg)
    throws RemoteException
  {
    this.zzaFb.zzpb();
    ((zzi)this.zzaFb.zzpc()).zza(LocationRequestUpdateData.zzb(paramPendingIntent, paramzzg));
  }
  
  public void zza(LocationCallback paramLocationCallback, zzg paramzzg)
    throws RemoteException
  {
    this.zzaFb.zzpb();
    zzx.zzb(paramLocationCallback, "Invalid null callback");
    synchronized (this.zzaFx)
    {
      paramLocationCallback = (zza)this.zzaFx.remove(paramLocationCallback);
      if (paramLocationCallback != null)
      {
        paramLocationCallback.release();
        ((zzi)this.zzaFb.zzpc()).zza(LocationRequestUpdateData.zza(paramLocationCallback, paramzzg));
      }
      return;
    }
  }
  
  public void zza(LocationListener paramLocationListener, zzg paramzzg)
    throws RemoteException
  {
    this.zzaFb.zzpb();
    zzx.zzb(paramLocationListener, "Invalid null listener");
    synchronized (this.zzaqR)
    {
      paramLocationListener = (zzc)this.zzaqR.remove(paramLocationListener);
      if ((this.zzaFv != null) && (this.zzaqR.isEmpty()))
      {
        this.zzaFv.release();
        this.zzaFv = null;
      }
      if (paramLocationListener != null)
      {
        paramLocationListener.release();
        ((zzi)this.zzaFb.zzpc()).zza(LocationRequestUpdateData.zza(paramLocationListener, paramzzg));
      }
      return;
    }
  }
  
  public void zza(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent, zzg paramzzg)
    throws RemoteException
  {
    this.zzaFb.zzpb();
    ((zzi)this.zzaFb.zzpc()).zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(paramLocationRequest), paramPendingIntent, paramzzg));
  }
  
  public void zza(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper, zzg paramzzg)
    throws RemoteException
  {
    this.zzaFb.zzpb();
    paramLocationListener = zza(paramLocationListener, paramLooper);
    ((zzi)this.zzaFb.zzpc()).zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(paramLocationRequest), paramLocationListener, paramzzg));
  }
  
  public void zza(LocationRequestInternal paramLocationRequestInternal, LocationCallback paramLocationCallback, Looper paramLooper, zzg paramzzg)
    throws RemoteException
  {
    this.zzaFb.zzpb();
    paramLocationCallback = zza(paramLocationCallback, paramLooper);
    ((zzi)this.zzaFb.zzpc()).zza(LocationRequestUpdateData.zza(paramLocationRequestInternal, paramLocationCallback, paramzzg));
  }
  
  public void zzah(boolean paramBoolean)
    throws RemoteException
  {
    this.zzaFb.zzpb();
    ((zzi)this.zzaFb.zzpc()).zzah(paramBoolean);
    this.zzaFw = paramBoolean;
  }
  
  public void zzc(Location paramLocation)
    throws RemoteException
  {
    this.zzaFb.zzpb();
    ((zzi)this.zzaFb.zzpc()).zzc(paramLocation);
  }
  
  public LocationAvailability zzwD()
  {
    this.zzaFb.zzpb();
    try
    {
      LocationAvailability localLocationAvailability = ((zzi)this.zzaFb.zzpc()).zzdw(this.mContext.getPackageName());
      return localLocationAvailability;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void zzwE()
  {
    if (this.zzaFw) {}
    try
    {
      zzah(false);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  private static class zza
    extends zzc.zza
  {
    private Handler zzaFy;
    
    zza(final LocationCallback paramLocationCallback, Looper paramLooper)
    {
      Looper localLooper = paramLooper;
      if (paramLooper == null)
      {
        localLooper = Looper.myLooper();
        if (localLooper == null) {
          break label45;
        }
      }
      label45:
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "Can't create handler inside thread that has not called Looper.prepare()");
        this.zzaFy = new Handler(localLooper)
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            switch (paramAnonymousMessage.what)
            {
            default: 
              return;
            case 0: 
              paramLocationCallback.onLocationResult((LocationResult)paramAnonymousMessage.obj);
              return;
            }
            paramLocationCallback.onLocationAvailability((LocationAvailability)paramAnonymousMessage.obj);
          }
        };
        return;
      }
    }
    
    private void zzb(int paramInt, Object paramObject)
    {
      if (this.zzaFy == null)
      {
        Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = paramInt;
      localMessage.obj = paramObject;
      this.zzaFy.sendMessage(localMessage);
    }
    
    public void onLocationAvailability(LocationAvailability paramLocationAvailability)
    {
      zzb(1, paramLocationAvailability);
    }
    
    public void onLocationResult(LocationResult paramLocationResult)
    {
      zzb(0, paramLocationResult);
    }
    
    public void release()
    {
      this.zzaFy = null;
    }
  }
  
  private static class zzb
    extends Handler
  {
    private final LocationListener zzaFA;
    
    public zzb(LocationListener paramLocationListener)
    {
      this.zzaFA = paramLocationListener;
    }
    
    public zzb(LocationListener paramLocationListener, Looper paramLooper)
    {
      super();
      this.zzaFA = paramLocationListener;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
        return;
      }
      paramMessage = new Location((Location)paramMessage.obj);
      this.zzaFA.onLocationChanged(paramMessage);
    }
  }
  
  private static class zzc
    extends zzd.zza
  {
    private Handler zzaFy;
    
    zzc(LocationListener paramLocationListener, Looper paramLooper)
    {
      boolean bool;
      if (paramLooper == null)
      {
        if (Looper.myLooper() != null)
        {
          bool = true;
          zzx.zza(bool, "Can't create handler inside thread that has not called Looper.prepare()");
        }
      }
      else {
        if (paramLooper != null) {
          break label46;
        }
      }
      label46:
      for (paramLocationListener = new zzk.zzb(paramLocationListener);; paramLocationListener = new zzk.zzb(paramLocationListener, paramLooper))
      {
        this.zzaFy = paramLocationListener;
        return;
        bool = false;
        break;
      }
    }
    
    public void onLocationChanged(Location paramLocation)
    {
      if (this.zzaFy == null)
      {
        Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramLocation;
      this.zzaFy.sendMessage(localMessage);
    }
    
    public void release()
    {
      this.zzaFy = null;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */