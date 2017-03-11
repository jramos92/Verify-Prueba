package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.internal.zzry;
import com.google.android.gms.internal.zzsa;
import java.io.IOException;

public final class zzau
  extends zzry<zzau>
{
  public long zzalO;
  public long zzalR;
  
  public zzau()
  {
    zzru();
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
            return bool1;
            bool1 = bool2;
          } while (!(paramObject instanceof zzau));
          paramObject = (zzau)paramObject;
          bool1 = bool2;
        } while (this.zzalR != ((zzau)paramObject).zzalR);
        bool1 = bool2;
      } while (this.zzalO != ((zzau)paramObject).zzalO);
      if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
        break label91;
      }
      if (((zzau)paramObject).zzbik == null) {
        break;
      }
      bool1 = bool2;
    } while (!((zzau)paramObject).zzbik.isEmpty());
    return true;
    label91:
    return this.zzbik.equals(((zzau)paramObject).zzbik);
  }
  
  public int hashCode()
  {
    int j = getClass().getName().hashCode();
    int k = (int)(this.zzalR ^ this.zzalR >>> 32);
    int m = (int)(this.zzalO ^ this.zzalO >>> 32);
    if ((this.zzbik == null) || (this.zzbik.isEmpty())) {}
    for (int i = 0;; i = this.zzbik.hashCode()) {
      return i + (((j + 527) * 31 + k) * 31 + m) * 31;
    }
  }
  
  protected int zzB()
  {
    return super.zzB() + zzrx.zze(1, this.zzalR) + zzrx.zze(2, this.zzalO);
  }
  
  public void zza(zzrx paramzzrx)
    throws IOException
  {
    paramzzrx.zzc(1, this.zzalR);
    paramzzrx.zzc(2, this.zzalO);
    super.zza(paramzzrx);
  }
  
  public zzau zzo(zzrw paramzzrw)
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
        this.zzalR = paramzzrw.zzFu();
        break;
      case 16: 
        this.zzalO = paramzzrw.zzFu();
      }
    }
  }
  
  public zzau zzru()
  {
    this.zzalR = -1L;
    this.zzalO = -1L;
    this.zzbik = null;
    this.zzbiv = -1;
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */