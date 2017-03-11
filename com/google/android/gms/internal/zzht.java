package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zzgr
public class zzht
{
  private boolean zzGb = false;
  private final LinkedList<zza> zzHE;
  private final String zzHF;
  private final String zzHG;
  private long zzHH = -1L;
  private long zzHI = -1L;
  private long zzHJ = -1L;
  private long zzHK = 0L;
  private long zzHL = -1L;
  private long zzHM = -1L;
  private final zzhu zzpV;
  private final Object zzpd = new Object();
  
  public zzht(zzhu paramzzhu, String paramString1, String paramString2)
  {
    this.zzpV = paramzzhu;
    this.zzHF = paramString1;
    this.zzHG = paramString2;
    this.zzHE = new LinkedList();
  }
  
  public zzht(String paramString1, String paramString2)
  {
    this(zzp.zzby(), paramString1, paramString2);
  }
  
  public Bundle toBundle()
  {
    ArrayList localArrayList;
    synchronized (this.zzpd)
    {
      Bundle localBundle1 = new Bundle();
      localBundle1.putString("seq_num", this.zzHF);
      localBundle1.putString("slotid", this.zzHG);
      localBundle1.putBoolean("ismediation", this.zzGb);
      localBundle1.putLong("treq", this.zzHL);
      localBundle1.putLong("tresponse", this.zzHM);
      localBundle1.putLong("timp", this.zzHI);
      localBundle1.putLong("tload", this.zzHJ);
      localBundle1.putLong("pcc", this.zzHK);
      localBundle1.putLong("tfetch", this.zzHH);
      localArrayList = new ArrayList();
      Iterator localIterator = this.zzHE.iterator();
      if (localIterator.hasNext()) {
        localArrayList.add(((zza)localIterator.next()).toBundle());
      }
    }
    localBundle2.putParcelableArrayList("tclick", localArrayList);
    return localBundle2;
  }
  
  public void zzgf()
  {
    synchronized (this.zzpd)
    {
      if ((this.zzHM != -1L) && (this.zzHI == -1L))
      {
        this.zzHI = SystemClock.elapsedRealtime();
        this.zzpV.zza(this);
      }
      this.zzpV.zzgn().zzgf();
      return;
    }
  }
  
  public void zzgg()
  {
    synchronized (this.zzpd)
    {
      if (this.zzHM != -1L)
      {
        zza localzza = new zza();
        localzza.zzgk();
        this.zzHE.add(localzza);
        this.zzHK += 1L;
        this.zzpV.zzgn().zzgg();
        this.zzpV.zza(this);
      }
      return;
    }
  }
  
  public void zzgh()
  {
    synchronized (this.zzpd)
    {
      if ((this.zzHM != -1L) && (!this.zzHE.isEmpty()))
      {
        zza localzza = (zza)this.zzHE.getLast();
        if (localzza.zzgi() == -1L)
        {
          localzza.zzgj();
          this.zzpV.zza(this);
        }
      }
      return;
    }
  }
  
  public void zzi(AdRequestParcel paramAdRequestParcel)
  {
    synchronized (this.zzpd)
    {
      this.zzHL = SystemClock.elapsedRealtime();
      this.zzpV.zzgn().zzb(paramAdRequestParcel, this.zzHL);
      return;
    }
  }
  
  public void zzl(long paramLong)
  {
    synchronized (this.zzpd)
    {
      this.zzHM = paramLong;
      if (this.zzHM != -1L) {
        this.zzpV.zza(this);
      }
      return;
    }
  }
  
  public void zzm(long paramLong)
  {
    synchronized (this.zzpd)
    {
      if (this.zzHM != -1L)
      {
        this.zzHH = paramLong;
        this.zzpV.zza(this);
      }
      return;
    }
  }
  
  public void zzy(boolean paramBoolean)
  {
    synchronized (this.zzpd)
    {
      if (this.zzHM != -1L)
      {
        this.zzHJ = SystemClock.elapsedRealtime();
        if (!paramBoolean)
        {
          this.zzHI = this.zzHJ;
          this.zzpV.zza(this);
        }
      }
      return;
    }
  }
  
  public void zzz(boolean paramBoolean)
  {
    synchronized (this.zzpd)
    {
      if (this.zzHM != -1L)
      {
        this.zzGb = paramBoolean;
        this.zzpV.zza(this);
      }
      return;
    }
  }
  
  @zzgr
  private static final class zza
  {
    private long zzHN = -1L;
    private long zzHO = -1L;
    
    public Bundle toBundle()
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("topen", this.zzHN);
      localBundle.putLong("tclose", this.zzHO);
      return localBundle;
    }
    
    public long zzgi()
    {
      return this.zzHO;
    }
    
    public void zzgj()
    {
      this.zzHO = SystemClock.elapsedRealtime();
    }
    
    public void zzgk()
    {
      this.zzHN = SystemClock.elapsedRealtime();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */