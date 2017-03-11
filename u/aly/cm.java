package u.aly;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class cm
{
  public static cl a(Class<? extends cl> paramClass, int paramInt)
  {
    try
    {
      paramClass = (cl)paramClass.getMethod("findByValue", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(paramInt) });
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      return null;
    }
    catch (IllegalAccessException paramClass)
    {
      return null;
    }
    catch (InvocationTargetException paramClass) {}
    return null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\cm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */