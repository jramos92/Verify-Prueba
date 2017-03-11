package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzqz
{
  public static final class zza
    extends zzry<zza>
  {
    public long zzbai;
    public zzaf.zzj zzbaj;
    public zzaf.zzf zziR;
    
    public zza()
    {
      zzDY();
    }
    
    public static zza zzw(byte[] paramArrayOfByte)
      throws zzsd
    {
      return (zza)zzse.zza(new zza(), paramArrayOfByte);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label55:
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
            } while (!(paramObject instanceof zza));
            paramObject = (zza)paramObject;
            bool1 = bool2;
          } while (this.zzbai != ((zza)paramObject).zzbai);
          if (this.zziR != null) {
            break;
          }
          bool1 = bool2;
        } while (((zza)paramObject).zziR != null);
        if (this.zzbaj != null) {
          break label125;
        }
        bool1 = bool2;
      } while (((zza)paramObject).zzbaj != null);
      for (;;)
      {
        if ((this.zzbik == null) || (this.zzbik.isEmpty()))
        {
          if (((zza)paramObject).zzbik != null)
          {
            bool1 = bool2;
            if (!((zza)paramObject).zzbik.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.zziR.equals(((zza)paramObject).zziR)) {
            break label55;
          }
          return false;
          label125:
          if (!this.zzbaj.equals(((zza)paramObject).zzbaj)) {
            return false;
          }
        }
      }
      return this.zzbik.equals(((zza)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = (int)(this.zzbai ^ this.zzbai >>> 32);
      int i;
      int j;
      if (this.zziR == null)
      {
        i = 0;
        if (this.zzbaj != null) {
          break label110;
        }
        j = 0;
        label48:
        k = m;
        if (this.zzbik != null) {
          if (!this.zzbik.isEmpty()) {
            break label121;
          }
        }
      }
      label110:
      label121:
      for (int k = m;; k = this.zzbik.hashCode())
      {
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
        i = this.zziR.hashCode();
        break;
        j = this.zzbaj.hashCode();
        break label48;
      }
    }
    
    protected int zzB()
    {
      int j = super.zzB() + zzrx.zzd(1, this.zzbai);
      int i = j;
      if (this.zziR != null) {
        i = j + zzrx.zzc(2, this.zziR);
      }
      j = i;
      if (this.zzbaj != null) {
        j = i + zzrx.zzc(3, this.zzbaj);
      }
      return j;
    }
    
    public zza zzDY()
    {
      this.zzbai = 0L;
      this.zziR = null;
      this.zzbaj = null;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      paramzzrx.zzb(1, this.zzbai);
      if (this.zziR != null) {
        paramzzrx.zza(2, this.zziR);
      }
      if (this.zzbaj != null) {
        paramzzrx.zza(3, this.zzbaj);
      }
      super.zza(paramzzrx);
    }
    
    public zza zzz(zzrw paramzzrw)
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
          this.zzbai = paramzzrw.zzFq();
          break;
        case 18: 
          if (this.zziR == null) {
            this.zziR = new zzaf.zzf();
          }
          paramzzrw.zza(this.zziR);
          break;
        case 26: 
          if (this.zzbaj == null) {
            this.zzbaj = new zzaf.zzj();
          }
          paramzzrw.zza(this.zzbaj);
        }
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzqz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */