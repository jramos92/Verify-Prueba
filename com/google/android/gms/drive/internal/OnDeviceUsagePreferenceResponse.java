package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDeviceUsagePreferenceResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<OnDeviceUsagePreferenceResponse> CREATOR = new zzax();
  final int mVersionCode;
  final FileUploadPreferencesImpl zzalY;
  
  OnDeviceUsagePreferenceResponse(int paramInt, FileUploadPreferencesImpl paramFileUploadPreferencesImpl)
  {
    this.mVersionCode = paramInt;
    this.zzalY = paramFileUploadPreferencesImpl;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzax.zza(this, paramParcel, paramInt);
  }
  
  public FileUploadPreferencesImpl zzrx()
  {
    return this.zzalY;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\OnDeviceUsagePreferenceResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */