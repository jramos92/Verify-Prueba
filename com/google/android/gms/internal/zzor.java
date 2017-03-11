package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.data.Subscription.zza;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public class zzor
  implements RecordingApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final Subscription paramSubscription)
  {
    paramGoogleApiClient.zza(new zznq.zzc(paramGoogleApiClient)
    {
      protected void zza(zznq paramAnonymouszznq)
        throws RemoteException
      {
        zzou localzzou = new zzou(this);
        ((zzob)paramAnonymouszznq.zzpc()).zza(new SubscribeRequest(paramSubscription, false, localzzou));
      }
    });
  }
  
  public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zznq.zza(paramGoogleApiClient)
    {
      protected ListSubscriptionsResult zzL(Status paramAnonymousStatus)
      {
        return ListSubscriptionsResult.zzS(paramAnonymousStatus);
      }
      
      protected void zza(zznq paramAnonymouszznq)
        throws RemoteException
      {
        zzor.zza localzza = new zzor.zza(this, null);
        ((zzob)paramAnonymouszznq.zzpc()).zza(new ListSubscriptionsRequest(null, localzza));
      }
    });
  }
  
  public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient paramGoogleApiClient, final DataType paramDataType)
  {
    paramGoogleApiClient.zza(new zznq.zza(paramGoogleApiClient)
    {
      protected ListSubscriptionsResult zzL(Status paramAnonymousStatus)
      {
        return ListSubscriptionsResult.zzS(paramAnonymousStatus);
      }
      
      protected void zza(zznq paramAnonymouszznq)
        throws RemoteException
      {
        zzor.zza localzza = new zzor.zza(this, null);
        ((zzob)paramAnonymouszznq.zzpc()).zza(new ListSubscriptionsRequest(paramDataType, localzza));
      }
    });
  }
  
  public PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, DataSource paramDataSource)
  {
    return zza(paramGoogleApiClient, new Subscription.zza().zzb(paramDataSource).zzsD());
  }
  
  public PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return zza(paramGoogleApiClient, new Subscription.zza().zzb(paramDataType).zzsD());
  }
  
  public PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, final DataSource paramDataSource)
  {
    paramGoogleApiClient.zzb(new zznq.zzc(paramGoogleApiClient)
    {
      protected void zza(zznq paramAnonymouszznq)
        throws RemoteException
      {
        zzou localzzou = new zzou(this);
        ((zzob)paramAnonymouszznq.zzpc()).zza(new UnsubscribeRequest(null, paramDataSource, localzzou));
      }
    });
  }
  
  public PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, final DataType paramDataType)
  {
    paramGoogleApiClient.zzb(new zznq.zzc(paramGoogleApiClient)
    {
      protected void zza(zznq paramAnonymouszznq)
        throws RemoteException
      {
        zzou localzzou = new zzou(this);
        ((zzob)paramAnonymouszznq.zzpc()).zza(new UnsubscribeRequest(paramDataType, null, localzzou));
      }
    });
  }
  
  public PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, Subscription paramSubscription)
  {
    if (paramSubscription.getDataType() == null) {
      return unsubscribe(paramGoogleApiClient, paramSubscription.getDataSource());
    }
    return unsubscribe(paramGoogleApiClient, paramSubscription.getDataType());
  }
  
  private static class zza
    extends zzoe.zza
  {
    private final zzlb.zzb<ListSubscriptionsResult> zzagy;
    
    private zza(zzlb.zzb<ListSubscriptionsResult> paramzzb)
    {
      this.zzagy = paramzzb;
    }
    
    public void zza(ListSubscriptionsResult paramListSubscriptionsResult)
    {
      this.zzagy.zzp(paramListSubscriptionsResult);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */