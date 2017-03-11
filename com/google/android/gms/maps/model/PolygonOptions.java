package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class PolygonOptions
  implements SafeParcelable
{
  public static final zzh CREATOR = new zzh();
  private final int mVersionCode;
  private float zzaJP = 10.0F;
  private int zzaJQ = -16777216;
  private int zzaJR = 0;
  private float zzaJS = 0.0F;
  private boolean zzaJT = true;
  private final List<LatLng> zzaKu;
  private final List<List<LatLng>> zzaKv;
  private boolean zzaKw = false;
  
  public PolygonOptions()
  {
    this.mVersionCode = 1;
    this.zzaKu = new ArrayList();
    this.zzaKv = new ArrayList();
  }
  
  PolygonOptions(int paramInt1, List<LatLng> paramList, List paramList1, float paramFloat1, int paramInt2, int paramInt3, float paramFloat2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt1;
    this.zzaKu = paramList;
    this.zzaKv = paramList1;
    this.zzaJP = paramFloat1;
    this.zzaJQ = paramInt2;
    this.zzaJR = paramInt3;
    this.zzaJS = paramFloat2;
    this.zzaJT = paramBoolean1;
    this.zzaKw = paramBoolean2;
  }
  
  public PolygonOptions add(LatLng paramLatLng)
  {
    this.zzaKu.add(paramLatLng);
    return this;
  }
  
  public PolygonOptions add(LatLng... paramVarArgs)
  {
    this.zzaKu.addAll(Arrays.asList(paramVarArgs));
    return this;
  }
  
  public PolygonOptions addAll(Iterable<LatLng> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      LatLng localLatLng = (LatLng)paramIterable.next();
      this.zzaKu.add(localLatLng);
    }
    return this;
  }
  
  public PolygonOptions addHole(Iterable<LatLng> paramIterable)
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localArrayList.add((LatLng)paramIterable.next());
    }
    this.zzaKv.add(localArrayList);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public PolygonOptions fillColor(int paramInt)
  {
    this.zzaJR = paramInt;
    return this;
  }
  
  public PolygonOptions geodesic(boolean paramBoolean)
  {
    this.zzaKw = paramBoolean;
    return this;
  }
  
  public int getFillColor()
  {
    return this.zzaJR;
  }
  
  public List<List<LatLng>> getHoles()
  {
    return this.zzaKv;
  }
  
  public List<LatLng> getPoints()
  {
    return this.zzaKu;
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
  
  public boolean isGeodesic()
  {
    return this.zzaKw;
  }
  
  public boolean isVisible()
  {
    return this.zzaJT;
  }
  
  public PolygonOptions strokeColor(int paramInt)
  {
    this.zzaJQ = paramInt;
    return this;
  }
  
  public PolygonOptions strokeWidth(float paramFloat)
  {
    this.zzaJP = paramFloat;
    return this;
  }
  
  public PolygonOptions visible(boolean paramBoolean)
  {
    this.zzaJT = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public PolygonOptions zIndex(float paramFloat)
  {
    this.zzaJS = paramFloat;
    return this;
  }
  
  List zzya()
  {
    return this.zzaKv;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\model\PolygonOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */