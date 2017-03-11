package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.internal.zzae;
import java.util.ArrayList;

public class ExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  private final Context mContext;
  private final Thread.UncaughtExceptionHandler zzLv;
  private final Tracker zzLw;
  private ExceptionParser zzLx;
  private GoogleAnalytics zzLy;
  
  public ExceptionReporter(Tracker paramTracker, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramTracker == null) {
      throw new NullPointerException("tracker cannot be null");
    }
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.zzLv = paramUncaughtExceptionHandler;
    this.zzLw = paramTracker;
    this.zzLx = new StandardExceptionParser(paramContext, new ArrayList());
    this.mContext = paramContext.getApplicationContext();
    paramContext = new StringBuilder().append("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null) {}
    for (paramTracker = "null";; paramTracker = paramUncaughtExceptionHandler.getClass().getName())
    {
      zzae.v(paramTracker);
      return;
    }
  }
  
  public ExceptionParser getExceptionParser()
  {
    return this.zzLx;
  }
  
  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    this.zzLx = paramExceptionParser;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Object localObject = "UncaughtException";
    if (this.zzLx != null) {
      if (paramThread == null) {
        break label115;
      }
    }
    label115:
    for (localObject = paramThread.getName();; localObject = null)
    {
      localObject = this.zzLx.getDescription((String)localObject, paramThrowable);
      zzae.v("Reporting uncaught exception: " + (String)localObject);
      this.zzLw.send(new HitBuilders.ExceptionBuilder().setDescription((String)localObject).setFatal(true).build());
      localObject = zzhK();
      ((GoogleAnalytics)localObject).dispatchLocalHits();
      ((GoogleAnalytics)localObject).zzhO();
      if (this.zzLv != null)
      {
        zzae.v("Passing exception to the original handler");
        this.zzLv.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
  }
  
  GoogleAnalytics zzhK()
  {
    if (this.zzLy == null) {
      this.zzLy = GoogleAnalytics.getInstance(this.mContext);
    }
    return this.zzLy;
  }
  
  Thread.UncaughtExceptionHandler zzhL()
  {
    return this.zzLv;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\ExceptionReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */