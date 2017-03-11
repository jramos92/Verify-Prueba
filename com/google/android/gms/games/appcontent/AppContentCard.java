package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

public abstract interface AppContentCard
  extends Parcelable, Freezable<AppContentCard>
{
  public abstract List<AppContentAction> getActions();
  
  public abstract String getDescription();
  
  public abstract Bundle getExtras();
  
  public abstract String getId();
  
  public abstract String getTitle();
  
  public abstract String getType();
  
  public abstract List<AppContentCondition> zztP();
  
  public abstract String zztQ();
  
  public abstract List<AppContentAnnotation> zzua();
  
  public abstract int zzub();
  
  public abstract String zzuc();
  
  public abstract int zzud();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */