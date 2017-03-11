package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class IdToken
  implements SafeParcelable
{
  public static final Parcelable.Creator<IdToken> CREATOR = new zzd();
  final int mVersionCode;
  private final String zzSk;
  private final String zzSs;
  
  IdToken(int paramInt, String paramString1, String paramString2)
  {
    this.mVersionCode = paramInt;
    this.zzSk = paramString1;
    this.zzSs = paramString2;
  }
  
  public IdToken(String paramString1, String paramString2)
  {
    this(1, paramString1, paramString2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountType()
  {
    return this.zzSk;
  }
  
  public String getIdToken()
  {
    return this.zzSs;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\api\credentials\IdToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */