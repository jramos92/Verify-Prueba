package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<MaskedWalletRequest> CREATOR = new zzl();
  private final int mVersionCode;
  Cart zzbcA;
  String zzbcj;
  String zzbcq;
  boolean zzbdl;
  boolean zzbdm;
  boolean zzbdn;
  String zzbdo;
  String zzbdp;
  boolean zzbdq;
  boolean zzbdr;
  CountrySpecification[] zzbds;
  boolean zzbdt;
  boolean zzbdu;
  ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> zzbdv;
  PaymentMethodTokenizationParameters zzbdw;
  ArrayList<Integer> zzbdx;
  
  MaskedWalletRequest()
  {
    this.mVersionCode = 3;
    this.zzbdt = true;
    this.zzbdu = true;
  }
  
  MaskedWalletRequest(int paramInt, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString2, String paramString3, String paramString4, Cart paramCart, boolean paramBoolean4, boolean paramBoolean5, CountrySpecification[] paramArrayOfCountrySpecification, boolean paramBoolean6, boolean paramBoolean7, ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> paramArrayList, PaymentMethodTokenizationParameters paramPaymentMethodTokenizationParameters, ArrayList<Integer> paramArrayList1)
  {
    this.mVersionCode = paramInt;
    this.zzbcq = paramString1;
    this.zzbdl = paramBoolean1;
    this.zzbdm = paramBoolean2;
    this.zzbdn = paramBoolean3;
    this.zzbdo = paramString2;
    this.zzbcj = paramString3;
    this.zzbdp = paramString4;
    this.zzbcA = paramCart;
    this.zzbdq = paramBoolean4;
    this.zzbdr = paramBoolean5;
    this.zzbds = paramArrayOfCountrySpecification;
    this.zzbdt = paramBoolean6;
    this.zzbdu = paramBoolean7;
    this.zzbdv = paramArrayList;
    this.zzbdw = paramPaymentMethodTokenizationParameters;
    this.zzbdx = paramArrayList1;
  }
  
  public static Builder newBuilder()
  {
    MaskedWalletRequest localMaskedWalletRequest = new MaskedWalletRequest();
    localMaskedWalletRequest.getClass();
    return new Builder(null);
  }
  
  public boolean allowDebitCard()
  {
    return this.zzbdu;
  }
  
  public boolean allowPrepaidCard()
  {
    return this.zzbdt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public ArrayList<Integer> getAllowedCardNetworks()
  {
    return this.zzbdx;
  }
  
  public ArrayList<com.google.android.gms.identity.intents.model.CountrySpecification> getAllowedCountrySpecificationsForShipping()
  {
    return this.zzbdv;
  }
  
  public CountrySpecification[] getAllowedShippingCountrySpecifications()
  {
    return this.zzbds;
  }
  
  public Cart getCart()
  {
    return this.zzbcA;
  }
  
  public String getCurrencyCode()
  {
    return this.zzbcj;
  }
  
  public String getEstimatedTotalPrice()
  {
    return this.zzbdo;
  }
  
  public String getMerchantName()
  {
    return this.zzbdp;
  }
  
  public String getMerchantTransactionId()
  {
    return this.zzbcq;
  }
  
  public PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters()
  {
    return this.zzbdw;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean isBillingAgreement()
  {
    return this.zzbdr;
  }
  
  public boolean isPhoneNumberRequired()
  {
    return this.zzbdl;
  }
  
  public boolean isShippingAddressRequired()
  {
    return this.zzbdm;
  }
  
  public boolean useMinimalBillingAddress()
  {
    return this.zzbdn;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public Builder addAllowedCardNetwork(int paramInt)
    {
      if (MaskedWalletRequest.this.zzbdx == null) {
        MaskedWalletRequest.this.zzbdx = new ArrayList();
      }
      MaskedWalletRequest.this.zzbdx.add(Integer.valueOf(paramInt));
      return this;
    }
    
    public Builder addAllowedCardNetworks(Collection<Integer> paramCollection)
    {
      if (paramCollection != null)
      {
        if (MaskedWalletRequest.this.zzbdx == null) {
          MaskedWalletRequest.this.zzbdx = new ArrayList();
        }
        MaskedWalletRequest.this.zzbdx.addAll(paramCollection);
      }
      return this;
    }
    
    public Builder addAllowedCountrySpecificationForShipping(com.google.android.gms.identity.intents.model.CountrySpecification paramCountrySpecification)
    {
      if (MaskedWalletRequest.this.zzbdv == null) {
        MaskedWalletRequest.this.zzbdv = new ArrayList();
      }
      MaskedWalletRequest.this.zzbdv.add(paramCountrySpecification);
      return this;
    }
    
    public Builder addAllowedCountrySpecificationsForShipping(Collection<com.google.android.gms.identity.intents.model.CountrySpecification> paramCollection)
    {
      if (paramCollection != null)
      {
        if (MaskedWalletRequest.this.zzbdv == null) {
          MaskedWalletRequest.this.zzbdv = new ArrayList();
        }
        MaskedWalletRequest.this.zzbdv.addAll(paramCollection);
      }
      return this;
    }
    
    public MaskedWalletRequest build()
    {
      return MaskedWalletRequest.this;
    }
    
    public Builder setAllowDebitCard(boolean paramBoolean)
    {
      MaskedWalletRequest.this.zzbdu = paramBoolean;
      return this;
    }
    
    public Builder setAllowPrepaidCard(boolean paramBoolean)
    {
      MaskedWalletRequest.this.zzbdt = paramBoolean;
      return this;
    }
    
    public Builder setCart(Cart paramCart)
    {
      MaskedWalletRequest.this.zzbcA = paramCart;
      return this;
    }
    
    public Builder setCurrencyCode(String paramString)
    {
      MaskedWalletRequest.this.zzbcj = paramString;
      return this;
    }
    
    public Builder setEstimatedTotalPrice(String paramString)
    {
      MaskedWalletRequest.this.zzbdo = paramString;
      return this;
    }
    
    public Builder setIsBillingAgreement(boolean paramBoolean)
    {
      MaskedWalletRequest.this.zzbdr = paramBoolean;
      return this;
    }
    
    public Builder setMerchantName(String paramString)
    {
      MaskedWalletRequest.this.zzbdp = paramString;
      return this;
    }
    
    public Builder setMerchantTransactionId(String paramString)
    {
      MaskedWalletRequest.this.zzbcq = paramString;
      return this;
    }
    
    public Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paramPaymentMethodTokenizationParameters)
    {
      MaskedWalletRequest.this.zzbdw = paramPaymentMethodTokenizationParameters;
      return this;
    }
    
    public Builder setPhoneNumberRequired(boolean paramBoolean)
    {
      MaskedWalletRequest.this.zzbdl = paramBoolean;
      return this;
    }
    
    public Builder setShippingAddressRequired(boolean paramBoolean)
    {
      MaskedWalletRequest.this.zzbdm = paramBoolean;
      return this;
    }
    
    public Builder setUseMinimalBillingAddress(boolean paramBoolean)
    {
      MaskedWalletRequest.this.zzbdn = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\MaskedWalletRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */