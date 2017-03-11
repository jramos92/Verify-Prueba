package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;

public class DisableFitRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DisableFitRequest> CREATOR = new zzl();
  private final int mVersionCode;
  private final zzoj zzasb;
  
  DisableFitRequest(int paramInt, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzasb = zzoj.zza.zzbJ(paramIBinder);
  }
  
  public DisableFitRequest(zzoj paramzzoj)
  {
    this.mVersionCode = 2;
    this.zzasb = paramzzoj;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String toString()
  {
    return String.format("DisableFitRequest", new Object[0]);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    return this.zzasb.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\DisableFitRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */