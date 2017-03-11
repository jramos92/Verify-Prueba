package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzn
  implements Parcelable.Creator<CreateFileRequest>
{
  static void zza(CreateFileRequest paramCreateFileRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramCreateFileRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramCreateFileRequest.zzakq, paramInt, false);
    zzb.zza(paramParcel, 3, paramCreateFileRequest.zzako, paramInt, false);
    zzb.zza(paramParcel, 4, paramCreateFileRequest.zzake, paramInt, false);
    zzb.zza(paramParcel, 5, paramCreateFileRequest.zzakp, false);
    zzb.zza(paramParcel, 6, paramCreateFileRequest.zzajW);
    zzb.zza(paramParcel, 7, paramCreateFileRequest.zzaiX, false);
    zzb.zzc(paramParcel, 8, paramCreateFileRequest.zzakr);
    zzb.zzc(paramParcel, 9, paramCreateFileRequest.zzaks);
    zzb.zzI(paramParcel, i);
  }
  
  public CreateFileRequest zzbc(Parcel paramParcel)
  {
    int i = 0;
    String str = null;
    int m = zza.zzap(paramParcel);
    int j = 0;
    boolean bool = false;
    Integer localInteger = null;
    Contents localContents = null;
    MetadataBundle localMetadataBundle = null;
    DriveId localDriveId = null;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        localDriveId = (DriveId)zza.zza(paramParcel, n, DriveId.CREATOR);
        break;
      case 3: 
        localMetadataBundle = (MetadataBundle)zza.zza(paramParcel, n, MetadataBundle.CREATOR);
        break;
      case 4: 
        localContents = (Contents)zza.zza(paramParcel, n, Contents.CREATOR);
        break;
      case 5: 
        localInteger = zza.zzh(paramParcel, n);
        break;
      case 6: 
        bool = zza.zzc(paramParcel, n);
        break;
      case 7: 
        str = zza.zzp(paramParcel, n);
        break;
      case 8: 
        j = zza.zzg(paramParcel, n);
        break;
      case 9: 
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new CreateFileRequest(k, localDriveId, localMetadataBundle, localContents, localInteger, bool, str, j, i);
  }
  
  public CreateFileRequest[] zzcK(int paramInt)
  {
    return new CreateFileRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */