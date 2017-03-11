package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.playlog.internal.LogEvent;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import com.google.android.gms.playlog.internal.zzd;

@Deprecated
public class zzqd
{
  private final com.google.android.gms.playlog.internal.zzf zzaRE;
  private PlayLoggerContext zzaRF;
  
  public zzqd(Context paramContext, int paramInt, String paramString1, String paramString2, zza paramzza, boolean paramBoolean, String paramString3)
  {
    String str = paramContext.getPackageName();
    int i = 0;
    try
    {
      int j = paramContext.getPackageManager().getPackageInfo(str, 0).versionCode;
      i = j;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Log.wtf("PlayLogger", "This can't happen.", localNameNotFoundException);
      }
    }
    this.zzaRF = new PlayLoggerContext(str, i, paramInt, paramString1, paramString2, paramBoolean);
    this.zzaRE = new com.google.android.gms.playlog.internal.zzf(paramContext, paramContext.getMainLooper(), new zzd(paramzza), new com.google.android.gms.common.internal.zzf(null, null, null, 49, null, str, paramString3, null));
  }
  
  public void start()
  {
    this.zzaRE.start();
  }
  
  public void stop()
  {
    this.zzaRE.stop();
  }
  
  public void zza(long paramLong, String paramString, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    this.zzaRE.zzb(this.zzaRF, new LogEvent(paramLong, 0L, paramString, paramArrayOfByte, paramVarArgs));
  }
  
  public void zzb(String paramString, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    zza(System.currentTimeMillis(), paramString, paramArrayOfByte, paramVarArgs);
  }
  
  public static abstract interface zza
  {
    public abstract void zzBr();
    
    public abstract void zzBs();
    
    public abstract void zzf(PendingIntent paramPendingIntent);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzqd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */