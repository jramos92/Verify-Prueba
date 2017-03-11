package cn.sharesdk.whatsapp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.b;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.e;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;

public class c
  extends e
{
  public c(Platform paramPlatform)
  {
    super(paramPlatform);
  }
  
  public void a(int paramInt, String paramString, PlatformActionListener paramPlatformActionListener)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("type", paramInt);
    localIntent.putExtra("path", paramString);
    paramString = new a();
    paramString.a(this.a, paramPlatformActionListener);
    paramString.show(this.a.getContext(), localIntent);
  }
  
  public void a(String paramString, PlatformActionListener paramPlatformActionListener)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("type", 100);
    localIntent.putExtra("phone", paramString);
    paramString = new a();
    paramString.a(this.a, paramPlatformActionListener);
    paramString.show(this.a.getContext(), localIntent);
  }
  
  public void a(String paramString1, String paramString2, PlatformActionListener paramPlatformActionListener)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("type", 1);
    localIntent.putExtra("text", paramString1);
    localIntent.putExtra("title", paramString2);
    paramString1 = new a();
    paramString1.a(this.a, paramPlatformActionListener);
    paramString1.show(this.a.getContext(), localIntent);
  }
  
  public boolean a()
  {
    for (;;)
    {
      try
      {
        if (this.a.getContext().getPackageManager().getPackageInfo("com.whatsapp", 0) == null) {
          continue;
        }
        bool = true;
        localBoolean = Boolean.valueOf(bool);
      }
      catch (Exception localException)
      {
        boolean bool;
        Boolean localBoolean = Boolean.valueOf(false);
        d.a().w("Exception", new Object[] { localException.toString() });
        continue;
      }
      return localBoolean.booleanValue();
      bool = false;
    }
  }
  
  public String getAuthorizeUrl()
  {
    return null;
  }
  
  public b getAuthorizeWebviewClient(g paramg)
  {
    return null;
  }
  
  public String getRedirectUri()
  {
    return null;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\whatsapp\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */