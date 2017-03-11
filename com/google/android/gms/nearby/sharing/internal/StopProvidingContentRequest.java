package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class StopProvidingContentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<StopProvidingContentRequest> CREATOR = new zzj();
  final int versionCode;
  public long zzaRt;
  public zzc zzaRu;
  
  StopProvidingContentRequest()
  {
    this.versionCode = 1;
  }
  
  StopProvidingContentRequest(int paramInt, long paramLong, IBinder paramIBinder)
  {
    this.versionCode = paramInt;
    this.zzaRt = paramLong;
    this.zzaRu = zzc.zza.zzdt(paramIBinder);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzBd()
  {
    return this.zzaRu.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\sharing\internal\StopProvidingContentRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */