package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

public class zzg
  implements zzf<Boolean>
{
  private Boolean zzaoi = Boolean.valueOf(false);
  
  public static boolean zza(Filter paramFilter)
  {
    if (paramFilter == null) {
      return false;
    }
    return ((Boolean)paramFilter.zza(new zzg())).booleanValue();
  }
  
  public <T> Boolean zzc(zzb<T> paramzzb, T paramT)
  {
    return this.zzaoi;
  }
  
  public <T> Boolean zzc(Operator paramOperator, MetadataField<T> paramMetadataField, T paramT)
  {
    return this.zzaoi;
  }
  
  public Boolean zzc(Operator paramOperator, List<Boolean> paramList)
  {
    return this.zzaoi;
  }
  
  public Boolean zzcM(String paramString)
  {
    if (!paramString.isEmpty()) {
      this.zzaoi = Boolean.valueOf(true);
    }
    return this.zzaoi;
  }
  
  public Boolean zzd(Boolean paramBoolean)
  {
    return this.zzaoi;
  }
  
  public <T> Boolean zze(MetadataField<T> paramMetadataField, T paramT)
  {
    return this.zzaoi;
  }
  
  public Boolean zzf(MetadataField<?> paramMetadataField)
  {
    return this.zzaoi;
  }
  
  public Boolean zzrW()
  {
    return this.zzaoi;
  }
  
  public Boolean zzrX()
  {
    return this.zzaoi;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */