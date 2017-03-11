package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class RegisterStatusCallbackRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RegisterStatusCallbackRequest> CREATOR = new zzo();
  final int versionCode;
  public final zzc zzaQG;
  public final zzf zzaRc;
  public boolean zzaRd;
  
  RegisterStatusCallbackRequest(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, boolean paramBoolean)
  {
    this.versionCode = paramInt;
    this.zzaQG = zzc.zza.zzdl(paramIBinder1);
    this.zzaRc = zzf.zza.zzdo(paramIBinder2);
    this.zzaRd = paramBoolean;
  }
  
  RegisterStatusCallbackRequest(IBinder paramIBinder1, IBinder paramIBinder2)
  {
    this(1, paramIBinder1, paramIBinder2, false);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzBd()
  {
    return this.zzaQG.asBinder();
  }
  
  IBinder zzBf()
  {
    return this.zzaRc.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\messages\internal\RegisterStatusCallbackRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */