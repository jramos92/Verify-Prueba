package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicBoolean;

@zzgr
public abstract class zzgc
  implements zzgh<Void>, zzja.zza
{
  protected final Context mContext;
  protected final zzgg.zza zzDd;
  protected final zzhs.zza zzDe;
  protected AdResponseParcel zzDf;
  private Runnable zzDg;
  protected final Object zzDh = new Object();
  private AtomicBoolean zzDi = new AtomicBoolean(true);
  protected final zziz zzoM;
  
  protected zzgc(Context paramContext, zzhs.zza paramzza, zziz paramzziz, zzgg.zza paramzza1)
  {
    this.mContext = paramContext;
    this.zzDe = paramzza;
    this.zzDf = this.zzDe.zzHD;
    this.zzoM = paramzziz;
    this.zzDd = paramzza1;
  }
  
  private zzhs zzA(int paramInt)
  {
    AdRequestInfoParcel localAdRequestInfoParcel = this.zzDe.zzHC;
    return new zzhs(localAdRequestInfoParcel.zzEn, this.zzoM, this.zzDf.zzyY, paramInt, this.zzDf.zzyZ, this.zzDf.zzEM, this.zzDf.orientation, this.zzDf.zzzc, localAdRequestInfoParcel.zzEq, this.zzDf.zzEK, null, null, null, null, null, this.zzDf.zzEL, this.zzDe.zzqn, this.zzDf.zzEJ, this.zzDe.zzHz, this.zzDf.zzEO, this.zzDf.zzEP, this.zzDe.zzHw, null);
  }
  
  public void cancel()
  {
    if (!this.zzDi.getAndSet(false)) {
      return;
    }
    this.zzoM.stopLoading();
    zzp.zzbx().zza(this.zzoM.getWebView());
    zzz(-1);
    zzid.zzIE.removeCallbacks(this.zzDg);
  }
  
  public void zza(zziz paramzziz, boolean paramBoolean)
  {
    zzb.zzaF("WebView finished loading.");
    if (!this.zzDi.getAndSet(false)) {
      return;
    }
    if (paramBoolean) {}
    for (int i = zzft();; i = -1)
    {
      zzz(i);
      zzid.zzIE.removeCallbacks(this.zzDg);
      return;
    }
  }
  
  public final Void zzfr()
  {
    zzx.zzci("Webview render task needs to be called on UI thread.");
    this.zzDg = new Runnable()
    {
      public void run()
      {
        if (!zzgc.zza(zzgc.this).get()) {
          return;
        }
        zzb.e("Timed out waiting for WebView to finish loading.");
        zzgc.this.cancel();
      }
    };
    zzid.zzIE.postDelayed(this.zzDg, ((Long)zzby.zzvw.get()).longValue());
    zzfs();
    return null;
  }
  
  protected abstract void zzfs();
  
  protected int zzft()
  {
    return -2;
  }
  
  protected void zzz(int paramInt)
  {
    if (paramInt != -2) {
      this.zzDf = new AdResponseParcel(paramInt, this.zzDf.zzzc);
    }
    this.zzDd.zzb(zzA(paramInt));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzgc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */