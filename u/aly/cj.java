package u.aly;

import java.io.ByteArrayOutputStream;

public class cj
  extends ByteArrayOutputStream
{
  public cj() {}
  
  public cj(int paramInt)
  {
    super(paramInt);
  }
  
  public byte[] a()
  {
    return this.buf;
  }
  
  public int b()
  {
    return this.count;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */