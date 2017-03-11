package com.google.android.gms.auth.firstparty.shared;

public enum zzd
{
  private final String zzUK;
  
  private zzd(String paramString)
  {
    this.zzUK = paramString;
  }
  
  public static boolean zza(zzd paramzzd)
  {
    return (zzTV.equals(paramzzd)) || (zzUe.equals(paramzzd)) || (zzUh.equals(paramzzd)) || (zzTZ.equals(paramzzd)) || (zzUj.equals(paramzzd)) || (zzUl.equals(paramzzd)) || (zzb(paramzzd));
  }
  
  public static boolean zzb(zzd paramzzd)
  {
    return (zzTO.equals(paramzzd)) || (zzUm.equals(paramzzd)) || (zzUn.equals(paramzzd)) || (zzUo.equals(paramzzd)) || (zzUp.equals(paramzzd)) || (zzUq.equals(paramzzd)) || (zzUr.equals(paramzzd)) || (zzUs.equals(paramzzd));
  }
  
  public static final zzd zzbE(String paramString)
  {
    Object localObject = null;
    zzd[] arrayOfzzd = values();
    int j = arrayOfzzd.length;
    int i = 0;
    if (i < j)
    {
      zzd localzzd = arrayOfzzd[i];
      if (!localzzd.zzUK.equals(paramString)) {
        break label48;
      }
      localObject = localzzd;
    }
    label48:
    for (;;)
    {
      i += 1;
      break;
      return (zzd)localObject;
    }
  }
  
  public static boolean zzc(zzd paramzzd)
  {
    return (zzTS.equals(paramzzd)) || (zzTT.equals(paramzzd));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\firstparty\shared\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */