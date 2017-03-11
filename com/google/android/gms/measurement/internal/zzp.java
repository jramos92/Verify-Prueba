package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zza;

public class zzp
  extends zzy
{
  private final char zzaMJ;
  private final long zzaMK = zzzt().zzzb();
  private final zza zzaML;
  private final zza zzaMM;
  private final zza zzaMN;
  private final zza zzaMO;
  private final zza zzaMP;
  private final zza zzaMQ;
  private final zza zzaMR;
  private final zza zzaMS;
  private final zza zzaMT;
  private final String zzagm = zzzt().zzyS();
  
  zzp(zzv paramzzv)
  {
    super(paramzzv);
    if (zzzt().zzjB())
    {
      if (zzzt().zzjA()) {}
      for (c = 'P';; c = 'C')
      {
        this.zzaMJ = c;
        this.zzaML = new zza(6, false, false);
        this.zzaMM = new zza(6, true, false);
        this.zzaMN = new zza(6, false, true);
        this.zzaMO = new zza(5, false, false);
        this.zzaMP = new zza(5, true, false);
        this.zzaMQ = new zza(5, false, true);
        this.zzaMR = new zza(4, false, false);
        this.zzaMS = new zza(3, false, false);
        this.zzaMT = new zza(2, false, false);
        return;
      }
    }
    if (zzzt().zzjA()) {}
    for (char c = 'p';; c = 'c')
    {
      this.zzaMJ = c;
      break;
    }
  }
  
  static String zza(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    String str2 = zzc(paramBoolean, paramObject1);
    paramObject2 = zzc(paramBoolean, paramObject2);
    paramObject3 = zzc(paramBoolean, paramObject3);
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = "";
    if (!TextUtils.isEmpty(str1))
    {
      localStringBuilder.append(str1);
      paramString = ": ";
    }
    paramObject1 = paramString;
    if (!TextUtils.isEmpty(str2))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append(str2);
      paramObject1 = ", ";
    }
    paramString = (String)paramObject1;
    if (!TextUtils.isEmpty((CharSequence)paramObject2))
    {
      localStringBuilder.append((String)paramObject1);
      localStringBuilder.append((String)paramObject2);
      paramString = ", ";
    }
    if (!TextUtils.isEmpty((CharSequence)paramObject3))
    {
      localStringBuilder.append(paramString);
      localStringBuilder.append((String)paramObject3);
    }
    return localStringBuilder.toString();
  }
  
  static String zzc(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {
      return "";
    }
    if ((paramObject instanceof Integer)) {
      paramObject = Long.valueOf(((Integer)paramObject).intValue());
    }
    for (;;)
    {
      String str1;
      Object localObject1;
      if ((paramObject instanceof Long))
      {
        if (!paramBoolean) {
          return String.valueOf(paramObject);
        }
        if (Math.abs(((Long)paramObject).longValue()) < 100L) {
          return String.valueOf(paramObject);
        }
        if (String.valueOf(paramObject).charAt(0) == '-') {}
        for (str1 = "-";; str1 = "")
        {
          paramObject = String.valueOf(Math.abs(((Long)paramObject).longValue()));
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append(Math.round(Math.pow(10.0D, ((String)paramObject).length() - 1)));
          ((StringBuilder)localObject1).append("...");
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append(Math.round(Math.pow(10.0D, ((String)paramObject).length()) - 1.0D));
          return ((StringBuilder)localObject1).toString();
        }
      }
      if ((paramObject instanceof Boolean)) {
        return String.valueOf(paramObject);
      }
      if ((paramObject instanceof Throwable))
      {
        Object localObject2 = (Throwable)paramObject;
        paramObject = new StringBuilder(((Throwable)localObject2).toString());
        str1 = zzeb(zza.class.getCanonicalName());
        localObject1 = zzeb(zzv.class.getCanonicalName());
        localObject2 = ((Throwable)localObject2).getStackTrace();
        int j = localObject2.length;
        int i = 0;
        if (i < j)
        {
          Object localObject3 = localObject2[i];
          if (((StackTraceElement)localObject3).isNativeMethod()) {}
          String str2;
          do
          {
            do
            {
              i += 1;
              break;
              str2 = ((StackTraceElement)localObject3).getClassName();
            } while (str2 == null);
            str2 = zzeb(str2);
          } while ((!str2.equals(str1)) && (!str2.equals(localObject1)));
          ((StringBuilder)paramObject).append(": ");
          ((StringBuilder)paramObject).append(localObject3);
        }
        return ((StringBuilder)paramObject).toString();
      }
      if (paramBoolean) {
        return "-";
      }
      return String.valueOf(paramObject);
    }
  }
  
  private static String zzeb(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int i;
    do
    {
      return str;
      i = paramString.lastIndexOf('.');
      str = paramString;
    } while (i == -1);
    return paramString.substring(0, i);
  }
  
  protected boolean zzN(int paramInt)
  {
    return Log.isLoggable(this.zzagm, paramInt);
  }
  
  protected void zza(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    if ((!paramBoolean1) && (zzN(paramInt))) {
      zzl(paramInt, zza(false, paramString, paramObject1, paramObject2, paramObject3));
    }
    if ((!paramBoolean2) && (paramInt >= 5)) {
      zzb(paramInt, paramString, paramObject1, paramObject2, paramObject3);
    }
  }
  
  public void zzb(int paramInt, final String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    zzx.zzw(paramString);
    zzu localzzu = this.zzaKG.zzAb();
    if ((localzzu == null) || (!localzzu.isInitialized()) || (localzzu.zzAp()))
    {
      zzl(6, "Scheduler not initialized or shutdown. Not logging error/warn.");
      return;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    paramInt = i;
    if (i >= "01VDIWEA?".length()) {
      paramInt = "01VDIWEA?".length() - 1;
    }
    paramObject1 = "1" + "01VDIWEA?".charAt(paramInt) + this.zzaMJ + this.zzaMK + ":" + zza(true, paramString, paramObject1, paramObject2, paramObject3);
    if (((String)paramObject1).length() > 1024) {}
    for (paramString = paramString.substring(0, 1024);; paramString = (String)paramObject1)
    {
      localzzu.zzh(new Runnable()
      {
        public void run()
        {
          zzs localzzs = zzp.this.zzaKG.zzzs();
          if ((!localzzs.isInitialized()) || (localzzs.zzAp()))
          {
            zzp.this.zzl(6, "Persisted config not initialized . Not logging error/warn.");
            return;
          }
          localzzs.zzaNh.zzbn(paramString);
        }
      });
      return;
    }
  }
  
  protected void zzhR() {}
  
  protected void zzl(int paramInt, String paramString)
  {
    Log.println(paramInt, this.zzagm, paramString);
  }
  
  public zza zzzK()
  {
    return this.zzaML;
  }
  
  public zza zzzL()
  {
    return this.zzaMO;
  }
  
  public zza zzzM()
  {
    return this.zzaMP;
  }
  
  public zza zzzN()
  {
    return this.zzaMQ;
  }
  
  public zza zzzO()
  {
    return this.zzaMR;
  }
  
  public zza zzzP()
  {
    return this.zzaMS;
  }
  
  public zza zzzQ()
  {
    return this.zzaMT;
  }
  
  public String zzzR()
  {
    Pair localPair = zzzs().zzaNh.zzkW();
    if (localPair == null) {
      return null;
    }
    return String.valueOf(localPair.second) + ":" + (String)localPair.first;
  }
  
  public class zza
  {
    private final int mPriority;
    private final boolean zzaMW;
    private final boolean zzaMX;
    
    zza(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.mPriority = paramInt;
      this.zzaMW = paramBoolean1;
      this.zzaMX = paramBoolean2;
    }
    
    public void zzd(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      zzp.this.zza(this.mPriority, this.zzaMW, this.zzaMX, paramString, paramObject1, paramObject2, paramObject3);
    }
    
    public void zze(String paramString, Object paramObject1, Object paramObject2)
    {
      zzp.this.zza(this.mPriority, this.zzaMW, this.zzaMX, paramString, paramObject1, paramObject2, null);
    }
    
    public void zzec(String paramString)
    {
      zzp.this.zza(this.mPriority, this.zzaMW, this.zzaMX, paramString, null, null, null);
    }
    
    public void zzj(String paramString, Object paramObject)
    {
      zzp.this.zza(this.mPriority, this.zzaMW, this.zzaMX, paramString, paramObject, null, null);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */