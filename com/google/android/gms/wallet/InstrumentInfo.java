package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo
  implements SafeParcelable
{
  public static final Parcelable.Creator<InstrumentInfo> CREATOR = new zzh();
  private final int mVersionCode;
  private String zzbcJ;
  private String zzbcK;
  
  InstrumentInfo(int paramInt, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.zzbcJ = paramString1;
    this.zzbcK = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getInstrumentDetails()
  {
    return this.zzbcK;
  }
  
  public String getInstrumentType()
  {
    return this.zzbcJ;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\InstrumentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */