package com.google.android.gms.tagmanager;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class zzdb
  extends zzak
{
  private static final String ID = zzad.zzcQ.toString();
  private static final String NAME = zzae.zzfR.toString();
  private static final String zzaZu = zzae.zzfw.toString();
  private static final String zzaZv = zzae.zzfE.toString();
  private static final String zzaZw = zzae.zzhv.toString();
  private final Context mContext;
  private Handler mHandler;
  private DataLayer zzaVR;
  private final Set<String> zzaZA = new HashSet();
  private boolean zzaZx;
  private boolean zzaZy;
  private final HandlerThread zzaZz;
  
  public zzdb(Context paramContext, DataLayer paramDataLayer)
  {
    super(ID, new String[] { zzaZu, NAME });
    this.mContext = paramContext;
    this.zzaVR = paramDataLayer;
    this.zzaZz = new HandlerThread("Google GTM SDK Timer", 10);
    this.zzaZz.start();
    this.mHandler = new Handler(this.zzaZz.getLooper());
  }
  
  public boolean zzCo()
  {
    return false;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    String str2 = zzdf.zzg((zzag.zza)paramMap.get(NAME));
    String str1 = zzdf.zzg((zzag.zza)paramMap.get(zzaZw));
    String str3 = zzdf.zzg((zzag.zza)paramMap.get(zzaZu));
    paramMap = zzdf.zzg((zzag.zza)paramMap.get(zzaZv));
    try
    {
      l1 = Long.parseLong(str3);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      try
      {
        for (;;)
        {
          l2 = Long.parseLong(paramMap);
          if ((l1 > 0L) && (!TextUtils.isEmpty(str2)))
          {
            if (str1 != null)
            {
              paramMap = str1;
              if (!str1.isEmpty()) {}
            }
            else
            {
              paramMap = "0";
            }
            if (!this.zzaZA.contains(paramMap))
            {
              if (!"0".equals(paramMap)) {
                this.zzaZA.add(paramMap);
              }
              this.mHandler.postDelayed(new zza(str2, paramMap, l1, l2), l1);
            }
          }
          return zzdf.zzDX();
          localNumberFormatException = localNumberFormatException;
          long l1 = 0L;
        }
      }
      catch (NumberFormatException paramMap)
      {
        for (;;)
        {
          long l2 = 0L;
        }
      }
    }
  }
  
  private final class zza
    implements Runnable
  {
    private final long zzaEE;
    private final String zzaZB;
    private final String zzaZC;
    private final long zzaZD;
    private long zzaZE;
    private final long zzzB;
    
    zza(String paramString1, String paramString2, long paramLong1, long paramLong2)
    {
      this.zzaZB = paramString1;
      this.zzaZC = paramString2;
      this.zzaEE = paramLong1;
      this.zzaZD = paramLong2;
      this.zzzB = System.currentTimeMillis();
    }
    
    public void run()
    {
      if ((this.zzaZD > 0L) && (this.zzaZE >= this.zzaZD))
      {
        if (!"0".equals(this.zzaZC)) {
          zzdb.zza(zzdb.this).remove(this.zzaZC);
        }
        return;
      }
      this.zzaZE += 1L;
      if (zzcu())
      {
        long l = System.currentTimeMillis();
        zzdb.zzb(zzdb.this).push(DataLayer.mapOf(new Object[] { "event", this.zzaZB, "gtm.timerInterval", String.valueOf(this.zzaEE), "gtm.timerLimit", String.valueOf(this.zzaZD), "gtm.timerStartTime", String.valueOf(this.zzzB), "gtm.timerCurrentTime", String.valueOf(l), "gtm.timerElapsedTime", String.valueOf(l - this.zzzB), "gtm.timerEventNumber", String.valueOf(this.zzaZE), "gtm.triggers", this.zzaZC }));
      }
      zzdb.zzc(zzdb.this).postDelayed(this, this.zzaEE);
    }
    
    protected boolean zzcu()
    {
      if (zzdb.zzd(zzdb.this)) {
        return zzdb.zze(zzdb.this);
      }
      Object localObject = (ActivityManager)zzdb.zzf(zzdb.this).getSystemService("activity");
      KeyguardManager localKeyguardManager = (KeyguardManager)zzdb.zzf(zzdb.this).getSystemService("keyguard");
      PowerManager localPowerManager = (PowerManager)zzdb.zzf(zzdb.this).getSystemService("power");
      localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if ((Process.myPid() == localRunningAppProcessInfo.pid) && (localRunningAppProcessInfo.importance == 100) && (!localKeyguardManager.inKeyguardRestrictedInputMode()) && (localPowerManager.isScreenOn())) {
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */