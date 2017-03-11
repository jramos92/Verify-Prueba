package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class UserAttributeParcel
  implements SafeParcelable
{
  public static final zzaf CREATOR = new zzaf();
  public final String name;
  public final int versionCode;
  public final String zzaMl;
  public final Long zzaOA;
  public final Float zzaOB;
  public final long zzaOz;
  public final String zzagS;
  
  UserAttributeParcel(int paramInt, String paramString1, long paramLong, Long paramLong1, Float paramFloat, String paramString2, String paramString3)
  {
    this.versionCode = paramInt;
    this.name = paramString1;
    this.zzaOz = paramLong;
    this.zzaOA = paramLong1;
    this.zzaOB = paramFloat;
    this.zzagS = paramString2;
    this.zzaMl = paramString3;
  }
  
  UserAttributeParcel(String paramString1, long paramLong, Object paramObject, String paramString2)
  {
    zzx.zzcr(paramString1);
    this.versionCode = 1;
    this.name = paramString1;
    this.zzaOz = paramLong;
    this.zzaMl = paramString2;
    if (paramObject == null)
    {
      this.zzaOA = null;
      this.zzaOB = null;
      this.zzagS = null;
      return;
    }
    if ((paramObject instanceof Long))
    {
      this.zzaOA = ((Long)paramObject);
      this.zzaOB = null;
      this.zzagS = null;
      return;
    }
    if ((paramObject instanceof Float))
    {
      this.zzaOA = null;
      this.zzaOB = ((Float)paramObject);
      this.zzagS = null;
      return;
    }
    if ((paramObject instanceof String))
    {
      this.zzaOA = null;
      this.zzaOB = null;
      this.zzagS = ((String)paramObject);
      return;
    }
    if (paramObject != null) {
      throw new IllegalArgumentException("User attribute given of un-supported type");
    }
    this.zzaOA = null;
    this.zzaOB = null;
    this.zzagS = null;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Object getValue()
  {
    if (this.zzaOA != null) {
      return this.zzaOA;
    }
    if (this.zzaOB != null) {
      return this.zzaOB;
    }
    if (this.zzagS != null) {
      return this.zzagS;
    }
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzaf.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\UserAttributeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */