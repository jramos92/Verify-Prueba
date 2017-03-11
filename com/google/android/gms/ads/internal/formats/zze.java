package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzcs.zza;
import com.google.android.gms.internal.zzgr;
import java.util.List;

@zzgr
public class zze
  extends zzcs.zza
  implements zzh.zza
{
  private final Bundle mExtras;
  private final Object zzpd = new Object();
  private final String zzwo;
  private final List<zzc> zzwp;
  private final String zzwq;
  private final String zzws;
  private final zza zzww;
  private zzh zzwx;
  private final zzcm zzwy;
  private final String zzwz;
  
  public zze(String paramString1, List paramList, String paramString2, zzcm paramzzcm, String paramString3, String paramString4, zza paramzza, Bundle paramBundle)
  {
    this.zzwo = paramString1;
    this.zzwp = paramList;
    this.zzwq = paramString2;
    this.zzwy = paramzzcm;
    this.zzws = paramString3;
    this.zzwz = paramString4;
    this.zzww = paramzza;
    this.mExtras = paramBundle;
  }
  
  public String getAdvertiser()
  {
    return this.zzwz;
  }
  
  public String getBody()
  {
    return this.zzwq;
  }
  
  public String getCallToAction()
  {
    return this.zzws;
  }
  
  public String getCustomTemplateId()
  {
    return "";
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public String getHeadline()
  {
    return this.zzwo;
  }
  
  public List getImages()
  {
    return this.zzwp;
  }
  
  public void zza(zzh paramzzh)
  {
    synchronized (this.zzpd)
    {
      this.zzwx = paramzzh;
      return;
    }
  }
  
  public zzcm zzdA()
  {
    return this.zzwy;
  }
  
  public zzd zzdx()
  {
    return com.google.android.gms.dynamic.zze.zzy(this.zzwx);
  }
  
  public String zzdy()
  {
    return "1";
  }
  
  public zza zzdz()
  {
    return this.zzww;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\formats\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */