package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznk;
import com.google.android.gms.internal.zzom;

public final class Device
  implements SafeParcelable
{
  public static final Parcelable.Creator<Device> CREATOR = new zzh();
  public static final int TYPE_CHEST_STRAP = 4;
  public static final int TYPE_PHONE = 1;
  public static final int TYPE_SCALE = 5;
  public static final int TYPE_TABLET = 2;
  public static final int TYPE_UNKNOWN = 0;
  public static final int TYPE_WATCH = 3;
  private final int mVersionCode;
  private final int zzWJ;
  private final String zzYk;
  private final int zzaqA;
  private final String zzaqx;
  private final String zzaqy;
  private final String zzaqz;
  
  Device(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzaqx = ((String)zzx.zzw(paramString1));
    this.zzaqy = ((String)zzx.zzw(paramString2));
    this.zzYk = "";
    this.zzaqz = ((String)zzx.zzw(paramString4));
    this.zzWJ = paramInt2;
    this.zzaqA = paramInt3;
  }
  
  public Device(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, "", paramString3, paramInt, 0);
  }
  
  public Device(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    this(1, paramString1, paramString2, "", paramString4, paramInt1, paramInt2);
  }
  
  public static Device getLocalDevice(Context paramContext)
  {
    int i = zznk.zzax(paramContext);
    paramContext = zzat(paramContext);
    return new Device(Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, paramContext, i, 2);
  }
  
  private boolean zza(Device paramDevice)
  {
    return (zzw.equal(this.zzaqx, paramDevice.zzaqx)) && (zzw.equal(this.zzaqy, paramDevice.zzaqy)) && (zzw.equal(this.zzYk, paramDevice.zzYk)) && (zzw.equal(this.zzaqz, paramDevice.zzaqz)) && (this.zzWJ == paramDevice.zzWJ) && (this.zzaqA == paramDevice.zzaqA);
  }
  
  private static String zzat(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  private boolean zzsv()
  {
    return zzsu() == 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Device)) && (zza((Device)paramObject)));
  }
  
  public String getManufacturer()
  {
    return this.zzaqx;
  }
  
  public String getModel()
  {
    return this.zzaqy;
  }
  
  String getStreamIdentifier()
  {
    return String.format("%s:%s:%s", new Object[] { this.zzaqx, this.zzaqy, this.zzaqz });
  }
  
  public int getType()
  {
    return this.zzWJ;
  }
  
  public String getUid()
  {
    return this.zzaqz;
  }
  
  public String getVersion()
  {
    return this.zzYk;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaqx, this.zzaqy, this.zzYk, this.zzaqz, Integer.valueOf(this.zzWJ) });
  }
  
  public String toString()
  {
    return String.format("Device{%s:%s:%s:%s}", new Object[] { getStreamIdentifier(), this.zzYk, Integer.valueOf(this.zzWJ), Integer.valueOf(this.zzaqA) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public int zzsu()
  {
    return this.zzaqA;
  }
  
  public String zzsw()
  {
    if (zzsv()) {
      return this.zzaqz;
    }
    return zzom.zzcU(this.zzaqz);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\Device.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */