package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk
  implements Parcelable.Creator<StreetViewPanoramaLink>
{
  static void zza(StreetViewPanoramaLink paramStreetViewPanoramaLink, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramStreetViewPanoramaLink.getVersionCode());
    zzb.zza(paramParcel, 2, paramStreetViewPanoramaLink.panoId, false);
    zzb.zza(paramParcel, 3, paramStreetViewPanoramaLink.bearing);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public StreetViewPanoramaLink zzfr(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str = null;
    float f = 0.0F;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str = zza.zzp(paramParcel, k);
        break;
      case 3: 
        f = zza.zzl(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new StreetViewPanoramaLink(i, str, f);
  }
  
  public StreetViewPanoramaLink[] zzhP(int paramInt)
  {
    return new StreetViewPanoramaLink[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\model\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */