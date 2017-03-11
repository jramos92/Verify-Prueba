package com.google.android.gms.drive;

import android.os.Bundle;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzp;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.internal.zznd;
import java.util.Collection;
import java.util.Iterator;

public final class MetadataBuffer
  extends AbstractDataBuffer<Metadata>
{
  private zza zzaja;
  
  public MetadataBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    paramDataHolder.zzor().setClassLoader(MetadataBuffer.class.getClassLoader());
  }
  
  public Metadata get(int paramInt)
  {
    zza localzza2 = this.zzaja;
    zza localzza1;
    if (localzza2 != null)
    {
      localzza1 = localzza2;
      if (zza.zza(localzza2) == paramInt) {}
    }
    else
    {
      localzza1 = new zza(this.zzabq, paramInt);
      this.zzaja = localzza1;
    }
    return localzza1;
  }
  
  @Deprecated
  public String getNextPageToken()
  {
    return null;
  }
  
  public void release()
  {
    if (this.zzabq != null) {
      zze.zza(this.zzabq);
    }
    super.release();
  }
  
  private static class zza
    extends Metadata
  {
    private final DataHolder zzabq;
    private final int zzadm;
    private final int zzajb;
    
    public zza(DataHolder paramDataHolder, int paramInt)
    {
      this.zzabq = paramDataHolder;
      this.zzajb = paramInt;
      this.zzadm = paramDataHolder.zzbt(paramInt);
    }
    
    public boolean isDataValid()
    {
      return !this.zzabq.isClosed();
    }
    
    public <T> T zza(MetadataField<T> paramMetadataField)
    {
      return (T)paramMetadataField.zza(this.zzabq, this.zzajb, this.zzadm);
    }
    
    public Metadata zzqV()
    {
      MetadataBundle localMetadataBundle = MetadataBundle.zzrM();
      Iterator localIterator = zze.zzrK().iterator();
      while (localIterator.hasNext())
      {
        MetadataField localMetadataField = (MetadataField)localIterator.next();
        if (localMetadataField != zznd.zzano) {
          localMetadataField.zza(this.zzabq, localMetadataBundle, this.zzajb, this.zzadm);
        }
      }
      return new zzp(localMetadataBundle);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\MetadataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */