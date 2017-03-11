package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo
  implements Parcelable.Creator<ChannelImpl>
{
  static void zza(ChannelImpl paramChannelImpl, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramChannelImpl.mVersionCode);
    zzb.zza(paramParcel, 2, paramChannelImpl.getToken(), false);
    zzb.zza(paramParcel, 3, paramChannelImpl.getNodeId(), false);
    zzb.zza(paramParcel, 4, paramChannelImpl.getPath(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ChannelImpl zzhN(Parcel paramParcel)
  {
    String str3 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
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
        str1 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        str3 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ChannelImpl(i, str1, str2, str3);
  }
  
  public ChannelImpl[] zzkV(int paramInt)
  {
    return new ChannelImpl[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */