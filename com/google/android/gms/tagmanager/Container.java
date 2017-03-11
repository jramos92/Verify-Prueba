package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf.zzf;
import com.google.android.gms.internal.zzaf.zzi;
import com.google.android.gms.internal.zzaf.zzj;
import com.google.android.gms.internal.zzag.zza;
import com.google.android.gms.internal.zzrb;
import com.google.android.gms.internal.zzrb.zzc;
import com.google.android.gms.internal.zzrb.zzg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container
{
  private final Context mContext;
  private final String zzaVQ;
  private final DataLayer zzaVR;
  private zzcp zzaVS;
  private Map<String, FunctionCallMacroCallback> zzaVT = new HashMap();
  private Map<String, FunctionCallTagCallback> zzaVU = new HashMap();
  private volatile long zzaVV;
  private volatile String zzaVW = "";
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, zzaf.zzj paramzzj)
  {
    this.mContext = paramContext;
    this.zzaVR = paramDataLayer;
    this.zzaVQ = paramString;
    this.zzaVV = paramLong;
    zza(paramzzj.zziR);
    if (paramzzj.zziQ != null) {
      zza(paramzzj.zziQ);
    }
  }
  
  Container(Context paramContext, DataLayer paramDataLayer, String paramString, long paramLong, zzrb.zzc paramzzc)
  {
    this.mContext = paramContext;
    this.zzaVR = paramDataLayer;
    this.zzaVQ = paramString;
    this.zzaVV = paramLong;
    zza(paramzzc);
  }
  
  private zzcp zzCu()
  {
    try
    {
      zzcp localzzcp = this.zzaVS;
      return localzzcp;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void zza(zzaf.zzf paramzzf)
  {
    if (paramzzf == null) {
      throw new NullPointerException();
    }
    try
    {
      zzrb.zzc localzzc = zzrb.zzb(paramzzf);
      zza(localzzc);
      return;
    }
    catch (zzrb.zzg localzzg)
    {
      zzbg.e("Not loading resource: " + paramzzf + " because it is invalid: " + localzzg.toString());
    }
  }
  
  private void zza(zzrb.zzc paramzzc)
  {
    this.zzaVW = paramzzc.getVersion();
    zzah localzzah = zzeD(this.zzaVW);
    zza(new zzcp(this.mContext, paramzzc, this.zzaVR, new zza(null), new zzb(null), localzzah));
    if (getBoolean("_gtm.loadEventEnabled")) {
      this.zzaVR.pushEvent("gtm.load", DataLayer.mapOf(new Object[] { "gtm.id", this.zzaVQ }));
    }
  }
  
  private void zza(zzcp paramzzcp)
  {
    try
    {
      this.zzaVS = paramzzcp;
      return;
    }
    finally
    {
      paramzzcp = finally;
      throw paramzzcp;
    }
  }
  
  private void zza(zzaf.zzi[] paramArrayOfzzi)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfzzi.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfzzi[i]);
      i += 1;
    }
    zzCu().zzA(localArrayList);
  }
  
  public boolean getBoolean(String paramString)
  {
    zzcp localzzcp = zzCu();
    if (localzzcp == null)
    {
      zzbg.e("getBoolean called for closed container.");
      return zzdf.zzDU().booleanValue();
    }
    try
    {
      boolean bool = zzdf.zzk((zzag.zza)localzzcp.zzeY(paramString).getObject()).booleanValue();
      return bool;
    }
    catch (Exception paramString)
    {
      zzbg.e("Calling getBoolean() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return zzdf.zzDU().booleanValue();
  }
  
  public String getContainerId()
  {
    return this.zzaVQ;
  }
  
  public double getDouble(String paramString)
  {
    zzcp localzzcp = zzCu();
    if (localzzcp == null)
    {
      zzbg.e("getDouble called for closed container.");
      return zzdf.zzDT().doubleValue();
    }
    try
    {
      double d = zzdf.zzj((zzag.zza)localzzcp.zzeY(paramString).getObject()).doubleValue();
      return d;
    }
    catch (Exception paramString)
    {
      zzbg.e("Calling getDouble() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return zzdf.zzDT().doubleValue();
  }
  
  public long getLastRefreshTime()
  {
    return this.zzaVV;
  }
  
  public long getLong(String paramString)
  {
    zzcp localzzcp = zzCu();
    if (localzzcp == null)
    {
      zzbg.e("getLong called for closed container.");
      return zzdf.zzDS().longValue();
    }
    try
    {
      long l = zzdf.zzi((zzag.zza)localzzcp.zzeY(paramString).getObject()).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      zzbg.e("Calling getLong() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return zzdf.zzDS().longValue();
  }
  
  public String getString(String paramString)
  {
    zzcp localzzcp = zzCu();
    if (localzzcp == null)
    {
      zzbg.e("getString called for closed container.");
      return zzdf.zzDW();
    }
    try
    {
      paramString = zzdf.zzg((zzag.zza)localzzcp.zzeY(paramString).getObject());
      return paramString;
    }
    catch (Exception paramString)
    {
      zzbg.e("Calling getString() threw an exception: " + paramString.getMessage() + " Returning default value.");
    }
    return zzdf.zzDW();
  }
  
  public boolean isDefault()
  {
    return getLastRefreshTime() == 0L;
  }
  
  public void registerFunctionCallMacroCallback(String paramString, FunctionCallMacroCallback paramFunctionCallMacroCallback)
  {
    if (paramFunctionCallMacroCallback == null) {
      throw new NullPointerException("Macro handler must be non-null");
    }
    synchronized (this.zzaVT)
    {
      this.zzaVT.put(paramString, paramFunctionCallMacroCallback);
      return;
    }
  }
  
  public void registerFunctionCallTagCallback(String paramString, FunctionCallTagCallback paramFunctionCallTagCallback)
  {
    if (paramFunctionCallTagCallback == null) {
      throw new NullPointerException("Tag callback must be non-null");
    }
    synchronized (this.zzaVU)
    {
      this.zzaVU.put(paramString, paramFunctionCallTagCallback);
      return;
    }
  }
  
  void release()
  {
    this.zzaVS = null;
  }
  
  public void unregisterFunctionCallMacroCallback(String paramString)
  {
    synchronized (this.zzaVT)
    {
      this.zzaVT.remove(paramString);
      return;
    }
  }
  
  public void unregisterFunctionCallTagCallback(String paramString)
  {
    synchronized (this.zzaVU)
    {
      this.zzaVU.remove(paramString);
      return;
    }
  }
  
  String zzCt()
  {
    return this.zzaVW;
  }
  
  FunctionCallMacroCallback zzeA(String paramString)
  {
    synchronized (this.zzaVT)
    {
      paramString = (FunctionCallMacroCallback)this.zzaVT.get(paramString);
      return paramString;
    }
  }
  
  FunctionCallTagCallback zzeB(String paramString)
  {
    synchronized (this.zzaVU)
    {
      paramString = (FunctionCallTagCallback)this.zzaVU.get(paramString);
      return paramString;
    }
  }
  
  void zzeC(String paramString)
  {
    zzCu().zzeC(paramString);
  }
  
  zzah zzeD(String paramString)
  {
    if (zzcb.zzDm().zzDn().equals(zzcb.zza.zzaYa)) {}
    return new zzbo();
  }
  
  public static abstract interface FunctionCallMacroCallback
  {
    public abstract Object getValue(String paramString, Map<String, Object> paramMap);
  }
  
  public static abstract interface FunctionCallTagCallback
  {
    public abstract void execute(String paramString, Map<String, Object> paramMap);
  }
  
  private class zza
    implements zzt.zza
  {
    private zza() {}
    
    public Object zzc(String paramString, Map<String, Object> paramMap)
    {
      Container.FunctionCallMacroCallback localFunctionCallMacroCallback = Container.this.zzeA(paramString);
      if (localFunctionCallMacroCallback == null) {
        return null;
      }
      return localFunctionCallMacroCallback.getValue(paramString, paramMap);
    }
  }
  
  private class zzb
    implements zzt.zza
  {
    private zzb() {}
    
    public Object zzc(String paramString, Map<String, Object> paramMap)
    {
      Container.FunctionCallTagCallback localFunctionCallTagCallback = Container.this.zzeB(paramString);
      if (localFunctionCallTagCallback != null) {
        localFunctionCallTagCallback.execute(paramString, paramMap);
      }
      return zzdf.zzDW();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\Container.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */