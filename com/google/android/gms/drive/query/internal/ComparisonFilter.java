package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class ComparisonFilter<T>
  extends AbstractFilter
{
  public static final zza CREATOR = new zza();
  final int mVersionCode;
  final Operator zzanV;
  final MetadataBundle zzanW;
  final MetadataField<T> zzanX;
  
  ComparisonFilter(int paramInt, Operator paramOperator, MetadataBundle paramMetadataBundle)
  {
    this.mVersionCode = paramInt;
    this.zzanV = paramOperator;
    this.zzanW = paramMetadataBundle;
    this.zzanX = zze.zzb(paramMetadataBundle);
  }
  
  public ComparisonFilter(Operator paramOperator, SearchableMetadataField<T> paramSearchableMetadataField, T paramT)
  {
    this(1, paramOperator, MetadataBundle.zza(paramSearchableMetadataField, paramT));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public T getValue()
  {
    return (T)this.zzanW.zza(this.zzanX);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public <F> F zza(zzf<F> paramzzf)
  {
    return (F)paramzzf.zzb(this.zzanV, this.zzanX, getValue());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\internal\ComparisonFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */