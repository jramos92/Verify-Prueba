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
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzv.zza;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreetViewPanoramaView
  extends FrameLayout
{
  private StreetViewPanorama zzaJj;
  private final zzb zzaJv;
  
  public StreetViewPanoramaView(Context paramContext)
  {
    super(paramContext);
    this.zzaJv = new zzb(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.zzaJv = new zzb(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.zzaJv = new zzb(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    super(paramContext);
    this.zzaJv = new zzb(this, paramContext, paramStreetViewPanoramaOptions);
  }
  
  @Deprecated
  public final StreetViewPanorama getStreetViewPanorama()
  {
    if (this.zzaJj != null) {
      return this.zzaJj;
    }
    this.zzaJv.zzxL();
    if (this.zzaJv.zzrZ() == null) {
      return null;
    }
    try
    {
      this.zzaJj = new StreetViewPanorama(((zza)this.zzaJv.zzrZ()).zzxS().getStreetViewPanorama());
      return this.zzaJj;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
  {
    zzx.zzci("getStreetViewPanoramaAsync() must be called on the main thread");
    this.zzaJv.getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    this.zzaJv.onCreate(paramBundle);
    if (this.zzaJv.zzrZ() == null) {
      zza.zzb(this);
    }
  }
  
  public final void onDestroy()
  {
    this.zzaJv.onDestroy();
  }
  
  public final void onLowMemory()
  {
    this.zzaJv.onLowMemory();
  }
  
  public final void onPause()
  {
    this.zzaJv.onPause();
  }
  
  public final void onResume()
  {
    this.zzaJv.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.zzaJv.onSaveInstanceState(paramBundle);
  }
  
  static class zza
    implements StreetViewLifecycleDelegate
  {
    private final ViewGroup zzaIV;
    private final IStreetViewPanoramaViewDelegate zzaJw;
    private View zzaJx;
    
    public zza(ViewGroup paramViewGroup, IStreetViewPanoramaViewDelegate paramIStreetViewPanoramaViewDelegate)
    {
      this.zzaJw = ((IStreetViewPanoramaViewDelegate)zzx.zzw(paramIStreetViewPanoramaViewDelegate));
      this.zzaIV = ((ViewGroup)zzx.zzw(paramViewGroup));
    }
    
    public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
    {
      try
      {
        this.zzaJw.getStreetViewPanoramaAsync(new zzv.zza()
        {
          public void zza(IStreetViewPanoramaDelegate paramAnonymousIStreetViewPanoramaDelegate)
            throws RemoteException
          {
            paramOnStreetViewPanoramaReadyCallback.onStreetViewPanoramaReady(new StreetViewPanorama(paramAnonymousIStreetViewPanoramaDelegate));
          }
        });
        return;
      }
      catch (RemoteException paramOnStreetViewPanoramaReadyCallback)
      {
        throw new RuntimeRemoteException(paramOnStreetViewPanoramaReadyCallback);
      }
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.zzaJw.onCreate(paramBundle);
        this.zzaJx = ((View)zze.zzp(this.zzaJw.getView()));
        this.zzaIV.removeAllViews();
        this.zzaIV.addView(this.zzaJx);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onDestroy()
    {
      try
      {
        this.zzaJw.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroyView()
    {
      throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onLowMemory()
    {
      try
      {
        this.zzaJw.onLowMemory();
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
        this.zzaJw.onPause();
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
        this.zzaJw.onResume();
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
        this.zzaJw.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeRemoteException(paramBundle);
      }
    }
    
    public void onStart() {}
    
    public void onStop() {}
    
    public IStreetViewPanoramaViewDelegate zzxS()
    {
      return this.zzaJw;
    }
  }
  
  static class zzb
    extends zza<StreetViewPanoramaView.zza>
  {
    private final Context mContext;
    protected zzf<StreetViewPanoramaView.zza> zzaIS;
    private final ViewGroup zzaIZ;
    private final List<OnStreetViewPanoramaReadyCallback> zzaJn = new ArrayList();
    private final StreetViewPanoramaOptions zzaJz;
    
    zzb(ViewGroup paramViewGroup, Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
    {
      this.zzaIZ = paramViewGroup;
      this.mContext = paramContext;
      this.zzaJz = paramStreetViewPanoramaOptions;
    }
    
    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
    {
      if (zzrZ() != null)
      {
        ((StreetViewPanoramaView.zza)zzrZ()).getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
        return;
      }
      this.zzaJn.add(paramOnStreetViewPanoramaReadyCallback);
    }
    
    protected void zza(zzf<StreetViewPanoramaView.zza> paramzzf)
    {
      this.zzaIS = paramzzf;
      zzxL();
    }
    
    public void zzxL()
    {
      if ((this.zzaIS != null) && (zzrZ() == null)) {}
      try
      {
        Object localObject = zzy.zzaG(this.mContext).zza(zze.zzy(this.mContext), this.zzaJz);
        this.zzaIS.zza(new StreetViewPanoramaView.zza(this.zzaIZ, (IStreetViewPanoramaViewDelegate)localObject));
        localObject = this.zzaJn.iterator();
        while (((Iterator)localObject).hasNext())
        {
          OnStreetViewPanoramaReadyCallback localOnStreetViewPanoramaReadyCallback = (OnStreetViewPanoramaReadyCallback)((Iterator)localObject).next();
          ((StreetViewPanoramaView.zza)zzrZ()).getStreetViewPanoramaAsync(localOnStreetViewPanoramaReadyCallback);
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
        this.zzaJn.clear();
        return;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\StreetViewPanoramaView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */