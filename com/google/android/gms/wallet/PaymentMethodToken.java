package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PaymentMethodToken
  implements SafeParcelable
{
  public static final Parcelable.Creator<PaymentMethodToken> CREATOR = new zzo();
  private final int mVersionCode;
  String zzaPv;
  int zzbdC;
  
  private PaymentMethodToken()
  {
    this.mVersionCode = 1;
  }
  
  PaymentMethodToken(int paramInt1, int paramInt2, String paramString)
  {
    this.mVersionCode = paramInt1;
    this.zzbdC = paramInt2;
    this.zzaPv = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getPaymentMethodTokenizationType()
  {
    return this.zzbdC;
  }
  
  public String getToken()
  {
    return this.zzaPv;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\PaymentMethodToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */