package cn.sharesdk.wechat.favorite;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.statistics.b.f.a;
import cn.sharesdk.framework.utils.d;
import cn.sharesdk.wechat.utils.WechatClientNotExistException;
import cn.sharesdk.wechat.utils.WechatHelper;
import cn.sharesdk.wechat.utils.WechatHelper.ShareParams;
import cn.sharesdk.wechat.utils.WechatTimelineNotSupportedException;
import cn.sharesdk.wechat.utils.g;
import cn.sharesdk.wechat.utils.k;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.R;
import java.util.ArrayList;
import java.util.HashMap;

public class WechatFavorite
  extends Platform
{
  public static final String NAME = WechatFavorite.class.getSimpleName();
  private String a;
  private String b;
  
  public WechatFavorite(Context paramContext)
  {
    super(paramContext);
  }
  
  private boolean c()
  {
    int[] arrayOfInt;
    do
    {
      try
      {
        PackageInfo localPackageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 0);
        if (localPackageInfo == null) {
          return false;
        }
      }
      catch (Throwable localThrowable1)
      {
        d.a().w(localThrowable1);
        return false;
      }
      String[] arrayOfString = localThrowable1.versionName.split("\\.");
      arrayOfInt = new int[arrayOfString.length];
      int i = 0;
      for (;;)
      {
        if (i < arrayOfInt.length) {
          try
          {
            arrayOfInt[i] = R.parseInt(arrayOfString[i]);
            i += 1;
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              d.a().w(localThrowable2);
              arrayOfInt[i] = 0;
            }
          }
        }
      }
    } while ((arrayOfInt.length <= 0) || (arrayOfInt[0] < 5));
    return true;
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    WechatHelper localWechatHelper = WechatHelper.a();
    localWechatHelper.a(this.context, this.a);
    if (!localWechatHelper.c()) {
      if (this.listener != null) {
        this.listener.onError(this, paramInt, new WechatClientNotExistException());
      }
    }
    do
    {
      return false;
      if (localWechatHelper.d()) {
        break;
      }
    } while (this.listener == null);
    this.listener.onError(this, 1, new WechatTimelineNotSupportedException());
    return false;
    if ((paramInt == 9) || (isAuthValid())) {
      return true;
    }
    if (TextUtils.isEmpty(getDb().get("refresh_token"))) {}
    innerAuthorize(paramInt, paramObject);
    return false;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    if ((TextUtils.isEmpty(this.a)) || (TextUtils.isEmpty(this.b))) {
      if (this.listener != null) {
        this.listener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramArrayOfString = WechatHelper.a();
          paramArrayOfString.a(this.context, this.a);
          if (paramArrayOfString.c()) {
            break;
          }
        } while (this.listener == null);
        this.listener.onError(this, 1, new WechatClientNotExistException());
        return;
        if (paramArrayOfString.d()) {
          break;
        }
      } while (this.listener == null);
      this.listener.onError(this, 1, new WechatTimelineNotSupportedException());
      return;
      g localg = new g(this, 37);
      localg.a(this.a, this.b);
      k localk = new k(this);
      localk.a(localg);
      localk.a(new a(this));
      try
      {
        paramArrayOfString.a(localk);
        return;
      }
      catch (Throwable paramArrayOfString) {}
    } while (this.listener == null);
    this.listener.onError(this, 1, paramArrayOfString);
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, paramInt);
    }
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    paramShareParams.set("scene", Integer.valueOf(2));
    WechatHelper localWechatHelper = WechatHelper.a();
    localWechatHelper.a(this.context, this.a);
    k localk = new k(this);
    localk.a(paramShareParams, this.listener);
    try
    {
      localWechatHelper.b(localk);
      return;
    }
    catch (Throwable paramShareParams)
    {
      while (this.listener == null) {}
      this.listener.onError(this, 9, paramShareParams);
    }
  }
  
  protected HashMap<String, Object> filterFriendshipInfo(int paramInt, HashMap<String, Object> paramHashMap)
  {
    return null;
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    paramHashMap = new f.a();
    String str1 = paramShareParams.getText();
    paramHashMap.b = str1;
    String str2 = paramShareParams.getImageUrl();
    Object localObject = paramShareParams.getImagePath();
    Bitmap localBitmap = paramShareParams.getImageData();
    if (!TextUtils.isEmpty(str2)) {
      paramHashMap.d.add(str2);
    }
    for (;;)
    {
      str2 = paramShareParams.getUrl();
      if (str2 != null) {
        paramHashMap.c.add(str2);
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("title", paramShareParams.getTitle());
      ((HashMap)localObject).put("url", str2);
      ((HashMap)localObject).put("extInfo", null);
      ((HashMap)localObject).put("content", str1);
      ((HashMap)localObject).put("image", paramHashMap.d);
      ((HashMap)localObject).put("musicFileUrl", str2);
      paramHashMap.g = ((HashMap)localObject);
      return paramHashMap;
      if (localObject != null) {
        paramHashMap.e.add(localObject);
      } else if (localBitmap != null) {
        paramHashMap.f.add(localBitmap);
      }
    }
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
    return null;
  }
  
  protected HashMap<String, Object> getFollowings(int paramInt1, int paramInt2, String paramString)
  {
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
  
  public int getPlatformId()
  {
    return 37;
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
    this.a = getDevinfo("AppId");
    this.b = getDevinfo("AppSecret");
    if ((this.a == null) || (this.a.length() <= 0))
    {
      this.a = getDevinfo("Wechat", "AppId");
      if ((this.a == null) || (this.a.length() <= 0)) {
        break label106;
      }
      copyDevinfo("Wechat", NAME);
      this.a = getDevinfo("AppId");
      d.a().d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
    }
    label106:
    do
    {
      return;
      this.a = getDevinfo("WechatMoments", "AppId");
    } while ((this.a == null) || (this.a.length() <= 0));
    copyDevinfo("WechatMoments", NAME);
    this.a = getDevinfo("AppId");
    d.a().d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
  }
  
  public boolean isClientValid()
  {
    WechatHelper localWechatHelper = WechatHelper.a();
    localWechatHelper.a(this.context, this.a);
    return (localWechatHelper.c()) && (c());
  }
  
  @Deprecated
  public boolean isValid()
  {
    WechatHelper localWechatHelper = WechatHelper.a();
    localWechatHelper.a(this.context, this.a);
    return (localWechatHelper.c()) && (c()) && (super.isValid());
  }
  
  protected void setNetworkDevinfo()
  {
    this.a = getNetworkDevinfo("app_id", "AppId");
    this.b = getNetworkDevinfo("app_secret", "AppSecret");
    if ((this.a == null) || (this.a.length() <= 0))
    {
      this.a = getNetworkDevinfo(22, "app_id", "AppId");
      if ((this.a != null) && (this.a.length() > 0))
      {
        copyNetworkDevinfo(22, 37);
        this.a = getNetworkDevinfo("app_id", "AppId");
        d.a().d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
      }
    }
    else if ((this.b == null) || (this.b.length() <= 0))
    {
      this.b = getNetworkDevinfo(22, "app_secret", "AppSecret");
      if ((this.b == null) || (this.b.length() <= 0)) {
        break label273;
      }
      copyNetworkDevinfo(22, 37);
      this.b = getNetworkDevinfo("app_secret", "AppSecret");
      d.a().d("Try to use the dev info of Wechat, this will cause Id and SortId field are always 0.", new Object[0]);
    }
    label273:
    do
    {
      return;
      this.a = getNetworkDevinfo(23, "app_id", "AppId");
      if ((this.a == null) || (this.a.length() <= 0)) {
        break;
      }
      copyNetworkDevinfo(23, 37);
      this.a = getNetworkDevinfo("app_id", "AppId");
      d.a().d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
      break;
      this.b = getNetworkDevinfo(23, "app_secret", "AppSecret");
    } while ((this.b == null) || (this.b.length() <= 0));
    copyNetworkDevinfo(23, 37);
    this.b = getNetworkDevinfo("app_secret", "AppSecret");
    d.a().d("Try to use the dev info of WechatMoments, this will cause Id and SortId field are always 0.", new Object[0]);
  }
  
  protected void timeline(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 7);
    }
  }
  
  protected void userInfor(String paramString)
  {
    if ((TextUtils.isEmpty(this.a)) || (TextUtils.isEmpty(this.b))) {
      if (this.listener != null) {
        this.listener.onError(this, 8, new Throwable("The params of appID or appSecret is missing !"));
      }
    }
    do
    {
      return;
      paramString = new g(this, 37);
      paramString.a(this.a, this.b);
      try
      {
        paramString.a(this.listener);
        return;
      }
      catch (Throwable paramString)
      {
        d.a().w(paramString);
      }
    } while (this.listener == null);
    this.listener.onError(this, 8, paramString);
  }
  
  public static class ShareParams
    extends WechatHelper.ShareParams
  {
    public ShareParams()
    {
      this.scene = 2;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\wechat\favorite\WechatFavorite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */