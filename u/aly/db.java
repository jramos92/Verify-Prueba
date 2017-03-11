package u.aly;

public class db
{
  public final String a;
  public final byte b;
  public final short c;
  
  public db()
  {
    this("", (byte)0, (short)0);
  }
  
  public db(String paramString, byte paramByte, short paramShort)
  {
    this.a = paramString;
    this.b = paramByte;
    this.c = paramShort;
  }
  
  public boolean a(db paramdb)
  {
    return (this.b == paramdb.b) && (this.c == paramdb.c);
  }
  
  public String toString()
  {
    return "<TField name:'" + this.a + "' type:" + this.b + " field-id:" + this.c + ">";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\db.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */