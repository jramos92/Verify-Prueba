package com.android.volley.toolbox;

import com.android.volley.Cache;
import com.android.volley.Cache.Entry;

public class NoCache
  implements Cache
{
  public void clear() {}
  
  public Cache.Entry get(String paramString)
  {
    return null;
  }
  
  public void initialize() {}
  
  public void invalidate(String paramString, boolean paramBoolean) {}
  
  public void put(String paramString, Cache.Entry paramEntry) {}
  
  public void remove(String paramString) {}
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\android\volley\toolbox\NoCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */