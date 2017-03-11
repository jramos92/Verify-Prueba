package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzp
  extends Metadata
{
  private final MetadataBundle zzakt;
  
  public zzp(MetadataBundle paramMetadataBundle)
  {
    this.zzakt = paramMetadataBundle;
  }
  
  public boolean isDataValid()
  {
    return this.zzakt != null;
  }
  
  public String toString()
  {
    return "Metadata [mImpl=" + this.zzakt + "]";
  }
  
  public <T> T zza(MetadataField<T> paramMetadataField)
  {
    return (T)this.zzakt.zza(paramMetadataField);
  }
  
  public Metadata zzqV()
  {
    return new zzp(MetadataBundle.zza(this.zzakt));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */