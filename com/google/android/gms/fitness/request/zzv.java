package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;

public class zzv
  implements Parcelable.Creator<SessionReadRequest>
{
  static void zza(SessionReadRequest paramSessionReadRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramSessionReadRequest.getSessionName(), false);
    zzb.zzc(paramParcel, 1000, paramSessionReadRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramSessionReadRequest.getSessionId(), false);
    zzb.zza(paramParcel, 3, paramSessionReadRequest.zzkX());
    zzb.zza(paramParcel, 4, paramSessionReadRequest.zzsi());
    zzb.zzc(paramParcel, 5, paramSessionReadRequest.getDataTypes(), false);
    zzb.zzc(paramParcel, 6, paramSessionReadRequest.getDataSources(), false);
    zzb.zza(paramParcel, 7, paramSessionReadRequest.zzti());
    zzb.zza(paramParcel, 8, paramSessionReadRequest.zzsT());
    zzb.zzb(paramParcel, 9, paramSessionReadRequest.getExcludedPackages(), false);
    zzb.zza(paramParcel, 10, paramSessionReadRequest.zzsO(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public SessionReadRequest zzdq(Parcel paramParcel)
  {
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
    long l2 = 0L;
    long l1 = 0L;
    ArrayList localArrayList3 = null;
    ArrayList localArrayList2 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    ArrayList localArrayList1 = null;
    IBinder localIBinder = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        l2 = zza.zzi(paramParcel, k);
        break;
      case 4: 
        l1 = zza.zzi(paramParcel, k);
        break;
      case 5: 
        localArrayList3 = zza.zzc(paramParcel, k, DataType.CREATOR);
        break;
      case 6: 
        localArrayList2 = zza.zzc(paramParcel, k, DataSource.CREATOR);
        break;
      case 7: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 8: 
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 9: 
        localArrayList1 = zza.zzD(paramParcel, k);
        break;
      case 10: 
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SessionReadRequest(i, str2, str1, l2, l1, localArrayList3, localArrayList2, bool2, bool1, localArrayList1, localIBinder);
  }
  
  public SessionReadRequest[] zzfi(int paramInt)
  {
    return new SessionReadRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */