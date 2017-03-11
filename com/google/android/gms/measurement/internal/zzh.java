package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;

class zzh
{
  final String mName;
  final String zzaLl;
  final long zzaMe;
  final long zzaMf;
  final long zzaMg;
  
  zzh(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    zzx.zzcr(paramString1);
    zzx.zzcr(paramString2);
    if (paramLong1 >= 0L)
    {
      bool1 = true;
      zzx.zzaa(bool1);
      if (paramLong2 < 0L) {
        break label81;
      }
    }
    label81:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzaa(bool1);
      this.zzaLl = paramString1;
      this.mName = paramString2;
      this.zzaMe = paramLong1;
      this.zzaMf = paramLong2;
      this.zzaMg = paramLong3;
      return;
      bool1 = false;
      break;
    }
  }
  
  zzh zzO(long paramLong)
  {
    return new zzh(this.zzaLl, this.mName, this.zzaMe + 1L, this.zzaMf + 1L, paramLong);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */