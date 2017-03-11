package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetPermissionStatusRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GetPermissionStatusRequest> CREATOR = new zza();
  final int mVersionCode;
  public final zzc zzaQG;
  public final String zzaQe;
  
  GetPermissionStatusRequest(int paramInt, IBinder paramIBinder, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzaQG = zzc.zza.zzdl(paramIBinder);
    this.zzaQe = paramString;
  }
  
  GetPermissionStatusRequest(IBinder paramIBinder, String paramString)
  {
    this(1, paramIBinder, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzBd()
  {
    return this.zzaQG.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\internal\GetPermissionStatusRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */