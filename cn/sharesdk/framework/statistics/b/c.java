package cn.sharesdk.framework.statistics.b;

import android.content.Context;

public abstract class c
{
  public long e;
  public String f;
  public String g;
  public String h;
  public int i;
  public String j;
  public int k;
  public String l;
  public String m;
  
  protected abstract String a();
  
  protected abstract void a(long paramLong);
  
  public boolean a(Context paramContext)
  {
    int n = b();
    int i1 = c();
    long l1 = System.currentTimeMillis();
    if (l1 - e() < n) {
      return d() < i1;
    }
    a(l1);
    return true;
  }
  
  protected abstract int b();
  
  public void b(Context paramContext)
  {
    f();
  }
  
  protected abstract int c();
  
  protected abstract long d();
  
  protected abstract long e();
  
  protected abstract void f();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a()).append(':');
    localStringBuilder.append(this.e).append('|');
    localStringBuilder.append(this.f).append('|');
    localStringBuilder.append(this.g).append('|');
    localStringBuilder.append(this.h).append('|');
    localStringBuilder.append(this.i).append('|');
    localStringBuilder.append(this.j).append('|');
    localStringBuilder.append(this.k).append('|');
    localStringBuilder.append(this.l);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\statistics\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */