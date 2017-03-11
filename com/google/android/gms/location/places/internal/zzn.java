package com.google.android.gms.location.places.internal;

import android.content.Context;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

public class zzn
  extends zzu
  implements PlaceLikelihood
{
  private final Context mContext;
  
  public zzn(DataHolder paramDataHolder, int paramInt, Context paramContext)
  {
    super(paramDataHolder, paramInt);
    this.mContext = paramContext;
  }
  
  public float getLikelihood()
  {
    return zzb("place_likelihood", -1.0F);
  }
  
  public Place getPlace()
  {
    return new zzs(this.zzabq, this.zzadl, this.mContext);
  }
  
  public PlaceLikelihood zzxo()
  {
    return PlaceLikelihoodEntity.zza((PlaceImpl)getPlace().freeze(), getLikelihood());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\internal\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */