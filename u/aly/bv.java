package u.aly;

import org.json.JSONObject;

public class bv
  extends by
{
  public a a;
  
  public bv(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    if (("ok".equalsIgnoreCase(paramJSONObject.optString("status"))) || ("ok".equalsIgnoreCase(paramJSONObject.optString("success"))))
    {
      this.a = a.a;
      return;
    }
    this.a = a.b;
  }
  
  public static enum a {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */