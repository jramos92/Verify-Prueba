package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg
  implements Parcelable.Creator<AdRequestParcel>
{
  static void zza(AdRequestParcel paramAdRequestParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramAdRequestParcel.versionCode);
    zzb.zza(paramParcel, 2, paramAdRequestParcel.zzsB);
    zzb.zza(paramParcel, 3, paramAdRequestParcel.extras, false);
    zzb.zzc(paramParcel, 4, paramAdRequestParcel.zzsC);
    zzb.zzb(paramParcel, 5, paramAdRequestParcel.zzsD, false);
    zzb.zza(paramParcel, 6, paramAdRequestParcel.zzsE);
    zzb.zzc(paramParcel, 7, paramAdRequestParcel.zzsF);
    zzb.zza(paramParcel, 8, paramAdRequestParcel.zzsG);
    zzb.zza(paramParcel, 9, paramAdRequestParcel.zzsH, false);
    zzb.zza(paramParcel, 10, paramAdRequestParcel.zzsI, paramInt, false);
    zzb.zza(paramParcel, 11, paramAdRequestParcel.zzsJ, paramInt, false);
    zzb.zza(paramParcel, 12, paramAdRequestParcel.zzsK, false);
    zzb.zza(paramParcel, 13, paramAdRequestParcel.zzsL, false);
    zzb.zza(paramParcel, 14, paramAdRequestParcel.zzsM, false);
    zzb.zzb(paramParcel, 15, paramAdRequestParcel.zzsN, false);
    zzb.zza(paramParcel, 17, paramAdRequestParcel.zzsP, false);
    zzb.zza(paramParcel, 16, paramAdRequestParcel.zzsO, false);
    zzb.zzI(paramParcel, i);
  }
  
  public AdRequestParcel zzb(Parcel paramParcel)
  {
    int m = zza.zzap(paramParcel);
    int k = 0;
    long l = 0L;
    Bundle localBundle3 = null;
    int j = 0;
    ArrayList localArrayList2 = null;
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = false;
    String str4 = null;
    SearchAdRequestParcel localSearchAdRequestParcel = null;
    Location localLocation = null;
    String str3 = null;
    Bundle localBundle2 = null;
    Bundle localBundle1 = null;
    ArrayList localArrayList1 = null;
    String str2 = null;
    String str1 = null;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzao(paramParcel);
      switch (zza.zzbM(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        l = zza.zzi(paramParcel, n);
        break;
      case 3: 
        localBundle3 = zza.zzr(paramParcel, n);
        break;
      case 4: 
        j = zza.zzg(paramParcel, n);
        break;
      case 5: 
        localArrayList2 = zza.zzD(paramParcel, n);
        break;
      case 6: 
        bool2 = zza.zzc(paramParcel, n);
        break;
      case 7: 
        i = zza.zzg(paramParcel, n);
        break;
      case 8: 
        bool1 = zza.zzc(paramParcel, n);
        break;
      case 9: 
        str4 = zza.zzp(paramParcel, n);
        break;
      case 10: 
        localSearchAdRequestParcel = (SearchAdRequestParcel)zza.zza(paramParcel, n, SearchAdRequestParcel.CREATOR);
        break;
      case 11: 
        localLocation = (Location)zza.zza(paramParcel, n, Location.CREATOR);
        break;
      case 12: 
        str3 = zza.zzp(paramParcel, n);
        break;
      case 13: 
        localBundle2 = zza.zzr(paramParcel, n);
        break;
      case 14: 
        localBundle1 = zza.zzr(paramParcel, n);
        break;
      case 15: 
        localArrayList1 = zza.zzD(paramParcel, n);
        break;
      case 17: 
        str1 = zza.zzp(paramParcel, n);
        break;
      case 16: 
        str2 = zza.zzp(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new AdRequestParcel(k, l, localBundle3, j, localArrayList2, bool2, i, bool1, str4, localSearchAdRequestParcel, localLocation, str3, localBundle2, localBundle1, localArrayList1, str2, str1);
  }
  
  public AdRequestParcel[] zzk(int paramInt)
  {
    return new AdRequestParcel[paramInt];
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\client\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */