package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzcj;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzfi;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzif;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjb;

@zzgr
public abstract class zzc
  extends zzb
  implements zzg, zzfi
{
  public zzc(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzem paramzzem, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzem, paramVersionInfoParcel, paramzzd);
  }
  
  public void recordClick()
  {
    onAdClicked();
  }
  
  public void recordImpression()
  {
    zza(this.zzot.zzqo, false);
  }
  
  protected zziz zza(zzhs.zza paramzza, zze paramzze)
  {
    Object localObject = this.zzot.zzqk.getNextView();
    if ((localObject instanceof zziz))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaF("Reusing webview...");
      localObject = (zziz)localObject;
      ((zziz)localObject).zza(this.zzot.context, this.zzot.zzqn, this.zzoo);
    }
    for (;;)
    {
      ((zziz)localObject).zzhe().zzb(this, this, this, this, false, this, null, paramzze, this);
      ((zziz)localObject).zzaJ(paramzza.zzHC.zzEC);
      return (zziz)localObject;
      if (localObject != null) {
        this.zzot.zzqk.removeView((View)localObject);
      }
      localObject = zzp.zzbw().zza(this.zzot.context, this.zzot.zzqn, false, false, this.zzot.zzqi, this.zzot.zzqj, this.zzoo, this.zzow);
      if (this.zzot.zzqn.zztg == null) {
        zzb(((zziz)localObject).getView());
      }
    }
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    zzaS();
  }
  
  public void zza(zzck paramzzck)
  {
    zzx.zzci("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
    this.zzot.zzqC = paramzzck;
  }
  
  protected void zza(final zzhs.zza paramzza, final zzcg paramzzcg)
  {
    if (paramzza.errorCode != -2)
    {
      zzid.zzIE.post(new Runnable()
      {
        public void run()
        {
          zzc.this.zzb(new zzhs(paramzza, null, null, null, null, null, null));
        }
      });
      return;
    }
    if (paramzza.zzqn != null) {
      this.zzot.zzqn = paramzza.zzqn;
    }
    if (paramzza.zzHD.zzEK)
    {
      this.zzot.zzqH = 0;
      this.zzot.zzqm = zzp.zzbu().zza(this.zzot.context, this, paramzza, this.zzot.zzqi, null, this.zzox, this, paramzzcg);
      return;
    }
    zzid.zzIE.post(new Runnable()
    {
      public void run()
      {
        if ((paramzza.zzHD.zzET) && (zzc.this.zzot.zzqC != null))
        {
          Object localObject = null;
          if (paramzza.zzHD.zzBF != null) {
            localObject = zzp.zzbv().zzaz(paramzza.zzHD.zzBF);
          }
          localObject = new zzch(zzc.this, (String)localObject, paramzza.zzHD.body);
          zzc.this.zzot.zzqH = 1;
          try
          {
            zzc.this.zzot.zzqC.zza((zzcj)localObject);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call the onCustomRenderedAdLoadedListener.", localRemoteException);
          }
        }
        final zze localzze = new zze();
        zziz localzziz = zzc.this.zza(paramzza, localzze);
        localzze.zza(new zze.zzb(paramzza, localzziz));
        localzziz.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
          {
            localzze.recordClick();
            return false;
          }
        });
        localzziz.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            localzze.recordClick();
          }
        });
        zzc.this.zzot.zzqH = 0;
        zzc.this.zzot.zzqm = zzp.zzbu().zza(zzc.this.zzot.context, zzc.this, paramzza, zzc.this.zzot.zzqi, localzziz, zzc.this.zzox, zzc.this, paramzzcg);
      }
    });
  }
  
  protected boolean zza(zzhs paramzzhs1, zzhs paramzzhs2)
  {
    if ((this.zzot.zzbN()) && (this.zzot.zzqk != null)) {
      this.zzot.zzqk.zzbT().zzaC(paramzzhs2.zzEP);
    }
    return super.zza(paramzzhs1, paramzzhs2);
  }
  
  public void zzbc()
  {
    zzaQ();
  }
  
  public void zzc(View paramView)
  {
    this.zzot.zzqG = paramView;
    zzb(new zzhs(this.zzot.zzqp, null, null, null, null, null, null));
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */