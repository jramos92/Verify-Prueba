package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlb.zzb;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;

public final class zzl
  implements ChannelApi
{
  private static final zzb.zza<ChannelApi.ChannelListener> zzbfD = new zzb.zza()
  {
    public void zza(zzbo paramAnonymouszzbo, zzlb.zzb<Status> paramAnonymouszzb, ChannelApi.ChannelListener paramAnonymousChannelListener, zzlm<ChannelApi.ChannelListener> paramAnonymouszzlm)
      throws RemoteException
    {
      paramAnonymouszzbo.zza(paramAnonymouszzb, paramAnonymousChannelListener, paramAnonymouszzlm, null);
    }
  };
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    zzx.zzb(paramGoogleApiClient, "client is null");
    zzx.zzb(paramChannelListener, "listener is null");
    return zzb.zza(paramGoogleApiClient, zzbfD, paramChannelListener);
  }
  
  public PendingResult<ChannelApi.OpenChannelResult> openChannel(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2)
  {
    zzx.zzb(paramGoogleApiClient, "client is null");
    zzx.zzb(paramString1, "nodeId is null");
    zzx.zzb(paramString2, "path is null");
    paramGoogleApiClient.zzb(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zze(this, paramString1, paramString2);
      }
      
      public ChannelApi.OpenChannelResult zzbk(Status paramAnonymousStatus)
      {
        return new zzl.zza(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    zzx.zzb(paramGoogleApiClient, "client is null");
    zzx.zzb(paramChannelListener, "listener is null");
    return paramGoogleApiClient.zza(new zzb(paramGoogleApiClient, paramChannelListener, null));
  }
  
  static final class zza
    implements ChannelApi.OpenChannelResult
  {
    private final Status zzSC;
    private final Channel zzbfW;
    
    zza(Status paramStatus, Channel paramChannel)
    {
      this.zzSC = ((Status)zzx.zzw(paramStatus));
      this.zzbfW = paramChannel;
    }
    
    public Channel getChannel()
    {
      return this.zzbfW;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  static final class zzb
    extends zzi<Status>
  {
    private final String zzRz;
    private ChannelApi.ChannelListener zzbfX;
    
    zzb(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener, String paramString)
    {
      super();
      this.zzbfX = ((ChannelApi.ChannelListener)zzx.zzw(paramChannelListener));
      this.zzRz = paramString;
    }
    
    protected void zza(zzbo paramzzbo)
      throws RemoteException
    {
      paramzzbo.zza(this, this.zzbfX, this.zzRz);
      this.zzbfX = null;
    }
    
    public Status zzd(Status paramStatus)
    {
      this.zzbfX = null;
      return paramStatus;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */