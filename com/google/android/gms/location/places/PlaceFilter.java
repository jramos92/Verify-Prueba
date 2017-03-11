package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class PlaceFilter
  extends zza
  implements SafeParcelable
{
  public static final zzg CREATOR = new zzg();
  final int mVersionCode;
  final List<Integer> zzaFX;
  private final Set<Integer> zzaFY;
  final List<String> zzaFZ;
  final List<UserDataType> zzaGa;
  private final Set<String> zzaGb;
  private final Set<UserDataType> zzaGc;
  final boolean zzaGl;
  
  public PlaceFilter()
  {
    this(false, null);
  }
  
  PlaceFilter(int paramInt, List<Integer> paramList, boolean paramBoolean, List<String> paramList1, List<UserDataType> paramList2)
  {
    this.mVersionCode = paramInt;
    if (paramList == null)
    {
      paramList = Collections.emptyList();
      this.zzaFX = paramList;
      this.zzaGl = paramBoolean;
      if (paramList2 != null) {
        break label97;
      }
      paramList = Collections.emptyList();
      label36:
      this.zzaGa = paramList;
      if (paramList1 != null) {
        break label106;
      }
    }
    label97:
    label106:
    for (paramList = Collections.emptyList();; paramList = Collections.unmodifiableList(paramList1))
    {
      this.zzaFZ = paramList;
      this.zzaFY = zzs(this.zzaFX);
      this.zzaGc = zzs(this.zzaGa);
      this.zzaGb = zzs(this.zzaFZ);
      return;
      paramList = Collections.unmodifiableList(paramList);
      break;
      paramList = Collections.unmodifiableList(paramList2);
      break label36;
    }
  }
  
  public PlaceFilter(Collection<Integer> paramCollection, boolean paramBoolean, Collection<String> paramCollection1, Collection<UserDataType> paramCollection2)
  {
    this(0, zzf(paramCollection), paramBoolean, zzf(paramCollection1), zzf(paramCollection2));
  }
  
  public PlaceFilter(boolean paramBoolean, Collection<String> paramCollection)
  {
    this(null, paramBoolean, paramCollection, null);
  }
  
  @Deprecated
  public static PlaceFilter zzwT()
  {
    return new zza(null).zzwU();
  }
  
  public int describeContents()
  {
    zzg localzzg = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceFilter)) {
        return false;
      }
      paramObject = (PlaceFilter)paramObject;
    } while ((this.zzaFY.equals(((PlaceFilter)paramObject).zzaFY)) && (this.zzaGl == ((PlaceFilter)paramObject).zzaGl) && (this.zzaGc.equals(((PlaceFilter)paramObject).zzaGc)) && (this.zzaGb.equals(((PlaceFilter)paramObject).zzaGb)));
    return false;
  }
  
  public Set<String> getPlaceIds()
  {
    return this.zzaGb;
  }
  
  public Set<Integer> getPlaceTypes()
  {
    return this.zzaFY;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaFY, Boolean.valueOf(this.zzaGl), this.zzaGc, this.zzaGb });
  }
  
  public boolean isRestrictedToPlacesOpenNow()
  {
    return this.zzaGl;
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzv(this);
    if (!this.zzaFY.isEmpty()) {
      localzza.zzg("types", this.zzaFY);
    }
    localzza.zzg("requireOpenNow", Boolean.valueOf(this.zzaGl));
    if (!this.zzaGb.isEmpty()) {
      localzza.zzg("placeIds", this.zzaGb);
    }
    if (!this.zzaGc.isEmpty()) {
      localzza.zzg("requestedUserDataTypes", this.zzaGc);
    }
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzg localzzg = CREATOR;
    zzg.zza(this, paramParcel, paramInt);
  }
  
  public Set<UserDataType> zzwS()
  {
    return this.zzaGc;
  }
  
  @Deprecated
  public static final class zza
  {
    private boolean zzaGl = false;
    private Collection<Integer> zzaGm = null;
    private Collection<UserDataType> zzaGn = null;
    private String[] zzaGo = null;
    
    public PlaceFilter zzwU()
    {
      List localList = null;
      ArrayList localArrayList1;
      if (this.zzaGm != null)
      {
        localArrayList1 = new ArrayList(this.zzaGm);
        if (this.zzaGn == null) {
          break label75;
        }
      }
      label75:
      for (ArrayList localArrayList2 = new ArrayList(this.zzaGn);; localArrayList2 = null)
      {
        if (this.zzaGo != null) {
          localList = Arrays.asList(this.zzaGo);
        }
        return new PlaceFilter(localArrayList1, this.zzaGl, localList, localArrayList2);
        localArrayList1 = null;
        break;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\PlaceFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */