package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class AppContentSectionEntityCreator
  implements Parcelable.Creator<AppContentSectionEntity>
{
  static void zza(AppContentSectionEntity paramAppContentSectionEntity, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramAppContentSectionEntity.getActions(), false);
    zzb.zzc(paramParcel, 1000, paramAppContentSectionEntity.getVersionCode());
    zzb.zzc(paramParcel, 3, paramAppContentSectionEntity.zzuk(), false);
    zzb.zza(paramParcel, 4, paramAppContentSectionEntity.zztQ(), false);
    zzb.zza(paramParcel, 5, paramAppContentSectionEntity.getExtras(), false);
    zzb.zza(paramParcel, 6, paramAppContentSectionEntity.zzuc(), false);
    zzb.zza(paramParcel, 7, paramAppContentSectionEntity.getTitle(), false);
    zzb.zza(paramParcel, 8, paramAppContentSectionEntity.getType(), false);
    zzb.zza(paramParcel, 9, paramAppContentSectionEntity.getId(), false);
    zzb.zza(paramParcel, 10, paramAppContentSectionEntity.zzul(), false);
    zzb.zzc(paramParcel, 14, paramAppContentSectionEntity.zzua(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public AppContentSectionEntity zzdW(Parcel paramParcel)
  {
    ArrayList localArrayList1 = null;
    int j = zza.zzap(paramParcel);
    int i = 0;
    String str1 = null;
    String str2 = null;
    String str3 = null;
    String str4 = null;
    String str5 = null;
    Bundle localBundle = null;
    String str6 = null;
    ArrayList localArrayList2 = null;
    ArrayList localArrayList3 = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzao(paramParcel);
      switch (zza.zzbM(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        localArrayList3 = zza.zzc(paramParcel, k, AppContentActionEntity.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 3: 
        localArrayList2 = zza.zzc(paramParcel, k, AppContentCardEntity.CREATOR);
        break;
      case 4: 
        str6 = zza.zzp(paramParcel, k);
        break;
      case 5: 
        localBundle = zza.zzr(paramParcel, k);
        break;
      case 6: 
        str5 = zza.zzp(paramParcel, k);
        break;
      case 7: 
        str4 = zza.zzp(paramParcel, k);
        break;
      case 8: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 9: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 10: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 14: 
        localArrayList1 = zza.zzc(paramParcel, k, AppContentAnnotationEntity.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new AppContentSectionEntity(i, localArrayList3, localArrayList2, str6, localBundle, str5, str4, str3, str2, str1, localArrayList1);
  }
  
  public AppContentSectionEntity[] zzfP(int paramInt)
  {
    return new AppContentSectionEntity[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\appcontent\AppContentSectionEntityCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */