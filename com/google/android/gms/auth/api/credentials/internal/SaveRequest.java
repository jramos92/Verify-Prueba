package com.google.android.gms.auth.api.credentials.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class SaveRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SaveRequest> CREATOR = new zzi();
  final int mVersionCode;
  private final Credential zzSD;
  
  SaveRequest(int paramInt, Credential paramCredential)
  {
    this.mVersionCode = paramInt;
    this.zzSD = paramCredential;
  }
  
  public SaveRequest(Credential paramCredential)
  {
    this(1, paramCredential);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Credential getCredential()
  {
    return this.zzSD;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\auth\api\credentials\internal\SaveRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */