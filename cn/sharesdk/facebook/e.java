package cn.sharesdk.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.a.a;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class e
  extends cn.sharesdk.framework.e
{
  private static final String[] b = { "user_about_me", "user_birthday", "user_photos", "publish_actions", "user_friends" };
  private static e c;
  private String d;
  private String e;
  private long f;
  private String g;
  private a h = a.a();
  private String[] i;
  private String j;
  
  private e(Platform paramPlatform)
  {
    super(paramPlatform);
  }
  
  public static e a(Platform paramPlatform)
  {
    if (c == null) {
      c = new e(paramPlatform);
    }
    return c;
  }
  
  public HashMap<String, Object> a(int paramInt1, int paramInt2, String paramString)
  {
    String str1 = "me";
    if (paramString != null) {
      str1 = paramString;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("access_token", this.e));
    localArrayList.add(new KVPair("format", "json"));
    localArrayList.add(new KVPair("limit", String.valueOf(paramInt1)));
    localArrayList.add(new KVPair("offset", String.valueOf(paramInt2)));
    localArrayList.add(new KVPair("fields", "id,name,first_name,middle_name,last_name,gender,locale,languages,link,age_range,third_party_id,installed,timezone,updated_time,verified,bio,birthday,cover,currency,devices,education,email,hometown,interested_in,location,political,payment_pricepoints,favorite_athletes,favorite_teams,picture,quotes,relationship_status,religion,security_settings,significant_other,video_upload_limits,website,work"));
    String str2 = "/friends";
    if (!TextUtils.isEmpty(paramString)) {
      str2 = "/taggable_friends";
    }
    paramString = "https://graph.facebook.com/v2.5/" + str1 + str2;
    paramString = this.h.a(paramString, localArrayList, "friends", c());
    if ((paramString != null) && (paramString.length() > 0)) {
      return new Hashon().fromJson(paramString);
    }
    return null;
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (paramString2 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        localArrayList.add(new KVPair((String)localEntry.getKey(), String.valueOf(localEntry.getValue())));
      }
    }
    localArrayList.add(new KVPair("access_token", this.e));
    localArrayList.add(new KVPair("format", "json"));
    if ((paramHashMap1 != null) && (paramHashMap1.size() > 0))
    {
      paramHashMap1 = paramHashMap1.entrySet().iterator();
      for (paramHashMap = null; paramHashMap1.hasNext(); paramHashMap = new KVPair((String)paramHashMap.getKey(), paramHashMap.getValue())) {
        paramHashMap = (Map.Entry)paramHashMap1.next();
      }
    }
    for (;;)
    {
      if ("GET".equals(paramString2.toUpperCase())) {
        paramString1 = this.h.httpGet(paramString1, localArrayList, null, null);
      }
      while ((paramString1 != null) && (paramString1.length() > 0))
      {
        return new Hashon().fromJson(paramString1);
        if ("POST".equals(paramString2.toUpperCase())) {
          paramString1 = this.h.httpPost(paramString1, localArrayList, paramHashMap, null, null);
        } else {
          paramString1 = null;
        }
      }
      break;
      paramHashMap = null;
    }
  }
  
  public void a(AuthorizeListener paramAuthorizeListener, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b(paramAuthorizeListener);
      return;
    }
    a(new f(this, paramAuthorizeListener));
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.e = paramString1;
    if ((paramString2 != null) && (!paramString2.equals("0"))) {}
    try
    {
      this.f = (System.currentTimeMillis() + R.parseInt(paramString2) * 1000);
      return;
    }
    catch (Throwable paramString1)
    {
      d.a().w(paramString1);
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.i = paramArrayOfString;
  }
  
  public boolean a()
  {
    return (this.e != null) && ((this.f == 0L) || (System.currentTimeMillis() < this.f));
  }
  
  public HashMap<String, Object> b(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("access_token", this.e));
    localArrayList.add(new KVPair("format", "json"));
    localArrayList.add(new KVPair("message", paramString));
    paramString = this.h.b("https://graph.facebook.com/v2.5/me/feed", localArrayList, "/v2.5/me/feed", c());
    if ((paramString != null) && (paramString.length() > 0)) {
      return new Hashon().fromJson(paramString);
    }
    return null;
  }
  
  public HashMap<String, Object> b(String paramString1, String paramString2)
  {
    Object localObject = null;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("access_token", this.e));
    localArrayList.add(new KVPair("format", "json"));
    localArrayList.add(new KVPair("caption", paramString1));
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("http"))) {
      localArrayList.add(new KVPair("url", paramString2));
    }
    for (paramString1 = null;; paramString1 = new KVPair("source", paramString2))
    {
      paramString2 = this.h.a("https://graph.facebook.com/v2.5/me/photos", localArrayList, paramString1, "/v2.5/me/photos", c());
      paramString1 = (String)localObject;
      if (paramString2 != null)
      {
        paramString1 = (String)localObject;
        if (paramString2.length() > 0) {
          paramString1 = new Hashon().fromJson(paramString2);
        }
      }
      return paramString1;
    }
  }
  
  public boolean b()
  {
    Object localObject = new Intent();
    ((Intent)localObject).setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
    ((Intent)localObject).putExtra("client_id", this.g);
    if ((this.i != null) && (this.i.length > 0)) {
      ((Intent)localObject).putExtra("scope", TextUtils.join(",", this.i));
    }
    localObject = getPlatform().getContext().getPackageManager().resolveActivity((Intent)localObject, 0);
    if (localObject == null) {}
    for (;;)
    {
      return false;
      localObject = ((ResolveInfo)localObject).activityInfo.packageName;
      try
      {
        localObject = getPlatform().getContext().getPackageManager().getPackageInfo((String)localObject, 64).signatures;
        int m = localObject.length;
        int k = 0;
        while (k < m)
        {
          boolean bool = "30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2".equals(localObject[k].toCharsString());
          if (bool) {
            return true;
          }
          k += 1;
        }
        return false;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    }
  }
  
  public HashMap<String, Object> c(String paramString)
  {
    String str = "/me";
    if (paramString != null) {
      str = "/" + paramString;
    }
    paramString = new ArrayList();
    paramString.add(new KVPair("access_token", this.e));
    paramString.add(new KVPair("format", "json"));
    paramString.add(new KVPair("fields", "id,name,first_name,middle_name,last_name,gender,locale,languages,link,age_range,third_party_id,installed,timezone,updated_time,verified,bio,birthday,cover,currency,devices,education,email,hometown,interested_in,location,political,payment_pricepoints,favorite_athletes,favorite_teams,picture,quotes,relationship_status,religion,security_settings,significant_other,video_upload_limits,website,work,token_for_business"));
    paramString = this.h.a("https://graph.facebook.com/v2.5" + str, paramString, "get_user_info", c());
    d.a().i("facebook helper getUser", new Object[0]);
    if ((paramString != null) && (paramString.length() > 0)) {
      return new Hashon().fromJson(paramString);
    }
    return null;
  }
  
  public void d(String paramString)
  {
    this.j = paramString;
  }
  
  public String getAuthorizeUrl()
  {
    int k = 0;
    Bundle localBundle = new Bundle();
    localBundle.putString("display", "touch");
    localBundle.putString("redirect_uri", this.j);
    localBundle.putString("type", "user_agent");
    if (this.i == null) {}
    StringBuilder localStringBuilder;
    for (String[] arrayOfString = b;; arrayOfString = this.i)
    {
      localStringBuilder = new StringBuilder();
      int n = arrayOfString.length;
      int m = 0;
      while (k < n)
      {
        String str = arrayOfString[k];
        if (m > 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(str);
        m += 1;
        k += 1;
      }
    }
    localBundle.putString("scope", localStringBuilder.toString());
    localBundle.putString("client_id", this.g);
    localBundle.putString("response_type", "code");
    this.d = ("https://www.facebook.com/dialog/oauth" + "?" + R.encodeUrl(localBundle));
    ShareSDK.logApiEvent("/dialog/oauth", c());
    return this.d;
  }
  
  public cn.sharesdk.framework.authorize.b getAuthorizeWebviewClient(g paramg)
  {
    return new c(paramg);
  }
  
  public String getRedirectUri()
  {
    return this.j;
  }
  
  public cn.sharesdk.framework.authorize.f getSSOProcessor(cn.sharesdk.framework.authorize.e parame)
  {
    b localb = new b(parame);
    localb.a(32525);
    String str = this.g;
    if (this.i == null) {}
    for (parame = b;; parame = this.i)
    {
      localb.a(str, parame);
      return localb;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\facebook\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */