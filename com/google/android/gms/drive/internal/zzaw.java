package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzaw
  implements Parcelable.Creator<OnContentsResponse>
{
  static void zza(OnContentsResponse paramOnContentsResponse, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnContentsResponse.mVersionCode);
    zzb.zza(paramParcel, 2, paramOnContentsResponse.zzakR, paramInt, false);
    zzb.zza(paramParcel, 3, paramOnContentsResponse.zzalX);
    zzb.zzI(paramParcel, i);
  }
  
  public OnContentsResponse zzbr(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzap(paramParcel);
    Contents localContents = null;
    int i = 0;
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
        localContents = (Contents)zza.zza(paramParcel, k, Contents.CREATOR);
        continue;
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new OnContentsResponse(i, localContents, bool);
  }
  
  public OnContentsResponse[] zzdd(int paramInt)
  {
    return new OnContentsResponse[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */