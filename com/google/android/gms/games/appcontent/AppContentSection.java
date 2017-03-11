package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

public abstract interface AppContentSection
  extends Parcelable, Freezable<AppContentSection>
{
  public abstract List<AppContentAction> getActions();
  
  public abstract Bundle getExtras();
  
  public abstract String getId();
  
  public abstract String getTitle();
  
  public abstract String getType();
  
  public abstract String zztQ();
  
  public abstract List<AppContentAnnotation> zzua();
  
  public abstract String zzuc();
  
  public abstract List<AppContentCard> zzuk();
  
  public abstract String zzul();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */