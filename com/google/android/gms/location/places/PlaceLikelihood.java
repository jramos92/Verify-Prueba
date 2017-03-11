package com.google.android.gms.location.places;

import com.google.android.gms.common.data.Freezable;

public abstract interface PlaceLikelihood
  extends Freezable<PlaceLikelihood>
{
  public abstract float getLikelihood();
  
  public abstract Place getPlace();
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\PlaceLikelihood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */