package u.aly;

import android.content.Context;
import android.telephony.TelephonyManager;

public class e
  extends a
{
  private static final String a = "imei";
  private Context b;
  
  public e(Context paramContext)
  {
    super("imei");
    this.b = paramContext;
  }
  
  public String f()
  {
    Object localObject = (TelephonyManager)this.b.getSystemService("phone");
    if (localObject == null) {}
    try
    {
      if (bq.a(this.b, "android.permission.READ_PHONE_STATE"))
      {
        localObject = ((TelephonyManager)localObject).getDeviceId();
        return (String)localObject;
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */