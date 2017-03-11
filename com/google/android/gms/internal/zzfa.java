package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.zza;
import java.util.Date;
import java.util.HashSet;

@zzgr
public final class zzfa
{
  public static int zza(AdRequest.ErrorCode paramErrorCode)
  {
    switch (1.zzzU[paramErrorCode.ordinal()])
    {
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static AdSize zzb(AdSizeParcel paramAdSizeParcel)
  {
    int i = 0;
    AdSize[] arrayOfAdSize = new AdSize[6];
    arrayOfAdSize[0] = AdSize.SMART_BANNER;
    arrayOfAdSize[1] = AdSize.BANNER;
    arrayOfAdSize[2] = AdSize.IAB_MRECT;
    arrayOfAdSize[3] = AdSize.IAB_BANNER;
    arrayOfAdSize[4] = AdSize.IAB_LEADERBOARD;
    arrayOfAdSize[5] = AdSize.IAB_WIDE_SKYSCRAPER;
    while (i < arrayOfAdSize.length)
    {
      if ((arrayOfAdSize[i].getWidth() == paramAdSizeParcel.width) && (arrayOfAdSize[i].getHeight() == paramAdSizeParcel.height)) {
        return arrayOfAdSize[i];
      }
      i += 1;
    }
    return new AdSize(zza.zza(paramAdSizeParcel.width, paramAdSizeParcel.height, paramAdSizeParcel.zzte));
  }
  
  public static MediationAdRequest zzh(AdRequestParcel paramAdRequestParcel)
  {
    if (paramAdRequestParcel.zzsD != null) {}
    for (HashSet localHashSet = new HashSet(paramAdRequestParcel.zzsD);; localHashSet = null) {
      return new MediationAdRequest(new Date(paramAdRequestParcel.zzsB), zzr(paramAdRequestParcel.zzsC), localHashSet, paramAdRequestParcel.zzsE, paramAdRequestParcel.zzsJ);
    }
  }
  
  public static AdRequest.Gender zzr(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return AdRequest.Gender.UNKNOWN;
    case 2: 
      return AdRequest.Gender.FEMALE;
    }
    return AdRequest.Gender.MALE;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzfa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */