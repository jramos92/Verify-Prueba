package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.zzx;

class zzr
  extends BroadcastReceiver
{
  static final String zzPu = zzr.class.getName();
  private boolean zzPv;
  private boolean zzPw;
  private final zzv zzaKG;
  
  zzr(zzv paramzzv)
  {
    zzx.zzw(paramzzv);
    this.zzaKG = paramzzv;
  }
  
  private Context getContext()
  {
    return this.zzaKG.getContext();
  }
  
  private zzp zzyd()
  {
    return this.zzaKG.zzyd();
  }
  
  public boolean isRegistered()
  {
    this.zzaKG.zzis();
    return this.zzPv;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.zzaKG.zziE();
    paramContext = paramIntent.getAction();
    zzyd().zzzQ().zzj("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      final boolean bool = this.zzaKG.zzAe().zzkK();
      if (this.zzPw != bool)
      {
        this.zzPw = bool;
        this.zzaKG.zzzr().zzh(new Runnable()
        {
          public void run()
          {
            zzr.zza(zzr.this).zzI(bool);
          }
        });
      }
      return;
    }
    zzyd().zzzL().zzj("NetworkBroadcastReceiver received unknown action", paramContext);
  }
  
  public void unregister()
  {
    this.zzaKG.zziE();
    this.zzaKG.zzis();
    if (!isRegistered()) {
      return;
    }
    zzyd().zzzQ().zzec("Unregistering connectivity change receiver");
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
      zzyd().zzzK().zzj("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
    }
  }
  
  public void zzkH()
  {
    this.zzaKG.zziE();
    this.zzaKG.zzis();
    if (this.zzPv) {
      return;
    }
    getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    this.zzPw = this.zzaKG.zzAe().zzkK();
    zzyd().zzzQ().zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzPw));
    this.zzPv = true;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */