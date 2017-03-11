package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

public class zzdc
{
  private Context mContext;
  private Tracker zzLw;
  private GoogleAnalytics zzLy;
  
  public zzdc(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void zzfc(String paramString)
  {
    try
    {
      if (this.zzLy == null)
      {
        this.zzLy = GoogleAnalytics.getInstance(this.mContext);
        this.zzLy.setLogger(new zza());
        this.zzLw = this.zzLy.newTracker(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public Tracker zzfb(String paramString)
  {
    zzfc(paramString);
    return this.zzLw;
  }
  
  static class zza
    implements Logger
  {
    private static int zzjB(int paramInt)
    {
      switch (paramInt)
      {
      case 6: 
      default: 
        return 3;
      case 5: 
        return 2;
      case 3: 
      case 4: 
        return 1;
      }
      return 0;
    }
    
    public void error(Exception paramException)
    {
      zzbg.zzb("", paramException);
    }
    
    public void error(String paramString)
    {
      zzbg.e(paramString);
    }
    
    public int getLogLevel()
    {
      return zzjB(zzbg.getLogLevel());
    }
    
    public void info(String paramString)
    {
      zzbg.zzaG(paramString);
    }
    
    public void setLogLevel(int paramInt)
    {
      zzbg.zzaH("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }
    
    public void verbose(String paramString)
    {
      zzbg.v(paramString);
    }
    
    public void warn(String paramString)
    {
      zzbg.zzaH(paramString);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzdc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */