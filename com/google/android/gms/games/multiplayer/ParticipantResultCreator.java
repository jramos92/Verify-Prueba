package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class ParticipantResultCreator
  implements Parcelable.Creator<ParticipantResult>
{
  static void zza(ParticipantResult paramParticipantResult, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zza(paramParcel, 1, paramParticipantResult.getParticipantId(), false);
    zzb.zzc(paramParcel, 1000, paramParticipantResult.getVersionCode());
    zzb.zzc(paramParcel, 2, paramParticipantResult.getResult());
    zzb.zzc(paramParcel, 3, paramParticipantResult.getPlacing());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ParticipantResult zzeg(Parcel paramParcel)
  {
    int k = 0;
    int m = zza.zzap(paramParcel);
    String str = null;
    int j = 0;
    int i = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        str = zza.zzp(paramParcel, n);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, n);
        break;
      case 2: 
        j = zza.zzg(paramParcel, n);
        break;
      case 3: 
        k = zza.zzg(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new ParticipantResult(i, str, j, k);
  }
  
  public ParticipantResult[] zzgm(int paramInt)
  {
    return new ParticipantResult[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\multiplayer\ParticipantResultCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */