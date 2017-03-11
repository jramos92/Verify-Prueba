package com.mob.tools.utils;

import android.text.TextUtils;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Hashon
{
  private ArrayList<?> arrayToList(Object paramObject)
  {
    ArrayList localArrayList;
    int j;
    int i;
    if ((paramObject instanceof byte[]))
    {
      localArrayList = new ArrayList();
      byte[] arrayOfByte = (byte[])paramObject;
      j = arrayOfByte.length;
      i = 0;
      for (;;)
      {
        paramObject = localArrayList;
        if (i >= j) {
          break;
        }
        localArrayList.add(Byte.valueOf(arrayOfByte[i]));
        i += 1;
      }
    }
    if ((paramObject instanceof short[]))
    {
      localArrayList = new ArrayList();
      paramObject = (short[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localArrayList.add(Short.valueOf(paramObject[i]));
        i += 1;
      }
      paramObject = localArrayList;
      return (ArrayList<?>)paramObject;
    }
    if ((paramObject instanceof int[]))
    {
      localArrayList = new ArrayList();
      paramObject = (int[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localArrayList.add(Integer.valueOf(paramObject[i]));
        i += 1;
      }
      return localArrayList;
    }
    if ((paramObject instanceof long[]))
    {
      localArrayList = new ArrayList();
      paramObject = (long[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localArrayList.add(Long.valueOf(paramObject[i]));
        i += 1;
      }
      return localArrayList;
    }
    if ((paramObject instanceof float[]))
    {
      localArrayList = new ArrayList();
      paramObject = (float[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localArrayList.add(Float.valueOf(paramObject[i]));
        i += 1;
      }
      return localArrayList;
    }
    if ((paramObject instanceof double[]))
    {
      localArrayList = new ArrayList();
      paramObject = (double[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localArrayList.add(Double.valueOf(paramObject[i]));
        i += 1;
      }
      return localArrayList;
    }
    if ((paramObject instanceof char[]))
    {
      localArrayList = new ArrayList();
      paramObject = (char[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localArrayList.add(Character.valueOf(paramObject[i]));
        i += 1;
      }
      return localArrayList;
    }
    if ((paramObject instanceof boolean[]))
    {
      localArrayList = new ArrayList();
      paramObject = (boolean[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localArrayList.add(Boolean.valueOf(paramObject[i]));
        i += 1;
      }
      return localArrayList;
    }
    if ((paramObject instanceof String[]))
    {
      localArrayList = new ArrayList();
      paramObject = (String[])paramObject;
      j = paramObject.length;
      i = 0;
      while (i < j)
      {
        localArrayList.add(paramObject[i]);
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  private String format(String paramString, ArrayList<Object> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("[\n");
    String str = paramString + "\t";
    int i = 0;
    paramArrayList = paramArrayList.iterator();
    if (paramArrayList.hasNext())
    {
      Object localObject = paramArrayList.next();
      if (i > 0) {
        localStringBuffer.append(",\n");
      }
      localStringBuffer.append(str);
      if ((localObject instanceof HashMap)) {
        localStringBuffer.append(format(str, (HashMap)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof ArrayList)) {
          localStringBuffer.append(format(str, (ArrayList)localObject));
        } else if ((localObject instanceof String)) {
          localStringBuffer.append('"').append(localObject).append('"');
        } else {
          localStringBuffer.append(localObject);
        }
      }
    }
    localStringBuffer.append('\n').append(paramString).append(']');
    return localStringBuffer.toString();
  }
  
  private String format(String paramString, HashMap<String, Object> paramHashMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("{\n");
    String str = paramString + "\t";
    int i = 0;
    paramHashMap = paramHashMap.entrySet().iterator();
    if (paramHashMap.hasNext())
    {
      Object localObject = (Map.Entry)paramHashMap.next();
      if (i > 0) {
        localStringBuffer.append(",\n");
      }
      localStringBuffer.append(str).append('"').append((String)((Map.Entry)localObject).getKey()).append("\":");
      localObject = ((Map.Entry)localObject).getValue();
      if ((localObject instanceof HashMap)) {
        localStringBuffer.append(format(str, (HashMap)localObject));
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localObject instanceof ArrayList)) {
          localStringBuffer.append(format(str, (ArrayList)localObject));
        } else if ((localObject instanceof String)) {
          localStringBuffer.append('"').append(localObject).append('"');
        } else {
          localStringBuffer.append(localObject);
        }
      }
    }
    localStringBuffer.append('\n').append(paramString).append('}');
    return localStringBuffer.toString();
  }
  
  private ArrayList<Object> fromJson(JSONArray paramJSONArray)
    throws JSONException
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int j = paramJSONArray.length();
    if (i < j)
    {
      Object localObject2 = paramJSONArray.opt(i);
      Object localObject1;
      if ((localObject2 instanceof JSONObject)) {
        localObject1 = fromJson((JSONObject)localObject2);
      }
      for (;;)
      {
        localArrayList.add(localObject1);
        i += 1;
        break;
        localObject1 = localObject2;
        if ((localObject2 instanceof JSONArray)) {
          localObject1 = fromJson((JSONArray)localObject2);
        }
      }
    }
    return localArrayList;
  }
  
  private HashMap<String, Object> fromJson(JSONObject paramJSONObject)
    throws JSONException
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = paramJSONObject.opt(str);
      Object localObject1 = localObject2;
      if (JSONObject.NULL.equals(localObject2)) {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        if ((localObject1 instanceof JSONObject)) {
          localObject2 = fromJson((JSONObject)localObject1);
        }
        for (;;)
        {
          localHashMap.put(str, localObject2);
          break;
          localObject2 = localObject1;
          if ((localObject1 instanceof JSONArray)) {
            localObject2 = fromJson((JSONArray)localObject1);
          }
        }
      }
    }
    return localHashMap;
  }
  
  private JSONArray getJSONArray(ArrayList<Object> paramArrayList)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof HashMap)) {
        paramArrayList = getJSONObject((HashMap)localObject);
      }
      for (;;)
      {
        localJSONArray.put(paramArrayList);
        break;
        paramArrayList = (ArrayList<Object>)localObject;
        if ((localObject instanceof ArrayList)) {
          paramArrayList = getJSONArray((ArrayList)localObject);
        }
      }
    }
    return localJSONArray;
  }
  
  private JSONObject getJSONObject(HashMap<String, Object> paramHashMap)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject = localEntry.getValue();
      if ((localObject instanceof HashMap)) {
        paramHashMap = getJSONObject((HashMap)localObject);
      }
      for (;;)
      {
        localJSONObject.put((String)localEntry.getKey(), paramHashMap);
        break;
        if ((localObject instanceof ArrayList))
        {
          paramHashMap = getJSONArray((ArrayList)localObject);
        }
        else
        {
          paramHashMap = (HashMap<String, Object>)localObject;
          if (isBasicArray(localObject)) {
            paramHashMap = getJSONArray(arrayToList(localObject));
          }
        }
      }
    }
    return localJSONObject;
  }
  
  private boolean isBasicArray(Object paramObject)
  {
    return ((paramObject instanceof byte[])) || ((paramObject instanceof short[])) || ((paramObject instanceof int[])) || ((paramObject instanceof long[])) || ((paramObject instanceof float[])) || ((paramObject instanceof double[])) || ((paramObject instanceof char[])) || ((paramObject instanceof boolean[])) || ((paramObject instanceof String[]));
  }
  
  public String format(String paramString)
  {
    try
    {
      paramString = format("", fromJson(paramString));
      return paramString;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(paramString);
    }
    return "";
  }
  
  public String fromHashMap(HashMap<String, Object> paramHashMap)
  {
    try
    {
      paramHashMap = getJSONObject(paramHashMap);
      if (paramHashMap == null) {
        return "";
      }
      paramHashMap = paramHashMap.toString();
      return paramHashMap;
    }
    catch (Throwable paramHashMap)
    {
      MobLog.getInstance().w(paramHashMap);
    }
    return "";
  }
  
  public HashMap<String, Object> fromJson(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!new JsonValidator().validate(paramString))) {
      return new HashMap();
    }
    String str1 = paramString;
    String str2 = paramString;
    try
    {
      if (paramString.startsWith("["))
      {
        str1 = paramString;
        str2 = paramString;
        if (paramString.endsWith("]"))
        {
          str2 = paramString;
          str1 = "{\"fakelist\":" + paramString + "}";
        }
      }
      str2 = str1;
      paramString = fromJson(new JSONObject(str1));
      return paramString;
    }
    catch (Throwable paramString)
    {
      MobLog.getInstance().w(str2, new Object[0]);
      MobLog.getInstance().w(paramString);
    }
    return new HashMap();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\tools\utils\Hashon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */