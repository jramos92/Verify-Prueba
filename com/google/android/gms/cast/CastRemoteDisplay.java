package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzkw;
import com.google.android.gms.internal.zzkx;

public final class CastRemoteDisplay
{
  public static final Api<CastRemoteDisplayOptions> API = new Api("CastRemoteDisplay.API", zzRl, zzRk);
  public static final CastRemoteDisplayApi CastRemoteDisplayApi = new zzkw(zzRk);
  private static final Api.zzc<zzkx> zzRk = new Api.zzc();
  private static final Api.zza<zzkx, CastRemoteDisplayOptions> zzRl = new Api.zza()
  {
    public zzkx zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, CastRemoteDisplay.CastRemoteDisplayOptions paramAnonymousCastRemoteDisplayOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzkx(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousCastRemoteDisplayOptions.zzUV, paramAnonymousCastRemoteDisplayOptions.zzVm, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  
  public static final class CastRemoteDisplayOptions
    implements Api.ApiOptions.HasOptions
  {
    final CastDevice zzUV;
    final CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzVm;
    
    private CastRemoteDisplayOptions(Builder paramBuilder)
    {
      this.zzUV = paramBuilder.zzUY;
      this.zzVm = paramBuilder.zzVn;
    }
    
    public static final class Builder
    {
      CastDevice zzUY;
      CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzVn;
      
      public Builder(CastDevice paramCastDevice, CastRemoteDisplay.CastRemoteDisplaySessionCallbacks paramCastRemoteDisplaySessionCallbacks)
      {
        zzx.zzb(paramCastDevice, "CastDevice parameter cannot be null");
        this.zzUY = paramCastDevice;
        this.zzVn = paramCastRemoteDisplaySessionCallbacks;
      }
      
      public CastRemoteDisplay.CastRemoteDisplayOptions build()
      {
        return new CastRemoteDisplay.CastRemoteDisplayOptions(this, null);
      }
    }
  }
  
  public static abstract interface CastRemoteDisplaySessionCallbacks
  {
    public abstract void onRemoteDisplayEnded(Status paramStatus);
  }
  
  public static abstract interface CastRemoteDisplaySessionResult
    extends Result
  {
    public abstract Display getPresentationDisplay();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\CastRemoteDisplay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */