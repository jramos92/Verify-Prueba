package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzoe;
import com.google.android.gms.internal.zzoe.zza;

public class ListSubscriptionsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ListSubscriptionsRequest> CREATOR = new zzp();
  private final int mVersionCode;
  private final DataType zzapL;
  private final zzoe zzasB;
  
  ListSubscriptionsRequest(int paramInt, DataType paramDataType, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzapL = paramDataType;
    this.zzasB = zzoe.zza.zzbE(paramIBinder);
  }
  
  public ListSubscriptionsRequest(DataType paramDataType, zzoe paramzzoe)
  {
    this.mVersionCode = 3;
    this.zzapL = paramDataType;
    this.zzasB = paramzzoe;
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
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzasB == null) {
      return null;
    }
    return this.zzasB.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\ListSubscriptionsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */