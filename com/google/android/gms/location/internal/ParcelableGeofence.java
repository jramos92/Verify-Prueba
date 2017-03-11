package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class ParcelableGeofence
  implements SafeParcelable, Geofence
{
  public static final zzo CREATOR = new zzo();
  private final int mVersionCode;
  private final String zzBY;
  private final int zzaEi;
  private final short zzaEk;
  private final double zzaEl;
  private final double zzaEm;
  private final float zzaEn;
  private final int zzaEo;
  private final int zzaEp;
  private final long zzaFO;
  
  public ParcelableGeofence(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    zzdx(paramString);
    zze(paramFloat);
    zza(paramDouble1, paramDouble2);
    paramInt2 = zzhc(paramInt2);
    this.mVersionCode = paramInt1;
    this.zzaEk = paramShort;
    this.zzBY = paramString;
    this.zzaEl = paramDouble1;
    this.zzaEm = paramDouble2;
    this.zzaEn = paramFloat;
    this.zzaFO = paramLong;
    this.zzaEi = paramInt2;
    this.zzaEo = paramInt3;
    this.zzaEp = paramInt4;
  }
  
  public ParcelableGeofence(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
  {
    this(1, paramString, paramInt1, paramShort, paramDouble1, paramDouble2, paramFloat, paramLong, paramInt2, paramInt3);
  }
  
  private static void zza(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D)) {
      throw new IllegalArgumentException("invalid latitude: " + paramDouble1);
    }
    if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D)) {
      throw new IllegalArgumentException("invalid longitude: " + paramDouble2);
    }
  }
  
  private static void zzdx(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 100)) {
      throw new IllegalArgumentException("requestId is null or too long: " + paramString);
    }
  }
  
  private static void zze(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException("invalid radius: " + paramFloat);
    }
  }
  
  private static int zzhc(int paramInt)
  {
    int i = paramInt & 0x7;
    if (i == 0) {
      throw new IllegalArgumentException("No supported transition specified: " + paramInt);
    }
    return i;
  }
  
  private static String zzhd(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return "CIRCLE";
  }
  
  public static ParcelableGeofence zzn(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = CREATOR.zzeJ(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public int describeContents()
  {
    zzo localzzo = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof ParcelableGeofence)) {
        return false;
      }
      paramObject = (ParcelableGeofence)paramObject;
      if (this.zzaEn != ((ParcelableGeofence)paramObject).zzaEn) {
        return false;
      }
      if (this.zzaEl != ((ParcelableGeofence)paramObject).zzaEl) {
        return false;
      }
      if (this.zzaEm != ((ParcelableGeofence)paramObject).zzaEm) {
        return false;
      }
    } while (this.zzaEk == ((ParcelableGeofence)paramObject).zzaEk);
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.zzaFO;
  }
  
  public double getLatitude()
  {
    return this.zzaEl;
  }
  
  public double getLongitude()
  {
    return this.zzaEm;
  }
  
  public int getNotificationResponsiveness()
  {
    return this.zzaEo;
  }
  
  public String getRequestId()
  {
    return this.zzBY;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.zzaEl);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.zzaEm);
    return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(this.zzaEn)) * 31 + this.zzaEk) * 31 + this.zzaEi;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { zzhd(this.zzaEk), this.zzBY, Integer.valueOf(this.zzaEi), Double.valueOf(this.zzaEl), Double.valueOf(this.zzaEm), Float.valueOf(this.zzaEn), Integer.valueOf(this.zzaEo / 1000), Integer.valueOf(this.zzaEp), Long.valueOf(this.zzaFO) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo localzzo = CREATOR;
    zzo.zza(this, paramParcel, paramInt);
  }
  
  public short zzwI()
  {
    return this.zzaEk;
  }
  
  public float zzwJ()
  {
    return this.zzaEn;
  }
  
  public int zzwK()
  {
    return this.zzaEi;
  }
  
  public int zzwL()
  {
    return this.zzaEp;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\internal\ParcelableGeofence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */