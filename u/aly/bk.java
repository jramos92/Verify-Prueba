package u.aly;

public enum bk
  implements cl
{
  private final int e;
  
  private bk(int paramInt)
  {
    this.e = paramInt;
  }
  
  public static bk a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 0: 
      return a;
    case 1: 
      return b;
    case 2: 
      return c;
    }
    return d;
  }
  
  public int a()
  {
    return this.e;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */