package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzog;
import com.google.android.gms.internal.zzog.zza;

public class ReadStatsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ReadStatsRequest> CREATOR = new zzr();
  private final int mVersionCode;
  private final zzog zzasE;
  
  ReadStatsRequest(int paramInt, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzasE = zzog.zza.zzbG(paramIBinder);
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
    return String.format("ReadStatsRequest", new Object[0]);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzr.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    return this.zzasE.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\ReadStatsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */