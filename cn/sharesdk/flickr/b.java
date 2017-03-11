package cn.sharesdk.flickr;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.e;
import cn.sharesdk.framework.utils.a.b;
import cn.sharesdk.framework.utils.d;
import cn.sharesdk.framework.utils.j;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class b
  extends e
{
  private static b b;
  private cn.sharesdk.framework.utils.a c = new cn.sharesdk.framework.utils.a();
  private cn.sharesdk.framework.a.a d = cn.sharesdk.framework.a.a.a();
  
  private b(Platform paramPlatform)
  {
    super(paramPlatform);
  }
  
  public static b a(Platform paramPlatform)
  {
    if (b == null) {
      b = new b(paramPlatform);
    }
    return b;
  }
  
  public String a(String paramString)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new KVPair("oauth_verifier", paramString));
      paramString = this.c.a("http://www.flickr.com/services/oauth/access_token", localArrayList);
      paramString = this.c.a(paramString);
      paramString = this.d.a("http://www.flickr.com/services/oauth/access_token", localArrayList, null, paramString, "/oauth/access_token", c());
      return paramString;
    }
    catch (Throwable paramString)
    {
      d.a().w(paramString);
    }
    return null;
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(paramString2)) {
      localArrayList.add(new KVPair("title", paramString2));
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localArrayList.add(new KVPair("description", paramString3));
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0)) {
      localArrayList.add(new KVPair("tags", TextUtils.join(" ", paramArrayOfString)));
    }
    if (paramBoolean1)
    {
      paramString2 = "1";
      localArrayList.add(new KVPair("is_public", paramString2));
      if (!paramBoolean2) {
        break label351;
      }
      paramString2 = "1";
      label120:
      localArrayList.add(new KVPair("is_friend", paramString2));
      if (!paramBoolean3) {
        break label357;
      }
    }
    label351:
    label357:
    for (paramString2 = "1";; paramString2 = "0")
    {
      localArrayList.add(new KVPair("is_family", paramString2));
      localArrayList.add(new KVPair("safety_level", String.valueOf(paramInt1)));
      localArrayList.add(new KVPair("content_type", String.valueOf(paramInt2)));
      localArrayList.add(new KVPair("hidden", String.valueOf(paramInt3)));
      localArrayList.add(new KVPair("nojsoncallback", "1"));
      localArrayList.add(new KVPair("format", "json"));
      paramString2 = this.c.a("https://up.flickr.com/services/upload/", localArrayList);
      paramString2 = this.c.a(paramString2);
      paramString2.remove(1);
      paramString1 = new KVPair("photo", paramString1);
      paramString1 = this.d.a("https://up.flickr.com/services/upload/", localArrayList, paramString1, paramString2, "/services/upload/", c());
      paramString2 = new j().a(paramString1);
      if ((paramString2 != null) && (paramString2.size() > 0)) {
        break label363;
      }
      throw new Throwable("respons is empty");
      paramString2 = "0";
      break;
      paramString2 = "0";
      break label120;
    }
    label363:
    paramString3 = (HashMap)paramString2.get("rsp");
    if ((paramString3 == null) || (paramString3.size() <= 0)) {
      throw new Throwable("respons is empty");
    }
    if (!"ok".equals(paramString3.get("stat"))) {
      throw new Throwable(paramString1);
    }
    return paramString2;
  }
  
  public void a(AuthorizeListener paramAuthorizeListener)
  {
    b(paramAuthorizeListener);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.c.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.c.a(paramString1, paramString2, paramString3);
  }
  
  public HashMap<String, Object> b(String paramString)
  {
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new KVPair("method", "flickr.people.getInfo"));
    ((ArrayList)localObject).add(new KVPair("user_id", paramString));
    ((ArrayList)localObject).add(new KVPair("api_key", this.c.a().a));
    ((ArrayList)localObject).add(new KVPair("nojsoncallback", "1"));
    ((ArrayList)localObject).add(new KVPair("format", "json"));
    paramString = this.c.b("https://www.flickr.com/services/rest/", (ArrayList)localObject);
    paramString = this.c.a(paramString);
    paramString = this.d.a("https://www.flickr.com/services/rest/", (ArrayList)localObject, paramString, null, "flickr.people.getInfo", c());
    if (TextUtils.isEmpty(paramString)) {
      throw new Throwable("respons is empty");
    }
    localObject = new Hashon().fromJson(paramString);
    if ((localObject == null) || (((HashMap)localObject).size() <= 0)) {
      throw new Throwable("respons is empty");
    }
    if (!"ok".equals(((HashMap)localObject).get("stat"))) {
      throw new Throwable(paramString);
    }
    return (HashMap<String, Object>)localObject;
  }
  
  public String getAuthorizeUrl()
  {
    Object localObject2;
    int j;
    int i;
    try
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(new KVPair("oauth_callback", getRedirectUri()));
      this.c.a(null, null);
      localObject2 = this.c.b("http://www.flickr.com/services/oauth/request_token", (ArrayList)localObject1);
      localObject3 = this.c.a((ArrayList)localObject2);
      ((ArrayList)localObject1).addAll((Collection)localObject2);
      localObject1 = this.d.a("http://www.flickr.com/services/oauth/request_token", (ArrayList)localObject1, (ArrayList)localObject3, null, "/oauth/request_token", c());
      if (localObject1 == null) {
        return null;
      }
      localObject2 = ((String)localObject1).split("&");
      localObject1 = new HashMap();
      j = localObject2.length;
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      d.a().w(localThrowable);
    }
    Object localObject3 = ((String)localObject3).split("=");
    if (localObject3.length >= 2)
    {
      ((HashMap)localObject1).put(localObject3[0], localObject3[1]);
      break label247;
      label157:
      return null;
    }
    label247:
    label252:
    for (;;)
    {
      if (!localThrowable.containsKey("oauth_token")) {
        break label157;
      }
      localObject2 = (String)localThrowable.get("oauth_token");
      String str = (String)localThrowable.get("oauth_token_secret");
      this.c.a((String)localObject2, str);
      ShareSDK.logApiEvent("/oauth/authorize", c());
      str = "http://www.flickr.com/services/oauth/authorize?oauth_token=" + (String)localObject2;
      return str;
      for (;;)
      {
        if (i >= j) {
          break label252;
        }
        localObject3 = localObject2[i];
        if (localObject3 != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public cn.sharesdk.framework.authorize.b getAuthorizeWebviewClient(g paramg)
  {
    return new c(paramg);
  }
  
  public String getRedirectUri()
  {
    return this.c.a().e;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\flickr\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */