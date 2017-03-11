package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.zzgr;

@zzgr
public final class zzj
  extends zzu.zza
{
  private final AppEventListener zztj;
  
  public zzj(AppEventListener paramAppEventListener)
  {
    this.zztj = paramAppEventListener;
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    this.zztj.onAppEvent(paramString1, paramString2);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */