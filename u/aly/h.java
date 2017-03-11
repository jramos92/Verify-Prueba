package u.aly;

import android.os.Build;
import android.os.Build.VERSION;

public class h
  extends a
{
  private static final String a = "serial";
  
  public h()
  {
    super("serial");
  }
  
  public String f()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return Build.SERIAL;
    }
    return null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */