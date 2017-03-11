package com.google.android.gms.ads.internal.formats;

import android.os.Bundle;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcm;
import com.google.android.gms.internal.zzcq.zza;
import com.google.android.gms.internal.zzgr;
import java.util.List;

@zzgr
public class zzd
  extends zzcq.zza
  implements zzh.zza
{
  private final Bundle mExtras;
  private final Object zzpd = new Object();
  private final String zzwo;
  private final List<zzc> zzwp;
  private final String zzwq;
  private final zzcm zzwr;
  private final String zzws;
  private final double zzwt;
  private final String zzwu;
  private final String zzwv;
  private final zza zzww;
  private zzh zzwx;
  
  public zzd(String paramString1, List paramList, String paramString2, zzcm paramzzcm, String paramString3, double paramDouble, String paramString4, String paramString5, zza paramzza, Bundle paramBundle)
  {
    this.zzwo = paramString1;
    this.zzwp = paramList;
    this.zzwq = paramString2;
    this.zzwr = paramzzcm;
    this.zzws = paramString3;
    this.zzwt = paramDouble;
    this.zzwu = paramString4;
    this.zzwv = paramString5;
    this.zzww = paramzza;
    this.mExtras = paramBundle;
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
  
  public String getPrice()
  {
    return this.zzwv;
  }
  
  public double getStarRating()
  {
    return this.zzwt;
  }
  
  public String getStore()
  {
    return this.zzwu;
  }
  
  public void zza(zzh paramzzh)
  {
    synchronized (this.zzpd)
    {
      this.zzwx = paramzzh;
      return;
    }
  }
  
  public zzcm zzdw()
  {
    return this.zzwr;
  }
  
  public com.google.android.gms.dynamic.zzd zzdx()
  {
    return zze.zzy(this.zzwx);
  }
  
  public String zzdy()
  {
    return "2";
  }
  
  public zza zzdz()
  {
    return this.zzww;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\formats\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */