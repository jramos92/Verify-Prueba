package u.aly;

import android.content.Context;
import android.content.SharedPreferences;

public class x
{
  private static final String a = "umeng_general_config";
  
  public static SharedPreferences a(Context paramContext)
  {
    return paramContext.getSharedPreferences("umeng_general_config", 0);
  }
  
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(paramString, 0);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */