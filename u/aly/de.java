package u.aly;

public final class de
{
  public final String a;
  public final byte b;
  public final int c;
  
  public de()
  {
    this("", (byte)0, 0);
  }
  
  public de(String paramString, byte paramByte, int paramInt)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramInt;
  }
  
  public boolean a(de paramde)
  {
    return (this.a.equals(paramde.a)) && (this.b == paramde.b) && (this.c == paramde.c);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof de)) {
      return a((de)paramObject);
    }
    return false;
  }
  
  public String toString()
  {
    return "<TMessage name:'" + this.a + "' type: " + this.b + " seqid:" + this.c + ">";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */