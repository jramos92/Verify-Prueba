package cn.sharesdk.flickr;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;

class a
  implements AuthorizeListener
{
  a(Flickr paramFlickr, b paramb) {}
  
  public void onCancel()
  {
    if (Flickr.h(this.b) != null) {
      Flickr.i(this.b).onCancel(this.b, 1);
    }
  }
  
  public void onComplete(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("oauth_token");
    String str2 = paramBundle.getString("oauth_token_secret");
    String str3 = paramBundle.getString("user_nsid");
    String str4 = paramBundle.getString("username");
    Flickr.a(this.b).putToken(str1);
    Flickr.b(this.b).putTokenSecret(str2);
    Flickr.c(this.b).putUserId(str3);
    Flickr.d(this.b).put("nickname", str4);
    Flickr.e(this.b).put("fullname", paramBundle.getString("fullname"));
    this.a.a(str1, str2);
    Flickr.a(this.b, 1, null);
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (Flickr.f(this.b) != null) {
      Flickr.g(this.b).onError(this.b, 1, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\flickr\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */