package com.google.android.gms.internal;

import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class zzrs
{
  private static int zza(String paramString, zzrt.zza.zza[] paramArrayOfzza)
  {
    int m = paramArrayOfzza.length;
    int i = 0;
    int j = 14;
    if (i < m)
    {
      zzrt.zza.zza localzza = paramArrayOfzza[i];
      int k;
      if (j == 14) {
        if ((localzza.type == 9) || (localzza.type == 2) || (localzza.type == 6)) {
          k = localzza.type;
        }
      }
      do
      {
        do
        {
          i += 1;
          j = k;
          break;
          k = j;
        } while (localzza.type == 14);
        throw new IllegalArgumentException("Unexpected TypedValue type: " + localzza.type + " for key " + paramString);
        k = j;
      } while (localzza.type == j);
      throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + paramString + " contains items of type " + j + " and " + localzza.type);
    }
    return j;
  }
  
  static int zza(List<Asset> paramList, Asset paramAsset)
  {
    paramList.add(paramAsset);
    return paramList.size() - 1;
  }
  
  public static zza zza(DataMap paramDataMap)
  {
    zzrt localzzrt = new zzrt();
    ArrayList localArrayList = new ArrayList();
    localzzrt.zzbhB = zza(paramDataMap, localArrayList);
    return new zza(localzzrt, localArrayList);
  }
  
  private static zzrt.zza.zza zza(List<Asset> paramList, Object paramObject)
  {
    zzrt.zza.zza localzza1 = new zzrt.zza.zza();
    if (paramObject == null)
    {
      localzza1.type = 14;
      return localzza1;
    }
    localzza1.zzbhF = new zzrt.zza.zza.zza();
    if ((paramObject instanceof String))
    {
      localzza1.type = 2;
      localzza1.zzbhF.zzbhH = ((String)paramObject);
    }
    Object localObject2;
    Object localObject1;
    int i;
    Object localObject3;
    for (;;)
    {
      return localzza1;
      if ((paramObject instanceof Integer))
      {
        localzza1.type = 6;
        localzza1.zzbhF.zzbhL = ((Integer)paramObject).intValue();
      }
      else if ((paramObject instanceof Long))
      {
        localzza1.type = 5;
        localzza1.zzbhF.zzbhK = ((Long)paramObject).longValue();
      }
      else if ((paramObject instanceof Double))
      {
        localzza1.type = 3;
        localzza1.zzbhF.zzbhI = ((Double)paramObject).doubleValue();
      }
      else if ((paramObject instanceof Float))
      {
        localzza1.type = 4;
        localzza1.zzbhF.zzbhJ = ((Float)paramObject).floatValue();
      }
      else if ((paramObject instanceof Boolean))
      {
        localzza1.type = 8;
        localzza1.zzbhF.zzbhN = ((Boolean)paramObject).booleanValue();
      }
      else if ((paramObject instanceof Byte))
      {
        localzza1.type = 7;
        localzza1.zzbhF.zzbhM = ((Byte)paramObject).byteValue();
      }
      else if ((paramObject instanceof byte[]))
      {
        localzza1.type = 1;
        localzza1.zzbhF.zzbhG = ((byte[])paramObject);
      }
      else if ((paramObject instanceof String[]))
      {
        localzza1.type = 11;
        localzza1.zzbhF.zzbhQ = ((String[])paramObject);
      }
      else if ((paramObject instanceof long[]))
      {
        localzza1.type = 12;
        localzza1.zzbhF.zzbhR = ((long[])paramObject);
      }
      else if ((paramObject instanceof float[]))
      {
        localzza1.type = 15;
        localzza1.zzbhF.zzbhS = ((float[])paramObject);
      }
      else if ((paramObject instanceof Asset))
      {
        localzza1.type = 13;
        localzza1.zzbhF.zzbhT = zza(paramList, (Asset)paramObject);
      }
      else
      {
        if (!(paramObject instanceof DataMap)) {
          break;
        }
        localzza1.type = 9;
        paramObject = (DataMap)paramObject;
        localObject2 = new TreeSet(((DataMap)paramObject).keySet());
        localObject1 = new zzrt.zza[((TreeSet)localObject2).size()];
        localObject2 = ((TreeSet)localObject2).iterator();
        i = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject1[i] = new zzrt.zza();
          localObject1[i].name = ((String)localObject3);
          localObject1[i].zzbhD = zza(paramList, ((DataMap)paramObject).get((String)localObject3));
          i += 1;
        }
        localzza1.zzbhF.zzbhO = ((zzrt.zza[])localObject1);
      }
    }
    int j;
    label587:
    zzrt.zza.zza localzza2;
    if ((paramObject instanceof ArrayList))
    {
      localzza1.type = 10;
      localObject2 = (ArrayList)paramObject;
      localObject3 = new zzrt.zza.zza[((ArrayList)localObject2).size()];
      paramObject = null;
      int k = ((ArrayList)localObject2).size();
      j = 0;
      i = 14;
      if (j < k)
      {
        localObject1 = ((ArrayList)localObject2).get(j);
        localzza2 = zza(paramList, localObject1);
        if ((localzza2.type != 14) && (localzza2.type != 2) && (localzza2.type != 6) && (localzza2.type != 9)) {
          throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + localObject1.getClass());
        }
        if ((i == 14) && (localzza2.type != 14))
        {
          i = localzza2.type;
          paramObject = localObject1;
        }
      }
    }
    for (;;)
    {
      localObject3[j] = localzza2;
      j += 1;
      break label587;
      if (localzza2.type != i)
      {
        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + paramObject.getClass() + " and a " + localObject1.getClass());
        localzza1.zzbhF.zzbhP = ((zzrt.zza.zza[])localObject3);
        break;
        throw new RuntimeException("newFieldValueFromValue: unexpected value " + paramObject.getClass().getSimpleName());
      }
    }
  }
  
  public static DataMap zza(zza paramzza)
  {
    DataMap localDataMap = new DataMap();
    zzrt.zza[] arrayOfzza = paramzza.zzbhz.zzbhB;
    int j = arrayOfzza.length;
    int i = 0;
    while (i < j)
    {
      zzrt.zza localzza = arrayOfzza[i];
      zza(paramzza.zzbhA, localDataMap, localzza.name, localzza.zzbhD);
      i += 1;
    }
    return localDataMap;
  }
  
  private static ArrayList zza(List<Asset> paramList, zzrt.zza.zza.zza paramzza, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(paramzza.zzbhP.length);
    paramzza = paramzza.zzbhP;
    int k = paramzza.length;
    int i = 0;
    if (i < k)
    {
      zzrt.zza[] arrayOfzza = paramzza[i];
      if (arrayOfzza.type == 14) {
        localArrayList.add(null);
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramInt == 9)
        {
          DataMap localDataMap = new DataMap();
          arrayOfzza = arrayOfzza.zzbhF.zzbhO;
          int m = arrayOfzza.length;
          int j = 0;
          while (j < m)
          {
            zzrt.zza localzza = arrayOfzza[j];
            zza(paramList, localDataMap, localzza.name, localzza.zzbhD);
            j += 1;
          }
          localArrayList.add(localDataMap);
        }
        else if (paramInt == 2)
        {
          localArrayList.add(arrayOfzza.zzbhF.zzbhH);
        }
        else
        {
          if (paramInt != 6) {
            break label191;
          }
          localArrayList.add(Integer.valueOf(arrayOfzza.zzbhF.zzbhL));
        }
      }
      label191:
      throw new IllegalArgumentException("Unexpected typeOfArrayList: " + paramInt);
    }
    return localArrayList;
  }
  
  private static void zza(List<Asset> paramList, DataMap paramDataMap, String paramString, zzrt.zza.zza paramzza)
  {
    int i = paramzza.type;
    if (i == 14)
    {
      paramDataMap.putString(paramString, null);
      return;
    }
    Object localObject1 = paramzza.zzbhF;
    if (i == 1)
    {
      paramDataMap.putByteArray(paramString, ((zzrt.zza.zza.zza)localObject1).zzbhG);
      return;
    }
    if (i == 11)
    {
      paramDataMap.putStringArray(paramString, ((zzrt.zza.zza.zza)localObject1).zzbhQ);
      return;
    }
    if (i == 12)
    {
      paramDataMap.putLongArray(paramString, ((zzrt.zza.zza.zza)localObject1).zzbhR);
      return;
    }
    if (i == 15)
    {
      paramDataMap.putFloatArray(paramString, ((zzrt.zza.zza.zza)localObject1).zzbhS);
      return;
    }
    if (i == 2)
    {
      paramDataMap.putString(paramString, ((zzrt.zza.zza.zza)localObject1).zzbhH);
      return;
    }
    if (i == 3)
    {
      paramDataMap.putDouble(paramString, ((zzrt.zza.zza.zza)localObject1).zzbhI);
      return;
    }
    if (i == 4)
    {
      paramDataMap.putFloat(paramString, ((zzrt.zza.zza.zza)localObject1).zzbhJ);
      return;
    }
    if (i == 5)
    {
      paramDataMap.putLong(paramString, ((zzrt.zza.zza.zza)localObject1).zzbhK);
      return;
    }
    if (i == 6)
    {
      paramDataMap.putInt(paramString, ((zzrt.zza.zza.zza)localObject1).zzbhL);
      return;
    }
    if (i == 7)
    {
      paramDataMap.putByte(paramString, (byte)((zzrt.zza.zza.zza)localObject1).zzbhM);
      return;
    }
    if (i == 8)
    {
      paramDataMap.putBoolean(paramString, ((zzrt.zza.zza.zza)localObject1).zzbhN);
      return;
    }
    if (i == 13)
    {
      if (paramList == null) {
        throw new RuntimeException("populateBundle: unexpected type for: " + paramString);
      }
      paramDataMap.putAsset(paramString, (Asset)paramList.get((int)((zzrt.zza.zza.zza)localObject1).zzbhT));
      return;
    }
    if (i == 9)
    {
      paramzza = new DataMap();
      localObject1 = ((zzrt.zza.zza.zza)localObject1).zzbhO;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        zza(paramList, paramzza, ((zzrt.zza)localObject2).name, ((zzrt.zza)localObject2).zzbhD);
        i += 1;
      }
      paramDataMap.putDataMap(paramString, paramzza);
      return;
    }
    if (i == 10)
    {
      i = zza(paramString, ((zzrt.zza.zza.zza)localObject1).zzbhP);
      paramList = zza(paramList, (zzrt.zza.zza.zza)localObject1, i);
      if (i == 14)
      {
        paramDataMap.putStringArrayList(paramString, paramList);
        return;
      }
      if (i == 9)
      {
        paramDataMap.putDataMapArrayList(paramString, paramList);
        return;
      }
      if (i == 2)
      {
        paramDataMap.putStringArrayList(paramString, paramList);
        return;
      }
      if (i == 6)
      {
        paramDataMap.putIntegerArrayList(paramString, paramList);
        return;
      }
      throw new IllegalStateException("Unexpected typeOfArrayList: " + i);
    }
    throw new RuntimeException("populateBundle: unexpected type " + i);
  }
  
  private static zzrt.zza[] zza(DataMap paramDataMap, List<Asset> paramList)
  {
    Object localObject1 = new TreeSet(paramDataMap.keySet());
    zzrt.zza[] arrayOfzza = new zzrt.zza[((TreeSet)localObject1).size()];
    localObject1 = ((TreeSet)localObject1).iterator();
    int i = 0;
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = paramDataMap.get(str);
      arrayOfzza[i] = new zzrt.zza();
      arrayOfzza[i].name = str;
      arrayOfzza[i].zzbhD = zza(paramList, localObject2);
      i += 1;
    }
    return arrayOfzza;
  }
  
  public static class zza
  {
    public final List<Asset> zzbhA;
    public final zzrt zzbhz;
    
    public zza(zzrt paramzzrt, List<Asset> paramList)
    {
      this.zzbhz = paramzzrt;
      this.zzbhA = paramList;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzrs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */