package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class TimeInterval
  implements SafeParcelable
{
  public static final Parcelable.Creator<TimeInterval> CREATOR = new zzg();
  private final int mVersionCode;
  long zzbeN;
  long zzbeO;
  
  TimeInterval()
  {
    this.mVersionCode = 1;
  }
  
  TimeInterval(int paramInt, long paramLong1, long paramLong2)
  {
    this.mVersionCode = paramInt;
    this.zzbeN = paramLong1;
    this.zzbeO = paramLong2;
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
    zzg.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wallet\wobs\TimeInterval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */