package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzle
  implements Releasable, Result
{
  protected final Status zzSC;
  protected final DataHolder zzabq;
  
  protected zzle(DataHolder paramDataHolder, Status paramStatus)
  {
    this.zzSC = paramStatus;
    this.zzabq = paramDataHolder;
  }
  
  public Status getStatus()
  {
    return this.zzSC;
  }
  
  public void release()
  {
    if (this.zzabq != null) {
      this.zzabq.close();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */