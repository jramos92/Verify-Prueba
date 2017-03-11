package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.Api.zzc;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public final class zzk
{
  public static final Api.zzc<zze> zzRk = new Api.zzc();
  public static final Charset zzZk;
  
  static
  {
    Object localObject = null;
    try
    {
      Charset localCharset = Charset.forName("UTF-8");
      localObject = localCharset;
    }
    catch (UnsupportedCharsetException localUnsupportedCharsetException)
    {
      for (;;) {}
    }
    catch (IllegalCharsetNameException localIllegalCharsetNameException)
    {
      for (;;) {}
    }
    zzZk = (Charset)localObject;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */