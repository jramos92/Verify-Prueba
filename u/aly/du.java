package u.aly;

public abstract class du
{
  public abstract int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws dv;
  
  public void a(int paramInt) {}
  
  public abstract boolean a();
  
  public abstract void b()
    throws dv;
  
  public void b(byte[] paramArrayOfByte)
    throws dv
  {
    b(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public abstract void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws dv;
  
  public abstract void c();
  
  public int d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws dv
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = a(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j <= 0) {
        throw new dv("Cannot read. Remote side has closed. Tried to read " + paramInt2 + " bytes, but only got " + i + " bytes. (This is often indicative of an internal error on the server side. Please check your server logs.)");
      }
      i += j;
    }
    return i;
  }
  
  public void d()
    throws dv
  {}
  
  public byte[] f()
  {
    return null;
  }
  
  public int g()
  {
    return 0;
  }
  
  public int h()
  {
    return -1;
  }
  
  public boolean i()
  {
    return a();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\du.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */