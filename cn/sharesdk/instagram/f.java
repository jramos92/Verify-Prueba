package cn.sharesdk.instagram;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.mob.tools.FakeActivity;
import java.io.File;
import java.util.HashMap;

public class f
  extends FakeActivity
  implements Handler.Callback
{
  private Platform a;
  private PlatformActionListener b;
  private String c;
  private String d;
  private String e;
  
  private void b(String paramString)
  {
    if ((!e.a(this.a).a()) || (TextUtils.isEmpty(paramString)))
    {
      finish();
      if (this.b != null) {
        this.b.onError(this.a, 9, new InstagramClientNotExistException());
      }
      return;
    }
    Intent localIntent = new Intent("android.intent.action.SEND");
    if ((paramString.endsWith("mp4")) || (paramString.endsWith("mkv"))) {
      localIntent.setType("video/*");
    }
    for (;;)
    {
      localIntent.setPackage("com.instagram.android");
      if (!TextUtils.isEmpty(this.c)) {
        localIntent.putExtra("android.intent.extra.TEXT", this.c);
      }
      localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramString)));
      try
      {
        startActivity(localIntent);
        finish();
        if (this.b == null) {
          break;
        }
        this.b.onComplete(this.a, 9, new HashMap());
        return;
      }
      catch (Throwable paramString)
      {
        finish();
      }
      if (this.b == null) {
        break;
      }
      this.b.onError(this.a, 9, paramString);
      return;
      localIntent.setType("image/*");
    }
  }
  
  public void a(Platform paramPlatform, PlatformActionListener paramPlatformActionListener)
  {
    this.a = paramPlatform;
    this.b = paramPlatformActionListener;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.e = paramString1;
    this.d = paramString2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.arg1 == 0)
    {
      finish();
      if (this.b != null) {
        this.b.onError(this.a, 9, (Throwable)paramMessage.obj);
      }
    }
    for (;;)
    {
      return false;
      b(String.valueOf(paramMessage.obj));
    }
  }
  
  public void onCreate()
  {
    if (!TextUtils.isEmpty(this.e)) {
      b(this.e);
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(this.d))
      {
        new g(this).start();
        return;
      }
    } while (this.b == null);
    finish();
    this.b.onError(this.a, 9, new Throwable("both imagePath and imageUrl are null"));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\instagram\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */