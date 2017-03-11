package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class Value
  implements SafeParcelable
{
  public static final Parcelable.Creator<Value> CREATOR = new zzt();
  private final int mVersionCode;
  private final int zzaqO;
  private float zzaqS;
  private boolean zzare;
  private String zzarf;
  private Map<String, MapValue> zzarg;
  private int[] zzarh;
  private float[] zzari;
  
  public Value(int paramInt)
  {
    this(3, paramInt, false, 0.0F, null, null, null, null);
  }
  
  Value(int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat, String paramString, Bundle paramBundle, int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    this.mVersionCode = paramInt1;
    this.zzaqO = paramInt2;
    this.zzare = paramBoolean;
    this.zzaqS = paramFloat;
    this.zzarf = paramString;
    this.zzarg = zzs(paramBundle);
    this.zzarh = paramArrayOfInt;
    this.zzari = paramArrayOfFloat;
  }
  
  private boolean zza(Value paramValue)
  {
    if ((this.zzaqO == paramValue.zzaqO) && (this.zzare == paramValue.zzare))
    {
      switch (this.zzaqO)
      {
      default: 
        if (this.zzaqS != paramValue.zzaqS) {
          break;
        }
      case 1: 
      case 2: 
        do
        {
          do
          {
            return true;
          } while (asInt() == paramValue.asInt());
          return false;
        } while (asFloat() == paramValue.asFloat());
        return false;
      case 3: 
        return asString().equals(paramValue.asString());
      case 4: 
        return zzrH().equals(paramValue.zzrH());
      case 5: 
        return zzsE().equals(paramValue.zzsE());
      case 6: 
        return zzsF().equals(paramValue.zzsF());
      }
      return false;
    }
    return false;
  }
  
  private static Map<String, MapValue> zzs(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    paramBundle.setClassLoader(MapValue.class.getClassLoader());
    ArrayMap localArrayMap = new ArrayMap(paramBundle.size());
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayMap.put(str, paramBundle.getParcelable(str));
    }
    return localArrayMap;
  }
  
  public String asActivity()
  {
    return FitnessActivities.getName(asInt());
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
  
  public int asInt()
  {
    boolean bool = true;
    if (this.zzaqO == 1) {}
    for (;;)
    {
      zzx.zza(bool, "Value is not in int format");
      return Float.floatToRawIntBits(this.zzaqS);
      bool = false;
    }
  }
  
  public String asString()
  {
    if (this.zzaqO == 3) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Value is not in string format");
      return this.zzarf;
    }
  }
  
  public void clearKey(String paramString)
  {
    if (this.zzaqO == 4) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
      if (this.zzarg != null) {
        this.zzarg.remove(paramString);
      }
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Value)) && (zza((Value)paramObject)));
  }
  
  public int getFormat()
  {
    return this.zzaqO;
  }
  
  public Float getKeyValue(String paramString)
  {
    if (this.zzaqO == 4) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Value is not in float map format");
      if ((this.zzarg == null) || (!this.zzarg.containsKey(paramString))) {
        break;
      }
      return Float.valueOf(((MapValue)this.zzarg.get(paramString)).asFloat());
    }
    return null;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Float.valueOf(this.zzaqS), this.zzarf, this.zzarg, this.zzarh, this.zzari });
  }
  
  public boolean isSet()
  {
    return this.zzare;
  }
  
  public void setActivity(String paramString)
  {
    setInt(FitnessActivities.zzcO(paramString));
  }
  
  public void setFloat(float paramFloat)
  {
    if (this.zzaqO == 2) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
      this.zzare = true;
      this.zzaqS = paramFloat;
      return;
    }
  }
  
  public void setInt(int paramInt)
  {
    if (this.zzaqO == 1) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
      this.zzare = true;
      this.zzaqS = Float.intBitsToFloat(paramInt);
      return;
    }
  }
  
  public void setKeyValue(String paramString, float paramFloat)
  {
    if (this.zzaqO == 4) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
      this.zzare = true;
      if (this.zzarg == null) {
        this.zzarg = new HashMap();
      }
      this.zzarg.put(paramString, MapValue.zzc(paramFloat));
      return;
    }
  }
  
  public void setString(String paramString)
  {
    if (this.zzaqO == 3) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
      this.zzare = true;
      this.zzarf = paramString;
      return;
    }
  }
  
  public String toString()
  {
    if (!this.zzare) {
      return "unset";
    }
    switch (this.zzaqO)
    {
    default: 
      return "unknown";
    case 1: 
      return Integer.toString(asInt());
    case 2: 
      return Float.toString(asFloat());
    case 3: 
      return this.zzarf;
    case 4: 
      return new TreeMap(this.zzarg).toString();
    case 5: 
      return zzsE().toString();
    }
    return zzsF().toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzt.zza(this, paramParcel, paramInt);
  }
  
  public Map<String, MapValue> zzrH()
  {
    if (this.zzaqO == 4) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Value is not in float map format");
      if (this.zzarg != null) {
        break;
      }
      return Collections.emptyMap();
    }
    return this.zzarg;
  }
  
  public int[] zzsE()
  {
    if (this.zzaqO == 5) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Value is not in int list format");
      return this.zzarh;
    }
  }
  
  public float[] zzsF()
  {
    if (this.zzaqO == 6) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Value is not in float list format");
      return this.zzari;
    }
  }
  
  String zzsG()
  {
    return this.zzarf;
  }
  
  Bundle zzsH()
  {
    if (this.zzarg == null) {
      return null;
    }
    Bundle localBundle = new Bundle(this.zzarg.size());
    Iterator localIterator = this.zzarg.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBundle.putParcelable((String)localEntry.getKey(), (Parcelable)localEntry.getValue());
    }
    return localBundle;
  }
  
  int[] zzsI()
  {
    return this.zzarh;
  }
  
  float[] zzsJ()
  {
    return this.zzari;
  }
  
  float zzsy()
  {
    return this.zzaqS;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */