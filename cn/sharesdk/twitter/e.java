package cn.sharesdk.twitter;

import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.utils.a.b;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class e
  extends cn.sharesdk.framework.e
{
  private static e b;
  private cn.sharesdk.framework.utils.a c = new cn.sharesdk.framework.utils.a();
  private cn.sharesdk.framework.a.a d = cn.sharesdk.framework.a.a.a();
  
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
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new KVPair("oauth_verifier", paramString));
      paramString = this.c.a("https://api.twitter.com/oauth/access_token", localArrayList);
      paramString = this.c.a(paramString);
      paramString = this.d.a("https://api.twitter.com/oauth/access_token", localArrayList, null, paramString, "/oauth/access_token", c());
      return paramString;
    }
    catch (Throwable paramString)
    {
      d.a().w(paramString);
    }
    return null;
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (paramString2 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        localObject = (Map.Entry)paramHashMap.next();
        localArrayList.add(new KVPair((String)((Map.Entry)localObject).getKey(), String.valueOf(((Map.Entry)localObject).getValue())));
      }
    }
    if ((paramHashMap1 != null) && (paramHashMap1.size() > 0))
    {
      localObject = paramHashMap1.entrySet().iterator();
      for (paramHashMap = null; ((Iterator)localObject).hasNext(); paramHashMap = new KVPair((String)paramHashMap.getKey(), paramHashMap.getValue())) {
        paramHashMap = (Map.Entry)((Iterator)localObject).next();
      }
    }
    for (;;)
    {
      if ("GET".equals(paramString2.toUpperCase()))
      {
        paramString2 = this.c.b(paramString1, localArrayList);
        paramString2 = this.c.a(paramString2);
        paramString1 = this.d.httpGet(paramString1, localArrayList, paramString2, null);
      }
      while ((paramString1 != null) && (paramString1.length() > 0))
      {
        return new Hashon().fromJson(paramString1);
        if ("POST".equals(paramString2.toUpperCase()))
        {
          if ((paramHashMap1 == null) || (paramHashMap1.size() <= 0))
          {
            paramString2 = this.c.a(paramString1, localArrayList);
            paramString2 = this.c.a(paramString2);
          }
          for (;;)
          {
            paramString1 = this.d.httpPost(paramString1, localArrayList, paramHashMap, paramString2, null);
            break;
            paramString2 = new ArrayList();
            paramString2 = this.c.a(paramString1, paramString2);
            paramString2 = this.c.a(paramString2);
            paramString2.remove(1);
          }
        }
        paramString1 = null;
      }
      break;
      paramHashMap = null;
    }
  }
  
  public HashMap<String, Object> a(String paramString, String[] paramArrayOfString)
  {
    int j = 0;
    ArrayList localArrayList1 = new ArrayList();
    Object localObject = this.c.a("https://upload.twitter.com/1.1/media/upload.json", localArrayList1);
    ArrayList localArrayList2 = this.c.a((ArrayList)localObject);
    localArrayList2.remove(1);
    StringBuilder localStringBuilder = new StringBuilder();
    ArrayList localArrayList3 = new ArrayList();
    int i = 0;
    for (;;)
    {
      if ((i >= paramArrayOfString.length) || ((localArrayList3 != null) && (localArrayList3.size() > 3)))
      {
        localStringBuilder.setLength(0);
        i = j;
      }
      while (i < localArrayList3.size())
      {
        if (((HashMap)localArrayList3.get(i)).containsKey("image"))
        {
          if (localStringBuilder.length() > 0) {
            localStringBuilder.append(',');
          }
          localStringBuilder.append(String.valueOf(((HashMap)localArrayList3.get(i)).get("media_id")));
        }
        i += 1;
        continue;
        localObject = paramArrayOfString[i];
        try
        {
          if (((String)localObject).startsWith("http")) {
            localObject = BitmapHelper.downloadBitmap(this.a.getContext(), (String)localObject);
          }
          boolean bool;
          do
          {
            localObject = new KVPair("media", localObject);
            localObject = this.d.a("https://upload.twitter.com/1.1/media/upload.json", localArrayList1, (KVPair)localObject, localArrayList2, "/1.1/media/upload.json", c());
            localStringBuilder.append(paramArrayOfString[i]).append(": ").append((String)localObject).append("\n");
            if ((localObject == null) || (((String)localObject).length() <= 0)) {
              break;
            }
            localArrayList3.add(new Hashon().fromJson((String)localObject));
            break;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              break;
            }
            bool = new File((String)localObject).exists();
          } while (bool);
        }
        catch (Exception localException)
        {
          d.a().w(localStringBuilder.toString(), new Object[0]);
          localException.printStackTrace();
        }
      }
      return d(paramString, localStringBuilder.toString());
      i += 1;
    }
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
    Object localObject1 = null;
    Object localObject2 = new ArrayList();
    l1 = 0L;
    try
    {
      long l2 = R.parseLong(paramString);
      l1 = l2;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString = null;
        continue;
        paramString = String.valueOf(l1);
      }
    }
    if (paramString == null)
    {
      paramString = this.a.getDb().getUserId();
      ((ArrayList)localObject2).add(new KVPair("user_id", paramString));
      paramString = this.c.b("https://api.twitter.com/1.1/users/show.json", (ArrayList)localObject2);
      paramString = this.c.a(paramString);
      localObject2 = this.d.a("https://api.twitter.com/1.1/users/show.json", (ArrayList)localObject2, paramString, null, "/1.1/users/show.json", c());
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
  }
  
  public HashMap<String, Object> b(String paramString1, String paramString2)
  {
    Object localObject = null;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("nextCursor", paramString2));
    int i = 1;
    try
    {
      R.parseLong(paramString1);
      if (i != 0)
      {
        localArrayList.add(new KVPair("user_id", paramString1));
        paramString1 = this.c.b("https://api.twitter.com/1.1/friends/list.json", localArrayList);
        paramString1 = this.c.a(paramString1);
        paramString2 = this.d.a("https://api.twitter.com/1.1/friends/list.json", localArrayList, paramString1, null, "/1.1/friends/list.json", c());
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
    catch (Throwable paramString2)
    {
      for (;;)
      {
        i = 0;
        continue;
        localArrayList.add(new KVPair("screen_name", paramString1));
      }
    }
  }
  
  public HashMap<String, Object> c(String paramString)
  {
    return d(paramString, null);
  }
  
  public HashMap<String, Object> c(String paramString1, String paramString2)
  {
    Object localObject = null;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("nextCursor", paramString2));
    int i = 1;
    try
    {
      R.parseLong(paramString1);
      if (i != 0)
      {
        localArrayList.add(new KVPair("user_id", paramString1));
        paramString1 = this.c.b("https://api.twitter.com/1.1/followers/list.json", localArrayList);
        paramString1 = this.c.a(paramString1);
        paramString2 = this.d.a("https://api.twitter.com/1.1/followers/list.json", localArrayList, paramString1, null, "/1.1/followers/list.json", c());
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
    catch (Throwable paramString2)
    {
      for (;;)
      {
        i = 0;
        continue;
        localArrayList.add(new KVPair("screen_name", paramString1));
      }
    }
  }
  
  public HashMap<String, Object> d(String paramString1, String paramString2)
  {
    Object localObject = null;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new KVPair("status", paramString1));
    if (!TextUtils.isEmpty(paramString2)) {
      localArrayList.add(new KVPair("media_ids", paramString2));
    }
    paramString1 = this.c.a("https://api.twitter.com/1.1/statuses/update.json", localArrayList);
    paramString1 = this.c.a(paramString1);
    paramString2 = this.d.a("https://api.twitter.com/1.1/statuses/update.json", localArrayList, null, paramString1, "/1.1/statuses/update.json", c());
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
  
  public HashMap<String, Object> e(String paramString1, String paramString2)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = this.c.a("https://api.twitter.com/1.1/statuses/update_with_media.json", localArrayList1);
    localArrayList2 = this.c.a(localArrayList2);
    localArrayList2.remove(1);
    localArrayList1.add(new KVPair("status", paramString1));
    paramString1 = new KVPair("media[]", paramString2);
    paramString1 = this.d.a("https://api.twitter.com/1.1/statuses/update_with_media.json", localArrayList1, paramString1, localArrayList2, "/1.1/statuses/update_with_media.json", c());
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      return new Hashon().fromJson(paramString1);
    }
    return null;
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
      a(null, null);
      localObject2 = this.c.a("https://api.twitter.com/oauth/request_token", (ArrayList)localObject1);
      localObject2 = this.c.a((ArrayList)localObject2);
      localObject1 = this.d.a("https://api.twitter.com/oauth/request_token", (ArrayList)localObject1, null, (ArrayList)localObject2, "/oauth/request_token", c());
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
    String[] arrayOfString = arrayOfString.split("=");
    if (arrayOfString.length >= 2)
    {
      ((HashMap)localObject1).put(arrayOfString[0], arrayOfString[1]);
      break label243;
      label153:
      return null;
    }
    label243:
    label248:
    for (;;)
    {
      if (!localThrowable.containsKey("oauth_token")) {
        break label153;
      }
      localObject2 = (String)localThrowable.get("oauth_token");
      a((String)localObject2, (String)localThrowable.get("oauth_token_secret"));
      ShareSDK.logApiEvent("/oauth/authorize", c());
      String str = "https://api.twitter.com/oauth/authorize?oauth_token=" + (String)localObject2;
      return str;
      for (;;)
      {
        if (i >= j) {
          break label248;
        }
        arrayOfString = localObject2[i];
        if (arrayOfString != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public cn.sharesdk.framework.authorize.b getAuthorizeWebviewClient(g paramg)
  {
    return new b(paramg);
  }
  
  public String getRedirectUri()
  {
    return this.c.a().e;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\twitter\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */