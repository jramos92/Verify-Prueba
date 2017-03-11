package com.google.android.gms.location.places.personalized.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.location.places.personalized.zzf;

public class TestDataImpl
  extends zzf
  implements SafeParcelable
{
  public static final zza CREATOR = new zza();
  final int mVersionCode;
  private final String zzaIe;
  
  TestDataImpl(int paramInt, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzaIe = paramString;
  }
  
  public int describeContents()
  {
    zza localzza = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof TestDataImpl)) {
      return false;
    }
    paramObject = (TestDataImpl)paramObject;
    return this.zzaIe.equals(((TestDataImpl)paramObject).zzaIe);
  }
  
  public int hashCode()
  {
    return this.zzaIe.hashCode();
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("testName", this.zzaIe).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza localzza = CREATOR;
    zza.zza(this, paramParcel, paramInt);
  }
  
  public String zzxv()
  {
    return this.zzaIe;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\personalized\internal\TestDataImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */