package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzry<M extends zzry<M>>
  extends zzse
{
  protected zzsa zzbik;
  
  protected int zzB()
  {
    int j = 0;
    if (this.zzbik != null)
    {
      int i = 0;
      for (;;)
      {
        k = i;
        if (j >= this.zzbik.size()) {
          break;
        }
        i += this.zzbik.zzlS(j).zzB();
        j += 1;
      }
    }
    int k = 0;
    return k;
  }
  
  public M zzFF()
    throws CloneNotSupportedException
  {
    zzry localzzry = (zzry)super.zzFG();
    zzsc.zza(this, localzzry);
    return localzzry;
  }
  
  public final <T> T zza(zzrz<M, T> paramzzrz)
  {
    if (this.zzbik == null) {}
    zzsb localzzsb;
    do
    {
      return null;
      localzzsb = this.zzbik.zzlR(zzsh.zzlV(paramzzrz.tag));
    } while (localzzsb == null);
    return (T)localzzsb.zzb(paramzzrz);
  }
  
  public void zza(zzrx paramzzrx)
    throws IOException
  {
    if (this.zzbik == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.zzbik.size())
      {
        this.zzbik.zzlS(i).zza(paramzzrx);
        i += 1;
      }
    }
  }
  
  protected final boolean zza(zzrw paramzzrw, int paramInt)
    throws IOException
  {
    int i = paramzzrw.getPosition();
    if (!paramzzrw.zzlA(paramInt)) {
      return false;
    }
    int j = zzsh.zzlV(paramInt);
    zzsg localzzsg = new zzsg(paramInt, paramzzrw.zzx(i, paramzzrw.getPosition() - i));
    paramzzrw = null;
    if (this.zzbik == null) {
      this.zzbik = new zzsa();
    }
    for (;;)
    {
      Object localObject = paramzzrw;
      if (paramzzrw == null)
      {
        localObject = new zzsb();
        this.zzbik.zza(j, (zzsb)localObject);
      }
      ((zzsb)localObject).zza(localzzsg);
      return true;
      paramzzrw = this.zzbik.zzlR(j);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */