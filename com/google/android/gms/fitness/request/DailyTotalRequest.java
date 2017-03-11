package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zznt.zza;

public class DailyTotalRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DailyTotalRequest> CREATOR = new zzc();
  private final int mVersionCode;
  private DataType zzapL;
  private final zznt zzasc;
  
  DailyTotalRequest(int paramInt, IBinder paramIBinder, DataType paramDataType)
  {
    this.mVersionCode = paramInt;
    this.zzasc = zznt.zza.zzbt(paramIBinder);
    this.zzapL = paramDataType;
  }
  
  public DailyTotalRequest(zznt paramzznt, DataType paramDataType)
  {
    this.mVersionCode = 2;
    this.zzasc = paramzznt;
    this.zzapL = paramDataType;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DataType getDataType()
  {
    return this.zzapL;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String toString()
  {
    return String.format("DailyTotalRequest{%s}", new Object[] { this.zzapL.zzst() });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    return this.zzasc.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\DailyTotalRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */