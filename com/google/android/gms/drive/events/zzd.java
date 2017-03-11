package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;

public class zzd
  implements Parcelable.Creator<ChangesAvailableOptions>
{
  static void zza(ChangesAvailableOptions paramChangesAvailableOptions, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramChangesAvailableOptions.mVersionCode);
    zzb.zzc(paramParcel, 2, paramChangesAvailableOptions.zzajy);
    zzb.zza(paramParcel, 3, paramChangesAvailableOptions.zzajz);
    zzb.zzc(paramParcel, 4, paramChangesAvailableOptions.zzajA, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ChangesAvailableOptions zzaN(Parcel paramParcel)
  {
    boolean bool = false;
    int k = zza.zzap(paramParcel);
    ArrayList localArrayList = null;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        i = zza.zzg(paramParcel, m);
        break;
      case 2: 
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        bool = zza.zzc(paramParcel, m);
        break;
      case 4: 
        localArrayList = zza.zzc(paramParcel, m, DriveSpace.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new ChangesAvailableOptions(i, j, bool, localArrayList);
  }
  
  public ChangesAvailableOptions[] zzct(int paramInt)
  {
    return new ChangesAvailableOptions[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\events\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */