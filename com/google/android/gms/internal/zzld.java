package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;

public abstract class zzld<L>
  implements zzlm.zzb<L>
{
  private final DataHolder zzabq;
  
  protected zzld(DataHolder paramDataHolder)
  {
    this.zzabq = paramDataHolder;
  }
  
  protected abstract void zza(L paramL, DataHolder paramDataHolder);
  
  public void zznN()
  {
    if (this.zzabq != null) {
      this.zzabq.close();
    }
  }
  
  public final void zzq(L paramL)
  {
    zza(paramL, this.zzabq);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */