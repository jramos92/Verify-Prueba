package com.google.android.gms.internal;

import android.content.Context;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import java.util.List;

@zzgr
public class zzgk
  extends zzgf
{
  protected zzei zzDA;
  private zzec zzDz;
  private final zzcg zzoo;
  private zzem zzox;
  private zzee zzzA;
  
  zzgk(Context paramContext, zzhs.zza paramzza, zzem paramzzem, zzgg.zza paramzza1, zzcg paramzzcg)
  {
    super(paramContext, paramzza, paramzza1);
    this.zzox = paramzzem;
    this.zzzA = paramzza.zzHx;
    this.zzoo = paramzzcg;
  }
  
  public void onStop()
  {
    synchronized (this.zzDh)
    {
      super.onStop();
      if (this.zzDz != null) {
        this.zzDz.cancel();
      }
      return;
    }
  }
  
  protected zzhs zzA(int paramInt)
  {
    Object localObject = this.zzDe.zzHC;
    AdRequestParcel localAdRequestParcel = ((AdRequestInfoParcel)localObject).zzEn;
    List localList1 = this.zzDf.zzyY;
    List localList2 = this.zzDf.zzyZ;
    List localList3 = this.zzDf.zzEM;
    int i = this.zzDf.orientation;
    long l = this.zzDf.zzzc;
    String str2 = ((AdRequestInfoParcel)localObject).zzEq;
    boolean bool = this.zzDf.zzEK;
    zzen localzzen;
    label107:
    String str1;
    label123:
    zzee localzzee;
    if (this.zzDA != null)
    {
      localObject = this.zzDA.zzzu;
      if (this.zzDA == null) {
        break label235;
      }
      localzzen = this.zzDA.zzzv;
      if (this.zzDA == null) {
        break label241;
      }
      str1 = this.zzDA.zzzw;
      localzzee = this.zzzA;
      if (this.zzDA == null) {
        break label251;
      }
    }
    label235:
    label241:
    label251:
    for (zzeg localzzeg = this.zzDA.zzzx;; localzzeg = null)
    {
      return new zzhs(localAdRequestParcel, null, localList1, paramInt, localList2, localList3, i, l, str2, bool, (zzed)localObject, localzzen, str1, localzzee, localzzeg, this.zzDf.zzEL, this.zzDe.zzqn, this.zzDf.zzEJ, this.zzDe.zzHz, this.zzDf.zzEO, this.zzDf.zzEP, this.zzDe.zzHw, null);
      localObject = null;
      break;
      localzzen = null;
      break label107;
      str1 = AdMobAdapter.class.getName();
      break label123;
    }
  }
  
  protected void zzh(long paramLong)
    throws zzgf.zza
  {
    synchronized (this.zzDh)
    {
      this.zzDz = new zzek(this.mContext, this.zzDe.zzHC, this.zzox, this.zzzA, this.zzDf.zzth, paramLong, ((Long)zzby.zzvw.get()).longValue(), this.zzoo);
      this.zzDA = this.zzDz.zzc(this.zzzA.zzyW);
      switch (this.zzDA.zzzt)
      {
      default: 
        throw new zzgf.zza("Unexpected mediation result: " + this.zzDA.zzzt, 0);
      }
    }
    throw new zzgf.zza("No fill from any mediation ad networks.", 3);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzgk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */