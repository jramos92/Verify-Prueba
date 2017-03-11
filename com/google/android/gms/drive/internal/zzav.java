package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

public class zzav
  implements Parcelable.Creator<OnChangesResponse>
{
  static void zza(OnChangesResponse paramOnChangesResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnChangesResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramOnChangesResponse.zzalT, paramInt, false);
    zzb.zzc(paramParcel, 3, paramOnChangesResponse.zzalU, false);
    zzb.zza(paramParcel, 4, paramOnChangesResponse.zzalV, paramInt, false);
    zzb.zza(paramParcel, 5, paramOnChangesResponse.zzalW);
    zzb.zzI(paramParcel, i);
  }
  
  public OnChangesResponse zzbq(Parcel paramParcel)
  {
    boolean bool = false;
    ChangeSequenceNumber localChangeSequenceNumber = null;
    int j = zza.zzap(paramParcel);
    ArrayList localArrayList = null;
    DataHolder localDataHolder = null;
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
        localDataHolder = (DataHolder)zza.zza(paramParcel, k, DataHolder.CREATOR);
        break;
      case 3: 
        localArrayList = zza.zzc(paramParcel, k, DriveId.CREATOR);
        break;
      case 4: 
        localChangeSequenceNumber = (ChangeSequenceNumber)zza.zza(paramParcel, k, ChangeSequenceNumber.CREATOR);
        break;
      case 5: 
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new OnChangesResponse(i, localDataHolder, localArrayList, localChangeSequenceNumber, bool);
  }
  
  public OnChangesResponse[] zzdc(int paramInt)
  {
    return new OnChangesResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzav.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */