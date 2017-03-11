package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzk;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzu;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.measurement.zzc;
import com.google.android.gms.measurement.zzi;
import java.util.List;
import java.util.ListIterator;

public class zza
  extends com.google.android.gms.measurement.zzf<zza>
{
  private final com.google.android.gms.analytics.internal.zzf zzLf;
  private boolean zzLg;
  
  public zza(com.google.android.gms.analytics.internal.zzf paramzzf)
  {
    super(paramzzf.zziw(), paramzzf.zzit());
    this.zzLf = paramzzf;
  }
  
  public void enableAdvertisingIdCollection(boolean paramBoolean)
  {
    this.zzLg = paramBoolean;
  }
  
  protected void zza(zzc paramzzc)
  {
    paramzzc = (zzjo)paramzzc.zze(zzjo.class);
    if (TextUtils.isEmpty(paramzzc.getClientId())) {
      paramzzc.setClientId(this.zzLf.zziL().zzjt());
    }
    if ((this.zzLg) && (TextUtils.isEmpty(paramzzc.zzib())))
    {
      com.google.android.gms.analytics.internal.zza localzza = this.zzLf.zziK();
      paramzzc.zzaV(localzza.zzig());
      paramzzc.zzG(localzza.zzic());
    }
  }
  
  public void zzaP(String paramString)
  {
    zzx.zzcr(paramString);
    zzaQ(paramString);
    zzyq().add(new zzb(this.zzLf, paramString));
  }
  
  public void zzaQ(String paramString)
  {
    paramString = zzb.zzaR(paramString);
    ListIterator localListIterator = zzyq().listIterator();
    while (localListIterator.hasNext()) {
      if (paramString.equals(((zzi)localListIterator.next()).zzhI())) {
        localListIterator.remove();
      }
    }
  }
  
  com.google.android.gms.analytics.internal.zzf zzhF()
  {
    return this.zzLf;
  }
  
  public zzc zzhG()
  {
    zzc localzzc = zzyp().zzye();
    localzzc.zzb(this.zzLf.zziB().zzjb());
    localzzc.zzb(this.zzLf.zziC().zzki());
    zzd(localzzc);
    return localzzc;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */