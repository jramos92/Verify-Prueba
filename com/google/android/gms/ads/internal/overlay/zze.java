package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzmx;

public class zze
{
  public void zza(Context paramContext, AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    zza(paramContext, paramAdOverlayInfoParcel, true);
  }
  
  public void zza(Context paramContext, AdOverlayInfoParcel paramAdOverlayInfoParcel, boolean paramBoolean)
  {
    if ((paramAdOverlayInfoParcel.zzBJ == 4) && (paramAdOverlayInfoParcel.zzBC == null))
    {
      if (paramAdOverlayInfoParcel.zzBB != null) {
        paramAdOverlayInfoParcel.zzBB.onAdClicked();
      }
      zzp.zzbs().zza(paramContext, paramAdOverlayInfoParcel.zzBA, paramAdOverlayInfoParcel.zzBI);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext, "com.google.android.gms.ads.AdActivity");
    localIntent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", paramAdOverlayInfoParcel.zzqj.zzJx);
    localIntent.putExtra("shouldCallOnOverlayOpened", paramBoolean);
    AdOverlayInfoParcel.zza(localIntent, paramAdOverlayInfoParcel);
    if (!zzmx.isAtLeastL()) {
      localIntent.addFlags(524288);
    }
    if (!(paramContext instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    zzp.zzbv().zzb(paramContext, localIntent);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\overlay\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */