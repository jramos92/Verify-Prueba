package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zzd.zza;

public final class MarkerOptions
  implements SafeParcelable
{
  public static final zzf CREATOR = new zzf();
  private float mAlpha = 1.0F;
  private final int mVersionCode;
  private boolean zzaJT = true;
  private LatLng zzaJq;
  private float zzaKb = 0.5F;
  private float zzaKc = 1.0F;
  private String zzaKk;
  private BitmapDescriptor zzaKl;
  private boolean zzaKm;
  private boolean zzaKn = false;
  private float zzaKo = 0.0F;
  private float zzaKp = 0.5F;
  private float zzaKq = 0.0F;
  private String zzajf;
  
  public MarkerOptions()
  {
    this.mVersionCode = 1;
  }
  
  MarkerOptions(int paramInt, LatLng paramLatLng, String paramString1, String paramString2, IBinder paramIBinder, float paramFloat1, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    this.mVersionCode = paramInt;
    this.zzaJq = paramLatLng;
    this.zzajf = paramString1;
    this.zzaKk = paramString2;
    if (paramIBinder == null) {}
    for (paramLatLng = null;; paramLatLng = new BitmapDescriptor(zzd.zza.zzbk(paramIBinder)))
    {
      this.zzaKl = paramLatLng;
      this.zzaKb = paramFloat1;
      this.zzaKc = paramFloat2;
      this.zzaKm = paramBoolean1;
      this.zzaJT = paramBoolean2;
      this.zzaKn = paramBoolean3;
      this.zzaKo = paramFloat3;
      this.zzaKp = paramFloat4;
      this.zzaKq = paramFloat5;
      this.mAlpha = paramFloat6;
      return;
    }
  }
  
  public MarkerOptions alpha(float paramFloat)
  {
    this.mAlpha = paramFloat;
    return this;
  }
  
  public MarkerOptions anchor(float paramFloat1, float paramFloat2)
  {
    this.zzaKb = paramFloat1;
    this.zzaKc = paramFloat2;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public MarkerOptions draggable(boolean paramBoolean)
  {
    this.zzaKm = paramBoolean;
    return this;
  }
  
  public MarkerOptions flat(boolean paramBoolean)
  {
    this.zzaKn = paramBoolean;
    return this;
  }
  
  public float getAlpha()
  {
    return this.mAlpha;
  }
  
  public float getAnchorU()
  {
    return this.zzaKb;
  }
  
  public float getAnchorV()
  {
    return this.zzaKc;
  }
  
  public BitmapDescriptor getIcon()
  {
    return this.zzaKl;
  }
  
  public float getInfoWindowAnchorU()
  {
    return this.zzaKp;
  }
  
  public float getInfoWindowAnchorV()
  {
    return this.zzaKq;
  }
  
  public LatLng getPosition()
  {
    return this.zzaJq;
  }
  
  public float getRotation()
  {
    return this.zzaKo;
  }
  
  public String getSnippet()
  {
    return this.zzaKk;
  }
  
  public String getTitle()
  {
    return this.zzajf;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public MarkerOptions icon(BitmapDescriptor paramBitmapDescriptor)
  {
    this.zzaKl = paramBitmapDescriptor;
    return this;
  }
  
  public MarkerOptions infoWindowAnchor(float paramFloat1, float paramFloat2)
  {
    this.zzaKp = paramFloat1;
    this.zzaKq = paramFloat2;
    return this;
  }
  
  public boolean isDraggable()
  {
    return this.zzaKm;
  }
  
  public boolean isFlat()
  {
    return this.zzaKn;
  }
  
  public boolean isVisible()
  {
    return this.zzaJT;
  }
  
  public MarkerOptions position(LatLng paramLatLng)
  {
    this.zzaJq = paramLatLng;
    return this;
  }
  
  public MarkerOptions rotation(float paramFloat)
  {
    this.zzaKo = paramFloat;
    return this;
  }
  
  public MarkerOptions snippet(String paramString)
  {
    this.zzaKk = paramString;
    return this;
  }
  
  public MarkerOptions title(String paramString)
  {
    this.zzajf = paramString;
    return this;
  }
  
  public MarkerOptions visible(boolean paramBoolean)
  {
    this.zzaJT = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  IBinder zzxZ()
  {
    if (this.zzaKl == null) {
      return null;
    }
    return this.zzaKl.zzxw().asBinder();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\model\MarkerOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */