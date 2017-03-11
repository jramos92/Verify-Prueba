package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class MatchAllFilter
  extends AbstractFilter
{
  public static final zzl CREATOR = new zzl();
  final int mVersionCode;
  
  public MatchAllFilter()
  {
    this(1);
  }
  
  MatchAllFilter(int paramInt)
  {
    this.mVersionCode = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
  
  public <F> F zza(zzf<F> paramzzf)
  {
    return (F)paramzzf.zzrV();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\internal\MatchAllFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */