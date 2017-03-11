package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.a.a;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.R;
import java.util.HashMap;

public class g
{
  private String a;
  private String b;
  private a c;
  private Platform d;
  private int e;
  
  public g(Platform paramPlatform, int paramInt)
  {
    this.d = paramPlatform;
    this.e = paramInt;
    this.c = a.a();
  }
  
  private void a(String paramString)
  {
    d.a().d("wechat getAuthorizeToken ==>>" + paramString, new Object[0]);
    Object localObject = new Hashon().fromJson(paramString);
    paramString = String.valueOf(((HashMap)localObject).get("access_token"));
    String str1 = String.valueOf(((HashMap)localObject).get("refresh_token"));
    String str2 = String.valueOf(((HashMap)localObject).get("expires_in"));
    localObject = String.valueOf(((HashMap)localObject).get("openid"));
    this.d.getDb().put("openid", (String)localObject);
    this.d.getDb().putExpiresIn(Long.valueOf(str2).longValue());
    this.d.getDb().putToken(paramString);
    this.d.getDb().put("refresh_token", str1);
  }
  
  public void a(Bundle paramBundle, AuthorizeListener paramAuthorizeListener)
  {
    String str = paramBundle.getString("_wxapi_sendauth_resp_url");
    if (TextUtils.isEmpty(str)) {
      if (paramAuthorizeListener != null) {
        paramAuthorizeListener.onError(null);
      }
    }
    do
    {
      return;
      int i = str.indexOf("://oauth?");
      paramBundle = str;
      if (i >= 0) {
        paramBundle = str.substring(i + 1);
      }
      paramBundle = R.urlToBundle(paramBundle).getString("code");
      try
      {
        a(paramBundle, paramAuthorizeListener);
        return;
      }
      catch (Throwable paramBundle)
      {
        d.a().w(paramBundle);
      }
    } while (paramAuthorizeListener == null);
    paramAuthorizeListener.onError(paramBundle);
  }
  
  public void a(PlatformActionListener paramPlatformActionListener)
  {
    new i(this, paramPlatformActionListener).start();
  }
  
  public void a(String paramString, AuthorizeListener paramAuthorizeListener)
  {
    d.a().d("getAuthorizeToken ==>> " + paramString, new Object[0]);
    new h(this, paramString, paramAuthorizeListener).start();
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\wechat\utils\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */