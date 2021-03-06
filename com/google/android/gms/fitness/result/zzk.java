package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;

public class zzk
  implements Parcelable.Creator<SessionStopResult>
{
  static void zza(SessionStopResult paramSessionStopResult, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1000, paramSessionStopResult.getVersionCode());
    zzb.zza(paramParcel, 2, paramSessionStopResult.getStatus(), paramInt, false);
    zzb.zzc(paramParcel, 3, paramSessionStopResult.getSessions(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public SessionStopResult zzdK(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    Status localStatus = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        i = zza.zzg(paramParcel, k);
        continue;
        localStatus = (Status)zza.zza(paramParcel, k, Status.CREATOR);
        continue;
        localArrayList = zza.zzc(paramParcel, k, Session.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SessionStopResult(i, localStatus, localArrayList);
  }
  
  public SessionStopResult[] zzfC(int paramInt)
  {
    return new SessionStopResult[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */