package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public abstract interface zzsi
{
  public static final class zza
    extends zzry<zza>
  {
    public String[] zzbiF;
    public String[] zzbiG;
    public int[] zzbiH;
    public long[] zzbiI;
    
    public zza()
    {
      zzFS();
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
                } while (!(paramObject instanceof zza));
                paramObject = (zza)paramObject;
                bool1 = bool2;
              } while (!zzsc.equals(this.zzbiF, ((zza)paramObject).zzbiF));
              bool1 = bool2;
            } while (!zzsc.equals(this.zzbiG, ((zza)paramObject).zzbiG));
            bool1 = bool2;
          } while (!zzsc.equals(this.zzbiH, ((zza)paramObject).zzbiH));
          bool1 = bool2;
        } while (!zzsc.equals(this.zzbiI, ((zza)paramObject).zzbiI));
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label127;
        }
        if (((zza)paramObject).zzbik == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zza)paramObject).zzbik.isEmpty());
      return true;
      label127:
      return this.zzbik.equals(((zza)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzsc.hashCode(this.zzbiF);
      int m = zzsc.hashCode(this.zzbiG);
      int n = zzsc.hashCode(this.zzbiH);
      int i1 = zzsc.hashCode(this.zzbiI);
      if ((this.zzbik == null) || (this.zzbik.isEmpty())) {}
      for (int i = 0;; i = this.zzbik.hashCode()) {
        return i + (((((j + 527) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31;
      }
    }
    
    protected int zzB()
    {
      int i2 = 0;
      int i1 = super.zzB();
      int j;
      int k;
      String str;
      int n;
      int m;
      if ((this.zzbiF != null) && (this.zzbiF.length > 0))
      {
        i = 0;
        j = 0;
        for (k = 0; i < this.zzbiF.length; k = m)
        {
          str = this.zzbiF[i];
          n = j;
          m = k;
          if (str != null)
          {
            m = k + 1;
            n = j + zzrx.zzfA(str);
          }
          i += 1;
          j = n;
        }
      }
      for (int i = i1 + j + k * 1;; i = i1)
      {
        j = i;
        if (this.zzbiG != null)
        {
          j = i;
          if (this.zzbiG.length > 0)
          {
            j = 0;
            k = 0;
            for (m = 0; j < this.zzbiG.length; m = n)
            {
              str = this.zzbiG[j];
              i1 = k;
              n = m;
              if (str != null)
              {
                n = m + 1;
                i1 = k + zzrx.zzfA(str);
              }
              j += 1;
              k = i1;
            }
            j = i + k + m * 1;
          }
        }
        i = j;
        if (this.zzbiH != null)
        {
          i = j;
          if (this.zzbiH.length > 0)
          {
            i = 0;
            k = 0;
            while (i < this.zzbiH.length)
            {
              k += zzrx.zzlJ(this.zzbiH[i]);
              i += 1;
            }
            i = j + k + this.zzbiH.length * 1;
          }
        }
        j = i;
        if (this.zzbiI != null)
        {
          j = i;
          if (this.zzbiI.length > 0)
          {
            k = 0;
            j = i2;
            while (j < this.zzbiI.length)
            {
              k += zzrx.zzaa(this.zzbiI[j]);
              j += 1;
            }
            j = i + k + this.zzbiI.length * 1;
          }
        }
        return j;
      }
    }
    
    public zza zzFS()
    {
      this.zzbiF = zzsh.zzbiC;
      this.zzbiG = zzsh.zzbiC;
      this.zzbiH = zzsh.zzbix;
      this.zzbiI = zzsh.zzbiy;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public zza zzG(zzrw paramzzrw)
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
        case 10: 
          j = zzsh.zzc(paramzzrw, 10);
          if (this.zzbiF == null) {}
          for (i = 0;; i = this.zzbiF.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbiF, 0, localObject, 0, i);
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
          this.zzbiF = ((String[])localObject);
          break;
        case 18: 
          j = zzsh.zzc(paramzzrw, 18);
          if (this.zzbiG == null) {}
          for (i = 0;; i = this.zzbiG.length)
          {
            localObject = new String[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbiG, 0, localObject, 0, i);
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
          this.zzbiG = ((String[])localObject);
          break;
        case 24: 
          j = zzsh.zzc(paramzzrw, 24);
          if (this.zzbiH == null) {}
          for (i = 0;; i = this.zzbiH.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbiH, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = paramzzrw.zzFr();
          this.zzbiH = ((int[])localObject);
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
          if (this.zzbiH == null) {}
          for (i = 0;; i = this.zzbiH.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbiH, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zzbiH = ((int[])localObject);
          paramzzrw.zzlD(k);
          break;
        case 32: 
          j = zzsh.zzc(paramzzrw, 32);
          if (this.zzbiI == null) {}
          for (i = 0;; i = this.zzbiI.length)
          {
            localObject = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbiI, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzzrw.zzFq();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = paramzzrw.zzFq();
          this.zzbiI = ((long[])localObject);
          break;
        case 34: 
          k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFq();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zzbiI == null) {}
          for (i = 0;; i = this.zzbiI.length)
          {
            localObject = new long[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbiI, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = paramzzrw.zzFq();
              j += 1;
            }
          }
          this.zzbiI = ((long[])localObject);
          paramzzrw.zzlD(k);
        }
      }
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      int j = 0;
      int i;
      String str;
      if ((this.zzbiF != null) && (this.zzbiF.length > 0))
      {
        i = 0;
        while (i < this.zzbiF.length)
        {
          str = this.zzbiF[i];
          if (str != null) {
            paramzzrx.zzb(1, str);
          }
          i += 1;
        }
      }
      if ((this.zzbiG != null) && (this.zzbiG.length > 0))
      {
        i = 0;
        while (i < this.zzbiG.length)
        {
          str = this.zzbiG[i];
          if (str != null) {
            paramzzrx.zzb(2, str);
          }
          i += 1;
        }
      }
      if ((this.zzbiH != null) && (this.zzbiH.length > 0))
      {
        i = 0;
        while (i < this.zzbiH.length)
        {
          paramzzrx.zzy(3, this.zzbiH[i]);
          i += 1;
        }
      }
      if ((this.zzbiI != null) && (this.zzbiI.length > 0))
      {
        i = j;
        while (i < this.zzbiI.length)
        {
          paramzzrx.zzb(4, this.zzbiI[i]);
          i += 1;
        }
      }
      super.zza(paramzzrx);
    }
  }
  
  public static final class zzb
    extends zzry<zzb>
  {
    public String version;
    public int zzbiJ;
    public String zzbiK;
    
    public zzb()
    {
      zzFT();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label54:
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
          } while (this.zzbiJ != ((zzb)paramObject).zzbiJ);
          if (this.zzbiK != null) {
            break;
          }
          bool1 = bool2;
        } while (((zzb)paramObject).zzbiK != null);
        if (this.version != null) {
          break label124;
        }
        bool1 = bool2;
      } while (((zzb)paramObject).version != null);
      for (;;)
      {
        if ((this.zzbik == null) || (this.zzbik.isEmpty()))
        {
          if (((zzb)paramObject).zzbik != null)
          {
            bool1 = bool2;
            if (!((zzb)paramObject).zzbik.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.zzbiK.equals(((zzb)paramObject).zzbiK)) {
            break label54;
          }
          return false;
          label124:
          if (!this.version.equals(((zzb)paramObject).version)) {
            return false;
          }
        }
      }
      return this.zzbik.equals(((zzb)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = this.zzbiJ;
      int i;
      int j;
      if (this.zzbiK == null)
      {
        i = 0;
        if (this.version != null) {
          break label101;
        }
        j = 0;
        label39:
        k = m;
        if (this.zzbik != null) {
          if (!this.zzbik.isEmpty()) {
            break label112;
          }
        }
      }
      label101:
      label112:
      for (int k = m;; k = this.zzbik.hashCode())
      {
        return (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31 + k;
        i = this.zzbiK.hashCode();
        break;
        j = this.version.hashCode();
        break label39;
      }
    }
    
    protected int zzB()
    {
      int j = super.zzB();
      int i = j;
      if (this.zzbiJ != 0) {
        i = j + zzrx.zzA(1, this.zzbiJ);
      }
      j = i;
      if (!this.zzbiK.equals("")) {
        j = i + zzrx.zzn(2, this.zzbiK);
      }
      i = j;
      if (!this.version.equals("")) {
        i = j + zzrx.zzn(3, this.version);
      }
      return i;
    }
    
    public zzb zzFT()
    {
      this.zzbiJ = 0;
      this.zzbiK = "";
      this.version = "";
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public zzb zzH(zzrw paramzzrw)
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
          case 0: 
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
          case 18: 
          case 19: 
          case 20: 
          case 21: 
          case 22: 
          case 23: 
          case 24: 
          case 25: 
          case 26: 
            this.zzbiJ = i;
          }
          break;
        case 18: 
          this.zzbiK = paramzzrw.readString();
          break;
        case 26: 
          this.version = paramzzrw.readString();
        }
      }
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if (this.zzbiJ != 0) {
        paramzzrx.zzy(1, this.zzbiJ);
      }
      if (!this.zzbiK.equals("")) {
        paramzzrx.zzb(2, this.zzbiK);
      }
      if (!this.version.equals("")) {
        paramzzrx.zzb(3, this.version);
      }
      super.zza(paramzzrx);
    }
  }
  
  public static final class zzc
    extends zzry<zzc>
  {
    public byte[] zzbiL;
    public byte[][] zzbiM;
    public boolean zzbiN;
    
    public zzc()
    {
      zzFU();
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
              } while (!(paramObject instanceof zzc));
              paramObject = (zzc)paramObject;
              bool1 = bool2;
            } while (!Arrays.equals(this.zzbiL, ((zzc)paramObject).zzbiL));
            bool1 = bool2;
          } while (!zzsc.zza(this.zzbiM, ((zzc)paramObject).zzbiM));
          bool1 = bool2;
        } while (this.zzbiN != ((zzc)paramObject).zzbiN);
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label108;
        }
        if (((zzc)paramObject).zzbik == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zzc)paramObject).zzbik.isEmpty());
      return true;
      label108:
      return this.zzbik.equals(((zzc)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int k = getClass().getName().hashCode();
      int m = Arrays.hashCode(this.zzbiL);
      int n = zzsc.zza(this.zzbiM);
      int i;
      if (this.zzbiN)
      {
        i = 1231;
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label94;
        }
      }
      label94:
      for (int j = 0;; j = this.zzbik.hashCode())
      {
        return j + (i + (((k + 527) * 31 + m) * 31 + n) * 31) * 31;
        i = 1237;
        break;
      }
    }
    
    protected int zzB()
    {
      int n = 0;
      int j = super.zzB();
      int i = j;
      if (!Arrays.equals(this.zzbiL, zzsh.zzbiE)) {
        i = j + zzrx.zzb(1, this.zzbiL);
      }
      j = i;
      if (this.zzbiM != null)
      {
        j = i;
        if (this.zzbiM.length > 0)
        {
          int k = 0;
          int m = 0;
          j = n;
          while (j < this.zzbiM.length)
          {
            byte[] arrayOfByte = this.zzbiM[j];
            int i1 = k;
            n = m;
            if (arrayOfByte != null)
            {
              n = m + 1;
              i1 = k + zzrx.zzE(arrayOfByte);
            }
            j += 1;
            k = i1;
            m = n;
          }
          j = i + k + m * 1;
        }
      }
      i = j;
      if (this.zzbiN) {
        i = j + zzrx.zzc(3, this.zzbiN);
      }
      return i;
    }
    
    public zzc zzFU()
    {
      this.zzbiL = zzsh.zzbiE;
      this.zzbiM = zzsh.zzbiD;
      this.zzbiN = false;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public zzc zzI(zzrw paramzzrw)
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
          this.zzbiL = paramzzrw.readBytes();
          break;
        case 18: 
          int j = zzsh.zzc(paramzzrw, 18);
          if (this.zzbiM == null) {}
          byte[][] arrayOfByte;
          for (i = 0;; i = this.zzbiM.length)
          {
            arrayOfByte = new byte[j + i][];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbiM, 0, arrayOfByte, 0, i);
              j = i;
            }
            while (j < arrayOfByte.length - 1)
            {
              arrayOfByte[j] = paramzzrw.readBytes();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfByte[j] = paramzzrw.readBytes();
          this.zzbiM = arrayOfByte;
          break;
        case 24: 
          this.zzbiN = paramzzrw.zzFs();
        }
      }
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if (!Arrays.equals(this.zzbiL, zzsh.zzbiE)) {
        paramzzrx.zza(1, this.zzbiL);
      }
      if ((this.zzbiM != null) && (this.zzbiM.length > 0))
      {
        int i = 0;
        while (i < this.zzbiM.length)
        {
          byte[] arrayOfByte = this.zzbiM[i];
          if (arrayOfByte != null) {
            paramzzrx.zza(2, arrayOfByte);
          }
          i += 1;
        }
      }
      if (this.zzbiN) {
        paramzzrx.zzb(3, this.zzbiN);
      }
      super.zza(paramzzrx);
    }
  }
  
  public static final class zzd
    extends zzry<zzd>
  {
    public String tag;
    public long zzbiO;
    public long zzbiP;
    public int zzbiQ;
    public int zzbiR;
    public boolean zzbiS;
    public zzsi.zze[] zzbiT;
    public zzsi.zzb zzbiU;
    public byte[] zzbiV;
    public byte[] zzbiW;
    public byte[] zzbiX;
    public zzsi.zza zzbiY;
    public String zzbiZ;
    public long zzbja;
    public zzsi.zzc zzbjb;
    public byte[] zzbjc;
    public int zzbjd;
    public int[] zzbje;
    
    public zzd()
    {
      zzFV();
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramObject == this) {
        bool1 = true;
      }
      label69:
      label140:
      label204:
      label220:
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
                                  do
                                  {
                                    do
                                    {
                                      return bool1;
                                      bool1 = bool2;
                                    } while (!(paramObject instanceof zzd));
                                    paramObject = (zzd)paramObject;
                                    bool1 = bool2;
                                  } while (this.zzbiO != ((zzd)paramObject).zzbiO);
                                  bool1 = bool2;
                                } while (this.zzbiP != ((zzd)paramObject).zzbiP);
                                if (this.tag != null) {
                                  break;
                                }
                                bool1 = bool2;
                              } while (((zzd)paramObject).tag != null);
                              bool1 = bool2;
                            } while (this.zzbiQ != ((zzd)paramObject).zzbiQ);
                            bool1 = bool2;
                          } while (this.zzbiR != ((zzd)paramObject).zzbiR);
                          bool1 = bool2;
                        } while (this.zzbiS != ((zzd)paramObject).zzbiS);
                        bool1 = bool2;
                      } while (!zzsc.equals(this.zzbiT, ((zzd)paramObject).zzbiT));
                      if (this.zzbiU != null) {
                        break label349;
                      }
                      bool1 = bool2;
                    } while (((zzd)paramObject).zzbiU != null);
                    bool1 = bool2;
                  } while (!Arrays.equals(this.zzbiV, ((zzd)paramObject).zzbiV));
                  bool1 = bool2;
                } while (!Arrays.equals(this.zzbiW, ((zzd)paramObject).zzbiW));
                bool1 = bool2;
              } while (!Arrays.equals(this.zzbiX, ((zzd)paramObject).zzbiX));
              if (this.zzbiY != null) {
                break label365;
              }
              bool1 = bool2;
            } while (((zzd)paramObject).zzbiY != null);
            if (this.zzbiZ != null) {
              break label381;
            }
            bool1 = bool2;
          } while (((zzd)paramObject).zzbiZ != null);
          bool1 = bool2;
        } while (this.zzbja != ((zzd)paramObject).zzbja);
        if (this.zzbjb != null) {
          break label397;
        }
        bool1 = bool2;
      } while (((zzd)paramObject).zzbjb != null);
      label349:
      label365:
      label381:
      label397:
      while (this.zzbjb.equals(((zzd)paramObject).zzbjb))
      {
        bool1 = bool2;
        if (!Arrays.equals(this.zzbjc, ((zzd)paramObject).zzbjc)) {
          break;
        }
        bool1 = bool2;
        if (this.zzbjd != ((zzd)paramObject).zzbjd) {
          break;
        }
        bool1 = bool2;
        if (!zzsc.equals(this.zzbje, ((zzd)paramObject).zzbje)) {
          break;
        }
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label413;
        }
        if (((zzd)paramObject).zzbik != null)
        {
          bool1 = bool2;
          if (!((zzd)paramObject).zzbik.isEmpty()) {
            break;
          }
        }
        return true;
        if (this.tag.equals(((zzd)paramObject).tag)) {
          break label69;
        }
        return false;
        if (this.zzbiU.equals(((zzd)paramObject).zzbiU)) {
          break label140;
        }
        return false;
        if (this.zzbiY.equals(((zzd)paramObject).zzbiY)) {
          break label204;
        }
        return false;
        if (this.zzbiZ.equals(((zzd)paramObject).zzbiZ)) {
          break label220;
        }
        return false;
      }
      return false;
      label413:
      return this.zzbik.equals(((zzd)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int i3 = 0;
      int i4 = getClass().getName().hashCode();
      int i5 = (int)(this.zzbiO ^ this.zzbiO >>> 32);
      int i6 = (int)(this.zzbiP ^ this.zzbiP >>> 32);
      int i;
      int i7;
      int i8;
      int j;
      label77:
      int i9;
      int k;
      label95:
      int i10;
      int i11;
      int i12;
      int m;
      label132:
      int n;
      label142:
      int i13;
      int i1;
      label167:
      int i14;
      int i15;
      int i16;
      if (this.tag == null)
      {
        i = 0;
        i7 = this.zzbiQ;
        i8 = this.zzbiR;
        if (!this.zzbiS) {
          break label345;
        }
        j = 1231;
        i9 = zzsc.hashCode(this.zzbiT);
        if (this.zzbiU != null) {
          break label352;
        }
        k = 0;
        i10 = Arrays.hashCode(this.zzbiV);
        i11 = Arrays.hashCode(this.zzbiW);
        i12 = Arrays.hashCode(this.zzbiX);
        if (this.zzbiY != null) {
          break label363;
        }
        m = 0;
        if (this.zzbiZ != null) {
          break label375;
        }
        n = 0;
        i13 = (int)(this.zzbja ^ this.zzbja >>> 32);
        if (this.zzbjb != null) {
          break label387;
        }
        i1 = 0;
        i14 = Arrays.hashCode(this.zzbjc);
        i15 = this.zzbjd;
        i16 = zzsc.hashCode(this.zzbje);
        i2 = i3;
        if (this.zzbik != null) {
          if (!this.zzbik.isEmpty()) {
            break label399;
          }
        }
      }
      label345:
      label352:
      label363:
      label375:
      label387:
      label399:
      for (int i2 = i3;; i2 = this.zzbik.hashCode())
      {
        return ((((i1 + ((n + (m + ((((k + ((j + (((i + (((i4 + 527) * 31 + i5) * 31 + i6) * 31) * 31 + i7) * 31 + i8) * 31) * 31 + i9) * 31) * 31 + i10) * 31 + i11) * 31 + i12) * 31) * 31) * 31 + i13) * 31) * 31 + i14) * 31 + i15) * 31 + i16) * 31 + i2;
        i = this.tag.hashCode();
        break;
        j = 1237;
        break label77;
        k = this.zzbiU.hashCode();
        break label95;
        m = this.zzbiY.hashCode();
        break label132;
        n = this.zzbiZ.hashCode();
        break label142;
        i1 = this.zzbjb.hashCode();
        break label167;
      }
    }
    
    protected int zzB()
    {
      int m = 0;
      int i = super.zzB();
      int j = i;
      if (this.zzbiO != 0L) {
        j = i + zzrx.zzd(1, this.zzbiO);
      }
      i = j;
      if (!this.tag.equals("")) {
        i = j + zzrx.zzn(2, this.tag);
      }
      j = i;
      if (this.zzbiT != null)
      {
        j = i;
        if (this.zzbiT.length > 0)
        {
          j = 0;
          while (j < this.zzbiT.length)
          {
            zzsi.zze localzze = this.zzbiT[j];
            k = i;
            if (localzze != null) {
              k = i + zzrx.zzc(3, localzze);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (!Arrays.equals(this.zzbiV, zzsh.zzbiE)) {
        i = j + zzrx.zzb(6, this.zzbiV);
      }
      j = i;
      if (this.zzbiY != null) {
        j = i + zzrx.zzc(7, this.zzbiY);
      }
      i = j;
      if (!Arrays.equals(this.zzbiW, zzsh.zzbiE)) {
        i = j + zzrx.zzb(8, this.zzbiW);
      }
      j = i;
      if (this.zzbiU != null) {
        j = i + zzrx.zzc(9, this.zzbiU);
      }
      i = j;
      if (this.zzbiS) {
        i = j + zzrx.zzc(10, this.zzbiS);
      }
      j = i;
      if (this.zzbiQ != 0) {
        j = i + zzrx.zzA(11, this.zzbiQ);
      }
      i = j;
      if (this.zzbiR != 0) {
        i = j + zzrx.zzA(12, this.zzbiR);
      }
      j = i;
      if (!Arrays.equals(this.zzbiX, zzsh.zzbiE)) {
        j = i + zzrx.zzb(13, this.zzbiX);
      }
      i = j;
      if (!this.zzbiZ.equals("")) {
        i = j + zzrx.zzn(14, this.zzbiZ);
      }
      j = i;
      if (this.zzbja != 180000L) {
        j = i + zzrx.zze(15, this.zzbja);
      }
      i = j;
      if (this.zzbjb != null) {
        i = j + zzrx.zzc(16, this.zzbjb);
      }
      j = i;
      if (this.zzbiP != 0L) {
        j = i + zzrx.zzd(17, this.zzbiP);
      }
      int k = j;
      if (!Arrays.equals(this.zzbjc, zzsh.zzbiE)) {
        k = j + zzrx.zzb(18, this.zzbjc);
      }
      i = k;
      if (this.zzbjd != 0) {
        i = k + zzrx.zzA(19, this.zzbjd);
      }
      j = i;
      if (this.zzbje != null)
      {
        j = i;
        if (this.zzbje.length > 0)
        {
          k = 0;
          j = m;
          while (j < this.zzbje.length)
          {
            k += zzrx.zzlJ(this.zzbje[j]);
            j += 1;
          }
          j = i + k + this.zzbje.length * 2;
        }
      }
      return j;
    }
    
    public zzd zzFV()
    {
      this.zzbiO = 0L;
      this.zzbiP = 0L;
      this.tag = "";
      this.zzbiQ = 0;
      this.zzbiR = 0;
      this.zzbiS = false;
      this.zzbiT = zzsi.zze.zzFW();
      this.zzbiU = null;
      this.zzbiV = zzsh.zzbiE;
      this.zzbiW = zzsh.zzbiE;
      this.zzbiX = zzsh.zzbiE;
      this.zzbiY = null;
      this.zzbiZ = "";
      this.zzbja = 180000L;
      this.zzbjb = null;
      this.zzbjc = zzsh.zzbiE;
      this.zzbjd = 0;
      this.zzbje = zzsh.zzbix;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public zzd zzJ(zzrw paramzzrw)
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
        case 8: 
          this.zzbiO = paramzzrw.zzFq();
          break;
        case 18: 
          this.tag = paramzzrw.readString();
          break;
        case 26: 
          j = zzsh.zzc(paramzzrw, 26);
          if (this.zzbiT == null) {}
          for (i = 0;; i = this.zzbiT.length)
          {
            localObject = new zzsi.zze[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbiT, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzsi.zze();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zzsi.zze();
          paramzzrw.zza(localObject[j]);
          this.zzbiT = ((zzsi.zze[])localObject);
          break;
        case 50: 
          this.zzbiV = paramzzrw.readBytes();
          break;
        case 58: 
          if (this.zzbiY == null) {
            this.zzbiY = new zzsi.zza();
          }
          paramzzrw.zza(this.zzbiY);
          break;
        case 66: 
          this.zzbiW = paramzzrw.readBytes();
          break;
        case 74: 
          if (this.zzbiU == null) {
            this.zzbiU = new zzsi.zzb();
          }
          paramzzrw.zza(this.zzbiU);
          break;
        case 80: 
          this.zzbiS = paramzzrw.zzFs();
          break;
        case 88: 
          this.zzbiQ = paramzzrw.zzFr();
          break;
        case 96: 
          this.zzbiR = paramzzrw.zzFr();
          break;
        case 106: 
          this.zzbiX = paramzzrw.readBytes();
          break;
        case 114: 
          this.zzbiZ = paramzzrw.readString();
          break;
        case 120: 
          this.zzbja = paramzzrw.zzFu();
          break;
        case 130: 
          if (this.zzbjb == null) {
            this.zzbjb = new zzsi.zzc();
          }
          paramzzrw.zza(this.zzbjb);
          break;
        case 136: 
          this.zzbiP = paramzzrw.zzFq();
          break;
        case 146: 
          this.zzbjc = paramzzrw.readBytes();
          break;
        case 152: 
          i = paramzzrw.zzFr();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
            this.zzbjd = i;
          }
          break;
        case 160: 
          j = zzsh.zzc(paramzzrw, 160);
          if (this.zzbje == null) {}
          for (i = 0;; i = this.zzbje.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbje, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = paramzzrw.zzFr();
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = paramzzrw.zzFr();
          this.zzbje = ((int[])localObject);
          break;
        case 162: 
          int k = paramzzrw.zzlC(paramzzrw.zzFv());
          i = paramzzrw.getPosition();
          j = 0;
          while (paramzzrw.zzFA() > 0)
          {
            paramzzrw.zzFr();
            j += 1;
          }
          paramzzrw.zzlE(i);
          if (this.zzbje == null) {}
          for (i = 0;; i = this.zzbje.length)
          {
            localObject = new int[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzbje, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length)
            {
              localObject[j] = paramzzrw.zzFr();
              j += 1;
            }
          }
          this.zzbje = ((int[])localObject);
          paramzzrw.zzlD(k);
        }
      }
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      int j = 0;
      if (this.zzbiO != 0L) {
        paramzzrx.zzb(1, this.zzbiO);
      }
      if (!this.tag.equals("")) {
        paramzzrx.zzb(2, this.tag);
      }
      int i;
      if ((this.zzbiT != null) && (this.zzbiT.length > 0))
      {
        i = 0;
        while (i < this.zzbiT.length)
        {
          zzsi.zze localzze = this.zzbiT[i];
          if (localzze != null) {
            paramzzrx.zza(3, localzze);
          }
          i += 1;
        }
      }
      if (!Arrays.equals(this.zzbiV, zzsh.zzbiE)) {
        paramzzrx.zza(6, this.zzbiV);
      }
      if (this.zzbiY != null) {
        paramzzrx.zza(7, this.zzbiY);
      }
      if (!Arrays.equals(this.zzbiW, zzsh.zzbiE)) {
        paramzzrx.zza(8, this.zzbiW);
      }
      if (this.zzbiU != null) {
        paramzzrx.zza(9, this.zzbiU);
      }
      if (this.zzbiS) {
        paramzzrx.zzb(10, this.zzbiS);
      }
      if (this.zzbiQ != 0) {
        paramzzrx.zzy(11, this.zzbiQ);
      }
      if (this.zzbiR != 0) {
        paramzzrx.zzy(12, this.zzbiR);
      }
      if (!Arrays.equals(this.zzbiX, zzsh.zzbiE)) {
        paramzzrx.zza(13, this.zzbiX);
      }
      if (!this.zzbiZ.equals("")) {
        paramzzrx.zzb(14, this.zzbiZ);
      }
      if (this.zzbja != 180000L) {
        paramzzrx.zzc(15, this.zzbja);
      }
      if (this.zzbjb != null) {
        paramzzrx.zza(16, this.zzbjb);
      }
      if (this.zzbiP != 0L) {
        paramzzrx.zzb(17, this.zzbiP);
      }
      if (!Arrays.equals(this.zzbjc, zzsh.zzbiE)) {
        paramzzrx.zza(18, this.zzbjc);
      }
      if (this.zzbjd != 0) {
        paramzzrx.zzy(19, this.zzbjd);
      }
      if ((this.zzbje != null) && (this.zzbje.length > 0))
      {
        i = j;
        while (i < this.zzbje.length)
        {
          paramzzrx.zzy(20, this.zzbje[i]);
          i += 1;
        }
      }
      super.zza(paramzzrx);
    }
  }
  
  public static final class zze
    extends zzry<zze>
  {
    private static volatile zze[] zzbjf;
    public String key;
    public String value;
    
    public zze()
    {
      zzFX();
    }
    
    public static zze[] zzFW()
    {
      if (zzbjf == null) {}
      synchronized (zzsc.zzbiu)
      {
        if (zzbjf == null) {
          zzbjf = new zze[0];
        }
        return zzbjf;
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
          if (this.key != null) {
            break;
          }
          bool1 = bool2;
        } while (((zze)paramObject).key != null);
        if (this.value != null) {
          break label111;
        }
        bool1 = bool2;
      } while (((zze)paramObject).value != null);
      for (;;)
      {
        if ((this.zzbik == null) || (this.zzbik.isEmpty()))
        {
          if (((zze)paramObject).zzbik != null)
          {
            bool1 = bool2;
            if (!((zze)paramObject).zzbik.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.key.equals(((zze)paramObject).key)) {
            break label41;
          }
          return false;
          label111:
          if (!this.value.equals(((zze)paramObject).value)) {
            return false;
          }
        }
      }
      return this.zzbik.equals(((zze)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int j;
      if (this.key == null)
      {
        i = 0;
        if (this.value != null) {
          break label89;
        }
        j = 0;
        label33:
        k = m;
        if (this.zzbik != null) {
          if (!this.zzbik.isEmpty()) {
            break label100;
          }
        }
      }
      label89:
      label100:
      for (int k = m;; k = this.zzbik.hashCode())
      {
        return (j + (i + (n + 527) * 31) * 31) * 31 + k;
        i = this.key.hashCode();
        break;
        j = this.value.hashCode();
        break label33;
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
      if (!this.value.equals("")) {
        j = i + zzrx.zzn(2, this.value);
      }
      return j;
    }
    
    public zze zzFX()
    {
      this.key = "";
      this.value = "";
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public zze zzK(zzrw paramzzrw)
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
        case 18: 
          this.value = paramzzrw.readString();
        }
      }
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if (!this.key.equals("")) {
        paramzzrx.zzb(1, this.key);
      }
      if (!this.value.equals("")) {
        paramzzrx.zzb(2, this.value);
      }
      super.zza(paramzzrx);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzsi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */