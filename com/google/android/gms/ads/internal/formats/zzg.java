package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzeq;
import com.google.android.gms.internal.zzer;
import com.google.android.gms.internal.zziz;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public class zzg
  extends zzh
{
  private Object zzpd = new Object();
  private zzeq zzwD;
  private zzer zzwE;
  private final zzn zzwF;
  private zzh zzwG;
  private boolean zzwH = false;
  
  private zzg(Context paramContext, zzn paramzzn, zzan paramzzan)
  {
    super(paramContext, paramzzn, null, paramzzan, null, null, null);
    this.zzwF = paramzzn;
  }
  
  public zzg(Context paramContext, zzn paramzzn, zzan paramzzan, zzeq paramzzeq)
  {
    this(paramContext, paramzzn, paramzzan);
    this.zzwD = paramzzeq;
  }
  
  public zzg(Context paramContext, zzn paramzzn, zzan paramzzan, zzer paramzzer)
  {
    this(paramContext, paramzzn, paramzzan);
    this.zzwE = paramzzer;
  }
  
  public void recordImpression()
  {
    zzx.zzci("recordImpression must be called on the main UI thread.");
    for (;;)
    {
      synchronized (this.zzpd)
      {
        zzl(true);
        if (this.zzwG != null)
        {
          this.zzwG.recordImpression();
          this.zzwF.recordImpression();
          return;
        }
        try
        {
          if ((this.zzwD != null) && (!this.zzwD.getOverrideClickHandling())) {
            this.zzwD.recordImpression();
          }
        }
        catch (RemoteException localRemoteException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call recordImpression", localRemoteException);
        }
      }
      if ((this.zzwE != null) && (!this.zzwE.getOverrideClickHandling())) {
        this.zzwE.recordImpression();
      }
    }
  }
  
  public zzb zza(View.OnClickListener paramOnClickListener)
  {
    return null;
  }
  
  public void zza(View paramView, Map<String, WeakReference<View>> paramMap, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    zzx.zzci("performClick must be called on the main UI thread.");
    synchronized (this.zzpd)
    {
      if (this.zzwG != null) {
        this.zzwG.zza(paramView, paramMap, paramJSONObject1, paramJSONObject2);
      }
      for (;;)
      {
        this.zzwF.onAdClicked();
        return;
        try
        {
          if ((this.zzwD != null) && (!this.zzwD.getOverrideClickHandling())) {
            this.zzwD.zzc(zze.zzy(paramView));
          }
          if ((this.zzwE == null) || (this.zzwE.getOverrideClickHandling())) {
            continue;
          }
          this.zzwD.zzc(zze.zzy(paramView));
        }
        catch (RemoteException paramView)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call performClick", paramView);
        }
      }
    }
  }
  
  public void zzb(zzh paramzzh)
  {
    synchronized (this.zzpd)
    {
      this.zzwG = paramzzh;
      return;
    }
  }
  
  public boolean zzdB()
  {
    synchronized (this.zzpd)
    {
      boolean bool = this.zzwH;
      return bool;
    }
  }
  
  public zziz zzdC()
  {
    return null;
  }
  
  public void zzh(View paramView)
  {
    synchronized (this.zzpd)
    {
      this.zzwH = true;
      try
      {
        if (this.zzwD != null) {
          this.zzwD.zzd(zze.zzy(paramView));
        }
        for (;;)
        {
          this.zzwH = false;
          return;
          if (this.zzwE != null) {
            this.zzwE.zzd(zze.zzy(paramView));
          }
        }
      }
      catch (RemoteException paramView)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call prepareAd", paramView);
        }
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\formats\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */