package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzhz;

@zzgr
public class zza
{
  public zzhz zza(Context paramContext, AdRequestInfoParcel.zza paramzza, zzan paramzzan, zza paramzza1)
  {
    if (paramzza.zzEn.extras.getBundle("sdk_less_server_data") != null) {}
    for (paramContext = new zzm(paramContext, paramzza, paramzza1);; paramContext = new zzb(paramContext, paramzza, paramzzan, paramzza1))
    {
      paramContext.zzgz();
      return paramContext;
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zza(zzhs.zza paramzza);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\request\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */