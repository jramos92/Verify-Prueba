package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<UsageInfo>
{
  static void zza(UsageInfo paramUsageInfo, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramUsageInfo.zzQU, paramInt, false);
    zzb.zzc(paramParcel, 1000, paramUsageInfo.mVersionCode);
    zzb.zza(paramParcel, 2, paramUsageInfo.zzQV);
    zzb.zzc(paramParcel, 3, paramUsageInfo.zzQW);
    zzb.zza(paramParcel, 4, paramUsageInfo.zzub, false);
    zzb.zza(paramParcel, 5, paramUsageInfo.zzQX, paramInt, false);
    zzb.zza(paramParcel, 6, paramUsageInfo.zzQY);
    zzb.zzc(paramParcel, 7, paramUsageInfo.zzQZ);
    zzb.zzc(paramParcel, 8, paramUsageInfo.zzRa);
    zzb.zzI(paramParcel, i);
  }
  
  public UsageInfo[] zzap(int paramInt)
  {
    return new UsageInfo[paramInt];
  }
  
  public UsageInfo zzy(Parcel paramParcel)
  {
    DocumentContents localDocumentContents = null;
    int i = 0;
    int n = zza.zzap(paramParcel);
    long l = 0L;
    int j = -1;
    boolean bool = false;
    String str = null;
    int k = 0;
    DocumentId localDocumentId = null;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzao(paramParcel);
      switch (zza.zzbM(i1))
      {
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        localDocumentId = (DocumentId)zza.zza(paramParcel, i1, DocumentId.CREATOR);
        break;
      case 1000: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        l = zza.zzi(paramParcel, i1);
        break;
      case 3: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 4: 
        str = zza.zzp(paramParcel, i1);
        break;
      case 5: 
        localDocumentContents = (DocumentContents)zza.zza(paramParcel, i1, DocumentContents.CREATOR);
        break;
      case 6: 
        bool = zza.zzc(paramParcel, i1);
        break;
      case 7: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 8: 
        i = zza.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new UsageInfo(m, localDocumentId, l, k, str, localDocumentContents, bool, j, i);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appdatasearch\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */