package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CircleOptions
  implements SafeParcelable
{
  public static final zzb CREATOR = new zzb();
  private final int mVersionCode;
  private LatLng zzaJN = null;
  private double zzaJO = 0.0D;
  private float zzaJP = 10.0F;
  private int zzaJQ = -16777216;
  private int zzaJR = 0;
  private float zzaJS = 0.0F;
  private boolean zzaJT = true;
  
  public CircleOptions()
  {
    this.mVersionCode = 1;
  }
  
  CircleOptions(int paramInt1, LatLng paramLatLng, double paramDouble, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzaJN = paramLatLng;
    this.zzaJO = paramDouble;
    this.zzaJP = paramFloat1;
    this.zzaJQ = paramInt2;
    this.zzaJR = paramInt3;
    this.zzaJS = paramFloat2;
    this.zzaJT = paramBoolean;
  }
  
  public CircleOptions center(LatLng paramLatLng)
  {
    this.zzaJN = paramLatLng;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CircleOptions fillColor(int paramInt)
  {
    this.zzaJR = paramInt;
    return this;
  }
  
  public LatLng getCenter()
  {
    return this.zzaJN;
  }
  
  public int getFillColor()
  {
    return this.zzaJR;
  }
  
  public double getRadius()
  {
    return this.zzaJO;
  }
  
  public int getStrokeColor()
  {
    return this.zzaJQ;
  }
  
  public float getStrokeWidth()
  {
    return this.zzaJP;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public float getZIndex()
  {
    return this.zzaJS;
  }
  
  public boolean isVisible()
  {
    return this.zzaJT;
  }
  
  public CircleOptions radius(double paramDouble)
  {
    this.zzaJO = paramDouble;
    return this;
  }
  
  public CircleOptions strokeColor(int paramInt)
  {
    this.zzaJQ = paramInt;
    return this;
  }
  
  public CircleOptions strokeWidth(float paramFloat)
  {
    this.zzaJP = paramFloat;
    return this;
  }
  
  public CircleOptions visible(boolean paramBoolean)
  {
    this.zzaJT = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public CircleOptions zIndex(float paramFloat)
  {
    this.zzaJS = paramFloat;
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\model\CircleOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */