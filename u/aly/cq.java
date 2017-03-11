package u.aly;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class cq
{
  private final ByteArrayOutputStream a = new ByteArrayOutputStream();
  private final ds b = new ds(this.a);
  private dg c;
  
  public cq()
  {
    this(new da.a());
  }
  
  public cq(di paramdi)
  {
    this.c = paramdi.a(this.b);
  }
  
  public String a(ch paramch, String paramString)
    throws cn
  {
    try
    {
      paramch = new String(a(paramch), paramString);
      return paramch;
    }
    catch (UnsupportedEncodingException paramch)
    {
      throw new cn("JVM DOES NOT SUPPORT ENCODING: " + paramString);
    }
  }
  
  public byte[] a(ch paramch)
    throws cn
  {
    this.a.reset();
    paramch.b(this.c);
    return this.a.toByteArray();
  }
  
  public String b(ch paramch)
    throws cn
  {
    return new String(a(paramch));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\cq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */