package cn.sharesdk.wechat.utils;

import android.os.Bundle;

public class f
  extends WechatResp
{
  public WXMediaMessage a;
  
  public f(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public int a()
  {
    return 4;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.a = WXMediaMessage.a.a(paramBundle);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    paramBundle.putAll(WXMediaMessage.a.a(this.a));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\wechat\utils\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */