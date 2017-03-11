package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznf;
import com.google.android.gms.internal.zznh;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public abstract class Metadata
  implements Freezable<Metadata>
{
  public static final int CONTENT_AVAILABLE_LOCALLY = 1;
  public static final int CONTENT_NOT_AVAILABLE_LOCALLY = 0;
  
  public String getAlternateLink()
  {
    return (String)zza(zznd.zzamK);
  }
  
  public int getContentAvailability()
  {
    Integer localInteger = (Integer)zza(zznh.zzanI);
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public Date getCreatedDate()
  {
    return (Date)zza(zznf.zzanB);
  }
  
  public Map<CustomPropertyKey, String> getCustomProperties()
  {
    AppVisibleCustomProperties localAppVisibleCustomProperties = (AppVisibleCustomProperties)zza(zznd.zzamL);
    if (localAppVisibleCustomProperties == null) {
      return Collections.emptyMap();
    }
    return localAppVisibleCustomProperties.zzrH();
  }
  
  public String getDescription()
  {
    return (String)zza(zznd.zzamM);
  }
  
  public DriveId getDriveId()
  {
    return (DriveId)zza(zznd.zzamJ);
  }
  
  public String getEmbedLink()
  {
    return (String)zza(zznd.zzamN);
  }
  
  public String getFileExtension()
  {
    return (String)zza(zznd.zzamO);
  }
  
  public long getFileSize()
  {
    return ((Long)zza(zznd.zzamP)).longValue();
  }
  
  public Date getLastViewedByMeDate()
  {
    return (Date)zza(zznf.zzanC);
  }
  
  public String getMimeType()
  {
    return (String)zza(zznd.zzang);
  }
  
  public Date getModifiedByMeDate()
  {
    return (Date)zza(zznf.zzanE);
  }
  
  public Date getModifiedDate()
  {
    return (Date)zza(zznf.zzanD);
  }
  
  public String getOriginalFilename()
  {
    return (String)zza(zznd.zzanh);
  }
  
  public long getQuotaBytesUsed()
  {
    return ((Long)zza(zznd.zzanm)).longValue();
  }
  
  public Date getSharedWithMeDate()
  {
    return (Date)zza(zznf.zzanF);
  }
  
  public String getTitle()
  {
    return (String)zza(zznd.zzanp);
  }
  
  public String getWebContentLink()
  {
    return (String)zza(zznd.zzanr);
  }
  
  public String getWebViewLink()
  {
    return (String)zza(zznd.zzans);
  }
  
  public boolean isEditable()
  {
    Boolean localBoolean = (Boolean)zza(zznd.zzamV);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isExplicitlyTrashed()
  {
    Boolean localBoolean = (Boolean)zza(zznd.zzamW);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isFolder()
  {
    return "application/vnd.google-apps.folder".equals(getMimeType());
  }
  
  public boolean isInAppFolder()
  {
    Boolean localBoolean = (Boolean)zza(zznd.zzamT);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isPinnable()
  {
    Boolean localBoolean = (Boolean)zza(zznh.zzanJ);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isPinned()
  {
    Boolean localBoolean = (Boolean)zza(zznd.zzamY);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isRestricted()
  {
    Boolean localBoolean = (Boolean)zza(zznd.zzana);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isShared()
  {
    Boolean localBoolean = (Boolean)zza(zznd.zzanb);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isStarred()
  {
    Boolean localBoolean = (Boolean)zza(zznd.zzann);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isTrashable()
  {
    Boolean localBoolean = (Boolean)zza(zznd.zzane);
    if (localBoolean == null) {
      return true;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isTrashed()
  {
    Boolean localBoolean = (Boolean)zza(zznd.zzanq);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isViewed()
  {
    Boolean localBoolean = (Boolean)zza(zznd.zzanf);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public abstract <T> T zza(MetadataField<T> paramMetadataField);
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\Metadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */