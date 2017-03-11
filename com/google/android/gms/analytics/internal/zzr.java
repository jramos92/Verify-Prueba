package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import java.util.HashSet;
import java.util.Set;

public class zzr
{
  private final zzf zzLf;
  private volatile Boolean zzNT;
  private String zzNU;
  private Set<Integer> zzNV;
  
  protected zzr(zzf paramzzf)
  {
    zzx.zzw(paramzzf);
    this.zzLf = paramzzf;
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
    //   1: getfield 38	com/google/android/gms/analytics/internal/zzr:zzNT	Ljava/lang/Boolean;
    //   4: ifnonnull +129 -> 133
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 38	com/google/android/gms/analytics/internal/zzr:zzNT	Ljava/lang/Boolean;
    //   13: ifnonnull +118 -> 131
    //   16: aload_0
    //   17: getfield 26	com/google/android/gms/analytics/internal/zzr:zzLf	Lcom/google/android/gms/analytics/internal/zzf;
    //   20: invokevirtual 44	com/google/android/gms/analytics/internal/zzf:getContext	()Landroid/content/Context;
    //   23: invokevirtual 50	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   26: astore_3
    //   27: aload_0
    //   28: getfield 26	com/google/android/gms/analytics/internal/zzr:zzLf	Lcom/google/android/gms/analytics/internal/zzf;
    //   31: invokevirtual 44	com/google/android/gms/analytics/internal/zzf:getContext	()Landroid/content/Context;
    //   34: invokestatic 56	android/os/Process:myPid	()I
    //   37: invokestatic 62	com/google/android/gms/internal/zzmy:zzj	(Landroid/content/Context;I)Ljava/lang/String;
    //   40: astore_2
    //   41: aload_3
    //   42: ifnull +30 -> 72
    //   45: aload_3
    //   46: getfield 67	android/content/pm/ApplicationInfo:processName	Ljava/lang/String;
    //   49: astore_3
    //   50: aload_3
    //   51: ifnull +90 -> 141
    //   54: aload_3
    //   55: aload_2
    //   56: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   59: ifeq +82 -> 141
    //   62: iconst_1
    //   63: istore_1
    //   64: aload_0
    //   65: iload_1
    //   66: invokestatic 79	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   69: putfield 38	com/google/android/gms/analytics/internal/zzr:zzNT	Ljava/lang/Boolean;
    //   72: aload_0
    //   73: getfield 38	com/google/android/gms/analytics/internal/zzr:zzNT	Ljava/lang/Boolean;
    //   76: ifnull +13 -> 89
    //   79: aload_0
    //   80: getfield 38	com/google/android/gms/analytics/internal/zzr:zzNT	Ljava/lang/Boolean;
    //   83: invokevirtual 82	java/lang/Boolean:booleanValue	()Z
    //   86: ifne +19 -> 105
    //   89: ldc 84
    //   91: aload_2
    //   92: invokevirtual 73	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   95: ifeq +10 -> 105
    //   98: aload_0
    //   99: getstatic 87	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   102: putfield 38	com/google/android/gms/analytics/internal/zzr:zzNT	Ljava/lang/Boolean;
    //   105: aload_0
    //   106: getfield 38	com/google/android/gms/analytics/internal/zzr:zzNT	Ljava/lang/Boolean;
    //   109: ifnonnull +22 -> 131
    //   112: aload_0
    //   113: getstatic 87	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   116: putfield 38	com/google/android/gms/analytics/internal/zzr:zzNT	Ljava/lang/Boolean;
    //   119: aload_0
    //   120: getfield 26	com/google/android/gms/analytics/internal/zzr:zzLf	Lcom/google/android/gms/analytics/internal/zzf;
    //   123: invokevirtual 91	com/google/android/gms/analytics/internal/zzf:zziu	()Lcom/google/android/gms/analytics/internal/zzaf;
    //   126: ldc 93
    //   128: invokevirtual 99	com/google/android/gms/analytics/internal/zzaf:zzbe	(Ljava/lang/String;)V
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_0
    //   134: getfield 38	com/google/android/gms/analytics/internal/zzr:zzNT	Ljava/lang/Boolean;
    //   137: invokevirtual 82	java/lang/Boolean:booleanValue	()Z
    //   140: ireturn
    //   141: iconst_0
    //   142: istore_1
    //   143: goto -79 -> 64
    //   146: astore_2
    //   147: aload_0
    //   148: monitorexit
    //   149: aload_2
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	zzr
    //   63	80	1	bool	boolean
    //   40	52	2	str	String
    //   146	4	2	localObject1	Object
    //   26	29	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	41	146	finally
    //   45	50	146	finally
    //   54	62	146	finally
    //   64	72	146	finally
    //   72	89	146	finally
    //   89	105	146	finally
    //   105	131	146	finally
    //   131	133	146	finally
    //   147	149	146	finally
  }
  
  public boolean zzjC()
  {
    return ((Boolean)zzy.zzOf.get()).booleanValue();
  }
  
  public int zzjD()
  {
    return ((Integer)zzy.zzOy.get()).intValue();
  }
  
  public int zzjE()
  {
    return ((Integer)zzy.zzOC.get()).intValue();
  }
  
  public int zzjF()
  {
    return ((Integer)zzy.zzOD.get()).intValue();
  }
  
  public int zzjG()
  {
    return ((Integer)zzy.zzOE.get()).intValue();
  }
  
  public long zzjH()
  {
    return ((Long)zzy.zzOn.get()).longValue();
  }
  
  public long zzjI()
  {
    return ((Long)zzy.zzOm.get()).longValue();
  }
  
  public long zzjJ()
  {
    return ((Long)zzy.zzOq.get()).longValue();
  }
  
  public long zzjK()
  {
    return ((Long)zzy.zzOr.get()).longValue();
  }
  
  public int zzjL()
  {
    return ((Integer)zzy.zzOs.get()).intValue();
  }
  
  public int zzjM()
  {
    return ((Integer)zzy.zzOt.get()).intValue();
  }
  
  public long zzjN()
  {
    return ((Integer)zzy.zzOG.get()).intValue();
  }
  
  public String zzjO()
  {
    return (String)zzy.zzOv.get();
  }
  
  public String zzjP()
  {
    return (String)zzy.zzOu.get();
  }
  
  public String zzjQ()
  {
    return (String)zzy.zzOw.get();
  }
  
  public String zzjR()
  {
    return (String)zzy.zzOx.get();
  }
  
  public zzm zzjS()
  {
    return zzm.zzbj((String)zzy.zzOz.get());
  }
  
  public zzo zzjT()
  {
    return zzo.zzbk((String)zzy.zzOA.get());
  }
  
  public Set<Integer> zzjU()
  {
    String str1 = (String)zzy.zzOF.get();
    String[] arrayOfString;
    HashSet localHashSet;
    int j;
    int i;
    if ((this.zzNV == null) || (this.zzNU == null) || (!this.zzNU.equals(str1)))
    {
      arrayOfString = TextUtils.split(str1, ",");
      localHashSet = new HashSet();
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      String str2;
      if (i < j) {
        str2 = arrayOfString[i];
      }
      try
      {
        localHashSet.add(Integer.valueOf(Integer.parseInt(str2)));
        i += 1;
        continue;
        this.zzNU = str1;
        this.zzNV = localHashSet;
        return this.zzNV;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
    }
  }
  
  public long zzjV()
  {
    return ((Long)zzy.zzOO.get()).longValue();
  }
  
  public long zzjW()
  {
    return ((Long)zzy.zzOP.get()).longValue();
  }
  
  public long zzjX()
  {
    return ((Long)zzy.zzOS.get()).longValue();
  }
  
  public int zzjY()
  {
    return ((Integer)zzy.zzOj.get()).intValue();
  }
  
  public int zzjZ()
  {
    return ((Integer)zzy.zzOl.get()).intValue();
  }
  
  public String zzka()
  {
    return "google_analytics_v4.db";
  }
  
  public String zzkb()
  {
    return "google_analytics2_v4.db";
  }
  
  public long zzkc()
  {
    return 86400000L;
  }
  
  public int zzkd()
  {
    return ((Integer)zzy.zzOI.get()).intValue();
  }
  
  public int zzke()
  {
    return ((Integer)zzy.zzOJ.get()).intValue();
  }
  
  public long zzkf()
  {
    return ((Long)zzy.zzOK.get()).longValue();
  }
  
  public long zzkg()
  {
    return ((Long)zzy.zzOT.get()).longValue();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */