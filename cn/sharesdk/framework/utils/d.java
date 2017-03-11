package cn.sharesdk.framework.utils;

import android.content.Context;
import com.mob.tools.log.NLog;

public class d
  extends NLog
{
  private d(Context paramContext, int paramInt, String paramString)
  {
    setCollector("SHARESDK", new e(this, paramContext, paramInt, paramString));
  }
  
  public static NLog a()
  {
    return getInstanceForSDK("SHARESDK", true);
  }
  
  public static NLog a(Context paramContext, int paramInt, String paramString)
  {
    return new d(paramContext, paramInt, paramString);
  }
  
  protected String getSDKTag()
  {
    return "SHARESDK";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */