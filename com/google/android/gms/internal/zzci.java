package com.google.android.gms.internal;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.doubleclick.CustomRenderedAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;

@zzgr
public class zzci
  implements CustomRenderedAd
{
  private final zzcj zzvZ;
  
  public zzci(zzcj paramzzcj)
  {
    this.zzvZ = paramzzcj;
  }
  
  public String getBaseUrl()
  {
    try
    {
      String str = this.zzvZ.zzdr();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not delegate getBaseURL to CustomRenderedAd", localRemoteException);
    }
    return null;
  }
  
  public String getContent()
  {
    try
    {
      String str = this.zzvZ.getContent();
      return str;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not delegate getContent to CustomRenderedAd", localRemoteException);
    }
    return null;
  }
  
  public void onAdRendered(View paramView)
  {
    try
    {
      zzcj localzzcj = this.zzvZ;
      if (paramView != null) {}
      for (paramView = zze.zzy(paramView);; paramView = null)
      {
        localzzcj.zza(paramView);
        return;
      }
      return;
    }
    catch (RemoteException paramView)
    {
      zzb.zzd("Could not delegate onAdRendered to CustomRenderedAd", paramView);
    }
  }
  
  public void recordClick()
  {
    try
    {
      this.zzvZ.recordClick();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not delegate recordClick to CustomRenderedAd", localRemoteException);
    }
  }
  
  public void recordImpression()
  {
    try
    {
      this.zzvZ.recordImpression();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      zzb.zzd("Could not delegate recordImpression to CustomRenderedAd", localRemoteException);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */