package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AppContentsImpl
  implements AppContents
{
  private static abstract class LoadsImpl
    extends Games.BaseGamesApiMethodImpl<AppContents.LoadAppContentResult>
  {
    public AppContents.LoadAppContentResult zzaa(final Status paramStatus)
    {
      new AppContents.LoadAppContentResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\api\AppContentsImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */