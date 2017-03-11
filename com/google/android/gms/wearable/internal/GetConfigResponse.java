package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;

@Deprecated
public class GetConfigResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetConfigResponse> CREATOR = new zzao();
  public final int statusCode;
  public final int versionCode;
  public final ConnectionConfiguration zzbgG;
  
  GetConfigResponse(int paramInt1, int paramInt2, ConnectionConfiguration paramConnectionConfiguration)
  {
    this.versionCode = paramInt1;
    this.statusCode = paramInt2;
    this.zzbgG = paramConnectionConfiguration;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzao.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\GetConfigResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */