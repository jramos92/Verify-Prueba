package cn.sharesdk.system.email;

import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import java.util.HashMap;

class a
  implements ActionListener
{
  a(Email paramEmail, Platform.ShareParams paramShareParams) {}
  
  public void onComplete(HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("ShareParams", this.a);
    if (Email.e(this.b) != null) {
      Email.f(this.b).onComplete(this.b, 9, paramHashMap);
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (Email.c(this.b) != null) {
      Email.d(this.b).onError(this.b, 9, paramThrowable);
    }
  }
  
  public void onStart(HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("ShareParams", this.a);
    if (Email.a(this.b) != null) {
      Email.b(this.b).onComplete(this.b, 9, paramHashMap);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\system\email\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */