package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;

public final class zzpt
  extends zzj<zzpw>
{
  private final long zzavo = hashCode();
  
  public zzpt(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 54, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public void disconnect()
  {
    if (isConnected()) {}
    try
    {
      ((zzpw)zzpc()).zzE(this.zzavo);
      super.disconnect();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", localRemoteException);
      }
    }
  }
  
  public String zzAO()
  {
    try
    {
      String str = ((zzpw)zzpc()).zzT(this.zzavo);
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
  
  public String zzAP()
  {
    try
    {
      String str = ((zzpw)zzpc()).zzAP();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException(localRemoteException);
    }
  }
  
  public void zzAQ()
  {
    try
    {
      ((zzpw)zzpc()).zzQ(this.zzavo);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("NearbyConnectionsClient", "Couldn't stop advertising", localRemoteException);
    }
  }
  
  public void zzAR()
  {
    try
    {
      ((zzpw)zzpc()).zzS(this.zzavo);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", localRemoteException);
    }
  }
  
  public void zza(zzlb.zzb<Status> paramzzb, String paramString, long paramLong, zzlm<Connections.EndpointDiscoveryListener> paramzzlm)
    throws RemoteException
  {
    ((zzpw)zzpc()).zza(new zzg(paramzzb, paramzzlm), paramString, paramLong, this.zzavo);
  }
  
  public void zza(zzlb.zzb<Connections.StartAdvertisingResult> paramzzb, String paramString, AppMetadata paramAppMetadata, long paramLong, zzlm<Connections.ConnectionRequestListener> paramzzlm)
    throws RemoteException
  {
    ((zzpw)zzpc()).zza(new zze(paramzzb, paramzzlm), paramString, paramAppMetadata, paramLong, this.zzavo);
  }
  
  public void zza(zzlb.zzb<Status> paramzzb, String paramString1, String paramString2, byte[] paramArrayOfByte, zzlm<Connections.ConnectionResponseCallback> paramzzlm, zzlm<Connections.MessageListener> paramzzlm1)
    throws RemoteException
  {
    ((zzpw)zzpc()).zza(new zzd(paramzzb, paramzzlm, paramzzlm1), paramString1, paramString2, paramArrayOfByte, this.zzavo);
  }
  
  public void zza(zzlb.zzb<Status> paramzzb, String paramString, byte[] paramArrayOfByte, zzlm<Connections.MessageListener> paramzzlm)
    throws RemoteException
  {
    ((zzpw)zzpc()).zza(new zza(paramzzb, paramzzlm), paramString, paramArrayOfByte, this.zzavo);
  }
  
  public void zza(String[] paramArrayOfString, byte[] paramArrayOfByte)
  {
    try
    {
      ((zzpw)zzpc()).zza(paramArrayOfString, paramArrayOfByte, this.zzavo);
      return;
    }
    catch (RemoteException paramArrayOfString)
    {
      Log.w("NearbyConnectionsClient", "Couldn't send reliable message", paramArrayOfString);
    }
  }
  
  public void zzb(String[] paramArrayOfString, byte[] paramArrayOfByte)
  {
    try
    {
      ((zzpw)zzpc()).zzb(paramArrayOfString, paramArrayOfByte, this.zzavo);
      return;
    }
    catch (RemoteException paramArrayOfString)
    {
      Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", paramArrayOfString);
    }
  }
  
  protected zzpw zzdh(IBinder paramIBinder)
  {
    return zzpw.zza.zzdj(paramIBinder);
  }
  
  public void zzej(String paramString)
  {
    try
    {
      ((zzpw)zzpc()).zzg(paramString, this.zzavo);
      return;
    }
    catch (RemoteException paramString)
    {
      Log.w("NearbyConnectionsClient", "Couldn't stop discovery", paramString);
    }
  }
  
  public void zzek(String paramString)
  {
    try
    {
      ((zzpw)zzpc()).zzh(paramString, this.zzavo);
      return;
    }
    catch (RemoteException paramString)
    {
      Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", paramString);
    }
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.nearby.connection.service.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
  }
  
  public void zzp(zzlb.zzb<Status> paramzzb, String paramString)
    throws RemoteException
  {
    ((zzpw)zzpc()).zza(new zzc(paramzzb), paramString, this.zzavo);
  }
  
  private static final class zza
    extends zzpt.zzb
  {
    private final zzlb.zzb<Status> zzagy;
    
    public zza(zzlb.zzb<Status> paramzzb, zzlm<Connections.MessageListener> paramzzlm)
    {
      super();
      this.zzagy = ((zzlb.zzb)zzx.zzw(paramzzb));
    }
    
    public void zziv(int paramInt)
      throws RemoteException
    {
      this.zzagy.zzp(new Status(paramInt));
    }
  }
  
  private static class zzb
    extends zzps
  {
    private final zzlm<Connections.MessageListener> zzaPA;
    
    zzb(zzlm<Connections.MessageListener> paramzzlm)
    {
      this.zzaPA = paramzzlm;
    }
    
    public void onDisconnected(final String paramString)
      throws RemoteException
    {
      this.zzaPA.zza(new zzlm.zzb()
      {
        public void zza(Connections.MessageListener paramAnonymousMessageListener)
        {
          paramAnonymousMessageListener.onDisconnected(paramString);
        }
        
        public void zznN() {}
      });
    }
    
    public void onMessageReceived(final String paramString, final byte[] paramArrayOfByte, final boolean paramBoolean)
      throws RemoteException
    {
      this.zzaPA.zza(new zzlm.zzb()
      {
        public void zza(Connections.MessageListener paramAnonymousMessageListener)
        {
          paramAnonymousMessageListener.onMessageReceived(paramString, paramArrayOfByte, paramBoolean);
        }
        
        public void zznN() {}
      });
    }
  }
  
  private static class zzc
    extends zzps
  {
    private final zzlb.zzb<Status> zzaPE;
    
    zzc(zzlb.zzb<Status> paramzzb)
    {
      this.zzaPE = paramzzb;
    }
    
    public void zziw(int paramInt)
      throws RemoteException
    {
      this.zzaPE.zzp(new Status(paramInt));
    }
  }
  
  private static final class zzd
    extends zzpt.zzb
  {
    private final zzlm<Connections.ConnectionResponseCallback> zzaPF;
    private final zzlb.zzb<Status> zzagy;
    
    public zzd(zzlb.zzb<Status> paramzzb, zzlm<Connections.ConnectionResponseCallback> paramzzlm, zzlm<Connections.MessageListener> paramzzlm1)
    {
      super();
      this.zzagy = ((zzlb.zzb)zzx.zzw(paramzzb));
      this.zzaPF = ((zzlm)zzx.zzw(paramzzlm));
    }
    
    public void zza(final String paramString, final int paramInt, final byte[] paramArrayOfByte)
      throws RemoteException
    {
      this.zzaPF.zza(new zzlm.zzb()
      {
        public void zza(Connections.ConnectionResponseCallback paramAnonymousConnectionResponseCallback)
        {
          paramAnonymousConnectionResponseCallback.onConnectionResponse(paramString, new Status(paramInt), paramArrayOfByte);
        }
        
        public void zznN() {}
      });
    }
    
    public void zziu(int paramInt)
      throws RemoteException
    {
      this.zzagy.zzp(new Status(paramInt));
    }
  }
  
  private static final class zze
    extends zzps
  {
    private final zzlm<Connections.ConnectionRequestListener> zzaPH;
    private final zzlb.zzb<Connections.StartAdvertisingResult> zzagy;
    
    zze(zzlb.zzb<Connections.StartAdvertisingResult> paramzzb, zzlm<Connections.ConnectionRequestListener> paramzzlm)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzw(paramzzb));
      this.zzaPH = ((zzlm)zzx.zzw(paramzzlm));
    }
    
    public void onConnectionRequest(final String paramString1, final String paramString2, final String paramString3, final byte[] paramArrayOfByte)
      throws RemoteException
    {
      this.zzaPH.zza(new zzlm.zzb()
      {
        public void zza(Connections.ConnectionRequestListener paramAnonymousConnectionRequestListener)
        {
          paramAnonymousConnectionRequestListener.onConnectionRequest(paramString1, paramString2, paramString3, paramArrayOfByte);
        }
        
        public void zznN() {}
      });
    }
    
    public void zzm(int paramInt, String paramString)
      throws RemoteException
    {
      this.zzagy.zzp(new zzpt.zzf(new Status(paramInt), paramString));
    }
  }
  
  private static final class zzf
    implements Connections.StartAdvertisingResult
  {
    private final Status zzSC;
    private final String zzaPL;
    
    zzf(Status paramStatus, String paramString)
    {
      this.zzSC = paramStatus;
      this.zzaPL = paramString;
    }
    
    public String getLocalEndpointName()
    {
      return this.zzaPL;
    }
    
    public Status getStatus()
    {
      return this.zzSC;
    }
  }
  
  private static final class zzg
    extends zzps
  {
    private final zzlm<Connections.EndpointDiscoveryListener> zzaPH;
    private final zzlb.zzb<Status> zzagy;
    
    zzg(zzlb.zzb<Status> paramzzb, zzlm<Connections.EndpointDiscoveryListener> paramzzlm)
    {
      this.zzagy = ((zzlb.zzb)zzx.zzw(paramzzb));
      this.zzaPH = ((zzlm)zzx.zzw(paramzzlm));
    }
    
    public void onEndpointFound(final String paramString1, final String paramString2, final String paramString3, final String paramString4)
      throws RemoteException
    {
      this.zzaPH.zza(new zzlm.zzb()
      {
        public void zza(Connections.EndpointDiscoveryListener paramAnonymousEndpointDiscoveryListener)
        {
          paramAnonymousEndpointDiscoveryListener.onEndpointFound(paramString1, paramString2, paramString3, paramString4);
        }
        
        public void zznN() {}
      });
    }
    
    public void onEndpointLost(final String paramString)
      throws RemoteException
    {
      this.zzaPH.zza(new zzlm.zzb()
      {
        public void zza(Connections.EndpointDiscoveryListener paramAnonymousEndpointDiscoveryListener)
        {
          paramAnonymousEndpointDiscoveryListener.onEndpointLost(paramString);
        }
        
        public void zznN() {}
      });
    }
    
    public void zzis(int paramInt)
      throws RemoteException
    {
      this.zzagy.zzp(new Status(paramInt));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzpt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */