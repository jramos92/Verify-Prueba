package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzw
  implements Parcelable.Creator<SessionRegistrationRequest>
{
  static void zza(SessionRegistrationRequest paramSessionRegistrationRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramSessionRegistrationRequest.zzta(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramSessionRegistrationRequest.getVersionCode());
    zzb.zza(paramParcel, 2, paramSessionRegistrationRequest.zzsO(), false);
    zzb.zzc(paramParcel, 4, paramSessionRegistrationRequest.zztj());
    zzb.zzI(paramParcel, i);
  }
  
  public SessionRegistrationRequest zzdr(Parcel paramParcel)
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
        localObject3 = (PendingIntent)zza.zza(paramParcel, m, PendingIntent.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        j = zza.zzg(paramParcel, m);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = zza.zzq(paramParcel, m);
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
    return new SessionRegistrationRequest(j, (PendingIntent)localObject1, (IBinder)localObject2, i);
  }
  
  public SessionRegistrationRequest[] zzfj(int paramInt)
  {
    return new SessionRegistrationRequest[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */