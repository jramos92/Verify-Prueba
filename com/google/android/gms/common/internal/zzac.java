package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zzd;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class zzac<T extends IInterface>
  extends zzj<T>
{
  private final Api.zzd<T> zzagt;
  
  public zzac(Context paramContext, Looper paramLooper, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf, Api.zzd paramzzd)
  {
    super(paramContext, paramLooper, paramInt, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzagt = paramzzd;
  }
  
  protected T zzW(IBinder paramIBinder)
  {
    return this.zzagt.zzW(paramIBinder);
  }
  
  protected void zzc(int paramInt, T paramT)
  {
    this.zzagt.zza(paramInt, paramT);
  }
  
  protected String zzfK()
  {
    return this.zzagt.zzfK();
  }
  
  protected String zzfL()
  {
    return this.zzagt.zzfL();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\internal\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */