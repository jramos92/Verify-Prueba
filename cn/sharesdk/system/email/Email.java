package cn.sharesdk.system.email;

import android.content.Context;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.statistics.b.f.a;
import com.mob.tools.utils.BitmapHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Email
  extends Platform
{
  public static final String NAME = Email.class.getSimpleName();
  
  public Email(Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    return true;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    afterRegister(1, null);
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, paramInt);
    }
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    for (;;)
    {
      String str2;
      try
      {
        localb = b.a(this.context);
        locala = new a(this, paramShareParams);
        localSpanned = Html.fromHtml(getShortLintk(paramShareParams.getText(), true));
        str2 = paramShareParams.getAddress();
        str3 = paramShareParams.getTitle();
        str1 = paramShareParams.getImagePath();
        Object localObject = paramShareParams.getImageUrl();
        paramShareParams = str1;
        if (!TextUtils.isEmpty(str1)) {
          break label148;
        }
        paramShareParams = str1;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label148;
        }
        localObject = new File(BitmapHelper.downloadBitmap(getContext(), (String)localObject));
        paramShareParams = str1;
        if (!((File)localObject).exists()) {
          break label148;
        }
        paramShareParams = ((File)localObject).getAbsolutePath();
      }
      catch (Throwable paramShareParams)
      {
        b localb;
        a locala;
        Spanned localSpanned;
        String str3;
        if (this.listener == null) {
          continue;
        }
        this.listener.onError(this, 9, paramShareParams);
        return;
      }
      localb.a(str1, str3, localSpanned, paramShareParams, locala);
      return;
      label148:
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
    }
  }
  
  protected HashMap<String, Object> filterFriendshipInfo(int paramInt, HashMap<String, Object> paramHashMap)
  {
    return null;
  }
  
  protected f.a filterShareContent(Platform.ShareParams paramShareParams, HashMap<String, Object> paramHashMap)
  {
    paramHashMap = new f.a();
    String str = paramShareParams.getText();
    paramHashMap.b = str;
    Object localObject = paramShareParams.getImagePath();
    if (localObject != null) {
      paramHashMap.e.add(localObject);
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("subject", paramShareParams.getTitle());
    ((HashMap)localObject).put("content", str);
    paramHashMap.g = ((HashMap)localObject);
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
    return 18;
  }
  
  public int getVersion()
  {
    return 1;
  }
  
  public boolean hasShareCallback()
  {
    return false;
  }
  
  protected void initDevInfo(String paramString) {}
  
  protected void setNetworkDevinfo() {}
  
  protected void timeline(int paramInt1, int paramInt2, String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 7);
    }
  }
  
  protected void userInfor(String paramString)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, 8);
    }
  }
  
  public static class ShareParams
    extends Platform.ShareParams
  {
    @Deprecated
    public String address;
    @Deprecated
    public String title;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\system\email\Email.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */