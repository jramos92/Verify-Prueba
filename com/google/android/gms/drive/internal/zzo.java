package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzo
  implements Parcelable.Creator<CreateFolderRequest>
{
  static void zza(CreateFolderRequest paramCreateFolderRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramCreateFolderRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramCreateFolderRequest.zzakq, paramInt, false);
    zzb.zza(paramParcel, 3, paramCreateFolderRequest.zzako, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public CreateFolderRequest zzbd(Parcel paramParcel)
  {
    MetadataBundle localMetadataBundle = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    DriveId localDriveId = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localDriveId = (DriveId)zza.zza(paramParcel, k, DriveId.CREATOR);
        continue;
        localMetadataBundle = (MetadataBundle)zza.zza(paramParcel, k, MetadataBundle.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new CreateFolderRequest(i, localDriveId, localMetadataBundle);
  }
  
  public CreateFolderRequest[] zzcL(int paramInt)
  {
    return new CreateFolderRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */