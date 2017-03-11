package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.content.Intent;
import cn.sharesdk.framework.Platform;
import com.mob.tools.FakeActivity;

public class a
  extends FakeActivity
{
  protected AuthorizeHelper a;
  
  public AuthorizeHelper a()
  {
    return this.a;
  }
  
  public void a(AuthorizeHelper paramAuthorizeHelper)
  {
    this.a = paramAuthorizeHelper;
    super.show(paramAuthorizeHelper.getPlatform().getContext(), null);
  }
  
  public void show(Context paramContext, Intent paramIntent)
  {
    throw new RuntimeException("This method is deprecated, use show(AuthorizeHelper, Intent) instead");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\authorize\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */