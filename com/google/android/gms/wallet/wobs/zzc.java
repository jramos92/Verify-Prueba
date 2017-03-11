package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzmj;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<LabelValueRow>
{
  static void zza(LabelValueRow paramLabelValueRow, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramLabelValueRow.getVersionCode());
    zzb.zza(paramParcel, 2, paramLabelValueRow.zzbeD, false);
    zzb.zza(paramParcel, 3, paramLabelValueRow.zzbeE, false);
    zzb.zzc(paramParcel, 4, paramLabelValueRow.zzbeF, false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public LabelValueRow zzhx(Parcel paramParcel)
  {
    String str2 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    ArrayList localArrayList = zzmj.zzqs();
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
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        localArrayList = zza.zzc(paramParcel, k, LabelValue.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new LabelValueRow(i, str1, str2, localArrayList);
  }
  
  public LabelValueRow[] zzkD(int paramInt)
  {
    return new LabelValueRow[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\wobs\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */