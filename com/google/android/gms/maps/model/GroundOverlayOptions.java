package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public final class GroundOverlayOptions
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public static final float NO_DIMENSION = -1.0F;
  private final int mVersionCode;
  private float zzaJL;
  private float zzaJS;
  private boolean zzaJT = true;
  private BitmapDescriptor zzaJV;
  private LatLng zzaJW;
  private float zzaJX;
  private float zzaJY;
  private LatLngBounds zzaJZ;
  private float zzaKa = 0.0F;
  private float zzaKb = 0.5F;
  private float zzaKc = 0.5F;
  
  public GroundOverlayOptions()
  {
    this.mVersionCode = 1;
  }
  
  GroundOverlayOptions(int paramInt, IBinder paramIBinder, LatLng paramLatLng, float paramFloat1, float paramFloat2, LatLngBounds paramLatLngBounds, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.mVersionCode = paramInt;
    this.zzaJV = new BitmapDescriptor(zzd.zza.zzbk(paramIBinder));
    this.zzaJW = paramLatLng;
    this.zzaJX = paramFloat1;
    this.zzaJY = paramFloat2;
    this.zzaJZ = paramLatLngBounds;
    this.zzaJL = paramFloat3;
    this.zzaJS = paramFloat4;
    this.zzaJT = paramBoolean;
    this.zzaKa = paramFloat5;
    this.zzaKb = paramFloat6;
    this.zzaKc = paramFloat7;
  }
  
  private GroundOverlayOptions zza(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    this.zzaJW = paramLatLng;
    this.zzaJX = paramFloat1;
    this.zzaJY = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.zzaKb = paramFloat1;
    this.zzaKc = paramFloat2;
    return this;
  }
  
  public GroundOverlayOptions bearing(float paramFloat)
  {
    this.zzaJL = ((paramFloat % 360.0F + 360.0F) % 360.0F);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float getAnchorU()
  {
    return this.zzaKb;
  }
  
  public float getAnchorV()
  {
    return this.zzaKc;
  }
  
  public float getBearing()
  {
    return this.zzaJL;
  }
  
  public LatLngBounds getBounds()
  {
    return this.zzaJZ;
  }
  
  public float getHeight()
  {
    return this.zzaJY;
  }
  
  public BitmapDescriptor getImage()
  {
    return this.zzaJV;
  }
  
  public LatLng getLocation()
  {
    return this.zzaJW;
  }
  
  public float getTransparency()
  {
    return this.zzaKa;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public float getWidth()
  {
    return this.zzaJX;
  }
  
  public float getZIndex()
  {
    return this.zzaJS;
  }
  
  public GroundOverlayOptions image(BitmapDescriptor paramBitmapDescriptor)
  {
    this.zzaJV = paramBitmapDescriptor;
    return this;
  }
  
  public boolean isVisible()
  {
    return this.zzaJT;
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat)
  {
    boolean bool2 = true;
    if (this.zzaJZ == null)
    {
      bool1 = true;
      zzx.zza(bool1, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label59;
      }
      bool1 = true;
      label24:
      zzx.zzb(bool1, "Location must be specified");
      if (paramFloat < 0.0F) {
        break label64;
      }
    }
    label59:
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "Width must be non-negative");
      return zza(paramLatLng, paramFloat, -1.0F);
      bool1 = false;
      break;
      bool1 = false;
      break label24;
    }
  }
  
  public GroundOverlayOptions position(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    boolean bool2 = true;
    if (this.zzaJZ == null)
    {
      bool1 = true;
      zzx.zza(bool1, "Position has already been set using positionFromBounds");
      if (paramLatLng == null) {
        break label81;
      }
      bool1 = true;
      label27:
      zzx.zzb(bool1, "Location must be specified");
      if (paramFloat1 < 0.0F) {
        break label87;
      }
      bool1 = true;
      label43:
      zzx.zzb(bool1, "Width must be non-negative");
      if (paramFloat2 < 0.0F) {
        break label93;
      }
    }
    label81:
    label87:
    label93:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "Height must be non-negative");
      return zza(paramLatLng, paramFloat1, paramFloat2);
      bool1 = false;
      break;
      bool1 = false;
      break label27;
      bool1 = false;
      break label43;
    }
  }
  
  public GroundOverlayOptions positionFromBounds(LatLngBounds paramLatLngBounds)
  {
    if (this.zzaJW == null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Position has already been set using position: " + this.zzaJW);
      this.zzaJZ = paramLatLngBounds;
      return this;
    }
  }
  
  public GroundOverlayOptions transparency(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Transparency must be in the range [0..1]");
      this.zzaKa = paramFloat;
      return this;
    }
  }
  
  public GroundOverlayOptions visible(boolean paramBoolean)
  {
    this.zzaJT = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public GroundOverlayOptions zIndex(float paramFloat)
  {
    this.zzaJS = paramFloat;
    return this;
  }
  
  IBinder zzxY()
  {
    return this.zzaJV.zzxw().asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\model\GroundOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */