package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzlb.zzb;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class zzay<T>
{
  private final Map<T, zzbp<T>> zzaqR = new HashMap();
  
  public boolean isEmpty()
  {
    synchronized (this.zzaqR)
    {
      boolean bool = this.zzaqR.isEmpty();
      return bool;
    }
  }
  
  public void zza(zzbo paramzzbo, zzlb.zzb<Status> paramzzb, T paramT)
    throws RemoteException
  {
    synchronized (this.zzaqR)
    {
      zzbp localzzbp = (zzbp)this.zzaqR.remove(paramT);
      if (localzzbp == null)
      {
        paramzzb.zzp(new Status(4002));
        return;
      }
      localzzbp.clear();
      ((zzax)paramzzbo.zzpc()).zza(new zzb(this.zzaqR, paramT, paramzzb), new RemoveListenerRequest(localzzbp));
      return;
    }
  }
  
  public void zza(zzbo paramzzbo, zzlb.zzb<Status> paramzzb, T paramT, zzbp<T> paramzzbp)
    throws RemoteException
  {
    synchronized (this.zzaqR)
    {
      if (this.zzaqR.get(paramT) != null)
      {
        paramzzb.zzp(new Status(4001));
        return;
      }
      this.zzaqR.put(paramT, paramzzbp);
    }
  }
  
  public void zzb(zzbo paramzzbo)
  {
    synchronized (this.zzaqR)
    {
      zzbn.zzo localzzo = new zzbn.zzo();
      Iterator localIterator = this.zzaqR.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          zzbp localzzbp = (zzbp)localEntry.getValue();
          if (localzzbp == null) {
            continue;
          }
          localzzbp.clear();
          boolean bool = paramzzbo.isConnected();
          if (!bool) {
            continue;
          }
          try
          {
            ((zzax)paramzzbo.zzpc()).zza(localzzo, new RemoveListenerRequest(localzzbp));
            if (Log.isLoggable("WearableClient", 2)) {
              Log.d("WearableClient", "disconnect: removed: " + localEntry.getKey() + "/" + localzzbp);
            }
          }
          catch (RemoteException localRemoteException)
          {
            Log.w("WearableClient", "disconnect: Didn't remove: " + localEntry.getKey() + "/" + localzzbp);
          }
        }
      }
    }
    this.zzaqR.clear();
  }
  
  public void zzeh(IBinder paramIBinder)
  {
    synchronized (this.zzaqR)
    {
      paramIBinder = zzax.zza.zzeg(paramIBinder);
      zzbn.zzo localzzo = new zzbn.zzo();
      Iterator localIterator = this.zzaqR.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          zzbp localzzbp = (zzbp)localEntry.getValue();
          try
          {
            paramIBinder.zza(localzzo, new AddListenerRequest(localzzbp));
            if (Log.isLoggable("WearableClient", 2)) {
              Log.d("WearableClient", "onPostInitHandler: added: " + localEntry.getKey() + "/" + localzzbp);
            }
          }
          catch (RemoteException localRemoteException)
          {
            Log.d("WearableClient", "onPostInitHandler: Didn't add: " + localEntry.getKey() + "/" + localzzbp);
          }
        }
      }
    }
  }
  
  private static class zza<T>
    extends zzbn.zzb<Status>
  {
    private WeakReference<Map<T, zzbp<T>>> zzbgM;
    private WeakReference<T> zzbgN;
    
    zza(Map<T, zzbp<T>> paramMap, T paramT, zzlb.zzb<Status> paramzzb)
    {
      super();
      this.zzbgM = new WeakReference(paramMap);
      this.zzbgN = new WeakReference(paramT);
    }
    
    public void zzc(Status paramStatus)
    {
      Map localMap = (Map)this.zzbgM.get();
      Object localObject = this.zzbgN.get();
      if ((!paramStatus.getStatus().isSuccess()) && (localMap != null) && (localObject != null)) {}
      try
      {
        localObject = (zzbp)localMap.remove(localObject);
        if (localObject != null) {
          ((zzbp)localObject).clear();
        }
        zzW(paramStatus);
        return;
      }
      finally {}
    }
  }
  
  private static class zzb<T>
    extends zzbn.zzb<Status>
  {
    private WeakReference<Map<T, zzbp<T>>> zzbgM;
    private WeakReference<T> zzbgN;
    
    zzb(Map<T, zzbp<T>> paramMap, T paramT, zzlb.zzb<Status> paramzzb)
    {
      super();
      this.zzbgM = new WeakReference(paramMap);
      this.zzbgN = new WeakReference(paramT);
    }
    
    public void zzc(Status paramStatus)
    {
      Map localMap = (Map)this.zzbgM.get();
      Object localObject = this.zzbgN.get();
      if ((paramStatus.getStatus().getStatusCode() == 4002) && (localMap != null) && (localObject != null)) {}
      try
      {
        localObject = (zzbp)localMap.remove(localObject);
        if (localObject != null) {
          ((zzbp)localObject).clear();
        }
        zzW(paramStatus);
        return;
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */