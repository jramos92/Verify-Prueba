package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

public class zze
{
  private final long zzahV;
  private final int zzahW;
  private final SimpleArrayMap<String, Long> zzahX;
  
  public zze()
  {
    this.zzahV = 60000L;
    this.zzahW = 10;
    this.zzahX = new SimpleArrayMap(10);
  }
  
  public zze(int paramInt, long paramLong)
  {
    this.zzahV = paramLong;
    this.zzahW = paramInt;
    this.zzahX = new SimpleArrayMap();
  }
  
  private void zzb(long paramLong1, long paramLong2)
  {
    int i = this.zzahX.size() - 1;
    while (i >= 0)
    {
      if (paramLong2 - ((Long)this.zzahX.valueAt(i)).longValue() > paramLong1) {
        this.zzahX.removeAt(i);
      }
      i -= 1;
    }
  }
  
  public Long zzcx(String paramString)
  {
    long l2 = SystemClock.elapsedRealtime();
    long l1 = this.zzahV;
    try
    {
      while (this.zzahX.size() >= this.zzahW)
      {
        zzb(l1, l2);
        l1 /= 2L;
        Log.w("ConnectionTracker", "The max capacity " + this.zzahW + " is not enough. Current durationThreshold is: " + l1);
      }
      paramString = (Long)this.zzahX.put(paramString, Long.valueOf(l2));
    }
    finally {}
    return paramString;
  }
  
  public boolean zzcy(String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.zzahX.remove(paramString) != null)
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\stats\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */