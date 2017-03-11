package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzj
  implements Parcelable.Creator<ControlProgressRequest>
{
  static void zza(ControlProgressRequest paramControlProgressRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramControlProgressRequest.mVersionCode);
    zzb.zzc(paramParcel, 2, paramControlProgressRequest.zzakj);
    zzb.zzc(paramParcel, 3, paramControlProgressRequest.zzakk);
    zzb.zza(paramParcel, 4, paramControlProgressRequest.zzaiA, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public ControlProgressRequest zzaZ(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzap(paramParcel);
    DriveId localDriveId = null;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        i = zza.zzg(paramParcel, n);
        break;
      case 2: 
        j = zza.zzg(paramParcel, n);
        break;
      case 3: 
        k = zza.zzg(paramParcel, n);
        break;
      case 4: 
        localDriveId = (DriveId)zza.zza(paramParcel, n, DriveId.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new ControlProgressRequest(i, j, k, localDriveId);
  }
  
  public ControlProgressRequest[] zzcG(int paramInt)
  {
    return new ControlProgressRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */