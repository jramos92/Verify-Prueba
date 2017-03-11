package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq
  implements Parcelable.Creator<ParcelableCollaborator>
{
  static void zza(ParcelableCollaborator paramParcelableCollaborator, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramParcelableCollaborator.mVersionCode);
    zzb.zza(paramParcel, 2, paramParcelableCollaborator.zzaox);
    zzb.zza(paramParcel, 3, paramParcelableCollaborator.zzaoy);
    zzb.zza(paramParcel, 4, paramParcelableCollaborator.zzHP, false);
    zzb.zza(paramParcel, 5, paramParcelableCollaborator.zzGY, false);
    zzb.zza(paramParcel, 6, paramParcelableCollaborator.zzTa, false);
    zzb.zza(paramParcel, 7, paramParcelableCollaborator.zzaoz, false);
    zzb.zza(paramParcel, 8, paramParcelableCollaborator.zzaoA, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public ParcelableCollaborator zzcr(Parcel paramParcel)
  {
    boolean bool1 = false;
    String str1 = null;
    int j = zza.zzap(paramParcel);
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    boolean bool2 = false;
    int i = 0;
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
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 3: 
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 4: 
        str5 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        str4 = zza.zzp(paramParcel, k);
        break;
      case 6: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 7: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 8: 
        str1 = zza.zzp(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ParcelableCollaborator(i, bool2, bool1, str5, str4, str3, str2, str1);
  }
  
  public ParcelableCollaborator[] zzee(int paramInt)
  {
    return new ParcelableCollaborator[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */