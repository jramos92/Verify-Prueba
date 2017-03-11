package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.List;

public final class RawDataSet
  implements SafeParcelable
{
  public static final Parcelable.Creator<RawDataSet> CREATOR = new zzo();
  final int mVersionCode;
  public final int zzaqU;
  public final int zzaqW;
  public final List<RawDataPoint> zzaqX;
  public final boolean zzaqa;
  
  public RawDataSet(int paramInt1, int paramInt2, int paramInt3, List<RawDataPoint> paramList, boolean paramBoolean)
  {
    this.mVersionCode = paramInt1;
    this.zzaqU = paramInt2;
    this.zzaqW = paramInt3;
    this.zzaqX = paramList;
    this.zzaqa = paramBoolean;
  }
  
  public RawDataSet(DataSet paramDataSet, List<DataSource> paramList, List<DataType> paramList1)
  {
    this.mVersionCode = 3;
    this.zzaqX = paramDataSet.zzr(paramList);
    this.zzaqa = paramDataSet.zzsh();
    this.zzaqU = zzs.zza(paramDataSet.getDataSource(), paramList);
    this.zzaqW = zzs.zza(paramDataSet.getDataType(), paramList1);
  }
  
  private boolean zza(RawDataSet paramRawDataSet)
  {
    return (this.zzaqU == paramRawDataSet.zzaqU) && (this.zzaqa == paramRawDataSet.zzaqa) && (zzw.equal(this.zzaqX, paramRawDataSet.zzaqX));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof RawDataSet)) && (zza((RawDataSet)paramObject)));
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.zzaqU) });
  }
  
  public String toString()
  {
    return String.format("RawDataSet{%s@[%s]}", new Object[] { Integer.valueOf(this.zzaqU), this.zzaqX });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\RawDataSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */