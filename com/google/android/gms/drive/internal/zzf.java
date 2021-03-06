package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.List;

public class zzf
  implements Parcelable.Creator<ChangeResourceParentsRequest>
{
  static void zza(ChangeResourceParentsRequest paramChangeResourceParentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramChangeResourceParentsRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramChangeResourceParentsRequest.zzajY, paramInt, false);
    zzb.zzc(paramParcel, 3, paramChangeResourceParentsRequest.zzajZ, false);
    zzb.zzc(paramParcel, 4, paramChangeResourceParentsRequest.zzaka, false);
    zzb.zzI(paramParcel, i);
  }
  
  public ChangeResourceParentsRequest zzaV(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      Object localObject3;
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (DriveId)zza.zza(paramParcel, k, DriveId.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = zza.zzc(paramParcel, k, DriveId.CREATOR);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        localArrayList = zza.zzc(paramParcel, k, DriveId.CREATOR);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ChangeResourceParentsRequest(i, (DriveId)localObject1, (List)localObject2, localArrayList);
  }
  
  public ChangeResourceParentsRequest[] zzcC(int paramInt)
  {
    return new ChangeResourceParentsRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */