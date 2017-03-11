package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.ArrayList;

public class zzd
  implements Parcelable.Creator<ParcelableEventList>
{
  static void zza(ParcelableEventList paramParcelableEventList, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramParcelableEventList.mVersionCode);
    zzb.zzc(paramParcel, 2, paramParcelableEventList.zzoQ, false);
    zzb.zza(paramParcel, 3, paramParcelableEventList.zzaoV, paramInt, false);
    zzb.zza(paramParcel, 4, paramParcelableEventList.zzaoW);
    zzb.zzb(paramParcel, 5, paramParcelableEventList.zzaoX, false);
    zzb.zza(paramParcel, 6, paramParcelableEventList.zzaoY, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public ParcelableEventList zzcw(Parcel paramParcel)
  {
    boolean bool = false;
    ParcelableChangeInfo localParcelableChangeInfo = null;
    int j = zza.zzap(paramParcel);
    ArrayList localArrayList1 = null;
    DataHolder localDataHolder = null;
    ArrayList localArrayList2 = null;
    int i = 0;
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
        localArrayList2 = zza.zzc(paramParcel, k, ParcelableEvent.CREATOR);
        break;
      case 3: 
        localDataHolder = (DataHolder)zza.zza(paramParcel, k, DataHolder.CREATOR);
        break;
      case 4: 
        bool = zza.zzc(paramParcel, k);
        break;
      case 5: 
        localArrayList1 = zza.zzD(paramParcel, k);
        break;
      case 6: 
        localParcelableChangeInfo = (ParcelableChangeInfo)zza.zza(paramParcel, k, ParcelableChangeInfo.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ParcelableEventList(i, localArrayList2, localDataHolder, bool, localArrayList1, localParcelableChangeInfo);
  }
  
  public ParcelableEventList[] zzej(int paramInt)
  {
    return new ParcelableEventList[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\event\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */