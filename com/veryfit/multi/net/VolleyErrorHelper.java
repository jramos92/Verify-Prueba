package com.veryfit.multi.net;

import android.content.Context;
import android.content.res.Resources;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

public class VolleyErrorHelper
{
  public static String getMessage(VolleyError paramVolleyError, Context paramContext)
  {
    if ((paramVolleyError instanceof TimeoutError)) {
      return paramContext.getResources().getString(2131296696);
    }
    if (isServerProblem(paramVolleyError)) {
      return paramContext.getResources().getString(2131296695);
    }
    if (isNetworkProblem(paramVolleyError)) {
      return paramContext.getResources().getString(2131296632);
    }
    if ((paramVolleyError instanceof ParseError)) {
      return paramContext.getResources().getString(2131296697);
    }
    return null;
  }
  
  public static int getVolleyErrorCode(VolleyError paramVolleyError)
  {
    int i = -1;
    paramVolleyError = paramVolleyError.networkResponse;
    if (paramVolleyError != null) {
      i = paramVolleyError.statusCode;
    }
    return i;
  }
  
  private static boolean isNetworkProblem(VolleyError paramVolleyError)
  {
    return ((paramVolleyError instanceof NetworkError)) || ((paramVolleyError instanceof NoConnectionError));
  }
  
  private static boolean isServerProblem(VolleyError paramVolleyError)
  {
    return ((paramVolleyError instanceof ServerError)) || ((paramVolleyError instanceof AuthFailureError));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\net\VolleyErrorHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */