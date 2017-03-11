package cn.sharesdk.framework.statistics.b;

public class a
  extends c
{
  private static int c;
  private static long d;
  public int a;
  public String b;
  
  protected String a()
  {
    return "[API]";
  }
  
  protected void a(long paramLong)
  {
    d = paramLong;
  }
  
  protected int b()
  {
    return 5000;
  }
  
  protected int c()
  {
    return 50;
  }
  
  protected long d()
  {
    return c;
  }
  
  protected long e()
  {
    return d;
  }
  
  protected void f()
  {
    c += 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(super.toString());
    localStringBuilder.append('|').append(this.a);
    localStringBuilder.append('|').append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\cn\sharesdk\framework\statistics\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */