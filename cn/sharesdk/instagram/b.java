package cn.sharesdk.instagram;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import java.util.HashMap;

class b
  implements PlatformActionListener
{
  b(Instagram paramInstagram, Platform.ShareParams paramShareParams) {}
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    if (Instagram.p(this.b) != null) {
      Instagram.q(this.b).onCancel(paramPlatform, paramInt);
    }
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    if (paramHashMap != null) {
      localHashMap.putAll(paramHashMap);
    }
    localHashMap.put("ShareParams", this.a);
    if (Instagram.n(this.b) != null) {
      Instagram.o(this.b).onComplete(paramPlatform, paramInt, localHashMap);
    }
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    if (Instagram.l(this.b) != null) {
      Instagram.m(this.b).onError(paramPlatform, paramInt, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\instagram\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */