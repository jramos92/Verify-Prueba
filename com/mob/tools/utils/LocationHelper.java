package com.mob.tools.utils;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;

public class LocationHelper
  implements LocationListener, Handler.Callback
{
  private int GPSTimeoutSec;
  private boolean gpsRequesting;
  private Handler handler;
  private LocationManager lm;
  private boolean networkRequesting;
  int networkTimeoutSec;
  private ArrayList<Float> res;
  
  public LocationHelper()
  {
    HandlerThread localHandlerThread = new HandlerThread("LocationUpdater");
    localHandlerThread.start();
    this.handler = new Handler(localHandlerThread.getLooper(), this);
    this.res = new ArrayList();
  }
  
  private void onGPSTimeout()
  {
    this.lm.removeUpdates(this);
    this.gpsRequesting = false;
    if (this.lm.isProviderEnabled("network"))
    {
      this.networkRequesting = true;
      this.lm.requestLocationUpdates("network", 1000L, 0.0F, this);
      if (this.networkTimeoutSec > 0) {
        this.handler.sendEmptyMessageDelayed(1, this.networkTimeoutSec * 1000);
      }
      return;
    }
    try
    {
      notifyAll();
      this.handler.getLooper().quit();
      return;
    }
    finally {}
  }
  
  private void onRequest()
  {
    if (this.lm.isProviderEnabled("gps"))
    {
      this.gpsRequesting = true;
      this.lm.requestLocationUpdates("gps", 1000L, 0.0F, this);
      if (this.GPSTimeoutSec > 0) {
        this.handler.sendEmptyMessageDelayed(1, this.GPSTimeoutSec * 1000);
      }
    }
    do
    {
      return;
      if (!this.lm.isProviderEnabled("network")) {
        break;
      }
      this.networkRequesting = true;
      this.lm.requestLocationUpdates("network", 1000L, 0.0F, this);
    } while (this.networkTimeoutSec <= 0);
    this.handler.sendEmptyMessageDelayed(1, this.networkTimeoutSec * 1000);
    return;
    try
    {
      notifyAll();
      this.handler.getLooper().quit();
      return;
    }
    finally {}
  }
  
  public float[] getLocation(Context paramContext)
    throws Throwable
  {
    return getLocation(paramContext, 0);
  }
  
  public float[] getLocation(Context paramContext, int paramInt)
    throws Throwable
  {
    return getLocation(paramContext, paramInt, 0);
  }
  
  public float[] getLocation(Context paramContext, int paramInt1, int paramInt2)
    throws Throwable
  {
    this.GPSTimeoutSec = paramInt1;
    this.networkTimeoutSec = paramInt2;
    this.lm = ((LocationManager)paramContext.getSystemService("location"));
    if (this.lm == null) {
      return null;
    }
    try
    {
      this.handler.sendEmptyMessageDelayed(0, 50L);
      wait();
      if (this.res.size() > 0) {
        return new float[] { ((Float)this.res.get(0)).floatValue(), ((Float)this.res.get(1)).floatValue() };
      }
    }
    finally {}
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      onRequest();
    }
    for (;;)
    {
      return false;
      if (this.gpsRequesting)
      {
        onGPSTimeout();
        continue;
      }
      if (!this.networkRequesting) {
        continue;
      }
      this.lm.removeUpdates(this);
      try
      {
        notifyAll();
        this.handler.getLooper().quit();
      }
      finally {}
    }
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    try
    {
      this.lm.removeUpdates(this);
      if (paramLocation != null)
      {
        this.res.add(Float.valueOf((float)paramLocation.getLatitude()));
        this.res.add(Float.valueOf((float)paramLocation.getLongitude()));
      }
      notifyAll();
      this.handler.getLooper().quit();
      return;
    }
    finally {}
  }
  
  public void onProviderDisabled(String paramString) {}
  
  public void onProviderEnabled(String paramString) {}
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\utils\LocationHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */