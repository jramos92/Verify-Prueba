package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzan
  implements Parcelable.Creator<GetCloudSyncSettingResponse>
{
  static void zza(GetCloudSyncSettingResponse paramGetCloudSyncSettingResponse, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramGetCloudSyncSettingResponse.versionCode);
    zzb.zzc(paramParcel, 2, paramGetCloudSyncSettingResponse.statusCode);
    zzb.zza(paramParcel, 3, paramGetCloudSyncSettingResponse.enabled);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public GetCloudSyncSettingResponse zzia(Parcel paramParcel)
  {
    boolean bool = false;
    int k = zza.zzap(paramParcel);
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
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new GetCloudSyncSettingResponse(i, j, bool);
  }
  
  public GetCloudSyncSettingResponse[] zzlj(int paramInt)
  {
    return new GetCloudSyncSettingResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */