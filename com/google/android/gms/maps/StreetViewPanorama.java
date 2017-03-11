package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzr.zza;
import com.google.android.gms.maps.internal.zzs.zza;
import com.google.android.gms.maps.internal.zzt.zza;
import com.google.android.gms.maps.internal.zzu.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanorama
{
  private final IStreetViewPanoramaDelegate zzaJc;
  
  protected StreetViewPanorama(IStreetViewPanoramaDelegate paramIStreetViewPanoramaDelegate)
  {
    this.zzaJc = ((IStreetViewPanoramaDelegate)zzx.zzw(paramIStreetViewPanoramaDelegate));
  }
  
  public void animateTo(StreetViewPanoramaCamera paramStreetViewPanoramaCamera, long paramLong)
  {
    try
    {
      this.zzaJc.animateTo(paramStreetViewPanoramaCamera, paramLong);
      return;
    }
    catch (RemoteException paramStreetViewPanoramaCamera)
    {
      throw new RuntimeRemoteException(paramStreetViewPanoramaCamera);
    }
  }
  
  public StreetViewPanoramaLocation getLocation()
  {
    try
    {
      StreetViewPanoramaLocation localStreetViewPanoramaLocation = this.zzaJc.getStreetViewPanoramaLocation();
      return localStreetViewPanoramaLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public StreetViewPanoramaCamera getPanoramaCamera()
  {
    try
    {
      StreetViewPanoramaCamera localStreetViewPanoramaCamera = this.zzaJc.getPanoramaCamera();
      return localStreetViewPanoramaCamera;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isPanningGesturesEnabled()
  {
    try
    {
      boolean bool = this.zzaJc.isPanningGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isStreetNamesEnabled()
  {
    try
    {
      boolean bool = this.zzaJc.isStreetNamesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isUserNavigationEnabled()
  {
    try
    {
      boolean bool = this.zzaJc.isUserNavigationEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public boolean isZoomGesturesEnabled()
  {
    try
    {
      boolean bool = this.zzaJc.isZoomGesturesEnabled();
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public Point orientationToPoint(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
  {
    try
    {
      paramStreetViewPanoramaOrientation = this.zzaJc.orientationToPoint(paramStreetViewPanoramaOrientation);
      if (paramStreetViewPanoramaOrientation == null) {
        return null;
      }
      paramStreetViewPanoramaOrientation = (Point)zze.zzp(paramStreetViewPanoramaOrientation);
      return paramStreetViewPanoramaOrientation;
    }
    catch (RemoteException paramStreetViewPanoramaOrientation)
    {
      throw new RuntimeRemoteException(paramStreetViewPanoramaOrientation);
    }
  }
  
  public StreetViewPanoramaOrientation pointToOrientation(Point paramPoint)
  {
    try
    {
      paramPoint = this.zzaJc.pointToOrientation(zze.zzy(paramPoint));
      return paramPoint;
    }
    catch (RemoteException paramPoint)
    {
      throw new RuntimeRemoteException(paramPoint);
    }
  }
  
  public final void setOnStreetViewPanoramaCameraChangeListener(final OnStreetViewPanoramaCameraChangeListener paramOnStreetViewPanoramaCameraChangeListener)
  {
    if (paramOnStreetViewPanoramaCameraChangeListener == null) {}
    try
    {
      this.zzaJc.setOnStreetViewPanoramaCameraChangeListener(null);
      return;
    }
    catch (RemoteException paramOnStreetViewPanoramaCameraChangeListener)
    {
      throw new RuntimeRemoteException(paramOnStreetViewPanoramaCameraChangeListener);
    }
    this.zzaJc.setOnStreetViewPanoramaCameraChangeListener(new zzr.zza()
    {
      public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera paramAnonymousStreetViewPanoramaCamera)
      {
        paramOnStreetViewPanoramaCameraChangeListener.onStreetViewPanoramaCameraChange(paramAnonymousStreetViewPanoramaCamera);
      }
    });
  }
  
  public final void setOnStreetViewPanoramaChangeListener(final OnStreetViewPanoramaChangeListener paramOnStreetViewPanoramaChangeListener)
  {
    if (paramOnStreetViewPanoramaChangeListener == null) {}
    try
    {
      this.zzaJc.setOnStreetViewPanoramaChangeListener(null);
      return;
    }
    catch (RemoteException paramOnStreetViewPanoramaChangeListener)
    {
      throw new RuntimeRemoteException(paramOnStreetViewPanoramaChangeListener);
    }
    this.zzaJc.setOnStreetViewPanoramaChangeListener(new zzs.zza()
    {
      public void onStreetViewPanoramaChange(StreetViewPanoramaLocation paramAnonymousStreetViewPanoramaLocation)
      {
        paramOnStreetViewPanoramaChangeListener.onStreetViewPanoramaChange(paramAnonymousStreetViewPanoramaLocation);
      }
    });
  }
  
  public final void setOnStreetViewPanoramaClickListener(final OnStreetViewPanoramaClickListener paramOnStreetViewPanoramaClickListener)
  {
    if (paramOnStreetViewPanoramaClickListener == null) {}
    try
    {
      this.zzaJc.setOnStreetViewPanoramaClickListener(null);
      return;
    }
    catch (RemoteException paramOnStreetViewPanoramaClickListener)
    {
      throw new RuntimeRemoteException(paramOnStreetViewPanoramaClickListener);
    }
    this.zzaJc.setOnStreetViewPanoramaClickListener(new zzt.zza()
    {
      public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation paramAnonymousStreetViewPanoramaOrientation)
      {
        paramOnStreetViewPanoramaClickListener.onStreetViewPanoramaClick(paramAnonymousStreetViewPanoramaOrientation);
      }
    });
  }
  
  public final void setOnStreetViewPanoramaLongClickListener(final OnStreetViewPanoramaLongClickListener paramOnStreetViewPanoramaLongClickListener)
  {
    if (paramOnStreetViewPanoramaLongClickListener == null) {}
    try
    {
      this.zzaJc.setOnStreetViewPanoramaLongClickListener(null);
      return;
    }
    catch (RemoteException paramOnStreetViewPanoramaLongClickListener)
    {
      throw new RuntimeRemoteException(paramOnStreetViewPanoramaLongClickListener);
    }
    this.zzaJc.setOnStreetViewPanoramaLongClickListener(new zzu.zza()
    {
      public void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation paramAnonymousStreetViewPanoramaOrientation)
      {
        paramOnStreetViewPanoramaLongClickListener.onStreetViewPanoramaLongClick(paramAnonymousStreetViewPanoramaOrientation);
      }
    });
  }
  
  public void setPanningGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.zzaJc.enablePanning(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setPosition(LatLng paramLatLng)
  {
    try
    {
      this.zzaJc.setPosition(paramLatLng);
      return;
    }
    catch (RemoteException paramLatLng)
    {
      throw new RuntimeRemoteException(paramLatLng);
    }
  }
  
  public void setPosition(LatLng paramLatLng, int paramInt)
  {
    try
    {
      this.zzaJc.setPositionWithRadius(paramLatLng, paramInt);
      return;
    }
    catch (RemoteException paramLatLng)
    {
      throw new RuntimeRemoteException(paramLatLng);
    }
  }
  
  public void setPosition(String paramString)
  {
    try
    {
      this.zzaJc.setPositionWithID(paramString);
      return;
    }
    catch (RemoteException paramString)
    {
      throw new RuntimeRemoteException(paramString);
    }
  }
  
  public void setStreetNamesEnabled(boolean paramBoolean)
  {
    try
    {
      this.zzaJc.enableStreetNames(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setUserNavigationEnabled(boolean paramBoolean)
  {
    try
    {
      this.zzaJc.enableUserNavigation(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean)
  {
    try
    {
      this.zzaJc.enableZoom(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  IStreetViewPanoramaDelegate zzxN()
  {
    return this.zzaJc;
  }
  
  public static abstract interface OnStreetViewPanoramaCameraChangeListener
  {
    public abstract void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera paramStreetViewPanoramaCamera);
  }
  
  public static abstract interface OnStreetViewPanoramaChangeListener
  {
    public abstract void onStreetViewPanoramaChange(StreetViewPanoramaLocation paramStreetViewPanoramaLocation);
  }
  
  public static abstract interface OnStreetViewPanoramaClickListener
  {
    public abstract void onStreetViewPanoramaClick(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation);
  }
  
  public static abstract interface OnStreetViewPanoramaLongClickListener
  {
    public abstract void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\StreetViewPanorama.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */