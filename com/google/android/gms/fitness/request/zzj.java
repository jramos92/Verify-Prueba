package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<DataTypeReadRequest>
{
  static void zza(DataTypeReadRequest paramDataTypeReadRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramDataTypeReadRequest.getName(), false);
    zzb.zzc(paramParcel, 1000, paramDataTypeReadRequest.getVersionCode());
    zzb.zza(paramParcel, 3, paramDataTypeReadRequest.zzsO(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public DataTypeReadRequest zzdf(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        str = zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 3: 
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DataTypeReadRequest(i, str, localIBinder);
  }
  
  public DataTypeReadRequest[] zzeW(int paramInt)
  {
    return new DataTypeReadRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */