package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
  implements Parcelable.Creator<ValueChangedDetails>
{
  static void zza(ValueChangedDetails paramValueChangedDetails, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramValueChangedDetails.mVersionCode);
    zzb.zzc(paramParcel, 2, paramValueChangedDetails.zzaoE);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ValueChangedDetails zzcA(Parcel paramParcel)
  {
    int j = 0;
    int k = zza.zzap(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new ValueChangedDetails(i, j);
  }
  
  public ValueChangedDetails[] zzen(int paramInt)
  {
    return new ValueChangedDetails[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\event\zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */