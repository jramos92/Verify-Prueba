package com.google.android.gms.playlog.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzsi.zzd;
import java.util.ArrayList;

public class zzb
{
  private final ArrayList<zza> zzaRK = new ArrayList();
  private int zzaRL;
  
  public zzb()
  {
    this(100);
  }
  
  public zzb(int paramInt)
  {
    this.zzaRL = paramInt;
  }
  
  private void zzBu()
  {
    while (getSize() > getCapacity()) {
      this.zzaRK.remove(0);
    }
  }
  
  public void clear()
  {
    this.zzaRK.clear();
  }
  
  public int getCapacity()
  {
    return this.zzaRL;
  }
  
  public int getSize()
  {
    return this.zzaRK.size();
  }
  
  public boolean isEmpty()
  {
    return this.zzaRK.isEmpty();
  }
  
  public ArrayList<zza> zzBt()
  {
    return this.zzaRK;
  }
  
  public void zza(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
  {
    this.zzaRK.add(new zza(paramPlayLoggerContext, paramLogEvent, null));
    zzBu();
  }
  
  public static class zza
  {
    public final PlayLoggerContext zzaRM;
    public final LogEvent zzaRN;
    public final zzsi.zzd zzaRO;
    
    private zza(PlayLoggerContext paramPlayLoggerContext, LogEvent paramLogEvent)
    {
      this.zzaRM = ((PlayLoggerContext)zzx.zzw(paramPlayLoggerContext));
      this.zzaRN = ((LogEvent)zzx.zzw(paramLogEvent));
      this.zzaRO = null;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\playlog\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */