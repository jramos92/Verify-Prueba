package com.veryfit.multi.camera;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class GsonUtil
{
  public static Gson getEncodeGson()
  {
    GsonBuilder localGsonBuilder = new GsonBuilder();
    localGsonBuilder.registerTypeAdapter(Date.class, new MyDateSerializer());
    localGsonBuilder.registerTypeAdapter(Date.class, new MyDateDeserializer());
    return localGsonBuilder.create();
  }
  
  public static List<Map<String, Object>> jsonString2ListMaps(String paramString)
  {
    (List)new Gson().fromJson(paramString, new TypeToken() {}.getType());
  }
  
  public static Object jsonString2Obj(String paramString, Class<?> paramClass)
  {
    return new Gson().fromJson(paramString, paramClass);
  }
  
  public static List<Object> jsonString2ObjList(String paramString)
  {
    (List)new Gson().fromJson(paramString, new TypeToken() {}.getType());
  }
  
  public static List<String> jsonString2StringList(String paramString)
  {
    (List)new Gson().fromJson(paramString, new TypeToken() {}.getType());
  }
  
  public static String obj2JsonString(Object paramObject)
  {
    return new Gson().toJson(paramObject);
  }
  
  static class MyDateDeserializer
    implements JsonDeserializer<Date>
  {
    public Date deserialize(JsonElement paramJsonElement, Type paramType, JsonDeserializationContext paramJsonDeserializationContext)
      throws JsonParseException
    {
      return new Date(Long.parseLong(new BigDecimal(paramJsonElement.toString()).toPlainString()));
    }
  }
  
  static class MyDateSerializer
    implements JsonSerializer<Date>
  {
    public JsonElement serialize(Date paramDate, Type paramType, JsonSerializationContext paramJsonSerializationContext)
    {
      return paramJsonSerializationContext.serialize(Long.valueOf(paramDate.getTime()));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\camera\GsonUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */