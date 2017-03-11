package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

public abstract interface AppContentAction
  extends Parcelable, Freezable<AppContentAction>
{
  public abstract Bundle getExtras();
  
  public abstract String getId();
  
  public abstract String getType();
  
  public abstract AppContentAnnotation zztO();
  
  public abstract List<AppContentCondition> zztP();
  
  public abstract String zztQ();
  
  public abstract String zztR();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */