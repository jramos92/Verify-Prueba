package cn.sharesdk.whatsapp;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.statistics.b.f.a;
import com.mob.tools.utils.BitmapHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class WhatsApp
  extends Platform
{
  public static final String NAME = WhatsApp.class.getSimpleName();
  private c a = new c(this);
  
  public WhatsApp(Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean checkAuthorize(int paramInt, Object paramObject)
  {
    if (isClientValid()) {
      return true;
    }
    if (this.listener != null) {
      this.listener.onError(this, paramInt, new WhatsAppClientNotExistException());
    }
    return false;
  }
  
  protected void doAuthorize(String[] paramArrayOfString)
  {
    if (isClientValid()) {
      afterRegister(1, null);
    }
    while (this.listener == null) {
      return;
    }
    this.listener.onError(this, 1, new WhatsAppClientNotExistException());
  }
  
  protected void doCustomerProtocol(String paramString1, String paramString2, int paramInt, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    if (this.listener != null) {
      this.listener.onCancel(this, paramInt);
    }
  }
  
  protected void doShare(Platform.ShareParams paramShareParams)
  {
    String str2 = paramShareParams.getText();
    Object localObject = paramShareParams.getTitle();
    String str3 = paramShareParams.getFilePath();
    String str4 = paramShareParams.getAddress();
    try
    {
      str1 = paramShareParams.getImagePath();
      str5 = paramShareParams.getImageUrl();
      localb = new b(this, paramShareParams);
      if (!TextUtils.isEmpty(str2))
      {
        paramShareParams = getShortLintk(str2, false);
        this.a.a(paramShareParams, (String)localObject, localb);
        return;
      }
      if (!TextUtils.isEmpty(str1))
      {
        this.a.a(2, str1, localb);
        return;
      }
    }
    catch (Throwable paramShareParams)
    {
      String str1;
      String str5;
      b localb;
      if (this.listener != null)
      {
        this.listener.onError(this, 9, paramShareParams);
        return;
        if (!TextUtils.isEmpty(str5))
        {
          localObject = new File(BitmapHelper.downloadBitmap(getContext(), str5));
          paramShareParams = str1;
          if (((File)localObject).exists()) {
            paramShareParams = ((File)localObject).getAbsolutePath();
          }
          this.a.a(2, paramShareParams, localb);
          return;
        }
        if (!TextUtils.isEmpty(str3))
        {
          this.a.a(6, str3, localb);
          return;
        }
        if (!TextUtils.isEmpty(str4))
        {
          this.a.a(str4, localb);
          return;
        }
        if (this.listener != null) {
          this.listener.onError(this, 9, new Throwable("Missing parameters"));
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
    String str1 = paramShareParams.getText();
    String str2 = paramShareParams.getImageUrl();
    paramShareParams = paramShareParams.getImagePath();
    if (!TextUtils.isEmpty(str1)) {
      locala.b = str1;
    }
    for (;;)
    {
      if (paramHashMap != null) {
        locala.g = paramHashMap;
      }
      return locala;
      if (!TextUtils.isEmpty(str2)) {
        locala.d.add(str2);
      } else if (!TextUtils.isEmpty(paramShareParams)) {
        locala.e.add(paramShareParams);
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
    return 43;
  }
  
  public int getVersion()
  {
    return 1;
  }
  
  public boolean hasShareCallback()
  {
    return true;
  }
  
  protected void initDevInfo(String paramString) {}
  
  public boolean isClientValid()
  {
    return this.a.a();
  }
  
  @Deprecated
  public boolean isValid()
  {
    return this.a.a();
  }
  
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
    public String imageUrl;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\whatsapp\WhatsApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */