package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StringParcel
  implements SafeParcelable
{
  public static final Parcelable.Creator<StringParcel> CREATOR = new zzn();
  final int mVersionCode;
  String zzvY;
  
  StringParcel(int paramInt, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzvY = paramString;
  }
  
  public StringParcel(String paramString)
  {
    this.mVersionCode = 1;
    this.zzvY = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
  
  public String zzfP()
  {
    return this.zzvY;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\request\StringParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */