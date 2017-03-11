package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<ReferenceShiftedDetails>
{
  static void zza(ReferenceShiftedDetails paramReferenceShiftedDetails, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramReferenceShiftedDetails.mVersionCode);
    zzb.zza(paramParcel, 2, paramReferenceShiftedDetails.zzaoZ, false);
    zzb.zza(paramParcel, 3, paramReferenceShiftedDetails.zzapa, false);
    zzb.zzc(paramParcel, 4, paramReferenceShiftedDetails.zzapb);
    zzb.zzc(paramParcel, 5, paramReferenceShiftedDetails.zzapc);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ReferenceShiftedDetails zzcx(Parcel paramParcel)
  {
    String str1 = null;
    int i = 0;
    int m = zza.zzap(paramParcel);
    int j = 0;
    String str2 = null;
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
        str2 = zza.zzp(paramParcel, n);
        break;
      case 3: 
        str1 = zza.zzp(paramParcel, n);
        break;
      case 4: 
        j = zza.zzg(paramParcel, n);
        break;
      case 5: 
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new ReferenceShiftedDetails(k, str2, str1, j, i);
  }
  
  public ReferenceShiftedDetails[] zzek(int paramInt)
  {
    return new ReferenceShiftedDetails[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\event\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */