package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<TextInsertedDetails>
{
  static void zza(TextInsertedDetails paramTextInsertedDetails, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramTextInsertedDetails.mVersionCode);
    zzb.zzc(paramParcel, 2, paramTextInsertedDetails.mIndex);
    zzb.zzc(paramParcel, 3, paramTextInsertedDetails.zzapd);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public TextInsertedDetails zzcz(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzap(paramParcel);
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
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new TextInsertedDetails(i, j, k);
  }
  
  public TextInsertedDetails[] zzem(int paramInt)
  {
    return new TextInsertedDetails[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\event\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */