package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;

class zza
{
  final String zzaLK;
  final String zzaLL;
  final String zzaLM;
  final long zzaLN;
  final long zzaLO;
  final String zzaLl;
  
  zza(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2)
  {
    zzx.zzcr(paramString1);
    if (paramLong1 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzaa(bool);
      this.zzaLl = paramString1;
      this.zzaLK = paramString2;
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = null;
      }
      this.zzaLL = paramString1;
      this.zzaLM = paramString4;
      this.zzaLN = paramLong1;
      this.zzaLO = paramLong2;
      return;
    }
  }
  
  public zza zzG(String paramString1, String paramString2)
  {
    return new zza(this.zzaLl, paramString1, this.zzaLL, paramString2, this.zzaLN, this.zzaLO);
  }
  
  public zza zza(zzp paramzzp, long paramLong)
  {
    zzx.zzw(paramzzp);
    long l2 = this.zzaLN + 1L;
    long l1 = l2;
    if (l2 > 2147483647L)
    {
      paramzzp.zzzL().zzec("Bundle index overflow");
      l1 = 0L;
    }
    return new zza(this.zzaLl, this.zzaLK, this.zzaLL, this.zzaLM, l1, paramLong);
  }
  
  public zza zzdY(String paramString)
  {
    return new zza(this.zzaLl, this.zzaLK, paramString, this.zzaLM, this.zzaLN, this.zzaLO);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */