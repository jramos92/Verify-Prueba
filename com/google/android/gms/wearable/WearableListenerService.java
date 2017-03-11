package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.internal.zzaw.zza;
import java.util.List;

public abstract class WearableListenerService
  extends Service
  implements CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, DataApi.DataListener, MessageApi.MessageListener, NodeApi.NodeListener, NodeApi.zza
{
  public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
  private boolean zzMG;
  private String zzQe;
  private volatile int zzaeG = -1;
  private IBinder zzaeJ;
  private Handler zzbfk;
  private Object zzbfl = new Object();
  
  private void zzEN()
    throws SecurityException
  {
    int i = Binder.getCallingUid();
    if (i == this.zzaeG) {
      return;
    }
    if (GooglePlayServicesUtil.zze(this, i))
    {
      this.zzaeG = i;
      return;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction())) {
      return this.zzaeJ;
    }
    return null;
  }
  
  public void onCapabilityChanged(CapabilityInfo paramCapabilityInfo) {}
  
  public void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onChannelOpened(Channel paramChannel) {}
  
  public void onConnectedNodes(List<Node> paramList) {}
  
  public void onCreate()
  {
    super.onCreate();
    if (Log.isLoggable("WearableLS", 3)) {
      Log.d("WearableLS", "onCreate: " + getPackageName());
    }
    this.zzQe = getPackageName();
    HandlerThread localHandlerThread = new HandlerThread("WearableListenerService");
    localHandlerThread.start();
    this.zzbfk = new Handler(localHandlerThread.getLooper());
    this.zzaeJ = new zza();
  }
  
  public void onDataChanged(DataEventBuffer paramDataEventBuffer) {}
  
  public void onDestroy()
  {
    synchronized (this.zzbfl)
    {
      this.zzMG = true;
      if (this.zzbfk == null) {
        throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
      }
    }
    this.zzbfk.getLooper().quit();
    super.onDestroy();
  }
  
  public void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onMessageReceived(MessageEvent paramMessageEvent) {}
  
  public void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onPeerConnected(Node paramNode) {}
  
  public void onPeerDisconnected(Node paramNode) {}
  
  private class zza
    extends zzaw.zza
  {
    boolean zzbfm = false;
    
    zza() {}
    
    public void onConnectedNodes(final List<NodeParcelable> paramList)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onConnectedNodes: " + WearableListenerService.zza(WearableListenerService.this) + ": " + paramList);
      }
      WearableListenerService.zzb(WearableListenerService.this);
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this)) {
          return;
        }
        WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            WearableListenerService.this.onConnectedNodes(paramList);
          }
        });
        return;
      }
    }
    
    public void zza(final AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onEntityUpdate: " + paramAmsEntityUpdateParcelable);
      }
      if (!this.zzbfm) {
        return;
      }
      WearableListenerService.zzb(WearableListenerService.this);
      final zzj localzzj = (zzj)WearableListenerService.this;
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this)) {
          return;
        }
      }
      WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
      {
        public void run()
        {
          localzzj.zza(paramAmsEntityUpdateParcelable);
        }
      });
    }
    
    public void zza(final AncsNotificationParcelable paramAncsNotificationParcelable)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onNotificationReceived: " + paramAncsNotificationParcelable);
      }
      if (!this.zzbfm) {
        return;
      }
      WearableListenerService.zzb(WearableListenerService.this);
      final zzj localzzj = (zzj)WearableListenerService.this;
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this)) {
          return;
        }
      }
      WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
      {
        public void run()
        {
          localzzj.zza(paramAncsNotificationParcelable);
        }
      });
    }
    
    public void zza(final CapabilityInfoParcelable paramCapabilityInfoParcelable)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onConnectedCapabilityChanged: " + paramCapabilityInfoParcelable);
      }
      WearableListenerService.zzb(WearableListenerService.this);
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this)) {
          return;
        }
        WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            WearableListenerService.this.onCapabilityChanged(paramCapabilityInfoParcelable);
          }
        });
        return;
      }
    }
    
    public void zza(final ChannelEventParcelable paramChannelEventParcelable)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onChannelEvent: " + paramChannelEventParcelable);
      }
      WearableListenerService.zzb(WearableListenerService.this);
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this)) {
          return;
        }
        WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            paramChannelEventParcelable.zza(WearableListenerService.this);
          }
        });
        return;
      }
    }
    
    public void zza(final MessageEventParcelable paramMessageEventParcelable)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onMessageReceived: " + paramMessageEventParcelable);
      }
      WearableListenerService.zzb(WearableListenerService.this);
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this)) {
          return;
        }
        WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            WearableListenerService.this.onMessageReceived(paramMessageEventParcelable);
          }
        });
        return;
      }
    }
    
    public void zza(final NodeParcelable paramNodeParcelable)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onPeerConnected: " + WearableListenerService.zza(WearableListenerService.this) + ": " + paramNodeParcelable);
      }
      WearableListenerService.zzb(WearableListenerService.this);
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this)) {
          return;
        }
        WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            WearableListenerService.this.onPeerConnected(paramNodeParcelable);
          }
        });
        return;
      }
    }
    
    public void zzaf(final DataHolder paramDataHolder)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onDataItemChanged: " + WearableListenerService.zza(WearableListenerService.this) + ": " + paramDataHolder);
      }
      WearableListenerService.zzb(WearableListenerService.this);
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this))
        {
          paramDataHolder.close();
          return;
        }
        WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            DataEventBuffer localDataEventBuffer = new DataEventBuffer(paramDataHolder);
            try
            {
              WearableListenerService.this.onDataChanged(localDataEventBuffer);
              return;
            }
            finally
            {
              localDataEventBuffer.release();
            }
          }
        });
        return;
      }
    }
    
    public void zzb(final NodeParcelable paramNodeParcelable)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", "onPeerDisconnected: " + WearableListenerService.zza(WearableListenerService.this) + ": " + paramNodeParcelable);
      }
      WearableListenerService.zzb(WearableListenerService.this);
      synchronized (WearableListenerService.zzc(WearableListenerService.this))
      {
        if (WearableListenerService.zzd(WearableListenerService.this)) {
          return;
        }
        WearableListenerService.zze(WearableListenerService.this).post(new Runnable()
        {
          public void run()
          {
            WearableListenerService.this.onPeerDisconnected(paramNodeParcelable);
          }
        });
        return;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\WearableListenerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */