package cn.sharesdk.tencent.qq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.R;
import java.util.HashMap;

public class h
  extends FakeActivity
{
  private String a;
  private Platform b;
  private PlatformActionListener c;
  
  public void a(Platform paramPlatform, PlatformActionListener paramPlatformActionListener)
  {
    this.b = paramPlatform;
    this.c = paramPlatformActionListener;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void onCreate()
  {
    try
    {
      Object localObject = this.activity.getIntent();
      String str1 = ((Intent)localObject).getScheme();
      finish();
      if ((str1 == null) || (!str1.startsWith(this.a))) {
        return;
      }
      localObject = R.urlToBundle(((Intent)localObject).getDataString());
      str1 = String.valueOf(((Bundle)localObject).get("result"));
      String str2 = String.valueOf(((Bundle)localObject).get("action"));
      if ((!"shareToQQ".equals(str2)) && (!"shareToQzone".equals(str2))) {
        return;
      }
      if ("complete".equals(str1))
      {
        if (this.c == null) {
          return;
        }
        localObject = String.valueOf(((Bundle)localObject).get("response"));
        localObject = new Hashon().fromJson((String)localObject);
        this.c.onComplete(this.b, 9, (HashMap)localObject);
        return;
      }
      if ("error".equals(str1))
      {
        if (this.c == null) {
          return;
        }
        localObject = new Throwable(String.valueOf(((Bundle)localObject).get("response")));
        this.c.onError(this.b, 9, (Throwable)localObject);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      d.a().w(localThrowable);
      return;
    }
    if (this.c != null) {
      this.c.onCancel(this.b, 9);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\tencent\qq\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */