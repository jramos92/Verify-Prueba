package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzox
{
  public static final class zza
    extends zzry<zza>
  {
    public zza[] zzaCU;
    
    public zza()
    {
      zzwc();
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
        } while (!zzsc.equals(this.zzaCU, ((zza)paramObject).zzaCU));
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label79;
        }
        if (((zza)paramObject).zzbik == null) {
          break;
        }
        bool1 = bool2;
      } while (!((zza)paramObject).zzbik.isEmpty());
      return true;
      label79:
      return this.zzbik.equals(((zza)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int j = getClass().getName().hashCode();
      int k = zzsc.hashCode(this.zzaCU);
      if ((this.zzbik == null) || (this.zzbik.isEmpty())) {}
      for (int i = 0;; i = this.zzbik.hashCode()) {
        return i + ((j + 527) * 31 + k) * 31;
      }
    }
    
    protected int zzB()
    {
      int i = super.zzB();
      int k = i;
      if (this.zzaCU != null)
      {
        k = i;
        if (this.zzaCU.length > 0)
        {
          int j = 0;
          for (;;)
          {
            k = i;
            if (j >= this.zzaCU.length) {
              break;
            }
            zza localzza = this.zzaCU[j];
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
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if ((this.zzaCU != null) && (this.zzaCU.length > 0))
      {
        int i = 0;
        while (i < this.zzaCU.length)
        {
          zza localzza = this.zzaCU[i];
          if (localzza != null) {
            paramzzrx.zza(1, localzza);
          }
          i += 1;
        }
      }
      super.zza(paramzzrx);
    }
    
    public zza zzp(zzrw paramzzrw)
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
          if (this.zzaCU == null) {}
          zza[] arrayOfzza;
          for (i = 0;; i = this.zzaCU.length)
          {
            arrayOfzza = new zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzaCU, 0, arrayOfzza, 0, i);
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
          this.zzaCU = arrayOfzza;
        }
      }
    }
    
    public zza zzwc()
    {
      this.zzaCU = zza.zzwd();
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
    
    public static final class zza
      extends zzry<zza>
    {
      private static volatile zza[] zzaCV;
      public int viewId;
      public String zzaCW;
      public String zzaCX;
      
      public zza()
      {
        zzwe();
      }
      
      public static zza[] zzwd()
      {
        if (zzaCV == null) {}
        synchronized (zzsc.zzbiu)
        {
          if (zzaCV == null) {
            zzaCV = new zza[0];
          }
          return zzaCV;
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
            if (this.zzaCW != null) {
              break;
            }
            bool1 = bool2;
          } while (((zza)paramObject).zzaCW != null);
          if (this.zzaCX != null) {
            break label124;
          }
          bool1 = bool2;
        } while (((zza)paramObject).zzaCX != null);
        label124:
        while (this.zzaCX.equals(((zza)paramObject).zzaCX))
        {
          bool1 = bool2;
          if (this.viewId != ((zza)paramObject).viewId) {
            break;
          }
          if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
            break label140;
          }
          if (((zza)paramObject).zzbik != null)
          {
            bool1 = bool2;
            if (!((zza)paramObject).zzbik.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.zzaCW.equals(((zza)paramObject).zzaCW)) {
            break label41;
          }
          return false;
        }
        return false;
        label140:
        return this.zzbik.equals(((zza)paramObject).zzbik);
      }
      
      public int hashCode()
      {
        int m = 0;
        int n = getClass().getName().hashCode();
        int i;
        int j;
        label33:
        int i1;
        if (this.zzaCW == null)
        {
          i = 0;
          if (this.zzaCX != null) {
            break label101;
          }
          j = 0;
          i1 = this.viewId;
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
          return ((j + (i + (n + 527) * 31) * 31) * 31 + i1) * 31 + k;
          i = this.zzaCW.hashCode();
          break;
          j = this.zzaCX.hashCode();
          break label33;
        }
      }
      
      protected int zzB()
      {
        int j = super.zzB();
        int i = j;
        if (!this.zzaCW.equals("")) {
          i = j + zzrx.zzn(1, this.zzaCW);
        }
        j = i;
        if (!this.zzaCX.equals("")) {
          j = i + zzrx.zzn(2, this.zzaCX);
        }
        i = j;
        if (this.viewId != 0) {
          i = j + zzrx.zzA(3, this.viewId);
        }
        return i;
      }
      
      public void zza(zzrx paramzzrx)
        throws IOException
      {
        if (!this.zzaCW.equals("")) {
          paramzzrx.zzb(1, this.zzaCW);
        }
        if (!this.zzaCX.equals("")) {
          paramzzrx.zzb(2, this.zzaCX);
        }
        if (this.viewId != 0) {
          paramzzrx.zzy(3, this.viewId);
        }
        super.zza(paramzzrx);
      }
      
      public zza zzq(zzrw paramzzrw)
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
            this.zzaCW = paramzzrw.readString();
            break;
          case 18: 
            this.zzaCX = paramzzrw.readString();
            break;
          case 24: 
            this.viewId = paramzzrw.zzFr();
          }
        }
      }
      
      public zza zzwe()
      {
        this.zzaCW = "";
        this.zzaCX = "";
        this.viewId = 0;
        this.zzbik = null;
        this.zzbiv = -1;
        return this;
      }
    }
  }
  
  public static final class zzb
    extends zzry<zzb>
  {
    private static volatile zzb[] zzaCY;
    public String name;
    public zzox.zzd zzaCZ;
    
    public zzb()
    {
      zzwg();
    }
    
    public static zzb[] zzwf()
    {
      if (zzaCY == null) {}
      synchronized (zzsc.zzbiu)
      {
        if (zzaCY == null) {
          zzaCY = new zzb[0];
        }
        return zzaCY;
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
          } while (!(paramObject instanceof zzb));
          paramObject = (zzb)paramObject;
          if (this.name != null) {
            break;
          }
          bool1 = bool2;
        } while (((zzb)paramObject).name != null);
        if (this.zzaCZ != null) {
          break label111;
        }
        bool1 = bool2;
      } while (((zzb)paramObject).zzaCZ != null);
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
          if (this.name.equals(((zzb)paramObject).name)) {
            break label41;
          }
          return false;
          label111:
          if (!this.zzaCZ.equals(((zzb)paramObject).zzaCZ)) {
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
      int i;
      int j;
      if (this.name == null)
      {
        i = 0;
        if (this.zzaCZ != null) {
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
        j = this.zzaCZ.hashCode();
        break label33;
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
      if (this.zzaCZ != null) {
        j = i + zzrx.zzc(2, this.zzaCZ);
      }
      return j;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if (!this.name.equals("")) {
        paramzzrx.zzb(1, this.name);
      }
      if (this.zzaCZ != null) {
        paramzzrx.zza(2, this.zzaCZ);
      }
      super.zza(paramzzrx);
    }
    
    public zzb zzr(zzrw paramzzrw)
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
          if (this.zzaCZ == null) {
            this.zzaCZ = new zzox.zzd();
          }
          paramzzrw.zza(this.zzaCZ);
        }
      }
    }
    
    public zzb zzwg()
    {
      this.name = "";
      this.zzaCZ = null;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
  }
  
  public static final class zzc
    extends zzry<zzc>
  {
    public String type;
    public zzox.zzb[] zzaDa;
    
    public zzc()
    {
      zzwh();
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
        if (this.type != null) {
          break;
        }
        bool1 = bool2;
      } while (((zzc)paramObject).type != null);
      while (this.type.equals(((zzc)paramObject).type))
      {
        bool1 = bool2;
        if (!zzsc.equals(this.zzaDa, ((zzc)paramObject).zzaDa)) {
          break;
        }
        if ((this.zzbik != null) && (!this.zzbik.isEmpty())) {
          break label111;
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
      label111:
      return this.zzbik.equals(((zzc)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int k = 0;
      int m = getClass().getName().hashCode();
      int i;
      int n;
      if (this.type == null)
      {
        i = 0;
        n = zzsc.hashCode(this.zzaDa);
        j = k;
        if (this.zzbik != null) {
          if (!this.zzbik.isEmpty()) {
            break label87;
          }
        }
      }
      label87:
      for (int j = k;; j = this.zzbik.hashCode())
      {
        return ((i + (m + 527) * 31) * 31 + n) * 31 + j;
        i = this.type.hashCode();
        break;
      }
    }
    
    protected int zzB()
    {
      int j = super.zzB();
      int i = j;
      if (!this.type.equals("")) {
        i = j + zzrx.zzn(1, this.type);
      }
      j = i;
      if (this.zzaDa != null)
      {
        j = i;
        if (this.zzaDa.length > 0)
        {
          j = 0;
          while (j < this.zzaDa.length)
          {
            zzox.zzb localzzb = this.zzaDa[j];
            int k = i;
            if (localzzb != null) {
              k = i + zzrx.zzc(2, localzzb);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      return j;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if (!this.type.equals("")) {
        paramzzrx.zzb(1, this.type);
      }
      if ((this.zzaDa != null) && (this.zzaDa.length > 0))
      {
        int i = 0;
        while (i < this.zzaDa.length)
        {
          zzox.zzb localzzb = this.zzaDa[i];
          if (localzzb != null) {
            paramzzrx.zza(2, localzzb);
          }
          i += 1;
        }
      }
      super.zza(paramzzrx);
    }
    
    public zzc zzs(zzrw paramzzrw)
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
          this.type = paramzzrw.readString();
          break;
        case 18: 
          int j = zzsh.zzc(paramzzrw, 18);
          if (this.zzaDa == null) {}
          zzox.zzb[] arrayOfzzb;
          for (i = 0;; i = this.zzaDa.length)
          {
            arrayOfzzb = new zzox.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzaDa, 0, arrayOfzzb, 0, i);
              j = i;
            }
            while (j < arrayOfzzb.length - 1)
            {
              arrayOfzzb[j] = new zzox.zzb();
              paramzzrw.zza(arrayOfzzb[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfzzb[j] = new zzox.zzb();
          paramzzrw.zza(arrayOfzzb[j]);
          this.zzaDa = arrayOfzzb;
        }
      }
    }
    
    public zzc zzwh()
    {
      this.type = "";
      this.zzaDa = zzox.zzb.zzwf();
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
  }
  
  public static final class zzd
    extends zzry<zzd>
  {
    public boolean zzaDb;
    public long zzaDc;
    public double zzaDd;
    public zzox.zzc zzaDe;
    public String zzagS;
    
    public zzd()
    {
      zzwi();
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
              do
              {
                do
                {
                  return bool1;
                  bool1 = bool2;
                } while (!(paramObject instanceof zzd));
                paramObject = (zzd)paramObject;
                bool1 = bool2;
              } while (this.zzaDb != ((zzd)paramObject).zzaDb);
              if (this.zzagS != null) {
                break;
              }
              bool1 = bool2;
            } while (((zzd)paramObject).zzagS != null);
            bool1 = bool2;
          } while (this.zzaDc != ((zzd)paramObject).zzaDc);
          bool1 = bool2;
        } while (Double.doubleToLongBits(this.zzaDd) != Double.doubleToLongBits(((zzd)paramObject).zzaDd));
        if (this.zzaDe != null) {
          break label158;
        }
        bool1 = bool2;
      } while (((zzd)paramObject).zzaDe != null);
      for (;;)
      {
        if ((this.zzbik == null) || (this.zzbik.isEmpty()))
        {
          if (((zzd)paramObject).zzbik != null)
          {
            bool1 = bool2;
            if (!((zzd)paramObject).zzbik.isEmpty()) {
              break;
            }
          }
          return true;
          if (this.zzagS.equals(((zzd)paramObject).zzagS)) {
            break label54;
          }
          return false;
          label158:
          if (!this.zzaDe.equals(((zzd)paramObject).zzaDe)) {
            return false;
          }
        }
      }
      return this.zzbik.equals(((zzd)paramObject).zzbik);
    }
    
    public int hashCode()
    {
      int n = 0;
      int i1 = getClass().getName().hashCode();
      int i;
      int j;
      label35:
      int i2;
      int i3;
      int k;
      if (this.zzaDb)
      {
        i = 1231;
        if (this.zzagS != null) {
          break label151;
        }
        j = 0;
        i2 = (int)(this.zzaDc ^ this.zzaDc >>> 32);
        long l = Double.doubleToLongBits(this.zzaDd);
        i3 = (int)(l ^ l >>> 32);
        if (this.zzaDe != null) {
          break label162;
        }
        k = 0;
        label79:
        m = n;
        if (this.zzbik != null) {
          if (!this.zzbik.isEmpty()) {
            break label173;
          }
        }
      }
      label151:
      label162:
      label173:
      for (int m = n;; m = this.zzbik.hashCode())
      {
        return (k + (((j + (i + (i1 + 527) * 31) * 31) * 31 + i2) * 31 + i3) * 31) * 31 + m;
        i = 1237;
        break;
        j = this.zzagS.hashCode();
        break label35;
        k = this.zzaDe.hashCode();
        break label79;
      }
    }
    
    protected int zzB()
    {
      int j = super.zzB();
      int i = j;
      if (this.zzaDb) {
        i = j + zzrx.zzc(1, this.zzaDb);
      }
      j = i;
      if (!this.zzagS.equals("")) {
        j = i + zzrx.zzn(2, this.zzagS);
      }
      i = j;
      if (this.zzaDc != 0L) {
        i = j + zzrx.zzd(3, this.zzaDc);
      }
      j = i;
      if (Double.doubleToLongBits(this.zzaDd) != Double.doubleToLongBits(0.0D)) {
        j = i + zzrx.zzb(4, this.zzaDd);
      }
      i = j;
      if (this.zzaDe != null) {
        i = j + zzrx.zzc(5, this.zzaDe);
      }
      return i;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if (this.zzaDb) {
        paramzzrx.zzb(1, this.zzaDb);
      }
      if (!this.zzagS.equals("")) {
        paramzzrx.zzb(2, this.zzagS);
      }
      if (this.zzaDc != 0L) {
        paramzzrx.zzb(3, this.zzaDc);
      }
      if (Double.doubleToLongBits(this.zzaDd) != Double.doubleToLongBits(0.0D)) {
        paramzzrx.zza(4, this.zzaDd);
      }
      if (this.zzaDe != null) {
        paramzzrx.zza(5, this.zzaDe);
      }
      super.zza(paramzzrx);
    }
    
    public zzd zzt(zzrw paramzzrw)
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
          this.zzaDb = paramzzrw.zzFs();
          break;
        case 18: 
          this.zzagS = paramzzrw.readString();
          break;
        case 24: 
          this.zzaDc = paramzzrw.zzFq();
          break;
        case 33: 
          this.zzaDd = paramzzrw.readDouble();
          break;
        case 42: 
          if (this.zzaDe == null) {
            this.zzaDe = new zzox.zzc();
          }
          paramzzrw.zza(this.zzaDe);
        }
      }
    }
    
    public zzd zzwi()
    {
      this.zzaDb = false;
      this.zzagS = "";
      this.zzaDc = 0L;
      this.zzaDd = 0.0D;
      this.zzaDe = null;
      this.zzbik = null;
      this.zzbiv = -1;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */