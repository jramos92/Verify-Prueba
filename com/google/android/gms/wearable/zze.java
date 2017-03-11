package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
  implements Parcelable.Creator<Asset>
{
  static void zza(Asset paramAsset, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramAsset.mVersionCode);
    zzb.zza(paramParcel, 2, paramAsset.getData(), false);
    zzb.zza(paramParcel, 3, paramAsset.getDigest(), false);
    zzb.zza(paramParcel, 4, paramAsset.zzbeT, paramInt, false);
    zzb.zza(paramParcel, 5, paramAsset.uri, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public Asset zzhE(Parcel paramParcel)
  {
    Uri localUri = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    ParcelFileDescriptor localParcelFileDescriptor = null;
    String str = null;
    byte[] arrayOfByte = null;
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
        arrayOfByte = zza.zzs(paramParcel, k);
        break;
      case 3: 
        str = zza.zzp(paramParcel, k);
        break;
      case 4: 
        localParcelFileDescriptor = (ParcelFileDescriptor)zza.zza(paramParcel, k, ParcelFileDescriptor.CREATOR);
        break;
      case 5: 
        localUri = (Uri)zza.zza(paramParcel, k, Uri.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new Asset(i, arrayOfByte, str, localParcelFileDescriptor, localUri);
  }
  
  public Asset[] zzkK(int paramInt)
  {
    return new Asset[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */