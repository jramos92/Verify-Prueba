package cn.sharesdk.system.email;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Spanned;
import android.text.TextUtils;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.UIHandler;
import java.io.File;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.HashMap;

public class b
{
  private static b a;
  private Context b;
  
  public static b a(Context paramContext)
  {
    if (a == null) {
      a = new b();
    }
    a.b = paramContext;
    return a;
  }
  
  public void a(String paramString1, String paramString2, Spanned paramSpanned, String paramString3, ActionListener paramActionListener)
  {
    boolean bool = true;
    try
    {
      Intent localIntent1 = new Intent("android.intent.action.SEND");
      localIntent1.setFlags(268435456);
      localIntent1.putExtra("android.intent.extra.SUBJECT", paramString2);
      localIntent1.putExtra("android.intent.extra.TEXT", paramSpanned);
      if (paramString3 != null)
      {
        File localFile = new File(paramString3);
        if (localFile.exists()) {
          localIntent1.putExtra("android.intent.extra.STREAM", Uri.fromFile(localFile));
        }
      }
      localIntent1.setType("message/rfc822");
      this.b.startActivity(localIntent1);
      paramString1 = DeviceHelper.getInstance(this.b);
      paramString2 = this.b.getPackageName();
      if (TextUtils.isEmpty(paramString1.getTopTaskPackageName()))
      {
        if ((bool) && (paramActionListener != null)) {
          paramActionListener.onComplete(new HashMap());
        }
        return;
      }
    }
    catch (Throwable localThrowable) {}
    for (;;)
    {
      try
      {
        Intent localIntent2 = new Intent("android.intent.action.SEND");
        localIntent2.setFlags(268435456);
        localIntent2.putExtra("android.intent.extra.EMAIL", paramString1);
        if (paramString2 != null) {
          localIntent2.putExtra("android.intent.extra.SUBJECT", paramString2);
        }
        if (paramSpanned != null)
        {
          localIntent2.putExtra("android.intent.extra.TEXT", paramSpanned);
          localIntent2.setType("text/html");
        }
        if (paramString3 != null)
        {
          paramString2 = URLConnection.getFileNameMap().getContentTypeFor(paramString3);
          if (paramString2 == null) {
            break label332;
          }
          paramString1 = paramString2;
          if (paramString2.length() <= 0) {
            break label332;
          }
          paramString2 = new File(paramString3);
          if (paramString2.exists())
          {
            localIntent2.putExtra("android.intent.extra.STREAM", Uri.fromFile(paramString2));
            localIntent2.setType(paramString1);
          }
        }
        this.b.startActivity(localIntent2);
      }
      catch (Throwable paramString1)
      {
        if (paramActionListener != null) {
          paramActionListener.onError(paramString1);
        }
        bool = false;
      }
      break;
      UIHandler.sendEmptyMessageDelayed(0, 2000L, new c(this, paramString1, paramString2, bool, paramActionListener));
      return;
      label332:
      paramString1 = "*/*";
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\system\email\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */