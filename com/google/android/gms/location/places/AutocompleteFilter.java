package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutocompleteFilter
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  final int mVersionCode;
  final boolean zzaFW;
  final List<Integer> zzaFX;
  private final Set<Integer> zzaFY;
  
  AutocompleteFilter(int paramInt, boolean paramBoolean, Collection<Integer> paramCollection)
  {
    this.mVersionCode = paramInt;
    this.zzaFW = paramBoolean;
    if (paramCollection == null) {}
    for (paramCollection = Collections.emptyList();; paramCollection = new ArrayList(paramCollection))
    {
      this.zzaFX = paramCollection;
      if (!this.zzaFX.isEmpty()) {
        break;
      }
      this.zzaFY = Collections.emptySet();
      return;
    }
    this.zzaFY = Collections.unmodifiableSet(new HashSet(this.zzaFX));
  }
  
  public static AutocompleteFilter create(Collection<Integer> paramCollection)
  {
    return zza(true, paramCollection);
  }
  
  public static AutocompleteFilter zza(boolean paramBoolean, Collection<Integer> paramCollection)
  {
    return new AutocompleteFilter(0, paramBoolean, paramCollection);
  }
  
  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof AutocompleteFilter)) {
        return false;
      }
      paramObject = (AutocompleteFilter)paramObject;
    } while ((this.zzaFY.equals(((AutocompleteFilter)paramObject).zzaFY)) && (this.zzaFW == ((AutocompleteFilter)paramObject).zzaFW));
    return false;
  }
  
  public Set<Integer> getPlaceTypes()
  {
    return this.zzaFY;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Boolean.valueOf(this.zzaFW), this.zzaFY });
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzv(this);
    if (!this.zzaFW) {
      localzza.zzg("restrictedToPlaces", Boolean.valueOf(this.zzaFW));
    }
    localzza.zzg("placeTypes", this.zzaFY);
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzwM()
  {
    return this.zzaFW;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\AutocompleteFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */