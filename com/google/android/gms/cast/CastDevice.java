package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CastDevice
  implements SafeParcelable
{
  public static final int CAPABILITY_AUDIO_IN = 8;
  public static final int CAPABILITY_AUDIO_OUT = 4;
  public static final int CAPABILITY_VIDEO_IN = 2;
  public static final int CAPABILITY_VIDEO_OUT = 1;
  public static final Parcelable.Creator<CastDevice> CREATOR = new zzb();
  private final int mVersionCode;
  private String zzVd;
  String zzVe;
  private Inet4Address zzVf;
  private String zzVg;
  private String zzVh;
  private String zzVi;
  private int zzVj;
  private List<WebImage> zzVk;
  private int zzVl;
  private int zzys;
  
  private CastDevice()
  {
    this(3, null, null, null, null, null, -1, new ArrayList(), 0, -1);
  }
  
  CastDevice(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, List<WebImage> paramList, int paramInt3, int paramInt4)
  {
    this.mVersionCode = paramInt1;
    this.zzVd = paramString1;
    this.zzVe = paramString2;
    if (this.zzVe != null) {}
    try
    {
      paramString1 = InetAddress.getByName(this.zzVe);
      if ((paramString1 instanceof Inet4Address)) {
        this.zzVf = ((Inet4Address)paramString1);
      }
      this.zzVg = paramString3;
      this.zzVh = paramString4;
      this.zzVi = paramString5;
      this.zzVj = paramInt2;
      this.zzVk = paramList;
      this.zzVl = paramInt3;
      this.zzys = paramInt4;
      return;
    }
    catch (UnknownHostException paramString1)
    {
      for (;;)
      {
        this.zzVf = null;
      }
    }
  }
  
  public static CastDevice getFromBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    paramBundle.setClassLoader(CastDevice.class.getClassLoader());
    return (CastDevice)paramBundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      do
      {
        return true;
        if (!(paramObject instanceof CastDevice)) {
          return false;
        }
        paramObject = (CastDevice)paramObject;
        if (getDeviceId() != null) {
          break;
        }
      } while (((CastDevice)paramObject).getDeviceId() == null);
      return false;
    } while ((zzf.zza(this.zzVd, ((CastDevice)paramObject).zzVd)) && (zzf.zza(this.zzVf, ((CastDevice)paramObject).zzVf)) && (zzf.zza(this.zzVh, ((CastDevice)paramObject).zzVh)) && (zzf.zza(this.zzVg, ((CastDevice)paramObject).zzVg)) && (zzf.zza(this.zzVi, ((CastDevice)paramObject).zzVi)) && (this.zzVj == ((CastDevice)paramObject).zzVj) && (zzf.zza(this.zzVk, ((CastDevice)paramObject).zzVk)) && (this.zzVl == ((CastDevice)paramObject).zzVl) && (this.zzys == ((CastDevice)paramObject).zzys));
    return false;
  }
  
  public int getCapabilities()
  {
    return this.zzVl;
  }
  
  public String getDeviceId()
  {
    return this.zzVd;
  }
  
  public String getDeviceVersion()
  {
    return this.zzVi;
  }
  
  public String getFriendlyName()
  {
    return this.zzVg;
  }
  
  public WebImage getIcon(int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    if (this.zzVk.isEmpty()) {
      return null;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return (WebImage)this.zzVk.get(0);
    }
    Iterator localIterator = this.zzVk.iterator();
    Object localObject2 = null;
    WebImage localWebImage;
    int i;
    int j;
    if (localIterator.hasNext())
    {
      localWebImage = (WebImage)localIterator.next();
      i = localWebImage.getWidth();
      j = localWebImage.getHeight();
      if ((i >= paramInt1) && (j >= paramInt2))
      {
        if ((localObject2 != null) && ((((WebImage)localObject2).getWidth() <= i) || (((WebImage)localObject2).getHeight() <= j))) {
          break label210;
        }
        localObject2 = localWebImage;
      }
    }
    label210:
    for (;;)
    {
      break;
      if ((i < paramInt1) && (j < paramInt2) && ((localObject1 == null) || ((((WebImage)localObject1).getWidth() < i) && (((WebImage)localObject1).getHeight() < j))))
      {
        localObject1 = localWebImage;
        continue;
        if (localObject2 != null) {}
        for (;;)
        {
          return (WebImage)localObject2;
          if (localObject1 != null) {
            localObject2 = localObject1;
          } else {
            localObject2 = (WebImage)this.zzVk.get(0);
          }
        }
      }
    }
  }
  
  public List<WebImage> getIcons()
  {
    return Collections.unmodifiableList(this.zzVk);
  }
  
  public Inet4Address getIpAddress()
  {
    return this.zzVf;
  }
  
  public String getModelName()
  {
    return this.zzVh;
  }
  
  public int getServicePort()
  {
    return this.zzVj;
  }
  
  public int getStatus()
  {
    return this.zzys;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean hasCapabilities(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null) {
      return false;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label33;
      }
      if (!hasCapability(paramArrayOfInt[i])) {
        break;
      }
      i += 1;
    }
    label33:
    return true;
  }
  
  public boolean hasCapability(int paramInt)
  {
    return (this.zzVl & paramInt) == paramInt;
  }
  
  public boolean hasIcons()
  {
    return !this.zzVk.isEmpty();
  }
  
  public int hashCode()
  {
    if (this.zzVd == null) {
      return 0;
    }
    return this.zzVd.hashCode();
  }
  
  public boolean isOnLocalNetwork()
  {
    return !this.zzVd.startsWith("__cast_nearby__");
  }
  
  public boolean isSameDevice(CastDevice paramCastDevice)
  {
    if (paramCastDevice == null) {}
    do
    {
      return false;
      if (getDeviceId() != null) {
        break;
      }
    } while (paramCastDevice.getDeviceId() != null);
    return true;
    return zzf.zza(getDeviceId(), paramCastDevice.getDeviceId());
  }
  
  public void putInBundle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    paramBundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
  }
  
  public String toString()
  {
    return String.format("\"%s\" (%s)", new Object[] { this.zzVg, this.zzVd });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\CastDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */