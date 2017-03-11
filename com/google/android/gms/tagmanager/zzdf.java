package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzdf
{
  private static final Object zzaZJ = null;
  private static Long zzaZK = new Long(0L);
  private static Double zzaZL = new Double(0.0D);
  private static zzde zzaZM = zzde.zzW(0L);
  private static String zzaZN = new String("");
  private static Boolean zzaZO = new Boolean(false);
  private static List<Object> zzaZP = new ArrayList(0);
  private static Map<Object, Object> zzaZQ = new HashMap();
  private static zzag.zza zzaZR = zzQ(zzaZN);
  
  private static double getDouble(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).doubleValue();
    }
    zzbg.e("getDouble received non-Number");
    return 0.0D;
  }
  
  public static Object zzDR()
  {
    return zzaZJ;
  }
  
  public static Long zzDS()
  {
    return zzaZK;
  }
  
  public static Double zzDT()
  {
    return zzaZL;
  }
  
  public static Boolean zzDU()
  {
    return zzaZO;
  }
  
  public static zzde zzDV()
  {
    return zzaZM;
  }
  
  public static String zzDW()
  {
    return zzaZN;
  }
  
  public static zzag.zza zzDX()
  {
    return zzaZR;
  }
  
  public static String zzL(Object paramObject)
  {
    if (paramObject == null) {
      return zzaZN;
    }
    return paramObject.toString();
  }
  
  public static zzde zzM(Object paramObject)
  {
    if ((paramObject instanceof zzde)) {
      return (zzde)paramObject;
    }
    if (zzS(paramObject)) {
      return zzde.zzW(zzT(paramObject));
    }
    if (zzR(paramObject)) {
      return zzde.zza(Double.valueOf(getDouble(paramObject)));
    }
    return zzff(zzL(paramObject));
  }
  
  public static Long zzN(Object paramObject)
  {
    if (zzS(paramObject)) {
      return Long.valueOf(zzT(paramObject));
    }
    return zzfg(zzL(paramObject));
  }
  
  public static Double zzO(Object paramObject)
  {
    if (zzR(paramObject)) {
      return Double.valueOf(getDouble(paramObject));
    }
    return zzfh(zzL(paramObject));
  }
  
  public static Boolean zzP(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    return zzfi(zzL(paramObject));
  }
  
  public static zzag.zza zzQ(Object paramObject)
  {
    boolean bool = false;
    Object localObject1 = new zzag.zza();
    if ((paramObject instanceof zzag.zza)) {
      return (zzag.zza)paramObject;
    }
    if ((paramObject instanceof String))
    {
      ((zzag.zza)localObject1).type = 1;
      ((zzag.zza)localObject1).zziU = ((String)paramObject);
    }
    for (;;)
    {
      ((zzag.zza)localObject1).zzje = bool;
      return (zzag.zza)localObject1;
      Object localObject2;
      Object localObject3;
      if ((paramObject instanceof List))
      {
        ((zzag.zza)localObject1).type = 2;
        localObject2 = (List)paramObject;
        paramObject = new ArrayList(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        bool = false;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = zzQ(((Iterator)localObject2).next());
          if (localObject3 == zzaZR) {
            return zzaZR;
          }
          if ((bool) || (((zzag.zza)localObject3).zzje)) {}
          for (bool = true;; bool = false)
          {
            ((List)paramObject).add(localObject3);
            break;
          }
        }
        ((zzag.zza)localObject1).zziV = ((zzag.zza[])((List)paramObject).toArray(new zzag.zza[0]));
      }
      else if ((paramObject instanceof Map))
      {
        ((zzag.zza)localObject1).type = 3;
        localObject3 = ((Map)paramObject).entrySet();
        paramObject = new ArrayList(((Set)localObject3).size());
        localObject2 = new ArrayList(((Set)localObject3).size());
        localObject3 = ((Set)localObject3).iterator();
        bool = false;
        if (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (Map.Entry)((Iterator)localObject3).next();
          zzag.zza localzza = zzQ(((Map.Entry)localObject4).getKey());
          localObject4 = zzQ(((Map.Entry)localObject4).getValue());
          if ((localzza == zzaZR) || (localObject4 == zzaZR)) {
            return zzaZR;
          }
          if ((bool) || (localzza.zzje) || (((zzag.zza)localObject4).zzje)) {}
          for (bool = true;; bool = false)
          {
            ((List)paramObject).add(localzza);
            ((List)localObject2).add(localObject4);
            break;
          }
        }
        ((zzag.zza)localObject1).zziW = ((zzag.zza[])((List)paramObject).toArray(new zzag.zza[0]));
        ((zzag.zza)localObject1).zziX = ((zzag.zza[])((List)localObject2).toArray(new zzag.zza[0]));
      }
      else if (zzR(paramObject))
      {
        ((zzag.zza)localObject1).type = 1;
        ((zzag.zza)localObject1).zziU = paramObject.toString();
      }
      else if (zzS(paramObject))
      {
        ((zzag.zza)localObject1).type = 6;
        ((zzag.zza)localObject1).zzja = zzT(paramObject);
      }
      else
      {
        if (!(paramObject instanceof Boolean)) {
          break;
        }
        ((zzag.zza)localObject1).type = 8;
        ((zzag.zza)localObject1).zzjb = ((Boolean)paramObject).booleanValue();
      }
    }
    localObject1 = new StringBuilder().append("Converting to Value from unknown object type: ");
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = paramObject.getClass().toString())
    {
      zzbg.e((String)paramObject);
      return zzaZR;
    }
  }
  
  private static boolean zzR(Object paramObject)
  {
    return ((paramObject instanceof Double)) || ((paramObject instanceof Float)) || (((paramObject instanceof zzde)) && (((zzde)paramObject).zzDM()));
  }
  
  private static boolean zzS(Object paramObject)
  {
    return ((paramObject instanceof Byte)) || ((paramObject instanceof Short)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Long)) || (((paramObject instanceof zzde)) && (((zzde)paramObject).zzDN()));
  }
  
  private static long zzT(Object paramObject)
  {
    if ((paramObject instanceof Number)) {
      return ((Number)paramObject).longValue();
    }
    zzbg.e("getInt64 received non-Number");
    return 0L;
  }
  
  public static zzag.zza zzfe(String paramString)
  {
    zzag.zza localzza = new zzag.zza();
    localzza.type = 5;
    localzza.zziZ = paramString;
    return localzza;
  }
  
  private static zzde zzff(String paramString)
  {
    try
    {
      zzde localzzde = zzde.zzfd(paramString);
      return localzzde;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      zzbg.e("Failed to convert '" + paramString + "' to a number.");
    }
    return zzaZM;
  }
  
  private static Long zzfg(String paramString)
  {
    paramString = zzff(paramString);
    if (paramString == zzaZM) {
      return zzaZK;
    }
    return Long.valueOf(paramString.longValue());
  }
  
  private static Double zzfh(String paramString)
  {
    paramString = zzff(paramString);
    if (paramString == zzaZM) {
      return zzaZL;
    }
    return Double.valueOf(paramString.doubleValue());
  }
  
  private static Boolean zzfi(String paramString)
  {
    if ("true".equalsIgnoreCase(paramString)) {
      return Boolean.TRUE;
    }
    if ("false".equalsIgnoreCase(paramString)) {
      return Boolean.FALSE;
    }
    return zzaZO;
  }
  
  public static String zzg(zzag.zza paramzza)
  {
    return zzL(zzl(paramzza));
  }
  
  public static zzde zzh(zzag.zza paramzza)
  {
    return zzM(zzl(paramzza));
  }
  
  public static Long zzi(zzag.zza paramzza)
  {
    return zzN(zzl(paramzza));
  }
  
  public static Double zzj(zzag.zza paramzza)
  {
    return zzO(zzl(paramzza));
  }
  
  public static Boolean zzk(zzag.zza paramzza)
  {
    return zzP(zzl(paramzza));
  }
  
  public static Object zzl(zzag.zza paramzza)
  {
    int k = 0;
    int j = 0;
    int i = 0;
    if (paramzza == null) {
      return zzaZJ;
    }
    Object localObject1;
    Object localObject2;
    switch (paramzza.type)
    {
    default: 
      zzbg.e("Failed to convert a value of type: " + paramzza.type);
      return zzaZJ;
    case 1: 
      return paramzza.zziU;
    case 2: 
      localObject1 = new ArrayList(paramzza.zziV.length);
      paramzza = paramzza.zziV;
      j = paramzza.length;
      while (i < j)
      {
        localObject2 = zzl(paramzza[i]);
        if (localObject2 == zzaZJ) {
          return zzaZJ;
        }
        ((ArrayList)localObject1).add(localObject2);
        i += 1;
      }
      return localObject1;
    case 3: 
      if (paramzza.zziW.length != paramzza.zziX.length)
      {
        zzbg.e("Converting an invalid value to object: " + paramzza.toString());
        return zzaZJ;
      }
      localObject1 = new HashMap(paramzza.zziX.length);
      i = k;
      while (i < paramzza.zziW.length)
      {
        localObject2 = zzl(paramzza.zziW[i]);
        Object localObject3 = zzl(paramzza.zziX[i]);
        if ((localObject2 == zzaZJ) || (localObject3 == zzaZJ)) {
          return zzaZJ;
        }
        ((Map)localObject1).put(localObject2, localObject3);
        i += 1;
      }
      return localObject1;
    case 4: 
      zzbg.e("Trying to convert a macro reference to object");
      return zzaZJ;
    case 5: 
      zzbg.e("Trying to convert a function id to object");
      return zzaZJ;
    case 6: 
      return Long.valueOf(paramzza.zzja);
    case 7: 
      localObject1 = new StringBuffer();
      paramzza = paramzza.zzjc;
      k = paramzza.length;
      i = j;
      while (i < k)
      {
        localObject2 = zzg(paramzza[i]);
        if (localObject2 == zzaZN) {
          return zzaZJ;
        }
        ((StringBuffer)localObject1).append((String)localObject2);
        i += 1;
      }
      return ((StringBuffer)localObject1).toString();
    }
    return Boolean.valueOf(paramzza.zzjb);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzdf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */