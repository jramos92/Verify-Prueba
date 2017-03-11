package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import java.util.ArrayList;

public class zzj
  implements Parcelable.Creator<SessionReadResult>
{
  static void zza(SessionReadResult paramSessionReadResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramSessionReadResult.getSessions(), false);
    zzb.zzc(paramParcel, 1000, paramSessionReadResult.getVersionCode());
    zzb.zzc(paramParcel, 2, paramSessionReadResult.zztt(), false);
    zzb.zza(paramParcel, 3, paramSessionReadResult.getStatus(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public SessionReadResult zzdJ(Parcel paramParcel)
  {
    Status localStatus = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localArrayList1 = zza.zzc(paramParcel, k, Session.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localArrayList2 = zza.zzc(paramParcel, k, SessionDataSet.CREATOR);
        break;
      case 3: 
        localStatus = (Status)zza.zza(paramParcel, k, Status.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SessionReadResult(i, localArrayList1, localArrayList2, localStatus);
  }
  
  public SessionReadResult[] zzfB(int paramInt)
  {
    return new SessionReadResult[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */