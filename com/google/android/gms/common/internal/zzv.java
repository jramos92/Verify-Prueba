package com.google.android.gms.common.internal;

import java.util.Iterator;

public class zzv
{
  private final String separator;
  
  private zzv(String paramString)
  {
    this.separator = paramString;
  }
  
  public static zzv zzcq(String paramString)
  {
    return new zzv(paramString);
  }
  
  public final String zza(Iterable<?> paramIterable)
  {
    return zza(new StringBuilder(), paramIterable).toString();
  }
  
  public final StringBuilder zza(StringBuilder paramStringBuilder, Iterable<?> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext())
    {
      paramStringBuilder.append(zzu(paramIterable.next()));
      while (paramIterable.hasNext())
      {
        paramStringBuilder.append(this.separator);
        paramStringBuilder.append(zzu(paramIterable.next()));
      }
    }
    return paramStringBuilder;
  }
  
  CharSequence zzu(Object paramObject)
  {
    if ((paramObject instanceof CharSequence)) {
      return (CharSequence)paramObject;
    }
    return paramObject.toString();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\internal\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */