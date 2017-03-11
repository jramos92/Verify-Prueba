package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;

public class UnsubscribeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UnsubscribeRequest> CREATOR = new zzae();
  private final int mVersionCode;
  private final DataType zzapL;
  private final DataSource zzapM;
  private final zzoj zzasb;
  
  UnsubscribeRequest(int paramInt, DataType paramDataType, DataSource paramDataSource, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzapL = paramDataType;
    this.zzapM = paramDataSource;
    this.zzasb = zzoj.zza.zzbJ(paramIBinder);
  }
  
  public UnsubscribeRequest(DataType paramDataType, DataSource paramDataSource, zzoj paramzzoj)
  {
    this.mVersionCode = 3;
    this.zzapL = paramDataType;
    this.zzapM = paramDataSource;
    this.zzasb = paramzzoj;
  }
  
  private boolean zzb(UnsubscribeRequest paramUnsubscribeRequest)
  {
    return (zzw.equal(this.zzapM, paramUnsubscribeRequest.zzapM)) && (zzw.equal(this.zzapL, paramUnsubscribeRequest.zzapL));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof UnsubscribeRequest)) && (zzb((UnsubscribeRequest)paramObject)));
  }
  
  public DataSource getDataSource()
  {
    return this.zzapM;
  }
  
  public DataType getDataType()
  {
    return this.zzapL;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzapM, this.zzapL });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzae.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzasb == null) {
      return null;
    }
    return this.zzasb.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\UnsubscribeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */