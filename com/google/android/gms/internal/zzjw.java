package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzjw
  extends zzj<zzjy>
{
  private final String zzRq;
  
  public zzjw(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf)
  {
    super(paramContext, paramLooper, 77, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzRq = paramzzf.zzoN();
  }
  
  private Bundle zzlz()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("authPackage", this.zzRq);
    return localBundle;
  }
  
  public void zza(zzjx paramzzjx, String paramString)
  {
    try
    {
      ((zzjy)zzpc()).zza(paramzzjx, paramString);
      return;
    }
    catch (RemoteException paramzzjx) {}
  }
  
  protected zzjy zzaj(IBinder paramIBinder)
  {
    return zzjy.zza.zzal(paramIBinder);
  }
  
  public void zzb(zzjx paramzzjx, String paramString)
  {
    try
    {
      ((zzjy)zzpc()).zzb(paramzzjx, paramString);
      return;
    }
    catch (RemoteException paramzzjx) {}
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.appinvite.service.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.appinvite.internal.IAppInviteService";
  }
  
  protected Bundle zzly()
  {
    return zzlz();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzjw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */