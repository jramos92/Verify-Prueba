package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;

class zzf
  extends zzg<zzd>
{
  private static zzf zzbcb;
  
  zzf()
  {
    super("com.google.android.gms.vision.client.DynamiteNativeFaceDetectorCreator");
  }
  
  static zzc zza(Context paramContext, FaceSettingsParcel paramFaceSettingsParcel)
  {
    if (zzbcb == null) {
      zzbcb = new zzf();
    }
    return zzbcb.zzb(paramContext, paramFaceSettingsParcel);
  }
  
  private zzc zzb(Context paramContext, FaceSettingsParcel paramFaceSettingsParcel)
  {
    try
    {
      com.google.android.gms.dynamic.zzd localzzd = zze.zzy(paramContext);
      paramContext = ((zzd)zzas(paramContext)).zza(localzzd, paramFaceSettingsParcel);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("FaceDetectorHandle", "Could not create native face detector", paramContext);
    }
    return null;
  }
  
  protected zzd zzdU(IBinder paramIBinder)
  {
    return zzd.zza.zzdT(paramIBinder);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\vision\face\internal\client\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */