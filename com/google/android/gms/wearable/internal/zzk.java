package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzk
  implements Parcelable.Creator<CapabilityInfoParcelable>
{
  static void zza(CapabilityInfoParcelable paramCapabilityInfoParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramCapabilityInfoParcelable.mVersionCode);
    zzb.zza(paramParcel, 2, paramCapabilityInfoParcelable.getName(), false);
    zzb.zzc(paramParcel, 3, paramCapabilityInfoParcelable.zzEX(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public CapabilityInfoParcelable zzhL(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str = null;
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
        localArrayList = zza.zzc(paramParcel, k, NodeParcelable.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new CapabilityInfoParcelable(i, str, localArrayList);
  }
  
  public CapabilityInfoParcelable[] zzkR(int paramInt)
  {
    return new CapabilityInfoParcelable[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */