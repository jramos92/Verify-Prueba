package com.google.android.gms.internal;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.zzg;
import com.google.android.gms.drive.metadata.internal.zzi;
import com.google.android.gms.drive.metadata.internal.zzj;
import com.google.android.gms.drive.metadata.internal.zzl;
import com.google.android.gms.drive.metadata.internal.zzn;
import com.google.android.gms.drive.metadata.internal.zzo;
import com.google.android.gms.drive.metadata.internal.zzp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class zznd
{
  public static final MetadataField<DriveId> zzamJ = zzng.zzanH;
  public static final MetadataField<String> zzamK = new zzo("alternateLink", 4300000);
  public static final zza zzamL = new zza(5000000);
  public static final MetadataField<String> zzamM = new zzo("description", 4300000);
  public static final MetadataField<String> zzamN = new zzo("embedLink", 4300000);
  public static final MetadataField<String> zzamO = new zzo("fileExtension", 4300000);
  public static final MetadataField<Long> zzamP = new zzg("fileSize", 4300000);
  public static final MetadataField<String> zzamQ = new zzo("folderColorRgb", 7500000);
  public static final MetadataField<Boolean> zzamR = new com.google.android.gms.drive.metadata.internal.zzb("hasThumbnail", 4300000);
  public static final MetadataField<String> zzamS = new zzo("indexableText", 4300000);
  public static final MetadataField<Boolean> zzamT = new com.google.android.gms.drive.metadata.internal.zzb("isAppData", 4300000);
  public static final MetadataField<Boolean> zzamU = new com.google.android.gms.drive.metadata.internal.zzb("isCopyable", 4300000);
  public static final MetadataField<Boolean> zzamV = new com.google.android.gms.drive.metadata.internal.zzb("isEditable", 4100000);
  public static final MetadataField<Boolean> zzamW = new com.google.android.gms.drive.metadata.internal.zzb("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 7000000)
  {
    protected Boolean zze(DataHolder paramAnonymousDataHolder, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousDataHolder.zzc("trashed", paramAnonymousInt1, paramAnonymousInt2) == 2) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    }
  };
  public static final MetadataField<Boolean> zzamX = new com.google.android.gms.drive.metadata.internal.zzb("isLocalContentUpToDate", 7800000);
  public static final zzb zzamY = new zzb("isPinned", 4100000);
  public static final MetadataField<Boolean> zzamZ = new com.google.android.gms.drive.metadata.internal.zzb("isOpenable", 7200000);
  public static final MetadataField<Boolean> zzana = new com.google.android.gms.drive.metadata.internal.zzb("isRestricted", 4300000);
  public static final MetadataField<Boolean> zzanb = new com.google.android.gms.drive.metadata.internal.zzb("isShared", 4300000);
  public static final MetadataField<Boolean> zzanc = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosFolder", 7000000);
  public static final MetadataField<Boolean> zzand = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosRootFolder", 7000000);
  public static final MetadataField<Boolean> zzane = new com.google.android.gms.drive.metadata.internal.zzb("isTrashable", 4400000);
  public static final MetadataField<Boolean> zzanf = new com.google.android.gms.drive.metadata.internal.zzb("isViewed", 4300000);
  public static final zzc zzang = new zzc(4100000);
  public static final MetadataField<String> zzanh = new zzo("originalFilename", 4300000);
  public static final com.google.android.gms.drive.metadata.zzb<String> zzani = new zzn("ownerNames", 4300000);
  public static final zzp zzanj = new zzp("lastModifyingUser", 6000000);
  public static final zzp zzank = new zzp("sharingUser", 6000000);
  public static final zzl zzanl = new zzl(4100000);
  public static final zzd zzanm = new zzd("quotaBytesUsed", 4300000);
  public static final zzf zzann = new zzf("starred", 4100000);
  public static final MetadataField<BitmapTeleporter> zzano = new zzj("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000)
  {
    protected BitmapTeleporter zzk(DataHolder paramAnonymousDataHolder, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      throw new IllegalStateException("Thumbnail field is write only");
    }
  };
  public static final zzg zzanp = new zzg("title", 4100000);
  public static final zzh zzanq = new zzh("trashed", 4100000);
  public static final MetadataField<String> zzanr = new zzo("webContentLink", 4300000);
  public static final MetadataField<String> zzans = new zzo("webViewLink", 4300000);
  public static final MetadataField<String> zzant = new zzo("uniqueIdentifier", 5000000);
  public static final com.google.android.gms.drive.metadata.internal.zzb zzanu = new com.google.android.gms.drive.metadata.internal.zzb("writersCanShare", 6000000);
  public static final MetadataField<String> zzanv = new zzo("role", 6000000);
  public static final MetadataField<String> zzanw = new zzo("md5Checksum", 7000000);
  public static final zze zzanx = new zze(7000000);
  public static final MetadataField<String> zzany = new zzo("recencyReason", 8000000);
  public static final MetadataField<Boolean> zzanz = new com.google.android.gms.drive.metadata.internal.zzb("subscribed", 8000000);
  
  public static class zza
    extends zzne
    implements SearchableMetadataField<AppVisibleCustomProperties>
  {
    public zza(int paramInt)
    {
      super();
    }
  }
  
  public static class zzb
    extends com.google.android.gms.drive.metadata.internal.zzb
    implements SearchableMetadataField<Boolean>
  {
    public zzb(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzc
    extends zzo
    implements SearchableMetadataField<String>
  {
    public zzc(int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzd
    extends zzg
    implements SortableMetadataField<Long>
  {
    public zzd(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zze
    extends zzi<DriveSpace>
  {
    public zze(int paramInt)
    {
      super(Arrays.asList(new String[] { "inDriveSpace", "isAppData", "inGooglePhotosSpace" }), Collections.emptySet(), paramInt);
    }
    
    protected Collection<DriveSpace> zzd(DataHolder paramDataHolder, int paramInt1, int paramInt2)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramDataHolder.zze("inDriveSpace", paramInt1, paramInt2)) {
        localArrayList.add(DriveSpace.zzaiR);
      }
      if (paramDataHolder.zze("isAppData", paramInt1, paramInt2)) {
        localArrayList.add(DriveSpace.zzaiS);
      }
      if (paramDataHolder.zze("inGooglePhotosSpace", paramInt1, paramInt2)) {
        localArrayList.add(DriveSpace.zzaiT);
      }
      return localArrayList;
    }
  }
  
  public static class zzf
    extends com.google.android.gms.drive.metadata.internal.zzb
    implements SearchableMetadataField<Boolean>
  {
    public zzf(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzg
    extends zzo
    implements SearchableMetadataField<String>, SortableMetadataField<String>
  {
    public zzg(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzh
    extends com.google.android.gms.drive.metadata.internal.zzb
    implements SearchableMetadataField<Boolean>
  {
    public zzh(String paramString, int paramInt)
    {
      super(paramInt);
    }
    
    protected Boolean zze(DataHolder paramDataHolder, int paramInt1, int paramInt2)
    {
      if (paramDataHolder.zzc(getName(), paramInt1, paramInt2) != 0) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zznd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */