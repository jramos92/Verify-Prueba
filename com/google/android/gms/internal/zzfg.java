package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzgr
public class zzfg
  extends zzfh
  implements zzdk
{
  private final Context mContext;
  private final zzbq zzAA;
  DisplayMetrics zzAB;
  private float zzAC;
  int zzAD = -1;
  int zzAE = -1;
  private int zzAF;
  int zzAG = -1;
  int zzAH = -1;
  int zzAI = -1;
  int zzAJ = -1;
  private final zziz zzoM;
  private final WindowManager zzri;
  
  public zzfg(zziz paramzziz, Context paramContext, zzbq paramzzbq)
  {
    super(paramzziz);
    this.zzoM = paramzziz;
    this.mContext = paramContext;
    this.zzAA = paramzzbq;
    this.zzri = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  private void zzei()
  {
    this.zzAB = new DisplayMetrics();
    Display localDisplay = this.zzri.getDefaultDisplay();
    localDisplay.getMetrics(this.zzAB);
    this.zzAC = this.zzAB.density;
    this.zzAF = localDisplay.getRotation();
  }
  
  private void zzen()
  {
    int[] arrayOfInt = new int[2];
    this.zzoM.getLocationOnScreen(arrayOfInt);
    zze(zzl.zzcF().zzc(this.mContext, arrayOfInt[0]), zzl.zzcF().zzc(this.mContext, arrayOfInt[1]));
  }
  
  private zzff zzeq()
  {
    return new zzff.zza().zzp(this.zzAA.zzcW()).zzo(this.zzAA.zzcX()).zzq(this.zzAA.zzdb()).zzr(this.zzAA.zzcY()).zzs(this.zzAA.zzcZ()).zzeh();
  }
  
  public void zza(zziz paramzziz, Map<String, String> paramMap)
  {
    zzel();
  }
  
  public void zze(int paramInt1, int paramInt2)
  {
    if ((this.mContext instanceof Activity)) {}
    for (int i = zzp.zzbv().zzj((Activity)this.mContext)[0];; i = 0)
    {
      zzc(paramInt1, paramInt2 - i, this.zzAI, this.zzAJ);
      this.zzoM.zzhe().zzd(paramInt1, paramInt2);
      return;
    }
  }
  
  void zzej()
  {
    this.zzAD = zzl.zzcF().zzb(this.zzAB, this.zzAB.widthPixels);
    this.zzAE = zzl.zzcF().zzb(this.zzAB, this.zzAB.heightPixels);
    Object localObject = this.zzoM.zzgZ();
    if ((localObject == null) || (((Activity)localObject).getWindow() == null))
    {
      this.zzAG = this.zzAD;
      this.zzAH = this.zzAE;
      return;
    }
    localObject = zzp.zzbv().zzg((Activity)localObject);
    this.zzAG = zzl.zzcF().zzb(this.zzAB, localObject[0]);
    this.zzAH = zzl.zzcF().zzb(this.zzAB, localObject[1]);
  }
  
  void zzek()
  {
    if (this.zzoM.zzaN().zztf)
    {
      this.zzAI = this.zzAD;
      this.zzAJ = this.zzAE;
      return;
    }
    this.zzoM.measure(0, 0);
    this.zzAI = zzl.zzcF().zzc(this.mContext, this.zzoM.getMeasuredWidth());
    this.zzAJ = zzl.zzcF().zzc(this.mContext, this.zzoM.getMeasuredHeight());
  }
  
  public void zzel()
  {
    zzei();
    zzej();
    zzek();
    zzeo();
    zzep();
    zzen();
    zzem();
  }
  
  void zzem()
  {
    if (zzb.zzN(2)) {
      zzb.zzaG("Dispatching Ready Event.");
    }
    zzal(this.zzoM.zzhh().zzJu);
  }
  
  void zzeo()
  {
    zza(this.zzAD, this.zzAE, this.zzAG, this.zzAH, this.zzAC, this.zzAF);
  }
  
  void zzep()
  {
    zzff localzzff = zzeq();
    this.zzoM.zzb("onDeviceFeaturesReceived", localzzff.toJson());
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */