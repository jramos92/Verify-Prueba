package u.aly;

import android.content.Context;
import android.provider.Settings.Secure;

public class b
  extends a
{
  private static final String a = "android_id";
  private Context b;
  
  public b(Context paramContext)
  {
    super("android_id");
    this.b = paramContext;
  }
  
  public String f()
  {
    try
    {
      String str = Settings.Secure.getString(this.b.getContentResolver(), "android_id");
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */