package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzax
  implements Parcelable.Creator<OnDeviceUsagePreferenceResponse>
{
  static void zza(OnDeviceUsagePreferenceResponse paramOnDeviceUsagePreferenceResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnDeviceUsagePreferenceResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramOnDeviceUsagePreferenceResponse.zzalY, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public OnDeviceUsagePreferenceResponse zzbs(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    FileUploadPreferencesImpl localFileUploadPreferencesImpl = null;
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
        localFileUploadPreferencesImpl = (FileUploadPreferencesImpl)zza.zza(paramParcel, k, FileUploadPreferencesImpl.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new OnDeviceUsagePreferenceResponse(i, localFileUploadPreferencesImpl);
  }
  
  public OnDeviceUsagePreferenceResponse[] zzde(int paramInt)
  {
    return new OnDeviceUsagePreferenceResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */