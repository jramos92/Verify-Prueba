package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

public class ReadRawResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<ReadRawResult> CREATOR = new zzi();
  private final int mVersionCode;
  private final DataHolder zzabq;
  private final List<DataHolder> zzatl;
  
  ReadRawResult(int paramInt, DataHolder paramDataHolder, List<DataHolder> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzabq = paramDataHolder;
    Object localObject = paramList;
    if (paramList == null) {
      localObject = Collections.singletonList(paramDataHolder);
    }
    this.zzatl = ((List)localObject);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Status getStatus()
  {
    return new Status(this.zzabq.getStatusCode());
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  DataHolder zzrh()
  {
    return this.zzabq;
  }
  
  List<DataHolder> zzts()
  {
    return this.zzatl;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\result\ReadRawResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */