package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicReference;

public class zzlb
{
  public static abstract class zza<R extends Result, A extends Api.zzb>
    extends zzlc<R>
    implements zzlb.zzb<R>, zzli.zzf<A>
  {
    private final Api.zzc<A> zzZM;
    private AtomicReference<zzli.zze> zzabg = new AtomicReference();
    
    protected zza(Api.zzc<A> paramzzc, GoogleApiClient paramGoogleApiClient)
    {
      super();
      this.zzZM = ((Api.zzc)zzx.zzw(paramzzc));
    }
    
    private void zza(RemoteException paramRemoteException)
    {
      zzv(new Status(8, paramRemoteException.getLocalizedMessage(), null));
    }
    
    protected abstract void zza(A paramA)
      throws RemoteException;
    
    public void zza(zzli.zze paramzze)
    {
      this.zzabg.set(paramzze);
    }
    
    public final void zzb(A paramA)
      throws DeadObjectException
    {
      try
      {
        zza(paramA);
        return;
      }
      catch (DeadObjectException paramA)
      {
        zza(paramA);
        throw paramA;
      }
      catch (RemoteException paramA)
      {
        zza(paramA);
      }
    }
    
    public void zznJ()
    {
      setResultCallback(null);
    }
    
    public int zznK()
    {
      return 0;
    }
    
    protected void zznL()
    {
      zzli.zze localzze = (zzli.zze)this.zzabg.getAndSet(null);
      if (localzze != null) {
        localzze.zzc(this);
      }
    }
    
    public final Api.zzc<A> zznx()
    {
      return this.zzZM;
    }
    
    public final void zzv(Status paramStatus)
    {
      if (!paramStatus.isSuccess()) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Failed result must not be success");
        zzb(zzb(paramStatus));
        return;
      }
    }
  }
  
  public static abstract interface zzb<R>
  {
    public abstract void zzp(R paramR);
    
    public abstract void zzv(Status paramStatus);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzlb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */