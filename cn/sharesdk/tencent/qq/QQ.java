package cn.sharesdk.tencent.qq;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.statistics.b.f.a;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

public class QQ
  extends Platform
{
  public static final String NAME = QQ.class.getSimpleName();
  private String a;
  private boolean b;
  private boolean c = true;
  
  public QQ(Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    if ((isAuthValid()) || ((paramInt == 9) && (paramObject != null) && ((paramObject instanceof Platform.ShareParams)) && (!((Platform.ShareParams)paramObject).isShareTencentWeibo())))
    {
      paramObject = e.a(this);
      ((e)paramObject).a(this.a);
      ((e)paramObject).b(this.db.getUserId());
      ((e)paramObject).d(this.db.getToken());
      return true;
    }
    innerAuthorize(paramInt, paramObject);
    return false;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    e locale = e.a(this);
    locale.a(this.a);
    locale.a(paramArrayOfString);
    locale.a(new a(this, locale), isSSODisable());
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, paramInt);
    }
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    String str3 = paramShareParams.getTitle();
    String str2 = paramShareParams.getText();
    String str4 = paramShareParams.getImagePath();
    String str5 = paramShareParams.getImageUrl();
    String str6 = paramShareParams.getMusicUrl();
    String str1 = paramShareParams.getTitleUrl();
    boolean bool = paramShareParams.isShareTencentWeibo();
    if ((TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str4)) && (TextUtils.isEmpty(str5)) && (TextUtils.isEmpty(str6)))
    {
      if (this.listener != null) {
        this.listener.onError(this, 9, new Throwable("qq share must have one param at least"));
      }
      return;
    }
    e locale = e.a(this);
    b localb = new b(this, paramShareParams);
    paramShareParams = str1;
    if (!TextUtils.isEmpty(str1)) {
      paramShareParams = getShortLintk(str1, false);
    }
    str1 = str2;
    if (!TextUtils.isEmpty(str2)) {
      str1 = getShortLintk(str2, false);
    }
    locale.a(str3, paramShareParams, str1, str4, str5, str6, this.b, localb, bool);
  }
  
  protected HashMap<String, Object> filterFriendshipInfo(int paramInt, HashMap<String, Object> paramHashMap)
  {
    return null;
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    paramHashMap = new f.a();
    String str1 = paramShareParams.getTitleUrl();
    paramHashMap.c.add(str1);
    paramHashMap.a = this.a;
    String str2 = paramShareParams.getText();
    if (!TextUtils.isEmpty(str2)) {
      paramHashMap.b = str2;
    }
    Object localObject = paramShareParams.getImageUrl();
    String str3 = paramShareParams.getImagePath();
    if (!TextUtils.isEmpty(str3)) {
      paramHashMap.e.add(str3);
    }
    for (;;)
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("title", paramShareParams.getTitle());
      ((HashMap)localObject).put("url", str1);
      ((HashMap)localObject).put("imageLocalUrl", str3);
      ((HashMap)localObject).put("summary", str2);
      ((HashMap)localObject).put("appName", DeviceHelper.getInstance(this.context).getAppName());
      paramHashMap.g = ((HashMap)localObject);
      return paramHashMap;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        paramHashMap.d.add(localObject);
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
    return 24;
  }
  
  public int getVersion()
  {
    return 2;
  }
  
  public boolean hasShareCallback()
  {
    return this.c;
  }
  
  protected void initDevInfo(String paramString)
  {
    this.a = getDevinfo("AppId");
    this.b = "true".equals(getDevinfo("ShareByAppClient"));
    if ((this.a == null) || (this.a.length() <= 0))
    {
      this.a = getDevinfo("QZone", "AppId");
      if ((this.a != null) && (this.a.length() > 0))
      {
        copyDevinfo("QZone", NAME);
        this.a = getDevinfo("AppId");
        this.b = "true".equals(getDevinfo("ShareByAppClient"));
        d.a().d("Try to use the dev info of QZone, this will cause Id and SortId field are always 0.", new Object[0]);
      }
    }
  }
  
  public boolean isClientValid()
  {
    e locale = e.a(this);
    locale.a(this.a);
    return locale.a();
  }
  
  protected void setNetworkDevinfo()
  {
    this.a = getNetworkDevinfo("app_id", "AppId");
    if ((this.a == null) || (this.a.length() <= 0))
    {
      this.a = getNetworkDevinfo(6, "app_id", "AppId");
      if ((this.a != null) && (this.a.length() > 0))
      {
        copyNetworkDevinfo(6, 24);
        this.a = getNetworkDevinfo("app_id", "AppId");
        d.a().d("Try to use the dev info of QZone, this will cause Id and SortId field are always 0.", new Object[0]);
      }
    }
  }
  
  protected void timeline(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 7);
    }
  }
  
  protected String uploadImageToFileServer(String paramString)
  {
    return super.uploadImageToFileServer(paramString);
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
    label317:
    label431:
    label464:
    label530:
    label570:
    for (;;)
    {
      return;
      paramString = e.a(this);
      try
      {
        paramString = paramString.e(str);
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
              break label431;
            }
            this.db.put("icon", String.valueOf(paramString.get("figureurl_qq_1")));
            if (!paramString.containsKey("figureurl_2")) {
              break label464;
            }
            this.db.put("iconQzone", String.valueOf(paramString.get("figureurl_2")));
            this.db.put("secretType", String.valueOf(paramString.get("is_yellow_vip")));
            if (String.valueOf(paramString.get("is_yellow_vip")).equals("1")) {
              this.db.put("snsUserLevel", String.valueOf(paramString.get("level")));
            }
            str = String.valueOf(paramString.get("gender"));
            if (!str.equals("男")) {
              break label530;
            }
            this.db.put("gender", "0");
          }
          for (;;)
          {
            if (this.listener == null) {
              break label570;
            }
            this.listener.onComplete(this, 8, paramString);
            return;
            if (!paramString.containsKey("figureurl_qq_2")) {
              break;
            }
            this.db.put("icon", String.valueOf(paramString.get("figureurl_qq_2")));
            break;
            if (paramString.containsKey("figureurl_1"))
            {
              this.db.put("iconQzone", String.valueOf(paramString.get("figureurl_1")));
              break label317;
            }
            if (!paramString.containsKey("figureurl")) {
              break label317;
            }
            this.db.put("iconQzone", String.valueOf(paramString.get("figureurl")));
            break label317;
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
    public String imageUrl;
    @Deprecated
    public String musicUrl;
    @Deprecated
    public String title;
    @Deprecated
    public String titleUrl;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qq\QQ.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */