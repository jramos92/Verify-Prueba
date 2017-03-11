package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class StringListResponse
  implements SafeParcelable
{
  public static final Parcelable.Creator<StringListResponse> CREATOR = new zzbv();
  private final int mVersionCode;
  private final List<String> zzamt;
  
  StringListResponse(int paramInt, List<String> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzamt = paramList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbv.zza(this, paramParcel, paramInt);
  }
  
  public List<String> zzrF()
  {
    return this.zzamt;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\StringListResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */