package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class SnapshotContentsEntityCreator
  implements Parcelable.Creator<SnapshotContentsEntity>
{
  static void zza(SnapshotContentsEntity paramSnapshotContentsEntity, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramSnapshotContentsEntity.zzqO(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramSnapshotContentsEntity.getVersionCode());
    zzb.zzI(paramParcel, i);
  }
  
  public SnapshotContentsEntity zzen(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    Contents localContents = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localContents = (Contents)zza.zza(paramParcel, k, Contents.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SnapshotContentsEntity(i, localContents);
  }
  
  public SnapshotContentsEntity[] zzgu(int paramInt)
  {
    return new SnapshotContentsEntity[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\snapshot\SnapshotContentsEntityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */