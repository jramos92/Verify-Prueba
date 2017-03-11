package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class zzcb
{
  private static zzcb zzaXU;
  private volatile String zzaVQ;
  private volatile zza zzaXV;
  private volatile String zzaXW;
  private volatile String zzaXX;
  
  zzcb()
  {
    clear();
  }
  
  static zzcb zzDm()
  {
    try
    {
      if (zzaXU == null) {
        zzaXU = new zzcb();
      }
      zzcb localzzcb = zzaXU;
      return localzzcb;
    }
    finally {}
  }
  
  private String zzeV(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  private String zzn(Uri paramUri)
  {
    return paramUri.getQuery().replace("&gtm_debug=x", "");
  }
  
  void clear()
  {
    this.zzaXV = zza.zzaXY;
    this.zzaXW = null;
    this.zzaVQ = null;
    this.zzaXX = null;
  }
  
  String getContainerId()
  {
    return this.zzaVQ;
  }
  
  zza zzDn()
  {
    return this.zzaXV;
  }
  
  String zzDo()
  {
    return this.zzaXW;
  }
  
  boolean zzm(Uri paramUri)
  {
    boolean bool = true;
    String str;
    try
    {
      str = URLDecoder.decode(paramUri.toString(), "UTF-8");
      if (!str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
        break label153;
      }
      zzbg.v("Container preview url: " + str);
      if (!str.matches(".*?&gtm_debug=x$")) {
        break label138;
      }
      this.zzaXV = zza.zzaYa;
    }
    catch (UnsupportedEncodingException paramUri)
    {
      for (;;)
      {
        bool = false;
        continue;
        this.zzaXV = zza.zzaXZ;
      }
    }
    finally {}
    this.zzaXX = zzn(paramUri);
    if ((this.zzaXV == zza.zzaXZ) || (this.zzaXV == zza.zzaYa)) {
      this.zzaXW = ("/r?" + this.zzaXX);
    }
    this.zzaVQ = zzeV(this.zzaXX);
    for (;;)
    {
      return bool;
      label138:
      label153:
      if (str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
      {
        if (zzeV(paramUri.getQuery()).equals(this.zzaVQ))
        {
          zzbg.v("Exit preview mode for container: " + this.zzaVQ);
          this.zzaXV = zza.zzaXY;
          this.zzaXW = null;
        }
      }
      else
      {
        zzbg.zzaH("Invalid preview uri: " + str);
        bool = false;
        continue;
      }
      bool = false;
    }
  }
  
  static enum zza
  {
    private zza() {}
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */