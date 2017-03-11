package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<AppMetadata>
{
  static void zza(AppMetadata paramAppMetadata, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramAppMetadata.versionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramAppMetadata.packageName, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramAppMetadata.zzaLP, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, paramAppMetadata.zzaDC, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 5, paramAppMetadata.zzaLQ, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 6, paramAppMetadata.zzaLR);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 7, paramAppMetadata.zzaLS);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, paramInt);
  }
  
  public AppMetadata zzfx(Parcel paramParcel)
  {
    long l1 = 0L;
    String str1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    long l2 = 0L;
    String str2 = null;
    String str3 = null;
    String str4 = null;
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
        str1 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        l2 = zza.zzi(paramParcel, k);
        break;
      case 7: 
        l1 = zza.zzi(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new AppMetadata(i, str4, str3, str2, str1, l2, l1);
  }
  
  public AppMetadata[] zzid(int paramInt)
  {
    return new AppMetadata[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */