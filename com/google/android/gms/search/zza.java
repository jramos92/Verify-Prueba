package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<GoogleNowAuthState>
{
  static void zza(GoogleNowAuthState paramGoogleNowAuthState, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramGoogleNowAuthState.getAuthCode(), false);
    zzb.zzc(paramParcel, 1000, paramGoogleNowAuthState.mVersionCode);
    zzb.zza(paramParcel, 2, paramGoogleNowAuthState.getAccessToken(), false);
    zzb.zza(paramParcel, 3, paramGoogleNowAuthState.getNextAllowedTimeMillis());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public GoogleNowAuthState zzgA(Parcel paramParcel)
  {
    String str1 = null;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(paramParcel);
    int i = 0;
    long l = 0L;
    String str2 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzao(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 2: 
        str1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 3: 
        l = com.google.android.gms.common.internal.safeparcel.zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new GoogleNowAuthState(i, str2, str1, l);
  }
  
  public GoogleNowAuthState[] zzjn(int paramInt)
  {
    return new GoogleNowAuthState[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\search\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */