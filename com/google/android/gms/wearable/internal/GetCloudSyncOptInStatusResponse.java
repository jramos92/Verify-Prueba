package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetCloudSyncOptInStatusResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetCloudSyncOptInStatusResponse> CREATOR = new zzam();
  public final int statusCode;
  public final int versionCode;
  public final boolean zzbgE;
  public final boolean zzbgF;
  
  GetCloudSyncOptInStatusResponse(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.zzbgE = paramBoolean1;
    this.zzbgF = paramBoolean2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzam.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\GetCloudSyncOptInStatusResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */