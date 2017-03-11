package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzai
  implements Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest>
{
  static void zza(GetDriveIdFromUniqueIdentifierRequest paramGetDriveIdFromUniqueIdentifierRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetDriveIdFromUniqueIdentifierRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramGetDriveIdFromUniqueIdentifierRequest.zzalD, false);
    zzb.zza(paramParcel, 3, paramGetDriveIdFromUniqueIdentifierRequest.zzalE);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public GetDriveIdFromUniqueIdentifierRequest zzbk(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzap(paramParcel);
    String str = null;
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
        str = zza.zzp(paramParcel, k);
        break;
      case 3: 
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new GetDriveIdFromUniqueIdentifierRequest(i, str, bool);
  }
  
  public GetDriveIdFromUniqueIdentifierRequest[] zzcW(int paramInt)
  {
    return new GetDriveIdFromUniqueIdentifierRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */