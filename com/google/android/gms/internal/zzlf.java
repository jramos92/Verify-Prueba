package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzk;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class zzlf
  implements zzlj
{
  private final zzli zzabr;
  
  public zzlf(zzli paramzzli)
  {
    this.zzabr = paramzzli;
  }
  
  private <A extends Api.zzb> void zza(zzli.zzf<A> paramzzf)
    throws DeadObjectException
  {
    this.zzabr.zzb(paramzzf);
    Api.zzb localzzb = this.zzabr.zza(paramzzf.zznx());
    if ((!localzzb.isConnected()) && (this.zzabr.zzach.containsKey(paramzzf.zznx())))
    {
      paramzzf.zzv(new Status(17));
      return;
    }
    paramzzf.zzb(localzzb);
  }
  
  public void begin()
  {
    while (!this.zzabr.zzaca.isEmpty()) {
      try
      {
        zza((zzli.zzf)this.zzabr.zzaca.remove());
      }
      catch (DeadObjectException localDeadObjectException)
      {
        Log.w("GACConnected", "Service died while flushing queue", localDeadObjectException);
      }
    }
  }
  
  public void connect() {}
  
  public void disconnect()
  {
    this.zzabr.zzach.clear();
    this.zzabr.zznY();
    this.zzabr.zzg(null);
    this.zzabr.zzabZ.zzpk();
  }
  
  public String getName()
  {
    return "CONNECTED";
  }
  
  public void onConnected(Bundle paramBundle) {}
  
  public void onConnectionSuspended(int paramInt)
  {
    if (paramInt == 1) {
      this.zzabr.zzoe();
    }
    Iterator localIterator = this.zzabr.zzacm.iterator();
    while (localIterator.hasNext()) {
      ((zzli.zzf)localIterator.next()).zzw(new Status(8, "The connection to Google Play services was lost"));
    }
    this.zzabr.zzg(null);
    this.zzabr.zzabZ.zzbG(paramInt);
    this.zzabr.zzabZ.zzpk();
    if (paramInt == 2) {
      this.zzabr.connect();
    }
  }
  
  public <A extends Api.zzb, R extends Result, T extends zzlb.zza<R, A>> T zza(T paramT)
  {
    return zzb(paramT);
  }
  
  public void zza(ConnectionResult paramConnectionResult, Api<?> paramApi, int paramInt) {}
  
  public <A extends Api.zzb, T extends zzlb.zza<? extends Result, A>> T zzb(T paramT)
  {
    try
    {
      zza(paramT);
      return paramT;
    }
    catch (DeadObjectException localDeadObjectException)
    {
      this.zzabr.zza(new zzli.zzb(this)
      {
        public void zznO()
        {
          zzlf.this.onConnectionSuspended(1);
        }
      });
    }
    return paramT;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzlf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */