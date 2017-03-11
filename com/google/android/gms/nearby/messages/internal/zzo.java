package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo
  implements Parcelable.Creator<RegisterStatusCallbackRequest>
{
  static void zza(RegisterStatusCallbackRequest paramRegisterStatusCallbackRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramRegisterStatusCallbackRequest.versionCode);
    zzb.zza(paramParcel, 2, paramRegisterStatusCallbackRequest.zzBd(), false);
    zzb.zza(paramParcel, 3, paramRegisterStatusCallbackRequest.zzBf(), false);
    zzb.zza(paramParcel, 4, paramRegisterStatusCallbackRequest.zzaRd);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public RegisterStatusCallbackRequest zzfW(Parcel paramParcel)
  {
    IBinder localIBinder2 = null;
    boolean bool = false;
    int j = zza.zzap(paramParcel);
    IBinder localIBinder1 = null;
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
        localIBinder1 = zza.zzq(paramParcel, k);
        break;
      case 3: 
        localIBinder2 = zza.zzq(paramParcel, k);
        break;
      case 4: 
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new RegisterStatusCallbackRequest(i, localIBinder1, localIBinder2, bool);
  }
  
  public RegisterStatusCallbackRequest[] zziI(int paramInt)
  {
    return new RegisterStatusCallbackRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\internal\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */