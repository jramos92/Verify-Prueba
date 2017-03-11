package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DrivePreferences;

public class zzba
  implements Parcelable.Creator<OnDrivePreferencesResponse>
{
  static void zza(OnDrivePreferencesResponse paramOnDrivePreferencesResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnDrivePreferencesResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramOnDrivePreferencesResponse.zzamd, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public OnDrivePreferencesResponse zzbv(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    DrivePreferences localDrivePreferences = null;
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
        localDrivePreferences = (DrivePreferences)zza.zza(paramParcel, k, DrivePreferences.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new OnDrivePreferencesResponse(i, localDrivePreferences);
  }
  
  public OnDrivePreferencesResponse[] zzdh(int paramInt)
  {
    return new OnDrivePreferencesResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */