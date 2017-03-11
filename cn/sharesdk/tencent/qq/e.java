package cn.sharesdk.tencent.qq;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.a.a;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.b;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class e
  extends cn.sharesdk.framework.e
{
  private static final String[] b = { "get_user_info", "get_simple_userinfo", "get_user_profile", "get_app_friends", "add_share", "list_album", "upload_pic", "add_album", "set_user_face", "get_vip_info", "get_vip_rich_info", "get_intimate_friends_weibo", "match_nick_tips_weibo", "add_t", "add_pic_t" };
  private static e c;
  private String d;
  private String[] e;
  private String f;
  private String g;
  
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
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, PlatformActionListener paramPlatformActionListener)
  {
    paramString6 = paramString5;
    if (paramString5 == null)
    {
      paramString6 = paramString5;
      if (paramString4 != null)
      {
        paramString6 = paramString5;
        if (new File(paramString4).exists()) {
          paramString6 = ((QQ)this.a).uploadImageToFileServer(paramString4);
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString5 = new StringBuilder();
        paramString5.append("http://openmobile.qq.com/api/check?");
        paramString5.append("page=shareindex.html&");
        paramString5.append("style=9&");
        paramString5.append("action=shareToQQ&");
        paramString5.append("sdkv=2.2.1&");
        paramString5.append("sdkp=a&");
        paramString5.append("appId=").append(this.d).append("&");
        paramString4 = DeviceHelper.getInstance(this.a.getContext());
        paramString5.append("status_os=").append(Data.urlEncode(paramString4.getOSVersionName(), "utf-8")).append("&");
        paramString5.append("status_machine=").append(Data.urlEncode(paramString4.getModel(), "utf-8")).append("&");
        paramString5.append("status_version=").append(Data.urlEncode(String.valueOf(paramString4.getOSVersionInt()), "utf-8")).append("&");
        paramString4 = paramString4.getAppName();
        if (!TextUtils.isEmpty(paramString4)) {
          paramString5.append("site=").append(Data.urlEncode(paramString4, "utf-8")).append("&");
        }
        if (!TextUtils.isEmpty(paramString1))
        {
          if (paramString1.length() > 40)
          {
            paramString1 = paramString1.substring(40) + "...";
            paramString4 = paramString1;
            if (paramString1.length() > 80) {
              paramString4 = paramString1.substring(80) + "...";
            }
            paramString5.append("title=").append(Data.urlEncode(paramString4, "utf-8")).append("&");
          }
        }
        else
        {
          if (!TextUtils.isEmpty(paramString3)) {
            paramString5.append("summary=").append(Data.urlEncode(paramString3, "utf-8")).append("&");
          }
          if (!TextUtils.isEmpty(paramString2)) {
            paramString5.append("targeturl=").append(Data.urlEncode(paramString2, "utf-8")).append("&");
          }
          if (!TextUtils.isEmpty(paramString6)) {
            paramString5.append("imageUrl=").append(Data.urlEncode(paramString6, "utf-8")).append("&");
          }
          paramString5.append("type=1");
          paramString1 = new k();
          paramString1.a(paramString5.toString());
          paramString1.a(paramPlatformActionListener);
          paramString1.b(this.d);
          paramString1.show(this.a.getContext(), null);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        if (paramPlatformActionListener != null)
        {
          paramPlatformActionListener.onError(this.a, 9, paramString1);
          return;
        }
      }
    }
  }
  
  private String b()
  {
    int i = 0;
    if (this.e == null) {}
    StringBuilder localStringBuilder;
    for (String[] arrayOfString = b;; arrayOfString = this.e)
    {
      localStringBuilder = new StringBuilder();
      int k = arrayOfString.length;
      int j = 0;
      while (i < k)
      {
        String str = arrayOfString[i];
        if (j > 0) {
          localStringBuilder.append(',');
        }
        localStringBuilder.append(str);
        j += 1;
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  private void b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, PlatformActionListener paramPlatformActionListener)
  {
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramString4)) {
          continue;
        }
        if (TextUtils.isEmpty(paramString5)) {
          break label333;
        }
      }
      catch (Throwable paramString1)
      {
        ArrayList localArrayList;
        if (paramPlatformActionListener == null) {
          break label332;
        }
        paramPlatformActionListener.onError(this.a, 9, paramString1);
        return;
        i = 1;
        if (i != 0) {
          break label339;
        }
        paramString1 = "/t/add_t";
        continue;
      }
      paramString6 = "https://graph.qq.com" + paramString1;
      localArrayList = new ArrayList();
      localArrayList.add(new KVPair("oauth_consumer_key", this.d));
      localArrayList.add(new KVPair("access_token", this.g));
      localArrayList.add(new KVPair("openid", this.f));
      localArrayList.add(new KVPair("format", "json"));
      localArrayList.add(new KVPair("content", paramString3));
      if (i != 0)
      {
        paramString2 = paramString4;
        if (TextUtils.isEmpty(paramString4)) {
          paramString2 = BitmapHelper.downloadBitmap(this.a.getContext(), paramString5);
        }
        paramString2 = new KVPair("pic", paramString2);
        paramString1 = a.a().a(paramString6, localArrayList, paramString2, paramString1, c());
        if ((paramString1 == null) || (paramString1.length() <= 0) || (paramPlatformActionListener == null)) {
          break label332;
        }
        paramString2 = new Hashon().fromJson(paramString1);
        if (((Integer)paramString2.get("ret")).intValue() != 0) {
          paramPlatformActionListener.onError(this.a, 9, new Exception(paramString1));
        }
      }
      else
      {
        paramString1 = a.a().b(paramString6, localArrayList, paramString1, c());
        continue;
      }
      paramPlatformActionListener.onComplete(this.a, 9, paramString2);
      return;
      label332:
      return;
      label333:
      int i = 0;
      continue;
      label339:
      paramString1 = "/t/add_pic_t";
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
    this.d = paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, PlatformActionListener paramPlatformActionListener, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      b(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramPlatformActionListener);
      return;
    }
    if ((paramBoolean1) && (a()))
    {
      Object localObject1 = paramString4;
      if (!TextUtils.isEmpty(paramString4))
      {
        Object localObject2 = new File(paramString4);
        localObject1 = paramString4;
        if (((File)localObject2).exists())
        {
          localObject1 = paramString4;
          if (paramString4.startsWith("/data/"))
          {
            localObject2 = new File(R.getCachePath(this.a.getContext(), "images"), System.currentTimeMillis() + ((File)localObject2).getName()).getAbsolutePath();
            localObject1 = paramString4;
            if (R.copyFile(paramString4, (String)localObject2)) {
              localObject1 = localObject2;
            }
          }
        }
      }
      paramString4 = new Intent();
      paramString4.putExtra("title", paramString1);
      paramString4.putExtra("titleUrl", paramString2);
      paramString4.putExtra("summary", paramString3);
      paramString4.putExtra("imagePath", (String)localObject1);
      paramString4.putExtra("imageUrl", paramString5);
      paramString4.putExtra("musicUrl", paramString6);
      paramString4.putExtra("appId", this.d);
      paramString1 = new i();
      paramString1.a(this.a, paramPlatformActionListener);
      paramString1.a(this.d);
      paramString1.show(this.a.getContext(), paramString4);
      return;
    }
    a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramPlatformActionListener);
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.e = paramArrayOfString;
  }
  
  public boolean a()
  {
    List localList = this.a.getContext().getPackageManager().getInstalledPackages(0);
    ArrayList localArrayList = new ArrayList();
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        localArrayList.add(((PackageInfo)localList.get(i)).packageName);
        i += 1;
      }
    }
    return (localArrayList.contains("com.tencent.mobileqq")) || (localArrayList.contains("com.tencent.mobileqqi")) || (localArrayList.contains("com.tencent.qqlite"));
  }
  
  public void b(String paramString)
  {
    this.f = paramString;
  }
  
  public HashMap<String, Object> c(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(new KVPair("access_token", paramString));
    paramString = new ArrayList();
    paramString.add(new KVPair("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
    paramString = a.a().a("https://graph.qq.com/oauth2.0/me", (ArrayList)localObject1, paramString, null, "/oauth2.0/me", c());
    localObject1 = paramString;
    if (paramString.startsWith("callback"))
    {
      for (localObject1 = paramString;; localObject1 = ((String)localObject1).substring(1))
      {
        paramString = (String)localObject1;
        if (((String)localObject1).startsWith("{")) {
          break;
        }
        paramString = (String)localObject1;
        if (((String)localObject1).length() <= 0) {
          break;
        }
      }
      for (;;)
      {
        localObject1 = paramString;
        if (paramString.endsWith("}")) {
          break;
        }
        localObject1 = paramString;
        if (paramString.length() <= 0) {
          break;
        }
        paramString = paramString.substring(0, paramString.length() - 1);
      }
    }
    paramString = (String)localObject2;
    if (localObject1 != null)
    {
      paramString = (String)localObject2;
      if (((String)localObject1).length() > 0) {
        paramString = new Hashon().fromJson((String)localObject1);
      }
    }
    return paramString;
  }
  
  public void d(String paramString)
  {
    this.g = paramString;
  }
  
  public HashMap<String, Object> e(String paramString)
  {
    Object localObject1 = null;
    paramString = new ArrayList();
    paramString.add(new KVPair("access_token", this.g));
    paramString.add(new KVPair("oauth_consumer_key", this.d));
    paramString.add(new KVPair("openid", this.f));
    Object localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(new KVPair("User-Agent", System.getProperties().getProperty("http.agent") + " ArzenAndroidSDK"));
    localObject2 = a.a().a("https://graph.qq.com/user/get_simple_userinfo", paramString, (ArrayList)localObject2, null, "/user/get_simple_userinfo", c());
    paramString = (String)localObject1;
    if (localObject2 != null)
    {
      paramString = (String)localObject1;
      if (((String)localObject2).length() > 0) {
        paramString = new Hashon().fromJson((String)localObject2);
      }
    }
    return paramString;
  }
  
  public String getAuthorizeUrl()
  {
    ShareSDK.logApiEvent("/oauth2.0/authorize", c());
    String str3 = b();
    String str1 = getRedirectUri();
    try
    {
      str1 = Data.urlEncode(str1, "utf-8");
      return "https://graph.qq.com/oauth2.0/m_authorize?response_type=token&client_id=" + this.d + "&" + "redirect_uri=" + str1 + "&" + "display=mobile&" + "scope=" + str3;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        d.a().w(localThrowable);
        String str2 = getRedirectUri();
      }
    }
  }
  
  public b getAuthorizeWebviewClient(cn.sharesdk.framework.authorize.g paramg)
  {
    return new c(paramg);
  }
  
  public String getRedirectUri()
  {
    return "auth://tauth.qq.com/";
  }
  
  public cn.sharesdk.framework.authorize.f getSSOProcessor(cn.sharesdk.framework.authorize.e parame)
  {
    parame = new g(parame);
    parame.a(5656);
    parame.a(this.d, b());
    return parame;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qq\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */