package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

public class zzqs
  extends zzj<zzqr>
{
  public zzqs(Context paramContext, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf)
  {
    super(paramContext, paramContext.getMainLooper(), 73, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  protected zzqr zzdL(IBinder paramIBinder)
  {
    return zzqr.zza.zzdK(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.search.service.SEARCH_AUTH_START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.search.internal.ISearchAuthService";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzqs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */