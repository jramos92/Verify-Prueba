package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class zza
  extends zzp.zza
{
  private Context mContext;
  private Account zzQd;
  int zzaeG;
  
  public static Account zzb(zzp paramzzp)
  {
    Account localAccount = null;
    long l;
    if (paramzzp != null) {
      l = Binder.clearCallingIdentity();
    }
    try
    {
      localAccount = paramzzp.getAccount();
      return localAccount;
    }
    catch (RemoteException paramzzp)
    {
      Log.w("AccountAccessor", "Remote account accessor probably died");
      return null;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof zza)) {
      return false;
    }
    return this.zzQd.equals(((zza)paramObject).zzQd);
  }
  
  public Account getAccount()
  {
    int i = Binder.getCallingUid();
    if (i == this.zzaeG) {
      return this.zzQd;
    }
    if (GooglePlayServicesUtil.zze(this.mContext, i))
    {
      this.zzaeG = i;
      return this.zzQd;
    }
    throw new SecurityException("Caller is not GooglePlayServices");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */