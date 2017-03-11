package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RemoveListenerRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<RemoveListenerRequest> CREATOR = new zzbg();
  final int mVersionCode;
  public final zzaw zzbfz;
  
  RemoveListenerRequest(int paramInt, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    if (paramIBinder != null)
    {
      this.zzbfz = zzaw.zza.zzef(paramIBinder);
      return;
    }
    this.zzbfz = null;
  }
  
  public RemoveListenerRequest(zzaw paramzzaw)
  {
    this.mVersionCode = 1;
    this.zzbfz = paramzzaw;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbg.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzEO()
  {
    if (this.zzbfz == null) {
      return null;
    }
    return this.zzbfz.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\internal\RemoveListenerRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */