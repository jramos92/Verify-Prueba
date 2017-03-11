package com.google.android.gms.cast;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v7.media.MediaRouteSelector.Builder;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.text.TextUtils;
import android.view.Display;
import com.google.android.gms.R.drawable;
import com.google.android.gms.R.id;
import com.google.android.gms.R.string;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CastRemoteDisplayLocalService
  extends Service
{
  private static CastRemoteDisplayLocalService zzVF;
  private static final zzl zzVo = new zzl("CastRemoteDisplayLocalService");
  private static final int zzVp = R.id.cast_notification_id;
  private static final Object zzVq = new Object();
  private static AtomicBoolean zzVr = new AtomicBoolean(false);
  private Handler mHandler;
  private Notification mNotification;
  private String zzUM;
  private Display zzVA;
  private Context zzVB;
  private ServiceConnection zzVC;
  private MediaRouter zzVD;
  private final MediaRouter.Callback zzVE = new MediaRouter.Callback()
  {
    public void onRouteUnselected(MediaRouter paramAnonymousMediaRouter, MediaRouter.RouteInfo paramAnonymousRouteInfo)
    {
      CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, "onRouteUnselected");
      if (CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this) == null)
      {
        CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, "onRouteUnselected, no device was selected");
        return;
      }
      if (!CastDevice.getFromBundle(paramAnonymousRouteInfo.getExtras()).getDeviceId().equals(CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this).getDeviceId()))
      {
        CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, "onRouteUnselected, device does not match");
        return;
      }
      CastRemoteDisplayLocalService.stopService();
    }
  };
  private final IBinder zzVG = new zza(null);
  private GoogleApiClient zzVs;
  private CastRemoteDisplay.CastRemoteDisplaySessionCallbacks zzVt;
  private Callbacks zzVu;
  private zzb zzVv;
  private NotificationSettings zzVw;
  private Boolean zzVx;
  private PendingIntent zzVy;
  private CastDevice zzVz;
  
  public static CastRemoteDisplayLocalService getInstance()
  {
    synchronized (zzVq)
    {
      CastRemoteDisplayLocalService localCastRemoteDisplayLocalService = zzVF;
      return localCastRemoteDisplayLocalService;
    }
  }
  
  protected static void setDebugEnabled()
  {
    zzVo.zzX(true);
  }
  
  public static void startService(final Context paramContext, Class<? extends CastRemoteDisplayLocalService> paramClass, String paramString, final CastDevice paramCastDevice, final NotificationSettings paramNotificationSettings, final Callbacks paramCallbacks)
  {
    zzVo.zzb("Starting Service", new Object[0]);
    synchronized (zzVq)
    {
      if (zzVF != null)
      {
        zzVo.zzf("An existing service had not been stopped before starting one", new Object[0]);
        zzR(true);
      }
      zzb(paramContext, paramClass);
      zzx.zzb(paramContext, "activityContext is required.");
      zzx.zzb(paramClass, "serviceClass is required.");
      zzx.zzb(paramString, "applicationId is required.");
      zzx.zzb(paramCastDevice, "device is required.");
      zzx.zzb(paramNotificationSettings, "notificationSettings is required.");
      zzx.zzb(paramCallbacks, "callbacks is required.");
      if ((NotificationSettings.zza(paramNotificationSettings) == null) && (NotificationSettings.zzd(paramNotificationSettings) == null)) {
        throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
      }
    }
    if (zzVr.getAndSet(true))
    {
      zzVo.zzc("Service is already being started, startService has been called twice", new Object[0]);
      return;
    }
    paramClass = new Intent(paramContext, paramClass);
    paramContext.startService(paramClass);
    paramContext.bindService(paramClass, new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        paramAnonymousComponentName = ((CastRemoteDisplayLocalService.zza)paramAnonymousIBinder).zzmw();
        if ((paramAnonymousComponentName == null) || (!CastRemoteDisplayLocalService.zza(paramAnonymousComponentName, this.zzUS, paramCastDevice, paramNotificationSettings, paramContext, this, paramCallbacks)))
        {
          CastRemoteDisplayLocalService.zzms().zzc("Connected but unable to get the service instance", new Object[0]);
          paramCallbacks.onRemoteDisplaySessionError(new Status(2200));
          CastRemoteDisplayLocalService.zzmt().set(false);
        }
        try
        {
          paramContext.unbindService(this);
          return;
        }
        catch (IllegalArgumentException paramAnonymousComponentName)
        {
          CastRemoteDisplayLocalService.zzms().zzb("No need to unbind service, already unbound", new Object[0]);
        }
      }
      
      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
        CastRemoteDisplayLocalService.zzms().zzb("onServiceDisconnected", new Object[0]);
        paramCallbacks.onRemoteDisplaySessionError(new Status(2201, "Service Disconnected"));
        CastRemoteDisplayLocalService.zzmt().set(false);
        try
        {
          paramContext.unbindService(this);
          return;
        }
        catch (IllegalArgumentException paramAnonymousComponentName)
        {
          CastRemoteDisplayLocalService.zzms().zzb("No need to unbind service, already unbound", new Object[0]);
        }
      }
    }, 64);
  }
  
  public static void stopService()
  {
    zzR(false);
  }
  
  private void zzQ(boolean paramBoolean)
  {
    zzbb("Stopping Service");
    if ((!paramBoolean) && (this.zzVD != null))
    {
      zzbb("Setting default route");
      this.zzVD.selectRoute(this.zzVD.getDefaultRoute());
    }
    if (this.zzVv != null)
    {
      zzbb("Unregistering notification receiver");
      unregisterReceiver(this.zzVv);
    }
    zzmp();
    zzmq();
    zzml();
    if (this.zzVs != null)
    {
      this.zzVs.disconnect();
      this.zzVs = null;
    }
    if ((this.zzVB != null) && (this.zzVC != null)) {}
    try
    {
      this.zzVB.unbindService(this.zzVC);
      this.zzVC = null;
      this.zzVB = null;
      this.zzUM = null;
      this.zzVs = null;
      this.mNotification = null;
      this.zzVA = null;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        zzbb("No need to unbind service, already unbound");
      }
    }
  }
  
  private static void zzR(boolean paramBoolean)
  {
    zzVo.zzb("Stopping Service", new Object[0]);
    zzVr.set(false);
    synchronized (zzVq)
    {
      if (zzVF == null)
      {
        zzVo.zzc("Service is already being stopped", new Object[0]);
        return;
      }
      CastRemoteDisplayLocalService localCastRemoteDisplayLocalService = zzVF;
      zzVF = null;
      localCastRemoteDisplayLocalService.zzQ(paramBoolean);
      return;
    }
  }
  
  private Notification zzS(boolean paramBoolean)
  {
    zzbb("createDefaultNotification");
    int k = getApplicationInfo().labelRes;
    String str3 = NotificationSettings.zzb(this.zzVw);
    String str2 = NotificationSettings.zzc(this.zzVw);
    int j;
    int i;
    String str1;
    if (paramBoolean)
    {
      j = R.string.cast_notification_connected_message;
      i = R.drawable.cast_ic_notification_on;
      str1 = str3;
      if (TextUtils.isEmpty(str3)) {
        str1 = getString(k);
      }
      if (!TextUtils.isEmpty(str2)) {
        break label163;
      }
      str2 = getString(j, new Object[] { this.zzVz.getFriendlyName() });
    }
    label163:
    for (;;)
    {
      return new NotificationCompat.Builder(this).setContentTitle(str1).setContentText(str2).setContentIntent(NotificationSettings.zzd(this.zzVw)).setSmallIcon(i).setOngoing(true).addAction(17301560, getString(R.string.cast_notification_disconnect), zzmr()).build();
      j = R.string.cast_notification_connecting_message;
      i = R.drawable.cast_ic_notification_connecting;
      break;
    }
  }
  
  private GoogleApiClient zza(CastDevice paramCastDevice)
  {
    paramCastDevice = new CastRemoteDisplay.CastRemoteDisplayOptions.Builder(paramCastDevice, this.zzVt);
    new GoogleApiClient.Builder(this, new GoogleApiClient.ConnectionCallbacks()new GoogleApiClient.OnConnectionFailedListener
    {
      public void onConnected(Bundle paramAnonymousBundle)
      {
        CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, "onConnected");
        CastRemoteDisplayLocalService.zzf(CastRemoteDisplayLocalService.this);
      }
      
      public void onConnectionSuspended(int paramAnonymousInt)
      {
        CastRemoteDisplayLocalService.zzms().zzf(String.format("[Instance: %s] ConnectionSuspended %d", new Object[] { this, Integer.valueOf(paramAnonymousInt) }), new Object[0]);
      }
    }, new GoogleApiClient.OnConnectionFailedListener()
    {
      public void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
      {
        CastRemoteDisplayLocalService.zzb(CastRemoteDisplayLocalService.this, "Connection failed: " + paramAnonymousConnectionResult);
        CastRemoteDisplayLocalService.zzc(CastRemoteDisplayLocalService.this);
      }
    }).addApi(CastRemoteDisplay.API, paramCastDevice.build()).build();
  }
  
  private void zza(Display paramDisplay)
  {
    this.zzVA = paramDisplay;
    if (this.zzVx.booleanValue())
    {
      this.mNotification = zzS(true);
      startForeground(zzVp, this.mNotification);
    }
    if (this.zzVu != null)
    {
      this.zzVu.onRemoteDisplaySessionStarted(this);
      this.zzVu = null;
    }
    onCreatePresentation(this.zzVA);
  }
  
  private boolean zza(String paramString, CastDevice paramCastDevice, NotificationSettings paramNotificationSettings, Context paramContext, ServiceConnection paramServiceConnection, Callbacks paramCallbacks)
  {
    zzbb("startRemoteDisplaySession");
    zzx.zzci("Starting the Cast Remote Display must be done on the main thread");
    for (;;)
    {
      synchronized (zzVq)
      {
        if (zzVF != null)
        {
          zzVo.zzf("An existing service had not been stopped before starting one", new Object[0]);
          return false;
        }
        zzVF = this;
        this.zzVu = paramCallbacks;
        this.zzUM = paramString;
        this.zzVz = paramCastDevice;
        this.zzVB = paramContext;
        this.zzVC = paramServiceConnection;
        this.zzVD = MediaRouter.getInstance(getApplicationContext());
        paramString = new MediaRouteSelector.Builder().addControlCategory(CastMediaControlIntent.categoryForCast(this.zzUM)).build();
        zzbb("addMediaRouterCallback");
        this.zzVD.addCallback(paramString, this.zzVE, 4);
        this.mHandler = new Handler(getMainLooper());
        this.mNotification = NotificationSettings.zza(paramNotificationSettings);
        this.zzVv = new zzb(null);
        registerReceiver(this.zzVv, new IntentFilter("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"));
        this.zzVw = new NotificationSettings(paramNotificationSettings, null);
        if (NotificationSettings.zza(this.zzVw) == null)
        {
          this.zzVx = Boolean.valueOf(true);
          this.mNotification = zzS(false);
          startForeground(zzVp, this.mNotification);
          this.zzVs = zza(paramCastDevice);
          this.zzVs.connect();
          return true;
        }
      }
      this.zzVx = Boolean.valueOf(false);
      this.mNotification = NotificationSettings.zza(this.zzVw);
    }
  }
  
  private static void zzb(Context paramContext, Class paramClass)
  {
    try
    {
      paramClass = new ComponentName(paramContext, paramClass);
      paramContext = paramContext.getPackageManager().getServiceInfo(paramClass, 128);
      if ((paramContext != null) && (paramContext.exported)) {
        throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
    }
  }
  
  private void zzbb(String paramString)
  {
    zzVo.zzb("[Instance: %s] %s", new Object[] { this, paramString });
  }
  
  private void zzbe(String paramString)
  {
    zzVo.zzc("[Instance: %s] %s", new Object[] { this, paramString });
  }
  
  private void zzml()
  {
    if (this.zzVD != null)
    {
      zzx.zzci("CastRemoteDisplayLocalService calls must be done on the main thread");
      zzbb("removeMediaRouterCallback");
      this.zzVD.removeCallback(this.zzVE);
    }
  }
  
  private void zzmm()
  {
    zzbb("startRemoteDisplay");
    if ((this.zzVs == null) || (!this.zzVs.isConnected()))
    {
      zzVo.zzc("Unable to start the remote display as the API client is not ready", new Object[0]);
      return;
    }
    CastRemoteDisplay.CastRemoteDisplayApi.startRemoteDisplay(this.zzVs, this.zzUM).setResultCallback(new ResultCallback()
    {
      public void zza(CastRemoteDisplay.CastRemoteDisplaySessionResult paramAnonymousCastRemoteDisplaySessionResult)
      {
        if (!paramAnonymousCastRemoteDisplaySessionResult.getStatus().isSuccess())
        {
          CastRemoteDisplayLocalService.zzms().zzc("Connection was not successful", new Object[0]);
          CastRemoteDisplayLocalService.zzc(CastRemoteDisplayLocalService.this);
          return;
        }
        CastRemoteDisplayLocalService.zzms().zzb("startRemoteDisplay successful", new Object[0]);
        synchronized (CastRemoteDisplayLocalService.zzmu())
        {
          if (CastRemoteDisplayLocalService.zzmv() == null)
          {
            CastRemoteDisplayLocalService.zzms().zzb("Remote Display started but session already cancelled", new Object[0]);
            CastRemoteDisplayLocalService.zzc(CastRemoteDisplayLocalService.this);
            return;
          }
        }
        paramAnonymousCastRemoteDisplaySessionResult = paramAnonymousCastRemoteDisplaySessionResult.getPresentationDisplay();
        if (paramAnonymousCastRemoteDisplaySessionResult != null) {
          CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, paramAnonymousCastRemoteDisplaySessionResult);
        }
        for (;;)
        {
          CastRemoteDisplayLocalService.zzmt().set(false);
          if ((CastRemoteDisplayLocalService.zzd(CastRemoteDisplayLocalService.this) == null) || (CastRemoteDisplayLocalService.zze(CastRemoteDisplayLocalService.this) == null)) {
            break;
          }
          try
          {
            CastRemoteDisplayLocalService.zzd(CastRemoteDisplayLocalService.this).unbindService(CastRemoteDisplayLocalService.zze(CastRemoteDisplayLocalService.this));
            CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, null);
            CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, null);
            return;
            CastRemoteDisplayLocalService.zzms().zzc("Cast Remote Display session created without display", new Object[0]);
          }
          catch (IllegalArgumentException paramAnonymousCastRemoteDisplaySessionResult)
          {
            for (;;)
            {
              CastRemoteDisplayLocalService.zzms().zzb("No need to unbind service, already unbound", new Object[0]);
            }
          }
        }
      }
    });
  }
  
  private void zzmn()
  {
    zzbb("stopRemoteDisplay");
    if ((this.zzVs == null) || (!this.zzVs.isConnected()))
    {
      zzVo.zzc("Unable to stop the remote display as the API client is not ready", new Object[0]);
      return;
    }
    CastRemoteDisplay.CastRemoteDisplayApi.stopRemoteDisplay(this.zzVs).setResultCallback(new ResultCallback()
    {
      public void zza(CastRemoteDisplay.CastRemoteDisplaySessionResult paramAnonymousCastRemoteDisplaySessionResult)
      {
        if (!paramAnonymousCastRemoteDisplaySessionResult.getStatus().isSuccess()) {
          CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, "Unable to stop the remote display, result unsuccessful");
        }
        for (;;)
        {
          CastRemoteDisplayLocalService.zzb(CastRemoteDisplayLocalService.this, null);
          return;
          CastRemoteDisplayLocalService.zza(CastRemoteDisplayLocalService.this, "remote display stopped");
        }
      }
    });
  }
  
  private void zzmo()
  {
    if (this.zzVu != null)
    {
      this.zzVu.onRemoteDisplaySessionError(new Status(2200));
      this.zzVu = null;
    }
    stopService();
  }
  
  private void zzmp()
  {
    zzbb("stopRemoteDisplaySession");
    zzmn();
    onDismissPresentation();
  }
  
  private void zzmq()
  {
    zzbb("Stopping the remote display Service");
    stopForeground(true);
    stopSelf();
  }
  
  private PendingIntent zzmr()
  {
    if (this.zzVy == null) {
      this.zzVy = PendingIntent.getBroadcast(this, 0, new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"), 268435456);
    }
    return this.zzVy;
  }
  
  protected Display getDisplay()
  {
    return this.zzVA;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    zzbb("onBind");
    return this.zzVG;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.zzVt = new CastRemoteDisplay.CastRemoteDisplaySessionCallbacks()
    {
      public void onRemoteDisplayEnded(Status paramAnonymousStatus)
      {
        CastRemoteDisplayLocalService.zzms().zzb(String.format("Cast screen has ended: %d", new Object[] { Integer.valueOf(paramAnonymousStatus.getStatusCode()) }), new Object[0]);
        if (CastRemoteDisplayLocalService.zzb(CastRemoteDisplayLocalService.this) != null) {
          CastRemoteDisplayLocalService.zzb(CastRemoteDisplayLocalService.this).post(new Runnable()
          {
            public void run()
            {
              CastRemoteDisplayLocalService.zzT(false);
            }
          });
        }
      }
    };
  }
  
  public abstract void onCreatePresentation(Display paramDisplay);
  
  public abstract void onDismissPresentation();
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzbb("onStartCommand");
    return 2;
  }
  
  public void updateNotificationSettings(NotificationSettings paramNotificationSettings)
  {
    zzx.zzb(paramNotificationSettings, "notificationSettings is required.");
    if (this.zzVw == null) {
      throw new IllegalStateException("No current notification settings to update");
    }
    if (this.zzVx.booleanValue())
    {
      if (NotificationSettings.zza(paramNotificationSettings) != null) {
        throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
      }
      if (NotificationSettings.zzd(paramNotificationSettings) != null) {
        NotificationSettings.zza(this.zzVw, NotificationSettings.zzd(paramNotificationSettings));
      }
      if (!TextUtils.isEmpty(NotificationSettings.zzb(paramNotificationSettings))) {
        NotificationSettings.zza(this.zzVw, NotificationSettings.zzb(paramNotificationSettings));
      }
      if (!TextUtils.isEmpty(NotificationSettings.zzc(paramNotificationSettings))) {
        NotificationSettings.zzb(this.zzVw, NotificationSettings.zzc(paramNotificationSettings));
      }
      this.mNotification = zzS(true);
    }
    for (;;)
    {
      startForeground(zzVp, this.mNotification);
      return;
      zzx.zzb(NotificationSettings.zza(paramNotificationSettings), "notification is required.");
      this.mNotification = NotificationSettings.zza(paramNotificationSettings);
      NotificationSettings.zza(this.zzVw, this.mNotification);
    }
  }
  
  public static abstract interface Callbacks
  {
    public abstract void onRemoteDisplaySessionError(Status paramStatus);
    
    public abstract void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService paramCastRemoteDisplayLocalService);
  }
  
  public static final class NotificationSettings
  {
    private Notification mNotification;
    private PendingIntent zzVN;
    private String zzVO;
    private String zzVP;
    
    private NotificationSettings() {}
    
    private NotificationSettings(NotificationSettings paramNotificationSettings)
    {
      this.mNotification = paramNotificationSettings.mNotification;
      this.zzVN = paramNotificationSettings.zzVN;
      this.zzVO = paramNotificationSettings.zzVO;
      this.zzVP = paramNotificationSettings.zzVP;
    }
    
    public static final class Builder
    {
      private CastRemoteDisplayLocalService.NotificationSettings zzVQ = new CastRemoteDisplayLocalService.NotificationSettings(null);
      
      public CastRemoteDisplayLocalService.NotificationSettings build()
      {
        if (CastRemoteDisplayLocalService.NotificationSettings.zza(this.zzVQ) != null)
        {
          if (!TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzb(this.zzVQ))) {
            throw new IllegalArgumentException("notificationTitle requires using the default notification");
          }
          if (!TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzc(this.zzVQ))) {
            throw new IllegalArgumentException("notificationText requires using the default notification");
          }
          if (CastRemoteDisplayLocalService.NotificationSettings.zzd(this.zzVQ) != null) {
            throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
          }
        }
        else if ((TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzb(this.zzVQ))) && (TextUtils.isEmpty(CastRemoteDisplayLocalService.NotificationSettings.zzc(this.zzVQ))) && (CastRemoteDisplayLocalService.NotificationSettings.zzd(this.zzVQ) == null))
        {
          throw new IllegalArgumentException("At least an argument must be provided");
        }
        return this.zzVQ;
      }
      
      public Builder setNotification(Notification paramNotification)
      {
        CastRemoteDisplayLocalService.NotificationSettings.zza(this.zzVQ, paramNotification);
        return this;
      }
      
      public Builder setNotificationPendingIntent(PendingIntent paramPendingIntent)
      {
        CastRemoteDisplayLocalService.NotificationSettings.zza(this.zzVQ, paramPendingIntent);
        return this;
      }
      
      public Builder setNotificationText(String paramString)
      {
        CastRemoteDisplayLocalService.NotificationSettings.zzb(this.zzVQ, paramString);
        return this;
      }
      
      public Builder setNotificationTitle(String paramString)
      {
        CastRemoteDisplayLocalService.NotificationSettings.zza(this.zzVQ, paramString);
        return this;
      }
    }
  }
  
  private class zza
    extends Binder
  {
    private zza() {}
    
    CastRemoteDisplayLocalService zzmw()
    {
      return CastRemoteDisplayLocalService.this;
    }
  }
  
  private static final class zzb
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent.getAction().equals("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"))
      {
        CastRemoteDisplayLocalService.zzms().zzb("disconnecting", new Object[0]);
        CastRemoteDisplayLocalService.stopService();
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\CastRemoteDisplayLocalService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */