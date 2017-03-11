package cn.sharesdk.whatsapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.mob.tools.FakeActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class a
  extends FakeActivity
{
  private Platform a;
  private PlatformActionListener b;
  
  public void a(Platform paramPlatform, PlatformActionListener paramPlatformActionListener)
  {
    this.a = paramPlatform;
    this.b = paramPlatformActionListener;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    finish();
    if (paramInt1 == 1)
    {
      HashMap localHashMap = new HashMap();
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Iterator localIterator = paramIntent.getExtras().keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localHashMap.put(str, paramIntent.getExtras().get(str));
        }
      }
      this.b.onComplete(this.a, 9, localHashMap);
    }
  }
  
  public void onCreate()
  {
    Object localObject2 = this.activity.getIntent().getExtras();
    String str4 = ((Bundle)localObject2).getString("uri");
    Object localObject1 = ((Bundle)localObject2).getString("path");
    String str2 = ((Bundle)localObject2).getString("title");
    String str3 = ((Bundle)localObject2).getString("text");
    String str1 = ((Bundle)localObject2).getString("phone");
    int i = ((Bundle)localObject2).getInt("type");
    if (!TextUtils.isEmpty(str4))
    {
      startActivityForResult(new Intent("android.intent.action.SEND", Uri.parse(str4)), 1);
      return;
    }
    localObject2 = new Intent("android.intent.action.SEND");
    if ((1 == i) && ((!TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str2))))
    {
      ((Intent)localObject2).setType("text/plain");
      ((Intent)localObject2).putExtra("android.intent.extra.SUBJECT", str2);
      ((Intent)localObject2).putExtra("android.intent.extra.TEXT", str3);
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((Intent)localObject1).setPackage("com.whatsapp");
      startActivityForResult((Intent)localObject1, 1);
      return;
      if ((2 == i) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        ((Intent)localObject2).setType("image/*");
        ((Intent)localObject2).putExtra("android.intent.extra.STREAM", Uri.parse((String)localObject1));
        localObject1 = localObject2;
      }
      else if ((6 == i) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        ((Intent)localObject2).setType("video/*");
        ((Intent)localObject2).putExtra("android.intent.extra.STREAM", Uri.parse((String)localObject1));
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = localObject2;
        if (100 == i)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(str1)) {
            localObject1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str1));
          }
        }
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\whatsapp\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */