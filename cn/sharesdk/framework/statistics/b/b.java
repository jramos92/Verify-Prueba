package cn.sharesdk.framework.statistics.b;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.d;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;

public class b
  extends c
{
  private static int n;
  private static long o;
  public int a;
  public String b;
  public String c;
  public String d;
  
  protected String a()
  {
    return "[AUT]";
  }
  
  protected void a(long paramLong)
  {
    o = paramLong;
  }
  
  protected int b()
  {
    return 5000;
  }
  
  protected int c()
  {
    return 5;
  }
  
  protected long d()
  {
    return n;
  }
  
  protected long e()
  {
    return o;
  }
  
  protected void f()
  {
    n += 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append('|').append(this.a);
    localStringBuilder.append('|').append(this.b);
    localStringBuilder.append('|');
    if (!TextUtils.isEmpty(this.d)) {}
    try
    {
      String str2 = Base64.encodeToString(Data.AES128Encode(this.f.substring(0, 16), this.d), 0);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (str2.contains("\n")) {
          str1 = str2.replace("\n", "");
        }
      }
      localStringBuilder.append(str1);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        d.a().w(localThrowable);
      }
    }
    localStringBuilder.append('|');
    if (!TextUtils.isEmpty(this.m)) {
      localStringBuilder.append(this.m);
    }
    localStringBuilder.append('|');
    if (!TextUtils.isEmpty(this.c)) {
      localStringBuilder.append(this.c);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\statistics\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */