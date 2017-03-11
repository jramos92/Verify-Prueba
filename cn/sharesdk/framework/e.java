package cn.sharesdk.framework;

import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.f;
import cn.sharesdk.framework.authorize.g;

public abstract class e
  implements AuthorizeHelper
{
  protected Platform a;
  private AuthorizeListener b;
  private SSOListener c;
  
  public e(Platform paramPlatform)
  {
    this.a = paramPlatform;
  }
  
  protected void a(SSOListener paramSSOListener)
  {
    this.c = paramSSOListener;
    cn.sharesdk.framework.authorize.e locale = new cn.sharesdk.framework.authorize.e();
    locale.a(paramSSOListener);
    locale.a(this);
  }
  
  protected void b(AuthorizeListener paramAuthorizeListener)
  {
    this.b = paramAuthorizeListener;
    paramAuthorizeListener = new g();
    paramAuthorizeListener.a(this.b);
    paramAuthorizeListener.a(this);
  }
  
  public int c()
  {
    return this.a.getPlatformId();
  }
  
  public AuthorizeListener getAuthorizeListener()
  {
    return this.b;
  }
  
  public Platform getPlatform()
  {
    return this.a;
  }
  
  public SSOListener getSSOListener()
  {
    return this.c;
  }
  
  public f getSSOProcessor(cn.sharesdk.framework.authorize.e parame)
  {
    return null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */