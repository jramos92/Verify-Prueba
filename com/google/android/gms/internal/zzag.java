package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzag
{
  public static final class zza
    extends zzry<zza>
  {
    private static volatile zza[] zziT;
    public int type;
    public String zziU;
    public zza[] zziV;
    public zza[] zziW;
    public zza[] zziX;
    public String zziY;
    public String zziZ;
    public long zzja;
    public boolean zzjb;
    public zza[] zzjc;
    public int[] zzjd;
    public boolean zzje;
    
    public zza()
    {
      zzR();
    }
    
    public static zza[] zzQ()
    {
      if (zziT == null) {}
      synchronized (zzsc.zzbiu)
      {
        if (zziT == null) {
          zziT = new zza[0];
        }
        return zziT;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label54:
      label118:
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
                  do
                  {
                    do
                    {
                      return bool1;
                      bool1 = bool2;
                    } while (!(paramObject instanceof zza));
                    paramObject = (zza)paramObject;
                    bool1 = bool2;
                  } while (this.type != ((zza)paramObject).type);
                  if (this.zziU != null) {
                    break;
                  }
                  bool1 = bool2;
                } while (((zza)paramObject).zziU != null);
                bool1 = bool2;
              } while (!zzsc.equals(this.zziV, ((zza)paramObject).zziV));
              bool1 = bool2;
            } while (!zzsc.equals(this.zziW, ((zza)paramObject).zziW));
            bool1 = bool2;
          } while (!zzsc.equals(this.zziX, ((zza)paramObject).zziX));
          if (this.zziY != null) {
            break label260;
          }
          bool1 = bool2;
        } while (((zza)paramObject).zziY != null);
        if (this.zziZ != null) {
          break label276;
        }
        bool1 = bool2;
      } while (((zza)paramObject).zziZ != null);
      label260:
      label276:
      while (this.zziZ.equals(((zza)paramObject).zziZ))
      {
        bool1 = bool2;
        if (this.zzja != ((zza)paramObject).zzja) {
          break;
        }
        bool1 = bool2;
        if (this.zzjb != ((zza)paramObject).zzjb) {
          break;
        }
        bool1 = bool2;
        if (!zzsc.equals(this.zzjc, ((zza)paramObject).zzjc)) {
          break;
        }
        bool1 = bool2;
        if (!zzsc.equals(this.zzjd, ((zza)paramObject).zzjd)) {
          break;
        }
        bool1 = bool2;
        if (this.zzje != ((zza)paramObject).zzje) {
          break;
        }
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label292;
        }
        if (((zza)paramObject).zzbik != null)
        {
          bool1 = bool2;
          if (!((zza)paramObject).zzbik.isEmpty()) {
            break;
          }
        }
        return true;
        if (this.zziU.equals(((zza)paramObject).zziU)) {
          break label54;
        }
        return false;
        if (this.zziY.equals(((zza)paramObject).zziY)) {
          break label118;
        }
        return false;
      }
      return false;
      label292:
      return this.zzbik.equals(((zza)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int n = 1231;
      int i2 = 0;
      int i3 = getClass().getName().hashCode();
      int i4 = this.type;
      int i;
      int i5;
      int i6;
      int i7;
      int j;
      label71:
      int k;
      label80:
      int i8;
      int m;
      label107:
      int i9;
      int i10;
      if (this.zziU == null)
      {
        i = 0;
        i5 = zzsc.hashCode(this.zziV);
        i6 = zzsc.hashCode(this.zziW);
        i7 = zzsc.hashCode(this.zziX);
        if (this.zziY != null) {
          break label250;
        }
        j = 0;
        if (this.zziZ != null) {
          break label261;
        }
        k = 0;
        i8 = (int)(this.zzja ^ this.zzja >>> 32);
        if (!this.zzjb) {
          break label272;
        }
        m = 1231;
        i9 = zzsc.hashCode(this.zzjc);
        i10 = zzsc.hashCode(this.zzjd);
        if (!this.zzje) {
          break label280;
        }
        label132:
        i1 = i2;
        if (this.zzbik != null) {
          if (!this.zzbik.isEmpty()) {
            break label288;
          }
        }
      }
      label250:
      label261:
      label272:
      label280:
      label288:
      for (int i1 = i2;; i1 = this.zzbik.hashCode())
      {
        return ((((m + ((k + (j + ((((i + ((i3 + 527) * 31 + i4) * 31) * 31 + i5) * 31 + i6) * 31 + i7) * 31) * 31) * 31 + i8) * 31) * 31 + i9) * 31 + i10) * 31 + n) * 31 + i1;
        i = this.zziU.hashCode();
        break;
        j = this.zziY.hashCode();
        break label71;
        k = this.zziZ.hashCode();
        break label80;
        m = 1237;
        break label107;
        n = 1237;
        break label132;
      }
    }
    
    protected int zzB()
    {
      int m = 0;
      int j = super.zzB() + zzrx.zzA(1, this.type);
      int i = j;
      if (!this.zziU.equals("")) {
        i = j + zzrx.zzn(2, this.zziU);
      }
      j = i;
      zza localzza;
      int k;
      if (this.zziV != null)
      {
        j = i;
        if (this.zziV.length > 0)
        {
          j = 0;
          while (j < this.zziV.length)
          {
            localzza = this.zziV[j];
            k = i;
            if (localzza != null) {
              k = i + zzrx.zzc(3, localzza);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.zziW != null)
      {
        i = j;
        if (this.zziW.length > 0)
        {
          i = j;
          j = 0;
          while (j < this.zziW.length)
          {
            localzza = this.zziW[j];
            k = i;
            if (localzza != null) {
              k = i + zzrx.zzc(4, localzza);
            }
            j += 1;
            i = k;
          }
        }
      }
      j = i;
      if (this.zziX != null)
      {
        j = i;
        if (this.zziX.length > 0)
        {
          j = 0;
          while (j < this.zziX.length)
          {
            localzza = this.zziX[j];
            k = i;
            if (localzza != null) {
              k = i + zzrx.zzc(5, localzza);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (!this.zziY.equals("")) {
        i = j + zzrx.zzn(6, this.zziY);
      }
      j = i;
      if (!this.zziZ.equals("")) {
        j = i + zzrx.zzn(7, this.zziZ);
      }
      i = j;
      if (this.zzja != 0L) {
        i = j + zzrx.zzd(8, this.zzja);
      }
      j = i;
      if (this.zzje) {
        j = i + zzrx.zzc(9, this.zzje);
      }
      i = j;
      if (this.zzjd != null)
      {
        i = j;
        if (this.zzjd.length > 0)
        {
          i = 0;
          k = 0;
          while (i < this.zzjd.length)
          {
            k += zzrx.zzlJ(this.zzjd[i]);
            i += 1;
          }
          i = j + k + this.zzjd.length * 1;
        }
      }
      j = i;
      if (this.zzjc != null)
      {
        j = i;
        if (this.zzjc.length > 0)
        {
          k = m;
          for (;;)
          {
            j = i;
            if (k >= this.zzjc.length) {
              break;
            }
            localzza = this.zzjc[k];
            j = i;
            if (localzza != null) {
              j = i + zzrx.zzc(11, localzza);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.zzjb) {
        i = j + zzrx.zzc(12, this.zzjb);
      }
      return i;
    }
    
    public zza zzR()
    {
      this.type = 1;
      this.zziU = "";
      this.zziV = zzQ();
      this.zziW = zzQ();
      this.zziX = zzQ();
      this.zziY = "";
      this.zziZ = "";
      this.zzja = 0L;
      this.zzjb = false;
      this.zzjc = zzQ();
      this.zzjd = zzsh.zzbix;
      this.zzje = false;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      int j = 0;
      paramzzrx.zzy(1, this.type);
      if (!this.zziU.equals("")) {
        paramzzrx.zzb(2, this.zziU);
      }
      int i;
      zza localzza;
      if ((this.zziV != null) && (this.zziV.length > 0))
      {
        i = 0;
        while (i < this.zziV.length)
        {
          localzza = this.zziV[i];
          if (localzza != null) {
            paramzzrx.zza(3, localzza);
          }
          i += 1;
        }
      }
      if ((this.zziW != null) && (this.zziW.length > 0))
      {
        i = 0;
        while (i < this.zziW.length)
        {
          localzza = this.zziW[i];
          if (localzza != null) {
            paramzzrx.zza(4, localzza);
          }
          i += 1;
        }
      }
      if ((this.zziX != null) && (this.zziX.length > 0))
      {
        i = 0;
        while (i < this.zziX.length)
        {
          localzza = this.zziX[i];
          if (localzza != null) {
            paramzzrx.zza(5, localzza);
          }
          i += 1;
        }
      }
      if (!this.zziY.equals("")) {
        paramzzrx.zzb(6, this.zziY);
      }
      if (!this.zziZ.equals("")) {
        paramzzrx.zzb(7, this.zziZ);
      }
      if (this.zzja != 0L) {
        paramzzrx.zzb(8, this.zzja);
      }
      if (this.zzje) {
        paramzzrx.zzb(9, this.zzje);
      }
      if ((this.zzjd != null) && (this.zzjd.length > 0))
      {
        i = 0;
        while (i < this.zzjd.length)
        {
          paramzzrx.zzy(10, this.zzjd[i]);
          i += 1;
        }
      }
      if ((this.zzjc != null) && (this.zzjc.length > 0))
      {
        i = j;
        while (i < this.zzjc.length)
        {
          localzza = this.zzjc[i];
          if (localzza != null) {
            paramzzrx.zza(11, localzza);
          }
          i += 1;
        }
      }
      if (this.zzjb) {
        paramzzrx.zzb(12, this.zzjb);
      }
      super.zza(paramzzrx);
    }
    
    public zza zzl(zzrw paramzzrw)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzrw.zzFo();
        int j;
        Object localObject;
        int k;
        switch (i)
        {
        default: 
          if (zza(paramzzrw, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          i = paramzzrw.zzFr();
          switch (i)
          {
          default: 
            break;
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
          case 7: 
          case 8: 
            this.type = i;
          }
          break;
        case 18: 
          this.zziU = paramzzrw.readString();
          break;
        case 26: 
          j = zzsh.zzc(paramzzrw, 26);
          if (this.zziV == null) {}
          for (i = 0;; i = this.zziV.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziV, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zza();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zza();
          paramzzrw.zza(localObject[j]);
          this.zziV = ((zza[])localObject);
          break;
        case 34: 
          j = zzsh.zzc(paramzzrw, 34);
          if (this.zziW == null) {}
          for (i = 0;; i = this.zziW.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziW, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zza();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zza();
          paramzzrw.zza(localObject[j]);
          this.zziW = ((zza[])localObject);
          break;
        case 42: 
          j = zzsh.zzc(paramzzrw, 42);
          if (this.zziX == null) {}
          for (i = 0;; i = this.zziX.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziX, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zza();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zza();
          paramzzrw.zza(localObject[j]);
          this.zziX = ((zza[])localObject);
          break;
        case 50: 
          this.zziY = paramzzrw.readString();
          break;
        case 58: 
          this.zziZ = paramzzrw.readString();
          break;
        case 64: 
          this.zzja = paramzzrw.zzFq();
          break;
        case 72: 
          this.zzje = paramzzrw.zzFs();
          break;
        case 80: 
          int m = zzsh.zzc(paramzzrw, 80);
          localObject = new int[m];
          j = 0;
          i = 0;
          if (j < m)
          {
            if (j != 0) {
              paramzzrw.zzFo();
            }
            int n = paramzzrw.zzFr();
            switch (n)
            {
            }
            for (;;)
            {
              j += 1;
              break;
              k = i + 1;
              localObject[i] = n;
              i = k;
            }
          }
          if (i != 0)
          {
            if (this.zzjd == null) {}
            for (j = 0;; j = this.zzjd.length)
            {
              if ((j != 0) || (i != localObject.length)) {
                break label810;
              }
              this.zzjd = ((int[])localObject);
              break;
            }
            int[] arrayOfInt = new int[j + i];
            if (j != 0) {
              System.arraycopy(this.zzjd, 0, arrayOfInt, 0, j);
            }
            System.arraycopy(localObject, 0, arrayOfInt, j, i);
            this.zzjd = arrayOfInt;
          }
          break;
        case 82: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0) {
            switch (paramzzrw.zzFr())
            {
            default: 
              break;
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: 
              j += 1;
            }
          }
          if (j != 0)
          {
            paramzzrw.zzlE(i);
            if (this.zzjd == null) {}
            for (i = 0;; i = this.zzjd.length)
            {
              localObject = new int[j + i];
              j = i;
              if (i != 0)
              {
                System.arraycopy(this.zzjd, 0, localObject, 0, i);
                j = i;
              }
              while (paramzzrw.zzFA() > 0)
              {
                i = paramzzrw.zzFr();
                switch (i)
                {
                default: 
                  break;
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                  localObject[j] = i;
                  j += 1;
                }
              }
            }
            this.zzjd = ((int[])localObject);
          }
          paramzzrw.zzlD(k);
          break;
        case 90: 
          j = zzsh.zzc(paramzzrw, 90);
          if (this.zzjc == null) {}
          for (i = 0;; i = this.zzjc.length)
          {
            localObject = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzjc, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zza();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zza();
          paramzzrw.zza(localObject[j]);
          this.zzjc = ((zza[])localObject);
          break;
        case 96: 
          label810:
          this.zzjb = paramzzrw.zzFs();
        }
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */