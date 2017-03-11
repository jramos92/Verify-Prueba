package cn.sharesdk.tencent.qq;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import java.util.HashMap;

class b
  implements PlatformActionListener
{
  b(QQ paramQQ, Platform.ShareParams paramShareParams) {}
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    if (QQ.p(this.b) != null) {
      QQ.q(this.b).onCancel(this.b, 9);
    }
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    paramPlatform = new HashMap();
    if (paramHashMap != null) {
      paramPlatform.putAll(paramHashMap);
    }
    paramPlatform.put("ShareParams", this.a);
    if (QQ.n(this.b) != null) {
      QQ.o(this.b).onComplete(this.b, 9, paramPlatform);
    }
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    if (QQ.l(this.b) != null) {
      QQ.m(this.b).onError(this.b, 9, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qq\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */