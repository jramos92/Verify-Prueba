package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class m
{
  private final String a = "umeng_event_snapshot";
  private boolean b = false;
  private SharedPreferences c;
  private Map<String, ArrayList<ae>> d = new HashMap();
  
  public m(Context paramContext)
  {
    this.c = x.a(paramContext, "umeng_event_snapshot");
  }
  
  private void c(String paramString)
  {
    Object localObject = null;
    if (this.d.containsKey(paramString))
    {
      localObject = (ArrayList)this.d.get(paramString);
      while (((ArrayList)localObject).size() > 4) {
        ((ArrayList)localObject).remove(0);
      }
      localObject = u.a((Serializable)localObject);
    }
    this.c.edit().putString(paramString, (String)localObject).commit();
  }
  
  private boolean d(String paramString)
  {
    if (this.d.containsKey(paramString)) {
      return true;
    }
    Object localObject = this.c.getString(paramString, null);
    if (localObject != null)
    {
      localObject = (ArrayList)u.a((String)localObject);
      if (localObject != null)
      {
        this.d.put(paramString, localObject);
        return true;
      }
    }
    return false;
  }
  
  public int a(String paramString)
  {
    if (this.d.containsKey(paramString)) {
      return ((ArrayList)this.d.get(paramString)).size();
    }
    return 0;
  }
  
  public void a(String paramString, ae paramae)
  {
    if (this.b) {
      d(paramString);
    }
    if (this.d.containsKey(paramString)) {
      ((ArrayList)this.d.get(paramString)).add(paramae);
    }
    for (;;)
    {
      if (this.b) {
        c(paramString);
      }
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramae);
      this.d.put(paramString, localArrayList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public ae b(String paramString)
  {
    if (this.b) {
      d(paramString);
    }
    if (this.d.containsKey(paramString))
    {
      localObject = (ArrayList)this.d.get(paramString);
      if (((ArrayList)localObject).size() <= 0) {}
    }
    for (Object localObject = (ae)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);; localObject = null)
    {
      if (this.b) {
        c(paramString);
      }
      return (ae)localObject;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */