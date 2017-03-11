package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import com.google.android.gms.internal.zzrb.zza;
import com.google.android.gms.internal.zzrb.zzb;
import com.google.android.gms.internal.zzrb.zzc;
import com.google.android.gms.internal.zzrb.zzd;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class zzaz
{
  private static zzag.zza zzJ(Object paramObject)
    throws JSONException
  {
    return zzdf.zzQ(zzK(paramObject));
  }
  
  static Object zzK(Object paramObject)
    throws JSONException
  {
    if ((paramObject instanceof JSONArray)) {
      throw new RuntimeException("JSONArrays are not supported");
    }
    if (JSONObject.NULL.equals(paramObject)) {
      throw new RuntimeException("JSON nulls are not supported");
    }
    Object localObject = paramObject;
    if ((paramObject instanceof JSONObject))
    {
      paramObject = (JSONObject)paramObject;
      localObject = new HashMap();
      Iterator localIterator = ((JSONObject)paramObject).keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        ((Map)localObject).put(str, zzK(((JSONObject)paramObject).get(str)));
      }
    }
    return localObject;
  }
  
  public static zzrb.zzc zzeT(String paramString)
    throws JSONException
  {
    paramString = zzJ(new JSONObject(paramString));
    zzrb.zzd localzzd = zzrb.zzc.zzEc();
    int i = 0;
    while (i < paramString.zziW.length)
    {
      localzzd.zzc(zzrb.zza.zzDZ().zzb(zzae.zzfu.toString(), paramString.zziW[i]).zzb(zzae.zzfj.toString(), zzdf.zzfe(zzn.zzCr())).zzb(zzn.zzCs(), paramString.zziX[i]).zzEb());
      i += 1;
    }
    return localzzd.zzEf();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */