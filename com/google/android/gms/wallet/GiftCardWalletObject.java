package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;
import com.google.android.gms.wallet.wobs.CommonWalletObject.zza;

public final class GiftCardWalletObject
  implements SafeParcelable
{
  public static final Parcelable.Creator<GiftCardWalletObject> CREATOR = new zzg();
  final int mVersionCode;
  String pin;
  CommonWalletObject zzbcC = CommonWalletObject.zzEI().zzEJ();
  String zzbcD;
  String zzbcE;
  long zzbcF;
  String zzbcG;
  long zzbcH;
  String zzbcI;
  
  GiftCardWalletObject()
  {
    this.mVersionCode = 1;
  }
  
  GiftCardWalletObject(int paramInt, CommonWalletObject paramCommonWalletObject, String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, long paramLong2, String paramString5)
  {
    this.mVersionCode = paramInt;
    this.zzbcC = paramCommonWalletObject;
    this.zzbcD = paramString1;
    this.pin = paramString2;
    this.zzbcF = paramLong1;
    this.zzbcG = paramString4;
    this.zzbcH = paramLong2;
    this.zzbcI = paramString5;
    this.zzbcE = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.zzbcC.getId();
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\GiftCardWalletObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */