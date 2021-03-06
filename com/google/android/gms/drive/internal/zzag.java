package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzag
  implements Parcelable.Creator<FileUploadPreferencesImpl>
{
  static void zza(FileUploadPreferencesImpl paramFileUploadPreferencesImpl, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramFileUploadPreferencesImpl.mVersionCode);
    zzb.zzc(paramParcel, 2, paramFileUploadPreferencesImpl.zzalx);
    zzb.zzc(paramParcel, 3, paramFileUploadPreferencesImpl.zzaly);
    zzb.zza(paramParcel, 4, paramFileUploadPreferencesImpl.zzalz);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public FileUploadPreferencesImpl zzbi(Parcel paramParcel)
  {
    boolean bool = false;
    int m = zza.zzap(paramParcel);
    int k = 0;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        i = zza.zzg(paramParcel, n);
        break;
      case 2: 
        j = zza.zzg(paramParcel, n);
        break;
      case 3: 
        k = zza.zzg(paramParcel, n);
        break;
      case 4: 
        bool = zza.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new FileUploadPreferencesImpl(i, j, k, bool);
  }
  
  public FileUploadPreferencesImpl[] zzcU(int paramInt)
  {
    return new FileUploadPreferencesImpl[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */