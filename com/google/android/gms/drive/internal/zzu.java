package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzg;
import com.google.android.gms.drive.events.zzi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zzu
  extends zzj<zzam>
{
  private final String zzRq;
  final GoogleApiClient.ConnectionCallbacks zzafE;
  private final Bundle zzakC;
  private final boolean zzakD;
  private volatile DriveId zzakE;
  private volatile DriveId zzakF;
  private volatile boolean zzakG = false;
  final Map<DriveId, Map<ChangeListener, zzae>> zzakH = new HashMap();
  final Map<zzc, zzae> zzakI = new HashMap();
  final Map<DriveId, Map<zzi, zzae>> zzakJ = new HashMap();
  final Map<DriveId, Map<zzi, zzae>> zzakK = new HashMap();
  
  public zzu(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, Bundle paramBundle)
  {
    super(paramContext, paramLooper, 11, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zzRq = paramzzf.zzoN();
    this.zzafE = paramConnectionCallbacks;
    this.zzakC = paramBundle;
    paramLooper = new Intent("com.google.android.gms.drive.events.HANDLE_EVENT");
    paramLooper.setPackage(paramContext.getPackageName());
    paramContext = paramContext.getPackageManager().queryIntentServices(paramLooper, 0);
    switch (paramContext.size())
    {
    default: 
      throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + paramLooper.getAction() + " action");
    case 0: 
      this.zzakD = false;
      return;
    }
    paramContext = ((ResolveInfo)paramContext.get(0)).serviceInfo;
    if (!paramContext.exported) {
      throw new IllegalStateException("Drive event service " + paramContext.name + " must be exported in AndroidManifest.xml");
    }
    this.zzakD = true;
  }
  
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final int paramInt, final DriveId paramDriveId)
  {
    zzx.zzb(zzg.zza(paramInt, paramDriveId), "id");
    zzx.zza(isConnected(), "Client must be connected");
    paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzrm().zza(new RemoveEventListenerRequest(paramDriveId, paramInt), null, null, new zzbt(this));
      }
    });
  }
  
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final int paramInt, final DriveId paramDriveId, final ChangesAvailableOptions paramChangesAvailableOptions)
  {
    zzx.zzb(zzg.zza(paramInt, paramDriveId), "id");
    zzx.zza(isConnected(), "Client must be connected");
    if (!this.zzakD) {
      throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }
    paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzrm().zza(new AddEventListenerRequest(paramDriveId, paramInt, paramChangesAvailableOptions), null, null, new zzbt(this));
      }
    });
  }
  
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final int paramInt, final DriveId paramDriveId, final zzae paramzzae)
  {
    paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzrm().zza(new RemoveEventListenerRequest(paramDriveId, paramInt), paramzzae, null, new zzbt(this));
      }
    });
  }
  
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final int paramInt, final DriveId paramDriveId, final zzae paramzzae, final ChangesAvailableOptions paramChangesAvailableOptions)
  {
    paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzrm().zza(new AddEventListenerRequest(paramDriveId, paramInt, paramChangesAvailableOptions), paramzzae, null, new zzbt(this));
      }
    });
  }
  
  PendingResult<Status> cancelPendingActions(GoogleApiClient paramGoogleApiClient, final List<String> paramList)
  {
    boolean bool2 = true;
    if (paramList != null)
    {
      bool1 = true;
      zzx.zzaa(bool1);
      if (paramList.isEmpty()) {
        break label58;
      }
    }
    label58:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzaa(bool1);
      zzx.zza(isConnected(), "Client must be connected");
      paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
      {
        protected void zza(zzu paramAnonymouszzu)
          throws RemoteException
        {
          paramAnonymouszzu.zzrm().zza(new CancelPendingActionsRequest(paramList), new zzbt(this));
        }
      });
      bool1 = false;
      break;
    }
  }
  
  public void disconnect()
  {
    if (isConnected()) {}
    try
    {
      ((zzam)zzpc()).zza(new DisconnectRequest());
      super.disconnect();
      synchronized (this.zzakH)
      {
        this.zzakH.clear();
        synchronized (this.zzakI)
        {
          this.zzakI.clear();
          synchronized (this.zzakJ)
          {
            this.zzakJ.clear();
          }
        }
      }
      synchronized (this.zzakK)
      {
        this.zzakK.clear();
        return;
        localObject1 = finally;
        throw ((Throwable)localObject1);
        localObject2 = finally;
        throw ((Throwable)localObject2);
        localObject3 = finally;
        throw ((Throwable)localObject3);
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;) {}
    }
  }
  
  PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId)
  {
    return zza(paramGoogleApiClient, 1, paramDriveId, null);
  }
  
  PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId, ChangeListener paramChangeListener)
  {
    zzx.zzb(zzg.zza(1, paramDriveId), "id");
    zzx.zzb(paramChangeListener, "listener");
    zzx.zza(isConnected(), "Client must be connected");
    label186:
    for (;;)
    {
      zzae localzzae;
      synchronized (this.zzakH)
      {
        Object localObject = (Map)this.zzakH.get(paramDriveId);
        if (localObject != null) {
          break label186;
        }
        localObject = new HashMap();
        this.zzakH.put(paramDriveId, localObject);
        localzzae = (zzae)((Map)localObject).get(paramChangeListener);
        if (localzzae == null)
        {
          localzzae = new zzae(getLooper(), getContext(), 1, paramChangeListener);
          ((Map)localObject).put(paramChangeListener, localzzae);
          paramChangeListener = localzzae;
          paramChangeListener.zzcP(1);
          paramGoogleApiClient = zza(paramGoogleApiClient, 1, paramDriveId, paramChangeListener, null);
          return paramGoogleApiClient;
        }
        if (localzzae.zzcQ(1))
        {
          paramGoogleApiClient = new zzs.zzj(paramGoogleApiClient, Status.zzabb);
          return paramGoogleApiClient;
        }
      }
      paramChangeListener = localzzae;
    }
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      this.zzakE = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.root_id"));
      this.zzakF = ((DriveId)paramBundle.getParcelable("com.google.android.gms.drive.appdata_id"));
      this.zzakG = true;
    }
    super.zza(paramInt1, paramIBinder, paramBundle, paramInt2);
  }
  
  protected zzam zzaR(IBinder paramIBinder)
  {
    return zzam.zza.zzaS(paramIBinder);
  }
  
  PendingResult<Status> zzb(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId)
  {
    return zza(paramGoogleApiClient, 1, paramDriveId);
  }
  
  PendingResult<Status> zzb(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId, ChangeListener paramChangeListener)
  {
    zzx.zzb(zzg.zza(1, paramDriveId), "id");
    zzx.zza(isConnected(), "Client must be connected");
    zzx.zzb(paramChangeListener, "listener");
    Map localMap2;
    synchronized (this.zzakH)
    {
      localMap2 = (Map)this.zzakH.get(paramDriveId);
      if (localMap2 == null)
      {
        paramGoogleApiClient = new zzs.zzj(paramGoogleApiClient, Status.zzabb);
        return paramGoogleApiClient;
      }
      paramChangeListener = (zzae)localMap2.remove(paramChangeListener);
      if (paramChangeListener == null)
      {
        paramGoogleApiClient = new zzs.zzj(paramGoogleApiClient, Status.zzabb);
        return paramGoogleApiClient;
      }
    }
    if (localMap2.isEmpty()) {
      this.zzakH.remove(paramDriveId);
    }
    paramGoogleApiClient = zza(paramGoogleApiClient, 1, paramDriveId, paramChangeListener);
    return paramGoogleApiClient;
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.drive.ApiService.START";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.drive.internal.IDriveService";
  }
  
  public boolean zzlN()
  {
    return (!getContext().getPackageName().equals(this.zzRq)) || (!zzrl());
  }
  
  protected Bundle zzly()
  {
    String str = getContext().getPackageName();
    zzx.zzw(str);
    if (!zzpa().zzoL().isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzZ(bool);
      Bundle localBundle = new Bundle();
      if (!str.equals(this.zzRq)) {
        localBundle.putString("proxy_package_name", this.zzRq);
      }
      localBundle.putAll(this.zzakC);
      return localBundle;
    }
  }
  
  public boolean zzpe()
  {
    return true;
  }
  
  boolean zzrl()
  {
    return GooglePlayServicesUtil.zze(getContext(), Process.myUid());
  }
  
  public zzam zzrm()
    throws DeadObjectException
  {
    return (zzam)zzpc();
  }
  
  public DriveId zzrn()
  {
    return this.zzakE;
  }
  
  public DriveId zzro()
  {
    return this.zzakF;
  }
  
  public boolean zzrp()
  {
    return this.zzakG;
  }
  
  public boolean zzrq()
  {
    return this.zzakD;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */