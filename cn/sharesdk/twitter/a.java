package cn.sharesdk.twitter;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;

class a
  implements AuthorizeListener
{
  a(Twitter paramTwitter, e parame) {}
  
  public void onCancel()
  {
    if (Twitter.g(this.b) != null) {
      Twitter.h(this.b).onCancel(this.b, 1);
    }
  }
  
  public void onComplete(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("oauth_token");
    String str2 = paramBundle.getString("oauth_token_secret");
    String str3 = paramBundle.getString("user_id");
    paramBundle = paramBundle.getString("screen_name");
    Twitter.a(this.b).putToken(str1);
    Twitter.b(this.b).putTokenSecret(str2);
    Twitter.c(this.b).putUserId(str3);
    Twitter.d(this.b).put("nickname", paramBundle);
    this.a.a(str1, str2);
    Twitter.a(this.b, 1, null);
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (Twitter.e(this.b) != null) {
      Twitter.f(this.b).onError(this.b, 1, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\twitter\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */