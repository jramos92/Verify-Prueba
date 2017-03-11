package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class FieldOnlyFilter
  extends AbstractFilter
{
  public static final Parcelable.Creator<FieldOnlyFilter> CREATOR = new zzb();
  final int mVersionCode;
  final MetadataBundle zzanW;
  private final MetadataField<?> zzanX;
  
  FieldOnlyFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.mVersionCode = paramInt;
    this.zzanW = paramMetadataBundle;
    this.zzanX = zze.zzb(paramMetadataBundle);
  }
  
  public FieldOnlyFilter(SearchableMetadataField<?> paramSearchableMetadataField)
  {
    this(1, MetadataBundle.zza(paramSearchableMetadataField, null));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public <T> T zza(zzf<T> paramzzf)
  {
    return (T)paramzzf.zze(this.zzanX);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\internal\FieldOnlyFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */