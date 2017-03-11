package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<GetInstrumentsRequest>
{
  static void zza(GetInstrumentsRequest paramGetInstrumentsRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetInstrumentsRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramGetInstrumentsRequest.zzbdQ, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public GetInstrumentsRequest zzhp(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    int[] arrayOfInt = null;
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
        arrayOfInt = zza.zzv(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new GetInstrumentsRequest(i, arrayOfInt);
  }
  
  public GetInstrumentsRequest[] zzks(int paramInt)
  {
    return new GetInstrumentsRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\firstparty\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */