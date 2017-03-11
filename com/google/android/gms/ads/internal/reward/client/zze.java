package com.google.android.gms.ads.internal.reward.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardItem;

public class zze
  implements RewardItem
{
  private final zza zzHc;
  
  public zze(zza paramzza)
  {
    this.zzHc = paramzza;
  }
  
  public int getAmount()
  {
    if (this.zzHc == null) {
      return 0;
    }
    try
    {
      int i = this.zzHc.getAmount();
      return i;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward getAmount to RewardItem", localRemoteException);
    }
    return 0;
  }
  
  public String getType()
  {
    if (this.zzHc == null) {
      return null;
    }
    try
    {
      String str = this.zzHc.getType();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not forward getType to RewardItem", localRemoteException);
    }
    return null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\reward\client\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */