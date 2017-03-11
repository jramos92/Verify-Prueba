package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbc
  implements Parcelable.Creator<OnFetchThumbnailResponse>
{
  static void zza(OnFetchThumbnailResponse paramOnFetchThumbnailResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnFetchThumbnailResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramOnFetchThumbnailResponse.zzamj, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public OnFetchThumbnailResponse zzbx(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    ParcelFileDescriptor localParcelFileDescriptor = null;
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
        localParcelFileDescriptor = (ParcelFileDescriptor)zza.zza(paramParcel, k, ParcelFileDescriptor.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new OnFetchThumbnailResponse(i, localParcelFileDescriptor);
  }
  
  public OnFetchThumbnailResponse[] zzdj(int paramInt)
  {
    return new OnFetchThumbnailResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */