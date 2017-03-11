package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzi
  implements Parcelable.Creator<CloseContentsRequest>
{
  static void zza(CloseContentsRequest paramCloseContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramCloseContentsRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramCloseContentsRequest.zzake, paramInt, false);
    zzb.zza(paramParcel, 3, paramCloseContentsRequest.zzaki, false);
    zzb.zzc(paramParcel, 4, paramCloseContentsRequest.zzakg);
    zzb.zzI(paramParcel, i);
  }
  
  public CloseContentsRequest zzaY(Parcel paramParcel)
  {
    Object localObject2 = null;
    int i = 0;
    int k = zza.zzap(paramParcel);
    Object localObject1 = null;
    int j = 0;
    if (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      Object localObject3;
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
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
        j = zza.zzg(paramParcel, m);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (Contents)zza.zza(paramParcel, m, Contents.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = zza.zzd(paramParcel, m);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        i = zza.zzg(paramParcel, m);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new CloseContentsRequest(j, (Contents)localObject1, (Boolean)localObject2, i);
  }
  
  public CloseContentsRequest[] zzcF(int paramInt)
  {
    return new CloseContentsRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */