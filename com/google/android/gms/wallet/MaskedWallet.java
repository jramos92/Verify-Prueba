package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWallet> CREATOR = new zzk();
  private final int mVersionCode;
  String zzbcp;
  String zzbcq;
  String zzbcs;
  Address zzbct;
  Address zzbcu;
  String[] zzbcv;
  UserAddress zzbcw;
  UserAddress zzbcx;
  InstrumentInfo[] zzbcy;
  LoyaltyWalletObject[] zzbdi;
  OfferWalletObject[] zzbdj;
  
  private MaskedWallet()
  {
    this.mVersionCode = 2;
  }
  
  MaskedWallet(int paramInt, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, Address paramAddress1, Address paramAddress2, LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject, OfferWalletObject[] paramArrayOfOfferWalletObject, UserAddress paramUserAddress1, UserAddress paramUserAddress2, InstrumentInfo[] paramArrayOfInstrumentInfo)
  {
    this.mVersionCode = paramInt;
    this.zzbcp = paramString1;
    this.zzbcq = paramString2;
    this.zzbcv = paramArrayOfString;
    this.zzbcs = paramString3;
    this.zzbct = paramAddress1;
    this.zzbcu = paramAddress2;
    this.zzbdi = paramArrayOfLoyaltyWalletObject;
    this.zzbdj = paramArrayOfOfferWalletObject;
    this.zzbcw = paramUserAddress1;
    this.zzbcx = paramUserAddress2;
    this.zzbcy = paramArrayOfInstrumentInfo;
  }
  
  public static Builder newBuilderFrom(MaskedWallet paramMaskedWallet)
  {
    zzx.zzw(paramMaskedWallet);
    return zzEC().setGoogleTransactionId(paramMaskedWallet.getGoogleTransactionId()).setMerchantTransactionId(paramMaskedWallet.getMerchantTransactionId()).setPaymentDescriptions(paramMaskedWallet.getPaymentDescriptions()).setInstrumentInfos(paramMaskedWallet.getInstrumentInfos()).setEmail(paramMaskedWallet.getEmail()).zza(paramMaskedWallet.zzED()).zza(paramMaskedWallet.zzEE()).setBuyerBillingAddress(paramMaskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(paramMaskedWallet.getBuyerShippingAddress());
  }
  
  public static Builder zzEC()
  {
    MaskedWallet localMaskedWallet = new MaskedWallet();
    localMaskedWallet.getClass();
    return new Builder(null);
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
    zzk.zza(this, paramParcel, paramInt);
  }
  
  @Deprecated
  public LoyaltyWalletObject[] zzED()
  {
    return this.zzbdi;
  }
  
  @Deprecated
  public OfferWalletObject[] zzEE()
  {
    return this.zzbdj;
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public MaskedWallet build()
    {
      return MaskedWallet.this;
    }
    
    public Builder setBillingAddress(Address paramAddress)
    {
      MaskedWallet.this.zzbct = paramAddress;
      return this;
    }
    
    public Builder setBuyerBillingAddress(UserAddress paramUserAddress)
    {
      MaskedWallet.this.zzbcw = paramUserAddress;
      return this;
    }
    
    public Builder setBuyerShippingAddress(UserAddress paramUserAddress)
    {
      MaskedWallet.this.zzbcx = paramUserAddress;
      return this;
    }
    
    public Builder setEmail(String paramString)
    {
      MaskedWallet.this.zzbcs = paramString;
      return this;
    }
    
    public Builder setGoogleTransactionId(String paramString)
    {
      MaskedWallet.this.zzbcp = paramString;
      return this;
    }
    
    public Builder setInstrumentInfos(InstrumentInfo[] paramArrayOfInstrumentInfo)
    {
      MaskedWallet.this.zzbcy = paramArrayOfInstrumentInfo;
      return this;
    }
    
    public Builder setMerchantTransactionId(String paramString)
    {
      MaskedWallet.this.zzbcq = paramString;
      return this;
    }
    
    public Builder setPaymentDescriptions(String[] paramArrayOfString)
    {
      MaskedWallet.this.zzbcv = paramArrayOfString;
      return this;
    }
    
    public Builder setShippingAddress(Address paramAddress)
    {
      MaskedWallet.this.zzbcu = paramAddress;
      return this;
    }
    
    @Deprecated
    public Builder zza(LoyaltyWalletObject[] paramArrayOfLoyaltyWalletObject)
    {
      MaskedWallet.this.zzbdi = paramArrayOfLoyaltyWalletObject;
      return this;
    }
    
    @Deprecated
    public Builder zza(OfferWalletObject[] paramArrayOfOfferWalletObject)
    {
      MaskedWallet.this.zzbdj = paramArrayOfOfferWalletObject;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\MaskedWallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */