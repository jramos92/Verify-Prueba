package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbu
  implements Parcelable.Creator<StreamContentsRequest>
{
  static void zza(StreamContentsRequest paramStreamContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramStreamContentsRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramStreamContentsRequest.zzakc, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public StreamContentsRequest zzbN(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
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
        localDriveId = (DriveId)zza.zza(paramParcel, k, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new StreamContentsRequest(i, localDriveId);
  }
  
  public StreamContentsRequest[] zzdz(int paramInt)
  {
    return new StreamContentsRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzbu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */