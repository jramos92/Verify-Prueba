package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlb.zza;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.PublishOptions.Builder;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.nearby.messages.SubscribeOptions.Builder;

public class zzk
  implements Messages
{
  public static final Api.zzc<zzj> zzRk = new Api.zzc();
  public static final Api.zza<zzj, MessagesOptions> zzRl = new Api.zza()
  {
    public int getPriority()
    {
      return Integer.MAX_VALUE;
    }
    
    public zzj zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, MessagesOptions paramAnonymousMessagesOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzj(paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymouszzf, paramAnonymousMessagesOptions);
    }
  };
  
  public PendingResult<Status> getPermissionStatus(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzj paramAnonymouszzj)
        throws RemoteException
      {
        paramAnonymouszzj.zzh(this);
      }
    });
  }
  
  public PendingResult<Status> publish(GoogleApiClient paramGoogleApiClient, Message paramMessage)
  {
    return publish(paramGoogleApiClient, paramMessage, PublishOptions.DEFAULT);
  }
  
  public PendingResult<Status> publish(GoogleApiClient paramGoogleApiClient, final Message paramMessage, final PublishOptions paramPublishOptions)
  {
    zzx.zzw(paramMessage);
    zzx.zzw(paramPublishOptions);
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzj paramAnonymouszzj)
        throws RemoteException
      {
        paramAnonymouszzj.zza(this, MessageWrapper.zza(paramMessage), paramPublishOptions);
      }
    });
  }
  
  @Deprecated
  public PendingResult<Status> publish(GoogleApiClient paramGoogleApiClient, Message paramMessage, Strategy paramStrategy)
  {
    return publish(paramGoogleApiClient, paramMessage, new PublishOptions.Builder().setStrategy(paramStrategy).build());
  }
  
  public PendingResult<Status> registerStatusCallback(GoogleApiClient paramGoogleApiClient, final StatusCallback paramStatusCallback)
  {
    zzx.zzw(paramStatusCallback);
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzj paramAnonymouszzj)
        throws RemoteException
      {
        paramAnonymouszzj.zza(this, paramStatusCallback);
      }
    });
  }
  
  @Deprecated
  public PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, MessageListener paramMessageListener)
  {
    return subscribe(paramGoogleApiClient, paramMessageListener, SubscribeOptions.DEFAULT);
  }
  
  @Deprecated
  public PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, MessageListener paramMessageListener, Strategy paramStrategy)
  {
    return subscribe(paramGoogleApiClient, paramMessageListener, new SubscribeOptions.Builder().setStrategy(paramStrategy).build());
  }
  
  @Deprecated
  public PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, MessageListener paramMessageListener, Strategy paramStrategy, MessageFilter paramMessageFilter)
  {
    return subscribe(paramGoogleApiClient, paramMessageListener, new SubscribeOptions.Builder().setStrategy(paramStrategy).setFilter(paramMessageFilter).build());
  }
  
  public PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, final MessageListener paramMessageListener, final SubscribeOptions paramSubscribeOptions)
  {
    zzx.zzw(paramMessageListener);
    zzx.zzw(paramSubscribeOptions);
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzj paramAnonymouszzj)
        throws RemoteException
      {
        paramAnonymouszzj.zza(this, paramMessageListener, paramSubscribeOptions, null);
      }
    });
  }
  
  public PendingResult<Status> unpublish(GoogleApiClient paramGoogleApiClient, final Message paramMessage)
  {
    zzx.zzw(paramMessage);
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzj paramAnonymouszzj)
        throws RemoteException
      {
        paramAnonymouszzj.zza(this, MessageWrapper.zza(paramMessage));
      }
    });
  }
  
  public PendingResult<Status> unregisterStatusCallback(GoogleApiClient paramGoogleApiClient, final StatusCallback paramStatusCallback)
  {
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzj paramAnonymouszzj)
        throws RemoteException
      {
        paramAnonymouszzj.zzb(this, paramStatusCallback);
      }
    });
  }
  
  public PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, final MessageListener paramMessageListener)
  {
    zzx.zzw(paramMessageListener);
    paramGoogleApiClient.zzb(new zza(paramGoogleApiClient)
    {
      protected void zza(zzj paramAnonymouszzj)
        throws RemoteException
      {
        paramAnonymouszzj.zza(this, paramMessageListener);
      }
    });
  }
  
  static abstract class zza
    extends zzlb.zza<Status, zzj>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    public Status zzd(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */