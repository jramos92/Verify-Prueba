package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzrt
  extends zzry<zzrt>
{
  public zza[] zzbhB;
  
  public zzrt()
  {
    zzFh();
  }
  
  public static zzrt zzy(byte[] paramArrayOfByte)
    throws zzsd
  {
    return (zzrt)zzse.zza(new zzrt(), paramArrayOfByte);
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
        } while (!(paramObject instanceof zzrt));
        paramObject = (zzrt)paramObject;
        bool1 = bool2;
      } while (!zzsc.equals(this.zzbhB, ((zzrt)paramObject).zzbhB));
      if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
        break label79;
      }
      if (((zzrt)paramObject).zzbik == null) {
        break;
      }
      bool1 = bool2;
    } while (!((zzrt)paramObject).zzbik.isEmpty());
    return true;
    label79:
    return this.zzbik.equals(((zzrt)paramObject).zzbik);
  }
  
  public int hashCode()
  {
    int j = getClass().getName().hashCode();
    int k = zzsc.hashCode(this.zzbhB);
    if ((this.zzbik == null) || (this.zzbik.isEmpty())) {}
    for (int i = 0;; i = this.zzbik.hashCode()) {
      return i + ((j + 527) * 31 + k) * 31;
    }
  }
  
  public zzrt zzA(zzrw paramzzrw)
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
        if (this.zzbhB == null) {}
        zza[] arrayOfzza;
        for (i = 0;; i = this.zzbhB.length)
        {
          arrayOfzza = new zza[j + i];
          j = i;
          if (i != 0)
          {
            System.arraycopy(this.zzbhB, 0, arrayOfzza, 0, i);
            j = i;
          }
          while (j < arrayOfzza.length - 1)
          {
            arrayOfzza[j] = new zza();
            paramzzrw.zza(arrayOfzza[j]);
            paramzzrw.zzFo();
            j += 1;
          }
        }
        arrayOfzza[j] = new zza();
        paramzzrw.zza(arrayOfzza[j]);
        this.zzbhB = arrayOfzza;
      }
    }
  }
  
  protected int zzB()
  {
    int i = super.zzB();
    int k = i;
    if (this.zzbhB != null)
    {
      k = i;
      if (this.zzbhB.length > 0)
      {
        int j = 0;
        for (;;)
        {
          k = i;
          if (j >= this.zzbhB.length) {
            break;
          }
          zza localzza = this.zzbhB[j];
          k = i;
          if (localzza != null) {
            k = i + zzrx.zzc(1, localzza);
          }
          j += 1;
          i = k;
        }
      }
    }
    return k;
  }
  
  public zzrt zzFh()
  {
    this.zzbhB = zza.zzFi();
    this.zzbik = null;
    this.zzbiv = -1;
    return this;
  }
  
  public void zza(zzrx paramzzrx)
    throws IOException
  {
    if ((this.zzbhB != null) && (this.zzbhB.length > 0))
    {
      int i = 0;
      while (i < this.zzbhB.length)
      {
        zza localzza = this.zzbhB[i];
        if (localzza != null) {
          paramzzrx.zza(1, localzza);
        }
        i += 1;
      }
    }
    super.zza(paramzzrx);
  }
  
  public static final class zza
    extends zzry<zza>
  {
    private static volatile zza[] zzbhC;
    public String name;
    public zza zzbhD;
    
    public zza()
    {
      zzFj();
    }
    
    public static zza[] zzFi()
    {
      if (zzbhC == null) {}
      synchronized (zzsc.zzbiu)
      {
        if (zzbhC == null) {
          zzbhC = new zza[0];
        }
        return zzbhC;
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
          } while (!(paramObject instanceof zza));
          paramObject = (zza)paramObject;
          if (this.name != null) {
            break;
          }
          bool1 = bool2;
        } while (((zza)paramObject).name != null);
        if (this.zzbhD != null) {
          break label111;
        }
        bool1 = bool2;
      } while (((zza)paramObject).zzbhD != null);
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
          if (this.name.equals(((zza)paramObject).name)) {
            break label41;
          }
          return false;
          label111:
          if (!this.zzbhD.equals(((zza)paramObject).zzbhD)) {
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
      int i;
      int j;
      if (this.name == null)
      {
        i = 0;
        if (this.zzbhD != null) {
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
        i = this.name.hashCode();
        break;
        j = this.zzbhD.hashCode();
        break label33;
      }
    }
    
    protected int zzB()
    {
      int j = super.zzB() + zzrx.zzn(1, this.name);
      int i = j;
      if (this.zzbhD != null) {
        i = j + zzrx.zzc(2, this.zzbhD);
      }
      return i;
    }
    
    public zza zzB(zzrw paramzzrw)
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
          if (this.zzbhD == null) {
            this.zzbhD = new zza();
          }
          paramzzrw.zza(this.zzbhD);
        }
      }
    }
    
    public zza zzFj()
    {
      this.name = "";
      this.zzbhD = null;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      paramzzrx.zzb(1, this.name);
      if (this.zzbhD != null) {
        paramzzrx.zza(2, this.zzbhD);
      }
      super.zza(paramzzrx);
    }
    
    public static final class zza
      extends zzry<zza>
    {
      private static volatile zza[] zzbhE;
      public int type;
      public zza zzbhF;
      
      public zza()
      {
        zzFl();
      }
      
      public static zza[] zzFk()
      {
        if (zzbhE == null) {}
        synchronized (zzsc.zzbiu)
        {
          if (zzbhE == null) {
            zzbhE = new zza[0];
          }
          return zzbhE;
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
              return bool1;
              bool1 = bool2;
            } while (!(paramObject instanceof zza));
            paramObject = (zza)paramObject;
            bool1 = bool2;
          } while (this.type != ((zza)paramObject).type);
          if (this.zzbhF != null) {
            break;
          }
          bool1 = bool2;
        } while (((zza)paramObject).zzbhF != null);
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
            if (!this.zzbhF.equals(((zza)paramObject).zzbhF)) {
              return false;
            }
          }
        }
        return this.zzbik.equals(((zza)paramObject).zzbik);
      }
      
      public int hashCode()
      {
        int k = 0;
        int m = getClass().getName().hashCode();
        int n = this.type;
        int i;
        if (this.zzbhF == null)
        {
          i = 0;
          j = k;
          if (this.zzbik != null) {
            if (!this.zzbik.isEmpty()) {
              break label84;
            }
          }
        }
        label84:
        for (int j = k;; j = this.zzbik.hashCode())
        {
          return (i + ((m + 527) * 31 + n) * 31) * 31 + j;
          i = this.zzbhF.hashCode();
          break;
        }
      }
      
      protected int zzB()
      {
        int j = super.zzB() + zzrx.zzA(1, this.type);
        int i = j;
        if (this.zzbhF != null) {
          i = j + zzrx.zzc(2, this.zzbhF);
        }
        return i;
      }
      
      public zza zzC(zzrw paramzzrw)
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
              this.type = i;
            }
            break;
          case 18: 
            if (this.zzbhF == null) {
              this.zzbhF = new zza();
            }
            paramzzrw.zza(this.zzbhF);
          }
        }
      }
      
      public zza zzFl()
      {
        this.type = 1;
        this.zzbhF = null;
        this.zzbik = null;
        this.zzbiv = -1;
        return this;
      }
      
      public void zza(zzrx paramzzrx)
        throws IOException
      {
        paramzzrx.zzy(1, this.type);
        if (this.zzbhF != null) {
          paramzzrx.zza(2, this.zzbhF);
        }
        super.zza(paramzzrx);
      }
      
      public static final class zza
        extends zzry<zza>
      {
        public byte[] zzbhG;
        public String zzbhH;
        public double zzbhI;
        public float zzbhJ;
        public long zzbhK;
        public int zzbhL;
        public int zzbhM;
        public boolean zzbhN;
        public zzrt.zza[] zzbhO;
        public zzrt.zza.zza[] zzbhP;
        public String[] zzbhQ;
        public long[] zzbhR;
        public float[] zzbhS;
        public long zzbhT;
        
        public zza()
        {
          zzFm();
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
              } while (!(paramObject instanceof zza));
              paramObject = (zza)paramObject;
              bool1 = bool2;
            } while (!Arrays.equals(this.zzbhG, ((zza)paramObject).zzbhG));
            if (this.zzbhH != null) {
              break;
            }
            bool1 = bool2;
          } while (((zza)paramObject).zzbhH != null);
          while (this.zzbhH.equals(((zza)paramObject).zzbhH))
          {
            bool1 = bool2;
            if (Double.doubleToLongBits(this.zzbhI) != Double.doubleToLongBits(((zza)paramObject).zzbhI)) {
              break;
            }
            bool1 = bool2;
            if (Float.floatToIntBits(this.zzbhJ) != Float.floatToIntBits(((zza)paramObject).zzbhJ)) {
              break;
            }
            bool1 = bool2;
            if (this.zzbhK != ((zza)paramObject).zzbhK) {
              break;
            }
            bool1 = bool2;
            if (this.zzbhL != ((zza)paramObject).zzbhL) {
              break;
            }
            bool1 = bool2;
            if (this.zzbhM != ((zza)paramObject).zzbhM) {
              break;
            }
            bool1 = bool2;
            if (this.zzbhN != ((zza)paramObject).zzbhN) {
              break;
            }
            bool1 = bool2;
            if (!zzsc.equals(this.zzbhO, ((zza)paramObject).zzbhO)) {
              break;
            }
            bool1 = bool2;
            if (!zzsc.equals(this.zzbhP, ((zza)paramObject).zzbhP)) {
              break;
            }
            bool1 = bool2;
            if (!zzsc.equals(this.zzbhQ, ((zza)paramObject).zzbhQ)) {
              break;
            }
            bool1 = bool2;
            if (!zzsc.equals(this.zzbhR, ((zza)paramObject).zzbhR)) {
              break;
            }
            bool1 = bool2;
            if (!zzsc.equals(this.zzbhS, ((zza)paramObject).zzbhS)) {
              break;
            }
            bool1 = bool2;
            if (this.zzbhT != ((zza)paramObject).zzbhT) {
              break;
            }
            if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
              break label297;
            }
            if (((zza)paramObject).zzbik != null)
            {
              bool1 = bool2;
              if (!((zza)paramObject).zzbik.isEmpty()) {
                break;
              }
            }
            return true;
          }
          return false;
          label297:
          return this.zzbik.equals(((zza)paramObject).zzbik);
        }
        
        public int hashCode()
        {
          int m = 0;
          int n = getClass().getName().hashCode();
          int i1 = Arrays.hashCode(this.zzbhG);
          int i;
          int i2;
          int i3;
          int i4;
          int i5;
          int i6;
          int j;
          label100:
          int i7;
          int i8;
          int i9;
          int i10;
          int i11;
          int i12;
          if (this.zzbhH == null)
          {
            i = 0;
            long l = Double.doubleToLongBits(this.zzbhI);
            i2 = (int)(l ^ l >>> 32);
            i3 = Float.floatToIntBits(this.zzbhJ);
            i4 = (int)(this.zzbhK ^ this.zzbhK >>> 32);
            i5 = this.zzbhL;
            i6 = this.zzbhM;
            if (!this.zzbhN) {
              break label288;
            }
            j = 1231;
            i7 = zzsc.hashCode(this.zzbhO);
            i8 = zzsc.hashCode(this.zzbhP);
            i9 = zzsc.hashCode(this.zzbhQ);
            i10 = zzsc.hashCode(this.zzbhR);
            i11 = zzsc.hashCode(this.zzbhS);
            i12 = (int)(this.zzbhT ^ this.zzbhT >>> 32);
            k = m;
            if (this.zzbik != null) {
              if (!this.zzbik.isEmpty()) {
                break label295;
              }
            }
          }
          label288:
          label295:
          for (int k = m;; k = this.zzbik.hashCode())
          {
            return (((((((j + ((((((i + ((n + 527) * 31 + i1) * 31) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12) * 31 + k;
            i = this.zzbhH.hashCode();
            break;
            j = 1237;
            break label100;
          }
        }
        
        protected int zzB()
        {
          int i2 = 0;
          int j = super.zzB();
          int i = j;
          if (!Arrays.equals(this.zzbhG, zzsh.zzbiE)) {
            i = j + zzrx.zzb(1, this.zzbhG);
          }
          j = i;
          if (!this.zzbhH.equals("")) {
            j = i + zzrx.zzn(2, this.zzbhH);
          }
          i = j;
          if (Double.doubleToLongBits(this.zzbhI) != Double.doubleToLongBits(0.0D)) {
            i = j + zzrx.zzb(3, this.zzbhI);
          }
          j = i;
          if (Float.floatToIntBits(this.zzbhJ) != Float.floatToIntBits(0.0F)) {
            j = i + zzrx.zzc(4, this.zzbhJ);
          }
          i = j;
          if (this.zzbhK != 0L) {
            i = j + zzrx.zzd(5, this.zzbhK);
          }
          j = i;
          if (this.zzbhL != 0) {
            j = i + zzrx.zzA(6, this.zzbhL);
          }
          int k = j;
          if (this.zzbhM != 0) {
            k = j + zzrx.zzB(7, this.zzbhM);
          }
          i = k;
          if (this.zzbhN) {
            i = k + zzrx.zzc(8, this.zzbhN);
          }
          j = i;
          Object localObject;
          if (this.zzbhO != null)
          {
            j = i;
            if (this.zzbhO.length > 0)
            {
              j = 0;
              while (j < this.zzbhO.length)
              {
                localObject = this.zzbhO[j];
                k = i;
                if (localObject != null) {
                  k = i + zzrx.zzc(9, (zzse)localObject);
                }
                j += 1;
                i = k;
              }
              j = i;
            }
          }
          i = j;
          if (this.zzbhP != null)
          {
            i = j;
            if (this.zzbhP.length > 0)
            {
              i = j;
              j = 0;
              while (j < this.zzbhP.length)
              {
                localObject = this.zzbhP[j];
                k = i;
                if (localObject != null) {
                  k = i + zzrx.zzc(10, (zzse)localObject);
                }
                j += 1;
                i = k;
              }
            }
          }
          j = i;
          if (this.zzbhQ != null)
          {
            j = i;
            if (this.zzbhQ.length > 0)
            {
              j = 0;
              k = 0;
              int n;
              for (int m = 0; j < this.zzbhQ.length; m = n)
              {
                localObject = this.zzbhQ[j];
                int i1 = k;
                n = m;
                if (localObject != null)
                {
                  n = m + 1;
                  i1 = k + zzrx.zzfA((String)localObject);
                }
                j += 1;
                k = i1;
              }
              j = i + k + m * 1;
            }
          }
          i = j;
          if (this.zzbhR != null)
          {
            i = j;
            if (this.zzbhR.length > 0)
            {
              k = 0;
              i = i2;
              while (i < this.zzbhR.length)
              {
                k += zzrx.zzaa(this.zzbhR[i]);
                i += 1;
              }
              i = j + k + this.zzbhR.length * 1;
            }
          }
          j = i;
          if (this.zzbhT != 0L) {
            j = i + zzrx.zzd(13, this.zzbhT);
          }
          i = j;
          if (this.zzbhS != null)
          {
            i = j;
            if (this.zzbhS.length > 0) {
              i = j + this.zzbhS.length * 4 + this.zzbhS.length * 1;
            }
          }
          return i;
        }
        
        public zza zzD(zzrw paramzzrw)
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
              this.zzbhG = paramzzrw.readBytes();
              break;
            case 18: 
              this.zzbhH = paramzzrw.readString();
              break;
            case 25: 
              this.zzbhI = paramzzrw.readDouble();
              break;
            case 37: 
              this.zzbhJ = paramzzrw.readFloat();
              break;
            case 40: 
              this.zzbhK = paramzzrw.zzFq();
              break;
            case 48: 
              this.zzbhL = paramzzrw.zzFr();
              break;
            case 56: 
              this.zzbhM = paramzzrw.zzFt();
              break;
            case 64: 
              this.zzbhN = paramzzrw.zzFs();
              break;
            case 74: 
              j = zzsh.zzc(paramzzrw, 74);
              if (this.zzbhO == null) {}
              for (i = 0;; i = this.zzbhO.length)
              {
                localObject = new zzrt.zza[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.zzbhO, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = new zzrt.zza();
                  paramzzrw.zza(localObject[j]);
                  paramzzrw.zzFo();
                  j += 1;
                }
              }
              localObject[j] = new zzrt.zza();
              paramzzrw.zza(localObject[j]);
              this.zzbhO = ((zzrt.zza[])localObject);
              break;
            case 82: 
              j = zzsh.zzc(paramzzrw, 82);
              if (this.zzbhP == null) {}
              for (i = 0;; i = this.zzbhP.length)
              {
                localObject = new zzrt.zza.zza[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.zzbhP, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = new zzrt.zza.zza();
                  paramzzrw.zza(localObject[j]);
                  paramzzrw.zzFo();
                  j += 1;
                }
              }
              localObject[j] = new zzrt.zza.zza();
              paramzzrw.zza(localObject[j]);
              this.zzbhP = ((zzrt.zza.zza[])localObject);
              break;
            case 90: 
              j = zzsh.zzc(paramzzrw, 90);
              if (this.zzbhQ == null) {}
              for (i = 0;; i = this.zzbhQ.length)
              {
                localObject = new String[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.zzbhQ, 0, localObject, 0, i);
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
              this.zzbhQ = ((String[])localObject);
              break;
            case 96: 
              j = zzsh.zzc(paramzzrw, 96);
              if (this.zzbhR == null) {}
              for (i = 0;; i = this.zzbhR.length)
              {
                localObject = new long[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.zzbhR, 0, localObject, 0, i);
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
              this.zzbhR = ((long[])localObject);
              break;
            case 98: 
              k = paramzzrw.zzlC(paramzzrw.zzFv());
              i = paramzzrw.getPosition();
              j = 0;
              while (paramzzrw.zzFA() > 0)
              {
                paramzzrw.zzFq();
                j += 1;
              }
              paramzzrw.zzlE(i);
              if (this.zzbhR == null) {}
              for (i = 0;; i = this.zzbhR.length)
              {
                localObject = new long[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.zzbhR, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length)
                {
                  localObject[j] = paramzzrw.zzFq();
                  j += 1;
                }
              }
              this.zzbhR = ((long[])localObject);
              paramzzrw.zzlD(k);
              break;
            case 104: 
              this.zzbhT = paramzzrw.zzFq();
              break;
            case 117: 
              j = zzsh.zzc(paramzzrw, 117);
              if (this.zzbhS == null) {}
              for (i = 0;; i = this.zzbhS.length)
              {
                localObject = new float[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.zzbhS, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length - 1)
                {
                  localObject[j] = paramzzrw.readFloat();
                  paramzzrw.zzFo();
                  j += 1;
                }
              }
              localObject[j] = paramzzrw.readFloat();
              this.zzbhS = ((float[])localObject);
              break;
            case 114: 
              i = paramzzrw.zzFv();
              k = paramzzrw.zzlC(i);
              j = i / 4;
              if (this.zzbhS == null) {}
              for (i = 0;; i = this.zzbhS.length)
              {
                localObject = new float[j + i];
                j = i;
                if (i != 0)
                {
                  System.arraycopy(this.zzbhS, 0, localObject, 0, i);
                  j = i;
                }
                while (j < localObject.length)
                {
                  localObject[j] = paramzzrw.readFloat();
                  j += 1;
                }
              }
              this.zzbhS = ((float[])localObject);
              paramzzrw.zzlD(k);
            }
          }
        }
        
        public zza zzFm()
        {
          this.zzbhG = zzsh.zzbiE;
          this.zzbhH = "";
          this.zzbhI = 0.0D;
          this.zzbhJ = 0.0F;
          this.zzbhK = 0L;
          this.zzbhL = 0;
          this.zzbhM = 0;
          this.zzbhN = false;
          this.zzbhO = zzrt.zza.zzFi();
          this.zzbhP = zzrt.zza.zza.zzFk();
          this.zzbhQ = zzsh.zzbiC;
          this.zzbhR = zzsh.zzbiy;
          this.zzbhS = zzsh.zzbiz;
          this.zzbhT = 0L;
          this.zzbik = null;
          this.zzbiv = -1;
          return this;
        }
        
        public void zza(zzrx paramzzrx)
          throws IOException
        {
          int j = 0;
          if (!Arrays.equals(this.zzbhG, zzsh.zzbiE)) {
            paramzzrx.zza(1, this.zzbhG);
          }
          if (!this.zzbhH.equals("")) {
            paramzzrx.zzb(2, this.zzbhH);
          }
          if (Double.doubleToLongBits(this.zzbhI) != Double.doubleToLongBits(0.0D)) {
            paramzzrx.zza(3, this.zzbhI);
          }
          if (Float.floatToIntBits(this.zzbhJ) != Float.floatToIntBits(0.0F)) {
            paramzzrx.zzb(4, this.zzbhJ);
          }
          if (this.zzbhK != 0L) {
            paramzzrx.zzb(5, this.zzbhK);
          }
          if (this.zzbhL != 0) {
            paramzzrx.zzy(6, this.zzbhL);
          }
          if (this.zzbhM != 0) {
            paramzzrx.zzz(7, this.zzbhM);
          }
          if (this.zzbhN) {
            paramzzrx.zzb(8, this.zzbhN);
          }
          int i;
          Object localObject;
          if ((this.zzbhO != null) && (this.zzbhO.length > 0))
          {
            i = 0;
            while (i < this.zzbhO.length)
            {
              localObject = this.zzbhO[i];
              if (localObject != null) {
                paramzzrx.zza(9, (zzse)localObject);
              }
              i += 1;
            }
          }
          if ((this.zzbhP != null) && (this.zzbhP.length > 0))
          {
            i = 0;
            while (i < this.zzbhP.length)
            {
              localObject = this.zzbhP[i];
              if (localObject != null) {
                paramzzrx.zza(10, (zzse)localObject);
              }
              i += 1;
            }
          }
          if ((this.zzbhQ != null) && (this.zzbhQ.length > 0))
          {
            i = 0;
            while (i < this.zzbhQ.length)
            {
              localObject = this.zzbhQ[i];
              if (localObject != null) {
                paramzzrx.zzb(11, (String)localObject);
              }
              i += 1;
            }
          }
          if ((this.zzbhR != null) && (this.zzbhR.length > 0))
          {
            i = 0;
            while (i < this.zzbhR.length)
            {
              paramzzrx.zzb(12, this.zzbhR[i]);
              i += 1;
            }
          }
          if (this.zzbhT != 0L) {
            paramzzrx.zzb(13, this.zzbhT);
          }
          if ((this.zzbhS != null) && (this.zzbhS.length > 0))
          {
            i = j;
            while (i < this.zzbhS.length)
            {
              paramzzrx.zzb(14, this.zzbhS[i]);
              i += 1;
            }
          }
          super.zza(paramzzrx);
        }
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzrt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */