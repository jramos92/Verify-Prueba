package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zzmj;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.wallet.wobs.LabelValueRow;
import com.google.android.gms.wallet.wobs.LoyaltyPoints;
import com.google.android.gms.wallet.wobs.TextModuleData;
import com.google.android.gms.wallet.wobs.TimeInterval;
import com.google.android.gms.wallet.wobs.UriData;
import com.google.android.gms.wallet.wobs.WalletObjectMessage;
import java.util.ArrayList;

public class zzj
  implements Parcelable.Creator<LoyaltyWalletObject>
{
  static void zza(LoyaltyWalletObject paramLoyaltyWalletObject, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramLoyaltyWalletObject.getVersionCode());
    zzb.zza(paramParcel, 2, paramLoyaltyWalletObject.zzhL, false);
    zzb.zza(paramParcel, 3, paramLoyaltyWalletObject.zzbcP, false);
    zzb.zza(paramParcel, 4, paramLoyaltyWalletObject.zzbcQ, false);
    zzb.zza(paramParcel, 5, paramLoyaltyWalletObject.zzbcR, false);
    zzb.zza(paramParcel, 6, paramLoyaltyWalletObject.zzaHT, false);
    zzb.zza(paramParcel, 7, paramLoyaltyWalletObject.zzbcS, false);
    zzb.zza(paramParcel, 8, paramLoyaltyWalletObject.zzbcT, false);
    zzb.zza(paramParcel, 9, paramLoyaltyWalletObject.zzbcU, false);
    zzb.zza(paramParcel, 10, paramLoyaltyWalletObject.zzbcV, false);
    zzb.zza(paramParcel, 11, paramLoyaltyWalletObject.zzbcW, false);
    zzb.zzc(paramParcel, 12, paramLoyaltyWalletObject.state);
    zzb.zzc(paramParcel, 13, paramLoyaltyWalletObject.zzbcX, false);
    zzb.zza(paramParcel, 14, paramLoyaltyWalletObject.zzbcY, paramInt, false);
    zzb.zzc(paramParcel, 15, paramLoyaltyWalletObject.zzbcZ, false);
    zzb.zza(paramParcel, 17, paramLoyaltyWalletObject.zzbdb, false);
    zzb.zza(paramParcel, 16, paramLoyaltyWalletObject.zzbda, false);
    zzb.zza(paramParcel, 19, paramLoyaltyWalletObject.zzbdd);
    zzb.zzc(paramParcel, 18, paramLoyaltyWalletObject.zzbdc, false);
    zzb.zzc(paramParcel, 21, paramLoyaltyWalletObject.zzbdf, false);
    zzb.zzc(paramParcel, 20, paramLoyaltyWalletObject.zzbde, false);
    zzb.zza(paramParcel, 23, paramLoyaltyWalletObject.zzbdh, paramInt, false);
    zzb.zzc(paramParcel, 22, paramLoyaltyWalletObject.zzbdg, false);
    zzb.zzI(paramParcel, i);
  }
  
  public LoyaltyWalletObject zzhf(Parcel paramParcel)
  {
    int k = zza.zzap(paramParcel);
    int j = 0;
    String str12 = null;
    String str11 = null;
    String str10 = null;
    String str9 = null;
    String str8 = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    String str4 = null;
    String str3 = null;
    int i = 0;
    ArrayList localArrayList6 = zzmj.zzqs();
    TimeInterval localTimeInterval = null;
    ArrayList localArrayList5 = zzmj.zzqs();
    String str2 = null;
    String str1 = null;
    ArrayList localArrayList4 = zzmj.zzqs();
    boolean bool = false;
    ArrayList localArrayList3 = zzmj.zzqs();
    ArrayList localArrayList2 = zzmj.zzqs();
    ArrayList localArrayList1 = zzmj.zzqs();
    LoyaltyPoints localLoyaltyPoints = null;
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
        str12 = zza.zzp(paramParcel, m);
        break;
      case 3: 
        str11 = zza.zzp(paramParcel, m);
        break;
      case 4: 
        str10 = zza.zzp(paramParcel, m);
        break;
      case 5: 
        str9 = zza.zzp(paramParcel, m);
        break;
      case 6: 
        str8 = zza.zzp(paramParcel, m);
        break;
      case 7: 
        str7 = zza.zzp(paramParcel, m);
        break;
      case 8: 
        str6 = zza.zzp(paramParcel, m);
        break;
      case 9: 
        str5 = zza.zzp(paramParcel, m);
        break;
      case 10: 
        str4 = zza.zzp(paramParcel, m);
        break;
      case 11: 
        str3 = zza.zzp(paramParcel, m);
        break;
      case 12: 
        i = zza.zzg(paramParcel, m);
        break;
      case 13: 
        localArrayList6 = zza.zzc(paramParcel, m, WalletObjectMessage.CREATOR);
        break;
      case 14: 
        localTimeInterval = (TimeInterval)zza.zza(paramParcel, m, TimeInterval.CREATOR);
        break;
      case 15: 
        localArrayList5 = zza.zzc(paramParcel, m, LatLng.CREATOR);
        break;
      case 17: 
        str1 = zza.zzp(paramParcel, m);
        break;
      case 16: 
        str2 = zza.zzp(paramParcel, m);
        break;
      case 19: 
        bool = zza.zzc(paramParcel, m);
        break;
      case 18: 
        localArrayList4 = zza.zzc(paramParcel, m, LabelValueRow.CREATOR);
        break;
      case 21: 
        localArrayList2 = zza.zzc(paramParcel, m, TextModuleData.CREATOR);
        break;
      case 20: 
        localArrayList3 = zza.zzc(paramParcel, m, UriData.CREATOR);
        break;
      case 23: 
        localLoyaltyPoints = (LoyaltyPoints)zza.zza(paramParcel, m, LoyaltyPoints.CREATOR);
        break;
      case 22: 
        localArrayList1 = zza.zzc(paramParcel, m, UriData.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new LoyaltyWalletObject(j, str12, str11, str10, str9, str8, str7, str6, str5, str4, str3, i, localArrayList6, localTimeInterval, localArrayList5, str2, str1, localArrayList4, bool, localArrayList3, localArrayList2, localArrayList1, localLoyaltyPoints);
  }
  
  public LoyaltyWalletObject[] zzki(int paramInt)
  {
    return new LoyaltyWalletObject[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */