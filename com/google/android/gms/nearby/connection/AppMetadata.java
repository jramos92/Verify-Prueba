package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public final class AppMetadata
  implements SafeParcelable
{
  public static final Parcelable.Creator<AppMetadata> CREATOR = new zzb();
  private final int mVersionCode;
  private final List<AppIdentifier> zzaPy;
  
  AppMetadata(int paramInt, List<AppIdentifier> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzaPy = ((List)zzx.zzb(paramList, "Must specify application identifiers"));
    zzx.zza(paramList.size(), "Application identifiers cannot be empty");
  }
  
  public AppMetadata(List<AppIdentifier> paramList)
  {
    this(1, paramList);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<AppIdentifier> getAppIdentifiers()
  {
    return this.zzaPy;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\connection\AppMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */