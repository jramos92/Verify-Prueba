package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzl.zza;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapFragment
  extends Fragment
{
  private final zzb zzaIN = new zzb(this);
  private GoogleMap zzaIO;
  
  public static MapFragment newInstance()
  {
    return new MapFragment();
  }
  
  public static MapFragment newInstance(GoogleMapOptions paramGoogleMapOptions)
  {
    MapFragment localMapFragment = new MapFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", paramGoogleMapOptions);
    localMapFragment.setArguments(localBundle);
    return localMapFragment;
  }
  
  @Deprecated
  public final GoogleMap getMap()
  {
    Object localObject = zzxK();
    if (localObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        localObject = ((IMapFragmentDelegate)localObject).getMap();
        if (localObject == null) {
          continue;
        }
        if ((this.zzaIO == null) || (this.zzaIO.zzxy().asBinder() != ((IGoogleMapDelegate)localObject).asBinder())) {
          this.zzaIO = new GoogleMap((IGoogleMapDelegate)localObject);
        }
        return this.zzaIO;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
  }
  
  public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
  {
    com.google.android.gms.common.internal.zzx.zzci("getMapAsync must be called on the main thread.");
    this.zzaIN.getMapAsync(paramOnMapReadyCallback);
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MapFragment.class.getClassLoader());
    }
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    zzb.zza(this.zzaIN, paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.zzaIN.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = this.zzaIN.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater.setClickable(true);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.zzaIN.onDestroy();
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.zzaIN.onDestroyView();
    super.onDestroyView();
  }
  
  public final void onEnterAmbient(Bundle paramBundle)
  {
    com.google.android.gms.common.internal.zzx.zzci("onEnterAmbient must be called on the main thread.");
    this.zzaIN.onEnterAmbient(paramBundle);
  }
  
  public final void onExitAmbient()
  {
    com.google.android.gms.common.internal.zzx.zzci("onExitAmbient must be called on the main thread.");
    this.zzaIN.onExitAmbient();
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    zzb.zza(this.zzaIN, paramActivity);
    paramAttributeSet = GoogleMapOptions.createFromAttributes(paramActivity, paramAttributeSet);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("MapOptions", paramAttributeSet);
    this.zzaIN.onInflate(paramActivity, localBundle, paramBundle);
  }
  
  public void onLowMemory()
  {
    this.zzaIN.onLowMemory();
    super.onLowMemory();
  }
  
  public void onPause()
  {
    this.zzaIN.onPause();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.zzaIN.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.setClassLoader(MapFragment.class.getClassLoader());
    }
    super.onSaveInstanceState(paramBundle);
    this.zzaIN.onSaveInstanceState(paramBundle);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }
  
  protected IMapFragmentDelegate zzxK()
  {
    this.zzaIN.zzxL();
    if (this.zzaIN.zzrZ() == null) {
      return null;
    }
    return ((zza)this.zzaIN.zzrZ()).zzxK();
  }
  
  static class zza
    implements MapLifecycleDelegate
  {
    private final IMapFragmentDelegate zzaIP;
    private final Fragment zzapz;
    
    public zza(Fragment paramFragment, IMapFragmentDelegate paramIMapFragmentDelegate)
    {
      this.zzaIP = ((IMapFragmentDelegate)com.google.android.gms.common.internal.zzx.zzw(paramIMapFragmentDelegate));
      this.zzapz = ((Fragment)com.google.android.gms.common.internal.zzx.zzw(paramFragment));
    }
    
    public void getMapAsync(final OnMapReadyCallback paramOnMapReadyCallback)
    {
      try
      {
        this.zzaIP.getMapAsync(new zzl.zza()
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
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {}
      try
      {
        localBundle = new Bundle();
        paramBundle = this.zzapz.getArguments();
        if ((paramBundle != null) && (paramBundle.containsKey("MapOptions"))) {
          com.google.android.gms.maps.internal.zzx.zza(localBundle, "MapOptions", paramBundle.getParcelable("MapOptions"));
        }
        this.zzaIP.onCreate(localBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      try
      {
        paramLayoutInflater = this.zzaIP.onCreateView(zze.zzy(paramLayoutInflater), zze.zzy(paramViewGroup), paramBundle);
        return (View)zze.zzp(paramLayoutInflater);
      }
      catch (RemoteException paramLayoutInflater)
      {
        throw new RuntimeRemoteException(paramLayoutInflater);
      }
    }
    
    public void onDestroy()
    {
      try
      {
        this.zzaIP.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroyView()
    {
      try
      {
        this.zzaIP.onDestroyView();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onEnterAmbient(Bundle paramBundle)
    {
      try
      {
        this.zzaIP.onEnterAmbient(paramBundle);
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
        this.zzaIP.onExitAmbient();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      paramBundle1 = (GoogleMapOptions)paramBundle1.getParcelable("MapOptions");
      try
      {
        this.zzaIP.onInflate(zze.zzy(paramActivity), paramBundle1, paramBundle2);
        return;
      }
      catch (RemoteException paramActivity)
      {
        throw new RuntimeRemoteException(paramActivity);
      }
    }
    
    public void onLowMemory()
    {
      try
      {
        this.zzaIP.onLowMemory();
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
        this.zzaIP.onPause();
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
        this.zzaIP.onResume();
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
        this.zzaIP.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public void onStart() {}
    
    public void onStop() {}
    
    public IMapFragmentDelegate zzxK()
    {
      return this.zzaIP;
    }
  }
  
  static class zzb
    extends zza<MapFragment.zza>
  {
    private Activity mActivity;
    protected zzf<MapFragment.zza> zzaIS;
    private final List<OnMapReadyCallback> zzaIT = new ArrayList();
    private final Fragment zzapz;
    
    zzb(Fragment paramFragment)
    {
      this.zzapz = paramFragment;
    }
    
    private void setActivity(Activity paramActivity)
    {
      this.mActivity = paramActivity;
      zzxL();
    }
    
    public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
    {
      if (zzrZ() != null)
      {
        ((MapFragment.zza)zzrZ()).getMapAsync(paramOnMapReadyCallback);
        return;
      }
      this.zzaIT.add(paramOnMapReadyCallback);
    }
    
    public void onEnterAmbient(Bundle paramBundle)
    {
      if (zzrZ() != null) {
        ((MapFragment.zza)zzrZ()).onEnterAmbient(paramBundle);
      }
    }
    
    public void onExitAmbient()
    {
      if (zzrZ() != null) {
        ((MapFragment.zza)zzrZ()).onExitAmbient();
      }
    }
    
    protected void zza(zzf<MapFragment.zza> paramzzf)
    {
      this.zzaIS = paramzzf;
      zzxL();
    }
    
    public void zzxL()
    {
      if ((this.mActivity != null) && (this.zzaIS != null) && (zzrZ() == null)) {
        try
        {
          MapsInitializer.initialize(this.mActivity);
          Object localObject = zzy.zzaG(this.mActivity).zzt(zze.zzy(this.mActivity));
          if (localObject == null) {
            return;
          }
          this.zzaIS.zza(new MapFragment.zza(this.zzapz, (IMapFragmentDelegate)localObject));
          localObject = this.zzaIT.iterator();
          while (((Iterator)localObject).hasNext())
          {
            OnMapReadyCallback localOnMapReadyCallback = (OnMapReadyCallback)((Iterator)localObject).next();
            ((MapFragment.zza)zzrZ()).getMapAsync(localOnMapReadyCallback);
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\MapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */