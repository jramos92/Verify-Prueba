package cn.sharesdk.framework.utils;

import android.content.Context;
import com.mob.commons.logcollector.LogsCollector;

class e
  extends LogsCollector
{
  e(d paramd, Context paramContext, int paramInt, String paramString)
  {
    super(paramContext);
  }
  
  protected String getAppkey()
  {
    return this.b;
  }
  
  protected String getSDKTag()
  {
    return "SHARESDK";
  }
  
  protected int getSDKVersion()
  {
    return this.a;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\utils\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */