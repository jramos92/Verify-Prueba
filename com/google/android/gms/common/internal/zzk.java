package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk
  implements Handler.Callback
{
  private final Handler mHandler;
  private final zza zzafP;
  private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzafQ = new ArrayList();
  final ArrayList<GoogleApiClient.ConnectionCallbacks> zzafR = new ArrayList();
  private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzafS = new ArrayList();
  private volatile boolean zzafT = false;
  private final AtomicInteger zzafU = new AtomicInteger(0);
  private boolean zzafV = false;
  private final Object zzpd = new Object();
  
  public zzk(Looper paramLooper, zza paramzza)
  {
    this.zzafP = paramzza;
    this.mHandler = new Handler(paramLooper, this);
  }
  
  public boolean handleMessage(Message arg1)
  {
    if (???.what == 1)
    {
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)???.obj;
      synchronized (this.zzpd)
      {
        if ((this.zzafT) && (this.zzafP.isConnected()) && (this.zzafQ.contains(localConnectionCallbacks))) {
          localConnectionCallbacks.onConnected(this.zzafP.zzmS());
        }
        return true;
      }
    }
    Log.wtf("GmsClientEvents", "Don't know how to handle message: " + ???.what, new Exception());
    return false;
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzx.zzw(paramConnectionCallbacks);
    synchronized (this.zzpd)
    {
      boolean bool = this.zzafQ.contains(paramConnectionCallbacks);
      return bool;
    }
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzx.zzw(paramOnConnectionFailedListener);
    synchronized (this.zzpd)
    {
      boolean bool = this.zzafS.contains(paramOnConnectionFailedListener);
      return bool;
    }
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzx.zzw(paramConnectionCallbacks);
    synchronized (this.zzpd)
    {
      if (this.zzafQ.contains(paramConnectionCallbacks))
      {
        Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + paramConnectionCallbacks + " is already registered");
        if (this.zzafP.isConnected()) {
          this.mHandler.sendMessage(this.mHandler.obtainMessage(1, paramConnectionCallbacks));
        }
        return;
      }
      this.zzafQ.add(paramConnectionCallbacks);
    }
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzx.zzw(paramOnConnectionFailedListener);
    synchronized (this.zzpd)
    {
      if (this.zzafS.contains(paramOnConnectionFailedListener))
      {
        Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " is already registered");
        return;
      }
      this.zzafS.add(paramOnConnectionFailedListener);
    }
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    zzx.zzw(paramConnectionCallbacks);
    synchronized (this.zzpd)
    {
      if (!this.zzafQ.remove(paramConnectionCallbacks)) {
        Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + paramConnectionCallbacks + " not found");
      }
      while (!this.zzafV) {
        return;
      }
      this.zzafR.add(paramConnectionCallbacks);
    }
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    zzx.zzw(paramOnConnectionFailedListener);
    synchronized (this.zzpd)
    {
      if (!this.zzafS.remove(paramOnConnectionFailedListener)) {
        Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + paramOnConnectionFailedListener + " not found");
      }
      return;
    }
  }
  
  public void zzbG(int paramInt)
  {
    boolean bool = false;
    if (Looper.myLooper() == this.mHandler.getLooper()) {
      bool = true;
    }
    zzx.zza(bool, "onUnintentionalDisconnection must only be called on the Handler thread");
    this.mHandler.removeMessages(1);
    synchronized (this.zzpd)
    {
      this.zzafV = true;
      Object localObject2 = new ArrayList(this.zzafQ);
      int i = this.zzafU.get();
      localObject2 = ((ArrayList)localObject2).iterator();
      GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
      do
      {
        if (((Iterator)localObject2).hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
          if ((this.zzafT) && (this.zzafU.get() == i)) {}
        }
        else
        {
          this.zzafR.clear();
          this.zzafV = false;
          return;
        }
      } while (!this.zzafQ.contains(localConnectionCallbacks));
      localConnectionCallbacks.onConnectionSuspended(paramInt);
    }
  }
  
  public void zzh(Bundle paramBundle)
  {
    boolean bool2 = true;
    boolean bool1;
    if (Looper.myLooper() == this.mHandler.getLooper())
    {
      bool1 = true;
      zzx.zza(bool1, "onConnectionSuccess must only be called on the Handler thread");
    }
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if (this.zzafV) {
          break label206;
        }
        bool1 = true;
        zzx.zzZ(bool1);
        this.mHandler.removeMessages(1);
        this.zzafV = true;
        if (this.zzafR.size() != 0) {
          break label211;
        }
        bool1 = bool2;
        zzx.zzZ(bool1);
        Object localObject2 = new ArrayList(this.zzafQ);
        int i = this.zzafU.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        GoogleApiClient.ConnectionCallbacks localConnectionCallbacks;
        if (((Iterator)localObject2).hasNext())
        {
          localConnectionCallbacks = (GoogleApiClient.ConnectionCallbacks)((Iterator)localObject2).next();
          if ((this.zzafT) && (this.zzafP.isConnected()) && (this.zzafU.get() == i)) {}
        }
        else
        {
          this.zzafR.clear();
          this.zzafV = false;
          return;
        }
        if (this.zzafR.contains(localConnectionCallbacks)) {
          continue;
        }
        localConnectionCallbacks.onConnected(paramBundle);
      }
      bool1 = false;
      break;
      label206:
      bool1 = false;
      continue;
      label211:
      bool1 = false;
    }
  }
  
  public void zzi(ConnectionResult paramConnectionResult)
  {
    if (Looper.myLooper() == this.mHandler.getLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "onConnectionFailure must only be called on the Handler thread");
      this.mHandler.removeMessages(1);
      synchronized (this.zzpd)
      {
        Object localObject2 = new ArrayList(this.zzafS);
        int i = this.zzafU.get();
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          GoogleApiClient.OnConnectionFailedListener localOnConnectionFailedListener = (GoogleApiClient.OnConnectionFailedListener)((Iterator)localObject2).next();
          if ((!this.zzafT) || (this.zzafU.get() != i)) {
            return;
          }
          if (this.zzafS.contains(localOnConnectionFailedListener)) {
            localOnConnectionFailedListener.onConnectionFailed(paramConnectionResult);
          }
        }
      }
      return;
    }
  }
  
  public void zzpk()
  {
    this.zzafT = false;
    this.zzafU.incrementAndGet();
  }
  
  public void zzpl()
  {
    this.zzafT = true;
  }
  
  public static abstract interface zza
  {
    public abstract boolean isConnected();
    
    public abstract Bundle zzmS();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */