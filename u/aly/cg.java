package u.aly;

public class cg
  extends cn
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  private static final dl j = new dl("TApplicationException");
  private static final db k = new db("message", (byte)11, (short)1);
  private static final db l = new db("type", (byte)8, (short)2);
  private static final long m = 1L;
  protected int i = 0;
  
  public cg() {}
  
  public cg(int paramInt)
  {
    this.i = paramInt;
  }
  
  public cg(int paramInt, String paramString)
  {
    super(paramString);
    this.i = paramInt;
  }
  
  public cg(String paramString)
  {
    super(paramString);
  }
  
  public static cg a(dg paramdg)
    throws cn
  {
    paramdg.j();
    String str = null;
    int n = 0;
    db localdb = paramdg.l();
    if (localdb.b == 0)
    {
      paramdg.k();
      return new cg(n, str);
    }
    switch (localdb.c)
    {
    default: 
      dj.a(paramdg, localdb.b);
    }
    for (;;)
    {
      paramdg.m();
      break;
      if (localdb.b == 11)
      {
        str = paramdg.z();
      }
      else
      {
        dj.a(paramdg, localdb.b);
        continue;
        if (localdb.b == 8) {
          n = paramdg.w();
        } else {
          dj.a(paramdg, localdb.b);
        }
      }
    }
  }
  
  public int a()
  {
    return this.i;
  }
  
  public void b(dg paramdg)
    throws cn
  {
    paramdg.a(j);
    if (getMessage() != null)
    {
      paramdg.a(k);
      paramdg.a(getMessage());
      paramdg.c();
    }
    paramdg.a(l);
    paramdg.a(this.i);
    paramdg.c();
    paramdg.d();
    paramdg.b();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */