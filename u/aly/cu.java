package u.aly;

import java.io.Serializable;

public class cu
  implements Serializable
{
  private final boolean a;
  public final byte b;
  private final String c;
  private final boolean d;
  
  public cu(byte paramByte)
  {
    this(paramByte, false);
  }
  
  public cu(byte paramByte, String paramString)
  {
    this.b = paramByte;
    this.a = true;
    this.c = paramString;
    this.d = false;
  }
  
  public cu(byte paramByte, boolean paramBoolean)
  {
    this.b = paramByte;
    this.a = false;
    this.c = null;
    this.d = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return this.b == 12;
  }
  
  public boolean d()
  {
    return (this.b == 15) || (this.b == 13) || (this.b == 14);
  }
  
  public boolean e()
  {
    return this.d;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */