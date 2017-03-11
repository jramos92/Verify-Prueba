package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzaz
  implements MessageApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return paramGoogleApiClient.zza(new zza(paramGoogleApiClient, paramMessageListener, paramGoogleApiClient.zzo(paramMessageListener), paramArrayOfIntentFilter, null));
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener)
  {
    return zza(paramGoogleApiClient, paramMessageListener, null);
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, final MessageApi.MessageListener paramMessageListener)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zza(this, paramMessageListener);
      }
      
      public Status zzd(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final byte[] paramArrayOfByte)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzbo paramAnonymouszzbo)
        throws RemoteException
      {
        paramAnonymouszzbo.zza(this, paramString1, paramString2, paramArrayOfByte);
      }
      
      protected MessageApi.SendMessageResult zzbr(Status paramAnonymousStatus)
      {
        return new zzaz.zzb(paramAnonymousStatus, -1);
      }
    });
  }
  
  private static final class zza
    extends zzi<Status>
  {
    private zzlm<MessageApi.MessageListener> zzaPH;
    private MessageApi.MessageListener zzbgS;
    private IntentFilter[] zzbgT;
    
    private zza(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, zzlm<MessageApi.MessageListener> paramzzlm, IntentFilter[] paramArrayOfIntentFilter)
    {
      super();
      this.zzbgS = ((MessageApi.MessageListener)zzx.zzw(paramMessageListener));
      this.zzaPH = ((zzlm)zzx.zzw(paramzzlm));
      this.zzbgT = paramArrayOfIntentFilter;
    }
    
    protected void zza(zzbo paramzzbo)
      throws RemoteException
    {
      paramzzbo.zza(this, this.zzbgS, this.zzaPH, this.zzbgT);
      this.zzbgS = null;
      this.zzaPH = null;
      this.zzbgT = null;
    }
    
    public Status zzd(Status paramStatus)
    {
      this.zzbgS = null;
      this.zzaPH = null;
      this.zzbgT = null;
      return paramStatus;
    }
  }
  
  public static class zzb
    implements MessageApi.SendMessageResult
  {
    private final Status zzSC;
    private final int zzaiy;
    
    public zzb(Status paramStatus, int paramInt)
    {
      this.zzSC = paramStatus;
      this.zzaiy = paramInt;
    }
    
    public int getRequestId()
    {
      return this.zzaiy;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */