package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzaz;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzja.zzb;
import java.util.List;

@zzgr
public class zzf
  extends zzc
{
  private boolean zzoN;
  
  public zzf(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzem, paramVersionInfoParcel, paramzzd);
  }
  
  private AdSizeParcel zzb(zzhs.zza paramzza)
  {
    if (paramzza.zzHD.zzti) {
      return this.zzot.zzqn;
    }
    paramzza = paramzza.zzHD.zzEN;
    if (paramzza != null)
    {
      paramzza = paramzza.split("[xX]");
      paramzza[0] = paramzza[0].trim();
      paramzza[1] = paramzza[1].trim();
    }
    for (paramzza = new AdSize(Integer.parseInt(paramzza[0]), Integer.parseInt(paramzza[1]));; paramzza = this.zzot.zzqn.zzcD()) {
      return new AdSizeParcel(this.zzot.context, paramzza);
    }
  }
  
  private boolean zzb(zzhs paramzzhs1, zzhs paramzzhs2)
  {
    if (paramzzhs2.zzEK) {}
    for (;;)
    {
      try
      {
        paramzzhs2 = paramzzhs2.zzzv.getView();
        if (paramzzhs2 == null)
        {
          zzb.zzaH("View in mediation adapter is null.");
          return false;
        }
        paramzzhs2 = (View)com.google.android.gms.dynamic.zze.zzp(paramzzhs2);
        View localView = this.zzot.zzqk.getNextView();
        if (localView != null)
        {
          if ((localView instanceof zziz)) {
            ((zziz)localView).destroy();
          }
          this.zzot.zzqk.removeView(localView);
        }
        if (paramzzhs2.zzHy == null) {
          continue;
        }
      }
      catch (RemoteException paramzzhs1)
      {
        try
        {
          zzb(paramzzhs2);
          if (this.zzot.zzqk.getChildCount() > 1) {
            this.zzot.zzqk.showNext();
          }
          if (paramzzhs1 != null)
          {
            paramzzhs1 = this.zzot.zzqk.getNextView();
            if (!(paramzzhs1 instanceof zziz)) {
              break label281;
            }
            ((zziz)paramzzhs1).zza(this.zzot.context, this.zzot.zzqn, this.zzoo);
            this.zzot.zzbM();
          }
          this.zzot.zzqk.setVisibility(0);
          return true;
        }
        catch (Throwable paramzzhs1)
        {
          zzb.zzd("Could not add mediation view to view hierarchy.", paramzzhs1);
          return false;
        }
        paramzzhs1 = paramzzhs1;
        zzb.zzd("Could not get View from mediation adapter.", paramzzhs1);
        return false;
      }
      if (paramzzhs2.zzBD != null)
      {
        paramzzhs2.zzBD.zza(paramzzhs2.zzHy);
        this.zzot.zzqk.removeAllViews();
        this.zzot.zzqk.setMinimumWidth(paramzzhs2.zzHy.widthPixels);
        this.zzot.zzqk.setMinimumHeight(paramzzhs2.zzHy.heightPixels);
        zzb(paramzzhs2.zzBD.getView());
        continue;
        label281:
        if (paramzzhs1 != null) {
          this.zzot.zzqk.removeView(paramzzhs1);
        }
      }
    }
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    zzx.zzci("setManualImpressionsEnabled must be called from the main thread.");
    this.zzoN = paramBoolean;
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
  }
  
  protected zziz zza(zzhs.zza paramzza, zze paramzze)
  {
    if (this.zzot.zzqn.zzti) {
      this.zzot.zzqn = zzb(paramzza);
    }
    return super.zza(paramzza, paramzze);
  }
  
  public boolean zza(zzhs paramzzhs1, final zzhs paramzzhs2)
  {
    if (!super.zza(paramzzhs1, paramzzhs2)) {
      return false;
    }
    if ((this.zzot.zzbN()) && (!zzb(paramzzhs1, paramzzhs2)))
    {
      zze(0);
      return false;
    }
    zza(paramzzhs2, false);
    if (this.zzot.zzbN()) {
      if (paramzzhs2.zzBD != null)
      {
        if (paramzzhs2.zzHw != null) {
          this.zzov.zza(this.zzot.zzqn, paramzzhs2);
        }
        if (!paramzzhs2.zzbY()) {
          break label115;
        }
        this.zzov.zza(this.zzot.zzqn, paramzzhs2).zza(paramzzhs2.zzBD);
      }
    }
    for (;;)
    {
      return true;
      label115:
      paramzzhs2.zzBD.zzhe().zza(new zzja.zzb()
      {
        public void zzbf()
        {
          zzf.this.zzov.zza(zzf.this.zzot.zzqn, paramzzhs2).zza(paramzzhs2.zzBD);
        }
      });
      continue;
      if ((this.zzot.zzqG != null) && (paramzzhs2.zzHw != null)) {
        this.zzov.zza(this.zzot.zzqn, paramzzhs2, this.zzot.zzqG);
      }
    }
  }
  
  protected boolean zzaU()
  {
    boolean bool = true;
    if (!zzp.zzbv().zza(this.zzot.context.getPackageManager(), this.zzot.context.getPackageName(), "android.permission.INTERNET"))
    {
      zzl.zzcF().zza(this.zzot.zzqk, this.zzot.zzqn, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      bool = false;
    }
    if (!zzp.zzbv().zzH(this.zzot.context))
    {
      zzl.zzcF().zza(this.zzot.zzqk, this.zzot.zzqn, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      bool = false;
    }
    if ((!bool) && (this.zzot.zzqk != null)) {
      this.zzot.zzqk.setVisibility(0);
    }
    return bool;
  }
  
  public boolean zzb(AdRequestParcel paramAdRequestParcel)
  {
    return super.zzb(zze(paramAdRequestParcel));
  }
  
  AdRequestParcel zze(AdRequestParcel paramAdRequestParcel)
  {
    if (paramAdRequestParcel.zzsG == this.zzoN) {
      return paramAdRequestParcel;
    }
    int i = paramAdRequestParcel.versionCode;
    long l = paramAdRequestParcel.zzsB;
    Bundle localBundle = paramAdRequestParcel.extras;
    int j = paramAdRequestParcel.zzsC;
    List localList = paramAdRequestParcel.zzsD;
    boolean bool2 = paramAdRequestParcel.zzsE;
    int k = paramAdRequestParcel.zzsF;
    if ((paramAdRequestParcel.zzsG) || (this.zzoN)) {}
    for (boolean bool1 = true;; bool1 = false) {
      return new AdRequestParcel(i, l, localBundle, j, localList, bool2, k, bool1, paramAdRequestParcel.zzsH, paramAdRequestParcel.zzsI, paramAdRequestParcel.zzsJ, paramAdRequestParcel.zzsK, paramAdRequestParcel.zzsL, paramAdRequestParcel.zzsM, paramAdRequestParcel.zzsN, paramAdRequestParcel.zzsO, paramAdRequestParcel.zzsP);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */