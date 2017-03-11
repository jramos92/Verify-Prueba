package cn.sharesdk.tencent.qzone;

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
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class QZone
  extends Platform
{
  public static final String NAME = QZone.class.getSimpleName();
  private String a;
  private boolean b;
  
  public QZone(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(Platform.ShareParams paramShareParams)
  {
    String str = paramShareParams.getImageUrl();
    Object localObject = paramShareParams.getImagePath();
    boolean bool = paramShareParams.isShareTencentWeibo();
    try
    {
      if ((TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(str)))
      {
        paramShareParams.setImagePath(BitmapHelper.downloadBitmap(this.context, str));
        doShare(paramShareParams);
        return;
      }
      if (!isAuthValid())
      {
        setPlatformActionListener(new b(this, getPlatformActionListener(), paramShareParams));
        authorize();
        return;
      }
    }
    catch (Throwable paramShareParams)
    {
      if (this.listener != null)
      {
        this.listener.onError(this, 9, paramShareParams);
        return;
        str = paramShareParams.getText();
        if (TextUtils.isEmpty(str))
        {
          if (this.listener != null) {
            this.listener.onError(this, 9, new Throwable("share params' value of text is empty!"));
          }
        }
        else
        {
          str = getShortLintk(str, false);
          f localf = f.a(this);
          if (bool) {}
          for (localObject = localf.b((String)localObject, str);; localObject = localf.a((String)localObject, str))
          {
            if ((localObject == null) && (this.listener != null)) {
              this.listener.onError(this, 9, new Throwable("response is empty"));
            }
            ((HashMap)localObject).put("ShareParams", paramShareParams);
            if (this.listener == null) {
              break;
            }
            this.listener.onComplete(this, 9, (HashMap)localObject);
            return;
          }
        }
      }
    }
  }
  
  private void b(Platform.ShareParams paramShareParams)
  {
    Object localObject2 = paramShareParams.getImageUrl();
    Object localObject3 = paramShareParams.getImagePath();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject1 = localObject2;
        if (new File((String)localObject3).exists())
        {
          localObject1 = uploadImageToFileServer((String)localObject3);
          paramShareParams.setImageUrl((String)localObject1);
        }
      }
    }
    try
    {
      paramShareParams.set("webShare", Boolean.valueOf(true));
      String str2 = paramShareParams.getTitle();
      String str1 = paramShareParams.getTitleUrl();
      String str3 = paramShareParams.getSite();
      localObject3 = paramShareParams.getText();
      localObject2 = localObject3;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = getShortLintk((String)localObject3, false);
      }
      localObject3 = str1;
      if (!TextUtils.isEmpty(str1)) {
        localObject3 = getShortLintk(str1, false);
      }
      f.a(this).a(str2, (String)localObject3, (String)localObject2, (String)localObject1, str3, this.b, new c(this, paramShareParams));
      return;
    }
    catch (Throwable paramShareParams)
    {
      while (this.listener == null) {}
      this.listener.onError(this, 9, paramShareParams);
    }
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    if ((isAuthValid()) || (paramInt == 9))
    {
      paramObject = f.a(this);
      ((f)paramObject).a(this.a);
      ((f)paramObject).b(this.db.getUserId());
      ((f)paramObject).c(this.db.getToken());
      return true;
    }
    innerAuthorize(paramInt, paramObject);
    return false;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    f localf = f.a(this);
    localf.a(this.a);
    localf.a(paramArrayOfString);
    localf.a(new a(this, localf), isSSODisable());
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    paramString1 = f.a(this).a(paramString1, paramString2, paramHashMap, paramHashMap1);
    if ((paramString1 == null) || (paramString1.size() <= 0)) {
      if (this.listener != null) {
        this.listener.onError(this, paramInt, new Throwable());
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramString1.containsKey("ret")) {
            break;
          }
        } while (this.listener == null);
        this.listener.onError(this, paramInt, new Throwable());
        return;
        if (((Integer)paramString1.get("ret")).intValue() == 0) {
          break;
        }
      } while (this.listener == null);
      paramString1 = new Hashon().fromHashMap(paramString1);
      this.listener.onError(this, paramInt, new Throwable(paramString1));
      return;
    } while (this.listener == null);
    this.listener.onComplete(this, paramInt, paramString1);
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    paramShareParams.set("webShare", Boolean.valueOf(false));
    String str1 = paramShareParams.getTitle();
    String str2 = paramShareParams.getTitleUrl();
    String str3 = paramShareParams.getSite();
    String str4 = paramShareParams.getSiteUrl();
    String str5 = paramShareParams.getImageUrl();
    String str6 = paramShareParams.getImagePath();
    if (paramShareParams.isShareTencentWeibo())
    {
      a(paramShareParams);
      return;
    }
    if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str4)) && ((!TextUtils.isEmpty(str6)) || (!TextUtils.isEmpty(str5))))
    {
      a(paramShareParams);
      return;
    }
    b(paramShareParams);
  }
  
  protected HashMap<String, Object> filterFriendshipInfo(int paramInt, HashMap<String, Object> paramHashMap)
  {
    return null;
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    f.a locala = new f.a();
    locala.b = paramShareParams.getText();
    Object localObject;
    if (((Boolean)paramShareParams.get("webShare", Boolean.class)).booleanValue())
    {
      localObject = paramShareParams.getImageUrl();
      if (localObject != null) {
        locala.d.add(localObject);
      }
      localObject = paramShareParams.getTitleUrl();
      if (localObject != null) {
        locala.c.add(localObject);
      }
      localObject = paramShareParams.getSiteUrl();
      if (localObject != null) {
        locala.c.add(localObject);
      }
      if (paramHashMap != null) {
        locala.a = String.valueOf(paramHashMap.get("share_id"));
      }
    }
    for (;;)
    {
      paramHashMap = new HashMap();
      paramHashMap.put("title", paramShareParams.getTitle());
      paramHashMap.put("url", paramShareParams.getTitleUrl());
      paramHashMap.put("site", paramShareParams.getSite());
      paramHashMap.put("fromurl", paramShareParams.getSiteUrl());
      paramHashMap.put("type", Integer.valueOf(4));
      paramHashMap.put("comment", paramShareParams.getComment());
      paramHashMap.put("summary", paramShareParams.getText());
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramShareParams.getImageUrl());
      paramHashMap.put("images", localObject);
      paramHashMap.put("playurl", null);
      locala.g = paramHashMap;
      return locala;
      localObject = paramShareParams.getImagePath();
      if (localObject != null) {
        locala.e.add(localObject);
      } else if (paramHashMap.get("large_url") != null) {
        locala.d.add(String.valueOf(paramHashMap.get("large_url")));
      } else if (paramHashMap.get("small_url") != null) {
        locala.d.add(String.valueOf(paramHashMap.get("small_url")));
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
    return 6;
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
    this.a = getDevinfo("AppId");
    this.b = "true".equals(getDevinfo("ShareByAppClient"));
    if ((this.a == null) || (this.a.length() <= 0))
    {
      this.a = getDevinfo("QQ", "AppId");
      if ((this.a != null) && (this.a.length() > 0))
      {
        copyDevinfo("QQ", NAME);
        this.a = getDevinfo("AppId");
        this.b = "true".equals(getDevinfo("ShareByAppClient"));
        d.a().d("Try to use the dev info of QQ, this will cause Id and SortId field are always 0.", new Object[0]);
      }
    }
  }
  
  public boolean isClientValid()
  {
    f localf = f.a(this);
    localf.a(this.a);
    return localf.a();
  }
  
  protected void setNetworkDevinfo()
  {
    this.a = getNetworkDevinfo("app_id", "AppId");
    if ((this.a == null) || (this.a.length() <= 0))
    {
      this.a = getNetworkDevinfo(24, "app_id", "AppId");
      if ((this.a != null) && (this.a.length() > 0))
      {
        copyNetworkDevinfo(24, 6);
        this.a = getNetworkDevinfo("app_id", "AppId");
        d.a().d("Try to use the dev info of QQ, this will cause Id and SortId field are always 0.", new Object[0]);
      }
    }
  }
  
  protected void timeline(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 7);
    }
  }
  
  protected void userInfor(String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() >= 0) {}
    }
    else
    {
      str = this.db.getUserId();
    }
    if ((str == null) || (str.length() < 0)) {
      if (this.listener != null) {
        this.listener.onError(this, 8, new RuntimeException("qq account is null"));
      }
    }
    label133:
    label315:
    label429:
    label462:
    label528:
    label568:
    for (;;)
    {
      return;
      paramString = f.a(this);
      try
      {
        paramString = paramString.d(str);
        if ((paramString != null) && (paramString.size() > 0)) {
          break label133;
        }
        if (this.listener == null) {
          continue;
        }
        this.listener.onError(this, 8, new Throwable());
        return;
      }
      catch (Throwable paramString) {}
      if (this.listener != null)
      {
        this.listener.onError(this, 8, paramString);
        return;
        if (!paramString.containsKey("ret"))
        {
          if (this.listener != null) {
            this.listener.onError(this, 8, new Throwable());
          }
        }
        else if (((Integer)paramString.get("ret")).intValue() != 0)
        {
          if (this.listener != null)
          {
            paramString = new Hashon().fromHashMap(paramString);
            this.listener.onError(this, 8, new Throwable(paramString));
          }
        }
        else
        {
          if (str == this.db.getUserId())
          {
            this.db.put("nickname", String.valueOf(paramString.get("nickname")));
            if (!paramString.containsKey("figureurl_qq_1")) {
              break label429;
            }
            this.db.put("iconQQ", String.valueOf(paramString.get("figureurl_qq_1")));
            if (!paramString.containsKey("figureurl_2")) {
              break label462;
            }
            this.db.put("icon", String.valueOf(paramString.get("figureurl_2")));
            this.db.put("secretType", String.valueOf(paramString.get("is_yellow_vip")));
            if (String.valueOf(paramString.get("is_yellow_vip")).equals("1")) {
              this.db.put("snsUserLevel", String.valueOf(paramString.get("level")));
            }
            str = String.valueOf(paramString.get("gender"));
            if (!str.equals("男")) {
              break label528;
            }
            this.db.put("gender", "0");
          }
          for (;;)
          {
            if (this.listener == null) {
              break label568;
            }
            this.listener.onComplete(this, 8, paramString);
            return;
            if (!paramString.containsKey("figureurl_qq_2")) {
              break;
            }
            this.db.put("iconQQ", String.valueOf(paramString.get("figureurl_qq_2")));
            break;
            if (paramString.containsKey("figureurl_1"))
            {
              this.db.put("icon", String.valueOf(paramString.get("figureurl_1")));
              break label315;
            }
            if (!paramString.containsKey("figureurl")) {
              break label315;
            }
            this.db.put("icon", String.valueOf(paramString.get("figureurl")));
            break label315;
            if (str.equals("女")) {
              this.db.put("gender", "1");
            } else {
              this.db.put("gender", "2");
            }
          }
        }
      }
    }
  }
  
  public static class ShareParams
    extends Platform.ShareParams
  {
    @Deprecated
    public String comment;
    @Deprecated
    public String imageUrl;
    @Deprecated
    public String site;
    @Deprecated
    public String siteUrl;
    @Deprecated
    public String title;
    @Deprecated
    public String titleUrl;
    @Deprecated
    boolean webShare;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qzone\QZone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */