package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbw
  implements Parcelable.Creator<TrashResourceRequest>
{
  static void zza(TrashResourceRequest paramTrashResourceRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramTrashResourceRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramTrashResourceRequest.zzakc, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public TrashResourceRequest zzbP(Parcel paramParcel)
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
    return new TrashResourceRequest(i, localDriveId);
  }
  
  public TrashResourceRequest[] zzdB(int paramInt)
  {
    return new TrashResourceRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzbw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */