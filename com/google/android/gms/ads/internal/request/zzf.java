package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf
  implements Parcelable.Creator<AdRequestInfoParcel>
{
  static void zza(AdRequestInfoParcel paramAdRequestInfoParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzaq(paramParcel);
    zzb.zzc(paramParcel, 1, paramAdRequestInfoParcel.versionCode);
    zzb.zza(paramParcel, 2, paramAdRequestInfoParcel.zzEm, false);
    zzb.zza(paramParcel, 3, paramAdRequestInfoParcel.zzEn, paramInt, false);
    zzb.zza(paramParcel, 4, paramAdRequestInfoParcel.zzqn, paramInt, false);
    zzb.zza(paramParcel, 5, paramAdRequestInfoParcel.zzqh, false);
    zzb.zza(paramParcel, 6, paramAdRequestInfoParcel.applicationInfo, paramInt, false);
    zzb.zza(paramParcel, 7, paramAdRequestInfoParcel.zzEo, paramInt, false);
    zzb.zza(paramParcel, 8, paramAdRequestInfoParcel.zzEp, false);
    zzb.zza(paramParcel, 9, paramAdRequestInfoParcel.zzEq, false);
    zzb.zza(paramParcel, 10, paramAdRequestInfoParcel.zzEr, false);
    zzb.zza(paramParcel, 11, paramAdRequestInfoParcel.zzqj, paramInt, false);
    zzb.zza(paramParcel, 12, paramAdRequestInfoParcel.zzEs, false);
    zzb.zzc(paramParcel, 13, paramAdRequestInfoParcel.zzEt);
    zzb.zzb(paramParcel, 14, paramAdRequestInfoParcel.zzqD, false);
    zzb.zza(paramParcel, 15, paramAdRequestInfoParcel.zzEu, false);
    zzb.zza(paramParcel, 17, paramAdRequestInfoParcel.zzEw, paramInt, false);
    zzb.zza(paramParcel, 16, paramAdRequestInfoParcel.zzEv);
    zzb.zzc(paramParcel, 19, paramAdRequestInfoParcel.zzEy);
    zzb.zzc(paramParcel, 18, paramAdRequestInfoParcel.zzEx);
    zzb.zza(paramParcel, 21, paramAdRequestInfoParcel.zzEA, false);
    zzb.zza(paramParcel, 20, paramAdRequestInfoParcel.zzEz);
    zzb.zza(paramParcel, 25, paramAdRequestInfoParcel.zzEB);
    zzb.zzb(paramParcel, 27, paramAdRequestInfoParcel.zzED, false);
    zzb.zza(paramParcel, 26, paramAdRequestInfoParcel.zzEC, false);
    zzb.zza(paramParcel, 29, paramAdRequestInfoParcel.zzqB, paramInt, false);
    zzb.zza(paramParcel, 28, paramAdRequestInfoParcel.zzqg, false);
    zzb.zza(paramParcel, 31, paramAdRequestInfoParcel.zzEF);
    zzb.zzb(paramParcel, 30, paramAdRequestInfoParcel.zzEE, false);
    zzb.zza(paramParcel, 32, paramAdRequestInfoParcel.zzEG, paramInt, false);
    zzb.zza(paramParcel, 33, paramAdRequestInfoParcel.zzEH, false);
    zzb.zzI(paramParcel, i);
  }
  
  public AdRequestInfoParcel[] zzD(int paramInt)
  {
    return new AdRequestInfoParcel[paramInt];
  }
  
  public AdRequestInfoParcel zzi(Parcel paramParcel)
  {
    int n = zza.zzap(paramParcel);
    int m = 0;
    Bundle localBundle3 = null;
    AdRequestParcel localAdRequestParcel = null;
    AdSizeParcel localAdSizeParcel = null;
    String str8 = null;
    ApplicationInfo localApplicationInfo = null;
    PackageInfo localPackageInfo = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    VersionInfoParcel localVersionInfoParcel = null;
    Bundle localBundle2 = null;
    int k = 0;
    ArrayList localArrayList3 = null;
    Bundle localBundle1 = null;
    boolean bool = false;
    Messenger localMessenger = null;
    int j = 0;
    int i = 0;
    float f = 0.0F;
    String str4 = null;
    long l2 = 0L;
    String str3 = null;
    ArrayList localArrayList2 = null;
    String str2 = null;
    NativeAdOptionsParcel localNativeAdOptionsParcel = null;
    ArrayList localArrayList1 = null;
    long l1 = 0L;
    CapabilityParcel localCapabilityParcel = null;
    String str1 = null;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzao(paramParcel);
      switch (zza.zzbM(i1))
      {
      case 22: 
      case 23: 
      case 24: 
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        localBundle3 = zza.zzr(paramParcel, i1);
        break;
      case 3: 
        localAdRequestParcel = (AdRequestParcel)zza.zza(paramParcel, i1, AdRequestParcel.CREATOR);
        break;
      case 4: 
        localAdSizeParcel = (AdSizeParcel)zza.zza(paramParcel, i1, AdSizeParcel.CREATOR);
        break;
      case 5: 
        str8 = zza.zzp(paramParcel, i1);
        break;
      case 6: 
        localApplicationInfo = (ApplicationInfo)zza.zza(paramParcel, i1, ApplicationInfo.CREATOR);
        break;
      case 7: 
        localPackageInfo = (PackageInfo)zza.zza(paramParcel, i1, PackageInfo.CREATOR);
        break;
      case 8: 
        str7 = zza.zzp(paramParcel, i1);
        break;
      case 9: 
        str6 = zza.zzp(paramParcel, i1);
        break;
      case 10: 
        str5 = zza.zzp(paramParcel, i1);
        break;
      case 11: 
        localVersionInfoParcel = (VersionInfoParcel)zza.zza(paramParcel, i1, VersionInfoParcel.CREATOR);
        break;
      case 12: 
        localBundle2 = zza.zzr(paramParcel, i1);
        break;
      case 13: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 14: 
        localArrayList3 = zza.zzD(paramParcel, i1);
        break;
      case 15: 
        localBundle1 = zza.zzr(paramParcel, i1);
        break;
      case 17: 
        localMessenger = (Messenger)zza.zza(paramParcel, i1, Messenger.CREATOR);
        break;
      case 16: 
        bool = zza.zzc(paramParcel, i1);
        break;
      case 19: 
        i = zza.zzg(paramParcel, i1);
        break;
      case 18: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 21: 
        str4 = zza.zzp(paramParcel, i1);
        break;
      case 20: 
        f = zza.zzl(paramParcel, i1);
        break;
      case 25: 
        l2 = zza.zzi(paramParcel, i1);
        break;
      case 27: 
        localArrayList2 = zza.zzD(paramParcel, i1);
        break;
      case 26: 
        str3 = zza.zzp(paramParcel, i1);
        break;
      case 29: 
        localNativeAdOptionsParcel = (NativeAdOptionsParcel)zza.zza(paramParcel, i1, NativeAdOptionsParcel.CREATOR);
        break;
      case 28: 
        str2 = zza.zzp(paramParcel, i1);
        break;
      case 31: 
        l1 = zza.zzi(paramParcel, i1);
        break;
      case 30: 
        localArrayList1 = zza.zzD(paramParcel, i1);
        break;
      case 32: 
        localCapabilityParcel = (CapabilityParcel)zza.zza(paramParcel, i1, CapabilityParcel.CREATOR);
        break;
      case 33: 
        str1 = zza.zzp(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new AdRequestInfoParcel(m, localBundle3, localAdRequestParcel, localAdSizeParcel, str8, localApplicationInfo, localPackageInfo, str7, str6, str5, localVersionInfoParcel, localBundle2, k, localArrayList3, localBundle1, bool, localMessenger, j, i, f, str4, l2, str3, localArrayList2, str2, localNativeAdOptionsParcel, localArrayList1, l1, localCapabilityParcel, str1);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\request\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */