package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<GetInstrumentsResponse>
{
  static void zza(GetInstrumentsResponse paramGetInstrumentsResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetInstrumentsResponse.getVersionCode());
    zzb.zza(paramParcel, 2, paramGetInstrumentsResponse.zzbdR, false);
    zzb.zza(paramParcel, 3, paramGetInstrumentsResponse.zzbdS, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public GetInstrumentsResponse zzhq(Parcel paramParcel)
  {
    String[] arrayOfString = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    byte[][] arrayOfByte = (byte[][])null;
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
        arrayOfString = zza.zzB(paramParcel, k);
        break;
      case 3: 
        arrayOfByte = zza.zzt(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new GetInstrumentsResponse(i, arrayOfString, arrayOfByte);
  }
  
  public GetInstrumentsResponse[] zzkt(int paramInt)
  {
    return new GetInstrumentsResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\firstparty\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */