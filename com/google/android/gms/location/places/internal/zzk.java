package com.google.android.gms.location.places.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.zzl;
import java.util.Locale;

public class zzk
  extends zzj<zzf>
{
  private final PlacesParams zzaHb;
  private final Locale zzaHc = Locale.getDefault();
  
  public zzk(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString1, String paramString2, PlacesOptions paramPlacesOptions)
  {
    super(paramContext, paramLooper, 67, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    paramContext = null;
    if (paramzzf.getAccount() != null) {
      paramContext = paramzzf.getAccount().name;
    }
    this.zzaHb = new PlacesParams(paramString1, this.zzaHc, paramContext, paramPlacesOptions.zzaGG, paramString2);
  }
  
  public void zza(zzl paramzzl, PlaceFilter paramPlaceFilter)
    throws RemoteException
  {
    PlaceFilter localPlaceFilter = paramPlaceFilter;
    if (paramPlaceFilter == null) {
      localPlaceFilter = PlaceFilter.zzwT();
    }
    ((zzf)zzpc()).zza(localPlaceFilter, this.zzaHb, paramzzl);
  }
  
  public void zza(zzl paramzzl, PlaceReport paramPlaceReport)
    throws RemoteException
  {
    zzx.zzw(paramPlaceReport);
    ((zzf)zzpc()).zza(paramPlaceReport, this.zzaHb, paramzzl);
  }
  
  protected zzf zzci(IBinder paramIBinder)
  {
    return zzf.zza.zzce(paramIBinder);
  }
  
  protected String zzfK()
  {
    return "com.google.android.gms.location.places.PlaceDetectionApi";
  }
  
  protected String zzfL()
  {
    return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
  }
  
  public static class zza
    extends Api.zza<zzk, PlacesOptions>
  {
    private final String zzaHd;
    private final String zzaHe;
    
    public zza(String paramString1, String paramString2)
    {
      this.zzaHd = paramString1;
      this.zzaHe = paramString2;
    }
    
    public zzk zzb(Context paramContext, Looper paramLooper, com.google.android.gms.common.internal.zzf paramzzf, PlacesOptions paramPlacesOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      String str1;
      String str2;
      if (this.zzaHd != null)
      {
        str1 = this.zzaHd;
        if (this.zzaHe == null) {
          break label73;
        }
        str2 = this.zzaHe;
        label26:
        if (paramPlacesOptions != null) {
          break label82;
        }
        paramPlacesOptions = new PlacesOptions.Builder().build();
      }
      label73:
      label82:
      for (;;)
      {
        return new zzk(paramContext, paramLooper, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener, str1, str2, paramPlacesOptions);
        str1 = paramContext.getPackageName();
        break;
        str2 = paramContext.getPackageName();
        break label26;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\location\places\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */