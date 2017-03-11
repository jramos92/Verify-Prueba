package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class zza<T>
  implements MetadataField<T>
{
  private final String zzamv;
  private final Set<String> zzamw;
  private final Set<String> zzamx;
  private final int zzamy;
  
  protected zza(String paramString, int paramInt)
  {
    this.zzamv = ((String)zzx.zzb(paramString, "fieldName"));
    this.zzamw = Collections.singleton(paramString);
    this.zzamx = Collections.emptySet();
    this.zzamy = paramInt;
  }
  
  protected zza(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt)
  {
    this.zzamv = ((String)zzx.zzb(paramString, "fieldName"));
    this.zzamw = Collections.unmodifiableSet(new HashSet(paramCollection1));
    this.zzamx = Collections.unmodifiableSet(new HashSet(paramCollection2));
    this.zzamy = paramInt;
  }
  
  public final String getName()
  {
    return this.zzamv;
  }
  
  public String toString()
  {
    return this.zzamv;
  }
  
  public final T zza(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    if (zzb(paramDataHolder, paramInt1, paramInt2)) {
      return (T)zzc(paramDataHolder, paramInt1, paramInt2);
    }
    return null;
  }
  
  protected abstract void zza(Bundle paramBundle, T paramT);
  
  public final void zza(DataHolder paramDataHolder, MetadataBundle paramMetadataBundle, int paramInt1, int paramInt2)
  {
    zzx.zzb(paramDataHolder, "dataHolder");
    zzx.zzb(paramMetadataBundle, "bundle");
    if (zzb(paramDataHolder, paramInt1, paramInt2)) {
      paramMetadataBundle.zzb(this, zzc(paramDataHolder, paramInt1, paramInt2));
    }
  }
  
  public final void zza(T paramT, Bundle paramBundle)
  {
    zzx.zzb(paramBundle, "bundle");
    if (paramT == null)
    {
      paramBundle.putString(getName(), null);
      return;
    }
    zza(paramBundle, paramT);
  }
  
  protected boolean zzb(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.zzamw.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ((!paramDataHolder.zzce(str)) || (paramDataHolder.zzi(str, paramInt1, paramInt2))) {
        return false;
      }
    }
    return true;
  }
  
  protected abstract T zzc(DataHolder paramDataHolder, int paramInt1, int paramInt2);
  
  public final T zzj(Bundle paramBundle)
  {
    zzx.zzb(paramBundle, "bundle");
    if (paramBundle.get(getName()) != null) {
      return (T)zzk(paramBundle);
    }
    return null;
  }
  
  protected abstract T zzk(Bundle paramBundle);
  
  public final Collection<String> zzrG()
  {
    return this.zzamw;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\metadata\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */