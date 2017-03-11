package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<AddListenerRequest>
{
  static void zza(AddListenerRequest paramAddListenerRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramAddListenerRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramAddListenerRequest.zzEO(), false);
    zzb.zza(paramParcel, 3, paramAddListenerRequest.zzbfA, paramInt, false);
    zzb.zza(paramParcel, 4, paramAddListenerRequest.zzbfB, false);
    zzb.zza(paramParcel, 5, paramAddListenerRequest.zzbfC, false);
    zzb.zzI(paramParcel, i);
  }
  
  public AddListenerRequest zzhH(Parcel paramParcel)
  {
    String str1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str2 = null;
    IntentFilter[] arrayOfIntentFilter = null;
    IBinder localIBinder = null;
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
        localIBinder = zza.zzq(paramParcel, k);
        break;
      case 3: 
        arrayOfIntentFilter = (IntentFilter[])zza.zzb(paramParcel, k, IntentFilter.CREATOR);
        break;
      case 4: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new AddListenerRequest(i, localIBinder, arrayOfIntentFilter, str2, str1);
  }
  
  public AddListenerRequest[] zzkN(int paramInt)
  {
    return new AddListenerRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */