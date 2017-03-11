package cn.sharesdk.facebook;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.R;

class a
  implements AuthorizeListener
{
  a(Facebook paramFacebook, e parame) {}
  
  public void onCancel()
  {
    if (Facebook.e(this.b) != null) {
      Facebook.f(this.b).onCancel(this.b, 1);
    }
  }
  
  public void onComplete(Bundle paramBundle)
  {
    String str2 = paramBundle.getString("oauth_token");
    int j = paramBundle.getInt("oauth_token_expires");
    int i = j;
    String str1;
    if (j == 0) {
      str1 = String.valueOf(paramBundle.get("expires_in"));
    }
    try
    {
      i = R.parseInt(str1);
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramBundle.getString("access_token");
      }
      Facebook.c(this.b).putToken(str1);
      Facebook.d(this.b).putExpiresIn(i);
      this.a.a(str1, String.valueOf(i));
      Facebook.a(this.b, 1, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        d.a().d(localThrowable);
        i = 0;
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (Facebook.a(this.b) != null) {
      Facebook.b(this.b).onError(this.b, 1, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\facebook\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */