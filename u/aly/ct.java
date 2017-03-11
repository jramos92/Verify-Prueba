package u.aly;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ct
  implements Serializable
{
  private static Map<Class<? extends ch>, Map<? extends co, ct>> d = new HashMap();
  public final String a;
  public final byte b;
  public final cu c;
  
  public ct(String paramString, byte paramByte, cu paramcu)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramcu;
  }
  
  public static Map<? extends co, ct> a(Class<? extends ch> paramClass)
  {
    if (!d.containsKey(paramClass)) {}
    try
    {
      paramClass.newInstance();
      return (Map)d.get(paramClass);
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("InstantiationException for TBase class: " + paramClass.getName() + ", message: " + localInstantiationException.getMessage());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("IllegalAccessException for TBase class: " + paramClass.getName() + ", message: " + localIllegalAccessException.getMessage());
    }
  }
  
  public static void a(Class<? extends ch> paramClass, Map<? extends co, ct> paramMap)
  {
    d.put(paramClass, paramMap);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */