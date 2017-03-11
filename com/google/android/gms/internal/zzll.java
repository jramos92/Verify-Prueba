package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.GoogleApiAvailability;

abstract class zzll
  extends BroadcastReceiver
{
  protected Context mContext;
  
  public static <T extends zzll> T zza(Context paramContext, T paramT)
  {
    return zza(paramContext, paramT, GoogleApiAvailability.getInstance());
  }
  
  public static <T extends zzll> T zza(Context paramContext, T paramT, GoogleApiAvailability paramGoogleApiAvailability)
  {
    Object localObject = new IntentFilter("android.intent.action.PACKAGE_ADDED");
    ((IntentFilter)localObject).addDataScheme("package");
    paramContext.registerReceiver(paramT, (IntentFilter)localObject);
    paramT.mContext = paramContext;
    localObject = paramT;
    if (!paramGoogleApiAvailability.zzj(paramContext, "com.google.android.gms"))
    {
      paramT.zzoi();
      paramT.unregister();
      localObject = null;
    }
    return (T)localObject;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getData();
    paramContext = null;
    if (paramIntent != null) {
      paramContext = paramIntent.getSchemeSpecificPart();
    }
    if ("com.google.android.gms".equals(paramContext))
    {
      zzoi();
      unregister();
    }
  }
  
  public void unregister()
  {
    try
    {
      if (this.mContext != null) {
        this.mContext.unregisterReceiver(this);
      }
      this.mContext = null;
      return;
    }
    finally {}
  }
  
  protected abstract void zzoi();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzll.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */