package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CreateWalletObjectsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CreateWalletObjectsRequest> CREATOR = new zzd();
  private final int mVersionCode;
  LoyaltyWalletObject zzbcm;
  OfferWalletObject zzbcn;
  GiftCardWalletObject zzbco;
  
  CreateWalletObjectsRequest()
  {
    this.mVersionCode = 3;
  }
  
  CreateWalletObjectsRequest(int paramInt, LoyaltyWalletObject paramLoyaltyWalletObject, OfferWalletObject paramOfferWalletObject, GiftCardWalletObject paramGiftCardWalletObject)
  {
    this.mVersionCode = paramInt;
    this.zzbcm = paramLoyaltyWalletObject;
    this.zzbcn = paramOfferWalletObject;
    this.zzbco = paramGiftCardWalletObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\CreateWalletObjectsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */