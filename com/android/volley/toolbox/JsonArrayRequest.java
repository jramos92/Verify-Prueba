package com.android.volley.toolbox;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonArrayRequest
  extends JsonRequest<JSONArray>
{
  public JsonArrayRequest(int paramInt, String paramString, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString, null, paramListener, paramErrorListener);
  }
  
  public JsonArrayRequest(int paramInt, String paramString1, String paramString2, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString1, paramString2, paramListener, paramErrorListener);
  }
  
  public JsonArrayRequest(int paramInt, String paramString, JSONArray paramJSONArray, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener) {}
  
  public JsonArrayRequest(int paramInt, String paramString, JSONObject paramJSONObject, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener) {}
  
  public JsonArrayRequest(String paramString, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(0, paramString, null, paramListener, paramErrorListener);
  }
  
  public JsonArrayRequest(String paramString, JSONArray paramJSONArray, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener) {}
  
  public JsonArrayRequest(String paramString, JSONObject paramJSONObject, Response.Listener<JSONArray> paramListener, Response.ErrorListener paramErrorListener) {}
  
  protected Response<JSONArray> parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    try
    {
      paramNetworkResponse = Response.success(new JSONArray(new String(paramNetworkResponse.data, HttpHeaderParser.parseCharset(paramNetworkResponse.headers, "utf-8"))), HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
      return paramNetworkResponse;
    }
    catch (UnsupportedEncodingException paramNetworkResponse)
    {
      return Response.error(new ParseError(paramNetworkResponse));
    }
    catch (JSONException paramNetworkResponse) {}
    return Response.error(new ParseError(paramNetworkResponse));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\android\volley\toolbox\JsonArrayRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */