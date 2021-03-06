package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<FieldChangedDetails>
{
  static void zza(FieldChangedDetails paramFieldChangedDetails, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramFieldChangedDetails.mVersionCode);
    zzb.zzc(paramParcel, 2, paramFieldChangedDetails.zzaoE);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public FieldChangedDetails zzct(Parcel paramParcel)
  {
    int j = 0;
    int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = com.google.android.gms.common.internal.safeparcel.zza.zzao(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(m))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, m);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new FieldChangedDetails(i, j);
  }
  
  public FieldChangedDetails[] zzeg(int paramInt)
  {
    return new FieldChangedDetails[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\event\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */