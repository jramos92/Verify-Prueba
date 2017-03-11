package cn.sharesdk.twitter;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.statistics.b.f.a;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Twitter
  extends Platform
{
  public static final String NAME = Twitter.class.getSimpleName();
  private String a;
  private String b;
  private String c;
  
  public Twitter(Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    if (isAuthValid())
    {
      e locale = e.a(this);
      locale.a(this.a, this.b, this.c);
      String str1 = this.db.getToken();
      String str2 = this.db.getTokenSecret();
      if ((str1 != null) && (str2 != null))
      {
        locale.a(str1, str2);
        return true;
      }
    }
    innerAuthorize(paramInt, paramObject);
    return false;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    paramArrayOfString = e.a(this);
    paramArrayOfString.a(this.a, this.b, this.c);
    paramArrayOfString.a(new a(this, paramArrayOfString));
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    e locale = e.a(this);
    try
    {
      paramString1 = locale.a(paramString1, paramString2, paramHashMap, paramHashMap1);
      if ((paramString1 == null) || (paramString1.size() <= 0))
      {
        if (this.listener != null) {
          this.listener.onError(this, paramInt, new Throwable("response is null"));
        }
      }
      else if ((paramString1.containsKey("error_code")) || (paramString1.containsKey("error")))
      {
        if (this.listener == null) {
          return;
        }
        paramString1 = new Hashon().fromHashMap(paramString1);
        this.listener.onError(this, paramInt, new Throwable(paramString1));
      }
    }
    catch (Throwable paramString1)
    {
      if (this.listener != null)
      {
        this.listener.onError(this, paramInt, paramString1);
        return;
        if (this.listener != null) {
          this.listener.onComplete(this, paramInt, paramString1);
        }
      }
    }
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    e locale = e.a(this);
    HashMap localHashMap = null;
    String str1 = getShortLintk(paramShareParams.getText(), false);
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            localObject = paramShareParams.getImageArray();
            str2 = paramShareParams.getImagePath();
            str3 = paramShareParams.getImageUrl();
            if ((localObject != null) && (localObject.length > 0))
            {
              localHashMap = locale.a(str1, (String[])localObject);
              if (localHashMap != null) {
                break;
              }
              if (this.listener != null) {
                this.listener.onError(this, 8, new Throwable("response is null"));
              }
              return;
            }
          }
          catch (Throwable paramShareParams)
          {
            Object localObject;
            String str2;
            String str3;
            if (this.listener == null) {
              continue;
            }
            this.listener.onError(this, 9, paramShareParams);
            return;
          }
          if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
          {
            localHashMap = locale.e(str1, str2);
          }
          else if (!TextUtils.isEmpty(str3))
          {
            localObject = BitmapHelper.downloadBitmap(getContext(), str3);
            if (new File((String)localObject).exists()) {
              localHashMap = locale.e(str1, (String)localObject);
            }
          }
          else
          {
            localHashMap = locale.c(str1);
          }
        }
        if ((!localHashMap.containsKey("error_code")) && (!localHashMap.containsKey("error"))) {
          break;
        }
      } while (this.listener == null);
      paramShareParams = new Hashon().fromHashMap(localHashMap);
      this.listener.onError(this, 8, new Throwable(paramShareParams));
      return;
      localHashMap.put("ShareParams", paramShareParams);
    } while (this.listener == null);
    this.listener.onComplete(this, 9, localHashMap);
  }
  
  protected HashMap<String, Object> filterFriendshipInfo(int paramInt, HashMap<String, Object> paramHashMap)
  {
    HashMap localHashMap1 = new HashMap();
    switch (paramInt)
    {
    }
    String str;
    label105:
    ArrayList localArrayList;
    label143:
    do
    {
      do
      {
        do
        {
          return null;
          localHashMap1.put("type", "FOLLOWING");
          localHashMap1.put("snsplat", Integer.valueOf(getPlatformId()));
          localHashMap1.put("snsuid", this.db.getUserId());
          if (!paramHashMap.containsKey("next_cursor")) {
            break;
          }
          str = String.valueOf(paramHashMap.get("next_cursor"));
          paramHashMap = paramHashMap.get("users");
        } while (paramHashMap == null);
        localArrayList = new ArrayList();
        paramHashMap = (ArrayList)paramHashMap;
      } while (paramHashMap.size() <= 0);
      Iterator localIterator = paramHashMap.iterator();
      HashMap localHashMap2;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localHashMap2 = (HashMap)localIterator.next();
      } while (localHashMap2 == null);
      HashMap localHashMap3 = new HashMap();
      localHashMap3.put("snsuid", String.valueOf(localHashMap2.get("id")));
      localHashMap3.put("nickname", String.valueOf(localHashMap2.get("screen_name")));
      localHashMap3.put("icon", String.valueOf(localHashMap2.get("profile_image_url")));
      localHashMap3.put("gender", "2");
      localHashMap3.put("resume", String.valueOf(localHashMap2.get("description")));
      if ("true".equals(String.valueOf(localHashMap2.get("verified")))) {}
      for (paramHashMap = "1";; paramHashMap = "0")
      {
        localHashMap3.put("secretType", paramHashMap);
        localHashMap3.put("followerCount", String.valueOf(localHashMap2.get("followers_count")));
        localHashMap3.put("favouriteCount", String.valueOf(localHashMap2.get("friends_count")));
        localHashMap3.put("shareCount", String.valueOf(localHashMap2.get("statuses_count")));
        localHashMap3.put("snsregat", String.valueOf(R.dateToLong(String.valueOf(localHashMap2.get("created_at")))));
        localHashMap3.put("snsUserUrl", "https://twitter.com/" + localHashMap2.get("screen_name"));
        localArrayList.add(localHashMap3);
        break label143;
        localHashMap1.put("type", "FOLLOWERS");
        break;
        localHashMap1.put("type", "FRIENDS");
        break;
        str = null;
        break label105;
      }
    } while ((localArrayList == null) || (localArrayList.size() <= 0));
    paramHashMap = str + "_false";
    if ((TextUtils.isEmpty(str)) || ("0".equals(str))) {
      paramHashMap = "0_true";
    }
    localHashMap1.put("nextCursor", paramHashMap);
    localHashMap1.put("list", localArrayList);
    return localHashMap1;
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    f.a locala = new f.a();
    locala.b = paramShareParams.getText();
    if (paramHashMap != null)
    {
      paramShareParams = (HashMap)paramHashMap.get("entities");
      if (paramShareParams != null)
      {
        paramShareParams = (ArrayList)paramShareParams.get("media");
        if ((paramShareParams != null) && (paramShareParams.size() > 0) && ((HashMap)paramShareParams.get(0) != null)) {
          locala.d.add(String.valueOf(paramHashMap.get("media_url")));
        }
      }
      locala.a = String.valueOf(paramHashMap.get("id"));
      locala.g = paramHashMap;
    }
    return locala;
  }
  
  protected void follow(String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 6);
    }
  }
  
  protected HashMap<String, Object> getBilaterals(int paramInt1, int paramInt2, String paramString)
  {
    return null;
  }
  
  protected HashMap<String, Object> getFollowers(int paramInt1, int paramInt2, String paramString)
  {
    if (TextUtils.isEmpty(null)) {}
    for (String str1 = this.db.getUserId();; str1 = null)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = this.db.getUserName();
      }
      if (TextUtils.isEmpty(str2)) {}
      for (;;)
      {
        return null;
        e locale = e.a(this);
        str1 = paramString;
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            str1 = "0";
          }
          paramString = locale.c(str2, str1);
          if ((paramString != null) && (paramString.size() > 0) && (!paramString.containsKey("error_code")) && (!paramString.containsKey("error")))
          {
            paramString = filterFriendshipInfo(11, paramString);
            return paramString;
          }
        }
        catch (Throwable paramString)
        {
          d.a().w(paramString);
          return null;
        }
      }
    }
  }
  
  protected HashMap<String, Object> getFollowings(int paramInt1, int paramInt2, String paramString)
  {
    if (TextUtils.isEmpty(null)) {}
    for (String str1 = this.db.getUserId();; str1 = null)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = this.db.getUserName();
      }
      if (TextUtils.isEmpty(str2)) {}
      for (;;)
      {
        return null;
        e locale = e.a(this);
        str1 = paramString;
        try
        {
          if (TextUtils.isEmpty(paramString)) {
            str1 = "0";
          }
          paramString = locale.b(str2, str1);
          if ((paramString != null) && (paramString.size() > 0) && (!paramString.containsKey("error_code")) && (!paramString.containsKey("error")))
          {
            paramString = filterFriendshipInfo(2, paramString);
            return paramString;
          }
        }
        catch (Throwable paramString)
        {
          d.a().w(paramString);
          return null;
        }
      }
    }
  }
  
  protected void getFriendList(int paramInt1, int paramInt2, String paramString)
  {
    String str1 = null;
    if (TextUtils.isEmpty(null)) {
      str1 = this.db.getUserId();
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = this.db.getUserName();
    }
    if ((TextUtils.isEmpty(str2)) && (this.listener != null)) {
      this.listener.onError(this, 2, new Throwable("The account do not authorize!"));
    }
    e locale = e.a(this);
    str1 = paramString;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        str1 = "0";
      }
      paramString = locale.b(str2, str1);
      if ((paramString == null) || (paramString.size() <= 0))
      {
        if (this.listener != null) {
          this.listener.onError(this, 2, new Throwable("response is null"));
        }
      }
      else if ((paramString.containsKey("error_code")) || (paramString.containsKey("error")))
      {
        if (this.listener == null) {
          return;
        }
        paramString = new Hashon().fromHashMap(paramString);
        this.listener.onError(this, 2, new Throwable(paramString));
      }
    }
    catch (Throwable paramString)
    {
      if (this.listener != null)
      {
        this.listener.onError(this, 2, paramString);
        return;
        if (this.listener != null) {
          this.listener.onComplete(this, 2, paramString);
        }
      }
    }
  }
  
  public String getName()
  {
    return NAME;
  }
  
  public int getPlatformId()
  {
    return 11;
  }
  
  public int getVersion()
  {
    return 2;
  }
  
  public boolean hasShareCallback()
  {
    return true;
  }
  
  protected void initDevInfo(String paramString)
  {
    this.a = getDevinfo("ConsumerKey");
    this.b = getDevinfo("ConsumerSecret");
    this.c = getDevinfo("CallbackUrl");
  }
  
  protected void setNetworkDevinfo()
  {
    this.a = getNetworkDevinfo("consumer_key", "ConsumerKey");
    this.b = getNetworkDevinfo("consumer_secret", "ConsumerSecret");
    this.c = getNetworkDevinfo("redirect_uri", "CallbackUrl");
  }
  
  protected void timeline(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 7);
    }
  }
  
  protected void userInfor(String paramString)
  {
    Object localObject = e.a(this);
    try
    {
      localObject = ((e)localObject).b(paramString);
      if ((localObject == null) || (((HashMap)localObject).size() <= 0))
      {
        if (this.listener != null) {
          this.listener.onError(this, 8, new Throwable("response is null"));
        }
      }
      else if ((((HashMap)localObject).containsKey("error_code")) || (((HashMap)localObject).containsKey("error")))
      {
        if (this.listener == null) {
          return;
        }
        paramString = new Hashon().fromHashMap((HashMap)localObject);
        this.listener.onError(this, 8, new Throwable(paramString));
      }
    }
    catch (Throwable paramString)
    {
      if (this.listener != null)
      {
        this.listener.onError(this, 8, paramString);
        return;
        PlatformDb localPlatformDb;
        if (paramString == null)
        {
          this.db.put("nickname", String.valueOf(((HashMap)localObject).get("screen_name")));
          this.db.put("icon", String.valueOf(((HashMap)localObject).get("profile_image_url")));
          this.db.put("gender", "2");
          this.db.put("resume", String.valueOf(((HashMap)localObject).get("description")));
          boolean bool = "true".equals(String.valueOf(((HashMap)localObject).get("verified")));
          localPlatformDb = this.db;
          if (!bool) {
            break label409;
          }
        }
        label409:
        for (paramString = "1";; paramString = "0")
        {
          localPlatformDb.put("secretType", paramString);
          this.db.put("followerCount", String.valueOf(((HashMap)localObject).get("followers_count")));
          this.db.put("favouriteCount", String.valueOf(((HashMap)localObject).get("friends_count")));
          this.db.put("shareCount", String.valueOf(((HashMap)localObject).get("statuses_count")));
          long l = R.dateToLong(String.valueOf(((HashMap)localObject).get("created_at")));
          this.db.put("snsregat", String.valueOf(l));
          paramString = "https://twitter.com/" + ((HashMap)localObject).get("screen_name");
          this.db.put("snsUserUrl", paramString);
          if (this.listener == null) {
            break;
          }
          this.listener.onComplete(this, 8, (HashMap)localObject);
          return;
        }
      }
    }
  }
  
  public static class ShareParams
    extends Platform.ShareParams
  {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\twitter\Twitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */