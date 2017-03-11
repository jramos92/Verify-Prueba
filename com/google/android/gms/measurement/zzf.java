package com.google.android.gms.measurement;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class zzf<T extends zzf>
{
  private final zzg zzaKZ;
  protected final zzc zzaLa;
  private final List<zzd> zzaLb;
  
  protected zzf(zzg paramzzg, zzmn paramzzmn)
  {
    zzx.zzw(paramzzg);
    this.zzaKZ = paramzzg;
    this.zzaLb = new ArrayList();
    paramzzg = new zzc(this, paramzzmn);
    paramzzg.zzyo();
    this.zzaLa = paramzzg;
  }
  
  protected void zza(zzc paramzzc) {}
  
  protected void zzd(zzc paramzzc)
  {
    Iterator localIterator = this.zzaLb.iterator();
    while (localIterator.hasNext()) {
      ((zzd)localIterator.next()).zza(this, paramzzc);
    }
  }
  
  public zzc zzhG()
  {
    zzc localzzc = this.zzaLa.zzye();
    zzd(localzzc);
    return localzzc;
  }
  
  protected zzg zzym()
  {
    return this.zzaKZ;
  }
  
  public zzc zzyp()
  {
    return this.zzaLa;
  }
  
  public List<zzi> zzyq()
  {
    return this.zzaLa.zzyg();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */