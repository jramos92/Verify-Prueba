package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzcc;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzig;
import com.google.android.gms.internal.zzig.zza;
import com.google.android.gms.internal.zzig.zzb;
import com.google.android.gms.internal.zzmn;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class zzp
{
  private final Context mContext;
  private final String zzBY;
  private final VersionInfoParcel zzBZ;
  private final zzce zzCa;
  private final zzcg zzCb;
  private final zzig zzCc = new zzig.zzb().zza("min_1", Double.MIN_VALUE, 1.0D).zza("1_5", 1.0D, 5.0D).zza("5_10", 5.0D, 10.0D).zza("10_20", 10.0D, 20.0D).zza("20_30", 20.0D, 30.0D).zza("30_max", 30.0D, Double.MAX_VALUE).zzgK();
  private final long[] zzCd;
  private final String[] zzCe;
  private zzce zzCf;
  private zzce zzCg;
  private zzce zzCh;
  private zzce zzCi;
  private boolean zzCj;
  private zzi zzCk;
  private boolean zzCl;
  private boolean zzCm;
  private long zzCn = -1L;
  
  public zzp(Context paramContext, VersionInfoParcel paramVersionInfoParcel, String paramString, zzcg paramzzcg, zzce paramzzce)
  {
    this.mContext = paramContext;
    this.zzBZ = paramVersionInfoParcel;
    this.zzBY = paramString;
    this.zzCb = paramzzcg;
    this.zzCa = paramzzce;
    paramContext = (String)zzby.zzuF.get();
    if (paramContext == null)
    {
      this.zzCe = new String[0];
      this.zzCd = new long[0];
      return;
    }
    paramContext = TextUtils.split(paramContext, ",");
    this.zzCe = new String[paramContext.length];
    this.zzCd = new long[paramContext.length];
    int i = 0;
    while (i < paramContext.length) {
      try
      {
        this.zzCd[i] = Long.parseLong(paramContext[i]);
        i += 1;
      }
      catch (NumberFormatException paramVersionInfoParcel)
      {
        for (;;)
        {
          zzb.zzd("Unable to parse frame hash target time number.", paramVersionInfoParcel);
          this.zzCd[i] = -1L;
        }
      }
    }
  }
  
  private void zzc(zzi paramzzi)
  {
    long l1 = ((Long)zzby.zzuG.get()).longValue();
    long l2 = paramzzi.getCurrentPosition();
    int i = 0;
    if (i < this.zzCe.length)
    {
      if (this.zzCe[i] != null) {}
      while (l1 <= Math.abs(l2 - this.zzCd[i]))
      {
        i += 1;
        break;
      }
      this.zzCe[i] = zza(paramzzi);
    }
  }
  
  private void zzfd()
  {
    if ((this.zzCh != null) && (this.zzCi == null))
    {
      zzcc.zza(this.zzCb, this.zzCh, new String[] { "vff" });
      zzcc.zza(this.zzCb, this.zzCa, new String[] { "vtt" });
      this.zzCi = zzcc.zzb(this.zzCb);
    }
    long l = com.google.android.gms.ads.internal.zzp.zzbz().nanoTime();
    if ((this.zzCj) && (this.zzCm) && (this.zzCn != -1L))
    {
      double d = TimeUnit.SECONDS.toNanos(1L) / (l - this.zzCn);
      this.zzCc.zza(d);
    }
    this.zzCm = this.zzCj;
    this.zzCn = l;
  }
  
  public void onStop()
  {
    if ((((Boolean)zzby.zzuE.get()).booleanValue()) && (!this.zzCl))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("type", "native-player-metrics");
      localBundle.putString("request", this.zzBY);
      localBundle.putString("player", this.zzCk.zzer());
      Object localObject = this.zzCc.getBuckets().iterator();
      while (((Iterator)localObject).hasNext())
      {
        zzig.zza localzza = (zzig.zza)((Iterator)localObject).next();
        localBundle.putString("fps_c_" + localzza.name, Integer.toString(localzza.count));
        localBundle.putString("fps_p_" + localzza.name, Double.toString(localzza.zzIV));
      }
      int i = 0;
      if (i < this.zzCd.length)
      {
        localObject = this.zzCe[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localBundle.putString("fh_" + Long.valueOf(this.zzCd[i]), (String)localObject);
        }
      }
      com.google.android.gms.ads.internal.zzp.zzbv().zza(this.mContext, this.zzBZ.zzJu, "gmob-apps", localBundle, true);
      this.zzCl = true;
    }
  }
  
  String zza(TextureView paramTextureView)
  {
    paramTextureView = paramTextureView.getBitmap(8, 8);
    long l2 = 0L;
    long l1 = 63L;
    int i = 0;
    while (i < 8)
    {
      long l3 = l1;
      int j = 0;
      l1 = l2;
      l2 = l3;
      if (j < 8)
      {
        int k = paramTextureView.getPixel(j, i);
        int m = Color.blue(k);
        int n = Color.red(k);
        if (Color.green(k) + (m + n) > 128) {}
        for (l3 = 1L;; l3 = 0L)
        {
          l1 |= l3 << (int)l2;
          l2 -= 1L;
          j += 1;
          break;
        }
      }
      i += 1;
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
    return String.format("%016X", new Object[] { Long.valueOf(l2) });
  }
  
  public void zza(zzi paramzzi)
  {
    zzcc.zza(this.zzCb, this.zzCa, new String[] { "vpc" });
    this.zzCf = zzcc.zzb(this.zzCb);
    this.zzCk = paramzzi;
  }
  
  public void zzb(zzi paramzzi)
  {
    zzfd();
    zzc(paramzzi);
  }
  
  public void zzeR()
  {
    if ((this.zzCf == null) || (this.zzCg != null)) {
      return;
    }
    zzcc.zza(this.zzCb, this.zzCf, new String[] { "vfr" });
    this.zzCg = zzcc.zzb(this.zzCb);
  }
  
  public void zzfe()
  {
    this.zzCj = true;
    if ((this.zzCg != null) && (this.zzCh == null))
    {
      zzcc.zza(this.zzCb, this.zzCg, new String[] { "vfp" });
      this.zzCh = zzcc.zzb(this.zzCb);
    }
  }
  
  public void zzff()
  {
    this.zzCj = false;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\overlay\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */