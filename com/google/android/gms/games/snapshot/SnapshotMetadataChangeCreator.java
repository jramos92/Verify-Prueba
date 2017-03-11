package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class SnapshotMetadataChangeCreator
  implements Parcelable.Creator<SnapshotMetadataChangeEntity>
{
  static void zza(SnapshotMetadataChangeEntity paramSnapshotMetadataChangeEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramSnapshotMetadataChangeEntity.getDescription(), false);
    zzb.zzc(paramParcel, 1000, paramSnapshotMetadataChangeEntity.getVersionCode());
    zzb.zza(paramParcel, 2, paramSnapshotMetadataChangeEntity.getPlayedTimeMillis(), false);
    zzb.zza(paramParcel, 4, paramSnapshotMetadataChangeEntity.getCoverImageUri(), paramInt, false);
    zzb.zza(paramParcel, 5, paramSnapshotMetadataChangeEntity.zzvS(), paramInt, false);
    zzb.zza(paramParcel, 6, paramSnapshotMetadataChangeEntity.getProgressValue(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public SnapshotMetadataChangeEntity zzep(Parcel paramParcel)
  {
    Long localLong1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    Uri localUri = null;
    BitmapTeleporter localBitmapTeleporter = null;
    Long localLong2 = null;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        str = zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localLong2 = zza.zzj(paramParcel, k);
        break;
      case 4: 
        localUri = (Uri)zza.zza(paramParcel, k, Uri.CREATOR);
        break;
      case 5: 
        localBitmapTeleporter = (BitmapTeleporter)zza.zza(paramParcel, k, BitmapTeleporter.CREATOR);
        break;
      case 6: 
        localLong1 = zza.zzj(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SnapshotMetadataChangeEntity(i, str, localLong2, localBitmapTeleporter, localUri, localLong1);
  }
  
  public SnapshotMetadataChangeEntity[] zzgw(int paramInt)
  {
    return new SnapshotMetadataChangeEntity[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\snapshot\SnapshotMetadataChangeCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */