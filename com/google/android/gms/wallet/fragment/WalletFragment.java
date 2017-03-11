package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R.string;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzrh;
import com.google.android.gms.internal.zzri.zza;
import com.google.android.gms.internal.zzrp;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment
  extends Fragment
{
  private boolean mCreated = false;
  private final Fragment zzapz = this;
  private WalletFragmentOptions zzbdY;
  private WalletFragmentInitParams zzbdZ;
  private MaskedWalletRequest zzbea;
  private MaskedWallet zzbeb;
  private Boolean zzbec;
  private zzb zzbeh;
  private final zzb zzbei = zzb.zza(this);
  private final zzc zzbej = new zzc(null);
  private zza zzbek = new zza(this);
  
  public static WalletFragment newInstance(WalletFragmentOptions paramWalletFragmentOptions)
  {
    WalletFragment localWalletFragment = new WalletFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extraWalletFragmentOptions", paramWalletFragmentOptions);
    localWalletFragment.zzapz.setArguments(localBundle);
    return localWalletFragment;
  }
  
  public int getState()
  {
    if (this.zzbeh != null) {
      return zzb.zza(this.zzbeh);
    }
    return 0;
  }
  
  public void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
  {
    if (this.zzbeh != null)
    {
      zzb.zza(this.zzbeh, paramWalletFragmentInitParams);
      this.zzbdZ = null;
    }
    do
    {
      return;
      if (this.zzbdZ != null) {
        break;
      }
      this.zzbdZ = paramWalletFragmentInitParams;
      if (this.zzbea != null) {
        Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
      }
    } while (this.zzbeb == null);
    Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
    return;
    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.zzbeh != null) {
      zzb.zza(this.zzbeh, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject;
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
      localObject = (WalletFragmentInitParams)paramBundle.getParcelable("walletFragmentInitParams");
      if (localObject != null)
      {
        if (this.zzbdZ != null) {
          Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
        }
        this.zzbdZ = ((WalletFragmentInitParams)localObject);
      }
      if (this.zzbea == null) {
        this.zzbea = ((MaskedWalletRequest)paramBundle.getParcelable("maskedWalletRequest"));
      }
      if (this.zzbeb == null) {
        this.zzbeb = ((MaskedWallet)paramBundle.getParcelable("maskedWallet"));
      }
      if (paramBundle.containsKey("walletFragmentOptions")) {
        this.zzbdY = ((WalletFragmentOptions)paramBundle.getParcelable("walletFragmentOptions"));
      }
      if (paramBundle.containsKey("enabled")) {
        this.zzbec = Boolean.valueOf(paramBundle.getBoolean("enabled"));
      }
    }
    for (;;)
    {
      this.mCreated = true;
      this.zzbej.onCreate(paramBundle);
      return;
      if (this.zzapz.getArguments() != null)
      {
        localObject = (WalletFragmentOptions)this.zzapz.getArguments().getParcelable("extraWalletFragmentOptions");
        if (localObject != null)
        {
          ((WalletFragmentOptions)localObject).zzaT(this.zzapz.getActivity());
          this.zzbdY = ((WalletFragmentOptions)localObject);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.zzbej.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mCreated = false;
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    if (this.zzbdY == null) {
      this.zzbdY = WalletFragmentOptions.zza(paramActivity, paramAttributeSet);
    }
    paramAttributeSet = new Bundle();
    paramAttributeSet.putParcelable("attrKeyWalletFragmentOptions", this.zzbdY);
    this.zzbej.onInflate(paramActivity, paramAttributeSet, paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.zzbej.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.zzbej.onResume();
    FragmentManager localFragmentManager = this.zzapz.getActivity().getFragmentManager();
    Fragment localFragment = localFragmentManager.findFragmentByTag("GooglePlayServicesErrorDialog");
    if (localFragment != null)
    {
      localFragmentManager.beginTransaction().remove(localFragment).commit();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzapz.getActivity()), this.zzapz.getActivity(), -1);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
    this.zzbej.onSaveInstanceState(paramBundle);
    if (this.zzbdZ != null)
    {
      paramBundle.putParcelable("walletFragmentInitParams", this.zzbdZ);
      this.zzbdZ = null;
    }
    if (this.zzbea != null)
    {
      paramBundle.putParcelable("maskedWalletRequest", this.zzbea);
      this.zzbea = null;
    }
    if (this.zzbeb != null)
    {
      paramBundle.putParcelable("maskedWallet", this.zzbeb);
      this.zzbeb = null;
    }
    if (this.zzbdY != null)
    {
      paramBundle.putParcelable("walletFragmentOptions", this.zzbdY);
      this.zzbdY = null;
    }
    if (this.zzbec != null)
    {
      paramBundle.putBoolean("enabled", this.zzbec.booleanValue());
      this.zzbec = null;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.zzbej.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.zzbej.onStop();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.zzbeh != null)
    {
      zzb.zza(this.zzbeh, paramBoolean);
      this.zzbec = null;
      return;
    }
    this.zzbec = Boolean.valueOf(paramBoolean);
  }
  
  public void setOnStateChangedListener(OnStateChangedListener paramOnStateChangedListener)
  {
    this.zzbek.zza(paramOnStateChangedListener);
  }
  
  public void updateMaskedWallet(MaskedWallet paramMaskedWallet)
  {
    if (this.zzbeh != null)
    {
      zzb.zza(this.zzbeh, paramMaskedWallet);
      this.zzbeb = null;
      return;
    }
    this.zzbeb = paramMaskedWallet;
  }
  
  public void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
  {
    if (this.zzbeh != null)
    {
      zzb.zza(this.zzbeh, paramMaskedWalletRequest);
      this.zzbea = null;
      return;
    }
    this.zzbea = paramMaskedWalletRequest;
  }
  
  public static abstract interface OnStateChangedListener
  {
    public abstract void onStateChanged(WalletFragment paramWalletFragment, int paramInt1, int paramInt2, Bundle paramBundle);
  }
  
  static class zza
    extends zzri.zza
  {
    private WalletFragment.OnStateChangedListener zzbel;
    private final WalletFragment zzbem;
    
    zza(WalletFragment paramWalletFragment)
    {
      this.zzbem = paramWalletFragment;
    }
    
    public void zza(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (this.zzbel != null) {
        this.zzbel.onStateChanged(this.zzbem, paramInt1, paramInt2, paramBundle);
      }
    }
    
    public void zza(WalletFragment.OnStateChangedListener paramOnStateChangedListener)
    {
      this.zzbel = paramOnStateChangedListener;
    }
  }
  
  private static class zzb
    implements LifecycleDelegate
  {
    private final zzrh zzbef;
    
    private zzb(zzrh paramzzrh)
    {
      this.zzbef = paramzzrh;
    }
    
    private int getState()
    {
      try
      {
        int i = this.zzbef.getState();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
    {
      try
      {
        this.zzbef.initialize(paramWalletFragmentInitParams);
        return;
      }
      catch (RemoteException paramWalletFragmentInitParams)
      {
        throw new RuntimeException(paramWalletFragmentInitParams);
      }
    }
    
    private void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      try
      {
        this.zzbef.onActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      }
      catch (RemoteException paramIntent)
      {
        throw new RuntimeException(paramIntent);
      }
    }
    
    private void setEnabled(boolean paramBoolean)
    {
      try
      {
        this.zzbef.setEnabled(paramBoolean);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void updateMaskedWallet(MaskedWallet paramMaskedWallet)
    {
      try
      {
        this.zzbef.updateMaskedWallet(paramMaskedWallet);
        return;
      }
      catch (RemoteException paramMaskedWallet)
      {
        throw new RuntimeException(paramMaskedWallet);
      }
    }
    
    private void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
    {
      try
      {
        this.zzbef.updateMaskedWalletRequest(paramMaskedWalletRequest);
        return;
      }
      catch (RemoteException paramMaskedWalletRequest)
      {
        throw new RuntimeException(paramMaskedWalletRequest);
      }
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.zzbef.onCreate(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeException(paramBundle);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      try
      {
        paramLayoutInflater = (View)zze.zzp(this.zzbef.onCreateView(zze.zzy(paramLayoutInflater), zze.zzy(paramViewGroup), paramBundle));
        return paramLayoutInflater;
      }
      catch (RemoteException paramLayoutInflater)
      {
        throw new RuntimeException(paramLayoutInflater);
      }
    }
    
    public void onDestroy() {}
    
    public void onDestroyView() {}
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      paramBundle1 = (WalletFragmentOptions)paramBundle1.getParcelable("extraWalletFragmentOptions");
      try
      {
        this.zzbef.zza(zze.zzy(paramActivity), paramBundle1, paramBundle2);
        return;
      }
      catch (RemoteException paramActivity)
      {
        throw new RuntimeException(paramActivity);
      }
    }
    
    public void onLowMemory() {}
    
    public void onPause()
    {
      try
      {
        this.zzbef.onPause();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onResume()
    {
      try
      {
        this.zzbef.onResume();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onSaveInstanceState(Bundle paramBundle)
    {
      try
      {
        this.zzbef.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeException(paramBundle);
      }
    }
    
    public void onStart()
    {
      try
      {
        this.zzbef.onStart();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onStop()
    {
      try
      {
        this.zzbef.onStop();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
  }
  
  private class zzc
    extends zza<WalletFragment.zzb>
    implements View.OnClickListener
  {
    private zzc() {}
    
    public void onClick(View paramView)
    {
      paramView = WalletFragment.zza(WalletFragment.this).getActivity();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramView), paramView, -1);
    }
    
    protected void zza(FrameLayout paramFrameLayout)
    {
      Button localButton = new Button(WalletFragment.zza(WalletFragment.this).getActivity());
      localButton.setText(R.string.wallet_buy_button_place_holder);
      int k = -1;
      int m = -2;
      int j = m;
      int i = k;
      if (WalletFragment.zze(WalletFragment.this) != null)
      {
        WalletFragmentStyle localWalletFragmentStyle = WalletFragment.zze(WalletFragment.this).getFragmentStyle();
        j = m;
        i = k;
        if (localWalletFragmentStyle != null)
        {
          DisplayMetrics localDisplayMetrics = WalletFragment.zza(WalletFragment.this).getResources().getDisplayMetrics();
          i = localWalletFragmentStyle.zza("buyButtonWidth", localDisplayMetrics, -1);
          j = localWalletFragmentStyle.zza("buyButtonHeight", localDisplayMetrics, -2);
        }
      }
      localButton.setLayoutParams(new ViewGroup.LayoutParams(i, j));
      localButton.setOnClickListener(this);
      paramFrameLayout.addView(localButton);
    }
    
    protected void zza(zzf<WalletFragment.zzb> paramzzf)
    {
      Object localObject = WalletFragment.zza(WalletFragment.this).getActivity();
      if ((WalletFragment.zzb(WalletFragment.this) == null) && (WalletFragment.zzc(WalletFragment.this)) && (localObject != null)) {}
      try
      {
        localObject = zzrp.zza((Activity)localObject, WalletFragment.zzd(WalletFragment.this), WalletFragment.zze(WalletFragment.this), WalletFragment.zzf(WalletFragment.this));
        WalletFragment.zza(WalletFragment.this, new WalletFragment.zzb((zzrh)localObject, null));
        WalletFragment.zza(WalletFragment.this, null);
        paramzzf.zza(WalletFragment.zzb(WalletFragment.this));
        if (WalletFragment.zzg(WalletFragment.this) != null)
        {
          WalletFragment.zzb.zza(WalletFragment.zzb(WalletFragment.this), WalletFragment.zzg(WalletFragment.this));
          WalletFragment.zza(WalletFragment.this, null);
        }
        if (WalletFragment.zzh(WalletFragment.this) != null)
        {
          WalletFragment.zzb.zza(WalletFragment.zzb(WalletFragment.this), WalletFragment.zzh(WalletFragment.this));
          WalletFragment.zza(WalletFragment.this, null);
        }
        if (WalletFragment.zzi(WalletFragment.this) != null)
        {
          WalletFragment.zzb.zza(WalletFragment.zzb(WalletFragment.this), WalletFragment.zzi(WalletFragment.this));
          WalletFragment.zza(WalletFragment.this, null);
        }
        if (WalletFragment.zzj(WalletFragment.this) != null)
        {
          WalletFragment.zzb.zza(WalletFragment.zzb(WalletFragment.this), WalletFragment.zzj(WalletFragment.this).booleanValue());
          WalletFragment.zza(WalletFragment.this, null);
        }
        return;
      }
      catch (GooglePlayServicesNotAvailableException paramzzf) {}
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\fragment\WalletFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */