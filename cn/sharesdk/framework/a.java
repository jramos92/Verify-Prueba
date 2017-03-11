package cn.sharesdk.framework;

import android.text.TextUtils;
import cn.sharesdk.framework.statistics.b.f;
import cn.sharesdk.framework.statistics.b.f.a;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import java.util.HashMap;

public class a
  implements PlatformActionListener
{
  private PlatformActionListener a;
  private HashMap<Platform, Platform.ShareParams> b = new HashMap();
  
  private String a(Platform paramPlatform)
  {
    paramPlatform = paramPlatform.getDb();
    try
    {
      paramPlatform = a(paramPlatform, new String[] { "nickname", "icon", "gender", "snsUserUrl", "resume", "secretType", "secret", "birthday", "followerCount", "favouriteCount", "shareCount", "snsregat", "snsUserLevel", "educationJSONArrayStr", "workJSONArrayStr" });
      return paramPlatform;
    }
    catch (Throwable paramPlatform)
    {
      cn.sharesdk.framework.utils.d.a().w(paramPlatform);
    }
    return null;
  }
  
  private String a(PlatformDb paramPlatformDb, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    int k = paramArrayOfString.length;
    int i = 0;
    int j = 0;
    if (i < k)
    {
      String str = paramArrayOfString[i];
      if (j > 0)
      {
        localStringBuilder2.append('|');
        localStringBuilder1.append('|');
      }
      j += 1;
      str = paramPlatformDb.get(str);
      if (TextUtils.isEmpty(str)) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder1.append(str);
        localStringBuilder2.append(Data.urlEncode(str, "utf-8"));
      }
    }
    cn.sharesdk.framework.utils.d.a().i("======UserData: " + localStringBuilder1.toString(), new Object[0]);
    return localStringBuilder2.toString();
  }
  
  private void a(int paramInt, Platform paramPlatform) {}
  
  private void a(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    this.a = new b(this, this.a, paramInt, paramHashMap);
    paramPlatform.showUser(null);
  }
  
  private String b(Platform paramPlatform)
  {
    PlatformDb localPlatformDb2 = paramPlatform.getDb();
    PlatformDb localPlatformDb1;
    if (!"WechatMoments".equals(paramPlatform.getName()))
    {
      localPlatformDb1 = localPlatformDb2;
      if (!"WechatFavorite".equals(paramPlatform.getName())) {}
    }
    else
    {
      localPlatformDb1 = localPlatformDb2;
      if (TextUtils.isEmpty(localPlatformDb2.getUserGender()))
      {
        paramPlatform = ShareSDK.getPlatform("Wechat");
        localPlatformDb1 = localPlatformDb2;
        if (paramPlatform != null) {
          localPlatformDb1 = paramPlatform.getDb();
        }
      }
    }
    try
    {
      paramPlatform = a(localPlatformDb1, new String[] { "gender", "birthday", "secretType", "educationJSONArrayStr", "workJSONArrayStr" });
      return paramPlatform;
    }
    catch (Throwable paramPlatform)
    {
      cn.sharesdk.framework.utils.d.a().w(paramPlatform);
    }
    return null;
  }
  
  private void b(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    Platform.ShareParams localShareParams = (Platform.ShareParams)this.b.remove(paramPlatform);
    if (paramHashMap != null) {
      localShareParams = (Platform.ShareParams)paramHashMap.remove("ShareParams");
    }
    for (;;)
    {
      try
      {
        localObject2 = (HashMap)paramHashMap.clone();
        if (localShareParams != null)
        {
          f localf = new f();
          localf.o = localShareParams.getCustomFlag();
          Object localObject1 = paramPlatform.getDb().getUserId();
          if ((("WechatMoments".equals(paramPlatform.getName())) || ("WechatFavorite".equals(paramPlatform.getName()))) && (TextUtils.isEmpty((CharSequence)localObject1)))
          {
            Platform localPlatform = ShareSDK.getPlatform("Wechat");
            if (localPlatform != null) {
              localObject1 = localPlatform.getDb().getUserId();
            }
            localf.b = ((String)localObject1);
            localf.a = paramPlatform.getPlatformId();
            localObject1 = paramPlatform.filterShareContent(localShareParams, (HashMap)localObject2);
            if (localObject1 != null)
            {
              localf.c = ((f.a)localObject1).a;
              localf.d = ((f.a)localObject1);
            }
            localf.n = b(paramPlatform);
            cn.sharesdk.framework.statistics.d.a(paramPlatform.getContext()).a(localf);
          }
        }
        else if (this.a == null) {}
      }
      catch (Throwable localThrowable)
      {
        try
        {
          this.a.onComplete(paramPlatform, paramInt, paramHashMap);
          a(9, paramPlatform);
          return;
          localThrowable = localThrowable;
          cn.sharesdk.framework.utils.d.a().w(localThrowable);
          Object localObject2 = paramHashMap;
          continue;
          if ("TencentWeibo".equals(paramPlatform.getName())) {
            String str = paramPlatform.getDb().get("name");
          }
        }
        catch (Throwable paramHashMap)
        {
          cn.sharesdk.framework.utils.d.a().w(paramHashMap);
        }
      }
    }
  }
  
  PlatformActionListener a()
  {
    return this.a;
  }
  
  void a(Platform paramPlatform, int paramInt, Object paramObject)
  {
    this.a = new c(this, this.a, paramInt, paramObject);
    paramPlatform.doAuthorize(null);
  }
  
  public void a(Platform paramPlatform, Platform.ShareParams paramShareParams)
  {
    this.b.put(paramPlatform, paramShareParams);
  }
  
  void a(PlatformActionListener paramPlatformActionListener)
  {
    this.a = paramPlatformActionListener;
  }
  
  public void onCancel(Platform paramPlatform, int paramInt)
  {
    if (this.a != null) {
      this.a.onCancel(paramPlatform, paramInt);
    }
  }
  
  public void onComplete(Platform paramPlatform, int paramInt, HashMap<String, Object> paramHashMap)
  {
    if ((paramPlatform instanceof CustomPlatform)) {
      if (this.a != null) {
        this.a.onComplete(paramPlatform, paramInt, paramHashMap);
      }
    }
    do
    {
      return;
      switch (paramInt)
      {
      }
    } while (this.a == null);
    this.a.onComplete(paramPlatform, paramInt, paramHashMap);
    return;
    a(paramPlatform, paramInt, paramHashMap);
    return;
    b(paramPlatform, paramInt, paramHashMap);
  }
  
  public void onError(Platform paramPlatform, int paramInt, Throwable paramThrowable)
  {
    if (this.a != null) {
      this.a.onError(paramPlatform, paramInt, paramThrowable);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */