package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzo
  extends zza<String>
{
  public zzo(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  protected void zzb(Bundle paramBundle, String paramString)
  {
    paramBundle.putString(getName(), paramString);
  }
  
  protected String zzi(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return paramDataHolder.zzd(getName(), paramInt1, paramInt2);
  }
  
  protected String zzr(Bundle paramBundle)
  {
    return paramBundle.getString(getName());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\metadata\internal\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */