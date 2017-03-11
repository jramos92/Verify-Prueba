package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GetBuyFlowInitializationTokenResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetBuyFlowInitializationTokenResponse> CREATOR = new zzc();
  private final int mVersionCode;
  byte[] zzbdP;
  
  GetBuyFlowInitializationTokenResponse()
  {
    this(1, new byte[0]);
  }
  
  GetBuyFlowInitializationTokenResponse(int paramInt, byte[] paramArrayOfByte)
  {
    this.mVersionCode = paramInt;
    this.zzbdP = paramArrayOfByte;
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
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\firstparty\GetBuyFlowInitializationTokenResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */