package com.google.android.gms.location.places.personalized;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.PlacesStatusCodes;

public final class zzd
  extends com.google.android.gms.common.data.zzd<PlaceUserData>
  implements Result
{
  private final Status zzSC;
  
  public zzd(DataHolder paramDataHolder)
  {
    this(paramDataHolder, PlacesStatusCodes.zzhp(paramDataHolder.getStatusCode()));
  }
  
  private zzd(DataHolder paramDataHolder, Status paramStatus)
  {
    super(paramDataHolder, PlaceUserData.CREATOR);
    if ((paramDataHolder == null) || (paramDataHolder.getStatusCode() == paramStatus.getStatusCode())) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzaa(bool);
      this.zzSC = paramStatus;
      return;
    }
  }
  
  public static zzd zzaS(Status paramStatus)
  {
    return new zzd(null, paramStatus);
  }
  
  public Status getStatus()
  {
    return this.zzSC;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\personalized\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */