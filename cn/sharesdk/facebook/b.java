package cn.sharesdk.facebook;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.e;
import cn.sharesdk.framework.authorize.f;

public class b
  extends f
{
  private String d;
  private String[] e;
  
  public b(e parame)
  {
    super(parame);
  }
  
  private boolean b()
  {
    boolean bool = true;
    Intent localIntent = new Intent();
    localIntent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
    localIntent.putExtra("client_id", this.d);
    if ((this.e != null) && (this.e.length > 0)) {
      localIntent.putExtra("scope", TextUtils.join(",", this.e));
    }
    if (!b(localIntent)) {
      return false;
    }
    try
    {
      this.a.startActivityForResult(localIntent, this.b);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        bool = false;
      }
    }
  }
  
  private boolean b(Intent paramIntent)
  {
    paramIntent = this.a.getContext().getPackageManager().resolveActivity(paramIntent, 0);
    if (paramIntent == null) {}
    for (;;)
    {
      return false;
      paramIntent = paramIntent.activityInfo.packageName;
      try
      {
        paramIntent = this.a.getContext().getPackageManager().getPackageInfo(paramIntent, 64).signatures;
        int j = paramIntent.length;
        int i = 0;
        while (i < j)
        {
          boolean bool = "30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2".equals(paramIntent[i].toCharsString());
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (PackageManager.NameNotFoundException paramIntent) {}
    }
  }
  
  private void c(Intent paramIntent)
  {
    if (this.c == null) {
      return;
    }
    String str2 = paramIntent.getStringExtra("error_message");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramIntent.getStringExtra("error_code");
    }
    if (str1 == null)
    {
      this.c.onComplete(paramIntent.getExtras());
      return;
    }
    if ((str1.equals("access_denied")) || (str1.equals("OAuthAccessDeniedException")))
    {
      this.c.onCancel();
      return;
    }
    str2 = paramIntent.getStringExtra("error_message");
    if (str2 != null) {
      str1 = paramIntent.getStringExtra("error_code") + ": " + str2;
    }
    this.c.onFailed(new Throwable(str1));
  }
  
  private void d(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      str = paramIntent.getStringExtra("error");
      i = paramIntent.getIntExtra("error_code", -1);
      paramIntent = new Throwable(str + " (" + i + ")");
      if (this.c != null) {
        this.c.onFailed(paramIntent);
      }
    }
    while (this.c == null)
    {
      String str;
      int i;
      return;
    }
    this.c.onCancel();
  }
  
  public void a()
  {
    if (!b())
    {
      this.a.finish();
      if (this.c != null) {
        this.c.onFailed(new Throwable());
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.finish();
    if (paramInt1 == this.b) {}
    switch (paramInt2)
    {
    default: 
      return;
    case -1: 
      c(paramIntent);
      return;
    }
    d(paramIntent);
  }
  
  public void a(String paramString, String[] paramArrayOfString)
  {
    this.d = paramString;
    this.e = paramArrayOfString;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\facebook\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */