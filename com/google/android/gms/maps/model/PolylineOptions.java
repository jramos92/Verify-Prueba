package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolylineOptions
  implements SafeParcelable
{
  public static final zzi CREATOR = new zzi();
  private int mColor = -16777216;
  private final int mVersionCode;
  private float zzaJS = 0.0F;
  private boolean zzaJT = true;
  private float zzaJX = 10.0F;
  private final List<LatLng> zzaKu;
  private boolean zzaKw = false;
  
  public PolylineOptions()
  {
    this.mVersionCode = 1;
    this.zzaKu = new ArrayList();
  }
  
  PolylineOptions(int paramInt1, List paramList, float paramFloat1, int paramInt2, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt1;
    this.zzaKu = paramList;
    this.zzaJX = paramFloat1;
    this.mColor = paramInt2;
    this.zzaJS = paramFloat2;
    this.zzaJT = paramBoolean1;
    this.zzaKw = paramBoolean2;
  }
  
  public PolylineOptions add(LatLng paramLatLng)
  {
    this.zzaKu.add(paramLatLng);
    return this;
  }
  
  public PolylineOptions add(LatLng... paramVarArgs)
  {
    this.zzaKu.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolylineOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.zzaKu.add(localLatLng);
    }
    return this;
  }
  
  public PolylineOptions color(int paramInt)
  {
    this.mColor = paramInt;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolylineOptions geodesic(boolean paramBoolean)
  {
    this.zzaKw = paramBoolean;
    return this;
  }
  
  public int getColor()
  {
    return this.mColor;
  }
  
  public List<LatLng> getPoints()
  {
    return this.zzaKu;
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
  
  public boolean isGeodesic()
  {
    return this.zzaKw;
  }
  
  public boolean isVisible()
  {
    return this.zzaJT;
  }
  
  public PolylineOptions visible(boolean paramBoolean)
  {
    this.zzaJT = paramBoolean;
    return this;
  }
  
  public PolylineOptions width(float paramFloat)
  {
    this.zzaJX = paramFloat;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public PolylineOptions zIndex(float paramFloat)
  {
    this.zzaJS = paramFloat;
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\model\PolylineOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */