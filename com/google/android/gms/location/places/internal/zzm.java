package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<PlaceLikelihoodEntity>
{
  static void zza(PlaceLikelihoodEntity paramPlaceLikelihoodEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramPlaceLikelihoodEntity.zzaHA, paramInt, false);
    zzb.zzc(paramParcel, 1000, paramPlaceLikelihoodEntity.mVersionCode);
    zzb.zza(paramParcel, 2, paramPlaceLikelihoodEntity.zzaHB);
    zzb.zzI(paramParcel, i);
  }
  
  public PlaceLikelihoodEntity zzeW(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    PlaceImpl localPlaceImpl = null;
    float f = 0.0F;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        localPlaceImpl = (PlaceImpl)zza.zza(paramParcel, k, PlaceImpl.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        f = zza.zzl(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PlaceLikelihoodEntity(i, localPlaceImpl, f);
  }
  
  public PlaceLikelihoodEntity[] zzhu(int paramInt)
  {
    return new PlaceLikelihoodEntity[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\internal\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */