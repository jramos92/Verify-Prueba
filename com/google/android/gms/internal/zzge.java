package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzgr
public class zzge
  extends zzgc
{
  private zzgd zzDt;
  
  zzge(Context paramContext, zzhs.zza paramzza, zziz paramzziz, zzgg.zza paramzza1)
  {
    super(paramContext, paramzza, paramzziz, paramzza1);
  }
  
  protected void zzfs()
  {
    Object localObject = this.zzoM.zzaN();
    int j;
    if (((AdSizeParcel)localObject).zztf)
    {
      localObject = this.mContext.getResources().getDisplayMetrics();
      j = ((DisplayMetrics)localObject).widthPixels;
    }
    for (int i = ((DisplayMetrics)localObject).heightPixels;; i = ((AdSizeParcel)localObject).heightPixels)
    {
      this.zzDt = new zzgd(this, this.zzoM, j, i);
      this.zzoM.zzhe().zza(this);
      this.zzDt.zza(this.zzDf);
      return;
      j = ((AdSizeParcel)localObject).widthPixels;
    }
  }
  
  protected int zzft()
  {
    if (this.zzDt.zzfx())
    {
      zzb.zzaF("Ad-Network indicated no fill with passback URL.");
      return 3;
    }
    if (!this.zzDt.zzfy()) {
      return 2;
    }
    return -2;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */