package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.zzw;

public final class zzlv
  extends zzmg<zza, Drawable>
{
  public zzlv()
  {
    super(10);
  }
  
  public static final class zza
  {
    public final int zzaeE;
    public final int zzaeF;
    
    public zza(int paramInt1, int paramInt2)
    {
      this.zzaeE = paramInt1;
      this.zzaeF = paramInt2;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = true;
      boolean bool1;
      if (!(paramObject instanceof zza)) {
        bool1 = false;
      }
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this == paramObject);
        paramObject = (zza)paramObject;
        if (((zza)paramObject).zzaeE != this.zzaeE) {
          break;
        }
        bool1 = bool2;
      } while (((zza)paramObject).zzaeF == this.zzaeF);
      return false;
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { Integer.valueOf(this.zzaeE), Integer.valueOf(this.zzaeF) });
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzlv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */