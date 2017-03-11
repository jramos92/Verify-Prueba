package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzj
  implements Parcelable.Creator<RealtimeDocumentSyncRequest>
{
  static void zza(RealtimeDocumentSyncRequest paramRealtimeDocumentSyncRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramRealtimeDocumentSyncRequest.mVersionCode);
    zzb.zzb(paramParcel, 2, paramRealtimeDocumentSyncRequest.zzajp, false);
    zzb.zzb(paramParcel, 3, paramRealtimeDocumentSyncRequest.zzajq, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public RealtimeDocumentSyncRequest zzaJ(Parcel paramParcel)
  {
    ArrayList localArrayList2 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
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
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localArrayList1 = zza.zzD(paramParcel, k);
        break;
      case 3: 
        localArrayList2 = zza.zzD(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new RealtimeDocumentSyncRequest(i, localArrayList1, localArrayList2);
  }
  
  public RealtimeDocumentSyncRequest[] zzcp(int paramInt)
  {
    return new RealtimeDocumentSyncRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */