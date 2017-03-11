package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;

public class zzb
  implements Parcelable.Creator<SortOrder>
{
  static void zza(SortOrder paramSortOrder, Parcel paramParcel, int paramInt)
  {
    paramInt = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, paramSortOrder.mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1, paramSortOrder.zzanS, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramSortOrder.zzanT);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, paramInt);
  }
  
  public SortOrder zzcb(Parcel paramParcel)
  {
    boolean bool = false;
    int j = zza.zzap(paramParcel);
    ArrayList localArrayList = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 1: 
        localArrayList = zza.zzc(paramParcel, k, FieldWithSortOrder.CREATOR);
        break;
      case 2: 
        bool = zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SortOrder(i, localArrayList, bool);
  }
  
  public SortOrder[] zzdN(int paramInt)
  {
    return new SortOrder[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */