package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class FullWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<FullWallet> CREATOR = new zze();
  private final int mVersionCode;
  String zzbcp;
  String zzbcq;
  ProxyCard zzbcr;
  String zzbcs;
  Address zzbct;
  Address zzbcu;
  String[] zzbcv;
  UserAddress zzbcw;
  UserAddress zzbcx;
  InstrumentInfo[] zzbcy;
  PaymentMethodToken zzbcz;
  
  private FullWallet()
  {
    this.mVersionCode = 1;
  }
  
  FullWallet(int paramInt, String paramString1, String paramString2, ProxyCard paramProxyCard, String paramString3, Address paramAddress1, Address paramAddress2, String[] paramArrayOfString, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo, PaymentMethodToken paramPaymentMethodToken)
  {
    this.mVersionCode = paramInt;
    this.zzbcp = paramString1;
    this.zzbcq = paramString2;
    this.zzbcr = paramProxyCard;
    this.zzbcs = paramString3;
    this.zzbct = paramAddress1;
    this.zzbcu = paramAddress2;
    this.zzbcv = paramArrayOfString;
    this.zzbcw = paramUserAddress1;
    this.zzbcx = paramUserAddress2;
    this.zzbcy = paramArrayOfInstrumentInfo;
    this.zzbcz = paramPaymentMethodToken;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Deprecated
  public Address getBillingAddress()
  {
    return this.zzbct;
  }
  
  public UserAddress getBuyerBillingAddress()
  {
    return this.zzbcw;
  }
  
  public UserAddress getBuyerShippingAddress()
  {
    return this.zzbcx;
  }
  
  public String getEmail()
  {
    return this.zzbcs;
  }
  
  public String getGoogleTransactionId()
  {
    return this.zzbcp;
  }
  
  public InstrumentInfo[] getInstrumentInfos()
  {
    return this.zzbcy;
  }
  
  public String getMerchantTransactionId()
  {
    return this.zzbcq;
  }
  
  public String[] getPaymentDescriptions()
  {
    return this.zzbcv;
  }
  
  public PaymentMethodToken getPaymentMethodToken()
  {
    return this.zzbcz;
  }
  
  public ProxyCard getProxyCard()
  {
    return this.zzbcr;
  }
  
  @Deprecated
  public Address getShippingAddress()
  {
    return this.zzbcu;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\FullWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */