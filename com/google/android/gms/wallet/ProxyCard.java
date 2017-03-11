package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard
  implements SafeParcelable
{
  public static final Parcelable.Creator<ProxyCard> CREATOR = new zzq();
  private final int mVersionCode;
  String zzbdF;
  String zzbdG;
  int zzbdH;
  int zzbdI;
  
  ProxyCard(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzbdF = paramString1;
    this.zzbdG = paramString2;
    this.zzbdH = paramInt2;
    this.zzbdI = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getCvn()
  {
    return this.zzbdG;
  }
  
  public int getExpirationMonth()
  {
    return this.zzbdH;
  }
  
  public int getExpirationYear()
  {
    return this.zzbdI;
  }
  
  public String getPan()
  {
    return this.zzbdF;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\ProxyCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */