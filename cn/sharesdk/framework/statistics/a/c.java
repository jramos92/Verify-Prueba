package cn.sharesdk.framework.statistics.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class c
{
  private static c c;
  private Context a;
  private SharedPreferences b;
  
  private c(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
    this.b = this.a.getSharedPreferences("share_sdk_1", 0);
  }
  
  public static c a(Context paramContext)
  {
    if (c == null) {
      c = new c(paramContext.getApplicationContext());
    }
    return c;
  }
  
  public long a()
  {
    return this.b.getLong("service_time", 0L);
  }
  
  public String a(String paramString)
  {
    return this.b.getString(paramString, "");
  }
  
  public void a(long paramLong)
  {
    a("device_time", Long.valueOf(paramLong));
  }
  
  public void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  public void a(String paramString, Boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putBoolean(paramString, paramBoolean.booleanValue());
    localEditor.commit();
  }
  
  public void a(String paramString, Long paramLong)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putLong(paramString, paramLong.longValue());
    localEditor.commit();
  }
  
  public void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = this.b.edit();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public void a(boolean paramBoolean)
  {
    a("connect_server", Boolean.valueOf(paramBoolean));
  }
  
  public long b(String paramString)
  {
    return this.b.getLong(paramString, 0L);
  }
  
  public void b(long paramLong)
  {
    a("connect_server_time", Long.valueOf(paramLong));
  }
  
  public void b(String paramString1, String paramString2)
  {
    a("buffered_snsconf_" + paramString1, paramString2);
  }
  
  public boolean b()
  {
    return Boolean.parseBoolean(this.b.getString("upload_device_info", "true"));
  }
  
  public int c(String paramString)
  {
    return this.b.getInt(paramString, 0);
  }
  
  public boolean c()
  {
    return Boolean.parseBoolean(this.b.getString("upload_user_info", "true"));
  }
  
  public void d(String paramString)
  {
    a("trans_short_link", paramString);
  }
  
  public boolean d()
  {
    return Boolean.parseBoolean(this.b.getString("trans_short_link", "false"));
  }
  
  public int e()
  {
    String str = this.b.getString("upload_share_content", "0");
    if ("true".equals(str)) {
      return 1;
    }
    if ("false".equals(str)) {
      return -1;
    }
    return 0;
  }
  
  public void e(String paramString)
  {
    a("upload_device_info", paramString);
  }
  
  public String f()
  {
    return a("device_data");
  }
  
  public void f(String paramString)
  {
    a("upload_user_info", paramString);
  }
  
  public String g()
  {
    return a("device_ext_data");
  }
  
  public void g(String paramString)
  {
    a("upload_share_content", paramString);
  }
  
  public Long h()
  {
    return Long.valueOf(b("device_time"));
  }
  
  public String h(String paramString)
  {
    return a("buffered_snsconf_" + paramString);
  }
  
  public void i(String paramString)
  {
    a("device_data", paramString);
  }
  
  public boolean i()
  {
    return this.b.getBoolean("connect_server", true);
  }
  
  public Long j()
  {
    return Long.valueOf(b("connect_server_time"));
  }
  
  public void j(String paramString)
  {
    a("device_ext_data", paramString);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\statistics\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */