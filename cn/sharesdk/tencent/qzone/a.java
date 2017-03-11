package cn.sharesdk.tencent.qzone;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.R;

class a
  implements AuthorizeListener
{
  a(QZone paramQZone, f paramf) {}
  
  public void onCancel()
  {
    if (QZone.j(this.b) != null) {
      QZone.k(this.b).onCancel(this.b, 1);
    }
  }
  
  public void onComplete(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("open_id");
    String str2 = paramBundle.getString("access_token");
    String str3 = paramBundle.getString("expires_in");
    QZone.c(this.b).putToken(str2);
    QZone.d(this.b).putTokenSecret("");
    try
    {
      QZone.e(this.b).putExpiresIn(R.parseLong(str3));
      QZone.f(this.b).putUserId(str1);
      str3 = paramBundle.getString("pf");
      String str4 = paramBundle.getString("pfkey");
      paramBundle = paramBundle.getString("pay_token");
      QZone.g(this.b).put("pf", str3);
      QZone.h(this.b).put("pfkey", str4);
      QZone.i(this.b).put("pay_token", paramBundle);
      this.a.b(str1);
      this.a.c(str2);
      QZone.a(this.b, 1, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        d.a().w(localThrowable);
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (QZone.a(this.b) != null) {
      QZone.b(this.b).onError(this.b, 1, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qzone\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */