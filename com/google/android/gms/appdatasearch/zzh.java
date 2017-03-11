package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

public class zzh
{
  private static final String[] zzQD;
  private static final Map<String, Integer> zzQE;
  
  static
  {
    int i = 0;
    zzQD = new String[] { "text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity" };
    zzQE = new HashMap(zzQD.length);
    while (i < zzQD.length)
    {
      zzQE.put(zzQD[i], Integer.valueOf(i));
      i += 1;
    }
  }
  
  public static String zzak(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= zzQD.length)) {
      return null;
    }
    return zzQD[paramInt];
  }
  
  public static int zzbz(String paramString)
  {
    Integer localInteger = (Integer)zzQE.get(paramString);
    if (localInteger == null) {
      throw new IllegalArgumentException("[" + paramString + "] is not a valid global search section name");
    }
    return localInteger.intValue();
  }
  
  public static int zzls()
  {
    return zzQD.length;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appdatasearch\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */