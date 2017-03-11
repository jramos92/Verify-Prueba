package com.mob.commons.logcollector;

import android.content.Context;
import com.mob.tools.utils.SharePrefrenceHelper;

public class d
{
  private static d a;
  private SharePrefrenceHelper b;
  
  private d(Context paramContext)
  {
    this.b = new SharePrefrenceHelper(paramContext.getApplicationContext());
    this.b.open("mob_sdk_exception", 1);
  }
  
  public static d a(Context paramContext)
  {
    if (a == null) {
      a = new d(paramContext);
    }
    return a;
  }
  
  public long a()
  {
    return this.b.getLong("service_time");
  }
  
  public void a(long paramLong)
  {
    this.b.putLong("service_time", Long.valueOf(paramLong));
  }
  
  public void a(String paramString)
  {
    this.b.putString("err_log_filter", paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    SharePrefrenceHelper localSharePrefrenceHelper = this.b;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localSharePrefrenceHelper.putInt("is_upload_err_log", Integer.valueOf(i));
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.b.putBoolean("is_upload_crash", Boolean.valueOf(paramBoolean));
  }
  
  public boolean b()
  {
    return this.b.getInt("is_upload_err_log") == 0;
  }
  
  public void c(boolean paramBoolean)
  {
    this.b.putBoolean("is_upload_sdkerr", Boolean.valueOf(paramBoolean));
  }
  
  public boolean c()
  {
    return this.b.getBoolean("is_upload_crash");
  }
  
  public void d(boolean paramBoolean)
  {
    this.b.putBoolean("is_upload_apperr", Boolean.valueOf(paramBoolean));
  }
  
  public boolean d()
  {
    return this.b.getBoolean("is_upload_sdkerr");
  }
  
  public boolean e()
  {
    return this.b.getBoolean("is_upload_apperr");
  }
  
  public String f()
  {
    return this.b.getString("err_log_filter");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\mob\commons\logcollector\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */