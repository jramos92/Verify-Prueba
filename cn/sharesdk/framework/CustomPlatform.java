package cn.sharesdk.framework;

import android.content.Context;
import cn.sharesdk.framework.statistics.b.f.a;
import java.util.HashMap;

public abstract class CustomPlatform
  extends Platform
{
  public CustomPlatform(Context paramContext)
  {
    super(paramContext);
  }
  
  protected abstract boolean checkAuthorize(int paramInt, Object paramObject);
  
  protected void doAuthorize(String[] paramArrayOfString) {}
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1) {}
  
  protected void doShare(Platform.ShareParams paramShareParams) {}
  
  protected HashMap<String, Object> filterFriendshipInfo(int paramInt, HashMap<String, Object> paramHashMap)
  {
    return null;
  }
  
  protected final f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    return null;
  }
  
  protected void follow(String paramString) {}
  
  protected HashMap<String, Object> getBilaterals(int paramInt1, int paramInt2, String paramString)
  {
    return null;
  }
  
  protected int getCustomPlatformId()
  {
    return 1;
  }
  
  protected HashMap<String, Object> getFollowers(int paramInt1, int paramInt2, String paramString)
  {
    return null;
  }
  
  protected HashMap<String, Object> getFollowings(int paramInt1, int paramInt2, String paramString)
  {
    return null;
  }
  
  protected void getFriendList(int paramInt1, int paramInt2, String paramString) {}
  
  public abstract String getName();
  
  protected final int getPlatformId()
  {
    return -Math.abs(getCustomPlatformId());
  }
  
  public int getVersion()
  {
    return 0;
  }
  
  public boolean hasShareCallback()
  {
    return false;
  }
  
  protected final void initDevInfo(String paramString) {}
  
  protected final void setNetworkDevinfo() {}
  
  protected void timeline(int paramInt1, int paramInt2, String paramString) {}
  
  protected void userInfor(String paramString) {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\CustomPlatform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */