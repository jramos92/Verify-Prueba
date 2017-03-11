package com.google.android.gms.appdatasearch;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Feature
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  public final int id;
  final int mVersionCode;
  final Bundle zzQn;
  
  Feature(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.mVersionCode = paramInt1;
    this.id = paramInt2;
    this.zzQn = paramBundle;
  }
  
  public int describeContents()
  {
    zze localzze = CREATOR;
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze localzze = CREATOR;
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\appdatasearch\Feature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */