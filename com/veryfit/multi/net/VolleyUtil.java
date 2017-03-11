package com.veryfit.multi.net;

import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Cache.Entry;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class VolleyUtil
{
  private static final String PROTOCOL_CHARSET = "UTF-8";
  private static final int REQUEST_TIMEOUT_MS = 5000;
  private static final String TAG = "VolleyUtil";
  private static VolleyUtil instance;
  private static RequestQueue mRequestQueue;
  private Context mContext;
  
  private VolleyUtil(Context paramContext)
  {
    this.mContext = paramContext;
    mRequestQueue = Volley.newRequestQueue(this.mContext);
  }
  
  public static VolleyUtil getInstance()
  {
    return instance;
  }
  
  public static VolleyUtil init(Context paramContext)
  {
    if (instance == null) {}
    try
    {
      instance = new VolleyUtil(paramContext);
      return instance;
    }
    finally {}
  }
  
  public void addToRequestQueue(Request<?> paramRequest)
  {
    addToRequestQueue(paramRequest, null);
  }
  
  public void addToRequestQueue(Request<?> paramRequest, Object paramObject)
  {
    VolleyLog.d("addToRequestQueue: %s", new Object[] { paramObject + ":" + getUrl(paramRequest) });
    Object localObject = paramObject;
    if (paramObject == null) {
      localObject = "VolleyUtil";
    }
    paramRequest.setTag(localObject);
    mRequestQueue.add(paramRequest);
  }
  
  public void cancel(Request<?> paramRequest)
  {
    paramRequest.cancel();
  }
  
  public void cancelRequestByTag(Object paramObject)
  {
    if (mRequestQueue != null) {
      mRequestQueue.cancelAll(paramObject);
    }
  }
  
  public void doRequest(Request<?> paramRequest, Object paramObject)
  {
    doRequest(paramRequest, paramObject, 2500);
  }
  
  public void doRequest(Request<?> paramRequest, Object paramObject, int paramInt)
  {
    doRequest(paramRequest, paramObject, paramInt, 0, 1.0F);
  }
  
  public void doRequest(Request<?> paramRequest, Object paramObject, int paramInt1, int paramInt2, float paramFloat)
  {
    setTimeOutAndRetrys(paramRequest, paramInt1, paramInt2, paramFloat);
    paramRequest.setTag(paramObject);
    mRequestQueue.add(paramRequest);
  }
  
  public String getCacheKey(Request<?> paramRequest)
  {
    return paramRequest.getCacheKey();
  }
  
  public Cache.Entry getEntry(Request<?> paramRequest)
  {
    return paramRequest.getCacheEntry();
  }
  
  public String getFromDiskCache(String paramString)
  {
    if (mRequestQueue.getCache().get(paramString) != null)
    {
      String str = new String(mRequestQueue.getCache().get(paramString).data);
      VolleyLog.d("url = %s, dataStr = %s", new Object[] { paramString, str });
      return str;
    }
    VolleyLog.d("url = %s", new Object[] { paramString + "--> No cache data in disk." });
    return null;
  }
  
  public String getUrl(Request<?> paramRequest)
  {
    return paramRequest.getUrl();
  }
  
  public boolean isCanceled(Request<?> paramRequest)
  {
    return paramRequest.isCanceled();
  }
  
  public <T> GsonRequest<T> loadGetGson(String paramString, Object paramObject, Class<T> paramClass, AVolleyResponse<T> paramAVolleyResponse)
  {
    cancelRequestByTag(paramObject);
    HashMap localHashMap = new HashMap();
    localHashMap.put("Accept", "*/*");
    localHashMap.put("Charset", "UTF-8");
    localHashMap.put("Content-Type", "application/json");
    paramString = new GsonRequest(0, paramString, paramClass, localHashMap, paramAVolleyResponse.getListener(), paramAVolleyResponse.getErrorListener());
    doRequest(paramString, paramObject, 5000);
    return paramString;
  }
  
  public StringRequest loadGetStr(String paramString, Object paramObject, AVolleyResponse<String> paramAVolleyResponse)
  {
    cancelRequestByTag(paramObject);
    paramString = new StringRequest(0, paramString, paramAVolleyResponse.getListener(), paramAVolleyResponse.getErrorListener());
    doRequest(paramString, paramObject, 5000);
    return paramString;
  }
  
  public XMLRequest loadGetXML(String paramString, Object paramObject, AVolleyResponse<XmlPullParser> paramAVolleyResponse)
  {
    cancelRequestByTag(paramObject);
    paramString = new XMLRequest(paramString, paramAVolleyResponse.getListener(), paramAVolleyResponse.getErrorListener());
    doRequest(paramString, paramObject, 5000);
    return paramString;
  }
  
  public <T> GsonRequest<T> loadPostGson(final String paramString1, Object paramObject, Class<T> paramClass, final String paramString2, AVolleyResponse<T> paramAVolleyResponse)
  {
    cancelRequestByTag(paramObject);
    HashMap localHashMap = new HashMap();
    localHashMap.put("Accept", "*/*");
    localHashMap.put("Charset", "UTF-8");
    localHashMap.put("Content-Type", "application/json");
    paramString1 = new GsonRequest(1, paramString1, paramClass, localHashMap, paramAVolleyResponse.getListener(), paramAVolleyResponse.getErrorListener())
    {
      public byte[] getBody()
      {
        try
        {
          VolleyLog.d(String.format("url: %s\n params: %s", new Object[] { paramString1, paramString2 }), new Object[0]);
          if (paramString2 == null) {
            return null;
          }
          byte[] arrayOfByte = paramString2.getBytes("UTF-8");
          return arrayOfByte;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
        return null;
      }
    };
    doRequest(paramString1, paramObject, 5000);
    return paramString1;
  }
  
  public StringRequest loadPostStr(String paramString, Object paramObject, final Map<String, String> paramMap, AVolleyResponse<String> paramAVolleyResponse)
  {
    cancelRequestByTag(paramObject);
    paramString = new StringRequest(1, paramString, paramAVolleyResponse.getListener(), paramAVolleyResponse.getErrorListener())
    {
      public Map<String, String> getHeaders()
        throws AuthFailureError
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("Accept", "*/*");
        localHashMap.put("Charset", "UTF-8");
        localHashMap.put("Content-Type", "application/json");
        return localHashMap;
      }
      
      protected Map<String, String> getParams()
        throws AuthFailureError
      {
        return paramMap;
      }
    };
    doRequest(paramString, paramObject, 5000);
    return paramString;
  }
  
  public XMLRequest loadPostXML(String paramString, Object paramObject, final Map<String, String> paramMap, AVolleyResponse<XmlPullParser> paramAVolleyResponse)
  {
    cancelRequestByTag(paramObject);
    paramString = new XMLRequest(1, paramString, paramAVolleyResponse.getListener(), paramAVolleyResponse.getErrorListener())
    {
      public Map<String, String> getHeaders()
        throws AuthFailureError
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("Accept", "*/*");
        localHashMap.put("Charset", "UTF-8");
        localHashMap.put("Content-Type", "application/json");
        return localHashMap;
      }
      
      protected Map<String, String> getParams()
        throws AuthFailureError
      {
        return paramMap;
      }
    };
    doRequest(paramString, paramObject, 5000);
    return paramString;
  }
  
  public void setDefaultTimeOut(Request<?> paramRequest)
  {
    setTimeOut(paramRequest, 2500);
  }
  
  public void setShouldCache(Request<?> paramRequest, boolean paramBoolean)
  {
    paramRequest.setShouldCache(paramBoolean);
  }
  
  public void setTimeOut(Request<?> paramRequest, int paramInt)
  {
    setTimeOutAndRetrys(paramRequest, paramInt, 0, 1.0F);
  }
  
  public void setTimeOutAndRetrys(Request<?> paramRequest, int paramInt1, int paramInt2, float paramFloat)
  {
    paramRequest.setRetryPolicy(new DefaultRetryPolicy(paramInt1, paramInt2, paramFloat));
  }
  
  public boolean shouldCache(Request<?> paramRequest)
  {
    return paramRequest.shouldCache();
  }
  
  public void startRequest()
  {
    if (mRequestQueue != null) {
      mRequestQueue.start();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\net\VolleyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */