package cn.sharesdk.framework;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.sharesdk.framework.statistics.a;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.SSDKHandlerThread;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.R;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class k
  extends SSDKHandlerThread
{
  private a a = a.a;
  private Context b;
  private HashMap<String, HashMap<String, String>> c;
  private ArrayList<Platform> d;
  private HashMap<String, Integer> e;
  private HashMap<Integer, String> f;
  private HashMap<Integer, CustomPlatform> g;
  private HashMap<Integer, HashMap<String, Object>> h;
  private HashMap<Integer, Service> i;
  private String j;
  private boolean k;
  private String l;
  private boolean m;
  private boolean n;
  
  public k(Context paramContext)
  {
    super("Thread-" + Math.abs(38301));
    this.b = paramContext.getApplicationContext();
    this.c = new HashMap();
    this.d = new ArrayList();
    this.e = new HashMap();
    this.f = new HashMap();
    this.g = new HashMap();
    this.h = new HashMap();
    this.i = new HashMap();
  }
  
  private boolean a(a parama, HashMap<String, Object> paramHashMap1, HashMap<String, Object> paramHashMap2)
  {
    try
    {
      if (paramHashMap1.containsKey("error"))
      {
        d.a().w("ShareSDK parse sns config ==>>", new Object[] { new Hashon().fromHashMap(paramHashMap1) });
        return false;
      }
      if (!paramHashMap1.containsKey("res"))
      {
        d.a().d("ShareSDK platform config result ==>>", new Object[] { "SNS configuration is empty" });
        return false;
      }
      paramHashMap1 = (String)paramHashMap1.get("res");
      if (paramHashMap1 == null) {
        return false;
      }
      paramHashMap2.putAll(parama.a(this.j, paramHashMap1));
      return true;
    }
    catch (Throwable parama)
    {
      d.a().w(parama);
    }
    return false;
  }
  
  private void h()
  {
    for (;;)
    {
      synchronized (this.c)
      {
        this.c.clear();
        i();
        if (this.c.containsKey("ShareSDK"))
        {
          Object localObject1 = (HashMap)this.c.remove("ShareSDK");
          if (localObject1 != null)
          {
            if (this.j == null) {
              this.j = ((String)((HashMap)localObject1).get("AppKey"));
            }
            if (!((HashMap)localObject1).containsKey("UseVersion")) {
              break label99;
            }
            localObject1 = (String)((HashMap)localObject1).get("UseVersion");
            this.l = ((String)localObject1);
          }
        }
        return;
      }
      label99:
      String str = "latest";
    }
  }
  
  private void i()
  {
    try
    {
      Object localObject = XmlPullParserFactory.newInstance();
      ((XmlPullParserFactory)localObject).setNamespaceAware(true);
      XmlPullParser localXmlPullParser = ((XmlPullParserFactory)localObject).newPullParser();
      try
      {
        localObject = this.b.getAssets().open("ShareSDK.xml");
        localXmlPullParser.setInput((InputStream)localObject, "utf-8");
        i1 = localXmlPullParser.getEventType();
        if (i1 != 1) {
          if (i1 == 2)
          {
            str = localXmlPullParser.getName();
            localHashMap = new HashMap();
            int i2 = localXmlPullParser.getAttributeCount();
            i1 = 0;
            while (i1 < i2)
            {
              localHashMap.put(localXmlPullParser.getAttributeName(i1), localXmlPullParser.getAttributeValue(i1).trim());
              i1 += 1;
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        InputStream localInputStream;
        for (;;)
        {
          String str;
          HashMap localHashMap;
          d.a().w(localThrowable1);
          localInputStream = this.b.getAssets().open("ShareSDK.conf");
          continue;
          this.c.put(str, localHashMap);
          int i1 = localXmlPullParser.next();
        }
        localInputStream.close();
        return;
      }
      return;
    }
    catch (Throwable localThrowable2)
    {
      d.a().w(localThrowable2);
    }
  }
  
  private void j()
  {
    new l(this).start();
  }
  
  private void k()
  {
    this.d.clear();
    ??? = new i().a(this.b);
    if (??? != null) {
      this.d.addAll((Collection)???);
    }
    synchronized (this.e)
    {
      synchronized (this.f)
      {
        Iterator localIterator = this.d.iterator();
        if (localIterator.hasNext())
        {
          Platform localPlatform = (Platform)localIterator.next();
          this.f.put(Integer.valueOf(localPlatform.getPlatformId()), localPlatform.getName());
          this.e.put(localPlatform.getName(), Integer.valueOf(localPlatform.getPlatformId()));
        }
      }
    }
  }
  
  private void l()
  {
    i locali = new i();
    locali.a(this);
    locali.a(this.b, this.j, this.handler, this.k, c());
  }
  
  public String a(int paramInt, String paramString)
  {
    synchronized (this.h)
    {
      paramString = new i().a(paramInt, paramString, this.h);
      return paramString;
    }
  }
  
  public String a(Bitmap paramBitmap)
  {
    if (a.c != this.a) {
      return null;
    }
    return new i().a(this.b, paramBitmap);
  }
  
  public String a(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    if (a.c != this.a) {
      return paramString1;
    }
    return new i().a(this.b, this.j, paramString1, paramBoolean, paramInt, paramString2);
  }
  
  public void a(int paramInt)
  {
    com.mob.tools.network.NetworkHelper.connectionTimeout = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.h)
    {
      new i().a(paramInt1, paramInt2, this.h);
      return;
    }
  }
  
  public void a(int paramInt, Platform paramPlatform)
  {
    new i().a(paramInt, paramPlatform);
  }
  
  public void a(Class<? extends Service> paramClass)
  {
    synchronized (this.i)
    {
      if (this.i.containsKey(Integer.valueOf(paramClass.hashCode()))) {
        return;
      }
    }
    try
    {
      Service localService = (Service)paramClass.newInstance();
      this.i.put(Integer.valueOf(paramClass.hashCode()), localService);
      localService.a(this.b);
      localService.a(this.j);
      localService.onBind();
      return;
      paramClass = finally;
      throw paramClass;
    }
    catch (Throwable paramClass)
    {
      for (;;)
      {
        d.a().w(paramClass);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.j = paramString;
  }
  
  public void a(String paramString, int paramInt)
  {
    new i().a(paramString, paramInt);
  }
  
  public void a(String paramString1, String paramString2)
  {
    synchronized (this.c)
    {
      paramString1 = (HashMap)this.c.get(paramString1);
      this.c.put(paramString2, paramString1);
      return;
    }
  }
  
  public void a(String paramString, HashMap<String, Object> paramHashMap)
  {
    label133:
    for (;;)
    {
      synchronized (this.c)
      {
        ??? = (HashMap)this.c.get(paramString);
        if (??? != null) {
          break label133;
        }
        synchronized (new HashMap())
        {
          paramHashMap = paramHashMap.entrySet().iterator();
          if (paramHashMap.hasNext())
          {
            Object localObject = (Map.Entry)paramHashMap.next();
            String str = (String)((Map.Entry)localObject).getKey();
            localObject = ((Map.Entry)localObject).getValue();
            if (localObject == null) {
              continue;
            }
            ???.put(str, String.valueOf(localObject));
          }
        }
      }
      this.c.put(paramString, ???);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public boolean a(HashMap<String, Object> paramHashMap)
  {
    if (a.c != this.a)
    {
      d.a().d("Statistics module unopened", new Object[0]);
      return false;
    }
    a locala = a.a(this.b);
    boolean bool2 = a(locala, locala.f(this.j), paramHashMap);
    if (bool2)
    {
      this.n = true;
      new m(this, locala).start();
      return bool2;
    }
    boolean bool1 = bool2;
    try
    {
      HashMap localHashMap = locala.g(this.j);
      bool1 = bool2;
      bool2 = a(locala, localHashMap, paramHashMap);
      if (bool2)
      {
        bool1 = bool2;
        locala.a(this.j, localHashMap);
      }
      bool1 = bool2;
      this.n = true;
      return bool2;
    }
    catch (Throwable paramHashMap)
    {
      d.a().w(paramHashMap);
      this.n = false;
    }
    return bool1;
  }
  
  public Platform[] a()
  {
    long l1 = System.currentTimeMillis();
    Object localObject4;
    synchronized (this.d)
    {
      if (this.a == a.a) {
        return null;
      }
      Object localObject1 = this.a;
      localObject4 = a.b;
      if (localObject1 == localObject4) {}
      try
      {
        this.d.wait();
        ??? = new ArrayList();
        localObject1 = this.d.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject4 = (Platform)((Iterator)localObject1).next();
          if ((localObject4 != null) && (((Platform)localObject4).b()))
          {
            ((Platform)localObject4).a();
            ???.add(localObject4);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          d.a().w(localThrowable);
        }
      }
    }
    Object localObject3 = this.g.entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Platform)((Map.Entry)((Iterator)localObject3).next()).getValue();
      if ((localObject4 != null) && (((Platform)localObject4).b())) {
        ???.add(localObject4);
      }
    }
    if (???.size() <= 0) {
      return null;
    }
    localObject3 = new Platform[???.size()];
    int i1 = 0;
    while (i1 < localObject3.length)
    {
      localObject3[i1] = ((Platform)???.get(i1));
      i1 += 1;
    }
    d.a().i("sort list use time: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    return (Platform[])localObject3;
  }
  
  public Platform b(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return null;
      Platform[] arrayOfPlatform = a();
      if (arrayOfPlatform != null)
      {
        int i2 = arrayOfPlatform.length;
        int i1 = 0;
        while (i1 < i2)
        {
          Platform localPlatform = arrayOfPlatform[i1];
          if (paramString.equals(localPlatform.getName())) {
            return localPlatform;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public String b()
  {
    try
    {
      String str = new i().a();
      return str;
    }
    catch (Throwable localThrowable)
    {
      d.a().w(localThrowable);
    }
    return "2.6.5";
  }
  
  public String b(String paramString1, String paramString2)
  {
    synchronized (this.c)
    {
      paramString1 = (HashMap)this.c.get(paramString1);
      if (paramString1 == null) {
        return null;
      }
      paramString1 = (String)paramString1.get(paramString2);
      return paramString1;
    }
  }
  
  public void b(int paramInt)
  {
    com.mob.tools.network.NetworkHelper.readTimout = paramInt;
  }
  
  public void b(Class<? extends Service> paramClass)
  {
    synchronized (this.i)
    {
      int i1 = paramClass.hashCode();
      if (this.i.containsKey(Integer.valueOf(i1)))
      {
        ((Service)this.i.get(Integer.valueOf(i1))).onUnbind();
        this.i.remove(Integer.valueOf(i1));
      }
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean b(HashMap<String, Object> paramHashMap)
  {
    synchronized (this.h)
    {
      this.h.clear();
      boolean bool = new i().a(paramHashMap, this.h);
      return bool;
    }
  }
  
  public int c()
  {
    try
    {
      int i1 = new i().b();
      return i1;
    }
    catch (Throwable localThrowable)
    {
      d.a().w(localThrowable);
    }
    return 56;
  }
  
  public int c(String paramString)
  {
    synchronized (this.e)
    {
      if (this.e.containsKey(paramString))
      {
        int i1 = ((Integer)this.e.get(paramString)).intValue();
        return i1;
      }
      return 0;
    }
  }
  
  public <T extends Service> T c(Class<T> paramClass)
  {
    synchronized (this.i)
    {
      if (this.a == a.a) {
        return null;
      }
      a locala1 = this.a;
      a locala2 = a.b;
      if (locala1 != locala2) {}
    }
    try
    {
      this.i.wait();
      try
      {
        paramClass = (Service)paramClass.cast(this.i.get(Integer.valueOf(paramClass.hashCode())));
        return paramClass;
      }
      catch (Throwable paramClass)
      {
        d.a().w(paramClass);
      }
      paramClass = finally;
      throw paramClass;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        d.a().w(localThrowable);
      }
    }
    return null;
  }
  
  public String c(int paramInt)
  {
    synchronized (this.f)
    {
      String str = (String)this.f.get(Integer.valueOf(paramInt));
      return str;
    }
  }
  
  public String d(String paramString)
  {
    if (a.c != this.a) {
      return null;
    }
    return new i().a(this.b, paramString);
  }
  
  public void d(Class<? extends CustomPlatform> arg1)
  {
    synchronized (this.g)
    {
      if (this.g.containsKey(Integer.valueOf(???.hashCode()))) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        localCustomPlatform = (CustomPlatform)???.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.b });
        this.g.put(Integer.valueOf(???.hashCode()), localCustomPlatform);
      }
      catch (Throwable ???)
      {
        CustomPlatform localCustomPlatform;
        HashMap localHashMap2;
        d.a().w(???);
        continue;
      }
      synchronized (this.e)
      {
        localHashMap2 = this.f;
        if (localCustomPlatform != null) {}
        try
        {
          if (localCustomPlatform.b())
          {
            this.f.put(Integer.valueOf(localCustomPlatform.getPlatformId()), localCustomPlatform.getName());
            this.e.put(localCustomPlatform.getName(), Integer.valueOf(localCustomPlatform.getPlatformId()));
          }
          return;
        }
        finally {}
        ??? = finally;
        throw ???;
      }
    }
  }
  
  public boolean d()
  {
    return this.m;
  }
  
  public void e(Class<? extends CustomPlatform> arg1)
  {
    int i1 = ???.hashCode();
    synchronized (this.g)
    {
      this.g.remove(Integer.valueOf(i1));
      return;
    }
  }
  
  public boolean e()
  {
    return this.k;
  }
  
  public boolean f()
  {
    synchronized (this.h)
    {
      if ((this.h != null) && (this.h.size() > 0)) {
        return true;
      }
      boolean bool = this.n;
      return bool;
    }
  }
  
  public void g()
  {
    try
    {
      R.clearCache(this.b);
      return;
    }
    catch (Throwable localThrowable)
    {
      d.a().w(localThrowable);
    }
  }
  
  protected void onMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a = a.a;
    this.handler.getLooper().quit();
  }
  
  protected void onStart(Message arg1)
  {
    synchronized (this.i)
    {
      synchronized (this.d)
      {
        try
        {
          k();
          l();
          this.a = a.c;
          this.d.notify();
          this.i.notify();
          j();
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            d.a().w(localThrowable);
          }
        }
      }
    }
  }
  
  protected void onStop(Message arg1)
  {
    synchronized (this.i)
    {
      Iterator localIterator = this.i.entrySet().iterator();
      if (localIterator.hasNext()) {
        ((Service)((Map.Entry)localIterator.next()).getValue()).onUnbind();
      }
    }
    this.i.clear();
    synchronized (this.g)
    {
      this.g.clear();
    }
  }
  
  public void startThread()
  {
    this.a = a.b;
    h();
    d.a(this.b, 60056, this.j);
    super.startThread();
  }
  
  private static enum a
  {
    private a() {}
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */