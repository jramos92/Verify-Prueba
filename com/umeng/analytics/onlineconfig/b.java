package com.umeng.analytics.onlineconfig;

import java.util.Locale;
import org.json.JSONObject;
import u.aly.br;
import u.aly.by;

public class b
  extends by
{
  public JSONObject a = null;
  boolean b = false;
  int c = -1;
  int d = -1;
  private final String e = "config_update";
  private final String f = "report_policy";
  private final String g = "online_params";
  private final String h = "report_interval";
  
  public b(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    if (paramJSONObject == null) {
      return;
    }
    a(paramJSONObject);
    a();
  }
  
  private void a()
  {
    if ((this.c < 0) || (this.c > 6)) {
      this.c = 1;
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("config_update")) {
          break;
        }
        if (paramJSONObject.getString("config_update").toLowerCase(Locale.US).equals("no")) {
          return;
        }
        if (paramJSONObject.has("report_policy"))
        {
          this.c = paramJSONObject.getInt("report_policy");
          this.d = (paramJSONObject.optInt("report_interval") * 1000);
          this.a = paramJSONObject.optJSONObject("online_params");
          this.b = true;
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        br.e("MobclickAgent", "fail to parce online config response", paramJSONObject);
        return;
      }
      br.e("MobclickAgent", " online config fetch no report policy");
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\umeng\analytics\onlineconfig\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */