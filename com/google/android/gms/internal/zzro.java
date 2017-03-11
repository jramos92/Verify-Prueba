package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenResponse;
import com.google.android.gms.wallet.firstparty.GetInstrumentsResponse;
import java.lang.ref.WeakReference;

public class zzro
  extends zzj<zzrj>
{
  private final Context mContext;
  private final int mTheme;
  private final String zzRs;
  private final int zzbdL;
  
  public zzro(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, int paramInt1, int paramInt2)
  {
    super(paramContext, paramLooper, 4, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.mContext = paramContext;
    this.zzbdL = paramInt1;
    this.zzRs = paramzzf.getAccountName();
    this.mTheme = paramInt2;
  }
  
  private Bundle zzEG()
  {
    return zza(this.zzbdL, this.mContext.getPackageName(), this.zzRs, this.mTheme);
  }
  
  public static Bundle zza(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", paramInt1);
    localBundle.putString("androidPackageName", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(paramString2, "com.google"));
    }
    localBundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", paramInt2);
    return localBundle;
  }
  
  public void zza(FullWalletRequest paramFullWalletRequest, int paramInt)
  {
    zzb localzzb = new zzb(this.mContext, paramInt);
    Bundle localBundle = zzEG();
    try
    {
      ((zzrj)zzpc()).zza(paramFullWalletRequest, localBundle, localzzb);
      return;
    }
    catch (RemoteException paramFullWalletRequest)
    {
      Log.e("WalletClientImpl", "RemoteException getting full wallet", paramFullWalletRequest);
      localzzb.zza(8, null, Bundle.EMPTY);
    }
  }
  
  public void zza(MaskedWalletRequest paramMaskedWalletRequest, int paramInt)
  {
    Bundle localBundle = zzEG();
    zzb localzzb = new zzb(this.mContext, paramInt);
    try
    {
      ((zzrj)zzpc()).zza(paramMaskedWalletRequest, localBundle, localzzb);
      return;
    }
    catch (RemoteException paramMaskedWalletRequest)
    {
      Log.e("WalletClientImpl", "RemoteException getting masked wallet", paramMaskedWalletRequest);
      localzzb.zza(8, null, Bundle.EMPTY);
    }
  }
  
  public void zza(NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    Bundle localBundle = zzEG();
    try
    {
      ((zzrj)zzpc()).zza(paramNotifyTransactionStatusRequest, localBundle);
      return;
    }
    catch (RemoteException paramNotifyTransactionStatusRequest) {}
  }
  
  public void zze(String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = zzEG();
    zzb localzzb = new zzb(this.mContext, paramInt);
    try
    {
      ((zzrj)zzpc()).zza(paramString1, paramString2, localBundle, localzzb);
      return;
    }
    catch (RemoteException paramString1)
    {
      Log.e("WalletClientImpl", "RemoteException changing masked wallet", paramString1);
      localzzb.zza(8, null, Bundle.EMPTY);
    }
  }
  
  protected zzrj zzeb(IBinder paramIBinder)
  {
    return zzrj.zza.zzdX(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.wallet.service.BIND";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.wallet.internal.IOwService";
  }
  
  public void zzkA(int paramInt)
  {
    Bundle localBundle = zzEG();
    zzb localzzb = new zzb(this.mContext, paramInt);
    try
    {
      ((zzrj)zzpc()).zzb(localBundle, localzzb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("WalletClientImpl", "RemoteException during isNewUser", localRemoteException);
      localzzb.zzb(8, false, Bundle.EMPTY);
    }
  }
  
  public void zzkz(int paramInt)
  {
    Bundle localBundle = zzEG();
    zzb localzzb = new zzb(this.mContext, paramInt);
    try
    {
      ((zzrj)zzpc()).zza(localBundle, localzzb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", localRemoteException);
      localzzb.zza(8, false, Bundle.EMPTY);
    }
  }
  
  public boolean zzpe()
  {
    return true;
  }
  
  private static class zza
    extends zzrm.zza
  {
    public void zza(int paramInt, FullWallet paramFullWallet, Bundle paramBundle) {}
    
    public void zza(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle) {}
    
    public void zza(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
    
    public void zza(Status paramStatus, Bundle paramBundle) {}
    
    public void zza(Status paramStatus, GetBuyFlowInitializationTokenResponse paramGetBuyFlowInitializationTokenResponse, Bundle paramBundle) {}
    
    public void zza(Status paramStatus, GetInstrumentsResponse paramGetInstrumentsResponse, Bundle paramBundle) {}
    
    public void zzb(int paramInt, boolean paramBoolean, Bundle paramBundle) {}
    
    public void zzj(int paramInt, Bundle paramBundle) {}
  }
  
  static final class zzb
    extends zzro.zza
  {
    private final int zzaaY;
    private final WeakReference<Activity> zzbeA;
    
    public zzb(Context paramContext, int paramInt)
    {
      super();
      this.zzbeA = new WeakReference((Activity)paramContext);
      this.zzaaY = paramInt;
    }
    
    public void zza(int paramInt, FullWallet paramFullWallet, Bundle paramBundle)
    {
      Activity localActivity = (Activity)this.zzbeA.get();
      if (localActivity == null)
      {
        Log.d("WalletClientImpl", "Ignoring onFullWalletLoaded, Activity has gone");
        return;
      }
      Object localObject = null;
      if (paramBundle != null) {
        localObject = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
      }
      paramBundle = new ConnectionResult(paramInt, (PendingIntent)localObject);
      if (paramBundle.hasResolution()) {
        try
        {
          paramBundle.startResolutionForResult(localActivity, this.zzaaY);
          return;
        }
        catch (IntentSender.SendIntentException paramFullWallet)
        {
          Log.w("WalletClientImpl", "Exception starting pending intent", paramFullWallet);
          return;
        }
      }
      localObject = new Intent();
      int i;
      if (paramBundle.isSuccess())
      {
        i = -1;
        ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_FULL_WALLET", paramFullWallet);
        paramFullWallet = localActivity.createPendingResult(this.zzaaY, (Intent)localObject, 1073741824);
        if (paramFullWallet == null) {
          Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
        }
      }
      else
      {
        if (paramInt == 408) {}
        for (i = 0;; i = 1)
        {
          ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", paramInt);
          break;
        }
      }
      try
      {
        paramFullWallet.send(i);
        return;
      }
      catch (PendingIntent.CanceledException paramFullWallet)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", paramFullWallet);
      }
    }
    
    public void zza(int paramInt, MaskedWallet paramMaskedWallet, Bundle paramBundle)
    {
      Activity localActivity = (Activity)this.zzbeA.get();
      if (localActivity == null)
      {
        Log.d("WalletClientImpl", "Ignoring onMaskedWalletLoaded, Activity has gone");
        return;
      }
      Object localObject = null;
      if (paramBundle != null) {
        localObject = (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
      }
      paramBundle = new ConnectionResult(paramInt, (PendingIntent)localObject);
      if (paramBundle.hasResolution()) {
        try
        {
          paramBundle.startResolutionForResult(localActivity, this.zzaaY);
          return;
        }
        catch (IntentSender.SendIntentException paramMaskedWallet)
        {
          Log.w("WalletClientImpl", "Exception starting pending intent", paramMaskedWallet);
          return;
        }
      }
      localObject = new Intent();
      int i;
      if (paramBundle.isSuccess())
      {
        i = -1;
        ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_MASKED_WALLET", paramMaskedWallet);
        paramMaskedWallet = localActivity.createPendingResult(this.zzaaY, (Intent)localObject, 1073741824);
        if (paramMaskedWallet == null) {
          Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
        }
      }
      else
      {
        if (paramInt == 408) {}
        for (i = 0;; i = 1)
        {
          ((Intent)localObject).putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", paramInt);
          break;
        }
      }
      try
      {
        paramMaskedWallet.send(i);
        return;
      }
      catch (PendingIntent.CanceledException paramMaskedWallet)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", paramMaskedWallet);
      }
    }
    
    public void zza(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      paramBundle = (Activity)this.zzbeA.get();
      if (paramBundle == null)
      {
        Log.d("WalletClientImpl", "Ignoring onPreAuthorizationDetermined, Activity has gone");
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("com.google.android.gm.wallet.EXTRA_IS_USER_PREAUTHORIZED", paramBoolean);
      paramBundle = paramBundle.createPendingResult(this.zzaaY, localIntent, 1073741824);
      if (paramBundle == null)
      {
        Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
        return;
      }
      try
      {
        paramBundle.send(-1);
        return;
      }
      catch (PendingIntent.CanceledException paramBundle)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", paramBundle);
      }
    }
    
    public void zzb(int paramInt, boolean paramBoolean, Bundle paramBundle)
    {
      paramBundle = (Activity)this.zzbeA.get();
      if (paramBundle == null)
      {
        Log.d("WalletClientImpl", "Ignoring onIsNewUserDetermined, Activity has gone");
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("com.google.android.gms.wallet.EXTRA_IS_NEW_USER", paramBoolean);
      paramBundle = paramBundle.createPendingResult(this.zzaaY, localIntent, 1073741824);
      if (paramBundle == null)
      {
        Log.w("WalletClientImpl", "Null pending result returned for onIsNewUserDetermined");
        return;
      }
      try
      {
        paramBundle.send(-1);
        return;
      }
      catch (PendingIntent.CanceledException paramBundle)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", paramBundle);
      }
    }
    
    public void zzj(int paramInt, Bundle paramBundle)
    {
      zzx.zzb(paramBundle, "Bundle should not be null");
      Activity localActivity = (Activity)this.zzbeA.get();
      if (localActivity == null)
      {
        Log.d("WalletClientImpl", "Ignoring onWalletObjectsCreated, Activity has gone");
        return;
      }
      paramBundle = new ConnectionResult(paramInt, (PendingIntent)paramBundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
      if (paramBundle.hasResolution()) {
        try
        {
          paramBundle.startResolutionForResult(localActivity, this.zzaaY);
          return;
        }
        catch (IntentSender.SendIntentException paramBundle)
        {
          Log.w("WalletClientImpl", "Exception starting pending intent", paramBundle);
          return;
        }
      }
      Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + paramBundle);
      paramBundle = new Intent();
      paramBundle.putExtra("com.google.android.gms.wallet.EXTRA_ERROR_CODE", 413);
      paramBundle = localActivity.createPendingResult(this.zzaaY, paramBundle, 1073741824);
      if (paramBundle == null)
      {
        Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
        return;
      }
      try
      {
        paramBundle.send(1);
        return;
      }
      catch (PendingIntent.CanceledException paramBundle)
      {
        Log.w("WalletClientImpl", "Exception setting pending result", paramBundle);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */