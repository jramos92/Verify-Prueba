package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class EventParcel
  implements SafeParcelable
{
  public static final zzj CREATOR = new zzj();
  public final String name;
  public final int versionCode;
  public final EventParams zzaMk;
  public final String zzaMl;
  public final long zzaMm;
  
  EventParcel(int paramInt, String paramString1, EventParams paramEventParams, String paramString2, long paramLong)
  {
    this.versionCode = paramInt;
    this.name = paramString1;
    this.zzaMk = paramEventParams;
    this.zzaMl = paramString2;
    this.zzaMm = paramLong;
  }
  
  public EventParcel(String paramString1, EventParams paramEventParams, String paramString2, long paramLong)
  {
    this.versionCode = 1;
    this.name = paramString1;
    this.zzaMk = paramEventParams;
    this.zzaMl = paramString2;
    this.zzaMm = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "origin=" + this.zzaMl + ",name=" + this.name + ",params=" + this.zzaMk;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\EventParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */