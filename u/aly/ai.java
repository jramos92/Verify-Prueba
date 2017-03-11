package u.aly;

import org.json.JSONArray;

public class ai
  extends bg
{
  public ai() {}
  
  public ai(String paramString)
    throws Exception
  {
    a(new JSONArray(paramString));
  }
  
  public ai(JSONArray paramJSONArray)
    throws Exception
  {
    a(paramJSONArray);
  }
  
  private void a(JSONArray paramJSONArray)
    throws Exception
  {
    a(paramJSONArray.getString(0));
    a(paramJSONArray.getInt(1));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */