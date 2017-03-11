package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public abstract class zzc
{
  protected final DataHolder zzabq;
  protected int zzadl;
  private int zzadm;
  
  public zzc(DataHolder paramDataHolder, int paramInt)
  {
    this.zzabq = ((DataHolder)zzx.zzw(paramDataHolder));
    zzbr(paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof zzc))
    {
      paramObject = (zzc)paramObject;
      bool1 = bool2;
      if (zzw.equal(Integer.valueOf(((zzc)paramObject).zzadl), Integer.valueOf(this.zzadl)))
      {
        bool1 = bool2;
        if (zzw.equal(Integer.valueOf(((zzc)paramObject).zzadm), Integer.valueOf(this.zzadm)))
        {
          bool1 = bool2;
          if (((zzc)paramObject).zzabq == this.zzabq) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return this.zzabq.zze(paramString, this.zzadl, this.zzadm);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return this.zzabq.zzg(paramString, this.zzadl, this.zzadm);
  }
  
  protected float getFloat(String paramString)
  {
    return this.zzabq.zzf(paramString, this.zzadl, this.zzadm);
  }
  
  protected int getInteger(String paramString)
  {
    return this.zzabq.zzc(paramString, this.zzadl, this.zzadm);
  }
  
  protected long getLong(String paramString)
  {
    return this.zzabq.zzb(paramString, this.zzadl, this.zzadm);
  }
  
  protected String getString(String paramString)
  {
    return this.zzabq.zzd(paramString, this.zzadl, this.zzadm);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.zzadl), Integer.valueOf(this.zzadm), this.zzabq });
  }
  
  public boolean isDataValid()
  {
    return !this.zzabq.isClosed();
  }
  
  protected void zza(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.zzabq.zza(paramString, this.zzadl, this.zzadm, paramCharArrayBuffer);
  }
  
  protected void zzbr(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.zzabq.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzZ(bool);
      this.zzadl = paramInt;
      this.zzadm = this.zzabq.zzbt(this.zzadl);
      return;
    }
  }
  
  public boolean zzce(String paramString)
  {
    return this.zzabq.zzce(paramString);
  }
  
  protected Uri zzcf(String paramString)
  {
    return this.zzabq.zzh(paramString, this.zzadl, this.zzadm);
  }
  
  protected boolean zzcg(String paramString)
  {
    return this.zzabq.zzi(paramString, this.zzadl, this.zzadm);
  }
  
  protected int zzou()
  {
    return this.zzadl;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\data\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */