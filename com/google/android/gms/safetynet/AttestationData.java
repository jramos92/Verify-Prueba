package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AttestationData
  implements SafeParcelable
{
  public static final Parcelable.Creator<AttestationData> CREATOR = new zza();
  public final int mVersionCode;
  private String zzaUA;
  
  AttestationData(int paramInt, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzaUA = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getJwsResult()
  {
    return this.zzaUA;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\safetynet\AttestationData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */