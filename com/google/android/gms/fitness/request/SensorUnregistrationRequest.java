package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzj.zza;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;

public class SensorUnregistrationRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SensorUnregistrationRequest> CREATOR = new zzt();
  private final PendingIntent mPendingIntent;
  private final int mVersionCode;
  private final zzj zzasF;
  private final zzoj zzasb;
  
  SensorUnregistrationRequest(int paramInt, IBinder paramIBinder1, PendingIntent paramPendingIntent, IBinder paramIBinder2)
  {
    this.mVersionCode = paramInt;
    if (paramIBinder1 == null) {}
    for (paramIBinder1 = null;; paramIBinder1 = zzj.zza.zzbl(paramIBinder1))
    {
      this.zzasF = paramIBinder1;
      this.mPendingIntent = paramPendingIntent;
      this.zzasb = zzoj.zza.zzbJ(paramIBinder2);
      return;
    }
  }
  
  public SensorUnregistrationRequest(zzj paramzzj, PendingIntent paramPendingIntent, zzoj paramzzoj)
  {
    this.mVersionCode = 4;
    this.zzasF = paramzzj;
    this.mPendingIntent = paramPendingIntent;
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
    return String.format("SensorUnregistrationRequest{%s}", new Object[] { this.zzasF });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzt.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzasb == null) {
      return null;
    }
    return this.zzasb.asBinder();
  }
  
  public PendingIntent zzta()
  {
    return this.mPendingIntent;
  }
  
  IBinder zztf()
  {
    if (this.zzasF == null) {
      return null;
    }
    return this.zzasF.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\SensorUnregistrationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */