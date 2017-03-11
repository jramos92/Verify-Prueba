package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;

public class StopBleScanRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<StopBleScanRequest> CREATOR = new zzab();
  private final int mVersionCode;
  private final zzn zzasY;
  private final zzoj zzasb;
  
  StopBleScanRequest(int paramInt, IBinder paramIBinder1, IBinder paramIBinder2)
  {
    this.mVersionCode = paramInt;
    this.zzasY = zzn.zza.zzbM(paramIBinder1);
    this.zzasb = zzoj.zza.zzbJ(paramIBinder2);
  }
  
  public StopBleScanRequest(BleScanCallback paramBleScanCallback, zzoj paramzzoj)
  {
    this(zza.zza.zzsM().zzb(paramBleScanCallback), paramzzoj);
  }
  
  public StopBleScanRequest(zzn paramzzn, zzoj paramzzoj)
  {
    this.mVersionCode = 3;
    this.zzasY = paramzzn;
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
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzab.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzasb == null) {
      return null;
    }
    return this.zzasb.asBinder();
  }
  
  public IBinder zztk()
  {
    return this.zzasY.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\StopBleScanRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */