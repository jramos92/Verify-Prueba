package cn.sharesdk.instagram;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.statistics.b.f.a;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Instagram
  extends Platform
{
  public static final String NAME = Instagram.class.getSimpleName();
  private String a;
  private String b;
  private String c;
  
  public Instagram(Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    e locale = e.a(this);
    boolean bool = locale.a();
    if (paramInt == 9) {
      return bool;
    }
    if (isAuthValid())
    {
      locale.a(this.a, this.b, this.c);
      locale.b(this.db.getToken());
      return true;
    }
    innerAuthorize(paramInt, paramObject);
    return false;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    e locale = e.a(this);
    locale.a(this.a, this.b, this.c);
    locale.a(paramArrayOfString);
    locale.a(new a(this, locale));
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, paramInt);
    }
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    b localb = new b(this, paramShareParams);
    e.a(this).a(paramShareParams.getImagePath(), paramShareParams.getImageUrl(), paramShareParams.getText(), localb);
  }
  
  protected HashMap<String, Object> filterFriendshipInfo(int paramInt, HashMap<String, Object> paramHashMap)
  {
    HashMap localHashMap1 = new HashMap();
    if (2 == paramInt) {
      localHashMap1.put("type", "FOLLOWING");
    }
    for (;;)
    {
      localHashMap1.put("snsplat", Integer.valueOf(getPlatformId()));
      localHashMap1.put("snsuid", this.db.getUserId());
      localObject = paramHashMap.get("data");
      if (localObject != null) {
        break;
      }
      return null;
      localHashMap1.put("type", "FOLLOWERS");
    }
    paramHashMap = new ArrayList();
    Object localObject = (ArrayList)localObject;
    if (((ArrayList)localObject).size() <= 0) {
      return null;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      HashMap localHashMap2 = (HashMap)((Iterator)localObject).next();
      if (localHashMap2 != null)
      {
        HashMap localHashMap3 = new HashMap();
        String str = String.valueOf(localHashMap2.get("username"));
        localHashMap3.put("snsuid", String.valueOf(localHashMap2.get("id")));
        localHashMap3.put("nickname", str);
        localHashMap3.put("snsUserUrl", "http://instagram.com/" + str + "/#");
        localHashMap3.put("icon", String.valueOf(localHashMap2.get("profile_picture")));
        localHashMap3.put("gender", "2");
        paramHashMap.add(localHashMap3);
      }
    }
    if ((paramHashMap == null) || (paramHashMap.size() <= 0)) {
      return null;
    }
    localHashMap1.put("nextCursor", "0_true");
    localHashMap1.put("list", paramHashMap);
    return localHashMap1;
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    paramHashMap = new f.a();
    String str = paramShareParams.getImagePath();
    paramShareParams = paramShareParams.getImageUrl();
    if (!TextUtils.isEmpty(str)) {
      paramHashMap.e.add(str);
    }
    while (TextUtils.isEmpty(paramShareParams)) {
      return paramHashMap;
    }
    paramHashMap.d.add(paramShareParams);
    return paramHashMap;
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
    String str = paramString;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        str = this.db.getUserId();
      }
      paramString = str;
      if (TextUtils.isEmpty(str)) {
        paramString = this.db.get("nickname");
      }
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramString = e.a(this).e(paramString);
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = filterFriendshipInfo(11, paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      d.a().w(paramString);
    }
    return null;
  }
  
  protected HashMap<String, Object> getFollowings(int paramInt1, int paramInt2, String paramString)
  {
    String str = paramString;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        str = this.db.getUserId();
      }
      paramString = str;
      if (TextUtils.isEmpty(str)) {
        paramString = this.db.get("nickname");
      }
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      paramString = e.a(this).d(paramString);
      if ((paramString != null) && (paramString.size() > 0))
      {
        paramString = filterFriendshipInfo(2, paramString);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      d.a().w(paramString);
    }
    return null;
  }
  
  protected void getFriendList(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 2);
    }
  }
  
  public String getName()
  {
    return NAME;
  }
  
  protected int getPlatformId()
  {
    return 15;
  }
  
  public int getVersion()
  {
    return 1;
  }
  
  public boolean hasShareCallback()
  {
    return false;
  }
  
  protected void initDevInfo(String paramString)
  {
    this.a = getDevinfo("ClientId");
    this.b = getDevinfo("ClientSecret");
    this.c = getDevinfo("RedirectUri");
  }
  
  public boolean isClientValid()
  {
    return e.a(this).a();
  }
  
  protected void setNetworkDevinfo()
  {
    this.a = getNetworkDevinfo("client_id", "ClientId");
    this.b = getNetworkDevinfo("client_secret", "ClientSecret");
    this.c = getNetworkDevinfo("redirect_uri", "RedirectUri");
  }
  
  protected void timeline(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 7);
    }
  }
  
  protected void userInfor(String paramString)
  {
    int i = 0;
    Object localObject;
    if (paramString != null)
    {
      localObject = paramString;
      if (paramString.length() >= 0) {}
    }
    else
    {
      localObject = this.db.getUserId();
      i = 1;
    }
    if ((localObject == null) || (((String)localObject).length() < 0)) {
      if (this.listener != null) {
        this.listener.onError(this, 8, new RuntimeException("Instagram account is null"));
      }
    }
    label135:
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            paramString = e.a(this).c((String)localObject);
            if ((paramString != null) && (paramString.size() > 0)) {
              break label135;
            }
            if (this.listener != null)
            {
              this.listener.onError(this, 8, new Throwable());
              return;
            }
          }
          catch (Throwable paramString) {}
        }
      } while (this.listener == null);
      this.listener.onError(this, 8, paramString);
      return;
      if (i != 0)
      {
        localObject = (HashMap)paramString.get("data");
        if ((localObject != null) && (((HashMap)localObject).size() > 0))
        {
          this.db.put("resume", String.valueOf(((HashMap)localObject).get("bio")));
          this.db.put("icon", String.valueOf(((HashMap)localObject).get("profile_picture")));
          String str = String.valueOf(((HashMap)localObject).get("username"));
          this.db.put("nickname", str);
          this.db.put("snsUserUrl", "http://instagram.com/" + str + "/#");
          localObject = (HashMap)((HashMap)localObject).get("counts");
          if ((localObject != null) && (((HashMap)localObject).size() > 0))
          {
            this.db.put("followerCount", String.valueOf(((HashMap)localObject).get("followed_by")));
            this.db.put("favouriteCount", String.valueOf(((HashMap)localObject).get("follows")));
            this.db.put("shareCount", String.valueOf(((HashMap)localObject).get("media")));
          }
        }
      }
    } while (this.listener == null);
    this.listener.onComplete(this, 8, paramString);
  }
  
  public static class ShareParams
    extends Platform.ShareParams
  {
    @Deprecated
    public String imageUrl;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\instagram\Instagram.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */