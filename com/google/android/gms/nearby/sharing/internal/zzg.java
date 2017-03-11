package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
  implements Parcelable.Creator<ReceiveContentRequest>
{
  static void zza(ReceiveContentRequest paramReceiveContentRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramReceiveContentRequest.versionCode);
    zzb.zza(paramParcel, 2, paramReceiveContentRequest.zzaRq, false);
    zzb.zza(paramParcel, 3, paramReceiveContentRequest.zzBp(), false);
    zzb.zza(paramParcel, 4, paramReceiveContentRequest.packageName, false);
    zzb.zza(paramParcel, 5, paramReceiveContentRequest.zzBd(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ReceiveContentRequest zzgf(Parcel paramParcel)
  {
    IBinder localIBinder1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str = null;
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
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
        localIBinder3 = zza.zzq(paramParcel, k);
        break;
      case 3: 
        localIBinder2 = zza.zzq(paramParcel, k);
        break;
      case 4: 
        str = zza.zzp(paramParcel, k);
        break;
      case 5: 
        localIBinder1 = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ReceiveContentRequest(i, localIBinder3, localIBinder2, str, localIBinder1);
  }
  
  public ReceiveContentRequest[] zziR(int paramInt)
  {
    return new ReceiveContentRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\sharing\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */