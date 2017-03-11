package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface AppContentAnnotation
  extends Parcelable, Freezable<AppContentAnnotation>
{
  public abstract String getDescription();
  
  public abstract String getId();
  
  public abstract String getTitle();
  
  public abstract String zztT();
  
  public abstract int zztU();
  
  public abstract Uri zztV();
  
  public abstract Bundle zztW();
  
  public abstract int zztX();
  
  public abstract String zztY();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentAnnotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */