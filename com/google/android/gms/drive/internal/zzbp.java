package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbp
  implements Parcelable.Creator<RemovePermissionRequest>
{
  static void zza(RemovePermissionRequest paramRemovePermissionRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramRemovePermissionRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramRemovePermissionRequest.zzaiA, paramInt, false);
    zzb.zza(paramParcel, 3, paramRemovePermissionRequest.zzajj, false);
    zzb.zza(paramParcel, 4, paramRemovePermissionRequest.zzajW);
    zzb.zza(paramParcel, 5, paramRemovePermissionRequest.zzaiX, false);
    zzb.zzI(paramParcel, i);
  }
  
  public RemovePermissionRequest zzbJ(Parcel paramParcel)
  {
    boolean bool = false;
    String str1 = null;
    int j = zza.zzap(paramParcel);
    String str2 = null;
    DriveId localDriveId = null;
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
        localDriveId = (DriveId)zza.zza(paramParcel, k, DriveId.CREATOR);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        bool = zza.zzc(paramParcel, k);
        break;
      case 5: 
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new RemovePermissionRequest(i, localDriveId, str2, bool, str1);
  }
  
  public RemovePermissionRequest[] zzdv(int paramInt)
  {
    return new RemovePermissionRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */