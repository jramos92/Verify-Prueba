package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;

public class NotFilter
  extends AbstractFilter
{
  public static final Parcelable.Creator<NotFilter> CREATOR = new zzm();
  final int mVersionCode;
  final FilterHolder zzaol;
  
  NotFilter(int paramInt, FilterHolder paramFilterHolder)
  {
    this.mVersionCode = paramInt;
    this.zzaol = paramFilterHolder;
  }
  
  public NotFilter(Filter paramFilter)
  {
    this(1, new FilterHolder(paramFilter));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
  
  public <T> T zza(zzf<T> paramzzf)
  {
    return (T)paramzzf.zzx(this.zzaol.getFilter().zza(paramzzf));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\internal\NotFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */