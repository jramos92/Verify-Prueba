package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AuthAccountResult
  implements SafeParcelable
{
  public static final Parcelable.Creator<AuthAccountResult> CREATOR = new zza();
  final int mVersionCode;
  
  public AuthAccountResult()
  {
    this(1);
  }
  
  AuthAccountResult(int paramInt)
  {
    this.mVersionCode = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\signin\internal\AuthAccountResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */