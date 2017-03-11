package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public class SyncInfoResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<SyncInfoResult> CREATOR = new zzl();
  private final int mVersionCode;
  private final Status zzSC;
  private final long zzZH;
  
  SyncInfoResult(int paramInt, Status paramStatus, long paramLong)
  {
    this.mVersionCode = paramInt;
    this.zzSC = paramStatus;
    this.zzZH = paramLong;
  }
  
  private boolean zzb(SyncInfoResult paramSyncInfoResult)
  {
    return (this.zzSC.equals(paramSyncInfoResult.zzSC)) && (zzw.equal(Long.valueOf(this.zzZH), Long.valueOf(paramSyncInfoResult.zzZH)));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SyncInfoResult)) && (zzb((SyncInfoResult)paramObject)));
  }
  
  public Status getStatus()
  {
    return this.zzSC;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzSC, Long.valueOf(this.zzZH) });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("status", this.zzSC).zzg("timestamp", Long.valueOf(this.zzZH)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
  
  public long zztu()
  {
    return this.zzZH;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\SyncInfoResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */