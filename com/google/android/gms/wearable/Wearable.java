package com.google.android.gms.wearable;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.wearable.internal.zzaz;
import com.google.android.gms.wearable.internal.zzbb;
import com.google.android.gms.wearable.internal.zzbm;
import com.google.android.gms.wearable.internal.zzbo;
import com.google.android.gms.wearable.internal.zzbq;
import com.google.android.gms.wearable.internal.zze;
import com.google.android.gms.wearable.internal.zzg;
import com.google.android.gms.wearable.internal.zzj;
import com.google.android.gms.wearable.internal.zzl;
import com.google.android.gms.wearable.internal.zzw;
import com.google.android.gms.wearable.internal.zzx;

public class Wearable
{
  public static final Api<WearableOptions> API = new Api("Wearable.API", zzRl, zzRk);
  public static final CapabilityApi CapabilityApi;
  public static final ChannelApi ChannelApi;
  public static final DataApi DataApi = new zzx();
  public static final MessageApi MessageApi;
  public static final NodeApi NodeApi;
  public static final Api.zzc<zzbo> zzRk;
  private static final Api.zza<zzbo, WearableOptions> zzRl;
  public static final zzc zzbff;
  public static final zza zzbfg;
  public static final zzf zzbfh;
  public static final zzi zzbfi;
  public static final zzk zzbfj;
  
  static
  {
    CapabilityApi = new zzj();
    MessageApi = new zzaz();
    NodeApi = new zzbb();
    ChannelApi = new zzl();
    zzbff = new zzg();
    zzbfg = new zze();
    zzbfh = new zzw();
    zzbfi = new zzbm();
    zzbfj = new zzbq();
    zzRk = new Api.zzc();
    zzRl = new Api.zza()
    {
      public zzbo zza(Context paramAnonymousContext, Looper paramAnonymousLooper, com.google.android.gms.common.internal.zzf paramAnonymouszzf, Wearable.WearableOptions paramAnonymousWearableOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
      {
        if (paramAnonymousWearableOptions != null) {}
        for (;;)
        {
          return new zzbo(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymouszzf);
          new Wearable.WearableOptions(new Wearable.WearableOptions.Builder(), null);
        }
      }
    };
  }
  
  public static final class WearableOptions
    implements Api.ApiOptions.Optional
  {
    private WearableOptions(Builder paramBuilder) {}
    
    public static class Builder
    {
      public Wearable.WearableOptions build()
      {
        return new Wearable.WearableOptions(this, null);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\Wearable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */