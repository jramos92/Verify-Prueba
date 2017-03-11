package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.zzb;

public class zzrn
  implements Payments
{
  public void changeMaskedWallet(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final int paramInt)
  {
    paramGoogleApiClient.zza(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzro paramAnonymouszzro)
      {
        paramAnonymouszzro.zze(paramString1, paramString2, paramInt);
        zzb(Status.zzabb);
      }
    });
  }
  
  public void checkForPreAuthorization(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.zza(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzro paramAnonymouszzro)
      {
        paramAnonymouszzro.zzkz(paramInt);
        zzb(Status.zzabb);
      }
    });
  }
  
  public void isNewUser(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.zza(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzro paramAnonymouszzro)
      {
        paramAnonymouszzro.zzkA(paramInt);
        zzb(Status.zzabb);
      }
    });
  }
  
  public void loadFullWallet(GoogleApiClient paramGoogleApiClient, final FullWalletRequest paramFullWalletRequest, final int paramInt)
  {
    paramGoogleApiClient.zza(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzro paramAnonymouszzro)
      {
        paramAnonymouszzro.zza(paramFullWalletRequest, paramInt);
        zzb(Status.zzabb);
      }
    });
  }
  
  public void loadMaskedWallet(GoogleApiClient paramGoogleApiClient, final MaskedWalletRequest paramMaskedWalletRequest, final int paramInt)
  {
    paramGoogleApiClient.zza(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzro paramAnonymouszzro)
      {
        paramAnonymouszzro.zza(paramMaskedWalletRequest, paramInt);
        zzb(Status.zzabb);
      }
    });
  }
  
  public void notifyTransactionStatus(GoogleApiClient paramGoogleApiClient, final NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    paramGoogleApiClient.zza(new Wallet.zzb(paramGoogleApiClient)
    {
      protected void zza(zzro paramAnonymouszzro)
      {
        paramAnonymouszzro.zza(paramNotifyTransactionStatusRequest);
        zzb(Status.zzabb);
      }
    });
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzrn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */