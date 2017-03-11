package cn.sharesdk.instagram;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.a.a;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.b;
import cn.sharesdk.framework.authorize.g;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

public class e
  extends cn.sharesdk.framework.e
{
  private static e b;
  private String c;
  private String d;
  private String e;
  private String[] f;
  private String g;
  
  private e(Platform paramPlatform)
  {
    super(paramPlatform);
  }
  
  public static e a(Platform paramPlatform)
  {
    if (b == null) {
      b = new e(paramPlatform);
    }
    return b;
  }
  
  public String a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("client_id", this.c));
    localArrayList.add(new KVPair("client_secret", this.d));
    localArrayList.add(new KVPair("grant_type", "authorization_code"));
    localArrayList.add(new KVPair("redirect_uri", this.e));
    localArrayList.add(new KVPair("code", paramString));
    return a.a().b("https://api.instagram.com/oauth/access_token", localArrayList, "/oauth/authorize", c());
  }
  
  public void a(AuthorizeListener paramAuthorizeListener)
  {
    b(paramAuthorizeListener);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, PlatformActionListener paramPlatformActionListener)
  {
    f localf = new f();
    localf.a(this.a, paramPlatformActionListener);
    localf.a(paramString1, paramString2);
    localf.a(paramString3);
    localf.show(this.a.getContext(), null);
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.f = paramArrayOfString;
  }
  
  public boolean a()
  {
    boolean bool = false;
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setPackage("com.instagram.android");
    localIntent.setType("image/*");
    if (this.a.getContext().getPackageManager().resolveActivity(localIntent, 0) != null) {
      bool = true;
    }
    return bool;
  }
  
  public void b(String paramString)
  {
    this.g = paramString;
  }
  
  public HashMap<String, Object> c(String paramString)
  {
    paramString = "https://api.instagram.com/v1/users/" + paramString + "/";
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new KVPair("access_token", this.g));
    paramString = a.a().a(paramString, (ArrayList)localObject, "/v1/users", c());
    if ((paramString == null) || (paramString.length() <= 0)) {
      throw new Throwable("response is empty");
    }
    localObject = new Hashon().fromJson(paramString);
    if ((localObject == null) || (((HashMap)localObject).size() <= 0)) {
      throw new Throwable("response is empty");
    }
    HashMap localHashMap = (HashMap)((HashMap)localObject).get("meta");
    if ((localHashMap == null) || (localHashMap.size() <= 0)) {
      throw new Throwable(paramString);
    }
    if (200 != ((Integer)localHashMap.get("code")).intValue()) {
      throw new Throwable(paramString);
    }
    localHashMap = (HashMap)((HashMap)localObject).get("data");
    if ((localHashMap == null) || (localHashMap.size() <= 0)) {
      throw new Throwable(paramString);
    }
    return (HashMap<String, Object>)localObject;
  }
  
  public HashMap<String, Object> d(String paramString)
  {
    paramString = "https://api.instagram.com/v1/users/" + paramString + "/follows";
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new KVPair("access_token", this.g));
    paramString = a.a().a(paramString, (ArrayList)localObject, "/v1/users/follows", c());
    if ((paramString == null) || (paramString.length() <= 0)) {
      throw new Throwable("response is empty");
    }
    localObject = new Hashon().fromJson(paramString);
    if ((localObject == null) || (((HashMap)localObject).size() <= 0)) {
      throw new Throwable("response is empty");
    }
    HashMap localHashMap = (HashMap)((HashMap)localObject).get("meta");
    if ((localHashMap == null) || (localHashMap.size() <= 0)) {
      throw new Throwable(paramString);
    }
    if (200 != ((Integer)localHashMap.get("code")).intValue()) {
      throw new Throwable(paramString);
    }
    return (HashMap<String, Object>)localObject;
  }
  
  public HashMap<String, Object> e(String paramString)
  {
    paramString = "https://api.instagram.com/v1/users/" + paramString + "/followed-by";
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(new KVPair("access_token", this.g));
    paramString = a.a().a(paramString, (ArrayList)localObject, "/v1/users/followed-by", c());
    if ((paramString == null) || (paramString.length() <= 0)) {
      throw new Throwable("response is empty");
    }
    localObject = new Hashon().fromJson(paramString);
    if ((localObject == null) || (((HashMap)localObject).size() <= 0)) {
      throw new Throwable("response is empty");
    }
    HashMap localHashMap = (HashMap)((HashMap)localObject).get("meta");
    if ((localHashMap == null) || (localHashMap.size() <= 0)) {
      throw new Throwable(paramString);
    }
    if (200 != ((Integer)localHashMap.get("code")).intValue()) {
      throw new Throwable(paramString);
    }
    return (HashMap<String, Object>)localObject;
  }
  
  public String getAuthorizeUrl()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://instagram.com/oauth/authorize/?");
    localStringBuilder.append("client_id=").append(this.c);
    localStringBuilder.append("&redirect_uri=").append(getRedirectUri());
    localStringBuilder.append("&response_type=code");
    if ((this.f != null) && (this.f.length > 0)) {
      localStringBuilder.append("&scope=").append(TextUtils.join("+", this.f));
    }
    ShareSDK.logApiEvent("/oauth/authorize", c());
    return localStringBuilder.toString();
  }
  
  public b getAuthorizeWebviewClient(g paramg)
  {
    return new c(paramg);
  }
  
  public String getRedirectUri()
  {
    return this.e;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\instagram\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */