package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LoyaltyPoints
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoyaltyPoints> CREATOR = new zze();
  String label;
  private final int mVersionCode;
  String type;
  TimeInterval zzbcY;
  LoyaltyPointsBalance zzbeG;
  
  LoyaltyPoints()
  {
    this.mVersionCode = 1;
  }
  
  LoyaltyPoints(int paramInt, String paramString1, LoyaltyPointsBalance paramLoyaltyPointsBalance, String paramString2, TimeInterval paramTimeInterval)
  {
    this.mVersionCode = paramInt;
    this.label = paramString1;
    this.zzbeG = paramLoyaltyPointsBalance;
    this.type = paramString2;
    this.zzbcY = paramTimeInterval;
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
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\wobs\LoyaltyPoints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */