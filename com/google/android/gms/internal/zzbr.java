package com.google.android.gms.internal;

import android.text.TextUtils;

@zzgr
public final class zzbr
{
  private String zzuc;
  private int zzud = -1;
  
  public zzbr()
  {
    this((String)zzby.zzul.zzde(), -1);
  }
  
  public zzbr(String paramString)
  {
    this(paramString, -1);
  }
  
  public zzbr(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = (String)zzby.zzul.zzde();
    }
    for (;;)
    {
      this.zzuc = paramString;
      this.zzud = paramInt;
      return;
    }
  }
  
  public String zzdc()
  {
    return this.zzuc;
  }
  
  public int zzdd()
  {
    return this.zzud;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzbr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */