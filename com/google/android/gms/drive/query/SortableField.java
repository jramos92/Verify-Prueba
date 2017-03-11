package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zznf;
import java.util.Date;

public class SortableField
{
  public static final SortableMetadataField<Date> CREATED_DATE;
  public static final SortableMetadataField<Date> LAST_VIEWED_BY_ME;
  public static final SortableMetadataField<Date> MODIFIED_BY_ME_DATE;
  public static final SortableMetadataField<Date> MODIFIED_DATE;
  public static final SortableMetadataField<Long> QUOTA_USED = zznd.zzanm;
  public static final SortableMetadataField<Date> SHARED_WITH_ME_DATE;
  public static final SortableMetadataField<String> TITLE = zznd.zzanp;
  public static final SortableMetadataField<Date> zzanU = zznf.zzanG;
  
  static
  {
    CREATED_DATE = zznf.zzanB;
    MODIFIED_DATE = zznf.zzanD;
    MODIFIED_BY_ME_DATE = zznf.zzanE;
    LAST_VIEWED_BY_ME = zznf.zzanC;
    SHARED_WITH_ME_DATE = zznf.zzanF;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\query\SortableField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */