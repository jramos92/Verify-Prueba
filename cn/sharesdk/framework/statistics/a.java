package cn.sharesdk.framework.statistics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.statistics.b.f;
import cn.sharesdk.framework.statistics.b.f.a;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.R;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

public class a
{
  private static a a;
  private c b;
  private cn.sharesdk.framework.statistics.a.c c;
  private boolean d;
  
  private a(Context paramContext)
  {
    this.b = new c(paramContext);
    this.c = cn.sharesdk.framework.statistics.a.c.a(paramContext);
  }
  
  public static a a(Context paramContext)
  {
    if (a == null) {
      a = new a(paramContext);
    }
    return a;
  }
  
  private String a(Bitmap paramBitmap, b paramb)
  {
    File localFile = File.createTempFile("bm_tmp", ".png");
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localFileOutputStream);
    localFileOutputStream.flush();
    localFileOutputStream.close();
    return a(localFile.getAbsolutePath(), paramb);
  }
  
  private String a(String paramString, b paramb)
  {
    if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
      return null;
    }
    Bitmap.CompressFormat localCompressFormat = BitmapHelper.getBmpFormat(paramString);
    float f = 200.0F;
    if (paramb == b.b) {
      f = 600.0F;
    }
    paramb = new BitmapFactory.Options();
    paramb.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, paramb);
    paramb.inJustDecodeBounds = false;
    int i = paramb.outWidth;
    int j = paramb.outHeight;
    if ((i >= j) && (j > f)) {}
    for (i = (int)Math.ceil(paramb.outHeight / f);; i = (int)Math.ceil(paramb.outWidth / f))
    {
      j = i;
      if (i <= 0) {
        j = 1;
      }
      paramb = new BitmapFactory.Options();
      paramb.inSampleSize = j;
      paramb.inPurgeable = true;
      paramb.inInputShareable = true;
      paramString = BitmapFactory.decodeFile(paramString, paramb);
      paramString.getHeight();
      paramString.getWidth();
      paramb = File.createTempFile("bm_tmp2", "." + localCompressFormat.name().toLowerCase());
      FileOutputStream localFileOutputStream = new FileOutputStream(paramb);
      paramString.compress(localCompressFormat, 80, localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      return h(paramb.getAbsolutePath());
      if ((i >= j) || (i <= f)) {
        break;
      }
    }
    return h(paramString);
  }
  
  private String a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        return paramString1;
        localObject1 = new ArrayList();
        paramString3 = Pattern.compile(paramString3);
        localObject2 = paramString3.matcher(paramString1);
        while (((Matcher)localObject2).find())
        {
          String str = ((Matcher)localObject2).group();
          if ((str != null) && (str.length() > 0)) {
            ((ArrayList)localObject1).add(str);
          }
        }
      } while (((ArrayList)localObject1).size() == 0);
      paramString2 = this.b.a(paramString1, paramString2, (ArrayList)localObject1, paramInt, paramString4);
    } while ((paramString2 == null) || (paramString2.size() <= 0) || (!paramString2.containsKey("data")));
    paramString4 = (ArrayList)paramString2.get("data");
    paramString2 = new HashMap();
    paramString4 = paramString4.iterator();
    while (paramString4.hasNext())
    {
      localObject1 = (HashMap)paramString4.next();
      localObject2 = String.valueOf(((HashMap)localObject1).get("surl"));
      paramString2.put(String.valueOf(((HashMap)localObject1).get("source")), localObject2);
    }
    paramString3 = paramString3.matcher(paramString1);
    paramString4 = new StringBuilder();
    for (paramInt = 0; paramString3.find(); paramInt = paramString3.end())
    {
      paramString4.append(paramString1.substring(paramInt, paramString3.start()));
      paramString4.append((String)paramString2.get(paramString3.group()));
    }
    paramString4.append(paramString1.substring(paramInt, paramString1.length()));
    paramString1 = paramString4.toString();
    cn.sharesdk.framework.utils.d.a().i("> SERVER_SHORT_LINK_URL content after replace link ===  %s", new Object[] { paramString1 });
    return paramString1;
  }
  
  private void a(cn.sharesdk.framework.statistics.b.b paramb)
  {
    boolean bool = this.c.c();
    String str = paramb.c;
    if ((bool) && (!TextUtils.isEmpty(str)))
    {
      paramb.c = Data.Base64AES(str, paramb.f.substring(0, 16));
      return;
    }
    paramb.d = null;
    paramb.c = null;
  }
  
  private void a(f paramf)
  {
    int k = 0;
    int i = this.c.e();
    boolean bool = this.c.c();
    f.a locala = paramf.d;
    int j;
    String str;
    if ((i == 1) || ((i == 0) && (this.d)))
    {
      if ((locala == null) || (locala.e == null)) {}
      for (i = 0;; i = locala.e.size())
      {
        j = 0;
        while (j < i)
        {
          str = a((String)locala.e.get(j), b.a);
          if (!TextUtils.isEmpty(str)) {
            locala.d.add(str);
          }
          j += 1;
        }
      }
      if ((locala == null) || (locala.f == null))
      {
        i = 0;
        j = k;
      }
    }
    while (j < i)
    {
      str = a((Bitmap)locala.f.get(j), b.a);
      if (!TextUtils.isEmpty(str)) {
        locala.d.add(str);
      }
      j += 1;
      continue;
      i = locala.f.size();
      j = k;
      continue;
      paramf.d = null;
    }
    if (!bool) {
      paramf.n = null;
    }
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    try
    {
      this.b.a(paramString, paramBoolean);
      return true;
    }
    catch (Exception paramString)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString);
    }
    return false;
  }
  
  private String h(String paramString)
  {
    paramString = this.b.d(paramString);
    if ((paramString == null) || (paramString.size() <= 0)) {}
    while ((!paramString.containsKey("status")) || (R.parseInt(String.valueOf(paramString.get("status"))) != 200) || (!paramString.containsKey("url"))) {
      return null;
    }
    return (String)paramString.get("url");
  }
  
  private String i(String paramString)
  {
    paramString = new ByteArrayInputStream(paramString.getBytes());
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject = new GZIPOutputStream(localByteArrayOutputStream);
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramString.read(arrayOfByte, 0, 1024);
      if (i == -1) {
        break;
      }
      ((GZIPOutputStream)localObject).write(arrayOfByte, 0, i);
    }
    ((GZIPOutputStream)localObject).flush();
    ((GZIPOutputStream)localObject).close();
    localObject = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    paramString.close();
    return Base64.encodeToString((byte[])localObject, 2);
  }
  
  public String a(Bitmap paramBitmap)
  {
    try
    {
      paramBitmap = a(paramBitmap, b.b);
      return paramBitmap;
    }
    catch (Throwable paramBitmap)
    {
      cn.sharesdk.framework.utils.d.a().w(paramBitmap);
    }
    return null;
  }
  
  public String a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, String paramString3)
  {
    try
    {
      if (this.c.i())
      {
        if (!this.c.d()) {
          return paramString1;
        }
        if (paramBoolean)
        {
          String str = a(paramString1, paramString2, "<a[^>]*?href[\\s]*=[\\s]*[\"']?([^'\">]+?)['\"]?>", paramInt, paramString3);
          if ((str != null) && (!str.equals(paramString1))) {
            return str;
          }
        }
        paramString2 = a(paramString1, paramString2, "(http://|https://){1}[\\w\\.\\-/:\\?&%=,;\\[\\]\\{\\}`~!@#\\$\\^\\*\\(\\)_\\+\\\\\\|]+", paramInt, paramString3);
        if (paramString2 != null)
        {
          paramBoolean = paramString2.equals(paramString1);
          if (!paramBoolean) {
            return paramString2;
          }
        }
      }
    }
    catch (Throwable paramString2)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString2);
    }
    return paramString1;
  }
  
  public HashMap<String, Object> a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = this.b.b(paramString1, paramString2);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString1);
    }
    return new HashMap();
  }
  
  public void a()
  {
    for (;;)
    {
      int i;
      try
      {
        if (!this.c.i()) {
          return;
        }
        ArrayList localArrayList = this.b.d();
        i = 0;
        if (i < localArrayList.size())
        {
          cn.sharesdk.framework.statistics.a.d locald = (cn.sharesdk.framework.statistics.a.d)localArrayList.get(i);
          boolean bool;
          if (locald.b.size() == 1)
          {
            bool = a(locald.a, false);
            if (bool) {
              this.b.a(locald.b);
            }
          }
          else
          {
            bool = a(i(locald.a), true);
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        cn.sharesdk.framework.utils.d.a().w(localThrowable);
      }
      i += 1;
    }
  }
  
  public void a(cn.sharesdk.framework.statistics.b.c paramc)
  {
    for (;;)
    {
      try
      {
        if (!this.c.i()) {
          return;
        }
        if ((paramc instanceof cn.sharesdk.framework.statistics.b.b))
        {
          a((cn.sharesdk.framework.statistics.b.b)paramc);
          if (!this.c.b()) {
            paramc.m = null;
          }
          long l2 = this.c.a();
          long l1 = l2;
          if (l2 == 0L) {
            l1 = this.b.a();
          }
          paramc.e = (System.currentTimeMillis() - l1);
          this.b.a(paramc);
          return;
        }
      }
      catch (Throwable paramc)
      {
        cn.sharesdk.framework.utils.d.a().w(paramc);
        return;
      }
      if ((paramc instanceof f)) {
        a((f)paramc);
      }
    }
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        long l1 = this.c.j().longValue();
        long l2 = System.currentTimeMillis();
        Calendar localCalendar = Calendar.getInstance();
        localCalendar.setTimeInMillis(l1);
        int i = localCalendar.get(5);
        localCalendar.setTimeInMillis(l2);
        int j = localCalendar.get(5);
        if ((l2 - l1 < 86400000L) && (i == j)) {
          return;
        }
        paramString = this.b.a(paramString);
        if (paramString.containsKey("res"))
        {
          bool = "true".equals(String.valueOf(paramString.get("res")));
          this.c.a(bool);
          if ((paramString == null) || (paramString.size() <= 0)) {
            break;
          }
          this.c.b(System.currentTimeMillis());
          return;
        }
      }
      catch (Throwable paramString)
      {
        cn.sharesdk.framework.utils.d.a().w(paramString);
        return;
      }
      boolean bool = true;
    }
  }
  
  public void a(String paramString, ArrayList<HashMap<String, String>> paramArrayList)
  {
    try
    {
      if (!this.c.i()) {
        return;
      }
      this.b.a(paramString, paramArrayList);
      return;
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString);
    }
  }
  
  public void a(String paramString, HashMap<String, Object> paramHashMap)
  {
    try
    {
      this.b.b(paramString, paramHashMap);
      return;
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void b(String paramString)
  {
    try
    {
      if (!this.c.i()) {
        return;
      }
      this.c.a(System.currentTimeMillis());
      paramString = this.b.b(paramString);
      if ((paramString.containsKey("status")) && (R.parseInt(String.valueOf(paramString.get("status"))) == 65336))
      {
        cn.sharesdk.framework.utils.d.a().d((String)paramString.get("error"), new Object[0]);
        return;
      }
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString);
      return;
    }
    if (paramString.containsKey("timestamp"))
    {
      long l1 = R.parseLong(String.valueOf(paramString.get("timestamp")));
      long l2 = System.currentTimeMillis();
      this.c.a("service_time", Long.valueOf(l2 - l1));
    }
    String str1;
    if (paramString.containsKey("switchs"))
    {
      Object localObject = (HashMap)paramString.get("switchs");
      if (localObject != null)
      {
        str1 = String.valueOf(((HashMap)localObject).get("device"));
        String str2 = String.valueOf(((HashMap)localObject).get("share"));
        String str3 = String.valueOf(((HashMap)localObject).get("auth"));
        localObject = String.valueOf(((HashMap)localObject).get("backflow"));
        this.c.e(str1);
        this.c.g(str2);
        this.c.f(str3);
        this.c.d((String)localObject);
      }
    }
    if ((paramString.containsKey("requesthost")) && (paramString.containsKey("requestport")))
    {
      str1 = String.valueOf(paramString.get("requesthost"));
      paramString = String.valueOf(paramString.get("requestport"));
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(paramString))) {
        this.b.c("http://" + str1 + ":" + paramString);
      }
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      if (!this.c.i()) {
        return;
      }
      String str1 = this.c.f();
      HashMap localHashMap = this.b.b();
      String str2 = String.valueOf(localHashMap);
      if (!str2.equals(str1))
      {
        this.c.i(str2);
        this.b.a(paramString, localHashMap);
        return;
      }
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString);
    }
  }
  
  public void d(String paramString)
  {
    try
    {
      if (!this.c.i()) {
        return;
      }
      String str1 = this.c.g();
      String str2 = Data.Base64AES(this.b.c(), "sdk.sharesdk.sdk");
      if (!str2.equals(str1))
      {
        this.c.j(str2);
        this.b.a(paramString, str2);
        return;
      }
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString);
    }
  }
  
  public String e(String paramString)
  {
    try
    {
      paramString = a(paramString, b.b);
      return paramString;
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString);
    }
    return null;
  }
  
  public HashMap<String, Object> f(String paramString)
  {
    try
    {
      paramString = this.b.f(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString);
    }
    return new HashMap();
  }
  
  public HashMap<String, Object> g(String paramString)
  {
    try
    {
      paramString = this.b.e(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      cn.sharesdk.framework.utils.d.a().w(paramString);
    }
    return new HashMap();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\statistics\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */