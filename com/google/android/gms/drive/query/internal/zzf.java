package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import java.util.List;

public abstract interface zzf<F>
{
  public abstract <T> F zzb(zzb<T> paramzzb, T paramT);
  
  public abstract <T> F zzb(Operator paramOperator, MetadataField<T> paramMetadataField, T paramT);
  
  public abstract F zzb(Operator paramOperator, List<F> paramList);
  
  public abstract F zzcL(String paramString);
  
  public abstract <T> F zzd(MetadataField<T> paramMetadataField, T paramT);
  
  public abstract F zze(MetadataField<?> paramMetadataField);
  
  public abstract F zzrU();
  
  public abstract F zzrV();
  
  public abstract F zzx(F paramF);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */