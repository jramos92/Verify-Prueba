package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgr;

@zzgr
public final class RewardedVideoAdRequestParcel
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  public final int versionCode;
  public final AdRequestParcel zzEn;
  public final String zzqh;
  
  public RewardedVideoAdRequestParcel(int paramInt, AdRequestParcel paramAdRequestParcel, String paramString)
  {
    this.versionCode = paramInt;
    this.zzEn = paramAdRequestParcel;
    this.zzqh = paramString;
  }
  
  public RewardedVideoAdRequestParcel(AdRequestParcel paramAdRequestParcel, String paramString)
  {
    this(1, paramAdRequestParcel, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\reward\client\RewardedVideoAdRequestParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */