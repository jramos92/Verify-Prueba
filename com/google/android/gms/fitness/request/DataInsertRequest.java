package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;

public class DataInsertRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataInsertRequest> CREATOR = new zze();
  private final int mVersionCode;
  private final DataSet zzarb;
  private final zzoj zzasb;
  private final boolean zzash;
  
  DataInsertRequest(int paramInt, DataSet paramDataSet, IBinder paramIBinder, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzarb = paramDataSet;
    this.zzasb = zzoj.zza.zzbJ(paramIBinder);
    this.zzash = paramBoolean;
  }
  
  public DataInsertRequest(DataSet paramDataSet, zzoj paramzzoj, boolean paramBoolean)
  {
    this.mVersionCode = 4;
    this.zzarb = paramDataSet;
    this.zzasb = paramzzoj;
    this.zzash = paramBoolean;
  }
  
  private boolean zzc(DataInsertRequest paramDataInsertRequest)
  {
    return zzw.equal(this.zzarb, paramDataInsertRequest.zzarb);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataInsertRequest)) && (zzc((DataInsertRequest)paramObject)));
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzarb });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("dataSet", this.zzarb).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
  
  public DataSet zzsA()
  {
    return this.zzarb;
  }
  
  public IBinder zzsO()
  {
    if (this.zzasb == null) {
      return null;
    }
    return this.zzasb.asBinder();
  }
  
  public boolean zzsS()
  {
    return this.zzash;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\DataInsertRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */