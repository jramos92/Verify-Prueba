package com.android.volley.toolbox;

import com.android.volley.Cache.Entry;
import com.android.volley.NetworkResponse;
import java.util.Date;
import java.util.Map;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

public class HttpHeaderParser
{
  public static Cache.Entry parseCacheHeaders(NetworkResponse paramNetworkResponse)
  {
    long l10 = System.currentTimeMillis();
    Map localMap = paramNetworkResponse.headers;
    long l3 = 0L;
    long l8 = 0L;
    long l9 = 0L;
    long l6 = 0L;
    long l7 = 0L;
    l4 = 0L;
    l5 = 0L;
    int i = 0;
    int j = 0;
    int m = 0;
    Object localObject1 = (String)localMap.get("Date");
    if (localObject1 != null) {
      l3 = parseDateAsEpoch((String)localObject1);
    }
    localObject1 = (String)localMap.get("Cache-Control");
    l1 = l4;
    l2 = l5;
    if (localObject1 != null)
    {
      int k = 1;
      localObject1 = ((String)localObject1).split(",");
      j = 0;
      l2 = l5;
      l1 = l4;
      i = m;
      if (j >= localObject1.length)
      {
        j = i;
        i = k;
      }
    }
    else
    {
      localObject1 = (String)localMap.get("Expires");
      l5 = l9;
      if (localObject1 != null) {
        l5 = parseDateAsEpoch((String)localObject1);
      }
      localObject1 = (String)localMap.get("Last-Modified");
      l4 = l8;
      if (localObject1 != null) {
        l4 = parseDateAsEpoch((String)localObject1);
      }
      localObject1 = (String)localMap.get("ETag");
      if (i == 0) {
        break label451;
      }
      l5 = l10 + 1000L * l1;
      if (j == 0) {
        break label433;
      }
      l1 = l5;
      l2 = l5;
      label228:
      localObject2 = new Cache.Entry();
      ((Cache.Entry)localObject2).data = paramNetworkResponse.data;
      ((Cache.Entry)localObject2).etag = ((String)localObject1);
      ((Cache.Entry)localObject2).softTtl = l2;
      ((Cache.Entry)localObject2).ttl = l1;
      ((Cache.Entry)localObject2).serverDate = l3;
      ((Cache.Entry)localObject2).lastModified = l4;
      ((Cache.Entry)localObject2).responseHeaders = localMap;
      return (Cache.Entry)localObject2;
    }
    Object localObject2 = localObject1[j].trim();
    if ((((String)localObject2).equals("no-cache")) || (((String)localObject2).equals("no-store"))) {
      return null;
    }
    if (((String)localObject2).startsWith("max-age=")) {}
    for (;;)
    {
      try
      {
        l4 = Long.parseLong(((String)localObject2).substring(8));
        l5 = l2;
      }
      catch (Exception localException2)
      {
        label433:
        label451:
        l4 = l1;
        l5 = l2;
        continue;
      }
      j += 1;
      l1 = l4;
      l2 = l5;
      break;
      if (((String)localObject2).startsWith("stale-while-revalidate=")) {}
      try
      {
        l5 = Long.parseLong(((String)localObject2).substring(23));
        l4 = l1;
      }
      catch (Exception localException1)
      {
        l4 = l1;
        l5 = l2;
      }
      if (!((String)localObject2).equals("must-revalidate"))
      {
        l4 = l1;
        l5 = l2;
        if (!((String)localObject2).equals("proxy-revalidate")) {}
      }
      else
      {
        i = 1;
        l4 = l1;
        l5 = l2;
        continue;
        l1 = l5 + 1000L * l2;
        l2 = l5;
        break label228;
        l1 = l7;
        l2 = l6;
        if (l3 <= 0L) {
          break label228;
        }
        l1 = l7;
        l2 = l6;
        if (l5 < l3) {
          break label228;
        }
        l2 = l10 + (l5 - l3);
        l1 = l2;
        break label228;
      }
    }
  }
  
  public static String parseCharset(Map<String, String> paramMap)
  {
    return parseCharset(paramMap, "UTF-8");
  }
  
  public static String parseCharset(Map<String, String> paramMap, String paramString)
  {
    paramMap = (String)paramMap.get("Content-Type");
    int i;
    if (paramMap != null)
    {
      paramMap = paramMap.split(";");
      i = 1;
    }
    for (;;)
    {
      if (i >= paramMap.length) {
        return paramString;
      }
      String[] arrayOfString = paramMap[i].trim().split("=");
      if ((arrayOfString.length == 2) && (arrayOfString[0].equals("charset"))) {
        return arrayOfString[1];
      }
      i += 1;
    }
  }
  
  public static long parseDateAsEpoch(String paramString)
  {
    try
    {
      long l = DateUtils.parseDate(paramString).getTime();
      return l;
    }
    catch (DateParseException paramString) {}
    return 0L;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\android\volley\toolbox\HttpHeaderParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */