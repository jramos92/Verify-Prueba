package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzz
  implements Parcelable.Creator<SessionUnregistrationRequest>
{
  static void zza(SessionUnregistrationRequest paramSessionUnregistrationRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramSessionUnregistrationRequest.zzta(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramSessionUnregistrationRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramSessionUnregistrationRequest.zzsO(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public SessionUnregistrationRequest zzdu(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    PendingIntent localPendingIntent = null;
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
        localPendingIntent = (PendingIntent)zza.zza(paramParcel, k, PendingIntent.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SessionUnregistrationRequest(i, localPendingIntent, localIBinder);
  }
  
  public SessionUnregistrationRequest[] zzfm(int paramInt)
  {
    return new SessionUnregistrationRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */