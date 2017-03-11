package com.android.volley;

import java.util.Collections;
import java.util.Map;

public abstract interface Cache
{
  public abstract void clear();
  
  public abstract Entry get(String paramString);
  
  public abstract void initialize();
  
  public abstract void invalidate(String paramString, boolean paramBoolean);
  
  public abstract void put(String paramString, Entry paramEntry);
  
  public abstract void remove(String paramString);
  
  public static class Entry
  {
    public byte[] data;
    public String etag;
    public long lastModified;
    public Map<String, String> responseHeaders = Collections.emptyMap();
    public long serverDate;
    public long softTtl;
    public long ttl;
    
    public boolean isExpired()
    {
      return this.ttl < System.currentTimeMillis();
    }
    
    public boolean refreshNeeded()
    {
      return this.softTtl < System.currentTimeMillis();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\android\volley\Cache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */