package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.ArrayList;
import java.util.Iterator;

@zzgr
public class zzbh
{
  private final Object zzpd = new Object();
  private final int zzrN;
  private final int zzrO;
  private final int zzrP;
  private final zzbm zzrQ;
  private ArrayList<String> zzrR = new ArrayList();
  private int zzrS = 0;
  private int zzrT = 0;
  private int zzrU = 0;
  private int zzrV;
  private String zzrW = "";
  
  public zzbh(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.zzrN = paramInt1;
    this.zzrO = paramInt2;
    this.zzrP = paramInt3;
    this.zzrQ = new zzbm(paramInt4);
  }
  
  private String zza(ArrayList<String> paramArrayList, int paramInt)
  {
    if (paramArrayList.isEmpty()) {
      paramArrayList = "";
    }
    Object localObject;
    do
    {
      return paramArrayList;
      localObject = new StringBuffer();
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        ((StringBuffer)localObject).append((String)paramArrayList.next());
        ((StringBuffer)localObject).append(' ');
      } while (((StringBuffer)localObject).length() <= paramInt);
      ((StringBuffer)localObject).deleteCharAt(((StringBuffer)localObject).length() - 1);
      localObject = ((StringBuffer)localObject).toString();
      paramArrayList = (ArrayList<String>)localObject;
    } while (((String)localObject).length() < paramInt);
    return ((String)localObject).substring(0, paramInt);
  }
  
  private void zzx(String paramString)
  {
    if ((paramString == null) || (paramString.length() < this.zzrP)) {
      return;
    }
    synchronized (this.zzpd)
    {
      this.zzrR.add(paramString);
      this.zzrS += paramString.length();
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzbh)) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      paramObject = (zzbh)paramObject;
    } while ((((zzbh)paramObject).zzcm() == null) || (!((zzbh)paramObject).zzcm().equals(zzcm())));
    return true;
  }
  
  public int getScore()
  {
    return this.zzrV;
  }
  
  public int hashCode()
  {
    return zzcm().hashCode();
  }
  
  public String toString()
  {
    return "ActivityContent fetchId: " + this.zzrT + " score:" + this.zzrV + " total_length:" + this.zzrS + "\n text: " + zza(this.zzrR, 200) + "\n signture: " + this.zzrW;
  }
  
  int zza(int paramInt1, int paramInt2)
  {
    return this.zzrN * paramInt1 + this.zzrO * paramInt2;
  }
  
  public boolean zzcl()
  {
    for (;;)
    {
      synchronized (this.zzpd)
      {
        if (this.zzrU == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public String zzcm()
  {
    return this.zzrW;
  }
  
  public void zzcn()
  {
    synchronized (this.zzpd)
    {
      this.zzrV -= 100;
      return;
    }
  }
  
  public void zzco()
  {
    synchronized (this.zzpd)
    {
      this.zzrU -= 1;
      return;
    }
  }
  
  public void zzcp()
  {
    synchronized (this.zzpd)
    {
      this.zzrU += 1;
      return;
    }
  }
  
  public void zzcq()
  {
    synchronized (this.zzpd)
    {
      int i = zza(this.zzrS, this.zzrT);
      if (i > this.zzrV)
      {
        this.zzrV = i;
        this.zzrW = this.zzrQ.zza(this.zzrR);
      }
      return;
    }
  }
  
  int zzcr()
  {
    return this.zzrS;
  }
  
  public void zzg(int paramInt)
  {
    this.zzrT = paramInt;
  }
  
  public void zzv(String arg1)
  {
    zzx(???);
    synchronized (this.zzpd)
    {
      if (this.zzrU < 0) {
        zzb.zzaF("ActivityContent: negative number of WebViews.");
      }
      zzcq();
      return;
    }
  }
  
  public void zzw(String paramString)
  {
    zzx(paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */