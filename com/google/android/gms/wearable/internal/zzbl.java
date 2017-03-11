package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzbl
  implements Parcelable.Creator<StorageInfoResponse>
{
  static void zza(StorageInfoResponse paramStorageInfoResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramStorageInfoResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramStorageInfoResponse.statusCode);
    zzb.zza(paramParcel, 3, paramStorageInfoResponse.zzbhb);
    zzb.zzc(paramParcel, 4, paramStorageInfoResponse.zzbhd, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public StorageInfoResponse zzip(Parcel paramParcel)
  {
    int i = 0;
    int k = zza.zzap(paramParcel);
    long l = 0L;
    ArrayList localArrayList = null;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        i = zza.zzg(paramParcel, m);
        break;
      case 3: 
        l = zza.zzi(paramParcel, m);
        break;
      case 4: 
        localArrayList = zza.zzc(paramParcel, m, PackageStorageInfo.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new StorageInfoResponse(j, i, l, localArrayList);
  }
  
  public StorageInfoResponse[] zzly(int paramInt)
  {
    return new StorageInfoResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */