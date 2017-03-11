package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.zzp;
import java.util.LinkedHashMap;
import java.util.Map;

public class zzbz
{
  private Context mContext = null;
  private String zzqV = null;
  private boolean zzvA;
  private String zzvB;
  private Map<String, String> zzvC;
  
  public zzbz(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.zzqV = paramString;
    this.zzvA = ((Boolean)zzby.zzuQ.get()).booleanValue();
    this.zzvB = ((String)zzby.zzuR.get());
    this.zzvC = new LinkedHashMap();
    this.zzvC.put("s", "gmob_sdk");
    this.zzvC.put("v", "3");
    this.zzvC.put("os", Build.VERSION.RELEASE);
    this.zzvC.put("sdk", Build.VERSION.SDK);
    this.zzvC.put("device", zzp.zzbv().zzgE());
    paramString = this.zzvC;
    if (paramContext.getApplicationContext() != null) {}
    for (paramContext = paramContext.getApplicationContext().getPackageName();; paramContext = paramContext.getPackageName())
    {
      paramString.put("app", paramContext);
      paramContext = zzp.zzbB().zzC(this.mContext);
      this.zzvC.put("network_coarse", Integer.toString(paramContext.zzGE));
      this.zzvC.put("network_fine", Integer.toString(paramContext.zzGF));
      return;
    }
  }
  
  Context getContext()
  {
    return this.mContext;
  }
  
  String zzbV()
  {
    return this.zzqV;
  }
  
  boolean zzdg()
  {
    return this.zzvA;
  }
  
  String zzdh()
  {
    return this.zzvB;
  }
  
  Map<String, String> zzdi()
  {
    return this.zzvC;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzbz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */