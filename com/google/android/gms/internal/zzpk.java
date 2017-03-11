package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface zzpk
{
  public static final class zza
    extends zzse
  {
    private static volatile zza[] zzaOC;
    public Integer count;
    public String name;
    public zzpk.zzb[] zzaOD;
    public Long zzaOE;
    public Long zzaOF;
    
    public zza()
    {
      zzAy();
    }
    
    public static zza[] zzAx()
    {
      if (zzaOC == null) {}
      synchronized (zzsc.zzbiu)
      {
        if (zzaOC == null) {
          zzaOC = new zza[0];
        }
        return zzaOC;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        do
        {
          return true;
          if (!(paramObject instanceof zza)) {
            return false;
          }
          paramObject = (zza)paramObject;
          if (!zzsc.equals(this.zzaOD, ((zza)paramObject).zzaOD)) {
            return false;
          }
          if (this.name == null)
          {
            if (((zza)paramObject).name != null) {
              return false;
            }
          }
          else if (!this.name.equals(((zza)paramObject).name)) {
            return false;
          }
          if (this.zzaOE == null)
          {
            if (((zza)paramObject).zzaOE != null) {
              return false;
            }
          }
          else if (!this.zzaOE.equals(((zza)paramObject).zzaOE)) {
            return false;
          }
          if (this.zzaOF == null)
          {
            if (((zza)paramObject).zzaOF != null) {
              return false;
            }
          }
          else if (!this.zzaOF.equals(((zza)paramObject).zzaOF)) {
            return false;
          }
          if (this.count != null) {
            break;
          }
        } while (((zza)paramObject).count == null);
        return false;
      } while (this.count.equals(((zza)paramObject).count));
      return false;
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i1 = zzsc.hashCode(this.zzaOD);
      int i;
      int j;
      label42:
      int k;
      if (this.name == null)
      {
        i = 0;
        if (this.zzaOE != null) {
          break label103;
        }
        j = 0;
        if (this.zzaOF != null) {
          break label114;
        }
        k = 0;
        label51:
        if (this.count != null) {
          break label125;
        }
      }
      for (;;)
      {
        return (k + (j + (i + ((n + 527) * 31 + i1) * 31) * 31) * 31) * 31 + m;
        i = this.name.hashCode();
        break;
        label103:
        j = this.zzaOE.hashCode();
        break label42;
        label114:
        k = this.zzaOF.hashCode();
        break label51;
        label125:
        m = this.count.hashCode();
      }
    }
    
    public zza zzAy()
    {
      this.zzaOD = zzpk.zzb.zzAz();
      this.name = null;
      this.zzaOE = null;
      this.zzaOF = null;
      this.count = null;
      this.zzbiv = -1;
      return this;
    }
    
    protected int zzB()
    {
      int i = super.zzB();
      int j = i;
      if (this.zzaOD != null)
      {
        j = i;
        if (this.zzaOD.length > 0)
        {
          int k = 0;
          for (;;)
          {
            j = i;
            if (k >= this.zzaOD.length) {
              break;
            }
            zzpk.zzb localzzb = this.zzaOD[k];
            j = i;
            if (localzzb != null) {
              j = i + zzrx.zzc(1, localzzb);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.name != null) {
        i = j + zzrx.zzn(2, this.name);
      }
      j = i;
      if (this.zzaOE != null) {
        j = i + zzrx.zzd(3, this.zzaOE.longValue());
      }
      i = j;
      if (this.zzaOF != null) {
        i = j + zzrx.zzd(4, this.zzaOF.longValue());
      }
      j = i;
      if (this.count != null) {
        j = i + zzrx.zzA(5, this.count.intValue());
      }
      return j;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if ((this.zzaOD != null) && (this.zzaOD.length > 0))
      {
        int i = 0;
        while (i < this.zzaOD.length)
        {
          zzpk.zzb localzzb = this.zzaOD[i];
          if (localzzb != null) {
            paramzzrx.zza(1, localzzb);
          }
          i += 1;
        }
      }
      if (this.name != null) {
        paramzzrx.zzb(2, this.name);
      }
      if (this.zzaOE != null) {
        paramzzrx.zzb(3, this.zzaOE.longValue());
      }
      if (this.zzaOF != null) {
        paramzzrx.zzb(4, this.zzaOF.longValue());
      }
      if (this.count != null) {
        paramzzrx.zzy(5, this.count.intValue());
      }
      super.zza(paramzzrx);
    }
    
    public zza zzu(zzrw paramzzrw)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzrw.zzFo();
        switch (i)
        {
        default: 
          if (zzsh.zzb(paramzzrw, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          int j = zzsh.zzc(paramzzrw, 10);
          if (this.zzaOD == null) {}
          zzpk.zzb[] arrayOfzzb;
          for (i = 0;; i = this.zzaOD.length)
          {
            arrayOfzzb = new zzpk.zzb[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzaOD, 0, arrayOfzzb, 0, i);
              j = i;
            }
            while (j < arrayOfzzb.length - 1)
            {
              arrayOfzzb[j] = new zzpk.zzb();
              paramzzrw.zza(arrayOfzzb[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfzzb[j] = new zzpk.zzb();
          paramzzrw.zza(arrayOfzzb[j]);
          this.zzaOD = arrayOfzzb;
          break;
        case 18: 
          this.name = paramzzrw.readString();
          break;
        case 24: 
          this.zzaOE = Long.valueOf(paramzzrw.zzFq());
          break;
        case 32: 
          this.zzaOF = Long.valueOf(paramzzrw.zzFq());
          break;
        case 40: 
          this.count = Integer.valueOf(paramzzrw.zzFr());
        }
      }
    }
  }
  
  public static final class zzb
    extends zzse
  {
    private static volatile zzb[] zzaOG;
    public String name;
    public Float zzaOB;
    public Long zzaOH;
    public String zzagS;
    
    public zzb()
    {
      zzAA();
    }
    
    public static zzb[] zzAz()
    {
      if (zzaOG == null) {}
      synchronized (zzsc.zzbiu)
      {
        if (zzaOG == null) {
          zzaOG = new zzb[0];
        }
        return zzaOG;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        do
        {
          return true;
          if (!(paramObject instanceof zzb)) {
            return false;
          }
          paramObject = (zzb)paramObject;
          if (this.name == null)
          {
            if (((zzb)paramObject).name != null) {
              return false;
            }
          }
          else if (!this.name.equals(((zzb)paramObject).name)) {
            return false;
          }
          if (this.zzagS == null)
          {
            if (((zzb)paramObject).zzagS != null) {
              return false;
            }
          }
          else if (!this.zzagS.equals(((zzb)paramObject).zzagS)) {
            return false;
          }
          if (this.zzaOH == null)
          {
            if (((zzb)paramObject).zzaOH != null) {
              return false;
            }
          }
          else if (!this.zzaOH.equals(((zzb)paramObject).zzaOH)) {
            return false;
          }
          if (this.zzaOB != null) {
            break;
          }
        } while (((zzb)paramObject).zzaOB == null);
        return false;
      } while (this.zzaOB.equals(((zzb)paramObject).zzaOB));
      return false;
    }
    
    public int hashCode()
    {
      int m = 0;
      int n = getClass().getName().hashCode();
      int i;
      int j;
      label33:
      int k;
      if (this.name == null)
      {
        i = 0;
        if (this.zzagS != null) {
          break label88;
        }
        j = 0;
        if (this.zzaOH != null) {
          break label99;
        }
        k = 0;
        label42:
        if (this.zzaOB != null) {
          break label110;
        }
      }
      for (;;)
      {
        return (k + (j + (i + (n + 527) * 31) * 31) * 31) * 31 + m;
        i = this.name.hashCode();
        break;
        label88:
        j = this.zzagS.hashCode();
        break label33;
        label99:
        k = this.zzaOH.hashCode();
        break label42;
        label110:
        m = this.zzaOB.hashCode();
      }
    }
    
    public zzb zzAA()
    {
      this.name = null;
      this.zzagS = null;
      this.zzaOH = null;
      this.zzaOB = null;
      this.zzbiv = -1;
      return this;
    }
    
    protected int zzB()
    {
      int j = super.zzB();
      int i = j;
      if (this.name != null) {
        i = j + zzrx.zzn(1, this.name);
      }
      j = i;
      if (this.zzagS != null) {
        j = i + zzrx.zzn(2, this.zzagS);
      }
      i = j;
      if (this.zzaOH != null) {
        i = j + zzrx.zzd(3, this.zzaOH.longValue());
      }
      j = i;
      if (this.zzaOB != null) {
        j = i + zzrx.zzc(4, this.zzaOB.floatValue());
      }
      return j;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if (this.name != null) {
        paramzzrx.zzb(1, this.name);
      }
      if (this.zzagS != null) {
        paramzzrx.zzb(2, this.zzagS);
      }
      if (this.zzaOH != null) {
        paramzzrx.zzb(3, this.zzaOH.longValue());
      }
      if (this.zzaOB != null) {
        paramzzrx.zzb(4, this.zzaOB.floatValue());
      }
      super.zza(paramzzrx);
    }
    
    public zzb zzv(zzrw paramzzrw)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzrw.zzFo();
        switch (i)
        {
        default: 
          if (zzsh.zzb(paramzzrw, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          this.name = paramzzrw.readString();
          break;
        case 18: 
          this.zzagS = paramzzrw.readString();
          break;
        case 24: 
          this.zzaOH = Long.valueOf(paramzzrw.zzFq());
          break;
        case 37: 
          this.zzaOB = Float.valueOf(paramzzrw.readFloat());
        }
      }
    }
  }
  
  public static final class zzc
    extends zzse
  {
    public zzpk.zzd[] zzaOI;
    
    public zzc()
    {
      zzAB();
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        return true;
        if (!(paramObject instanceof zzc)) {
          return false;
        }
        paramObject = (zzc)paramObject;
      } while (zzsc.equals(this.zzaOI, ((zzc)paramObject).zzaOI));
      return false;
    }
    
    public int hashCode()
    {
      return (getClass().getName().hashCode() + 527) * 31 + zzsc.hashCode(this.zzaOI);
    }
    
    public zzc zzAB()
    {
      this.zzaOI = zzpk.zzd.zzAC();
      this.zzbiv = -1;
      return this;
    }
    
    protected int zzB()
    {
      int i = super.zzB();
      int k = i;
      if (this.zzaOI != null)
      {
        k = i;
        if (this.zzaOI.length > 0)
        {
          int j = 0;
          for (;;)
          {
            k = i;
            if (j >= this.zzaOI.length) {
              break;
            }
            zzpk.zzd localzzd = this.zzaOI[j];
            k = i;
            if (localzzd != null) {
              k = i + zzrx.zzc(1, localzzd);
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
      if ((this.zzaOI != null) && (this.zzaOI.length > 0))
      {
        int i = 0;
        while (i < this.zzaOI.length)
        {
          zzpk.zzd localzzd = this.zzaOI[i];
          if (localzzd != null) {
            paramzzrx.zza(1, localzzd);
          }
          i += 1;
        }
      }
      super.zza(paramzzrx);
    }
    
    public zzc zzw(zzrw paramzzrw)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzrw.zzFo();
        switch (i)
        {
        default: 
          if (zzsh.zzb(paramzzrw, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          int j = zzsh.zzc(paramzzrw, 10);
          if (this.zzaOI == null) {}
          zzpk.zzd[] arrayOfzzd;
          for (i = 0;; i = this.zzaOI.length)
          {
            arrayOfzzd = new zzpk.zzd[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzaOI, 0, arrayOfzzd, 0, i);
              j = i;
            }
            while (j < arrayOfzzd.length - 1)
            {
              arrayOfzzd[j] = new zzpk.zzd();
              paramzzrw.zza(arrayOfzzd[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          arrayOfzzd[j] = new zzpk.zzd();
          paramzzrw.zza(arrayOfzzd[j]);
          this.zzaOI = arrayOfzzd;
        }
      }
    }
  }
  
  public static final class zzd
    extends zzse
  {
    private static volatile zzd[] zzaOJ;
    public String zzaDC;
    public String zzaLP;
    public String zzaLQ;
    public Integer zzaOK;
    public zzpk.zza[] zzaOL;
    public zzpk.zze[] zzaOM;
    public Long zzaON;
    public Long zzaOO;
    public Long zzaOP;
    public Long zzaOQ;
    public Long zzaOR;
    public String zzaOS;
    public String zzaOT;
    public String zzaOU;
    public String zzaOV;
    public Integer zzaOW;
    public String zzaOX;
    public Long zzaOY;
    public Long zzaOZ;
    public String zzaPa;
    public Boolean zzaPb;
    public String zzaPc;
    public Long zzaPd;
    public Integer zzaPe;
    public String zzaPf;
    public Boolean zzaPg;
    
    public zzd()
    {
      zzAD();
    }
    
    public static zzd[] zzAC()
    {
      if (zzaOJ == null) {}
      synchronized (zzsc.zzbiu)
      {
        if (zzaOJ == null) {
          zzaOJ = new zzd[0];
        }
        return zzaOJ;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        do
        {
          return true;
          if (!(paramObject instanceof zzd)) {
            return false;
          }
          paramObject = (zzd)paramObject;
          if (this.zzaOK == null)
          {
            if (((zzd)paramObject).zzaOK != null) {
              return false;
            }
          }
          else if (!this.zzaOK.equals(((zzd)paramObject).zzaOK)) {
            return false;
          }
          if (!zzsc.equals(this.zzaOL, ((zzd)paramObject).zzaOL)) {
            return false;
          }
          if (!zzsc.equals(this.zzaOM, ((zzd)paramObject).zzaOM)) {
            return false;
          }
          if (this.zzaON == null)
          {
            if (((zzd)paramObject).zzaON != null) {
              return false;
            }
          }
          else if (!this.zzaON.equals(((zzd)paramObject).zzaON)) {
            return false;
          }
          if (this.zzaOO == null)
          {
            if (((zzd)paramObject).zzaOO != null) {
              return false;
            }
          }
          else if (!this.zzaOO.equals(((zzd)paramObject).zzaOO)) {
            return false;
          }
          if (this.zzaOP == null)
          {
            if (((zzd)paramObject).zzaOP != null) {
              return false;
            }
          }
          else if (!this.zzaOP.equals(((zzd)paramObject).zzaOP)) {
            return false;
          }
          if (this.zzaOQ == null)
          {
            if (((zzd)paramObject).zzaOQ != null) {
              return false;
            }
          }
          else if (!this.zzaOQ.equals(((zzd)paramObject).zzaOQ)) {
            return false;
          }
          if (this.zzaOR == null)
          {
            if (((zzd)paramObject).zzaOR != null) {
              return false;
            }
          }
          else if (!this.zzaOR.equals(((zzd)paramObject).zzaOR)) {
            return false;
          }
          if (this.zzaOS == null)
          {
            if (((zzd)paramObject).zzaOS != null) {
              return false;
            }
          }
          else if (!this.zzaOS.equals(((zzd)paramObject).zzaOS)) {
            return false;
          }
          if (this.zzaOT == null)
          {
            if (((zzd)paramObject).zzaOT != null) {
              return false;
            }
          }
          else if (!this.zzaOT.equals(((zzd)paramObject).zzaOT)) {
            return false;
          }
          if (this.zzaOU == null)
          {
            if (((zzd)paramObject).zzaOU != null) {
              return false;
            }
          }
          else if (!this.zzaOU.equals(((zzd)paramObject).zzaOU)) {
            return false;
          }
          if (this.zzaOV == null)
          {
            if (((zzd)paramObject).zzaOV != null) {
              return false;
            }
          }
          else if (!this.zzaOV.equals(((zzd)paramObject).zzaOV)) {
            return false;
          }
          if (this.zzaOW == null)
          {
            if (((zzd)paramObject).zzaOW != null) {
              return false;
            }
          }
          else if (!this.zzaOW.equals(((zzd)paramObject).zzaOW)) {
            return false;
          }
          if (this.zzaLQ == null)
          {
            if (((zzd)paramObject).zzaLQ != null) {
              return false;
            }
          }
          else if (!this.zzaLQ.equals(((zzd)paramObject).zzaLQ)) {
            return false;
          }
          if (this.zzaOX == null)
          {
            if (((zzd)paramObject).zzaOX != null) {
              return false;
            }
          }
          else if (!this.zzaOX.equals(((zzd)paramObject).zzaOX)) {
            return false;
          }
          if (this.zzaDC == null)
          {
            if (((zzd)paramObject).zzaDC != null) {
              return false;
            }
          }
          else if (!this.zzaDC.equals(((zzd)paramObject).zzaDC)) {
            return false;
          }
          if (this.zzaOY == null)
          {
            if (((zzd)paramObject).zzaOY != null) {
              return false;
            }
          }
          else if (!this.zzaOY.equals(((zzd)paramObject).zzaOY)) {
            return false;
          }
          if (this.zzaOZ == null)
          {
            if (((zzd)paramObject).zzaOZ != null) {
              return false;
            }
          }
          else if (!this.zzaOZ.equals(((zzd)paramObject).zzaOZ)) {
            return false;
          }
          if (this.zzaPa == null)
          {
            if (((zzd)paramObject).zzaPa != null) {
              return false;
            }
          }
          else if (!this.zzaPa.equals(((zzd)paramObject).zzaPa)) {
            return false;
          }
          if (this.zzaPb == null)
          {
            if (((zzd)paramObject).zzaPb != null) {
              return false;
            }
          }
          else if (!this.zzaPb.equals(((zzd)paramObject).zzaPb)) {
            return false;
          }
          if (this.zzaPc == null)
          {
            if (((zzd)paramObject).zzaPc != null) {
              return false;
            }
          }
          else if (!this.zzaPc.equals(((zzd)paramObject).zzaPc)) {
            return false;
          }
          if (this.zzaPd == null)
          {
            if (((zzd)paramObject).zzaPd != null) {
              return false;
            }
          }
          else if (!this.zzaPd.equals(((zzd)paramObject).zzaPd)) {
            return false;
          }
          if (this.zzaPe == null)
          {
            if (((zzd)paramObject).zzaPe != null) {
              return false;
            }
          }
          else if (!this.zzaPe.equals(((zzd)paramObject).zzaPe)) {
            return false;
          }
          if (this.zzaPf == null)
          {
            if (((zzd)paramObject).zzaPf != null) {
              return false;
            }
          }
          else if (!this.zzaPf.equals(((zzd)paramObject).zzaPf)) {
            return false;
          }
          if (this.zzaLP == null)
          {
            if (((zzd)paramObject).zzaLP != null) {
              return false;
            }
          }
          else if (!this.zzaLP.equals(((zzd)paramObject).zzaLP)) {
            return false;
          }
          if (this.zzaPg != null) {
            break;
          }
        } while (((zzd)paramObject).zzaPg == null);
        return false;
      } while (this.zzaPg.equals(((zzd)paramObject).zzaPg));
      return false;
    }
    
    public int hashCode()
    {
      int i19 = 0;
      int i20 = getClass().getName().hashCode();
      int i;
      int i21;
      int i22;
      int j;
      label51:
      int k;
      label60:
      int m;
      label70:
      int n;
      label80:
      int i1;
      label90:
      int i2;
      label100:
      int i3;
      label110:
      int i4;
      label120:
      int i5;
      label130:
      int i6;
      label140:
      int i7;
      label150:
      int i8;
      label160:
      int i9;
      label170:
      int i10;
      label180:
      int i11;
      label190:
      int i12;
      label200:
      int i13;
      label210:
      int i14;
      label220:
      int i15;
      label230:
      int i16;
      label240:
      int i17;
      label250:
      int i18;
      if (this.zzaOK == null)
      {
        i = 0;
        i21 = zzsc.hashCode(this.zzaOL);
        i22 = zzsc.hashCode(this.zzaOM);
        if (this.zzaON != null) {
          break label438;
        }
        j = 0;
        if (this.zzaOO != null) {
          break label449;
        }
        k = 0;
        if (this.zzaOP != null) {
          break label460;
        }
        m = 0;
        if (this.zzaOQ != null) {
          break label472;
        }
        n = 0;
        if (this.zzaOR != null) {
          break label484;
        }
        i1 = 0;
        if (this.zzaOS != null) {
          break label496;
        }
        i2 = 0;
        if (this.zzaOT != null) {
          break label508;
        }
        i3 = 0;
        if (this.zzaOU != null) {
          break label520;
        }
        i4 = 0;
        if (this.zzaOV != null) {
          break label532;
        }
        i5 = 0;
        if (this.zzaOW != null) {
          break label544;
        }
        i6 = 0;
        if (this.zzaLQ != null) {
          break label556;
        }
        i7 = 0;
        if (this.zzaOX != null) {
          break label568;
        }
        i8 = 0;
        if (this.zzaDC != null) {
          break label580;
        }
        i9 = 0;
        if (this.zzaOY != null) {
          break label592;
        }
        i10 = 0;
        if (this.zzaOZ != null) {
          break label604;
        }
        i11 = 0;
        if (this.zzaPa != null) {
          break label616;
        }
        i12 = 0;
        if (this.zzaPb != null) {
          break label628;
        }
        i13 = 0;
        if (this.zzaPc != null) {
          break label640;
        }
        i14 = 0;
        if (this.zzaPd != null) {
          break label652;
        }
        i15 = 0;
        if (this.zzaPe != null) {
          break label664;
        }
        i16 = 0;
        if (this.zzaPf != null) {
          break label676;
        }
        i17 = 0;
        if (this.zzaLP != null) {
          break label688;
        }
        i18 = 0;
        label260:
        if (this.zzaPg != null) {
          break label700;
        }
      }
      for (;;)
      {
        return (i18 + (i17 + (i16 + (i15 + (i14 + (i13 + (i12 + (i11 + (i10 + (i9 + (i8 + (i7 + (i6 + (i5 + (i4 + (i3 + (i2 + (i1 + (n + (m + (k + (j + (((i + (i20 + 527) * 31) * 31 + i21) * 31 + i22) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31) * 31 + i19;
        i = this.zzaOK.hashCode();
        break;
        label438:
        j = this.zzaON.hashCode();
        break label51;
        label449:
        k = this.zzaOO.hashCode();
        break label60;
        label460:
        m = this.zzaOP.hashCode();
        break label70;
        label472:
        n = this.zzaOQ.hashCode();
        break label80;
        label484:
        i1 = this.zzaOR.hashCode();
        break label90;
        label496:
        i2 = this.zzaOS.hashCode();
        break label100;
        label508:
        i3 = this.zzaOT.hashCode();
        break label110;
        label520:
        i4 = this.zzaOU.hashCode();
        break label120;
        label532:
        i5 = this.zzaOV.hashCode();
        break label130;
        label544:
        i6 = this.zzaOW.hashCode();
        break label140;
        label556:
        i7 = this.zzaLQ.hashCode();
        break label150;
        label568:
        i8 = this.zzaOX.hashCode();
        break label160;
        label580:
        i9 = this.zzaDC.hashCode();
        break label170;
        label592:
        i10 = this.zzaOY.hashCode();
        break label180;
        label604:
        i11 = this.zzaOZ.hashCode();
        break label190;
        label616:
        i12 = this.zzaPa.hashCode();
        break label200;
        label628:
        i13 = this.zzaPb.hashCode();
        break label210;
        label640:
        i14 = this.zzaPc.hashCode();
        break label220;
        label652:
        i15 = this.zzaPd.hashCode();
        break label230;
        label664:
        i16 = this.zzaPe.hashCode();
        break label240;
        label676:
        i17 = this.zzaPf.hashCode();
        break label250;
        label688:
        i18 = this.zzaLP.hashCode();
        break label260;
        label700:
        i19 = this.zzaPg.hashCode();
      }
    }
    
    public zzd zzAD()
    {
      this.zzaOK = null;
      this.zzaOL = zzpk.zza.zzAx();
      this.zzaOM = zzpk.zze.zzAE();
      this.zzaON = null;
      this.zzaOO = null;
      this.zzaOP = null;
      this.zzaOQ = null;
      this.zzaOR = null;
      this.zzaOS = null;
      this.zzaOT = null;
      this.zzaOU = null;
      this.zzaOV = null;
      this.zzaOW = null;
      this.zzaLQ = null;
      this.zzaOX = null;
      this.zzaDC = null;
      this.zzaOY = null;
      this.zzaOZ = null;
      this.zzaPa = null;
      this.zzaPb = null;
      this.zzaPc = null;
      this.zzaPd = null;
      this.zzaPe = null;
      this.zzaPf = null;
      this.zzaLP = null;
      this.zzaPg = null;
      this.zzbiv = -1;
      return this;
    }
    
    protected int zzB()
    {
      int m = 0;
      int i = super.zzB();
      int j = i;
      if (this.zzaOK != null) {
        j = i + zzrx.zzA(1, this.zzaOK.intValue());
      }
      i = j;
      Object localObject;
      int k;
      if (this.zzaOL != null)
      {
        i = j;
        if (this.zzaOL.length > 0)
        {
          i = j;
          j = 0;
          while (j < this.zzaOL.length)
          {
            localObject = this.zzaOL[j];
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
      if (this.zzaOM != null)
      {
        j = i;
        if (this.zzaOM.length > 0)
        {
          k = m;
          for (;;)
          {
            j = i;
            if (k >= this.zzaOM.length) {
              break;
            }
            localObject = this.zzaOM[k];
            j = i;
            if (localObject != null) {
              j = i + zzrx.zzc(3, (zzse)localObject);
            }
            k += 1;
            i = j;
          }
        }
      }
      i = j;
      if (this.zzaON != null) {
        i = j + zzrx.zzd(4, this.zzaON.longValue());
      }
      j = i;
      if (this.zzaOO != null) {
        j = i + zzrx.zzd(5, this.zzaOO.longValue());
      }
      i = j;
      if (this.zzaOP != null) {
        i = j + zzrx.zzd(6, this.zzaOP.longValue());
      }
      j = i;
      if (this.zzaOR != null) {
        j = i + zzrx.zzd(7, this.zzaOR.longValue());
      }
      i = j;
      if (this.zzaOS != null) {
        i = j + zzrx.zzn(8, this.zzaOS);
      }
      j = i;
      if (this.zzaOT != null) {
        j = i + zzrx.zzn(9, this.zzaOT);
      }
      i = j;
      if (this.zzaOU != null) {
        i = j + zzrx.zzn(10, this.zzaOU);
      }
      j = i;
      if (this.zzaOV != null) {
        j = i + zzrx.zzn(11, this.zzaOV);
      }
      i = j;
      if (this.zzaOW != null) {
        i = j + zzrx.zzA(12, this.zzaOW.intValue());
      }
      j = i;
      if (this.zzaLQ != null) {
        j = i + zzrx.zzn(13, this.zzaLQ);
      }
      i = j;
      if (this.zzaOX != null) {
        i = j + zzrx.zzn(14, this.zzaOX);
      }
      j = i;
      if (this.zzaDC != null) {
        j = i + zzrx.zzn(16, this.zzaDC);
      }
      i = j;
      if (this.zzaOY != null) {
        i = j + zzrx.zzd(17, this.zzaOY.longValue());
      }
      j = i;
      if (this.zzaOZ != null) {
        j = i + zzrx.zzd(18, this.zzaOZ.longValue());
      }
      i = j;
      if (this.zzaPa != null) {
        i = j + zzrx.zzn(19, this.zzaPa);
      }
      j = i;
      if (this.zzaPb != null) {
        j = i + zzrx.zzc(20, this.zzaPb.booleanValue());
      }
      i = j;
      if (this.zzaPc != null) {
        i = j + zzrx.zzn(21, this.zzaPc);
      }
      j = i;
      if (this.zzaPd != null) {
        j = i + zzrx.zzd(22, this.zzaPd.longValue());
      }
      i = j;
      if (this.zzaPe != null) {
        i = j + zzrx.zzA(23, this.zzaPe.intValue());
      }
      j = i;
      if (this.zzaPf != null) {
        j = i + zzrx.zzn(24, this.zzaPf);
      }
      i = j;
      if (this.zzaLP != null) {
        i = j + zzrx.zzn(25, this.zzaLP);
      }
      j = i;
      if (this.zzaOQ != null) {
        j = i + zzrx.zzd(26, this.zzaOQ.longValue());
      }
      i = j;
      if (this.zzaPg != null) {
        i = j + zzrx.zzc(28, this.zzaPg.booleanValue());
      }
      return i;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      int j = 0;
      if (this.zzaOK != null) {
        paramzzrx.zzy(1, this.zzaOK.intValue());
      }
      int i;
      Object localObject;
      if ((this.zzaOL != null) && (this.zzaOL.length > 0))
      {
        i = 0;
        while (i < this.zzaOL.length)
        {
          localObject = this.zzaOL[i];
          if (localObject != null) {
            paramzzrx.zza(2, (zzse)localObject);
          }
          i += 1;
        }
      }
      if ((this.zzaOM != null) && (this.zzaOM.length > 0))
      {
        i = j;
        while (i < this.zzaOM.length)
        {
          localObject = this.zzaOM[i];
          if (localObject != null) {
            paramzzrx.zza(3, (zzse)localObject);
          }
          i += 1;
        }
      }
      if (this.zzaON != null) {
        paramzzrx.zzb(4, this.zzaON.longValue());
      }
      if (this.zzaOO != null) {
        paramzzrx.zzb(5, this.zzaOO.longValue());
      }
      if (this.zzaOP != null) {
        paramzzrx.zzb(6, this.zzaOP.longValue());
      }
      if (this.zzaOR != null) {
        paramzzrx.zzb(7, this.zzaOR.longValue());
      }
      if (this.zzaOS != null) {
        paramzzrx.zzb(8, this.zzaOS);
      }
      if (this.zzaOT != null) {
        paramzzrx.zzb(9, this.zzaOT);
      }
      if (this.zzaOU != null) {
        paramzzrx.zzb(10, this.zzaOU);
      }
      if (this.zzaOV != null) {
        paramzzrx.zzb(11, this.zzaOV);
      }
      if (this.zzaOW != null) {
        paramzzrx.zzy(12, this.zzaOW.intValue());
      }
      if (this.zzaLQ != null) {
        paramzzrx.zzb(13, this.zzaLQ);
      }
      if (this.zzaOX != null) {
        paramzzrx.zzb(14, this.zzaOX);
      }
      if (this.zzaDC != null) {
        paramzzrx.zzb(16, this.zzaDC);
      }
      if (this.zzaOY != null) {
        paramzzrx.zzb(17, this.zzaOY.longValue());
      }
      if (this.zzaOZ != null) {
        paramzzrx.zzb(18, this.zzaOZ.longValue());
      }
      if (this.zzaPa != null) {
        paramzzrx.zzb(19, this.zzaPa);
      }
      if (this.zzaPb != null) {
        paramzzrx.zzb(20, this.zzaPb.booleanValue());
      }
      if (this.zzaPc != null) {
        paramzzrx.zzb(21, this.zzaPc);
      }
      if (this.zzaPd != null) {
        paramzzrx.zzb(22, this.zzaPd.longValue());
      }
      if (this.zzaPe != null) {
        paramzzrx.zzy(23, this.zzaPe.intValue());
      }
      if (this.zzaPf != null) {
        paramzzrx.zzb(24, this.zzaPf);
      }
      if (this.zzaLP != null) {
        paramzzrx.zzb(25, this.zzaLP);
      }
      if (this.zzaOQ != null) {
        paramzzrx.zzb(26, this.zzaOQ.longValue());
      }
      if (this.zzaPg != null) {
        paramzzrx.zzb(28, this.zzaPg.booleanValue());
      }
      super.zza(paramzzrx);
    }
    
    public zzd zzx(zzrw paramzzrw)
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
          if (zzsh.zzb(paramzzrw, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          this.zzaOK = Integer.valueOf(paramzzrw.zzFr());
          break;
        case 18: 
          j = zzsh.zzc(paramzzrw, 18);
          if (this.zzaOL == null) {}
          for (i = 0;; i = this.zzaOL.length)
          {
            localObject = new zzpk.zza[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzaOL, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzpk.zza();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zzpk.zza();
          paramzzrw.zza(localObject[j]);
          this.zzaOL = ((zzpk.zza[])localObject);
          break;
        case 26: 
          j = zzsh.zzc(paramzzrw, 26);
          if (this.zzaOM == null) {}
          for (i = 0;; i = this.zzaOM.length)
          {
            localObject = new zzpk.zze[j + i];
            j = i;
            if (i != 0)
            {
              System.arraycopy(this.zzaOM, 0, localObject, 0, i);
              j = i;
            }
            while (j < localObject.length - 1)
            {
              localObject[j] = new zzpk.zze();
              paramzzrw.zza(localObject[j]);
              paramzzrw.zzFo();
              j += 1;
            }
          }
          localObject[j] = new zzpk.zze();
          paramzzrw.zza(localObject[j]);
          this.zzaOM = ((zzpk.zze[])localObject);
          break;
        case 32: 
          this.zzaON = Long.valueOf(paramzzrw.zzFq());
          break;
        case 40: 
          this.zzaOO = Long.valueOf(paramzzrw.zzFq());
          break;
        case 48: 
          this.zzaOP = Long.valueOf(paramzzrw.zzFq());
          break;
        case 56: 
          this.zzaOR = Long.valueOf(paramzzrw.zzFq());
          break;
        case 66: 
          this.zzaOS = paramzzrw.readString();
          break;
        case 74: 
          this.zzaOT = paramzzrw.readString();
          break;
        case 82: 
          this.zzaOU = paramzzrw.readString();
          break;
        case 90: 
          this.zzaOV = paramzzrw.readString();
          break;
        case 96: 
          this.zzaOW = Integer.valueOf(paramzzrw.zzFr());
          break;
        case 106: 
          this.zzaLQ = paramzzrw.readString();
          break;
        case 114: 
          this.zzaOX = paramzzrw.readString();
          break;
        case 130: 
          this.zzaDC = paramzzrw.readString();
          break;
        case 136: 
          this.zzaOY = Long.valueOf(paramzzrw.zzFq());
          break;
        case 144: 
          this.zzaOZ = Long.valueOf(paramzzrw.zzFq());
          break;
        case 154: 
          this.zzaPa = paramzzrw.readString();
          break;
        case 160: 
          this.zzaPb = Boolean.valueOf(paramzzrw.zzFs());
          break;
        case 170: 
          this.zzaPc = paramzzrw.readString();
          break;
        case 176: 
          this.zzaPd = Long.valueOf(paramzzrw.zzFq());
          break;
        case 184: 
          this.zzaPe = Integer.valueOf(paramzzrw.zzFr());
          break;
        case 194: 
          this.zzaPf = paramzzrw.readString();
          break;
        case 202: 
          this.zzaLP = paramzzrw.readString();
          break;
        case 208: 
          this.zzaOQ = Long.valueOf(paramzzrw.zzFq());
          break;
        case 224: 
          this.zzaPg = Boolean.valueOf(paramzzrw.zzFs());
        }
      }
    }
  }
  
  public static final class zze
    extends zzse
  {
    private static volatile zze[] zzaPh;
    public String name;
    public Float zzaOB;
    public Long zzaOH;
    public Long zzaPi;
    public String zzagS;
    
    public zze()
    {
      zzAF();
    }
    
    public static zze[] zzAE()
    {
      if (zzaPh == null) {}
      synchronized (zzsc.zzbiu)
      {
        if (zzaPh == null) {
          zzaPh = new zze[0];
        }
        return zzaPh;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {}
      do
      {
        do
        {
          return true;
          if (!(paramObject instanceof zze)) {
            return false;
          }
          paramObject = (zze)paramObject;
          if (this.zzaPi == null)
          {
            if (((zze)paramObject).zzaPi != null) {
              return false;
            }
          }
          else if (!this.zzaPi.equals(((zze)paramObject).zzaPi)) {
            return false;
          }
          if (this.name == null)
          {
            if (((zze)paramObject).name != null) {
              return false;
            }
          }
          else if (!this.name.equals(((zze)paramObject).name)) {
            return false;
          }
          if (this.zzagS == null)
          {
            if (((zze)paramObject).zzagS != null) {
              return false;
            }
          }
          else if (!this.zzagS.equals(((zze)paramObject).zzagS)) {
            return false;
          }
          if (this.zzaOH == null)
          {
            if (((zze)paramObject).zzaOH != null) {
              return false;
            }
          }
          else if (!this.zzaOH.equals(((zze)paramObject).zzaOH)) {
            return false;
          }
          if (this.zzaOB != null) {
            break;
          }
        } while (((zze)paramObject).zzaOB == null);
        return false;
      } while (this.zzaOB.equals(((zze)paramObject).zzaOB));
      return false;
    }
    
    public int hashCode()
    {
      int n = 0;
      int i1 = getClass().getName().hashCode();
      int i;
      int j;
      label33:
      int k;
      label42:
      int m;
      if (this.zzaPi == null)
      {
        i = 0;
        if (this.name != null) {
          break label104;
        }
        j = 0;
        if (this.zzagS != null) {
          break label115;
        }
        k = 0;
        if (this.zzaOH != null) {
          break label126;
        }
        m = 0;
        label52:
        if (this.zzaOB != null) {
          break label138;
        }
      }
      for (;;)
      {
        return (m + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31) * 31 + n;
        i = this.zzaPi.hashCode();
        break;
        label104:
        j = this.name.hashCode();
        break label33;
        label115:
        k = this.zzagS.hashCode();
        break label42;
        label126:
        m = this.zzaOH.hashCode();
        break label52;
        label138:
        n = this.zzaOB.hashCode();
      }
    }
    
    public zze zzAF()
    {
      this.zzaPi = null;
      this.name = null;
      this.zzagS = null;
      this.zzaOH = null;
      this.zzaOB = null;
      this.zzbiv = -1;
      return this;
    }
    
    protected int zzB()
    {
      int j = super.zzB();
      int i = j;
      if (this.zzaPi != null) {
        i = j + zzrx.zzd(1, this.zzaPi.longValue());
      }
      j = i;
      if (this.name != null) {
        j = i + zzrx.zzn(2, this.name);
      }
      i = j;
      if (this.zzagS != null) {
        i = j + zzrx.zzn(3, this.zzagS);
      }
      j = i;
      if (this.zzaOH != null) {
        j = i + zzrx.zzd(4, this.zzaOH.longValue());
      }
      i = j;
      if (this.zzaOB != null) {
        i = j + zzrx.zzc(5, this.zzaOB.floatValue());
      }
      return i;
    }
    
    public void zza(zzrx paramzzrx)
      throws IOException
    {
      if (this.zzaPi != null) {
        paramzzrx.zzb(1, this.zzaPi.longValue());
      }
      if (this.name != null) {
        paramzzrx.zzb(2, this.name);
      }
      if (this.zzagS != null) {
        paramzzrx.zzb(3, this.zzagS);
      }
      if (this.zzaOH != null) {
        paramzzrx.zzb(4, this.zzaOH.longValue());
      }
      if (this.zzaOB != null) {
        paramzzrx.zzb(5, this.zzaOB.floatValue());
      }
      super.zza(paramzzrx);
    }
    
    public zze zzy(zzrw paramzzrw)
      throws IOException
    {
      for (;;)
      {
        int i = paramzzrw.zzFo();
        switch (i)
        {
        default: 
          if (zzsh.zzb(paramzzrw, i)) {}
          break;
        case 0: 
          return this;
        case 8: 
          this.zzaPi = Long.valueOf(paramzzrw.zzFq());
          break;
        case 18: 
          this.name = paramzzrw.readString();
          break;
        case 26: 
          this.zzagS = paramzzrw.readString();
          break;
        case 32: 
          this.zzaOH = Long.valueOf(paramzzrw.zzFq());
          break;
        case 45: 
          this.zzaOB = Float.valueOf(paramzzrw.readFloat());
        }
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzpk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */