package com.veryfit.multi.net;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XMLRequest
  extends Request<XmlPullParser>
{
  private final Response.Listener<XmlPullParser> mListener;
  
  public XMLRequest(int paramInt, String paramString, Response.Listener<XmlPullParser> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString, paramErrorListener);
    this.mListener = paramListener;
  }
  
  public XMLRequest(String paramString, Response.Listener<XmlPullParser> paramListener, Response.ErrorListener paramErrorListener)
  {
    this(0, paramString, paramListener, paramErrorListener);
  }
  
  protected void deliverResponse(XmlPullParser paramXmlPullParser)
  {
    if (this.mListener != null) {
      this.mListener.onResponse(paramXmlPullParser);
    }
  }
  
  protected Response<XmlPullParser> parseNetworkResponse(NetworkResponse paramNetworkResponse)
  {
    try
    {
      String str = new String(paramNetworkResponse.data, HttpHeaderParser.parseCharset(paramNetworkResponse.headers));
      XmlPullParser localXmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
      localXmlPullParser.setInput(new StringReader(str));
      paramNetworkResponse = Response.success(localXmlPullParser, HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
      return paramNetworkResponse;
    }
    catch (UnsupportedEncodingException paramNetworkResponse)
    {
      return Response.error(new ParseError(paramNetworkResponse));
    }
    catch (XmlPullParserException paramNetworkResponse) {}
    return Response.error(new ParseError(paramNetworkResponse));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\net\XMLRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */