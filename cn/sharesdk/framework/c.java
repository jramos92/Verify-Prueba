package cn.sharesdk.framework;

import java.util.HashMap;

class c
  implements PlatformActionListener
{
  c(a parama, PlatformActionListener paramPlatformActionListener, int paramInt, Object paramObject) {}
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    a.a(this.d, this.a);
    if (a.a(this.d) != null) {
      a.a(this.d).onCancel(paramPlatform, this.b);
    }
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    a.a(this.d, this.a);
    paramPlatform.afterRegister(this.b, this.c);
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    a.a(this.d, this.a);
    if (a.a(this.d) != null) {
      a.a(this.d).onError(paramPlatform, paramInt, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */