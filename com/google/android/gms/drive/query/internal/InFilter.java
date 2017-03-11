package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class InFilter<T>
  extends AbstractFilter
{
  public static final zzj CREATOR = new zzj();
  final int mVersionCode;
  final MetadataBundle zzanW;
  private final zzb<T> zzaoj;
  
  InFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.mVersionCode = paramInt;
    this.zzanW = paramMetadataBundle;
    this.zzaoj = ((zzb)zze.zzb(paramMetadataBundle));
  }
  
  public InFilter(SearchableCollectionMetadataField<T> paramSearchableCollectionMetadataField, T paramT)
  {
    this(1, MetadataBundle.zza(paramSearchableCollectionMetadataField, Collections.singleton(paramT)));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public T getValue()
  {
    return (T)((Collection)this.zzanW.zza(this.zzaoj)).iterator().next();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
  
  public <F> F zza(zzf<F> paramzzf)
  {
    return (F)paramzzf.zzb(this.zzaoj, getValue());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\internal\InFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */