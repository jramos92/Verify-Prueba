package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties
  implements SafeParcelable, Iterable<CustomProperty>
{
  public static final Parcelable.Creator<AppVisibleCustomProperties> CREATOR = new zza();
  public static final AppVisibleCustomProperties zzamA = new zza().zzrI();
  final int mVersionCode;
  final List<CustomProperty> zzamB;
  
  AppVisibleCustomProperties(int paramInt, Collection<CustomProperty> paramCollection)
  {
    this.mVersionCode = paramInt;
    zzx.zzw(paramCollection);
    this.zzamB = new ArrayList(paramCollection);
  }
  
  private AppVisibleCustomProperties(Collection<CustomProperty> paramCollection)
  {
    this(1, paramCollection);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Iterator<CustomProperty> iterator()
  {
    return this.zzamB.iterator();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public Map<CustomPropertyKey, String> zzrH()
  {
    HashMap localHashMap = new HashMap(this.zzamB.size());
    Iterator localIterator = this.zzamB.iterator();
    while (localIterator.hasNext())
    {
      CustomProperty localCustomProperty = (CustomProperty)localIterator.next();
      localHashMap.put(localCustomProperty.zzrJ(), localCustomProperty.getValue());
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static class zza
  {
    private final Map<CustomPropertyKey, CustomProperty> zzamC = new HashMap();
    
    public zza zza(CustomPropertyKey paramCustomPropertyKey, String paramString)
    {
      zzx.zzb(paramCustomPropertyKey, "key");
      this.zzamC.put(paramCustomPropertyKey, new CustomProperty(paramCustomPropertyKey, paramString));
      return this;
    }
    
    public zza zza(CustomProperty paramCustomProperty)
    {
      zzx.zzb(paramCustomProperty, "property");
      this.zzamC.put(paramCustomProperty.zzrJ(), paramCustomProperty);
      return this;
    }
    
    public AppVisibleCustomProperties zzrI()
    {
      return new AppVisibleCustomProperties(this.zzamC.values(), null);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\metadata\internal\AppVisibleCustomProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */