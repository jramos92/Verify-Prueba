package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.zzd;
import java.util.Date;

public class zznf
{
  public static final zza zzanB = new zza("created", 4100000);
  public static final zzb zzanC = new zzb("lastOpenedTime", 4300000);
  public static final zzd zzanD = new zzd("modified", 4100000);
  public static final zzc zzanE = new zzc("modifiedByMe", 4100000);
  public static final zzf zzanF = new zzf("sharedWithMe", 4100000);
  public static final zze zzanG = new zze("recency", 8000000);
  
  public static class zza
    extends zzd
    implements SortableMetadataField<Date>
  {
    public zza(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzb
    extends zzd
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public zzb(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzc
    extends zzd
    implements SortableMetadataField<Date>
  {
    public zzc(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzd
    extends zzd
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public zzd(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zze
    extends zzd
    implements SortableMetadataField<Date>
  {
    public zze(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class zzf
    extends zzd
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public zzf(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zznf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */