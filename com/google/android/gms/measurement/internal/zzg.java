package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.Set;

public class zzg
{
  final String mName;
  final long zzZH;
  final String zzaLl;
  final String zzaMb;
  final long zzaMc;
  final EventParams zzaMd;
  
  zzg(zzv paramzzv, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    zzx.zzcr(paramString2);
    zzx.zzcr(paramString3);
    this.zzaLl = paramString2;
    this.mName = paramString3;
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = null;
    }
    this.zzaMb = paramString2;
    this.zzZH = paramLong1;
    this.zzaMc = paramLong2;
    if ((this.zzaMc != 0L) && (this.zzaMc > this.zzZH)) {
      paramzzv.zzyd().zzzL().zzec("Event created with reverse previous/current timestamps");
    }
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      paramString1 = new Bundle(paramBundle);
      paramString2 = paramString1.keySet().iterator();
      while (paramString2.hasNext())
      {
        paramString3 = (String)paramString2.next();
        if (paramString3 == null)
        {
          paramString2.remove();
        }
        else
        {
          paramBundle = paramzzv.zzzq().zzC(paramString1.get(paramString3));
          if (paramBundle == null) {
            paramString2.remove();
          } else {
            paramzzv.zzzq().zza(paramString1, paramString3, paramBundle);
          }
        }
      }
      this.zzaMd = new EventParams(paramString1);
      return;
    }
    this.zzaMd = new EventParams(new Bundle());
  }
  
  private zzg(zzv paramzzv, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, EventParams paramEventParams)
  {
    zzx.zzcr(paramString2);
    zzx.zzcr(paramString3);
    zzx.zzw(paramEventParams);
    this.zzaLl = paramString2;
    this.mName = paramString3;
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = null;
    }
    this.zzaMb = paramString2;
    this.zzZH = paramLong1;
    this.zzaMc = paramLong2;
    if ((this.zzaMc != 0L) && (this.zzaMc > this.zzZH)) {
      paramzzv.zzyd().zzzL().zzec("Event created with reverse previous/current timestamps");
    }
    this.zzaMd = paramEventParams;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Event{");
    localStringBuilder.append("appId='").append(this.zzaLl).append('\'');
    localStringBuilder.append(", name='").append(this.mName).append('\'');
    localStringBuilder.append(", params=").append(this.zzaMd);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  zzg zza(zzv paramzzv, long paramLong)
  {
    return new zzg(paramzzv, this.zzaMb, this.zzaLl, this.mName, this.zzZH, paramLong, this.zzaMd);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */