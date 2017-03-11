package cn.sharesdk.tencent.qzone;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import java.util.HashMap;

class c
  implements PlatformActionListener
{
  c(QZone paramQZone, Platform.ShareParams paramShareParams) {}
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    if (QZone.p(this.b) != null) {
      QZone.q(this.b).onCancel(this.b, 9);
    }
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    if (QZone.n(this.b) != null)
    {
      paramHashMap.put("ShareParams", this.a);
      QZone.o(this.b).onComplete(this.b, 9, paramHashMap);
    }
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    if (QZone.l(this.b) != null) {
      QZone.m(this.b).onError(this.b, 9, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qzone\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */