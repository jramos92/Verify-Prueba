package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.common.internal.zzx;

public class zziy
{
  private final Context mContext;
  private zzk zzCo;
  private final ViewGroup zzJT;
  private final zziz zzoM;
  
  public zziy(Context paramContext, ViewGroup paramViewGroup, zziz paramzziz)
  {
    this(paramContext, paramViewGroup, paramzziz, null);
  }
  
  zziy(Context paramContext, ViewGroup paramViewGroup, zziz paramzziz, zzk paramzzk)
  {
    this.mContext = paramContext;
    this.zzJT = paramViewGroup;
    this.zzoM = paramzziz;
    this.zzCo = paramzzk;
  }
  
  public void onDestroy()
  {
    zzx.zzci("onDestroy must be called from the UI thread.");
    if (this.zzCo != null) {
      this.zzCo.destroy();
    }
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.zzCo != null) {
      return;
    }
    zzcc.zza(this.zzoM.zzhn().zzdm(), this.zzoM.zzhm(), new String[] { "vpr" });
    zzce localzzce = zzcc.zzb(this.zzoM.zzhn().zzdm());
    this.zzCo = new zzk(this.mContext, this.zzoM, paramInt5, this.zzoM.zzhn().zzdm(), localzzce);
    this.zzJT.addView(this.zzCo, 0, new ViewGroup.LayoutParams(-1, -1));
    this.zzCo.zzd(paramInt1, paramInt2, paramInt3, paramInt4);
    this.zzoM.zzhe().zzF(false);
  }
  
  public void zze(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    zzx.zzci("The underlay may only be modified from the UI thread.");
    if (this.zzCo != null) {
      this.zzCo.zzd(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public zzk zzgX()
  {
    zzx.zzci("getAdVideoUnderlay must be called from the UI thread.");
    return this.zzCo;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zziy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */