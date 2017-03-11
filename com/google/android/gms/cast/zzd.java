package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<LaunchOptions>
{
  static void zza(LaunchOptions paramLaunchOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramLaunchOptions.getVersionCode());
    zzb.zza(paramParcel, 2, paramLaunchOptions.getRelaunchIfRunning());
    zzb.zza(paramParcel, 3, paramLaunchOptions.getLanguage(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LaunchOptions zzZ(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzap(paramParcel);
    String str = null;
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
        bool = zza.zzc(paramParcel, k);
        break;
      case 3: 
        str = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LaunchOptions(i, bool, str);
  }
  
  public LaunchOptions[] zzaQ(int paramInt)
  {
    return new LaunchOptions[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */