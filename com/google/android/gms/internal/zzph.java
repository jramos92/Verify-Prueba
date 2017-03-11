package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class zzph
  extends zze<zzph>
{
  private int zzaLA;
  private String zzaLB;
  private String zzaLC;
  private boolean zzaLD;
  private boolean zzaLE;
  private boolean zzaLF;
  private String zzaLy;
  private int zzaLz;
  
  public zzph()
  {
    this(false);
  }
  
  public zzph(boolean paramBoolean)
  {
    this(paramBoolean, zzyL());
  }
  
  public zzph(boolean paramBoolean, int paramInt)
  {
    zzx.zzbI(paramInt);
    this.zzaLz = paramInt;
    this.zzaLE = paramBoolean;
  }
  
  static int zzyL()
  {
    UUID localUUID = UUID.randomUUID();
    int i = (int)(localUUID.getLeastSignificantBits() & 0x7FFFFFFF);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = (int)(localUUID.getMostSignificantBits() & 0x7FFFFFFF);
      i = j;
    } while (j != 0);
    Log.e("GAv4", "UUID.randomUUID() returned 0.");
    return Integer.MAX_VALUE;
  }
  
  private void zzyP()
  {
    if (this.zzaLF) {
      throw new IllegalStateException("ScreenViewInfo is immutable");
    }
  }
  
  public void setScreenName(String paramString)
  {
    zzyP();
    this.zzaLy = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("screenName", this.zzaLy);
    localHashMap.put("interstitial", Boolean.valueOf(this.zzaLD));
    localHashMap.put("automatic", Boolean.valueOf(this.zzaLE));
    localHashMap.put("screenId", Integer.valueOf(this.zzaLz));
    localHashMap.put("referrerScreenId", Integer.valueOf(this.zzaLA));
    localHashMap.put("referrerScreenName", this.zzaLB);
    localHashMap.put("referrerUri", this.zzaLC);
    return zzB(localHashMap);
  }
  
  public void zza(zzph paramzzph)
  {
    if (!TextUtils.isEmpty(this.zzaLy)) {
      paramzzph.setScreenName(this.zzaLy);
    }
    if (this.zzaLz != 0) {
      paramzzph.zzib(this.zzaLz);
    }
    if (this.zzaLA != 0) {
      paramzzph.zzic(this.zzaLA);
    }
    if (!TextUtils.isEmpty(this.zzaLB)) {
      paramzzph.zzdT(this.zzaLB);
    }
    if (!TextUtils.isEmpty(this.zzaLC)) {
      paramzzph.zzdU(this.zzaLC);
    }
    if (this.zzaLD) {
      paramzzph.zzam(this.zzaLD);
    }
    if (this.zzaLE) {
      paramzzph.zzal(this.zzaLE);
    }
  }
  
  public void zzal(boolean paramBoolean)
  {
    zzyP();
    this.zzaLE = paramBoolean;
  }
  
  public void zzam(boolean paramBoolean)
  {
    zzyP();
    this.zzaLD = paramBoolean;
  }
  
  public void zzdT(String paramString)
  {
    zzyP();
    this.zzaLB = paramString;
  }
  
  public void zzdU(String paramString)
  {
    zzyP();
    if (TextUtils.isEmpty(paramString))
    {
      this.zzaLC = null;
      return;
    }
    this.zzaLC = paramString;
  }
  
  public void zzib(int paramInt)
  {
    zzyP();
    this.zzaLz = paramInt;
  }
  
  public void zzic(int paramInt)
  {
    zzyP();
    this.zzaLA = paramInt;
  }
  
  public String zzyM()
  {
    return this.zzaLy;
  }
  
  public int zzyN()
  {
    return this.zzaLz;
  }
  
  public String zzyO()
  {
    return this.zzaLC;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */