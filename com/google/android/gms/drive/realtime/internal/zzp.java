package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import java.util.ArrayList;

public class zzp
  implements Parcelable.Creator<ParcelableChangeInfo>
{
  static void zza(ParcelableChangeInfo paramParcelableChangeInfo, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramParcelableChangeInfo.mVersionCode);
    zzb.zza(paramParcel, 2, paramParcelableChangeInfo.zzZH);
    zzb.zzc(paramParcel, 3, paramParcelableChangeInfo.zzoQ, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ParcelableChangeInfo zzcq(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    long l = 0L;
    ArrayList localArrayList = null;
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
        l = zza.zzi(paramParcel, k);
        break;
      case 3: 
        localArrayList = zza.zzc(paramParcel, k, ParcelableEvent.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ParcelableChangeInfo(i, l, localArrayList);
  }
  
  public ParcelableChangeInfo[] zzed(int paramInt)
  {
    return new ParcelableChangeInfo[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */