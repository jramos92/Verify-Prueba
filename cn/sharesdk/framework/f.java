package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.R;
import java.lang.reflect.Field;
import java.util.HashMap;

public class f
{
  private Platform a;
  private Context b;
  private PlatformDb c;
  private a d;
  private int e;
  private int f;
  private boolean g;
  private boolean h = true;
  private boolean i;
  
  public f(Platform paramPlatform, Context paramContext)
  {
    this.a = paramPlatform;
    this.b = paramContext;
    String str = paramPlatform.getName();
    this.c = new PlatformDb(paramContext, str, paramPlatform.getVersion());
    a(str);
    this.d = new a();
  }
  
  private boolean j()
  {
    boolean bool = false;
    if (!ShareSDK.a()) {
      return true;
    }
    Object localObject;
    if (ShareSDK.b())
    {
      localObject = a(this.a.getPlatformId(), "covert_url", null);
      if (localObject != null) {
        ((String)localObject).trim();
      }
      if (!"false".equals(localObject)) {
        bool = true;
      }
      this.h = bool;
      this.a.setNetworkDevinfo();
      return true;
    }
    for (;;)
    {
      try
      {
        localObject = new HashMap();
        if (!ShareSDK.a((HashMap)localObject)) {
          return false;
        }
        if (!ShareSDK.b((HashMap)localObject))
        {
          localObject = new Hashon().fromHashMap((HashMap)localObject);
          d.a().w("Failed to parse network dev-info: " + (String)localObject, new Object[0]);
          return false;
        }
        localObject = a(this.a.getPlatformId(), "covert_url", null);
        if (localObject != null) {
          ((String)localObject).trim();
        }
        if (!"false".equals(localObject))
        {
          bool = true;
          this.h = bool;
          this.a.setNetworkDevinfo();
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        d.a().w(localThrowable);
        return false;
      }
      bool = false;
    }
  }
  
  private String k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      try
      {
        if (!"TencentWeibo".equals(this.a.getName())) {
          continue;
        }
        d.a().i("user id %s ==>>", new Object[] { g().getUserName() });
        localStringBuilder.append(Data.urlEncode(g().getUserName(), "utf-8"));
        localStringBuilder.append("|").append(Data.urlEncode(g().get("secretType"), "utf-8"));
        localStringBuilder.append("|").append(Data.urlEncode(g().get("gender"), "utf-8"));
        localStringBuilder.append("|").append(Data.urlEncode(g().get("birthday"), "utf-8"));
        localStringBuilder.append("|").append(Data.urlEncode(g().get("educationJSONArrayStr"), "utf-8"));
        localStringBuilder.append("|").append(Data.urlEncode(g().get("workJSONArrayStr"), "utf-8"));
      }
      catch (Throwable localThrowable)
      {
        d.a().w(localThrowable);
        continue;
      }
      return localStringBuilder.toString();
      localStringBuilder.append(Data.urlEncode(g().getUserId(), "utf-8"));
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    String str = ShareSDK.a(paramInt, paramString1);
    if (!TextUtils.isEmpty(str))
    {
      paramString1 = str;
      if (!"null".equals(str)) {}
    }
    else
    {
      paramString1 = this.a.getDevinfo(this.a.getName(), paramString2);
    }
    return paramString1;
  }
  
  public String a(Bitmap paramBitmap)
  {
    return ShareSDK.a(paramBitmap);
  }
  
  public String a(String paramString, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (!this.h)
    {
      d.a().i("getShortLintk use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return paramString;
    }
    if (TextUtils.isEmpty(paramString))
    {
      d.a().i("getShortLintk use time: " + (System.currentTimeMillis() - l), new Object[0]);
      return paramString;
    }
    paramString = ShareSDK.a(paramString, paramBoolean, this.a.getPlatformId(), k());
    d.a().i("getShortLintk use time: " + (System.currentTimeMillis() - l), new Object[0]);
    return paramString;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    c(2, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.d.a(this.a, paramInt, paramObject);
  }
  
  public void a(Platform.ShareParams paramShareParams)
  {
    if (paramShareParams == null)
    {
      if (this.d != null) {
        this.d.onError(this.a, 9, new NullPointerException());
      }
      return;
    }
    c(9, paramShareParams);
  }
  
  public void a(PlatformActionListener paramPlatformActionListener)
  {
    this.d.a(paramPlatformActionListener);
  }
  
  public void a(String paramString)
  {
    String str = ShareSDK.b(paramString, "Id");
    try
    {
      this.e = R.parseInt(String.valueOf(str).trim());
      str = ShareSDK.b(paramString, "SortId");
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        do
        {
          this.f = R.parseInt(String.valueOf(str).trim());
          str = ShareSDK.b(paramString, "Enable");
          if (str != null) {
            break;
          }
          this.i = true;
          if (!(this.a instanceof CustomPlatform)) {
            d.a().d(this.a.getName() + " failed to parse Enable, this will cause platform always be enable", new Object[0]);
          }
          this.a.initDevInfo(paramString);
          return;
          localThrowable1 = localThrowable1;
        } while ((this.a instanceof CustomPlatform));
        d.a().d(this.a.getName() + " failed to parse Id, this will cause method getId() always returens 0", new Object[0]);
      }
      catch (Throwable localThrowable2)
      {
        for (;;)
        {
          if (!(this.a instanceof CustomPlatform))
          {
            d.a().d(this.a.getName() + " failed to parse SortId, this won't cause any problem, don't worry", new Object[0]);
            continue;
            this.i = "true".equals(localThrowable2.trim());
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    c(7, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
  }
  
  public void a(String paramString1, String paramString2, short paramShort, HashMap<String, Object> paramHashMap, HashMap<String, String> paramHashMap1)
  {
    c(0xA0000 | paramShort, new Object[] { paramString1, paramString2, paramHashMap, paramHashMap1 });
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void a(String[] paramArrayOfString)
  {
    new h(this, paramArrayOfString).start();
  }
  
  public int b()
  {
    return this.f;
  }
  
  protected void b(int paramInt, Object paramObject)
  {
    Object localObject2;
    Object localObject1;
    HashMap localHashMap;
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      localObject2 = (Object[])paramObject;
      paramObject = String.valueOf(localObject2[0]);
      localObject1 = String.valueOf(localObject2[1]);
      localHashMap = (HashMap)localObject2[2];
      localObject2 = (HashMap)localObject2[3];
      this.a.doCustomerProtocol((String)paramObject, (String)localObject1, paramInt, localHashMap, (HashMap)localObject2);
    case 1: 
      do
      {
        return;
      } while (this.d == null);
      this.d.onComplete(this.a, 1, null);
      return;
    case 6: 
      this.a.follow((String)paramObject);
      return;
    case 7: 
      paramObject = (Object[])paramObject;
      this.a.timeline(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      return;
    case 8: 
      localObject1 = this.a;
      if (paramObject == null) {}
      for (paramObject = null;; paramObject = (String)paramObject)
      {
        ((Platform)localObject1).userInfor((String)paramObject);
        return;
      }
    case 9: 
      localObject1 = (Platform.ShareParams)paramObject;
      localHashMap = ((Platform.ShareParams)localObject1).toMap();
      localObject2 = localObject1.getClass().getFields();
      int j = localObject2.length;
      paramInt = 0;
      for (;;)
      {
        if (paramInt < j)
        {
          Object localObject3 = localObject2[paramInt];
          if (localHashMap.get(((Field)localObject3).getName()) == null) {
            ((Field)localObject3).setAccessible(true);
          }
          try
          {
            paramObject = ((Field)localObject3).get(localObject1);
            if (paramObject != null) {
              localHashMap.put(((Field)localObject3).getName(), paramObject);
            }
            paramInt += 1;
          }
          catch (Throwable paramObject)
          {
            for (;;)
            {
              d.a().w((Throwable)paramObject);
              paramObject = null;
            }
          }
        }
      }
      if ((this.d instanceof a)) {
        this.d.a(this.a, (Platform.ShareParams)localObject1);
      }
      this.a.doShare((Platform.ShareParams)localObject1);
      return;
    }
    paramObject = (Object[])paramObject;
    this.a.getFriendList(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
  }
  
  public void b(String paramString)
  {
    c(6, paramString);
  }
  
  public PlatformActionListener c()
  {
    return this.d.a();
  }
  
  protected void c(int paramInt, Object paramObject)
  {
    new g(this, paramInt, paramObject).start();
  }
  
  public void c(String paramString)
  {
    c(8, paramString);
  }
  
  public String d(String paramString)
  {
    return ShareSDK.a(paramString);
  }
  
  public boolean d()
  {
    return this.c.isValid();
  }
  
  public boolean e()
  {
    return this.g;
  }
  
  public boolean f()
  {
    return this.i;
  }
  
  public PlatformDb g()
  {
    return this.c;
  }
  
  public void h()
  {
    this.c.removeAccount();
  }
  
  protected PlatformActionListener i()
  {
    return this.d;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */