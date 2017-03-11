package cn.sharesdk.tencent.qzone;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.b;
import cn.sharesdk.framework.authorize.g;
import java.net.URLDecoder;
import java.util.HashMap;

public class d
  extends b
{
  public d(g paramg)
  {
    super(paramg);
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    String str1 = (String)paramHashMap.get("access_token");
    String str2 = (String)paramHashMap.get("expires_in");
    Object localObject1 = (String)paramHashMap.get("error");
    Object localObject2 = (String)paramHashMap.get("error_description");
    String str3 = (String)paramHashMap.get("pf");
    String str4 = (String)paramHashMap.get("pfkey");
    paramHashMap = (String)paramHashMap.get("pay_token");
    if (!TextUtils.isEmpty(str1))
    {
      try
      {
        localObject1 = f.a(this.a.a().getPlatform()).e(str1);
        if ((localObject1 == null) || (((HashMap)localObject1).size() <= 0))
        {
          if (this.c == null) {
            return;
          }
          this.c.onError(new Throwable());
          return;
        }
        if (((HashMap)localObject1).containsKey("openid")) {
          break label192;
        }
        if (this.c == null) {
          return;
        }
        this.c.onError(new Throwable());
        return;
      }
      catch (Throwable paramHashMap)
      {
        if (this.c == null) {
          return;
        }
      }
      this.c.onError(paramHashMap);
      return;
      label192:
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("access_token", str1);
      ((Bundle)localObject2).putString("open_id", String.valueOf(((HashMap)localObject1).get("openid")));
      ((Bundle)localObject2).putString("expires_in", str2);
      ((Bundle)localObject2).putString("pf", str3);
      ((Bundle)localObject2).putString("pfkey", str4);
      ((Bundle)localObject2).putString("pay_token", paramHashMap);
      if (this.c != null) {
        this.c.onComplete((Bundle)localObject2);
      }
    }
    else if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramHashMap = (String)localObject2 + " (" + (String)localObject1 + ")";
      if (this.c != null) {
        this.c.onError(new Throwable(paramHashMap));
      }
    }
    else
    {
      this.c.onError(new Throwable());
    }
  }
  
  protected void a(String paramString)
  {
    Object localObject = paramString;
    if (paramString.startsWith(this.b)) {
      localObject = paramString.substring(paramString.indexOf('#') + 1);
    }
    localObject = ((String)localObject).split("&");
    HashMap localHashMap = new HashMap();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      paramString = localObject[i].split("=");
      if (paramString.length < 2)
      {
        localHashMap.put(URLDecoder.decode(paramString[0]), "");
        i += 1;
      }
      else
      {
        String str = URLDecoder.decode(paramString[0]);
        if (paramString[1] == null) {}
        for (paramString = "";; paramString = paramString[1])
        {
          localHashMap.put(str, URLDecoder.decode(paramString));
          break;
        }
      }
    }
    a(localHashMap);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString.startsWith(this.b))
    {
      paramWebView.setVisibility(4);
      paramWebView.stopLoading();
      this.a.finish();
      new e(this, paramString).start();
      return true;
    }
    paramWebView.loadUrl(paramString);
    return true;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qzone\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */