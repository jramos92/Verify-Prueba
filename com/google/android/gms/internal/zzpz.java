package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class zzpz
  implements PanoramaApi
{
  private static void zza(Context paramContext, Uri paramUri)
  {
    paramContext.revokeUriPermission(paramUri, 1);
  }
  
  private static void zza(Context paramContext, zzpy paramzzpy, final zzpx paramzzpx, final Uri paramUri, Bundle paramBundle)
    throws RemoteException
  {
    paramContext.grantUriPermission("com.google.android.gms", paramUri, 1);
    paramzzpx = new zzpx.zza()
    {
      public void zza(int paramAnonymousInt1, Bundle paramAnonymousBundle, int paramAnonymousInt2, Intent paramAnonymousIntent)
        throws RemoteException
      {
        zzpz.zzb(this.zzry, paramUri);
        paramzzpx.zza(paramAnonymousInt1, paramAnonymousBundle, paramAnonymousInt2, paramAnonymousIntent);
      }
    };
    try
    {
      paramzzpy.zza(paramzzpx, paramUri, paramBundle, true);
      return;
    }
    catch (RemoteException paramzzpy)
    {
      zza(paramContext, paramUri);
      throw paramzzpy;
    }
    catch (RuntimeException paramzzpy)
    {
      zza(paramContext, paramUri);
      throw paramzzpy;
    }
  }
  
  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfo(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.zza(new zza(paramGoogleApiClient)
    {
      protected void zza(Context paramAnonymousContext, zzpy paramAnonymouszzpy)
        throws RemoteException
      {
        paramAnonymouszzpy.zza(new zzpz.zzb(this), paramUri, null, false);
      }
    });
  }
  
  public PendingResult<PanoramaApi.PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.zza(new zza(paramGoogleApiClient)
    {
      protected void zza(Context paramAnonymousContext, zzpy paramAnonymouszzpy)
        throws RemoteException
      {
        zzpz.zzb(paramAnonymousContext, paramAnonymouszzpy, new zzpz.zzb(this), paramUri, null);
      }
    });
  }
  
  private static abstract class zza
    extends zzpz.zzc<PanoramaApi.PanoramaResult>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected PanoramaApi.PanoramaResult zzaV(Status paramStatus)
    {
      return new zzqb(paramStatus, null);
    }
  }
  
  private static final class zzb
    extends zzpx.zza
  {
    private final zzlb.zzb<PanoramaApi.PanoramaResult> zzagy;
    
    public zzb(zzlb.zzb<PanoramaApi.PanoramaResult> paramzzb)
    {
      this.zzagy = paramzzb;
    }
    
    public void zza(int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
    {
      if (paramBundle != null) {}
      for (paramBundle = (PendingIntent)paramBundle.getParcelable("pendingIntent");; paramBundle = null)
      {
        paramBundle = new Status(paramInt1, null, paramBundle);
        this.zzagy.zzp(new zzqb(paramBundle, paramIntent));
        return;
      }
    }
  }
  
  private static abstract class zzc<R extends Result>
    extends zzlb.zza<R, zzqa>
  {
    protected zzc(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected abstract void zza(Context paramContext, zzpy paramzzpy)
      throws RemoteException;
    
    protected final void zza(zzqa paramzzqa)
      throws RemoteException
    {
      zza(paramzzqa.getContext(), (zzpy)paramzzqa.zzpc());
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzpz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */