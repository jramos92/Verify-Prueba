package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;

public class BooleanResult
  implements Result
{
  private final Status zzSC;
  private final boolean zzaaE;
  
  public BooleanResult(Status paramStatus, boolean paramBoolean)
  {
    this.zzSC = ((Status)zzx.zzb(paramStatus, "Status must not be null"));
    this.zzaaE = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof BooleanResult)) {
        return false;
      }
      paramObject = (BooleanResult)paramObject;
    } while ((this.zzSC.equals(((BooleanResult)paramObject).zzSC)) && (this.zzaaE == ((BooleanResult)paramObject).zzaaE));
    return false;
  }
  
  public Status getStatus()
  {
    return this.zzSC;
  }
  
  public boolean getValue()
  {
    return this.zzaaE;
  }
  
  public final int hashCode()
  {
    int j = this.zzSC.hashCode();
    if (this.zzaaE) {}
    for (int i = 1;; i = 0) {
      return i + (j + 527) * 31;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\api\BooleanResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */