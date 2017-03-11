package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public abstract interface MetadataField<T>
{
  public abstract String getName();
  
  public abstract T zza(DataHolder paramDataHolder, int paramInt1, int paramInt2);
  
  public abstract void zza(DataHolder paramDataHolder, MetadataBundle paramMetadataBundle, int paramInt1, int paramInt2);
  
  public abstract void zza(T paramT, Bundle paramBundle);
  
  public abstract T zzj(Bundle paramBundle);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\metadata\MetadataField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */