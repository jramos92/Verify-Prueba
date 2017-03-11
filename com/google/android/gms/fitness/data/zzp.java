package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp
  implements Parcelable.Creator<Session>
{
  static void zza(Session paramSession, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramSession.zzkX());
    zzb.zzc(paramParcel, 1000, paramSession.getVersionCode());
    zzb.zza(paramParcel, 2, paramSession.zzsi());
    zzb.zza(paramParcel, 3, paramSession.getName(), false);
    zzb.zza(paramParcel, 4, paramSession.getIdentifier(), false);
    zzb.zza(paramParcel, 5, paramSession.getDescription(), false);
    zzb.zzc(paramParcel, 7, paramSession.zzsg());
    zzb.zza(paramParcel, 8, paramSession.zzsr(), paramInt, false);
    zzb.zza(paramParcel, 9, paramSession.zzsz(), false);
    zzb.zzI(paramParcel, i);
  }
  
  public Session zzcR(Parcel paramParcel)
  {
    long l1 = 0L;
    int i = 0;
    Long localLong = null;
    int k = zza.zzap(paramParcel);
    Application localApplication = null;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    long l2 = 0L;
    int j = 0;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzao(paramParcel);
      switch (zza.zzbM(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        l2 = zza.zzi(paramParcel, m);
        break;
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        l1 = zza.zzi(paramParcel, m);
        break;
      case 3: 
        str3 = zza.zzp(paramParcel, m);
        break;
      case 4: 
        str2 = zza.zzp(paramParcel, m);
        break;
      case 5: 
        str1 = zza.zzp(paramParcel, m);
        break;
      case 7: 
        i = zza.zzg(paramParcel, m);
        break;
      case 8: 
        localApplication = (Application)zza.zza(paramParcel, m, Application.CREATOR);
        break;
      case 9: 
        localLong = zza.zzj(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new Session(j, l2, l1, str3, str2, str1, i, localApplication, localLong);
  }
  
  public Session[] zzeI(int paramInt)
  {
    return new Session[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */