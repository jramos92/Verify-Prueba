package u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ah
  extends av
  implements q
{
  public ah(String paramString, Map<String, Object> paramMap)
  {
    a(paramString);
    b(System.currentTimeMillis());
    if (paramMap.size() > 0) {
      a(b(paramMap));
    }
    if (this.d > 0) {}
    for (int i = this.d;; i = 1)
    {
      a(i);
      return;
    }
  }
  
  private HashMap<String, bh> b(Map<String, Object> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    HashMap localHashMap = new HashMap();
    int i = 0;
    label207:
    while ((i < 10) && (paramMap.hasNext()))
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      bh localbh = new bh();
      Object localObject = localEntry.getValue();
      if ((localObject instanceof String)) {
        localbh.b((String)localObject);
      }
      for (;;)
      {
        if (!localbh.k()) {
          break label207;
        }
        localHashMap.put(localEntry.getKey(), localbh);
        i += 1;
        break;
        if ((localObject instanceof Long)) {
          localbh.b(((Long)localObject).longValue());
        } else if ((localObject instanceof Integer)) {
          localbh.b(((Integer)localObject).longValue());
        } else if ((localObject instanceof Float)) {
          localbh.b(((Float)localObject).longValue());
        } else if ((localObject instanceof Double)) {
          localbh.b(((Double)localObject).longValue());
        }
      }
    }
    return localHashMap;
  }
  
  public void a(bn parambn, String paramString)
  {
    Object localObject;
    bc localbc;
    if (parambn.s() > 0)
    {
      localObject = parambn.u().iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localbc = (bc)((Iterator)localObject).next();
      } while (!paramString.equals(localbc.c()));
    }
    for (;;)
    {
      localObject = localbc;
      if (localbc == null)
      {
        localObject = new bc();
        ((bc)localObject).a(paramString);
        parambn.a((bc)localObject);
      }
      ((bc)localObject).b(this);
      return;
      localbc = null;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\u\aly\ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */