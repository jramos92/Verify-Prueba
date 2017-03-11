package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzl.zza;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapView
  extends FrameLayout
{
  private GoogleMap zzaIO;
  private final zzb zzaIU;
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    this.zzaIU = new zzb(this, paramContext, null);
    init();
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.zzaIU = new zzb(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
    init();
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.zzaIU = new zzb(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
    init();
  }
  
  public MapView(Context paramContext, GoogleMapOptions paramGoogleMapOptions)
  {
    super(paramContext);
    this.zzaIU = new zzb(this, paramContext, paramGoogleMapOptions);
    init();
  }
  
  private void init()
  {
    setClickable(true);
  }
  
  @Deprecated
  public final GoogleMap getMap()
  {
    if (this.zzaIO != null) {
      return this.zzaIO;
    }
    this.zzaIU.zzxL();
    if (this.zzaIU.zzrZ() == null) {
      return null;
    }
    try
    {
      this.zzaIO = new GoogleMap(((zza)this.zzaIU.zzrZ()).zzxM().getMap());
      return this.zzaIO;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
  {
    zzx.zzci("getMapAsync() must be called on the main thread");
    this.zzaIU.getMapAsync(paramOnMapReadyCallback);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    this.zzaIU.onCreate(paramBundle);
    if (this.zzaIU.zzrZ() == null) {
      zza.zzb(this);
    }
  }
  
  public final void onDestroy()
  {
    this.zzaIU.onDestroy();
  }
  
  public final void onEnterAmbient(Bundle paramBundle)
  {
    zzx.zzci("onEnterAmbient() must be called on the main thread");
    this.zzaIU.onEnterAmbient(paramBundle);
  }
  
  public final void onExitAmbient()
  {
    zzx.zzci("onExitAmbient() must be called on the main thread");
    this.zzaIU.onExitAmbient();
  }
  
  public final void onLowMemory()
  {
    this.zzaIU.onLowMemory();
  }
  
  public final void onPause()
  {
    this.zzaIU.onPause();
  }
  
  public final void onResume()
  {
    this.zzaIU.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.zzaIU.onSaveInstanceState(paramBundle);
  }
  
  static class zza
    implements MapLifecycleDelegate
  {
    private final ViewGroup zzaIV;
    private final IMapViewDelegate zzaIW;
    private View zzaIX;
    
    public zza(ViewGroup paramViewGroup, IMapViewDelegate paramIMapViewDelegate)
    {
      this.zzaIW = ((IMapViewDelegate)zzx.zzw(paramIMapViewDelegate));
      this.zzaIV = ((ViewGroup)zzx.zzw(paramViewGroup));
    }
    
    public void getMapAsync(final OnMapReadyCallback paramOnMapReadyCallback)
    {
      try
      {
        this.zzaIW.getMapAsync(new zzl.zza()
        {
          public void zza(IGoogleMapDelegate paramAnonymousIGoogleMapDelegate)
            throws RemoteException
          {
            paramOnMapReadyCallback.onMapReady(new GoogleMap(paramAnonymousIGoogleMapDelegate));
          }
        });
        return;
      }
      catch (RemoteException paramOnMapReadyCallback)
      {
        throw new RuntimeRemoteException(paramOnMapReadyCallback);
      }
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.zzaIW.onCreate(paramBundle);
        this.zzaIX = ((View)zze.zzp(this.zzaIW.getView()));
        this.zzaIV.removeAllViews();
        this.zzaIV.addView(this.zzaIX);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
    }
    
    public void onDestroy()
    {
      try
      {
        this.zzaIW.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroyView()
    {
      throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
    }
    
    public void onEnterAmbient(Bundle paramBundle)
    {
      try
      {
        this.zzaIW.onEnterAmbient(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public void onExitAmbient()
    {
      try
      {
        this.zzaIW.onExitAmbient();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
    }
    
    public void onLowMemory()
    {
      try
      {
        this.zzaIW.onLowMemory();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onPause()
    {
      try
      {
        this.zzaIW.onPause();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onResume()
    {
      try
      {
        this.zzaIW.onResume();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onSaveInstanceState(Bundle paramBundle)
    {
      try
      {
        this.zzaIW.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public void onStart() {}
    
    public void onStop() {}
    
    public IMapViewDelegate zzxM()
    {
      return this.zzaIW;
    }
  }
  
  static class zzb
    extends zza<MapView.zza>
  {
    private final Context mContext;
    protected zzf<MapView.zza> zzaIS;
    private final List<OnMapReadyCallback> zzaIT = new ArrayList();
    private final ViewGroup zzaIZ;
    private final GoogleMapOptions zzaJa;
    
    zzb(ViewGroup paramViewGroup, Context paramContext, GoogleMapOptions paramGoogleMapOptions)
    {
      this.zzaIZ = paramViewGroup;
      this.mContext = paramContext;
      this.zzaJa = paramGoogleMapOptions;
    }
    
    public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
    {
      if (zzrZ() != null)
      {
        ((MapView.zza)zzrZ()).getMapAsync(paramOnMapReadyCallback);
        return;
      }
      this.zzaIT.add(paramOnMapReadyCallback);
    }
    
    public void onEnterAmbient(Bundle paramBundle)
    {
      if (zzrZ() != null) {
        ((MapView.zza)zzrZ()).onEnterAmbient(paramBundle);
      }
    }
    
    public void onExitAmbient()
    {
      if (zzrZ() != null) {
        ((MapView.zza)zzrZ()).onExitAmbient();
      }
    }
    
    protected void zza(zzf<MapView.zza> paramzzf)
    {
      this.zzaIS = paramzzf;
      zzxL();
    }
    
    public void zzxL()
    {
      if ((this.zzaIS != null) && (zzrZ() == null)) {
        try
        {
          MapsInitializer.initialize(this.mContext);
          Object localObject = zzy.zzaG(this.mContext).zza(zze.zzy(this.mContext), this.zzaJa);
          if (localObject == null) {
            return;
          }
          this.zzaIS.zza(new MapView.zza(this.zzaIZ, (IMapViewDelegate)localObject));
          localObject = this.zzaIT.iterator();
          while (((Iterator)localObject).hasNext())
          {
            OnMapReadyCallback localOnMapReadyCallback = (OnMapReadyCallback)((Iterator)localObject).next();
            ((MapView.zza)zzrZ()).getMapAsync(localOnMapReadyCallback);
          }
          return;
        }
        catch (RemoteException localRemoteException)
        {
          throw new RuntimeRemoteException(localRemoteException);
          this.zzaIT.clear();
          return;
        }
        catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\MapView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */