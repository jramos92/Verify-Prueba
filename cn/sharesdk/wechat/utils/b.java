package cn.sharesdk.wechat.utils;

import android.os.Bundle;

public class b
  extends WechatResp
{
  public String a;
  public String b;
  public int c;
  public String d;
  public String e;
  
  public b(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public int a()
  {
    return 1;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.a = paramBundle.getString("_wxapi_sendauth_resp_userName");
    this.b = paramBundle.getString("_wxapi_sendauth_resp_token");
    this.c = paramBundle.getInt("_wxapi_sendauth_resp_expireDate", 0);
    this.d = paramBundle.getString("_wxapi_sendauth_resp_state");
    this.e = paramBundle.getString("_wxapi_sendauth_resp_url");
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    paramBundle.putString("_wxapi_sendauth_resp_userName", this.a);
    paramBundle.putString("_wxapi_sendauth_resp_token", this.b);
    paramBundle.putInt("_wxapi_sendauth_resp_expireDate", this.c);
    paramBundle.putString("_wxapi_sendauth_resp_state", this.d);
    paramBundle.putString("_wxapi_sendauth_resp_url", this.e);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\wechat\utils\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */