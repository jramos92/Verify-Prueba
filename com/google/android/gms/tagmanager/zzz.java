package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class zzz
  implements zzar
{
  private static final Object zzaVD = new Object();
  private static zzz zzaWQ;
  private String zzaWR;
  private String zzaWS;
  private zzas zzaWT;
  private zzcd zzaWg;
  
  private zzz(Context paramContext)
  {
    this(zzat.zzaQ(paramContext), new zzcs());
  }
  
  zzz(zzas paramzzas, zzcd paramzzcd)
  {
    this.zzaWT = paramzzas;
    this.zzaWg = paramzzcd;
  }
  
  public static zzar zzaO(Context paramContext)
  {
    synchronized (zzaVD)
    {
      if (zzaWQ == null) {
        zzaWQ = new zzz(paramContext);
      }
      paramContext = zzaWQ;
      return paramContext;
    }
  }
  
  public boolean zzeN(String paramString)
  {
    if (!this.zzaWg.zzkF())
    {
      zzbg.zzaH("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
      return false;
    }
    String str = paramString;
    if (this.zzaWR != null)
    {
      str = paramString;
      if (this.zzaWS == null) {}
    }
    try
    {
      str = this.zzaWR + "?" + this.zzaWS + "=" + URLEncoder.encode(paramString, "UTF-8");
      zzbg.v("Sending wrapped url hit: " + str);
      this.zzaWT.zzeR(str);
      return true;
    }
    catch (UnsupportedEncodingException paramString)
    {
      zzbg.zzd("Error wrapping URL for testing.", paramString);
    }
    return false;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */