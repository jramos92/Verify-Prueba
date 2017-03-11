package com.veryfit.multi.net;

import android.content.Context;
import android.content.res.Resources;

public class ErrorCodeMap
{
  public static String getErrorMsg(Context paramContext, int paramInt)
  {
    if (paramInt == -1) {
      return paramContext.getResources().getString(2131296695);
    }
    return paramContext.getResources().getStringArray(2131361801)[(paramInt - 10001)];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\veryfit\multi\net\ErrorCodeMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */