package com.google.android.gms.ads.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq.zza;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzmi;

@zzgr
public class zzj
  extends zzq.zza
{
  private final Context mContext;
  private zzo zzoT;
  private NativeAdOptionsParcel zzoY;
  private final zzem zzox;
  private final String zzpa;
  private final VersionInfoParcel zzpb;
  private zzcw zzpg;
  private zzcx zzph;
  private zzmi<String, zzcy> zzpi;
  private zzmi<String, zzcz> zzpj;
  
  public zzj(Context paramContext, String paramString, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel)
  {
    this.mContext = paramContext;
    this.zzpa = paramString;
    this.zzox = paramzzem;
    this.zzpb = paramVersionInfoParcel;
    this.zzpj = new zzmi();
    this.zzpi = new zzmi();
  }
  
  public void zza(NativeAdOptionsParcel paramNativeAdOptionsParcel)
  {
    this.zzoY = paramNativeAdOptionsParcel;
  }
  
  public void zza(zzcw paramzzcw)
  {
    this.zzpg = paramzzcw;
  }
  
  public void zza(zzcx paramzzcx)
  {
    this.zzph = paramzzcx;
  }
  
  public void zza(String paramString, zzcz paramzzcz, zzcy paramzzcy)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
    }
    this.zzpj.put(paramString, paramzzcz);
    this.zzpi.put(paramString, paramzzcy);
  }
  
  public void zzb(zzo paramzzo)
  {
    this.zzoT = paramzzo;
  }
  
  public zzp zzbk()
  {
    return new zzi(this.mContext, this.zzpa, this.zzox, this.zzpb, this.zzoT, this.zzpg, this.zzph, this.zzpj, this.zzpi, this.zzoY);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */