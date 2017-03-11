package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogicalFilter
  extends AbstractFilter
{
  public static final Parcelable.Creator<LogicalFilter> CREATOR = new zzk();
  final int mVersionCode;
  private List<Filter> zzanP;
  final Operator zzanV;
  final List<FilterHolder> zzaok;
  
  LogicalFilter(int paramInt, Operator paramOperator, List<FilterHolder> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzanV = paramOperator;
    this.zzaok = paramList;
  }
  
  public LogicalFilter(Operator paramOperator, Filter paramFilter, Filter... paramVarArgs)
  {
    this.mVersionCode = 1;
    this.zzanV = paramOperator;
    this.zzaok = new ArrayList(paramVarArgs.length + 1);
    this.zzaok.add(new FilterHolder(paramFilter));
    this.zzanP = new ArrayList(paramVarArgs.length + 1);
    this.zzanP.add(paramFilter);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramOperator = paramVarArgs[i];
      this.zzaok.add(new FilterHolder(paramOperator));
      this.zzanP.add(paramOperator);
      i += 1;
    }
  }
  
  public LogicalFilter(Operator paramOperator, Iterable<Filter> paramIterable)
  {
    this.mVersionCode = 1;
    this.zzanV = paramOperator;
    this.zzanP = new ArrayList();
    this.zzaok = new ArrayList();
    paramOperator = paramIterable.iterator();
    while (paramOperator.hasNext())
    {
      paramIterable = (Filter)paramOperator.next();
      this.zzanP.add(paramIterable);
      this.zzaok.add(new FilterHolder(paramIterable));
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzk.zza(this, paramParcel, paramInt);
  }
  
  public <T> T zza(zzf<T> paramzzf)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzaok.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((FilterHolder)localIterator.next()).getFilter().zza(paramzzf));
    }
    return (T)paramzzf.zzb(this.zzanV, localArrayList);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\internal\LogicalFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */