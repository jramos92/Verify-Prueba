package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbo
  implements Parcelable.Creator<RemoveEventListenerRequest>
{
  static void zza(RemoveEventListenerRequest paramRemoveEventListenerRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramRemoveEventListenerRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramRemoveEventListenerRequest.zzaiA, paramInt, false);
    zzb.zzc(paramParcel, 3, paramRemoveEventListenerRequest.zzaho);
    zzb.zzI(paramParcel, i);
  }
  
  public RemoveEventListenerRequest zzbI(Parcel paramParcel)
  {
    int i = 0;
    int k = zza.zzap(paramParcel);
    DriveId localDriveId = null;
    int j = 0;
    if (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
      }
      for (;;)
      {
        break;
        j = zza.zzg(paramParcel, m);
        continue;
        localDriveId = (DriveId)zza.zza(paramParcel, m, DriveId.CREATOR);
        continue;
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new RemoveEventListenerRequest(j, localDriveId, i);
  }
  
  public RemoveEventListenerRequest[] zzdu(int paramInt)
  {
    return new RemoveEventListenerRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */