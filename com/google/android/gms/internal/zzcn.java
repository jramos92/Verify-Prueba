package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd.Image;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;

@zzgr
public class zzcn
  extends NativeAd.Image
{
  private final Drawable mDrawable;
  private final Uri mUri;
  private final double zzwn;
  private final zzcm zzxc;
  
  public zzcn(zzcm paramzzcm)
  {
    this.zzxc = paramzzcm;
    try
    {
      paramzzcm = this.zzxc.zzdv();
      if (paramzzcm == null) {
        break label83;
      }
      paramzzcm = (Drawable)zze.zzp(paramzzcm);
    }
    catch (RemoteException paramzzcm)
    {
      try
      {
        paramzzcm = this.zzxc.getUri();
        this.mUri = paramzzcm;
        double d1 = 1.0D;
        try
        {
          double d2 = this.zzxc.getScale();
          d1 = d2;
        }
        catch (RemoteException paramzzcm)
        {
          for (;;)
          {
            zzb.zzb("Failed to get scale.", paramzzcm);
          }
        }
        this.zzwn = d1;
        return;
        paramzzcm = paramzzcm;
        zzb.zzb("Failed to get drawable.", paramzzcm);
        paramzzcm = null;
      }
      catch (RemoteException paramzzcm)
      {
        for (;;)
        {
          zzb.zzb("Failed to get uri.", paramzzcm);
          paramzzcm = (zzcm)localObject;
        }
      }
    }
    this.mDrawable = paramzzcm;
  }
  
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
  
  public double getScale()
  {
    return this.zzwn;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzcn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */