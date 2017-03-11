package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class zzrp
  extends zzg<zzrk>
{
  private static zzrp zzbeB;
  
  protected zzrp()
  {
    super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
  }
  
  private static zzrp zzEH()
  {
    if (zzbeB == null) {
      zzbeB = new zzrp();
    }
    return zzbeB;
  }
  
  public static zzrh zza(Activity paramActivity, zzc paramzzc, WalletFragmentOptions paramWalletFragmentOptions, zzri paramzzri)
    throws GooglePlayServicesNotAvailableException
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramActivity);
    if (i != 0) {
      throw new GooglePlayServicesNotAvailableException(i);
    }
    try
    {
      paramActivity = ((zzrk)zzEH().zzas(paramActivity)).zza(zze.zzy(paramActivity), paramzzc, paramWalletFragmentOptions, paramzzri);
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      throw new RuntimeException(paramActivity);
    }
    catch (zzg.zza paramActivity)
    {
      throw new RuntimeException(paramActivity);
    }
  }
  
  protected zzrk zzec(IBinder paramIBinder)
  {
    return zzrk.zza.zzdY(paramIBinder);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzrp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */