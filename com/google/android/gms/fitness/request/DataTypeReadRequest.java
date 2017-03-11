package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.internal.zznw;
import com.google.android.gms.internal.zznw.zza;

public class DataTypeReadRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataTypeReadRequest> CREATOR = new zzj();
  private final String mName;
  private final int mVersionCode;
  private final zznw zzasy;
  
  DataTypeReadRequest(int paramInt, String paramString, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.mName = paramString;
    this.zzasy = zznw.zza.zzbw(paramIBinder);
  }
  
  public DataTypeReadRequest(String paramString, zznw paramzznw)
  {
    this.mVersionCode = 3;
    this.mName = paramString;
    this.zzasy = paramzznw;
  }
  
  private boolean zzb(DataTypeReadRequest paramDataTypeReadRequest)
  {
    return zzw.equal(this.mName, paramDataTypeReadRequest.mName);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataTypeReadRequest)) && (zzb((DataTypeReadRequest)paramObject)));
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.mName });
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("name", this.mName).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzsO()
  {
    return this.zzasy.asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\request\DataTypeReadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */