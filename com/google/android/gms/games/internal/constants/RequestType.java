package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;

public final class RequestType
{
  public static String zzfZ(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      GamesLog.zzz("RequestType", "Unknown request type: " + paramInt);
      return "UNKNOWN_TYPE";
    case 1: 
      return "GIFT";
    }
    return "WISH";
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\constants\RequestType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */