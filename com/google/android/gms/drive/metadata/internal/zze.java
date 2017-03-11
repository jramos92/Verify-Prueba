package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zznd;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.internal.zznf;
import com.google.android.gms.internal.zznh;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zze
{
  private static final Map<String, MetadataField<?>> zzamE = new HashMap();
  private static final Map<String, zza> zzamF = new HashMap();
  
  static
  {
    zzb(zznd.zzamJ);
    zzb(zznd.zzanp);
    zzb(zznd.zzang);
    zzb(zznd.zzann);
    zzb(zznd.zzanq);
    zzb(zznd.zzamW);
    zzb(zznd.zzamV);
    zzb(zznd.zzamX);
    zzb(zznd.zzamY);
    zzb(zznd.zzamZ);
    zzb(zznd.zzamT);
    zzb(zznd.zzanb);
    zzb(zznd.zzanc);
    zzb(zznd.zzand);
    zzb(zznd.zzanl);
    zzb(zznd.zzamK);
    zzb(zznd.zzani);
    zzb(zznd.zzamM);
    zzb(zznd.zzamU);
    zzb(zznd.zzamN);
    zzb(zznd.zzamO);
    zzb(zznd.zzamP);
    zzb(zznd.zzamQ);
    zzb(zznd.zzanf);
    zzb(zznd.zzana);
    zzb(zznd.zzanh);
    zzb(zznd.zzanj);
    zzb(zznd.zzank);
    zzb(zznd.zzanm);
    zzb(zznd.zzanr);
    zzb(zznd.zzans);
    zzb(zznd.zzamS);
    zzb(zznd.zzamR);
    zzb(zznd.zzano);
    zzb(zznd.zzane);
    zzb(zznd.zzamL);
    zzb(zznd.zzant);
    zzb(zznd.zzanu);
    zzb(zznd.zzanv);
    zzb(zznd.zzanw);
    zzb(zznd.zzanx);
    zzb(zznd.zzany);
    zzb(zznd.zzanz);
    zzb(zznf.zzanB);
    zzb(zznf.zzanD);
    zzb(zznf.zzanE);
    zzb(zznf.zzanF);
    zzb(zznf.zzanC);
    zzb(zznf.zzanG);
    zzb(zznh.zzanI);
    zzb(zznh.zzanJ);
    zzl localzzl = zznd.zzanl;
    zza(zzl.zzamI);
    zza(zzne.zzanA);
  }
  
  public static void zza(DataHolder paramDataHolder)
  {
    Iterator localIterator = zzamF.values().iterator();
    while (localIterator.hasNext()) {
      ((zza)localIterator.next()).zzb(paramDataHolder);
    }
  }
  
  private static void zza(zza paramzza)
  {
    if (zzamF.put(paramzza.zzrL(), paramzza) != null) {
      throw new IllegalStateException("A cleaner for key " + paramzza.zzrL() + " has already been registered");
    }
  }
  
  private static void zzb(MetadataField<?> paramMetadataField)
  {
    if (zzamE.containsKey(paramMetadataField.getName())) {
      throw new IllegalArgumentException("Duplicate field name registered: " + paramMetadataField.getName());
    }
    zzamE.put(paramMetadataField.getName(), paramMetadataField);
  }
  
  public static MetadataField<?> zzcF(String paramString)
  {
    return (MetadataField)zzamE.get(paramString);
  }
  
  public static Collection<MetadataField<?>> zzrK()
  {
    return Collections.unmodifiableCollection(zzamE.values());
  }
  
  public static abstract interface zza
  {
    public abstract void zzb(DataHolder paramDataHolder);
    
    public abstract String zzrL();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\metadata\internal\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */