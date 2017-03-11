package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
  implements Parcelable.Creator<DocumentId>
{
  static void zza(DocumentId paramDocumentId, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramDocumentId.zzQe, false);
    zzb.zzc(paramParcel, 1000, paramDocumentId.mVersionCode);
    zzb.zza(paramParcel, 2, paramDocumentId.zzQf, false);
    zzb.zza(paramParcel, 3, paramDocumentId.zzQg, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public DocumentId[] zzaf(int paramInt)
  {
    return new DocumentId[paramInt];
  }
  
  public DocumentId zzs(Parcel paramParcel)
  {
    String str3 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str3 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DocumentId(i, str1, str2, str3);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appdatasearch\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */