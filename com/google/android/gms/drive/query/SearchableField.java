package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznf;
import java.util.Date;

public class SearchableField
{
  public static final SearchableMetadataField<Boolean> IS_PINNED = zznd.zzamY;
  public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME;
  public static final SearchableMetadataField<String> MIME_TYPE;
  public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE;
  public static final SearchableCollectionMetadataField<DriveId> PARENTS;
  public static final SearchableMetadataField<Boolean> STARRED;
  public static final SearchableMetadataField<String> TITLE = zznd.zzanp;
  public static final SearchableMetadataField<Boolean> TRASHED;
  public static final SearchableOrderedMetadataField<Date> zzanQ;
  public static final SearchableMetadataField<AppVisibleCustomProperties> zzanR = zznd.zzamL;
  
  static
  {
    MIME_TYPE = zznd.zzang;
    TRASHED = zznd.zzanq;
    PARENTS = zznd.zzanl;
    zzanQ = zznf.zzanF;
    STARRED = zznd.zzann;
    MODIFIED_DATE = zznf.zzanD;
    LAST_VIEWED_BY_ME = zznf.zzanC;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\SearchableField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */