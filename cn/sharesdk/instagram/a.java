package cn.sharesdk.instagram;

import android.os.Bundle;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.authorize.AuthorizeListener;

class a
  implements AuthorizeListener
{
  a(Instagram paramInstagram, e parame) {}
  
  public void onCancel()
  {
    if (Instagram.j(this.b) != null) {
      Instagram.k(this.b).onCancel(this.b, 1);
    }
  }
  
  public void onComplete(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("access_token");
    String str2 = paramBundle.getString("username");
    String str3 = paramBundle.getString("bio");
    String str4 = paramBundle.getString("website");
    String str5 = paramBundle.getString("profile_picture");
    String str6 = paramBundle.getString("full_name");
    paramBundle = paramBundle.getString("id");
    Instagram.c(this.b).putToken(str1);
    Instagram.d(this.b).putUserId(paramBundle);
    Instagram.e(this.b).put("nickname", str2);
    Instagram.f(this.b).put("resume", str3);
    Instagram.g(this.b).put("website", str4);
    Instagram.h(this.b).put("icon", str5);
    Instagram.i(this.b).put("full_name", str6);
    this.a.b(str1);
    Instagram.a(this.b, 1, null);
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (Instagram.a(this.b) != null) {
      Instagram.b(this.b).onError(this.b, 1, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\instagram\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */