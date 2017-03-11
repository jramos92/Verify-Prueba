package cn.sharesdk.whatsapp;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import java.util.HashMap;

class b
  implements PlatformActionListener
{
  b(WhatsApp paramWhatsApp, Platform.ShareParams paramShareParams) {}
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    if (WhatsApp.e(this.b) != null) {
      WhatsApp.f(this.b).onCancel(paramPlatform, paramInt);
    }
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    if (paramHashMap != null) {
      localHashMap.putAll(paramHashMap);
    }
    localHashMap.put("ShareParams", this.a);
    if (WhatsApp.c(this.b) != null) {
      WhatsApp.d(this.b).onComplete(paramPlatform, paramInt, localHashMap);
    }
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    if (WhatsApp.a(this.b) != null) {
      WhatsApp.b(this.b).onError(paramPlatform, paramInt, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\whatsapp\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */