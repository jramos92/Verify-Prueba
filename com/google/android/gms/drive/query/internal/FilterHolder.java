package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder
  implements SafeParcelable
{
  public static final Parcelable.Creator<FilterHolder> CREATOR = new zzd();
  final int mVersionCode;
  private final Filter zzajh;
  final ComparisonFilter<?> zzanZ;
  final FieldOnlyFilter zzaoa;
  final LogicalFilter zzaob;
  final NotFilter zzaoc;
  final InFilter<?> zzaod;
  final MatchAllFilter zzaoe;
  final HasFilter zzaof;
  final FullTextSearchFilter zzaog;
  final OwnedByMeFilter zzaoh;
  
  FilterHolder(int paramInt, ComparisonFilter<?> paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter<?> paramInFilter, MatchAllFilter paramMatchAllFilter, HasFilter<?> paramHasFilter, FullTextSearchFilter paramFullTextSearchFilter, OwnedByMeFilter paramOwnedByMeFilter)
  {
    this.mVersionCode = paramInt;
    this.zzanZ = paramComparisonFilter;
    this.zzaoa = paramFieldOnlyFilter;
    this.zzaob = paramLogicalFilter;
    this.zzaoc = paramNotFilter;
    this.zzaod = paramInFilter;
    this.zzaoe = paramMatchAllFilter;
    this.zzaof = paramHasFilter;
    this.zzaog = paramFullTextSearchFilter;
    this.zzaoh = paramOwnedByMeFilter;
    if (this.zzanZ != null)
    {
      this.zzajh = this.zzanZ;
      return;
    }
    if (this.zzaoa != null)
    {
      this.zzajh = this.zzaoa;
      return;
    }
    if (this.zzaob != null)
    {
      this.zzajh = this.zzaob;
      return;
    }
    if (this.zzaoc != null)
    {
      this.zzajh = this.zzaoc;
      return;
    }
    if (this.zzaod != null)
    {
      this.zzajh = this.zzaod;
      return;
    }
    if (this.zzaoe != null)
    {
      this.zzajh = this.zzaoe;
      return;
    }
    if (this.zzaof != null)
    {
      this.zzajh = this.zzaof;
      return;
    }
    if (this.zzaog != null)
    {
      this.zzajh = this.zzaog;
      return;
    }
    if (this.zzaoh != null)
    {
      this.zzajh = this.zzaoh;
      return;
    }
    throw new IllegalArgumentException("At least one filter must be set.");
  }
  
  public FilterHolder(Filter paramFilter)
  {
    zzx.zzb(paramFilter, "Null filter.");
    this.mVersionCode = 2;
    if ((paramFilter instanceof ComparisonFilter))
    {
      localObject = (ComparisonFilter)paramFilter;
      this.zzanZ = ((ComparisonFilter)localObject);
      if (!(paramFilter instanceof FieldOnlyFilter)) {
        break label247;
      }
      localObject = (FieldOnlyFilter)paramFilter;
      label45:
      this.zzaoa = ((FieldOnlyFilter)localObject);
      if (!(paramFilter instanceof LogicalFilter)) {
        break label252;
      }
      localObject = (LogicalFilter)paramFilter;
      label62:
      this.zzaob = ((LogicalFilter)localObject);
      if (!(paramFilter instanceof NotFilter)) {
        break label257;
      }
      localObject = (NotFilter)paramFilter;
      label79:
      this.zzaoc = ((NotFilter)localObject);
      if (!(paramFilter instanceof InFilter)) {
        break label262;
      }
      localObject = (InFilter)paramFilter;
      label96:
      this.zzaod = ((InFilter)localObject);
      if (!(paramFilter instanceof MatchAllFilter)) {
        break label267;
      }
      localObject = (MatchAllFilter)paramFilter;
      label113:
      this.zzaoe = ((MatchAllFilter)localObject);
      if (!(paramFilter instanceof HasFilter)) {
        break label272;
      }
      localObject = (HasFilter)paramFilter;
      label130:
      this.zzaof = ((HasFilter)localObject);
      if (!(paramFilter instanceof FullTextSearchFilter)) {
        break label277;
      }
      localObject = (FullTextSearchFilter)paramFilter;
      label147:
      this.zzaog = ((FullTextSearchFilter)localObject);
      if (!(paramFilter instanceof OwnedByMeFilter)) {
        break label282;
      }
    }
    label247:
    label252:
    label257:
    label262:
    label267:
    label272:
    label277:
    label282:
    for (Object localObject = (OwnedByMeFilter)paramFilter;; localObject = null)
    {
      this.zzaoh = ((OwnedByMeFilter)localObject);
      if ((this.zzanZ != null) || (this.zzaoa != null) || (this.zzaob != null) || (this.zzaoc != null) || (this.zzaod != null) || (this.zzaoe != null) || (this.zzaof != null) || (this.zzaog != null) || (this.zzaoh != null)) {
        break label287;
      }
      throw new IllegalArgumentException("Invalid filter type.");
      localObject = null;
      break;
      localObject = null;
      break label45;
      localObject = null;
      break label62;
      localObject = null;
      break label79;
      localObject = null;
      break label96;
      localObject = null;
      break label113;
      localObject = null;
      break label130;
      localObject = null;
      break label147;
    }
    label287:
    this.zzajh = paramFilter;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Filter getFilter()
  {
    return this.zzajh;
  }
  
  public String toString()
  {
    return String.format("FilterHolder[%s]", new Object[] { this.zzajh });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\internal\FilterHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */