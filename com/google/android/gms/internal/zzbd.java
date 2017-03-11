package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

@zzgr
public class zzbd
  implements zzbb
{
  private final zziz zzoM;
  
  public zzbd(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzan paramzzan)
  {
    this.zzoM = zzp.zzbw().zza(paramContext, new AdSizeParcel(), false, false, paramzzan, paramVersionInfoParcel);
    this.zzoM.getWebView().setWillNotDraw(true);
  }
  
  private void runOnUiThread(Runnable paramRunnable)
  {
    if (zzl.zzcF().zzgT())
    {
      paramRunnable.run();
      return;
    }
    zzid.zzIE.post(paramRunnable);
  }
  
  public void destroy()
  {
    this.zzoM.destroy();
  }
  
  public void zza(com.google.android.gms.ads.internal.client.zza paramzza, zzg paramzzg, zzdg paramzzdg, zzn paramzzn, boolean paramBoolean, zzdm paramzzdm, zzdo paramzzdo, zze paramzze, zzfi paramzzfi)
  {
    this.zzoM.zzhe().zzb(paramzza, paramzzg, paramzzdg, paramzzn, paramBoolean, paramzzdm, paramzzdo, new zze(false), paramzzfi);
  }
  
  public void zza(final zzbb.zza paramzza)
  {
    this.zzoM.zzhe().zza(new zzja.zza()
    {
      public void zza(zziz paramAnonymouszziz, boolean paramAnonymousBoolean)
      {
        paramzza.zzcj();
      }
    });
  }
  
  public void zza(String paramString, zzdk paramzzdk)
  {
    this.zzoM.zzhe().zza(paramString, paramzzdk);
  }
  
  public void zza(final String paramString1, final String paramString2)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzbd.zza(zzbd.this).zza(paramString1, paramString2);
      }
    });
  }
  
  public void zza(final String paramString, final JSONObject paramJSONObject)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzbd.zza(zzbd.this).zza(paramString, paramJSONObject);
      }
    });
  }
  
  public void zzb(String paramString, zzdk paramzzdk)
  {
    this.zzoM.zzhe().zzb(paramString, paramzzdk);
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    this.zzoM.zzb(paramString, paramJSONObject);
  }
  
  public zzbf zzci()
  {
    return new zzbg(this);
  }
  
  public void zzs(String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzbd.zza(zzbd.this).loadData(this.zzrJ, "text/html", "UTF-8");
      }
    });
  }
  
  public void zzt(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzbd.zza(zzbd.this).loadUrl(paramString);
      }
    });
  }
  
  public void zzu(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzbd.zza(zzbd.this).loadData(paramString, "text/html", "UTF-8");
      }
    });
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzbd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */