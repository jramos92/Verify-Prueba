package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ReceiveContentRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ReceiveContentRequest> CREATOR = new zzg();
  public String packageName;
  final int versionCode;
  public IBinder zzaRq;
  public zzc zzaRu;
  public zza zzaRv;
  
  ReceiveContentRequest()
  {
    this.versionCode = 1;
  }
  
  ReceiveContentRequest(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2, String paramString, IBinder paramIBinder3)
  {
    this.versionCode = paramInt;
    this.zzaRq = paramIBinder1;
    this.zzaRv = zza.zza.zzdr(paramIBinder2);
    this.packageName = paramString;
    this.zzaRu = zzc.zza.zzdt(paramIBinder3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzBd()
  {
    return this.zzaRu.asBinder();
  }
  
  IBinder zzBp()
  {
    if (this.zzaRv == null) {
      return null;
    }
    return this.zzaRv.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\sharing\internal\ReceiveContentRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */