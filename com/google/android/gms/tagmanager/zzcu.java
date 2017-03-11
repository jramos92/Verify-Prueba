package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class zzcu
  extends zzct
{
  private static final Object zzaYT = new Object();
  private static zzcu zzaZe;
  private boolean connected = true;
  private Handler handler;
  private Context zzaYU;
  private zzau zzaYV;
  private volatile zzas zzaYW;
  private int zzaYX = 1800000;
  private boolean zzaYY = true;
  private boolean zzaYZ = false;
  private boolean zzaZa = true;
  private zzav zzaZb = new zzav()
  {
    public void zzas(boolean paramAnonymousBoolean)
    {
      zzcu.this.zzd(paramAnonymousBoolean, zzcu.zza(zzcu.this));
    }
  };
  private zzbl zzaZc;
  private boolean zzaZd = false;
  
  public static zzcu zzDG()
  {
    if (zzaZe == null) {
      zzaZe = new zzcu();
    }
    return zzaZe;
  }
  
  private void zzDH()
  {
    this.zzaZc = new zzbl(this);
    this.zzaZc.zzaR(this.zzaYU);
  }
  
  private void zzDI()
  {
    this.handler = new Handler(this.zzaYU.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if ((1 == paramAnonymousMessage.what) && (zzcu.zzDK().equals(paramAnonymousMessage.obj)))
        {
          zzcu.this.dispatch();
          if ((zzcu.zzb(zzcu.this) > 0) && (!zzcu.zzc(zzcu.this))) {
            zzcu.zzd(zzcu.this).sendMessageDelayed(zzcu.zzd(zzcu.this).obtainMessage(1, zzcu.zzDK()), zzcu.zzb(zzcu.this));
          }
        }
        return true;
      }
    });
    if (this.zzaYX > 0) {
      this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzaYT), this.zzaYX);
    }
  }
  
  /* Error */
  public void dispatch()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/google/android/gms/tagmanager/zzcu:zzaYZ	Z
    //   6: ifne +16 -> 22
    //   9: ldc 121
    //   11: invokestatic 127	com/google/android/gms/tagmanager/zzbg:v	(Ljava/lang/String;)V
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 50	com/google/android/gms/tagmanager/zzcu:zzaYY	Z
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 129	com/google/android/gms/tagmanager/zzcu:zzaYW	Lcom/google/android/gms/tagmanager/zzas;
    //   26: new 10	com/google/android/gms/tagmanager/zzcu$3
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 130	com/google/android/gms/tagmanager/zzcu$3:<init>	(Lcom/google/android/gms/tagmanager/zzcu;)V
    //   34: invokeinterface 136 2 0
    //   39: goto -20 -> 19
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	zzcu
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	42	finally
    //   22	39	42	finally
  }
  
  zzau zzDJ()
  {
    try
    {
      if (this.zzaYV != null) {
        break label50;
      }
      if (this.zzaYU == null) {
        throw new IllegalStateException("Cant get a store unless we have a context");
      }
    }
    finally {}
    this.zzaYV = new zzby(this.zzaZb, this.zzaYU);
    label50:
    if (this.handler == null) {
      zzDI();
    }
    this.zzaYZ = true;
    if (this.zzaYY)
    {
      dispatch();
      this.zzaYY = false;
    }
    if ((this.zzaZc == null) && (this.zzaZa)) {
      zzDH();
    }
    zzau localzzau = this.zzaYV;
    return localzzau;
  }
  
  /* Error */
  void zza(Context paramContext, zzas paramzzas)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	com/google/android/gms/tagmanager/zzcu:zzaYU	Landroid/content/Context;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 160	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   19: putfield 78	com/google/android/gms/tagmanager/zzcu:zzaYU	Landroid/content/Context;
    //   22: aload_0
    //   23: getfield 129	com/google/android/gms/tagmanager/zzcu:zzaYW	Lcom/google/android/gms/tagmanager/zzas;
    //   26: ifnonnull -15 -> 11
    //   29: aload_0
    //   30: aload_2
    //   31: putfield 129	com/google/android/gms/tagmanager/zzcu:zzaYW	Lcom/google/android/gms/tagmanager/zzas;
    //   34: goto -23 -> 11
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	zzcu
    //   0	42	1	paramContext	Context
    //   0	42	2	paramzzas	zzas
    //   6	2	3	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   14	34	37	finally
  }
  
  void zzat(boolean paramBoolean)
  {
    try
    {
      zzd(this.zzaZd, paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void zzd(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      String str1;
      try
      {
        if (this.zzaZd == paramBoolean1)
        {
          boolean bool = this.connected;
          if (bool == paramBoolean2) {
            return;
          }
        }
        if (((paramBoolean1) || (!paramBoolean2)) && (this.zzaYX > 0)) {
          this.handler.removeMessages(1, zzaYT);
        }
        if ((!paramBoolean1) && (paramBoolean2) && (this.zzaYX > 0)) {
          this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzaYT), this.zzaYX);
        }
        localStringBuilder = new StringBuilder().append("PowerSaveMode ");
        if (paramBoolean1) {
          break label153;
        }
        if (paramBoolean2) {
          break label146;
        }
      }
      finally {}
      zzbg.v(str1);
      this.zzaZd = paramBoolean1;
      this.connected = paramBoolean2;
      continue;
      label146:
      String str2 = "terminated.";
      continue;
      label153:
      str2 = "initiated.";
    }
  }
  
  void zzio()
  {
    try
    {
      if ((!this.zzaZd) && (this.connected) && (this.zzaYX > 0))
      {
        this.handler.removeMessages(1, zzaYT);
        this.handler.sendMessage(this.handler.obtainMessage(1, zzaYT));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzcu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */