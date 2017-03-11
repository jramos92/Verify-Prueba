package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class PopupLocationInfoParcelableCreator
  implements Parcelable.Creator<PopupLocationInfoParcelable>
{
  static void zza(PopupLocationInfoParcelable paramPopupLocationInfoParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramPopupLocationInfoParcelable.zzve(), false);
    zzb.zzc(paramParcel, 1000, paramPopupLocationInfoParcelable.getVersionCode());
    zzb.zza(paramParcel, 2, paramPopupLocationInfoParcelable.getWindowToken(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PopupLocationInfoParcelable zzdZ(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    Bundle localBundle = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localBundle = zza.zzr(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new PopupLocationInfoParcelable(i, localBundle, localIBinder);
  }
  
  public PopupLocationInfoParcelable[] zzfX(int paramInt)
  {
    return new PopupLocationInfoParcelable[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\PopupLocationInfoParcelableCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */