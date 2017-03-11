package com.google.android.gms.analytics.internal;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

public class zzal
  implements zzp
{
  public String zzLq;
  public double zzPJ = -1.0D;
  public int zzPK = -1;
  public int zzPL = -1;
  public int zzPM = -1;
  public int zzPN = -1;
  public Map<String, String> zzPO = new HashMap();
  
  public int getSessionTimeout()
  {
    return this.zzPK;
  }
  
  public String getTrackingId()
  {
    return this.zzLq;
  }
  
  public String zzbo(String paramString)
  {
    String str = (String)this.zzPO.get(paramString);
    if (str != null) {
      return str;
    }
    return paramString;
  }
  
  public boolean zzlc()
  {
    return this.zzLq != null;
  }
  
  public boolean zzld()
  {
    return this.zzPJ >= 0.0D;
  }
  
  public double zzle()
  {
    return this.zzPJ;
  }
  
  public boolean zzlf()
  {
    return this.zzPK >= 0;
  }
  
  public boolean zzlg()
  {
    return this.zzPL != -1;
  }
  
  public boolean zzlh()
  {
    return this.zzPL == 1;
  }
  
  public boolean zzli()
  {
    return this.zzPM != -1;
  }
  
  public boolean zzlj()
  {
    return this.zzPM == 1;
  }
  
  public boolean zzlk()
  {
    return this.zzPN == 1;
  }
  
  public String zzq(Activity paramActivity)
  {
    return zzbo(paramActivity.getClass().getCanonicalName());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */