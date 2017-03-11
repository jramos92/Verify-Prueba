package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzr;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqy;

public class CampaignTrackingReceiver
  extends BroadcastReceiver
{
  static zzqy zzLh;
  static Boolean zzLi;
  static Object zzpy = new Object();
  
  public static boolean zzV(Context paramContext)
  {
    zzx.zzw(paramContext);
    if (zzLi != null) {
      return zzLi.booleanValue();
    }
    boolean bool = zzam.zza(paramContext, CampaignTrackingReceiver.class, true);
    zzLi = Boolean.valueOf(bool);
    return bool;
  }
  
  public void onReceive(Context paramContext, Intent arg2)
  {
    Object localObject = zzf.zzX(paramContext);
    localzzaf = ((zzf)localObject).zziu();
    String str = ???.getStringExtra("referrer");
    ??? = ???.getAction();
    localzzaf.zza("CampaignTrackingReceiver received", ???);
    if ((!"com.android.vending.INSTALL_REFERRER".equals(???)) || (TextUtils.isEmpty(str)))
    {
      localzzaf.zzbd("CampaignTrackingReceiver received unexpected intent without referrer extra");
      return;
    }
    boolean bool = CampaignTrackingService.zzW(paramContext);
    if (!bool) {
      localzzaf.zzbd("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
    }
    zzaS(str);
    if (((zzf)localObject).zziv().zzjA())
    {
      localzzaf.zzbe("Received unexpected installation campaign on package side");
      return;
    }
    ??? = zzhJ();
    zzx.zzw(???);
    localObject = new Intent(paramContext, ???);
    ((Intent)localObject).putExtra("referrer", str);
    synchronized (zzpy)
    {
      paramContext.startService((Intent)localObject);
      if (!bool) {
        return;
      }
    }
    try
    {
      if (zzLh == null)
      {
        zzLh = new zzqy(paramContext, 1, "Analytics campaign WakeLock");
        zzLh.setReferenceCounted(false);
      }
      zzLh.acquire(1000L);
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        localzzaf.zzbd("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
      }
    }
  }
  
  protected void zzaS(String paramString) {}
  
  protected Class<? extends CampaignTrackingService> zzhJ()
  {
    return CampaignTrackingService.class;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\CampaignTrackingReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */