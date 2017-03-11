package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wallet.wobs.CommonWalletObject.zza;

public final class OfferWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<OfferWalletObject> CREATOR = new zzn();
  private final int mVersionCode;
  CommonWalletObject zzbcC;
  String zzbdB;
  String zzhL;
  
  OfferWalletObject()
  {
    this.mVersionCode = 3;
  }
  
  OfferWalletObject(int paramInt, String paramString1, String paramString2, CommonWalletObject paramCommonWalletObject)
  {
    this.mVersionCode = paramInt;
    this.zzbdB = paramString2;
    if (paramInt < 3)
    {
      this.zzbcC = CommonWalletObject.zzEI().zzfv(paramString1).zzEJ();
      return;
    }
    this.zzbcC = paramCommonWalletObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.zzbcC.getId();
  }
  
  public String getRedemptionCode()
  {
    return this.zzbdB;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\OfferWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */