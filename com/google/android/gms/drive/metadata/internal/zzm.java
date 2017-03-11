package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm
  implements Parcelable.Creator<PartialDriveId>
{
  static void zza(PartialDriveId paramPartialDriveId, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramPartialDriveId.mVersionCode);
    zzb.zza(paramParcel, 2, paramPartialDriveId.zzaiM, false);
    zzb.zza(paramParcel, 3, paramPartialDriveId.zzaiN);
    zzb.zzc(paramParcel, 4, paramPartialDriveId.zzaiO);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public PartialDriveId zzbZ(Parcel paramParcel)
  {
    int k = zza.zzap(paramParcel);
    int j = 0;
    String str = null;
    long l = 0L;
    int i = -1;
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
        str = zza.zzp(paramParcel, m);
        break;
      case 3: 
        l = zza.zzi(paramParcel, m);
        break;
      case 4: 
        i = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new PartialDriveId(j, str, l, i);
  }
  
  public PartialDriveId[] zzdL(int paramInt)
  {
    return new PartialDriveId[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\metadata\internal\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */