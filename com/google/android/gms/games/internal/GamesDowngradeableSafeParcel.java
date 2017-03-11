package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.internal.zzms;

public abstract class GamesDowngradeableSafeParcel
  extends DowngradeableSafeParcel
{
  protected static boolean zzd(Integer paramInteger)
  {
    if (paramInteger == null) {
      return false;
    }
    return zzms.zzcc(paramInteger.intValue());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\GamesDowngradeableSafeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */