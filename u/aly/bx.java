package u.aly;

import org.json.JSONObject;

public abstract class bx
{
  protected static String b = "POST";
  protected static String c = "GET";
  protected String d;
  
  public bx(String paramString)
  {
    this.d = paramString;
  }
  
  public abstract JSONObject a();
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public abstract String b();
  
  protected String c()
  {
    return b;
  }
  
  public String d()
  {
    return this.d;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */