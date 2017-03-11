package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Query
  implements SafeParcelable
{
  public static final Parcelable.Creator<Query> CREATOR = new zza();
  final int mVersionCode;
  final List<DriveSpace> zzajA;
  private final Set<DriveSpace> zzajB;
  final boolean zzalC;
  final LogicalFilter zzanK;
  final String zzanL;
  final SortOrder zzanM;
  final List<String> zzanN;
  final boolean zzanO;
  
  private Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList, boolean paramBoolean1, List<DriveSpace> paramList1, Set<DriveSpace> paramSet, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt;
    this.zzanK = paramLogicalFilter;
    this.zzanL = paramString;
    this.zzanM = paramSortOrder;
    this.zzanN = paramList;
    this.zzanO = paramBoolean1;
    this.zzajA = paramList1;
    this.zzajB = paramSet;
    this.zzalC = paramBoolean2;
  }
  
  Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList, boolean paramBoolean1, List<DriveSpace> paramList1, boolean paramBoolean2) {}
  
  private Query(LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList, boolean paramBoolean1, Set<DriveSpace> paramSet, boolean paramBoolean2) {}
  
  public int describeContents()
  {
    return 0;
  }
  
  public Filter getFilter()
  {
    return this.zzanK;
  }
  
  @Deprecated
  public String getPageToken()
  {
    return this.zzanL;
  }
  
  public SortOrder getSortOrder()
  {
    return this.zzanM;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Query[%s,%s,PageToken=%s,Spaces=%s]", new Object[] { this.zzanK, this.zzanM, this.zzanL, this.zzajA });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public List<String> zzrO()
  {
    return this.zzanN;
  }
  
  public boolean zzrP()
  {
    return this.zzanO;
  }
  
  public Set<DriveSpace> zzrQ()
  {
    return this.zzajB;
  }
  
  public boolean zzrR()
  {
    return this.zzalC;
  }
  
  public static class Builder
  {
    private Set<DriveSpace> zzajB;
    private boolean zzalC;
    private String zzanL;
    private SortOrder zzanM;
    private List<String> zzanN;
    private boolean zzanO;
    private final List<Filter> zzanP = new ArrayList();
    
    public Builder() {}
    
    public Builder(Query paramQuery)
    {
      this.zzanP.add(paramQuery.getFilter());
      this.zzanL = paramQuery.getPageToken();
      this.zzanM = paramQuery.getSortOrder();
      this.zzanN = paramQuery.zzrO();
      this.zzanO = paramQuery.zzrP();
      this.zzajB = paramQuery.zzrQ();
      this.zzalC = paramQuery.zzrR();
    }
    
    public Builder addFilter(Filter paramFilter)
    {
      if (!(paramFilter instanceof MatchAllFilter)) {
        this.zzanP.add(paramFilter);
      }
      return this;
    }
    
    public Query build()
    {
      return new Query(new LogicalFilter(Operator.zzaor, this.zzanP), this.zzanL, this.zzanM, this.zzanN, this.zzanO, this.zzajB, this.zzalC, null);
    }
    
    @Deprecated
    public Builder setPageToken(String paramString)
    {
      this.zzanL = paramString;
      return this;
    }
    
    public Builder setSortOrder(SortOrder paramSortOrder)
    {
      this.zzanM = paramSortOrder;
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\Query.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */