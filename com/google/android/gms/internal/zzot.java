package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

public class zzot
  implements SessionsApi
{
  private PendingResult<SessionStopResult> zza(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2)
  {
    paramGoogleApiClient.zzb(new zzns.zza(paramGoogleApiClient)
    {
      protected SessionStopResult zzN(Status paramAnonymousStatus)
      {
        return SessionStopResult.zzU(paramAnonymousStatus);
      }
      
      protected void zza(zzns paramAnonymouszzns)
        throws RemoteException
      {
        zzot.zzb localzzb = new zzot.zzb(this, null);
        ((zzod)paramAnonymouszzns.zzpc()).zza(new SessionStopRequest(paramString1, paramString2, localzzb));
      }
    });
  }
  
  public PendingResult<Status> insertSession(GoogleApiClient paramGoogleApiClient, final SessionInsertRequest paramSessionInsertRequest)
  {
    paramGoogleApiClient.zza(new zzns.zzc(paramGoogleApiClient)
    {
      protected void zza(zzns paramAnonymouszzns)
        throws RemoteException
      {
        zzou localzzou = new zzou(this);
        ((zzod)paramAnonymouszzns.zzpc()).zza(new SessionInsertRequest(paramSessionInsertRequest, localzzou));
      }
    });
  }
  
  public PendingResult<SessionReadResult> readSession(GoogleApiClient paramGoogleApiClient, final SessionReadRequest paramSessionReadRequest)
  {
    paramGoogleApiClient.zza(new zzns.zza(paramGoogleApiClient)
    {
      protected SessionReadResult zzO(Status paramAnonymousStatus)
      {
        return SessionReadResult.zzT(paramAnonymousStatus);
      }
      
      protected void zza(zzns paramAnonymouszzns)
        throws RemoteException
      {
        zzot.zza localzza = new zzot.zza(this, null);
        ((zzod)paramAnonymouszzns.zzpc()).zza(new SessionReadRequest(paramSessionReadRequest, localzza));
      }
    });
  }
  
  public PendingResult<Status> registerForSessions(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return zza(paramGoogleApiClient, paramPendingIntent, 0);
  }
  
  public PendingResult<Status> startSession(GoogleApiClient paramGoogleApiClient, final Session paramSession)
  {
    zzx.zzb(paramSession, "Session cannot be null");
    if (paramSession.getEndTime(TimeUnit.MILLISECONDS) == 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Cannot start a session which has already ended");
      paramGoogleApiClient.zzb(new zzns.zzc(paramGoogleApiClient)
      {
        protected void zza(zzns paramAnonymouszzns)
          throws RemoteException
        {
          zzou localzzou = new zzou(this);
          ((zzod)paramAnonymouszzns.zzpc()).zza(new SessionStartRequest(paramSession, localzzou));
        }
      });
    }
  }
  
  public PendingResult<SessionStopResult> stopSession(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return zza(paramGoogleApiClient, null, paramString);
  }
  
  public PendingResult<Status> unregisterForSessions(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent)
  {
    paramGoogleApiClient.zzb(new zzns.zzc(paramGoogleApiClient)
    {
      protected void zza(zzns paramAnonymouszzns)
        throws RemoteException
      {
        zzou localzzou = new zzou(this);
        ((zzod)paramAnonymouszzns.zzpc()).zza(new SessionUnregistrationRequest(paramPendingIntent, localzzou));
      }
    });
  }
  
  public PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final PendingIntent paramPendingIntent, final int paramInt)
  {
    paramGoogleApiClient.zzb(new zzns.zzc(paramGoogleApiClient)
    {
      protected void zza(zzns paramAnonymouszzns)
        throws RemoteException
      {
        zzou localzzou = new zzou(this);
        ((zzod)paramAnonymouszzns.zzpc()).zza(new SessionRegistrationRequest(paramPendingIntent, localzzou, paramInt));
      }
    });
  }
  
  private static class zza
    extends zzoh.zza
  {
    private final zzlb.zzb<SessionReadResult> zzagy;
    
    private zza(zzlb.zzb<SessionReadResult> paramzzb)
    {
      this.zzagy = paramzzb;
    }
    
    public void zza(SessionReadResult paramSessionReadResult)
      throws RemoteException
    {
      this.zzagy.zzp(paramSessionReadResult);
    }
  }
  
  private static class zzb
    extends zzoi.zza
  {
    private final zzlb.zzb<SessionStopResult> zzagy;
    
    private zzb(zzlb.zzb<SessionStopResult> paramzzb)
    {
      this.zzagy = paramzzb;
    }
    
    public void zza(SessionStopResult paramSessionStopResult)
    {
      this.zzagy.zzp(paramSessionStopResult);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */