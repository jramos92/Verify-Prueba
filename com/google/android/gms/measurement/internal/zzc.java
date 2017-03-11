package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzd;

public class zzc
  extends zzx
{
  static final String zzaLT = String.valueOf(GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000).replaceAll("(\\d+)(\\d)(\\d\\d)", "$1.$2.$3");
  private Boolean zzNT;
  
  zzc(zzv paramzzv)
  {
    super(paramzzv);
  }
  
  public boolean zzjA()
  {
    return zzd.zzaeK;
  }
  
  /* Error */
  public boolean zzjB()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 62	com/google/android/gms/measurement/internal/zzc:zzNT	Ljava/lang/Boolean;
    //   4: ifnonnull +90 -> 94
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 62	com/google/android/gms/measurement/internal/zzc:zzNT	Ljava/lang/Boolean;
    //   13: ifnonnull +79 -> 92
    //   16: aload_0
    //   17: invokevirtual 63	com/google/android/gms/measurement/internal/zzc:getContext	()Landroid/content/Context;
    //   20: invokevirtual 69	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   23: astore_3
    //   24: aload_0
    //   25: invokevirtual 63	com/google/android/gms/measurement/internal/zzc:getContext	()Landroid/content/Context;
    //   28: invokestatic 75	android/os/Process:myPid	()I
    //   31: invokestatic 81	com/google/android/gms/internal/zzmy:zzj	(Landroid/content/Context;I)Ljava/lang/String;
    //   34: astore_2
    //   35: aload_3
    //   36: ifnull +30 -> 66
    //   39: aload_3
    //   40: getfield 86	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   43: astore_3
    //   44: aload_3
    //   45: ifnull +57 -> 102
    //   48: aload_3
    //   49: aload_2
    //   50: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +49 -> 102
    //   56: iconst_1
    //   57: istore_1
    //   58: aload_0
    //   59: iload_1
    //   60: invokestatic 95	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   63: putfield 62	com/google/android/gms/measurement/internal/zzc:zzNT	Ljava/lang/Boolean;
    //   66: aload_0
    //   67: getfield 62	com/google/android/gms/measurement/internal/zzc:zzNT	Ljava/lang/Boolean;
    //   70: ifnonnull +22 -> 92
    //   73: aload_0
    //   74: getstatic 98	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   77: putfield 62	com/google/android/gms/measurement/internal/zzc:zzNT	Ljava/lang/Boolean;
    //   80: aload_0
    //   81: invokevirtual 102	com/google/android/gms/measurement/internal/zzc:zzyd	()Lcom/google/android/gms/measurement/internal/zzp;
    //   84: invokevirtual 108	com/google/android/gms/measurement/internal/zzp:zzzK	()Lcom/google/android/gms/measurement/internal/zzp$zza;
    //   87: ldc 110
    //   89: invokevirtual 116	com/google/android/gms/measurement/internal/zzp$zza:zzec	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_0
    //   95: getfield 62	com/google/android/gms/measurement/internal/zzc:zzNT	Ljava/lang/Boolean;
    //   98: invokevirtual 119	java/lang/Boolean:booleanValue	()Z
    //   101: ireturn
    //   102: iconst_0
    //   103: istore_1
    //   104: goto -46 -> 58
    //   107: astore_2
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_2
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	zzc
    //   57	47	1	bool	boolean
    //   34	16	2	str	String
    //   107	4	2	localObject1	Object
    //   23	26	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	35	107	finally
    //   39	44	107	finally
    //   48	56	107	finally
    //   58	66	107	finally
    //   66	92	107	finally
    //   92	94	107	finally
    //   108	110	107	finally
  }
  
  long zzjV()
  {
    return ((Long)zzk.zzaMC.get()).longValue();
  }
  
  public String zzka()
  {
    return "google_app_measurement.db";
  }
  
  public String zzkb()
  {
    return "google_app_measurement2.db";
  }
  
  public long zzkg()
  {
    return Math.max(0L, ((Long)zzk.zzaMr.get()).longValue());
  }
  
  String zzyS()
  {
    return (String)zzk.zzaMp.get();
  }
  
  public int zzyT()
  {
    return 24;
  }
  
  int zzyU()
  {
    return 36;
  }
  
  int zzyV()
  {
    return 36;
  }
  
  int zzyW()
  {
    return 20;
  }
  
  long zzyX()
  {
    return 3600000L;
  }
  
  long zzyY()
  {
    return 60000L;
  }
  
  long zzyZ()
  {
    return 61000L;
  }
  
  long zzza()
  {
    return ((Long)zzk.zzaMq.get()).longValue();
  }
  
  public long zzzb()
  {
    return GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE / 1000;
  }
  
  public long zzzc()
  {
    return ((Long)zzk.zzaMB.get()).longValue();
  }
  
  public long zzzd()
  {
    return ((Long)zzk.zzaMx.get()).longValue();
  }
  
  public long zzze()
  {
    return 20L;
  }
  
  public int zzzf()
  {
    return ((Integer)zzk.zzaMs.get()).intValue();
  }
  
  public int zzzg()
  {
    return Math.max(0, ((Integer)zzk.zzaMt.get()).intValue());
  }
  
  public String zzzh()
  {
    return (String)zzk.zzaMu.get();
  }
  
  public long zzzi()
  {
    return Math.max(0L, ((Long)zzk.zzaMv.get()).longValue());
  }
  
  public long zzzj()
  {
    return Math.max(0L, ((Long)zzk.zzaMw.get()).longValue());
  }
  
  public long zzzk()
  {
    return Math.max(0L, ((Long)zzk.zzaMy.get()).longValue());
  }
  
  public long zzzl()
  {
    return Math.max(0L, ((Long)zzk.zzaMz.get()).longValue());
  }
  
  public int zzzm()
  {
    return Math.min(20, Math.max(0, ((Integer)zzk.zzaMA.get()).intValue()));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */