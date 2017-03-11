package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo
  implements SafeParcelable
{
  public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
  private final int mVersionCode;
  private final String zzavf;
  private final int zzavg;
  
  public ConnectionInfo(int paramInt1, String paramString, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzavf = paramString;
    this.zzavg = paramInt2;
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
    ConnectionInfoCreator.zza(this, paramParcel, paramInt);
  }
  
  public String zzut()
  {
    return this.zzavf;
  }
  
  public int zzuu()
  {
    return this.zzavg;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\ConnectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */