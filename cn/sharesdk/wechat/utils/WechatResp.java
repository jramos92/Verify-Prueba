package cn.sharesdk.wechat.utils;

import android.os.Bundle;

public abstract class WechatResp
{
  public int f;
  public String g;
  public String h;
  
  public WechatResp(Bundle paramBundle)
  {
    a(paramBundle);
  }
  
  public abstract int a();
  
  public void a(Bundle paramBundle)
  {
    this.f = paramBundle.getInt("_wxapi_baseresp_errcode");
    this.g = paramBundle.getString("_wxapi_baseresp_errstr");
    this.h = paramBundle.getString("_wxapi_baseresp_transaction");
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putInt("_wxapi_command_type", a());
    paramBundle.putInt("_wxapi_baseresp_errcode", this.f);
    paramBundle.putString("_wxapi_baseresp_errstr", this.g);
    paramBundle.putString("_wxapi_baseresp_transaction", this.h);
  }
  
  public static abstract interface ErrCode
  {
    public static final int ERR_AUTH_DENIED = -4;
    public static final int ERR_COMM = -1;
    public static final int ERR_OK = 0;
    public static final int ERR_SENT_FAILED = -3;
    public static final int ERR_UNSUPPORT = -5;
    public static final int ERR_USER_CANCEL = -2;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\wechat\utils\WechatResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */