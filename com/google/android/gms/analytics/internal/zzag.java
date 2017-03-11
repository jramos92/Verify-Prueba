package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzx;

class zzag
  extends BroadcastReceiver
{
  static final String zzPu = zzag.class.getName();
  private final zzf zzME;
  private boolean zzPv;
  private boolean zzPw;
  
  zzag(zzf paramzzf)
  {
    zzx.zzw(paramzzf);
    this.zzME = paramzzf;
  }
  
  private Context getContext()
  {
    return this.zzME.getContext();
  }
  
  private zzb zzhP()
  {
    return this.zzME.zzhP();
  }
  
  private zzaf zziu()
  {
    return this.zzME.zziu();
  }
  
  private void zzkI()
  {
    zziu();
    zzhP();
  }
  
  public boolean isConnected()
  {
    if (!this.zzPv) {
      this.zzME.zziu().zzbd("Connectivity unknown. Receiver not registered");
    }
    return this.zzPw;
  }
  
  public boolean isRegistered()
  {
    return this.zzPv;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    zzkI();
    paramContext = paramIntent.getAction();
    this.zzME.zziu().zza("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      boolean bool = zzkK();
      if (this.zzPw != bool)
      {
        this.zzPw = bool;
        zzhP().zzI(bool);
      }
    }
    do
    {
      return;
      if (!"com.google.analytics.RADIO_POWERED".equals(paramContext)) {
        break;
      }
    } while (paramIntent.hasExtra(zzPu));
    zzhP().zzio();
    return;
    this.zzME.zziu().zzd("NetworkBroadcastReceiver received unknown action", paramContext);
  }
  
  public void unregister()
  {
    if (!isRegistered()) {
      return;
    }
    this.zzME.zziu().zzba("Unregistering connectivity change receiver");
    this.zzPv = false;
    this.zzPw = false;
    Context localContext = getContext();
    try
    {
      localContext.unregisterReceiver(this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zziu().zze("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
    }
  }
  
  public void zzkH()
  {
    zzkI();
    if (this.zzPv) {
      return;
    }
    Context localContext = getContext();
    localContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    IntentFilter localIntentFilter = new IntentFilter("com.google.analytics.RADIO_POWERED");
    localIntentFilter.addCategory(localContext.getPackageName());
    localContext.registerReceiver(this, localIntentFilter);
    this.zzPw = zzkK();
    this.zzME.zziu().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzPw));
    this.zzPv = true;
  }
  
  public void zzkJ()
  {
    if (Build.VERSION.SDK_INT <= 10) {
      return;
    }
    Context localContext = getContext();
    Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
    localIntent.addCategory(localContext.getPackageName());
    localIntent.putExtra(zzPu, true);
    localContext.sendOrderedBroadcast(localIntent, null);
  }
  
  protected boolean zzkK()
  {
    Object localObject = (ConnectivityManager)getContext().getSystemService("connectivity");
    try
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        boolean bool = ((NetworkInfo)localObject).isConnected();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (SecurityException localSecurityException) {}
    return false;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */