package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzg
  extends zza<Long>
{
  public zzg(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  protected void zza(Bundle paramBundle, Long paramLong)
  {
    paramBundle.putLong(getName(), paramLong.longValue());
  }
  
  protected Long zzh(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return Long.valueOf(paramDataHolder.zzb(getName(), paramInt1, paramInt2));
  }
  
  protected Long zzo(Bundle paramBundle)
  {
    return Long.valueOf(paramBundle.getLong(getName()));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\metadata\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */