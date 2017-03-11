package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzof;
import com.google.android.gms.internal.zzof.zza;
import java.util.List;

public class ReadRawRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ReadRawRequest> CREATOR = new zzq();
  private final int mVersionCode;
  private final zzof zzasC;
  private final List<DataSourceQueryParams> zzasD;
  private final boolean zzasn;
  private final boolean zzaso;
  
  ReadRawRequest(int paramInt, IBinder paramIBinder, List<DataSourceQueryParams> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt;
    this.zzasC = zzof.zza.zzbF(paramIBinder);
    this.zzasD = paramList;
    this.zzasn = paramBoolean1;
    this.zzaso = paramBoolean2;
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
    zzq.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    if (this.zzasC != null) {
      return this.zzasC.asBinder();
    }
    return null;
  }
  
  public boolean zzsT()
  {
    return this.zzaso;
  }
  
  public boolean zzsU()
  {
    return this.zzasn;
  }
  
  public List<DataSourceQueryParams> zzsZ()
  {
    return this.zzasD;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\ReadRawRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */