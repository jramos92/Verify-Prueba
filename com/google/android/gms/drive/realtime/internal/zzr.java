package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr
  implements Parcelable.Creator<ParcelableIndexReference>
{
  static void zza(ParcelableIndexReference paramParcelableIndexReference, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramParcelableIndexReference.mVersionCode);
    zzb.zza(paramParcel, 2, paramParcelableIndexReference.zzaoB, false);
    zzb.zzc(paramParcel, 3, paramParcelableIndexReference.mIndex);
    zzb.zza(paramParcel, 4, paramParcelableIndexReference.zzaoC);
    zzb.zzc(paramParcel, 5, paramParcelableIndexReference.zzaoD);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ParcelableIndexReference zzcs(Parcel paramParcel)
  {
    boolean bool = false;
    int m = zza.zzap(paramParcel);
    String str = null;
    int i = -1;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        str = zza.zzp(paramParcel, n);
        break;
      case 3: 
        j = zza.zzg(paramParcel, n);
        break;
      case 4: 
        bool = zza.zzc(paramParcel, n);
        break;
      case 5: 
        i = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new ParcelableIndexReference(k, str, j, bool, i);
  }
  
  public ParcelableIndexReference[] zzef(int paramInt)
  {
    return new ParcelableIndexReference[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */