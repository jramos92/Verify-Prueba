package u.aly;

public enum aw
  implements cl
{
  private final int d;
  
  private aw(int paramInt)
  {
    this.d = paramInt;
  }
  
  public static aw a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return a;
    case 1: 
      return b;
    }
    return c;
  }
  
  public int a()
  {
    return this.d;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */