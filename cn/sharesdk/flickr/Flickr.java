package cn.sharesdk.flickr;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.statistics.b.f.a;
import com.mob.tools.utils.BitmapHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Flickr
  extends Platform
{
  public static final String NAME = Flickr.class.getSimpleName();
  private String a;
  private String b;
  private String c;
  
  public Flickr(Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    if (isAuthValid())
    {
      b localb = b.a(this);
      localb.a(this.a, this.b, this.c);
      String str1 = this.db.getToken();
      String str2 = this.db.getTokenSecret();
      if ((str1 != null) && (str2 != null))
      {
        localb.a(str1, str2);
        return true;
      }
    }
    innerAuthorize(paramInt, paramObject);
    return false;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    paramArrayOfString = b.a(this);
    paramArrayOfString.a(this.a, this.b, this.c);
    paramArrayOfString.a(new a(this, paramArrayOfString));
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, paramInt);
    }
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    try
    {
      Object localObject2 = paramShareParams.getImagePath();
      Object localObject3 = paramShareParams.getImageUrl();
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject3 = new File(BitmapHelper.downloadBitmap(getContext(), (String)localObject3));
          localObject1 = localObject2;
          if (((File)localObject3).exists()) {
            localObject1 = ((File)localObject3).getAbsolutePath();
          }
        }
      }
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!new File((String)localObject1).exists()))
      {
        if (this.listener != null) {
          this.listener.onError(this, 9, new Throwable("imagePath is needed"));
        }
      }
      else
      {
        localObject2 = b.a(this);
        localObject3 = getShortLintk(paramShareParams.getText(), false);
        localObject1 = ((b)localObject2).a((String)localObject1, paramShareParams.getTitle(), (String)localObject3, paramShareParams.getTags(), paramShareParams.isPublic(), paramShareParams.isFriend(), paramShareParams.isFamily(), paramShareParams.getSafetyLevel(), paramShareParams.getContentType(), paramShareParams.getHidden());
        if (localObject1 == null)
        {
          if (this.listener == null) {
            return;
          }
          this.listener.onError(this, 9, new Throwable("respons is empty"));
        }
      }
    }
    catch (Throwable paramShareParams)
    {
      Object localObject1;
      if (this.listener != null)
      {
        this.listener.onError(this, 9, paramShareParams);
        return;
        if (this.listener != null)
        {
          ((HashMap)localObject1).put("ShareParams", paramShareParams);
          this.listener.onComplete(this, 9, (HashMap)localObject1);
        }
      }
    }
  }
  
  protected HashMap<String, Object> filterFriendshipInfo(int paramInt, HashMap<String, Object> paramHashMap)
  {
    return null;
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    f.a locala = new f.a();
    locala.b = paramShareParams.getText();
    locala.e.add(paramShareParams.getImagePath());
    if (paramHashMap != null) {
      locala.a = String.valueOf(((HashMap)((HashMap)paramHashMap.get("rsp")).get("photoid")).get("value"));
    }
    locala.g = paramHashMap;
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
  
  protected int getPlatformId()
  {
    return 34;
  }
  
  public int getVersion()
  {
    return 1;
  }
  
  public boolean hasShareCallback()
  {
    return true;
  }
  
  protected void initDevInfo(String paramString)
  {
    this.a = getDevinfo("ApiKey");
    this.b = getDevinfo("ApiSecret");
    this.c = getDevinfo("RedirectUri");
  }
  
  protected void setNetworkDevinfo()
  {
    this.a = getNetworkDevinfo("api_key", "ApiKey");
    this.b = getNetworkDevinfo("api_secret", "ApiSecret");
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
    Object localObject = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      i = 1;
      localObject = getDb().getUserId();
    }
    paramString = b.a(this);
    try
    {
      paramString = paramString.b((String)localObject);
      if (paramString == null)
      {
        if (this.listener != null) {
          this.listener.onError(this, 8, new Throwable("respons is empty"));
        }
        return;
      }
    }
    catch (Throwable paramString)
    {
      do
      {
        for (;;)
        {
          if (this.listener != null) {
            this.listener.onError(this, 8, paramString);
          }
          paramString = null;
        }
        if (i != 0)
        {
          localObject = (HashMap)paramString.get("person");
          if (localObject != null)
          {
            this.db.putUserId(String.valueOf(((HashMap)localObject).get("id")));
            HashMap localHashMap = (HashMap)((HashMap)localObject).get("username");
            if (localHashMap != null) {
              this.db.put("nickname", String.valueOf(localHashMap.get("_content")));
            }
            localHashMap = (HashMap)((HashMap)localObject).get("profileurl");
            if (localHashMap != null) {
              this.db.put("snsUserUrl", String.valueOf(localHashMap.get("_content")));
            }
            localObject = (HashMap)((HashMap)localObject).get("description");
            if (localObject != null) {
              this.db.put("resume", String.valueOf(((HashMap)localObject).get("_content")));
            }
          }
        }
      } while (this.listener == null);
      this.listener.onComplete(this, 8, paramString);
    }
  }
  
  public static class ShareParams
    extends Platform.ShareParams
  {
    @Deprecated
    public int contentType;
    @Deprecated
    public int hidden;
    @Deprecated
    public boolean isFamily;
    @Deprecated
    public boolean isFriend;
    @Deprecated
    public boolean isPublic;
    @Deprecated
    public int safetyLevel;
    @Deprecated
    public String[] tags;
    @Deprecated
    public String title;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\flickr\Flickr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */