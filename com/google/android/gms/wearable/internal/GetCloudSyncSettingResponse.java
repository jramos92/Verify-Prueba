package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCloudSyncSettingResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetCloudSyncSettingResponse> CREATOR = new zzan();
  public final boolean enabled;
  public final int statusCode;
  public final int versionCode;
  
  GetCloudSyncSettingResponse(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.enabled = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzan.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\GetCloudSyncSettingResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */