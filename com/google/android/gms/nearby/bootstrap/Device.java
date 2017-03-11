package com.google.android.gms.nearby.bootstrap;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class Device
  implements SafeParcelable
{
  public static final Parcelable.Creator<Device> CREATOR = new zzb();
  private final String description;
  private final String name;
  final int versionCode;
  private final String zzaPp;
  private final byte zzaPq;
  
  Device(int paramInt, String paramString1, String paramString2, String paramString3, byte paramByte)
  {
    this.versionCode = paramInt;
    this.name = zzx.zzcr(paramString1);
    this.description = ((String)zzx.zzw(paramString2));
    this.zzaPp = ((String)zzx.zzw(paramString3));
    if (paramByte <= 4) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Unknown device type");
      this.zzaPq = paramByte;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public String getDeviceId()
  {
    return this.zzaPp;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String toString()
  {
    return this.name + ": " + this.description + "[" + this.zzaPq + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public byte zzAG()
  {
    return this.zzaPq;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\nearby\bootstrap\Device.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */