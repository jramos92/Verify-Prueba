package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DriveFileRange
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveFileRange> CREATOR = new zzc();
  final int mVersionCode;
  final long zzaiK;
  final long zzaiL;
  
  DriveFileRange(int paramInt, long paramLong1, long paramLong2)
  {
    this.mVersionCode = paramInt;
    this.zzaiK = paramLong1;
    this.zzaiL = paramLong2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\DriveFileRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */