package cn.sharesdk.framework;

import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

class b
  implements PlatformActionListener
{
  b(a parama, PlatformActionListener paramPlatformActionListener, int paramInt, HashMap paramHashMap) {}
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    a.a(this.d, this.a);
    if (a.a(this.d) != null) {
      a.a(this.d).onComplete(paramPlatform, this.b, this.c);
    }
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    a.a(this.d, this.a);
    if (a.a(this.d) != null) {
      a.a(this.d).onComplete(paramPlatform, this.b, this.c);
    }
    cn.sharesdk.framework.statistics.b.b localb = new cn.sharesdk.framework.statistics.b.b();
    localb.a = paramPlatform.getPlatformId();
    if ("TencentWeibo".equals(paramPlatform.getName())) {}
    for (String str = paramPlatform.getDb().get("name");; str = paramPlatform.getDb().getUserId())
    {
      localb.b = str;
      localb.c = new Hashon().fromHashMap(paramHashMap);
      localb.d = a.a(this.d, paramPlatform);
      cn.sharesdk.framework.statistics.d.a(paramPlatform.getContext()).a(localb);
      a.a(this.d, 1, paramPlatform);
      return;
    }
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    cn.sharesdk.framework.utils.d.a().w(paramThrowable);
    a.a(this.d, this.a);
    if (a.a(this.d) != null) {
      a.a(this.d).onComplete(paramPlatform, this.b, this.c);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */