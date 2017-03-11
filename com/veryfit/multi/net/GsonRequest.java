package com.veryfit.multi.net;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class GsonRequest<T>
  extends Request<T>
{
  private int errorCode;
  private String errorMessage;
  private final Class<T> mClazz;
  private final Gson mGson = new Gson();
  private final Map<String, String> mHeaders;
  private final Response.Listener<T> mListener;
  private int state;
  
  public GsonRequest(int paramInt, String paramString, Class<T> paramClass, Map<String, String> paramMap, Response.Listener<T> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString, paramErrorListener);
    this.mClazz = paramClass;
    this.mHeaders = paramMap;
    this.mListener = paramListener;
  }
  
  public GsonRequest(String paramString, Class<T> paramClass, Response.Listener<T> paramListener, Response.ErrorListener paramErrorListener)
  {
    this(0, paramString, paramClass, null, paramListener, paramErrorListener);
  }
  
  protected void deliverResponse(T paramT)
  {
    if (this.mListener != null) {
      this.mListener.onResponse(paramT);
    }
  }
  
  public int getErrorCode()
  {
    return this.errorCode;
  }
  
  public String getErrorMessage()
  {
    return this.errorMessage;
  }
  
  public Gson getGson()
  {
    return this.mGson;
  }
  
  public Map<String, String> getHeaders()
    throws AuthFailureError
  {
    if (this.mHeaders != null) {
      return this.mHeaders;
    }
    return super.getHeaders();
  }
  
  public int getState()
  {
    return this.state;
  }
  
  protected Response<T> parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    try
    {
      String str = new String(paramNetworkResponse.data, HttpHeaderParser.parseCharset(paramNetworkResponse.headers));
      VolleyLog.d("responseBody = %s", new Object[] { str });
      ResponseEntity localResponseEntity = (ResponseEntity)this.mGson.fromJson(str, ResponseEntity.class);
      this.state = localResponseEntity.getState();
      this.errorCode = localResponseEntity.getErrorCode();
      this.errorMessage = localResponseEntity.getErrorMessage();
      paramNetworkResponse = Response.success(this.mGson.fromJson(str, this.mClazz), HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
      return paramNetworkResponse;
    }
    catch (UnsupportedEncodingException paramNetworkResponse)
    {
      return Response.error(new ParseError(paramNetworkResponse));
    }
    catch (JsonSyntaxException paramNetworkResponse) {}
    return Response.error(new ParseError(paramNetworkResponse));
  }
  
  public void setErrorCode(int paramInt)
  {
    this.errorCode = paramInt;
  }
  
  public void setErrorMessage(String paramString)
  {
    this.errorMessage = paramString;
  }
  
  public void setState(int paramInt)
  {
    this.state = paramInt;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\net\GsonRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */