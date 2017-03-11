package com.veryfit.multi.net;

import android.content.Context;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;

public abstract class AVolleyResponse<T>
{
  private Context mContext;
  
  public AVolleyResponse(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public Response.ErrorListener getErrorListener()
  {
    new Response.ErrorListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        VolleyLog.e("====== volleyErrorCode = %d ,volleyErrorMsg = %s", new Object[] { Integer.valueOf(VolleyErrorHelper.getVolleyErrorCode(paramAnonymousVolleyError)), paramAnonymousVolleyError.getMessage() });
        AVolleyResponse.this.onError(paramAnonymousVolleyError, VolleyErrorHelper.getMessage(paramAnonymousVolleyError, AVolleyResponse.this.mContext));
      }
    };
  }
  
  public Response.Listener<T> getListener()
  {
    new Response.Listener()
    {
      public void onResponse(T paramAnonymousT)
      {
        AVolleyResponse.this.onSuccess(paramAnonymousT);
      }
    };
  }
  
  public abstract void onError(VolleyError paramVolleyError, String paramString);
  
  public abstract void onSuccess(T paramT);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\net\AVolleyResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */