package com.google.android.gms.games.appcontent;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface AppContentTuple
  extends Parcelable, Freezable<AppContentTuple>
{
  public abstract String getName();
  
  public abstract String getValue();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentTuple.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */