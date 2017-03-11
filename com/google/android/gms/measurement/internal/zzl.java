package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;

final class zzl
{
  private static volatile zzl zzaMF;
  private final String zzaLl;
  private final Status zzaMD;
  private final boolean zzaME;
  
  zzl(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("google_app_measurement_enable", "integer", paramContext.getPackageName());
    boolean bool1 = bool2;
    if (i != 0)
    {
      if (localResources.getInteger(i) != 0) {
        bool1 = bool2;
      }
    }
    else
    {
      this.zzaME = bool1;
      i = localResources.getIdentifier("google_app_id", "string", paramContext.getPackageName());
      if (i != 0) {
        break label112;
      }
      if (!this.zzaME) {
        break label102;
      }
    }
    label102:
    for (this.zzaMD = new Status(10, "Missing an expected resource: 'R.string.google_app_id' for initializing Google services.  Possible causes are missing google-services.json or com.google.gms.google-services gradle plugin.");; this.zzaMD = Status.zzabb)
    {
      this.zzaLl = null;
      return;
      bool1 = false;
      break;
    }
    label112:
    paramContext = localResources.getString(i);
    if (TextUtils.isEmpty(paramContext))
    {
      if (this.zzaME) {}
      for (this.zzaMD = new Status(10, "The resource 'R.string.google_app_id' is invalid, expected an app  identifier and found: '" + paramContext + "'.");; this.zzaMD = Status.zzabb)
      {
        this.zzaLl = null;
        return;
      }
    }
    this.zzaLl = paramContext;
    this.zzaMD = Status.zzabb;
  }
  
  public static Status zzaK(Context paramContext)
  {
    zzx.zzb(paramContext, "Context must not be null.");
    if (zzaMF == null) {}
    try
    {
      if (zzaMF == null) {
        zzaMF = new zzl(paramContext);
      }
      return zzaMF.zzaMD;
    }
    finally {}
  }
  
  public static String zzzC()
  {
    if (zzaMF == null) {
      try
      {
        if (zzaMF == null) {
          throw new IllegalStateException("Initialize must be called before getGoogleAppId.");
        }
      }
      finally {}
    }
    return zzaMF.zzzD();
  }
  
  public static boolean zzzE()
  {
    if (zzaMF == null) {
      try
      {
        if (zzaMF == null) {
          throw new IllegalStateException("Initialize must be called before isMeasurementEnabled.");
        }
      }
      finally {}
    }
    return zzaMF.zzzF();
  }
  
  String zzzD()
  {
    if (!this.zzaMD.isSuccess()) {
      throw new IllegalStateException("Initialize must be successful before calling getGoogleAppId.  The result of the previous call to initialize was: '" + this.zzaMD + "'.");
    }
    return this.zzaLl;
  }
  
  boolean zzzF()
  {
    if (!this.zzaMD.isSuccess()) {
      throw new IllegalStateException("Initialize must be successful before calling isMeasurementEnabledInternal.  The result of the previous call to initialize was: '" + this.zzaMD + "'.");
    }
    return this.zzaME;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */