package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class MapValue
  implements SafeParcelable
{
  public static final Parcelable.Creator<MapValue> CREATOR = new zzl();
  private final int mVersionCode;
  private final int zzaqO;
  private final float zzaqS;
  
  public MapValue(int paramInt, float paramFloat)
  {
    this(1, paramInt, paramFloat);
  }
  
  MapValue(int paramInt1, int paramInt2, float paramFloat)
  {
    this.mVersionCode = paramInt1;
    this.zzaqO = paramInt2;
    this.zzaqS = paramFloat;
  }
  
  private boolean zza(MapValue paramMapValue)
  {
    if (this.zzaqO == paramMapValue.zzaqO)
    {
      switch (this.zzaqO)
      {
      default: 
        if (this.zzaqS != paramMapValue.zzaqS) {
          break;
        }
      case 2: 
        do
        {
          return true;
        } while (asFloat() == paramMapValue.asFloat());
        return false;
      }
      return false;
    }
    return false;
  }
  
  public static MapValue zzc(float paramFloat)
  {
    return new MapValue(2, paramFloat);
  }
  
  public float asFloat()
  {
    if (this.zzaqO == 2) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Value is not in float format");
      return this.zzaqS;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof MapValue)) && (zza((MapValue)paramObject)));
  }
  
  int getFormat()
  {
    return this.zzaqO;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return (int)this.zzaqS;
  }
  
  public String toString()
  {
    switch (this.zzaqO)
    {
    default: 
      return "unknown";
    }
    return Float.toString(asFloat());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
  
  float zzsy()
  {
    return this.zzaqS;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\MapValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */