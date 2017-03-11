package cn.sharesdk.linkedin;

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
  a(LinkedIn paramLinkedIn, b paramb) {}
  
  public void onCancel()
  {
    if (LinkedIn.f(this.b) != null) {
      LinkedIn.g(this.b).onCancel(this.b, 1);
    }
  }
  
  public void onComplete(Bundle paramBundle)
  {
    String str = paramBundle.getString("access_token");
    try
    {
      i = R.parseInt(paramBundle.getString("expires_in"));
      LinkedIn.c(this.b).putToken(str);
      LinkedIn.d(this.b).putTokenSecret("");
      LinkedIn.e(this.b).putExpiresIn(i);
      this.a.c(str);
      LinkedIn.a(this.b, 1, null);
      return;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        d.a().w(paramBundle);
        int i = 0;
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (LinkedIn.a(this.b) != null) {
      LinkedIn.b(this.b).onError(this.b, 1, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\linkedin\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */