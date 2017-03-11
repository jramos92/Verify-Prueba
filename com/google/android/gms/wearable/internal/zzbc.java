package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbc
  implements Parcelable.Creator<NodeParcelable>
{
  static void zza(NodeParcelable paramNodeParcelable, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramNodeParcelable.mVersionCode);
    zzb.zza(paramParcel, 2, paramNodeParcelable.getId(), false);
    zzb.zza(paramParcel, 3, paramNodeParcelable.getDisplayName(), false);
    zzb.zzc(paramParcel, 4, paramNodeParcelable.getHopCount());
    zzb.zza(paramParcel, 5, paramNodeParcelable.isNearby());
    zzb.zzI(paramParcel, paramInt);
  }
  
  public NodeParcelable zzii(Parcel paramParcel)
  {
    String str1 = null;
    boolean bool = false;
    int k = zza.zzap(paramParcel);
    int i = 0;
    String str2 = null;
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
        j = zza.zzg(paramParcel, m);
        break;
      case 2: 
        str2 = zza.zzp(paramParcel, m);
        break;
      case 3: 
        str1 = zza.zzp(paramParcel, m);
        break;
      case 4: 
        i = zza.zzg(paramParcel, m);
        break;
      case 5: 
        bool = zza.zzc(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new NodeParcelable(j, str2, str1, i, bool);
  }
  
  public NodeParcelable[] zzlr(int paramInt)
  {
    return new NodeParcelable[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\zzbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */