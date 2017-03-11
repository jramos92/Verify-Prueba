package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzag.zza;
import java.util.Map;

class zzq
  extends zzak
{
  private static final String ID = zzad.zzbo.toString();
  private final String zzYk;
  
  public zzq(String paramString)
  {
    super(ID, new String[0]);
    this.zzYk = paramString;
  }
  
  public boolean zzCo()
  {
    return true;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    if (this.zzYk == null) {
      return zzdf.zzDX();
    }
    return zzdf.zzQ(this.zzYk);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\tagmanager\zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */