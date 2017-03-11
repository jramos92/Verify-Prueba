package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCloudSyncOptInOutDoneResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetCloudSyncOptInOutDoneResponse> CREATOR = new zzal();
  public final int statusCode;
  public final int versionCode;
  public final boolean zzbgD;
  
  GetCloudSyncOptInOutDoneResponse(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.zzbgD = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzal.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\GetCloudSyncOptInOutDoneResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */