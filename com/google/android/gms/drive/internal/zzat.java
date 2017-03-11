package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzsa;
import com.google.android.gms.internal.zzsd;
import com.google.android.gms.internal.zzse;
import java.io.IOException;

public final class zzat
  extends zzry<zzat>
{
  public int versionCode;
  public long zzalO;
  public String zzalQ;
  public long zzalR;
  public int zzalS;
  
  public zzat()
  {
    zzrt();
  }
  
  public static zzat zzl(byte[] paramArrayOfByte)
    throws zzsd
  {
    return (zzat)zzse.zza(new zzat(), paramArrayOfByte);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof zzat));
        paramObject = (zzat)paramObject;
        bool1 = bool2;
      } while (this.versionCode != ((zzat)paramObject).versionCode);
      if (this.zzalQ != null) {
        break;
      }
      bool1 = bool2;
    } while (((zzat)paramObject).zzalQ != null);
    while (this.zzalQ.equals(((zzat)paramObject).zzalQ))
    {
      bool1 = bool2;
      if (this.zzalR != ((zzat)paramObject).zzalR) {
        break;
      }
      bool1 = bool2;
      if (this.zzalO != ((zzat)paramObject).zzalO) {
        break;
      }
      bool1 = bool2;
      if (this.zzalS != ((zzat)paramObject).zzalS) {
        break;
      }
      if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
        break label149;
      }
      if (((zzat)paramObject).zzbik != null)
      {
        bool1 = bool2;
        if (!((zzat)paramObject).zzbik.isEmpty()) {
          break;
        }
      }
      return true;
    }
    return false;
    label149:
    return this.zzbik.equals(((zzat)paramObject).zzbik);
  }
  
  public int hashCode()
  {
    int k = 0;
    int m = getClass().getName().hashCode();
    int n = this.versionCode;
    int i;
    int i1;
    int i2;
    int i3;
    if (this.zzalQ == null)
    {
      i = 0;
      i1 = (int)(this.zzalR ^ this.zzalR >>> 32);
      i2 = (int)(this.zzalO ^ this.zzalO >>> 32);
      i3 = this.zzalS;
      j = k;
      if (this.zzbik != null) {
        if (!this.zzbik.isEmpty()) {
          break label138;
        }
      }
    }
    label138:
    for (int j = k;; j = this.zzbik.hashCode())
    {
      return ((((i + ((m + 527) * 31 + n) * 31) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + j;
      i = this.zzalQ.hashCode();
      break;
    }
  }
  
  protected int zzB()
  {
    int j = super.zzB() + zzrx.zzA(1, this.versionCode) + zzrx.zzn(2, this.zzalQ) + zzrx.zze(3, this.zzalR) + zzrx.zze(4, this.zzalO);
    int i = j;
    if (this.zzalS != -1) {
      i = j + zzrx.zzA(5, this.zzalS);
    }
    return i;
  }
  
  public void zza(zzrx paramzzrx)
    throws IOException
  {
    paramzzrx.zzy(1, this.versionCode);
    paramzzrx.zzb(2, this.zzalQ);
    paramzzrx.zzc(3, this.zzalR);
    paramzzrx.zzc(4, this.zzalO);
    if (this.zzalS != -1) {
      paramzzrx.zzy(5, this.zzalS);
    }
    super.zza(paramzzrx);
  }
  
  public zzat zzn(zzrw paramzzrw)
    throws IOException
  {
    for (;;)
    {
      int i = paramzzrw.zzFo();
      switch (i)
      {
      default: 
        if (zza(paramzzrw, i)) {}
        break;
      case 0: 
        return this;
      case 8: 
        this.versionCode = paramzzrw.zzFr();
        break;
      case 18: 
        this.zzalQ = paramzzrw.readString();
        break;
      case 24: 
        this.zzalR = paramzzrw.zzFu();
        break;
      case 32: 
        this.zzalO = paramzzrw.zzFu();
        break;
      case 40: 
        this.zzalS = paramzzrw.zzFr();
      }
    }
  }
  
  public zzat zzrt()
  {
    this.versionCode = 1;
    this.zzalQ = "";
    this.zzalR = -1L;
    this.zzalO = -1L;
    this.zzalS = -1;
    this.zzbik = null;
    this.zzbiv = -1;
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */