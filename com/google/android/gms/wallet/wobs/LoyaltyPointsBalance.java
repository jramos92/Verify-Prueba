package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LoyaltyPointsBalance
  implements SafeParcelable
{
  public static final Parcelable.Creator<LoyaltyPointsBalance> CREATOR = new zzd();
  private final int mVersionCode;
  String zzbcG;
  int zzbeH;
  String zzbeI;
  double zzbeJ;
  long zzbeK;
  int zzbeL;
  
  LoyaltyPointsBalance()
  {
    this.mVersionCode = 1;
    this.zzbeL = -1;
    this.zzbeH = -1;
    this.zzbeJ = -1.0D;
  }
  
  LoyaltyPointsBalance(int paramInt1, int paramInt2, String paramString1, double paramDouble, String paramString2, long paramLong, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzbeH = paramInt2;
    this.zzbeI = paramString1;
    this.zzbeJ = paramDouble;
    this.zzbcG = paramString2;
    this.zzbeK = paramLong;
    this.zzbeL = paramInt3;
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\wobs\LoyaltyPointsBalance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */