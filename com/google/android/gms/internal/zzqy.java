package com.google.android.gms.internal;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzg;
import com.google.android.gms.common.stats.zzi;

public class zzqy
{
  private static boolean DEBUG = false;
  private static String TAG = "WakeLock";
  private final Context mContext;
  private final PowerManager.WakeLock zzaVs;
  private WorkSource zzaVt;
  private final int zzaVu;
  private final String zzaVv;
  private boolean zzaVw = true;
  private int zzaVx;
  private int zzaVy;
  private final String zzaia;
  
  public zzqy(Context paramContext, int paramInt, String paramString)
  {
    this(paramContext, paramInt, paramString, null, null);
  }
  
  public zzqy(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    zzx.zzh(paramString1, "Wake lock name can NOT be empty");
    this.zzaVu = paramInt;
    this.zzaia = paramString1;
    this.zzaVv = paramString2;
    this.mContext = paramContext.getApplicationContext();
    this.zzaVs = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(paramInt, paramString1);
    if (zznc.zzar(this.mContext))
    {
      paramString1 = paramString3;
      if (zznb.zzcA(paramString3))
      {
        if ((!zzd.zzaeK) || (!zzlr.isInitialized())) {
          break label153;
        }
        Log.e(TAG, "callingPackage is not supposed to be empty for wakelock " + this.zzaia + "!", new IllegalArgumentException());
      }
    }
    label153:
    for (paramString1 = "com.google.android.gms";; paramString1 = paramContext.getPackageName())
    {
      this.zzaVt = zznc.zzm(paramContext, paramString1);
      zzc(this.zzaVt);
      return;
    }
  }
  
  private void zzeu(String paramString)
  {
    boolean bool = zzev(paramString);
    String str = zzj(paramString, bool);
    if (DEBUG) {
      Log.d(TAG, "Release:\n mWakeLockName: " + this.zzaia + "\n mSecondaryName: " + this.zzaVv + "\nmReferenceCounted: " + this.zzaVw + "\nreason: " + paramString + "\n mOpenEventCount" + this.zzaVy + "\nuseWithReason: " + bool + "\ntrackingName: " + str);
    }
    try
    {
      if (this.zzaVw)
      {
        int i = this.zzaVx - 1;
        this.zzaVx = i;
        if ((i == 0) || (bool)) {}
      }
      else
      {
        if ((this.zzaVw) || (this.zzaVy != 1)) {
          break label205;
        }
      }
      zzi.zzqr().zza(this.mContext, zzg.zza(this.zzaVs, str), 8, this.zzaia, str, this.zzaVu, zznc.zzb(this.zzaVt));
      this.zzaVy -= 1;
      label205:
      return;
    }
    finally {}
  }
  
  private boolean zzev(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.zzaVv));
  }
  
  private void zzi(String paramString, long paramLong)
  {
    boolean bool = zzev(paramString);
    String str = zzj(paramString, bool);
    if (DEBUG) {
      Log.d(TAG, "Acquire:\n mWakeLockName: " + this.zzaia + "\n mSecondaryName: " + this.zzaVv + "\nmReferenceCounted: " + this.zzaVw + "\nreason: " + paramString + "\nmOpenEventCount" + this.zzaVy + "\nuseWithReason: " + bool + "\ntrackingName: " + str + "\ntimeout: " + paramLong);
    }
    try
    {
      if (this.zzaVw)
      {
        int i = this.zzaVx;
        this.zzaVx = (i + 1);
        if ((i == 0) || (bool)) {}
      }
      else
      {
        if ((this.zzaVw) || (this.zzaVy != 0)) {
          break label221;
        }
      }
      zzi.zzqr().zza(this.mContext, zzg.zza(this.zzaVs, str), 7, this.zzaia, str, this.zzaVu, zznc.zzb(this.zzaVt), paramLong);
      this.zzaVy += 1;
      label221:
      return;
    }
    finally {}
  }
  
  private String zzj(String paramString, boolean paramBoolean)
  {
    if (this.zzaVw)
    {
      if (paramBoolean) {
        return paramString;
      }
      return this.zzaVv;
    }
    return this.zzaVv;
  }
  
  public void acquire(long paramLong)
  {
    if ((!zzmx.zzqx()) && (this.zzaVw)) {
      Log.wtf(TAG, "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: " + this.zzaia);
    }
    zzi(null, paramLong);
    this.zzaVs.acquire(paramLong);
  }
  
  public boolean isHeld()
  {
    return this.zzaVs.isHeld();
  }
  
  public void release()
  {
    zzeu(null);
    this.zzaVs.release();
  }
  
  public void setReferenceCounted(boolean paramBoolean)
  {
    this.zzaVs.setReferenceCounted(paramBoolean);
    this.zzaVw = paramBoolean;
  }
  
  public void zzc(WorkSource paramWorkSource)
  {
    if ((zznc.zzar(this.mContext)) && (paramWorkSource != null))
    {
      if (this.zzaVt == null) {
        break label42;
      }
      this.zzaVt.add(paramWorkSource);
    }
    for (;;)
    {
      this.zzaVs.setWorkSource(this.zzaVt);
      return;
      label42:
      this.zzaVt = paramWorkSource;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzqy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */