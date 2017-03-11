package com.google.android.gms.ads.internal;

import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziz;

@zzgr
public class zze
{
  private zza zzoI;
  private boolean zzoJ;
  private boolean zzoK;
  
  public zze()
  {
    this.zzoK = ((Boolean)zzby.zzus.get()).booleanValue();
  }
  
  public zze(boolean paramBoolean)
  {
    this.zzoK = paramBoolean;
  }
  
  public void recordClick()
  {
    this.zzoJ = true;
  }
  
  public void zza(zza paramzza)
  {
    this.zzoI = paramzza;
  }
  
  public boolean zzbe()
  {
    return (!this.zzoK) || (this.zzoJ);
  }
  
  public void zzp(String paramString)
  {
    zzb.zzaF("Action was blocked because no click was detected.");
    if (this.zzoI != null) {
      this.zzoI.zzq(paramString);
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zzq(String paramString);
  }
  
  @zzgr
  public static class zzb
    implements zze.zza
  {
    private final zzhs.zza zzoL;
    private final zziz zzoM;
    
    public zzb(zzhs.zza paramzza, zziz paramzziz)
    {
      this.zzoL = paramzza;
      this.zzoM = paramzziz;
    }
    
    public void zzq(String paramString)
    {
      zzb.zzaF("An auto-clicking creative is blocked");
      Uri.Builder localBuilder = new Uri.Builder();
      localBuilder.scheme("https");
      localBuilder.path("//pagead2.googlesyndication.com/pagead/gen_204");
      localBuilder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
      if (!TextUtils.isEmpty(paramString)) {
        localBuilder.appendQueryParameter("navigationURL", paramString);
      }
      if ((this.zzoL != null) && (this.zzoL.zzHD != null) && (!TextUtils.isEmpty(this.zzoL.zzHD.zzEP))) {
        localBuilder.appendQueryParameter("debugDialog", this.zzoL.zzHD.zzEP);
      }
      zzp.zzbv().zzc(this.zzoM.getContext(), this.zzoM.zzhh().zzJu, localBuilder.toString());
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */