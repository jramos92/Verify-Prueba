package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.ArrayList;

public class zzf
  implements Parcelable.Creator<ProvideContentRequest>
{
  static void zza(ProvideContentRequest paramProvideContentRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramProvideContentRequest.versionCode);
    zzb.zza(paramParcel, 2, paramProvideContentRequest.zzaRq, false);
    zzb.zza(paramParcel, 3, paramProvideContentRequest.zzBo(), false);
    zzb.zzc(paramParcel, 4, paramProvideContentRequest.zzaRs, false);
    zzb.zza(paramParcel, 5, paramProvideContentRequest.zzaRt);
    zzb.zza(paramParcel, 6, paramProvideContentRequest.zzBd(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ProvideContentRequest zzge(Parcel paramParcel)
  {
    IBinder localIBinder1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    long l = 0L;
    ArrayList localArrayList = null;
    IBinder localIBinder2 = null;
    IBinder localIBinder3 = null;
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
        localIBinder3 = zza.zzq(paramParcel, k);
        break;
      case 3: 
        localIBinder2 = zza.zzq(paramParcel, k);
        break;
      case 4: 
        localArrayList = zza.zzc(paramParcel, k, SharedContent.CREATOR);
        break;
      case 5: 
        l = zza.zzi(paramParcel, k);
        break;
      case 6: 
        localIBinder1 = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ProvideContentRequest(i, localIBinder3, localIBinder2, localArrayList, l, localIBinder1);
  }
  
  public ProvideContentRequest[] zziQ(int paramInt)
  {
    return new ProvideContentRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\sharing\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */