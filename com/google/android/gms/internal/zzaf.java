package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzaf
{
  public static final class zza
    extends zzry<zza>
  {
    public int level;
    public int zzhN;
    public int zzhO;
    
    public zza()
    {
      zzA();
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
                return bool1;
                bool1 = bool2;
              } while (!(paramObject instanceof zza));
              paramObject = (zza)paramObject;
              bool1 = bool2;
            } while (this.level != ((zza)paramObject).level);
            bool1 = bool2;
          } while (this.zzhN != ((zza)paramObject).zzhN);
          bool1 = bool2;
        } while (this.zzhO != ((zza)paramObject).zzhO);
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label102;
        }
        if (((zza)paramObject).zzbik == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zza)paramObject).zzbik.isEmpty());
      return true;
      label102:
      return this.zzbik.equals(((zza)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = this.level;
      int m = this.zzhN;
      int n = this.zzhO;
      if ((this.zzbik == null) || (this.zzbik.isEmpty())) {}
      for (int i = 0;; i = this.zzbik.hashCode()) {
        return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
      }
    }
    
    public zza zzA()
    {
      this.level = 1;
      this.zzhN = 0;
      this.zzhO = 0;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    protected int zzB()
    {
      int j = super.zzB();
      int i = j;
      if (this.level != 1) {
        i = j + zzrx.zzA(1, this.level);
      }
      j = i;
      if (this.zzhN != 0) {
        j = i + zzrx.zzA(2, this.zzhN);
      }
      i = j;
      if (this.zzhO != 0) {
        i = j + zzrx.zzA(3, this.zzhO);
      }
      return i;
    }
    
    public zza zza(zzrw paramzzrw)
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
          i = paramzzrw.zzFr();
          switch (i)
          {
          default: 
            break;
          case 1: 
          case 2: 
          case 3: 
            this.level = i;
          }
          break;
        case 16: 
          this.zzhN = paramzzrw.zzFr();
          break;
        case 24: 
          this.zzhO = paramzzrw.zzFr();
        }
      }
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if (this.level != 1) {
        paramzzrx.zzy(1, this.level);
      }
      if (this.zzhN != 0) {
        paramzzrx.zzy(2, this.zzhN);
      }
      if (this.zzhO != 0) {
        paramzzrx.zzy(3, this.zzhO);
      }
      super.zza(paramzzrx);
    }
  }
  
  public static final class zzb
    extends zzry<zzb>
  {
    private static volatile zzb[] zzhP;
    public int name;
    public int[] zzhQ;
    public int zzhR;
    public boolean zzhS;
    public boolean zzhT;
    
    public zzb()
    {
      zzD();
    }
    
    public static zzb[] zzC()
    {
      if (zzhP == null) {}
      synchronized (zzsc.zzbiu)
      {
        if (zzhP == null) {
          zzhP = new zzb[0];
        }
        return zzhP;
      }
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
                  do
                  {
                    return bool1;
                    bool1 = bool2;
                  } while (!(paramObject instanceof zzb));
                  paramObject = (zzb)paramObject;
                  bool1 = bool2;
                } while (!zzsc.equals(this.zzhQ, ((zzb)paramObject).zzhQ));
                bool1 = bool2;
              } while (this.zzhR != ((zzb)paramObject).zzhR);
              bool1 = bool2;
            } while (this.name != ((zzb)paramObject).name);
            bool1 = bool2;
          } while (this.zzhS != ((zzb)paramObject).zzhS);
          bool1 = bool2;
        } while (this.zzhT != ((zzb)paramObject).zzhT);
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label131;
        }
        if (((zzb)paramObject).zzbik == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzb)paramObject).zzbik.isEmpty());
      return true;
      label131:
      return this.zzbik.equals(((zzb)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int j = 1231;
      int m = getClass().getName().hashCode();
      int n = zzsc.hashCode(this.zzhQ);
      int i1 = this.zzhR;
      int i2 = this.name;
      int i;
      if (this.zzhS)
      {
        i = 1231;
        if (!this.zzhT) {
          break label121;
        }
        label55:
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label128;
        }
      }
      label121:
      label128:
      for (int k = 0;; k = this.zzbik.hashCode())
      {
        return k + ((i + ((((m + 527) * 31 + n) * 31 + i1) * 31 + i2) * 31) * 31 + j) * 31;
        i = 1237;
        break;
        j = 1237;
        break label55;
      }
    }
    
    protected int zzB()
    {
      int j = 0;
      int k = super.zzB();
      int i = k;
      if (this.zzhT) {
        i = k + zzrx.zzc(1, this.zzhT);
      }
      k = zzrx.zzA(2, this.zzhR) + i;
      if ((this.zzhQ != null) && (this.zzhQ.length > 0))
      {
        i = 0;
        while (i < this.zzhQ.length)
        {
          j += zzrx.zzlJ(this.zzhQ[i]);
          i += 1;
        }
      }
      for (j = k + j + this.zzhQ.length * 1;; j = k)
      {
        i = j;
        if (this.name != 0) {
          i = j + zzrx.zzA(4, this.name);
        }
        j = i;
        if (this.zzhS) {
          j = i + zzrx.zzc(6, this.zzhS);
        }
        return j;
      }
    }
    
    public zzb zzD()
    {
      this.zzhQ = zzsh.zzbix;
      this.zzhR = 0;
      this.name = 0;
      this.zzhS = false;
      this.zzhT = false;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if (this.zzhT) {
        paramzzrx.zzb(1, this.zzhT);
      }
      paramzzrx.zzy(2, this.zzhR);
      if ((this.zzhQ != null) && (this.zzhQ.length > 0))
      {
        int i = 0;
        while (i < this.zzhQ.length)
        {
          paramzzrx.zzy(3, this.zzhQ[i]);
          i += 1;
        }
      }
      if (this.name != 0) {
        paramzzrx.zzy(4, this.name);
      }
      if (this.zzhS) {
        paramzzrx.zzb(6, this.zzhS);
      }
      super.zza(paramzzrx);
    }
    
    public zzb zzc(zzrw paramzzrw)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzrw.zzFo();
        int j;
        int[] arrayOfInt;
        switch (i)
        {
        default: 
          if (zza(paramzzrw, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          this.zzhT = paramzzrw.zzFs();
          break;
        case 16: 
          this.zzhR = paramzzrw.zzFr();
          break;
        case 24: 
          j = zzsh.zzc(paramzzrw, 24);
          if (this.zzhQ == null) {}
          for (i = 0;; i = this.zzhQ.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzhQ, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zzhQ = arrayOfInt;
          break;
        case 26: 
          int k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zzhQ == null) {}
          for (i = 0;; i = this.zzhQ.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzhQ, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zzhQ = arrayOfInt;
          paramzzrw.zzlD(k);
          break;
        case 32: 
          this.name = paramzzrw.zzFr();
          break;
        case 48: 
          this.zzhS = paramzzrw.zzFs();
        }
      }
    }
  }
  
  public static final class zzc
    extends zzry<zzc>
  {
    private static volatile zzc[] zzhU;
    public String key;
    public long zzhV;
    public long zzhW;
    public boolean zzhX;
    public long zzhY;
    
    public zzc()
    {
      zzF();
    }
    
    public static zzc[] zzE()
    {
      if (zzhU == null) {}
      synchronized (zzsc.zzbiu)
      {
        if (zzhU == null) {
          zzhU = new zzc[0];
        }
        return zzhU;
      }
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
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof zzc));
        paramObject = (zzc)paramObject;
        if (this.key != null) {
          break;
        }
        bool1 = bool2;
      } while (((zzc)paramObject).key != null);
      while (this.key.equals(((zzc)paramObject).key))
      {
        bool1 = bool2;
        if (this.zzhV != ((zzc)paramObject).zzhV) {
          break;
        }
        bool1 = bool2;
        if (this.zzhW != ((zzc)paramObject).zzhW) {
          break;
        }
        bool1 = bool2;
        if (this.zzhX != ((zzc)paramObject).zzhX) {
          break;
        }
        bool1 = bool2;
        if (this.zzhY != ((zzc)paramObject).zzhY) {
          break;
        }
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label150;
        }
        if (((zzc)paramObject).zzbik != null)
        {
          bool1 = bool2;
          if (!((zzc)paramObject).zzbik.isEmpty()) {
            break;
          }
        }
        return true;
      }
      return false;
      label150:
      return this.zzbik.equals(((zzc)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int i1;
      int i2;
      int j;
      label65:
      int i3;
      if (this.key == null)
      {
        i = 0;
        i1 = (int)(this.zzhV ^ this.zzhV >>> 32);
        i2 = (int)(this.zzhW ^ this.zzhW >>> 32);
        if (!this.zzhX) {
          break label154;
        }
        j = 1231;
        i3 = (int)(this.zzhY ^ this.zzhY >>> 32);
        k = m;
        if (this.zzbik != null) {
          if (!this.zzbik.isEmpty()) {
            break label161;
          }
        }
      }
      label154:
      label161:
      for (int k = m;; k = this.zzbik.hashCode())
      {
        return ((j + (((i + (n + 527) * 31) * 31 + i1) * 31 + i2) * 31) * 31 + i3) * 31 + k;
        i = this.key.hashCode();
        break;
        j = 1237;
        break label65;
      }
    }
    
    protected int zzB()
    {
      int j = super.zzB();
      int i = j;
      if (!this.key.equals("")) {
        i = j + zzrx.zzn(1, this.key);
      }
      j = i;
      if (this.zzhV != 0L) {
        j = i + zzrx.zzd(2, this.zzhV);
      }
      i = j;
      if (this.zzhW != 2147483647L) {
        i = j + zzrx.zzd(3, this.zzhW);
      }
      j = i;
      if (this.zzhX) {
        j = i + zzrx.zzc(4, this.zzhX);
      }
      i = j;
      if (this.zzhY != 0L) {
        i = j + zzrx.zzd(5, this.zzhY);
      }
      return i;
    }
    
    public zzc zzF()
    {
      this.key = "";
      this.zzhV = 0L;
      this.zzhW = 2147483647L;
      this.zzhX = false;
      this.zzhY = 0L;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if (!this.key.equals("")) {
        paramzzrx.zzb(1, this.key);
      }
      if (this.zzhV != 0L) {
        paramzzrx.zzb(2, this.zzhV);
      }
      if (this.zzhW != 2147483647L) {
        paramzzrx.zzb(3, this.zzhW);
      }
      if (this.zzhX) {
        paramzzrx.zzb(4, this.zzhX);
      }
      if (this.zzhY != 0L) {
        paramzzrx.zzb(5, this.zzhY);
      }
      super.zza(paramzzrx);
    }
    
    public zzc zzd(zzrw paramzzrw)
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
        case 10: 
          this.key = paramzzrw.readString();
          break;
        case 16: 
          this.zzhV = paramzzrw.zzFq();
          break;
        case 24: 
          this.zzhW = paramzzrw.zzFq();
          break;
        case 32: 
          this.zzhX = paramzzrw.zzFs();
          break;
        case 40: 
          this.zzhY = paramzzrw.zzFq();
        }
      }
    }
  }
  
  public static final class zzd
    extends zzry<zzd>
  {
    public zzag.zza[] zzhZ;
    public zzag.zza[] zzia;
    public zzaf.zzc[] zzib;
    
    public zzd()
    {
      zzG();
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
                return bool1;
                bool1 = bool2;
              } while (!(paramObject instanceof zzd));
              paramObject = (zzd)paramObject;
              bool1 = bool2;
            } while (!zzsc.equals(this.zzhZ, ((zzd)paramObject).zzhZ));
            bool1 = bool2;
          } while (!zzsc.equals(this.zzia, ((zzd)paramObject).zzia));
          bool1 = bool2;
        } while (!zzsc.equals(this.zzib, ((zzd)paramObject).zzib));
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label111;
        }
        if (((zzd)paramObject).zzbik == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzd)paramObject).zzbik.isEmpty());
      return true;
      label111:
      return this.zzbik.equals(((zzd)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzsc.hashCode(this.zzhZ);
      int m = zzsc.hashCode(this.zzia);
      int n = zzsc.hashCode(this.zzib);
      if ((this.zzbik == null) || (this.zzbik.isEmpty())) {}
      for (int i = 0;; i = this.zzbik.hashCode()) {
        return i + ((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31;
      }
    }
    
    protected int zzB()
    {
      int m = 0;
      int i = super.zzB();
      int j = i;
      Object localObject;
      if (this.zzhZ != null)
      {
        j = i;
        if (this.zzhZ.length > 0)
        {
          j = 0;
          while (j < this.zzhZ.length)
          {
            localObject = this.zzhZ[j];
            k = i;
            if (localObject != null) {
              k = i + zzrx.zzc(1, (zzse)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.zzia != null)
      {
        i = j;
        if (this.zzia.length > 0)
        {
          i = j;
          j = 0;
          while (j < this.zzia.length)
          {
            localObject = this.zzia[j];
            k = i;
            if (localObject != null) {
              k = i + zzrx.zzc(2, (zzse)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      int k = i;
      if (this.zzib != null)
      {
        k = i;
        if (this.zzib.length > 0)
        {
          j = m;
          for (;;)
          {
            k = i;
            if (j >= this.zzib.length) {
              break;
            }
            localObject = this.zzib[j];
            k = i;
            if (localObject != null) {
              k = i + zzrx.zzc(3, (zzse)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      return k;
    }
    
    public zzd zzG()
    {
      this.zzhZ = zzag.zza.zzQ();
      this.zzia = zzag.zza.zzQ();
      this.zzib = zzaf.zzc.zzE();
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      int j = 0;
      int i;
      Object localObject;
      if ((this.zzhZ != null) && (this.zzhZ.length > 0))
      {
        i = 0;
        while (i < this.zzhZ.length)
        {
          localObject = this.zzhZ[i];
          if (localObject != null) {
            paramzzrx.zza(1, (zzse)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzia != null) && (this.zzia.length > 0))
      {
        i = 0;
        while (i < this.zzia.length)
        {
          localObject = this.zzia[i];
          if (localObject != null) {
            paramzzrx.zza(2, (zzse)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzib != null) && (this.zzib.length > 0))
      {
        i = j;
        while (i < this.zzib.length)
        {
          localObject = this.zzib[i];
          if (localObject != null) {
            paramzzrx.zza(3, (zzse)localObject);
          }
          i += 1;
        }
      }
      super.zza(paramzzrx);
    }
    
    public zzd zze(zzrw paramzzrw)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzrw.zzFo();
        int j;
        Object localObject;
        switch (i)
        {
        default: 
          if (zza(paramzzrw, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          j = zzsh.zzc(paramzzrw, 10);
          if (this.zzhZ == null) {}
          for (i = 0;; i = this.zzhZ.length)
          {
            localObject = new zzag.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzhZ, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzag.zza();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zzag.zza();
          paramzzrw.zza(localObject[j]);
          this.zzhZ = ((zzag.zza[])localObject);
          break;
        case 18: 
          j = zzsh.zzc(paramzzrw, 18);
          if (this.zzia == null) {}
          for (i = 0;; i = this.zzia.length)
          {
            localObject = new zzag.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzia, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzag.zza();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zzag.zza();
          paramzzrw.zza(localObject[j]);
          this.zzia = ((zzag.zza[])localObject);
          break;
        case 26: 
          j = zzsh.zzc(paramzzrw, 26);
          if (this.zzib == null) {}
          for (i = 0;; i = this.zzib.length)
          {
            localObject = new zzaf.zzc[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzib, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaf.zzc();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zzaf.zzc();
          paramzzrw.zza(localObject[j]);
          this.zzib = ((zzaf.zzc[])localObject);
        }
      }
    }
  }
  
  public static final class zze
    extends zzry<zze>
  {
    private static volatile zze[] zzic;
    public int key;
    public int value;
    
    public zze()
    {
      zzI();
    }
    
    public static zze[] zzH()
    {
      if (zzic == null) {}
      synchronized (zzsc.zzbiu)
      {
        if (zzic == null) {
          zzic = new zze[0];
        }
        return zzic;
      }
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
            } while (!(paramObject instanceof zze));
            paramObject = (zze)paramObject;
            bool1 = bool2;
          } while (this.key != ((zze)paramObject).key);
          bool1 = bool2;
        } while (this.value != ((zze)paramObject).value);
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label89;
        }
        if (((zze)paramObject).zzbik == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zze)paramObject).zzbik.isEmpty());
      return true;
      label89:
      return this.zzbik.equals(((zze)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = this.key;
      int m = this.value;
      if ((this.zzbik == null) || (this.zzbik.isEmpty())) {}
      for (int i = 0;; i = this.zzbik.hashCode()) {
        return i + (((j + 527) * 31 + k) * 31 + m) * 31;
      }
    }
    
    protected int zzB()
    {
      return super.zzB() + zzrx.zzA(1, this.key) + zzrx.zzA(2, this.value);
    }
    
    public zze zzI()
    {
      this.key = 0;
      this.value = 0;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      paramzzrx.zzy(1, this.key);
      paramzzrx.zzy(2, this.value);
      super.zza(paramzzrx);
    }
    
    public zze zzf(zzrw paramzzrw)
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
          this.key = paramzzrw.zzFr();
          break;
        case 16: 
          this.value = paramzzrw.zzFr();
        }
      }
    }
  }
  
  public static final class zzf
    extends zzry<zzf>
  {
    public String version;
    public String[] zzid;
    public String[] zzie;
    public zzag.zza[] zzif;
    public zzaf.zze[] zzig;
    public zzaf.zzb[] zzih;
    public zzaf.zzb[] zzii;
    public zzaf.zzb[] zzij;
    public zzaf.zzg[] zzik;
    public String zzil;
    public String zzim;
    public String zzin;
    public zzaf.zza zzio;
    public float zzip;
    public boolean zziq;
    public String[] zzir;
    public int zzis;
    
    public zzf()
    {
      zzJ();
    }
    
    public static zzf zzc(byte[] paramArrayOfByte)
      throws zzsd
    {
      return (zzf)zzse.zza(new zzf(), paramArrayOfByte);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label169:
      label185:
      label201:
      label217:
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
                                } while (!(paramObject instanceof zzf));
                                paramObject = (zzf)paramObject;
                                bool1 = bool2;
                              } while (!zzsc.equals(this.zzid, ((zzf)paramObject).zzid));
                              bool1 = bool2;
                            } while (!zzsc.equals(this.zzie, ((zzf)paramObject).zzie));
                            bool1 = bool2;
                          } while (!zzsc.equals(this.zzif, ((zzf)paramObject).zzif));
                          bool1 = bool2;
                        } while (!zzsc.equals(this.zzig, ((zzf)paramObject).zzig));
                        bool1 = bool2;
                      } while (!zzsc.equals(this.zzih, ((zzf)paramObject).zzih));
                      bool1 = bool2;
                    } while (!zzsc.equals(this.zzii, ((zzf)paramObject).zzii));
                    bool1 = bool2;
                  } while (!zzsc.equals(this.zzij, ((zzf)paramObject).zzij));
                  bool1 = bool2;
                } while (!zzsc.equals(this.zzik, ((zzf)paramObject).zzik));
                if (this.zzil != null) {
                  break;
                }
                bool1 = bool2;
              } while (((zzf)paramObject).zzil != null);
              if (this.zzim != null) {
                break label348;
              }
              bool1 = bool2;
            } while (((zzf)paramObject).zzim != null);
            if (this.zzin != null) {
              break label364;
            }
            bool1 = bool2;
          } while (((zzf)paramObject).zzin != null);
          if (this.version != null) {
            break label380;
          }
          bool1 = bool2;
        } while (((zzf)paramObject).version != null);
        if (this.zzio != null) {
          break label396;
        }
        bool1 = bool2;
      } while (((zzf)paramObject).zzio != null);
      label348:
      label364:
      label380:
      label396:
      while (this.zzio.equals(((zzf)paramObject).zzio))
      {
        bool1 = bool2;
        if (Float.floatToIntBits(this.zzip) != Float.floatToIntBits(((zzf)paramObject).zzip)) {
          break;
        }
        bool1 = bool2;
        if (this.zziq != ((zzf)paramObject).zziq) {
          break;
        }
        bool1 = bool2;
        if (!zzsc.equals(this.zzir, ((zzf)paramObject).zzir)) {
          break;
        }
        bool1 = bool2;
        if (this.zzis != ((zzf)paramObject).zzis) {
          break;
        }
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label412;
        }
        if (((zzf)paramObject).zzbik != null)
        {
          bool1 = bool2;
          if (!((zzf)paramObject).zzbik.isEmpty()) {
            break;
          }
        }
        return true;
        if (this.zzil.equals(((zzf)paramObject).zzil)) {
          break label169;
        }
        return false;
        if (this.zzim.equals(((zzf)paramObject).zzim)) {
          break label185;
        }
        return false;
        if (this.zzin.equals(((zzf)paramObject).zzin)) {
          break label201;
        }
        return false;
        if (this.version.equals(((zzf)paramObject).version)) {
          break label217;
        }
        return false;
      }
      return false;
      label412:
      return this.zzbik.equals(((zzf)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int i3 = 0;
      int i4 = getClass().getName().hashCode();
      int i5 = zzsc.hashCode(this.zzid);
      int i6 = zzsc.hashCode(this.zzie);
      int i7 = zzsc.hashCode(this.zzif);
      int i8 = zzsc.hashCode(this.zzig);
      int i9 = zzsc.hashCode(this.zzih);
      int i10 = zzsc.hashCode(this.zzii);
      int i11 = zzsc.hashCode(this.zzij);
      int i12 = zzsc.hashCode(this.zzik);
      int i;
      int j;
      label105:
      int k;
      label114:
      int m;
      label124:
      int n;
      label134:
      int i13;
      int i1;
      label155:
      int i14;
      int i15;
      if (this.zzil == null)
      {
        i = 0;
        if (this.zzim != null) {
          break label318;
        }
        j = 0;
        if (this.zzin != null) {
          break label329;
        }
        k = 0;
        if (this.version != null) {
          break label340;
        }
        m = 0;
        if (this.zzio != null) {
          break label352;
        }
        n = 0;
        i13 = Float.floatToIntBits(this.zzip);
        if (!this.zziq) {
          break label364;
        }
        i1 = 1231;
        i14 = zzsc.hashCode(this.zzir);
        i15 = this.zzis;
        i2 = i3;
        if (this.zzbik != null) {
          if (!this.zzbik.isEmpty()) {
            break label372;
          }
        }
      }
      label318:
      label329:
      label340:
      label352:
      label364:
      label372:
      for (int i2 = i3;; i2 = this.zzbik.hashCode())
      {
        return (((i1 + ((n + (m + (k + (j + (i + (((((((((i4 + 527) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31) * 31) * 31) * 31) * 31) * 31 + i13) * 31) * 31 + i14) * 31 + i15) * 31 + i2;
        i = this.zzil.hashCode();
        break;
        j = this.zzim.hashCode();
        break label105;
        k = this.zzin.hashCode();
        break label114;
        m = this.version.hashCode();
        break label124;
        n = this.zzio.hashCode();
        break label134;
        i1 = 1237;
        break label155;
      }
    }
    
    protected int zzB()
    {
      int i2 = 0;
      int i1 = super.zzB();
      int i;
      int k;
      Object localObject;
      int n;
      int m;
      if ((this.zzie != null) && (this.zzie.length > 0))
      {
        i = 0;
        j = 0;
        for (k = 0; i < this.zzie.length; k = m)
        {
          localObject = this.zzie[i];
          n = j;
          m = k;
          if (localObject != null)
          {
            m = k + 1;
            n = j + zzrx.zzfA((String)localObject);
          }
          i += 1;
          j = n;
        }
      }
      for (int j = i1 + j + k * 1;; j = i1)
      {
        i = j;
        if (this.zzif != null)
        {
          i = j;
          if (this.zzif.length > 0)
          {
            i = j;
            j = 0;
            while (j < this.zzif.length)
            {
              localObject = this.zzif[j];
              k = i;
              if (localObject != null) {
                k = i + zzrx.zzc(2, (zzse)localObject);
              }
              j += 1;
              i = k;
            }
          }
        }
        j = i;
        if (this.zzig != null)
        {
          j = i;
          if (this.zzig.length > 0)
          {
            j = 0;
            while (j < this.zzig.length)
            {
              localObject = this.zzig[j];
              k = i;
              if (localObject != null) {
                k = i + zzrx.zzc(3, (zzse)localObject);
              }
              j += 1;
              i = k;
            }
            j = i;
          }
        }
        i = j;
        if (this.zzih != null)
        {
          i = j;
          if (this.zzih.length > 0)
          {
            i = j;
            j = 0;
            while (j < this.zzih.length)
            {
              localObject = this.zzih[j];
              k = i;
              if (localObject != null) {
                k = i + zzrx.zzc(4, (zzse)localObject);
              }
              j += 1;
              i = k;
            }
          }
        }
        j = i;
        if (this.zzii != null)
        {
          j = i;
          if (this.zzii.length > 0)
          {
            j = 0;
            while (j < this.zzii.length)
            {
              localObject = this.zzii[j];
              k = i;
              if (localObject != null) {
                k = i + zzrx.zzc(5, (zzse)localObject);
              }
              j += 1;
              i = k;
            }
            j = i;
          }
        }
        i = j;
        if (this.zzij != null)
        {
          i = j;
          if (this.zzij.length > 0)
          {
            i = j;
            j = 0;
            while (j < this.zzij.length)
            {
              localObject = this.zzij[j];
              k = i;
              if (localObject != null) {
                k = i + zzrx.zzc(6, (zzse)localObject);
              }
              j += 1;
              i = k;
            }
          }
        }
        j = i;
        if (this.zzik != null)
        {
          j = i;
          if (this.zzik.length > 0)
          {
            j = 0;
            while (j < this.zzik.length)
            {
              localObject = this.zzik[j];
              k = i;
              if (localObject != null) {
                k = i + zzrx.zzc(7, (zzse)localObject);
              }
              j += 1;
              i = k;
            }
            j = i;
          }
        }
        i = j;
        if (!this.zzil.equals("")) {
          i = j + zzrx.zzn(9, this.zzil);
        }
        j = i;
        if (!this.zzim.equals("")) {
          j = i + zzrx.zzn(10, this.zzim);
        }
        i = j;
        if (!this.zzin.equals("0")) {
          i = j + zzrx.zzn(12, this.zzin);
        }
        j = i;
        if (!this.version.equals("")) {
          j = i + zzrx.zzn(13, this.version);
        }
        k = j;
        if (this.zzio != null) {
          k = j + zzrx.zzc(14, this.zzio);
        }
        i = k;
        if (Float.floatToIntBits(this.zzip) != Float.floatToIntBits(0.0F)) {
          i = k + zzrx.zzc(15, this.zzip);
        }
        j = i;
        if (this.zzir != null)
        {
          j = i;
          if (this.zzir.length > 0)
          {
            j = 0;
            k = 0;
            for (m = 0; j < this.zzir.length; m = n)
            {
              localObject = this.zzir[j];
              i1 = k;
              n = m;
              if (localObject != null)
              {
                n = m + 1;
                i1 = k + zzrx.zzfA((String)localObject);
              }
              j += 1;
              k = i1;
            }
            j = i + k + m * 2;
          }
        }
        k = j;
        if (this.zzis != 0) {
          k = j + zzrx.zzA(17, this.zzis);
        }
        i = k;
        if (this.zziq) {
          i = k + zzrx.zzc(18, this.zziq);
        }
        j = i;
        if (this.zzid != null)
        {
          j = i;
          if (this.zzid.length > 0)
          {
            k = 0;
            m = 0;
            j = i2;
            while (j < this.zzid.length)
            {
              localObject = this.zzid[j];
              i1 = k;
              n = m;
              if (localObject != null)
              {
                n = m + 1;
                i1 = k + zzrx.zzfA((String)localObject);
              }
              j += 1;
              k = i1;
              m = n;
            }
            j = i + k + m * 2;
          }
        }
        return j;
      }
    }
    
    public zzf zzJ()
    {
      this.zzid = zzsh.zzbiC;
      this.zzie = zzsh.zzbiC;
      this.zzif = zzag.zza.zzQ();
      this.zzig = zzaf.zze.zzH();
      this.zzih = zzaf.zzb.zzC();
      this.zzii = zzaf.zzb.zzC();
      this.zzij = zzaf.zzb.zzC();
      this.zzik = zzaf.zzg.zzK();
      this.zzil = "";
      this.zzim = "";
      this.zzin = "0";
      this.version = "";
      this.zzio = null;
      this.zzip = 0.0F;
      this.zziq = false;
      this.zzir = zzsh.zzbiC;
      this.zzis = 0;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      int j = 0;
      int i;
      Object localObject;
      if ((this.zzie != null) && (this.zzie.length > 0))
      {
        i = 0;
        while (i < this.zzie.length)
        {
          localObject = this.zzie[i];
          if (localObject != null) {
            paramzzrx.zzb(1, (String)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzif != null) && (this.zzif.length > 0))
      {
        i = 0;
        while (i < this.zzif.length)
        {
          localObject = this.zzif[i];
          if (localObject != null) {
            paramzzrx.zza(2, (zzse)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzig != null) && (this.zzig.length > 0))
      {
        i = 0;
        while (i < this.zzig.length)
        {
          localObject = this.zzig[i];
          if (localObject != null) {
            paramzzrx.zza(3, (zzse)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzih != null) && (this.zzih.length > 0))
      {
        i = 0;
        while (i < this.zzih.length)
        {
          localObject = this.zzih[i];
          if (localObject != null) {
            paramzzrx.zza(4, (zzse)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzii != null) && (this.zzii.length > 0))
      {
        i = 0;
        while (i < this.zzii.length)
        {
          localObject = this.zzii[i];
          if (localObject != null) {
            paramzzrx.zza(5, (zzse)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzij != null) && (this.zzij.length > 0))
      {
        i = 0;
        while (i < this.zzij.length)
        {
          localObject = this.zzij[i];
          if (localObject != null) {
            paramzzrx.zza(6, (zzse)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzik != null) && (this.zzik.length > 0))
      {
        i = 0;
        while (i < this.zzik.length)
        {
          localObject = this.zzik[i];
          if (localObject != null) {
            paramzzrx.zza(7, (zzse)localObject);
          }
          i += 1;
        }
      }
      if (!this.zzil.equals("")) {
        paramzzrx.zzb(9, this.zzil);
      }
      if (!this.zzim.equals("")) {
        paramzzrx.zzb(10, this.zzim);
      }
      if (!this.zzin.equals("0")) {
        paramzzrx.zzb(12, this.zzin);
      }
      if (!this.version.equals("")) {
        paramzzrx.zzb(13, this.version);
      }
      if (this.zzio != null) {
        paramzzrx.zza(14, this.zzio);
      }
      if (Float.floatToIntBits(this.zzip) != Float.floatToIntBits(0.0F)) {
        paramzzrx.zzb(15, this.zzip);
      }
      if ((this.zzir != null) && (this.zzir.length > 0))
      {
        i = 0;
        while (i < this.zzir.length)
        {
          localObject = this.zzir[i];
          if (localObject != null) {
            paramzzrx.zzb(16, (String)localObject);
          }
          i += 1;
        }
      }
      if (this.zzis != 0) {
        paramzzrx.zzy(17, this.zzis);
      }
      if (this.zziq) {
        paramzzrx.zzb(18, this.zziq);
      }
      if ((this.zzid != null) && (this.zzid.length > 0))
      {
        i = j;
        while (i < this.zzid.length)
        {
          localObject = this.zzid[i];
          if (localObject != null) {
            paramzzrx.zzb(19, (String)localObject);
          }
          i += 1;
        }
      }
      super.zza(paramzzrx);
    }
    
    public zzf zzg(zzrw paramzzrw)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzrw.zzFo();
        int j;
        Object localObject;
        switch (i)
        {
        default: 
          if (zza(paramzzrw, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          j = zzsh.zzc(paramzzrw, 10);
          if (this.zzie == null) {}
          for (i = 0;; i = this.zzie.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzie, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzzrw.readString();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = paramzzrw.readString();
          this.zzie = ((String[])localObject);
          break;
        case 18: 
          j = zzsh.zzc(paramzzrw, 18);
          if (this.zzif == null) {}
          for (i = 0;; i = this.zzif.length)
          {
            localObject = new zzag.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzif, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzag.zza();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zzag.zza();
          paramzzrw.zza(localObject[j]);
          this.zzif = ((zzag.zza[])localObject);
          break;
        case 26: 
          j = zzsh.zzc(paramzzrw, 26);
          if (this.zzig == null) {}
          for (i = 0;; i = this.zzig.length)
          {
            localObject = new zzaf.zze[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzig, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaf.zze();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zzaf.zze();
          paramzzrw.zza(localObject[j]);
          this.zzig = ((zzaf.zze[])localObject);
          break;
        case 34: 
          j = zzsh.zzc(paramzzrw, 34);
          if (this.zzih == null) {}
          for (i = 0;; i = this.zzih.length)
          {
            localObject = new zzaf.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzih, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaf.zzb();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zzaf.zzb();
          paramzzrw.zza(localObject[j]);
          this.zzih = ((zzaf.zzb[])localObject);
          break;
        case 42: 
          j = zzsh.zzc(paramzzrw, 42);
          if (this.zzii == null) {}
          for (i = 0;; i = this.zzii.length)
          {
            localObject = new zzaf.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzii, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaf.zzb();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zzaf.zzb();
          paramzzrw.zza(localObject[j]);
          this.zzii = ((zzaf.zzb[])localObject);
          break;
        case 50: 
          j = zzsh.zzc(paramzzrw, 50);
          if (this.zzij == null) {}
          for (i = 0;; i = this.zzij.length)
          {
            localObject = new zzaf.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzij, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaf.zzb();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zzaf.zzb();
          paramzzrw.zza(localObject[j]);
          this.zzij = ((zzaf.zzb[])localObject);
          break;
        case 58: 
          j = zzsh.zzc(paramzzrw, 58);
          if (this.zzik == null) {}
          for (i = 0;; i = this.zzik.length)
          {
            localObject = new zzaf.zzg[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzik, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzaf.zzg();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zzaf.zzg();
          paramzzrw.zza(localObject[j]);
          this.zzik = ((zzaf.zzg[])localObject);
          break;
        case 74: 
          this.zzil = paramzzrw.readString();
          break;
        case 82: 
          this.zzim = paramzzrw.readString();
          break;
        case 98: 
          this.zzin = paramzzrw.readString();
          break;
        case 106: 
          this.version = paramzzrw.readString();
          break;
        case 114: 
          if (this.zzio == null) {
            this.zzio = new zzaf.zza();
          }
          paramzzrw.zza(this.zzio);
          break;
        case 125: 
          this.zzip = paramzzrw.readFloat();
          break;
        case 130: 
          j = zzsh.zzc(paramzzrw, 130);
          if (this.zzir == null) {}
          for (i = 0;; i = this.zzir.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzir, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzzrw.readString();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = paramzzrw.readString();
          this.zzir = ((String[])localObject);
          break;
        case 136: 
          this.zzis = paramzzrw.zzFr();
          break;
        case 144: 
          this.zziq = paramzzrw.zzFs();
          break;
        case 154: 
          j = zzsh.zzc(paramzzrw, 154);
          if (this.zzid == null) {}
          for (i = 0;; i = this.zzid.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzid, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzzrw.readString();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = paramzzrw.readString();
          this.zzid = ((String[])localObject);
        }
      }
    }
  }
  
  public static final class zzg
    extends zzry<zzg>
  {
    private static volatile zzg[] zzit;
    public int[] zziA;
    public int[] zziB;
    public int[] zziC;
    public int[] zziD;
    public int[] zziu;
    public int[] zziv;
    public int[] zziw;
    public int[] zzix;
    public int[] zziy;
    public int[] zziz;
    
    public zzg()
    {
      zzL();
    }
    
    public static zzg[] zzK()
    {
      if (zzit == null) {}
      synchronized (zzsc.zzbiu)
      {
        if (zzit == null) {
          zzit = new zzg[0];
        }
        return zzit;
      }
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
                            } while (!(paramObject instanceof zzg));
                            paramObject = (zzg)paramObject;
                            bool1 = bool2;
                          } while (!zzsc.equals(this.zziu, ((zzg)paramObject).zziu));
                          bool1 = bool2;
                        } while (!zzsc.equals(this.zziv, ((zzg)paramObject).zziv));
                        bool1 = bool2;
                      } while (!zzsc.equals(this.zziw, ((zzg)paramObject).zziw));
                      bool1 = bool2;
                    } while (!zzsc.equals(this.zzix, ((zzg)paramObject).zzix));
                    bool1 = bool2;
                  } while (!zzsc.equals(this.zziy, ((zzg)paramObject).zziy));
                  bool1 = bool2;
                } while (!zzsc.equals(this.zziz, ((zzg)paramObject).zziz));
                bool1 = bool2;
              } while (!zzsc.equals(this.zziA, ((zzg)paramObject).zziA));
              bool1 = bool2;
            } while (!zzsc.equals(this.zziB, ((zzg)paramObject).zziB));
            bool1 = bool2;
          } while (!zzsc.equals(this.zziC, ((zzg)paramObject).zziC));
          bool1 = bool2;
        } while (!zzsc.equals(this.zziD, ((zzg)paramObject).zziD));
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label223;
        }
        if (((zzg)paramObject).zzbik == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzg)paramObject).zzbik.isEmpty());
      return true;
      label223:
      return this.zzbik.equals(((zzg)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzsc.hashCode(this.zziu);
      int m = zzsc.hashCode(this.zziv);
      int n = zzsc.hashCode(this.zziw);
      int i1 = zzsc.hashCode(this.zzix);
      int i2 = zzsc.hashCode(this.zziy);
      int i3 = zzsc.hashCode(this.zziz);
      int i4 = zzsc.hashCode(this.zziA);
      int i5 = zzsc.hashCode(this.zziB);
      int i6 = zzsc.hashCode(this.zziC);
      int i7 = zzsc.hashCode(this.zziD);
      if ((this.zzbik == null) || (this.zzbik.isEmpty())) {}
      for (int i = 0;; i = this.zzbik.hashCode()) {
        return i + (((((((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31;
      }
    }
    
    protected int zzB()
    {
      int m = 0;
      int k = super.zzB();
      int i;
      if ((this.zziu != null) && (this.zziu.length > 0))
      {
        i = 0;
        j = 0;
        while (i < this.zziu.length)
        {
          j += zzrx.zzlJ(this.zziu[i]);
          i += 1;
        }
      }
      for (int j = k + j + this.zziu.length * 1;; j = k)
      {
        i = j;
        if (this.zziv != null)
        {
          i = j;
          if (this.zziv.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zziv.length)
            {
              k += zzrx.zzlJ(this.zziv[i]);
              i += 1;
            }
            i = j + k + this.zziv.length * 1;
          }
        }
        j = i;
        if (this.zziw != null)
        {
          j = i;
          if (this.zziw.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zziw.length)
            {
              k += zzrx.zzlJ(this.zziw[j]);
              j += 1;
            }
            j = i + k + this.zziw.length * 1;
          }
        }
        i = j;
        if (this.zzix != null)
        {
          i = j;
          if (this.zzix.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zzix.length)
            {
              k += zzrx.zzlJ(this.zzix[i]);
              i += 1;
            }
            i = j + k + this.zzix.length * 1;
          }
        }
        j = i;
        if (this.zziy != null)
        {
          j = i;
          if (this.zziy.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zziy.length)
            {
              k += zzrx.zzlJ(this.zziy[j]);
              j += 1;
            }
            j = i + k + this.zziy.length * 1;
          }
        }
        i = j;
        if (this.zziz != null)
        {
          i = j;
          if (this.zziz.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zziz.length)
            {
              k += zzrx.zzlJ(this.zziz[i]);
              i += 1;
            }
            i = j + k + this.zziz.length * 1;
          }
        }
        j = i;
        if (this.zziA != null)
        {
          j = i;
          if (this.zziA.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zziA.length)
            {
              k += zzrx.zzlJ(this.zziA[j]);
              j += 1;
            }
            j = i + k + this.zziA.length * 1;
          }
        }
        i = j;
        if (this.zziB != null)
        {
          i = j;
          if (this.zziB.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zziB.length)
            {
              k += zzrx.zzlJ(this.zziB[i]);
              i += 1;
            }
            i = j + k + this.zziB.length * 1;
          }
        }
        j = i;
        if (this.zziC != null)
        {
          j = i;
          if (this.zziC.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zziC.length)
            {
              k += zzrx.zzlJ(this.zziC[j]);
              j += 1;
            }
            j = i + k + this.zziC.length * 1;
          }
        }
        i = j;
        if (this.zziD != null)
        {
          i = j;
          if (this.zziD.length > 0)
          {
            k = 0;
            i = m;
            while (i < this.zziD.length)
            {
              k += zzrx.zzlJ(this.zziD[i]);
              i += 1;
            }
            i = j + k + this.zziD.length * 1;
          }
        }
        return i;
      }
    }
    
    public zzg zzL()
    {
      this.zziu = zzsh.zzbix;
      this.zziv = zzsh.zzbix;
      this.zziw = zzsh.zzbix;
      this.zzix = zzsh.zzbix;
      this.zziy = zzsh.zzbix;
      this.zziz = zzsh.zzbix;
      this.zziA = zzsh.zzbix;
      this.zziB = zzsh.zzbix;
      this.zziC = zzsh.zzbix;
      this.zziD = zzsh.zzbix;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      int j = 0;
      int i;
      if ((this.zziu != null) && (this.zziu.length > 0))
      {
        i = 0;
        while (i < this.zziu.length)
        {
          paramzzrx.zzy(1, this.zziu[i]);
          i += 1;
        }
      }
      if ((this.zziv != null) && (this.zziv.length > 0))
      {
        i = 0;
        while (i < this.zziv.length)
        {
          paramzzrx.zzy(2, this.zziv[i]);
          i += 1;
        }
      }
      if ((this.zziw != null) && (this.zziw.length > 0))
      {
        i = 0;
        while (i < this.zziw.length)
        {
          paramzzrx.zzy(3, this.zziw[i]);
          i += 1;
        }
      }
      if ((this.zzix != null) && (this.zzix.length > 0))
      {
        i = 0;
        while (i < this.zzix.length)
        {
          paramzzrx.zzy(4, this.zzix[i]);
          i += 1;
        }
      }
      if ((this.zziy != null) && (this.zziy.length > 0))
      {
        i = 0;
        while (i < this.zziy.length)
        {
          paramzzrx.zzy(5, this.zziy[i]);
          i += 1;
        }
      }
      if ((this.zziz != null) && (this.zziz.length > 0))
      {
        i = 0;
        while (i < this.zziz.length)
        {
          paramzzrx.zzy(6, this.zziz[i]);
          i += 1;
        }
      }
      if ((this.zziA != null) && (this.zziA.length > 0))
      {
        i = 0;
        while (i < this.zziA.length)
        {
          paramzzrx.zzy(7, this.zziA[i]);
          i += 1;
        }
      }
      if ((this.zziB != null) && (this.zziB.length > 0))
      {
        i = 0;
        while (i < this.zziB.length)
        {
          paramzzrx.zzy(8, this.zziB[i]);
          i += 1;
        }
      }
      if ((this.zziC != null) && (this.zziC.length > 0))
      {
        i = 0;
        while (i < this.zziC.length)
        {
          paramzzrx.zzy(9, this.zziC[i]);
          i += 1;
        }
      }
      if ((this.zziD != null) && (this.zziD.length > 0))
      {
        i = j;
        while (i < this.zziD.length)
        {
          paramzzrx.zzy(10, this.zziD[i]);
          i += 1;
        }
      }
      super.zza(paramzzrx);
    }
    
    public zzg zzh(zzrw paramzzrw)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzrw.zzFo();
        int j;
        int[] arrayOfInt;
        int k;
        switch (i)
        {
        default: 
          if (zza(paramzzrw, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          j = zzsh.zzc(paramzzrw, 8);
          if (this.zziu == null) {}
          for (i = 0;; i = this.zziu.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziu, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zziu = arrayOfInt;
          break;
        case 10: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zziu == null) {}
          for (i = 0;; i = this.zziu.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziu, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zziu = arrayOfInt;
          paramzzrw.zzlD(k);
          break;
        case 16: 
          j = zzsh.zzc(paramzzrw, 16);
          if (this.zziv == null) {}
          for (i = 0;; i = this.zziv.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziv, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zziv = arrayOfInt;
          break;
        case 18: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zziv == null) {}
          for (i = 0;; i = this.zziv.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziv, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zziv = arrayOfInt;
          paramzzrw.zzlD(k);
          break;
        case 24: 
          j = zzsh.zzc(paramzzrw, 24);
          if (this.zziw == null) {}
          for (i = 0;; i = this.zziw.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziw, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zziw = arrayOfInt;
          break;
        case 26: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zziw == null) {}
          for (i = 0;; i = this.zziw.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziw, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zziw = arrayOfInt;
          paramzzrw.zzlD(k);
          break;
        case 32: 
          j = zzsh.zzc(paramzzrw, 32);
          if (this.zzix == null) {}
          for (i = 0;; i = this.zzix.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzix, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zzix = arrayOfInt;
          break;
        case 34: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zzix == null) {}
          for (i = 0;; i = this.zzix.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzix, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zzix = arrayOfInt;
          paramzzrw.zzlD(k);
          break;
        case 40: 
          j = zzsh.zzc(paramzzrw, 40);
          if (this.zziy == null) {}
          for (i = 0;; i = this.zziy.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziy, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zziy = arrayOfInt;
          break;
        case 42: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zziy == null) {}
          for (i = 0;; i = this.zziy.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziy, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zziy = arrayOfInt;
          paramzzrw.zzlD(k);
          break;
        case 48: 
          j = zzsh.zzc(paramzzrw, 48);
          if (this.zziz == null) {}
          for (i = 0;; i = this.zziz.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziz, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zziz = arrayOfInt;
          break;
        case 50: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zziz == null) {}
          for (i = 0;; i = this.zziz.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziz, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zziz = arrayOfInt;
          paramzzrw.zzlD(k);
          break;
        case 56: 
          j = zzsh.zzc(paramzzrw, 56);
          if (this.zziA == null) {}
          for (i = 0;; i = this.zziA.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziA, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zziA = arrayOfInt;
          break;
        case 58: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zziA == null) {}
          for (i = 0;; i = this.zziA.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziA, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zziA = arrayOfInt;
          paramzzrw.zzlD(k);
          break;
        case 64: 
          j = zzsh.zzc(paramzzrw, 64);
          if (this.zziB == null) {}
          for (i = 0;; i = this.zziB.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziB, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zziB = arrayOfInt;
          break;
        case 66: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zziB == null) {}
          for (i = 0;; i = this.zziB.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziB, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zziB = arrayOfInt;
          paramzzrw.zzlD(k);
          break;
        case 72: 
          j = zzsh.zzc(paramzzrw, 72);
          if (this.zziC == null) {}
          for (i = 0;; i = this.zziC.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziC, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zziC = arrayOfInt;
          break;
        case 74: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zziC == null) {}
          for (i = 0;; i = this.zziC.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziC, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zziC = arrayOfInt;
          paramzzrw.zzlD(k);
          break;
        case 80: 
          j = zzsh.zzc(paramzzrw, 80);
          if (this.zziD == null) {}
          for (i = 0;; i = this.zziD.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziD, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zziD = arrayOfInt;
          break;
        case 82: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zziD == null) {}
          for (i = 0;; i = this.zziD.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziD, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zziD = arrayOfInt;
          paramzzrw.zzlD(k);
        }
      }
    }
  }
  
  public static final class zzh
    extends zzry<zzh>
  {
    public static final zzrz<zzag.zza, zzh> zziE = zzrz.zza(11, zzh.class, 810L);
    private static final zzh[] zziF = new zzh[0];
    public int[] zziG;
    public int[] zziH;
    public int[] zziI;
    public int zziJ;
    public int[] zziK;
    public int zziL;
    public int zziM;
    
    public zzh()
    {
      zzM();
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
                  do
                  {
                    do
                    {
                      do
                      {
                        return bool1;
                        bool1 = bool2;
                      } while (!(paramObject instanceof zzh));
                      paramObject = (zzh)paramObject;
                      bool1 = bool2;
                    } while (!zzsc.equals(this.zziG, ((zzh)paramObject).zziG));
                    bool1 = bool2;
                  } while (!zzsc.equals(this.zziH, ((zzh)paramObject).zziH));
                  bool1 = bool2;
                } while (!zzsc.equals(this.zziI, ((zzh)paramObject).zziI));
                bool1 = bool2;
              } while (this.zziJ != ((zzh)paramObject).zziJ);
              bool1 = bool2;
            } while (!zzsc.equals(this.zziK, ((zzh)paramObject).zziK));
            bool1 = bool2;
          } while (this.zziL != ((zzh)paramObject).zziL);
          bool1 = bool2;
        } while (this.zziM != ((zzh)paramObject).zziM);
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label166;
        }
        if (((zzh)paramObject).zzbik == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzh)paramObject).zzbik.isEmpty());
      return true;
      label166:
      return this.zzbik.equals(((zzh)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzsc.hashCode(this.zziG);
      int m = zzsc.hashCode(this.zziH);
      int n = zzsc.hashCode(this.zziI);
      int i1 = this.zziJ;
      int i2 = zzsc.hashCode(this.zziK);
      int i3 = this.zziL;
      int i4 = this.zziM;
      if ((this.zzbik == null) || (this.zzbik.isEmpty())) {}
      for (int i = 0;; i = this.zzbik.hashCode()) {
        return i + ((((((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31;
      }
    }
    
    protected int zzB()
    {
      int m = 0;
      int k = super.zzB();
      int i;
      if ((this.zziG != null) && (this.zziG.length > 0))
      {
        i = 0;
        j = 0;
        while (i < this.zziG.length)
        {
          j += zzrx.zzlJ(this.zziG[i]);
          i += 1;
        }
      }
      for (int j = k + j + this.zziG.length * 1;; j = k)
      {
        i = j;
        if (this.zziH != null)
        {
          i = j;
          if (this.zziH.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zziH.length)
            {
              k += zzrx.zzlJ(this.zziH[i]);
              i += 1;
            }
            i = j + k + this.zziH.length * 1;
          }
        }
        j = i;
        if (this.zziI != null)
        {
          j = i;
          if (this.zziI.length > 0)
          {
            j = 0;
            k = 0;
            while (j < this.zziI.length)
            {
              k += zzrx.zzlJ(this.zziI[j]);
              j += 1;
            }
            j = i + k + this.zziI.length * 1;
          }
        }
        i = j;
        if (this.zziJ != 0) {
          i = j + zzrx.zzA(4, this.zziJ);
        }
        j = i;
        if (this.zziK != null)
        {
          j = i;
          if (this.zziK.length > 0)
          {
            k = 0;
            j = m;
            while (j < this.zziK.length)
            {
              k += zzrx.zzlJ(this.zziK[j]);
              j += 1;
            }
            j = i + k + this.zziK.length * 1;
          }
        }
        i = j;
        if (this.zziL != 0) {
          i = j + zzrx.zzA(6, this.zziL);
        }
        j = i;
        if (this.zziM != 0) {
          j = i + zzrx.zzA(7, this.zziM);
        }
        return j;
      }
    }
    
    public zzh zzM()
    {
      this.zziG = zzsh.zzbix;
      this.zziH = zzsh.zzbix;
      this.zziI = zzsh.zzbix;
      this.zziJ = 0;
      this.zziK = zzsh.zzbix;
      this.zziL = 0;
      this.zziM = 0;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      int j = 0;
      int i;
      if ((this.zziG != null) && (this.zziG.length > 0))
      {
        i = 0;
        while (i < this.zziG.length)
        {
          paramzzrx.zzy(1, this.zziG[i]);
          i += 1;
        }
      }
      if ((this.zziH != null) && (this.zziH.length > 0))
      {
        i = 0;
        while (i < this.zziH.length)
        {
          paramzzrx.zzy(2, this.zziH[i]);
          i += 1;
        }
      }
      if ((this.zziI != null) && (this.zziI.length > 0))
      {
        i = 0;
        while (i < this.zziI.length)
        {
          paramzzrx.zzy(3, this.zziI[i]);
          i += 1;
        }
      }
      if (this.zziJ != 0) {
        paramzzrx.zzy(4, this.zziJ);
      }
      if ((this.zziK != null) && (this.zziK.length > 0))
      {
        i = j;
        while (i < this.zziK.length)
        {
          paramzzrx.zzy(5, this.zziK[i]);
          i += 1;
        }
      }
      if (this.zziL != 0) {
        paramzzrx.zzy(6, this.zziL);
      }
      if (this.zziM != 0) {
        paramzzrx.zzy(7, this.zziM);
      }
      super.zza(paramzzrx);
    }
    
    public zzh zzi(zzrw paramzzrw)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzrw.zzFo();
        int j;
        int[] arrayOfInt;
        int k;
        switch (i)
        {
        default: 
          if (zza(paramzzrw, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          j = zzsh.zzc(paramzzrw, 8);
          if (this.zziG == null) {}
          for (i = 0;; i = this.zziG.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziG, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zziG = arrayOfInt;
          break;
        case 10: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zziG == null) {}
          for (i = 0;; i = this.zziG.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziG, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zziG = arrayOfInt;
          paramzzrw.zzlD(k);
          break;
        case 16: 
          j = zzsh.zzc(paramzzrw, 16);
          if (this.zziH == null) {}
          for (i = 0;; i = this.zziH.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziH, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zziH = arrayOfInt;
          break;
        case 18: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zziH == null) {}
          for (i = 0;; i = this.zziH.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziH, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zziH = arrayOfInt;
          paramzzrw.zzlD(k);
          break;
        case 24: 
          j = zzsh.zzc(paramzzrw, 24);
          if (this.zziI == null) {}
          for (i = 0;; i = this.zziI.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziI, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zziI = arrayOfInt;
          break;
        case 26: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zziI == null) {}
          for (i = 0;; i = this.zziI.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziI, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zziI = arrayOfInt;
          paramzzrw.zzlD(k);
          break;
        case 32: 
          this.zziJ = paramzzrw.zzFr();
          break;
        case 40: 
          j = zzsh.zzc(paramzzrw, 40);
          if (this.zziK == null) {}
          for (i = 0;; i = this.zziK.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziK, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length - 1)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfInt[j] = paramzzrw.zzFr();
          this.zziK = arrayOfInt;
          break;
        case 42: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zziK == null) {}
          for (i = 0;; i = this.zziK.length)
          {
            arrayOfInt = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziK, 0, arrayOfInt, 0, i);
              j = i;
            }
            while (j < arrayOfInt.length)
            {
              arrayOfInt[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zziK = arrayOfInt;
          paramzzrw.zzlD(k);
          break;
        case 48: 
          this.zziL = paramzzrw.zzFr();
          break;
        case 56: 
          this.zziM = paramzzrw.zzFr();
        }
      }
    }
  }
  
  public static final class zzi
    extends zzry<zzi>
  {
    private static volatile zzi[] zziN;
    public String name;
    public zzag.zza zziO;
    public zzaf.zzd zziP;
    
    public zzi()
    {
      zzO();
    }
    
    public static zzi[] zzN()
    {
      if (zziN == null) {}
      synchronized (zzsc.zzbiu)
      {
        if (zziN == null) {
          zziN = new zzi[0];
        }
        return zziN;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label41:
      label57:
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
            } while (!(paramObject instanceof zzi));
            paramObject = (zzi)paramObject;
            if (this.name != null) {
              break;
            }
            bool1 = bool2;
          } while (((zzi)paramObject).name != null);
          if (this.zziO != null) {
            break label127;
          }
          bool1 = bool2;
        } while (((zzi)paramObject).zziO != null);
        if (this.zziP != null) {
          break label143;
        }
        bool1 = bool2;
      } while (((zzi)paramObject).zziP != null);
      for (;;)
      {
        if ((this.zzbik == null) || (this.zzbik.isEmpty()))
        {
          if (((zzi)paramObject).zzbik != null)
          {
            bool1 = bool2;
            if (!((zzi)paramObject).zzbik.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.name.equals(((zzi)paramObject).name)) {
            break label41;
          }
          return false;
          label127:
          if (this.zziO.equals(((zzi)paramObject).zziO)) {
            break label57;
          }
          return false;
          label143:
          if (!this.zziP.equals(((zzi)paramObject).zziP)) {
            return false;
          }
        }
      }
      return this.zzbik.equals(((zzi)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int n = 0;
      int i1 = getClass().getName().hashCode();
      int i;
      int j;
      label33:
      int k;
      if (this.name == null)
      {
        i = 0;
        if (this.zziO != null) {
          break label106;
        }
        j = 0;
        if (this.zziP != null) {
          break label117;
        }
        k = 0;
        label42:
        m = n;
        if (this.zzbik != null) {
          if (!this.zzbik.isEmpty()) {
            break label128;
          }
        }
      }
      label106:
      label117:
      label128:
      for (int m = n;; m = this.zzbik.hashCode())
      {
        return (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31 + m;
        i = this.name.hashCode();
        break;
        j = this.zziO.hashCode();
        break label33;
        k = this.zziP.hashCode();
        break label42;
      }
    }
    
    protected int zzB()
    {
      int j = super.zzB();
      int i = j;
      if (!this.name.equals("")) {
        i = j + zzrx.zzn(1, this.name);
      }
      j = i;
      if (this.zziO != null) {
        j = i + zzrx.zzc(2, this.zziO);
      }
      i = j;
      if (this.zziP != null) {
        i = j + zzrx.zzc(3, this.zziP);
      }
      return i;
    }
    
    public zzi zzO()
    {
      this.name = "";
      this.zziO = null;
      this.zziP = null;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if (!this.name.equals("")) {
        paramzzrx.zzb(1, this.name);
      }
      if (this.zziO != null) {
        paramzzrx.zza(2, this.zziO);
      }
      if (this.zziP != null) {
        paramzzrx.zza(3, this.zziP);
      }
      super.zza(paramzzrx);
    }
    
    public zzi zzj(zzrw paramzzrw)
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
        case 10: 
          this.name = paramzzrw.readString();
          break;
        case 18: 
          if (this.zziO == null) {
            this.zziO = new zzag.zza();
          }
          paramzzrw.zza(this.zziO);
          break;
        case 26: 
          if (this.zziP == null) {
            this.zziP = new zzaf.zzd();
          }
          paramzzrw.zza(this.zziP);
        }
      }
    }
  }
  
  public static final class zzj
    extends zzry<zzj>
  {
    public zzaf.zzi[] zziQ;
    public zzaf.zzf zziR;
    public String zziS;
    
    public zzj()
    {
      zzP();
    }
    
    public static zzj zzd(byte[] paramArrayOfByte)
      throws zzsd
    {
      return (zzj)zzse.zza(new zzj(), paramArrayOfByte);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label57:
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
            } while (!(paramObject instanceof zzj));
            paramObject = (zzj)paramObject;
            bool1 = bool2;
          } while (!zzsc.equals(this.zziQ, ((zzj)paramObject).zziQ));
          if (this.zziR != null) {
            break;
          }
          bool1 = bool2;
        } while (((zzj)paramObject).zziR != null);
        if (this.zziS != null) {
          break label127;
        }
        bool1 = bool2;
      } while (((zzj)paramObject).zziS != null);
      for (;;)
      {
        if ((this.zzbik == null) || (this.zzbik.isEmpty()))
        {
          if (((zzj)paramObject).zzbik != null)
          {
            bool1 = bool2;
            if (!((zzj)paramObject).zzbik.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.zziR.equals(((zzj)paramObject).zziR)) {
            break label57;
          }
          return false;
          label127:
          if (!this.zziS.equals(((zzj)paramObject).zziS)) {
            return false;
          }
        }
      }
      return this.zzbik.equals(((zzj)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = zzsc.hashCode(this.zziQ);
      int i;
      int j;
      if (this.zziR == null)
      {
        i = 0;
        if (this.zziS != null) {
          break label104;
        }
        j = 0;
        label42:
        k = m;
        if (this.zzbik != null) {
          if (!this.zzbik.isEmpty()) {
            break label115;
          }
        }
      }
      label104:
      label115:
      for (int k = m;; k = this.zzbik.hashCode())
      {
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
        i = this.zziR.hashCode();
        break;
        j = this.zziS.hashCode();
        break label42;
      }
    }
    
    protected int zzB()
    {
      int i = super.zzB();
      int j = i;
      if (this.zziQ != null)
      {
        j = i;
        if (this.zziQ.length > 0)
        {
          int k = 0;
          for (;;)
          {
            j = i;
            if (k >= this.zziQ.length) {
              break;
            }
            zzaf.zzi localzzi = this.zziQ[k];
            j = i;
            if (localzzi != null) {
              j = i + zzrx.zzc(1, localzzi);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.zziR != null) {
        i = j + zzrx.zzc(2, this.zziR);
      }
      j = i;
      if (!this.zziS.equals("")) {
        j = i + zzrx.zzn(3, this.zziS);
      }
      return j;
    }
    
    public zzj zzP()
    {
      this.zziQ = zzaf.zzi.zzN();
      this.zziR = null;
      this.zziS = "";
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if ((this.zziQ != null) && (this.zziQ.length > 0))
      {
        int i = 0;
        while (i < this.zziQ.length)
        {
          zzaf.zzi localzzi = this.zziQ[i];
          if (localzzi != null) {
            paramzzrx.zza(1, localzzi);
          }
          i += 1;
        }
      }
      if (this.zziR != null) {
        paramzzrx.zza(2, this.zziR);
      }
      if (!this.zziS.equals("")) {
        paramzzrx.zzb(3, this.zziS);
      }
      super.zza(paramzzrx);
    }
    
    public zzj zzk(zzrw paramzzrw)
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
        case 10: 
          int j = zzsh.zzc(paramzzrw, 10);
          if (this.zziQ == null) {}
          zzaf.zzi[] arrayOfzzi;
          for (i = 0;; i = this.zziQ.length)
          {
            arrayOfzzi = new zzaf.zzi[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zziQ, 0, arrayOfzzi, 0, i);
              j = i;
            }
            while (j < arrayOfzzi.length - 1)
            {
              arrayOfzzi[j] = new zzaf.zzi();
              paramzzrw.zza(arrayOfzzi[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfzzi[j] = new zzaf.zzi();
          paramzzrw.zza(arrayOfzzi[j]);
          this.zziQ = arrayOfzzi;
          break;
        case 18: 
          if (this.zziR == null) {
            this.zziR = new zzaf.zzf();
          }
          paramzzrw.zza(this.zziR);
          break;
        case 26: 
          this.zziS = paramzzrw.readString();
        }
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */