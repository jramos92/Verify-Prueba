package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GoogleNowAuthState
  implements SafeParcelable
{
  public static final Parcelable.Creator<GoogleNowAuthState> CREATOR = new zza();
  final int mVersionCode;
  String zzaUM;
  String zzaUN;
  long zzaUO;
  
  GoogleNowAuthState(int paramInt, String paramString1, String paramString2, long paramLong)
  {
    this.mVersionCode = paramInt;
    this.zzaUM = paramString1;
    this.zzaUN = paramString2;
    this.zzaUO = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccessToken()
  {
    return this.zzaUN;
  }
  
  public String getAuthCode()
  {
    return this.zzaUM;
  }
  
  public long getNextAllowedTimeMillis()
  {
    return this.zzaUO;
  }
  
  public String toString()
  {
    return "mAuthCode = " + this.zzaUM + "\nmAccessToken = " + this.zzaUN + "\nmNextAllowedTimeMillis = " + this.zzaUO;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\search\GoogleNowAuthState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */