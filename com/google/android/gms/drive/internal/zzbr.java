package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbr
  implements Parcelable.Creator<SetFileUploadPreferencesRequest>
{
  static void zza(SetFileUploadPreferencesRequest paramSetFileUploadPreferencesRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramSetFileUploadPreferencesRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramSetFileUploadPreferencesRequest.zzalY, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public SetFileUploadPreferencesRequest zzbL(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    FileUploadPreferencesImpl localFileUploadPreferencesImpl = null;
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
        localFileUploadPreferencesImpl = (FileUploadPreferencesImpl)zza.zza(paramParcel, k, FileUploadPreferencesImpl.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SetFileUploadPreferencesRequest(i, localFileUploadPreferencesImpl);
  }
  
  public SetFileUploadPreferencesRequest[] zzdx(int paramInt)
  {
    return new SetFileUploadPreferencesRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzbr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */