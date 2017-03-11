package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk
  implements Parcelable.Creator<UserMetadata>
{
  static void zza(UserMetadata paramUserMetadata, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramUserMetadata.mVersionCode);
    zzb.zza(paramParcel, 2, paramUserMetadata.zzajr, false);
    zzb.zza(paramParcel, 3, paramUserMetadata.zzTa, false);
    zzb.zza(paramParcel, 4, paramUserMetadata.zzajs, false);
    zzb.zza(paramParcel, 5, paramUserMetadata.zzajt);
    zzb.zza(paramParcel, 6, paramUserMetadata.zzaju, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public UserMetadata zzaK(Parcel paramParcel)
  {
    boolean bool = false;
    String str1 = null;
    int j = zza.zzap(paramParcel);
    String str2 = null;
    String str3 = null;
    String str4 = null;
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
        str4 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        bool = zza.zzc(paramParcel, k);
        break;
      case 6: 
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new UserMetadata(i, str4, str3, str2, bool, str1);
  }
  
  public UserMetadata[] zzcq(int paramInt)
  {
    return new UserMetadata[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */