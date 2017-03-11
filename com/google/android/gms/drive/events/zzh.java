package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzh
  implements Parcelable.Creator<ProgressEvent>
{
  static void zza(ProgressEvent paramProgressEvent, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramProgressEvent.mVersionCode);
    zzb.zza(paramParcel, 2, paramProgressEvent.zzaiA, paramInt, false);
    zzb.zzc(paramParcel, 3, paramProgressEvent.zzys);
    zzb.zza(paramParcel, 4, paramProgressEvent.zzajP);
    zzb.zza(paramParcel, 5, paramProgressEvent.zzajQ);
    zzb.zzc(paramParcel, 6, paramProgressEvent.zzWJ);
    zzb.zzI(paramParcel, i);
  }
  
  public ProgressEvent zzaP(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = 0;
    int m = zza.zzap(paramParcel);
    DriveId localDriveId = null;
    long l2 = 0L;
    int j = 0;
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
        j = zza.zzg(paramParcel, n);
        break;
      case 4: 
        l2 = zza.zzi(paramParcel, n);
        break;
      case 5: 
        l1 = zza.zzi(paramParcel, n);
        break;
      case 6: 
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new ProgressEvent(k, localDriveId, j, l2, l1, i);
  }
  
  public ProgressEvent[] zzcv(int paramInt)
  {
    return new ProgressEvent[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\events\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */