package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzsa;
import java.io.IOException;

public final class zzas
  extends zzry<zzas>
{
  public int versionCode;
  public long zzalN;
  public long zzalO;
  public long zzalP;
  
  public zzas()
  {
    zzrs();
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
          do
          {
            do
            {
              do
              {
                return bool1;
                bool1 = bool2;
              } while (!(paramObject instanceof zzas));
              paramObject = (zzas)paramObject;
              bool1 = bool2;
            } while (this.versionCode != ((zzas)paramObject).versionCode);
            bool1 = bool2;
          } while (this.zzalN != ((zzas)paramObject).zzalN);
          bool1 = bool2;
        } while (this.zzalO != ((zzas)paramObject).zzalO);
        bool1 = bool2;
      } while (this.zzalP != ((zzas)paramObject).zzalP);
      if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
        break label118;
      }
      if (((zzas)paramObject).zzbik == null) {
        break;
      }
      bool1 = bool2;
    } while (!((zzas)paramObject).zzbik.isEmpty());
    return true;
    label118:
    return this.zzbik.equals(((zzas)paramObject).zzbik);
  }
  
  public int hashCode()
  {
    int j = getClass().getName().hashCode();
    int k = this.versionCode;
    int m = (int)(this.zzalN ^ this.zzalN >>> 32);
    int n = (int)(this.zzalO ^ this.zzalO >>> 32);
    int i1 = (int)(this.zzalP ^ this.zzalP >>> 32);
    if ((this.zzbik == null) || (this.zzbik.isEmpty())) {}
    for (int i = 0;; i = this.zzbik.hashCode()) {
      return i + (((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31;
    }
  }
  
  protected int zzB()
  {
    return super.zzB() + zzrx.zzA(1, this.versionCode) + zzrx.zze(2, this.zzalN) + zzrx.zze(3, this.zzalO) + zzrx.zze(4, this.zzalP);
  }
  
  public void zza(zzrx paramzzrx)
    throws IOException
  {
    paramzzrx.zzy(1, this.versionCode);
    paramzzrx.zzc(2, this.zzalN);
    paramzzrx.zzc(3, this.zzalO);
    paramzzrx.zzc(4, this.zzalP);
    super.zza(paramzzrx);
  }
  
  public zzas zzm(zzrw paramzzrw)
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
      case 16: 
        this.zzalN = paramzzrw.zzFu();
        break;
      case 24: 
        this.zzalO = paramzzrw.zzFu();
        break;
      case 32: 
        this.zzalP = paramzzrw.zzFu();
      }
    }
  }
  
  public zzas zzrs()
  {
    this.versionCode = 1;
    this.zzalN = -1L;
    this.zzalO = -1L;
    this.zzalP = -1L;
    this.zzbik = null;
    this.zzbiv = -1;
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */