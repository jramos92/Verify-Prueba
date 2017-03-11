package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import com.mob.tools.log.NLog;

public class d
  extends m
{
  public WXMediaMessage a;
  public int b;
  
  public int a()
  {
    return 2;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    paramBundle.putAll(WXMediaMessage.a.a(this.a));
    paramBundle.putInt("_wxapi_sendmessagetowx_req_scene", this.b);
  }
  
  public boolean b()
  {
    if ((this.a.getType() == 8) && ((this.a.thumbData == null) || (this.a.thumbData.length <= 0)))
    {
      cn.sharesdk.framework.utils.d.a().w("checkArgs fail, thumbData should not be null when send emoji", new Object[0]);
      return false;
    }
    if ((this.a.thumbData != null) && (this.a.thumbData.length > 32768))
    {
      cn.sharesdk.framework.utils.d.a().w("checkArgs fail, thumbData is invalid", new Object[0]);
      return false;
    }
    if ((this.a.title != null) && (this.a.title.length() > 512))
    {
      cn.sharesdk.framework.utils.d.a().w("checkArgs fail, title is invalid", new Object[0]);
      return false;
    }
    if ((this.a.description != null) && (this.a.description.length() > 1024)) {
      this.a.description = (this.a.description.substring(0, 1021) + "...");
    }
    if (this.a.mediaObject == null)
    {
      cn.sharesdk.framework.utils.d.a().w("checkArgs fail, mediaObject is null", new Object[0]);
      return false;
    }
    return this.a.mediaObject.checkArgs();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\wechat\utils\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */