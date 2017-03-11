package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzm
  implements Parcelable.Creator<CreateFileIntentSenderRequest>
{
  static void zza(CreateFileIntentSenderRequest paramCreateFileIntentSenderRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramCreateFileIntentSenderRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramCreateFileIntentSenderRequest.zzako, paramInt, false);
    zzb.zzc(paramParcel, 3, paramCreateFileIntentSenderRequest.zzaiy);
    zzb.zza(paramParcel, 4, paramCreateFileIntentSenderRequest.zzajf, false);
    zzb.zza(paramParcel, 5, paramCreateFileIntentSenderRequest.zzaji, paramInt, false);
    zzb.zza(paramParcel, 6, paramCreateFileIntentSenderRequest.zzakp, false);
    zzb.zzI(paramParcel, i);
  }
  
  public CreateFileIntentSenderRequest zzbb(Parcel paramParcel)
  {
    int i = 0;
    Integer localInteger = null;
    int k = zza.zzap(paramParcel);
    DriveId localDriveId = null;
    String str = null;
    MetadataBundle localMetadataBundle = null;
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
        localMetadataBundle = (MetadataBundle)zza.zza(paramParcel, m, MetadataBundle.CREATOR);
        break;
      case 3: 
        i = zza.zzg(paramParcel, m);
        break;
      case 4: 
        str = zza.zzp(paramParcel, m);
        break;
      case 5: 
        localDriveId = (DriveId)zza.zza(paramParcel, m, DriveId.CREATOR);
        break;
      case 6: 
        localInteger = zza.zzh(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new CreateFileIntentSenderRequest(j, localMetadataBundle, i, str, localDriveId, localInteger);
  }
  
  public CreateFileIntentSenderRequest[] zzcJ(int paramInt)
  {
    return new CreateFileIntentSenderRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */