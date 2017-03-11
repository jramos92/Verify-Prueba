package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Future;

@zzgr
public class zzbc
{
  private zzbb zza(final Context paramContext, VersionInfoParcel paramVersionInfoParcel, final zzin<zzbb> paramzzin, zzan paramzzan)
  {
    paramContext = new zzbd(paramContext, paramVersionInfoParcel, paramzzan);
    paramContext.zza(new zzbb.zza()
    {
      public void zzcj()
      {
        paramzzin.zzf(paramContext);
      }
    });
    return paramContext;
  }
  
  public Future<zzbb> zza(final Context paramContext, final VersionInfoParcel paramVersionInfoParcel, final String paramString, final zzan paramzzan)
  {
    final zzin localzzin = new zzin();
    zzid.zzIE.post(new Runnable()
    {
      public void run()
      {
        zzbc.zza(zzbc.this, paramContext, paramVersionInfoParcel, localzzin, paramzzan).zzt(paramString);
      }
    });
    return localzzin;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */