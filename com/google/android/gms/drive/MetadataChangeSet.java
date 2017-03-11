package com.google.android.gms.drive;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznf;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet
{
  public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
  public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
  public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
  public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
  public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
  public static final MetadataChangeSet zzajc = new MetadataChangeSet(MetadataBundle.zzrM());
  private final MetadataBundle zzajd;
  
  public MetadataChangeSet(MetadataBundle paramMetadataBundle)
  {
    this.zzajd = MetadataBundle.zza(paramMetadataBundle);
  }
  
  public Map<CustomPropertyKey, String> getCustomPropertyChangeMap()
  {
    AppVisibleCustomProperties localAppVisibleCustomProperties = (AppVisibleCustomProperties)this.zzajd.zza(zznd.zzamL);
    if (localAppVisibleCustomProperties == null) {
      return Collections.emptyMap();
    }
    return localAppVisibleCustomProperties.zzrH();
  }
  
  public String getDescription()
  {
    return (String)this.zzajd.zza(zznd.zzamM);
  }
  
  public String getIndexableText()
  {
    return (String)this.zzajd.zza(zznd.zzamS);
  }
  
  public Date getLastViewedByMeDate()
  {
    return (Date)this.zzajd.zza(zznf.zzanC);
  }
  
  public String getMimeType()
  {
    return (String)this.zzajd.zza(zznd.zzang);
  }
  
  public String getTitle()
  {
    return (String)this.zzajd.zza(zznd.zzanp);
  }
  
  public Boolean isPinned()
  {
    return (Boolean)this.zzajd.zza(zznd.zzamY);
  }
  
  public Boolean isStarred()
  {
    return (Boolean)this.zzajd.zza(zznd.zzann);
  }
  
  public Boolean isViewed()
  {
    return (Boolean)this.zzajd.zza(zznd.zzanf);
  }
  
  public MetadataBundle zzqW()
  {
    return this.zzajd;
  }
  
  public static class Builder
  {
    private final MetadataBundle zzajd = MetadataBundle.zzrM();
    private AppVisibleCustomProperties.zza zzaje;
    
    private int zzcD(String paramString)
    {
      if (paramString == null) {
        return 0;
      }
      return paramString.getBytes().length;
    }
    
    private String zzj(String paramString, int paramInt1, int paramInt2)
    {
      return String.format("%s must be no more than %d bytes, but is %d bytes.", new Object[] { paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    
    private void zzk(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt2 <= paramInt1) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, zzj(paramString, paramInt1, paramInt2));
        return;
      }
    }
    
    private AppVisibleCustomProperties.zza zzqX()
    {
      if (this.zzaje == null) {
        this.zzaje = new AppVisibleCustomProperties.zza();
      }
      return this.zzaje;
    }
    
    public MetadataChangeSet build()
    {
      if (this.zzaje != null) {
        this.zzajd.zzb(zznd.zzamL, this.zzaje.zzrI());
      }
      return new MetadataChangeSet(this.zzajd);
    }
    
    public Builder deleteCustomProperty(CustomPropertyKey paramCustomPropertyKey)
    {
      zzx.zzb(paramCustomPropertyKey, "key");
      zzqX().zza(paramCustomPropertyKey, null);
      return this;
    }
    
    public Builder setCustomProperty(CustomPropertyKey paramCustomPropertyKey, String paramString)
    {
      zzx.zzb(paramCustomPropertyKey, "key");
      zzx.zzb(paramString, "value");
      zzk("The total size of key string and value string of a custom property", 124, zzcD(paramCustomPropertyKey.getKey()) + zzcD(paramString));
      zzqX().zza(paramCustomPropertyKey, paramString);
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      this.zzajd.zzb(zznd.zzamM, paramString);
      return this;
    }
    
    public Builder setIndexableText(String paramString)
    {
      zzk("Indexable text size", 131072, zzcD(paramString));
      this.zzajd.zzb(zznd.zzamS, paramString);
      return this;
    }
    
    public Builder setLastViewedByMeDate(Date paramDate)
    {
      this.zzajd.zzb(zznf.zzanC, paramDate);
      return this;
    }
    
    public Builder setMimeType(String paramString)
    {
      this.zzajd.zzb(zznd.zzang, paramString);
      return this;
    }
    
    public Builder setPinned(boolean paramBoolean)
    {
      this.zzajd.zzb(zznd.zzamY, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public Builder setStarred(boolean paramBoolean)
    {
      this.zzajd.zzb(zznd.zzann, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public Builder setTitle(String paramString)
    {
      this.zzajd.zzb(zznd.zzanp, paramString);
      return this;
    }
    
    public Builder setViewed(boolean paramBoolean)
    {
      this.zzajd.zzb(zznd.zzanf, Boolean.valueOf(paramBoolean));
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\MetadataChangeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */