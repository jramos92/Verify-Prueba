package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextDeletedDetails
  implements SafeParcelable
{
  public static final Parcelable.Creator<TextDeletedDetails> CREATOR = new zzf();
  final int mIndex;
  final int mVersionCode;
  final int zzapd;
  
  TextDeletedDetails(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.mIndex = paramInt2;
    this.zzapd = paramInt3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\realtime\internal\event\TextDeletedDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */