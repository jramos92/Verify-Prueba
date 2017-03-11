package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zznd;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MetadataBundle
  implements SafeParcelable
{
  public static final Parcelable.Creator<MetadataBundle> CREATOR = new zzh();
  final int mVersionCode;
  final Bundle zzamG;
  
  MetadataBundle(int paramInt, Bundle paramBundle)
  {
    this.mVersionCode = paramInt;
    this.zzamG = ((Bundle)zzx.zzw(paramBundle));
    this.zzamG.setClassLoader(getClass().getClassLoader());
    paramBundle = new ArrayList();
    Object localObject = this.zzamG.keySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (zze.zzcF(str) == null)
      {
        paramBundle.add(str);
        zzz.zzy("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
      }
    }
    paramBundle = paramBundle.iterator();
    while (paramBundle.hasNext())
    {
      localObject = (String)paramBundle.next();
      this.zzamG.remove((String)localObject);
    }
  }
  
  private MetadataBundle(Bundle paramBundle)
  {
    this(1, paramBundle);
  }
  
  public static <T> MetadataBundle zza(MetadataField<T> paramMetadataField, T paramT)
  {
    MetadataBundle localMetadataBundle = zzrM();
    localMetadataBundle.zzb(paramMetadataField, paramT);
    return localMetadataBundle;
  }
  
  public static MetadataBundle zza(MetadataBundle paramMetadataBundle)
  {
    return new MetadataBundle(new Bundle(paramMetadataBundle.zzamG));
  }
  
  public static MetadataBundle zzrM()
  {
    return new MetadataBundle(new Bundle());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MetadataBundle)) {
      return false;
    }
    paramObject = (MetadataBundle)paramObject;
    Object localObject = this.zzamG.keySet();
    if (!((Set)localObject).equals(((MetadataBundle)paramObject).zzamG.keySet())) {
      return false;
    }
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!zzw.equal(this.zzamG.get(str), ((MetadataBundle)paramObject).zzamG.get(str))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Iterator localIterator = this.zzamG.keySet().iterator();
    String str;
    for (int i = 1; localIterator.hasNext(); i = this.zzamG.get(str).hashCode() + i * 31) {
      str = (String)localIterator.next();
    }
    return i;
  }
  
  public void setContext(Context paramContext)
  {
    BitmapTeleporter localBitmapTeleporter = (BitmapTeleporter)zza(zznd.zzano);
    if (localBitmapTeleporter != null) {
      localBitmapTeleporter.zzc(paramContext.getCacheDir());
    }
  }
  
  public String toString()
  {
    return "MetadataBundle [values=" + this.zzamG + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public <T> T zza(MetadataField<T> paramMetadataField)
  {
    return (T)paramMetadataField.zzj(this.zzamG);
  }
  
  public <T> void zzb(MetadataField<T> paramMetadataField, T paramT)
  {
    if (zze.zzcF(paramMetadataField.getName()) == null) {
      throw new IllegalArgumentException("Unregistered field: " + paramMetadataField.getName());
    }
    paramMetadataField.zza(paramT, this.zzamG);
  }
  
  public boolean zzc(MetadataField<?> paramMetadataField)
  {
    return this.zzamG.containsKey(paramMetadataField.getName());
  }
  
  public Set<MetadataField<?>> zzrN()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.zzamG.keySet().iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(zze.zzcF((String)localIterator.next()));
    }
    return localHashSet;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\metadata\internal\MetadataBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */