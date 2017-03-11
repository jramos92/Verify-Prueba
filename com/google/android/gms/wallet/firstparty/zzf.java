package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
  implements Parcelable.Creator<InitializeBuyFlowRequest>
{
  static void zza(InitializeBuyFlowRequest paramInitializeBuyFlowRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramInitializeBuyFlowRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramInitializeBuyFlowRequest.zzbdT, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public InitializeBuyFlowRequest zzhr(Parcel paramParcel)
  {
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
        arrayOfByte = zza.zzt(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new InitializeBuyFlowRequest(i, arrayOfByte);
  }
  
  public InitializeBuyFlowRequest[] zzku(int paramInt)
  {
    return new InitializeBuyFlowRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\firstparty\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */