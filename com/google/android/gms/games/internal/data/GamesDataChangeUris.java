package com.google.android.gms.games.internal.data;

import android.net.Uri;
import android.net.Uri.Builder;

public final class GamesDataChangeUris
{
  private static final Uri zzayY = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
  public static final Uri zzayZ = zzayY.buildUpon().appendPath("invitations").build();
  public static final Uri zzaza = zzayY.buildUpon().appendEncodedPath("players").build();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\data\GamesDataChangeUris.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */