package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<DocumentSection>
{
  static void zza(DocumentSection paramDocumentSection, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramDocumentSection.zzQj, false);
    zzb.zzc(paramParcel, 1000, paramDocumentSection.mVersionCode);
    zzb.zza(paramParcel, 3, paramDocumentSection.zzQk, paramInt, false);
    zzb.zzc(paramParcel, 4, paramDocumentSection.zzQl);
    zzb.zza(paramParcel, 5, paramDocumentSection.zzQm, false);
    zzb.zzI(paramParcel, i);
  }
  
  public DocumentSection[] zzag(int paramInt)
  {
    return new DocumentSection[paramInt];
  }
  
  public DocumentSection zzt(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int k = zza.zzap(paramParcel);
    int j = 0;
    int i = -1;
    RegisterSectionInfo localRegisterSectionInfo = null;
    String str = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        str = zza.zzp(paramParcel, m);
        break;
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        localRegisterSectionInfo = (RegisterSectionInfo)zza.zza(paramParcel, m, RegisterSectionInfo.CREATOR);
        break;
      case 4: 
        i = zza.zzg(paramParcel, m);
        break;
      case 5: 
        arrayOfByte = zza.zzs(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new DocumentSection(j, str, localRegisterSectionInfo, i, arrayOfByte);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appdatasearch\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */