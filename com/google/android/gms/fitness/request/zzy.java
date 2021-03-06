package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy
  implements Parcelable.Creator<SessionStopRequest>
{
  static void zza(SessionStopRequest paramSessionStopRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramSessionStopRequest.getName(), false);
    zzb.zzc(paramParcel, 1000, paramSessionStopRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramSessionStopRequest.getIdentifier(), false);
    zzb.zza(paramParcel, 3, paramSessionStopRequest.zzsO(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public SessionStopRequest zzdt(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SessionStopRequest(i, str1, str2, localIBinder);
  }
  
  public SessionStopRequest[] zzfl(int paramInt)
  {
    return new SessionStopRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */