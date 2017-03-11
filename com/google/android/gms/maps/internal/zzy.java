package com.google.android.gms.maps.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public class zzy
{
  private static Context zzaJF;
  private static zzc zzaJG;
  
  private static Context getRemoteContext(Context paramContext)
  {
    if (zzaJF == null) {
      if (!zzxV()) {
        break label23;
      }
    }
    label23:
    for (zzaJF = paramContext.getApplicationContext();; zzaJF = GooglePlayServicesUtil.getRemoteContext(paramContext)) {
      return zzaJF;
    }
  }
  
  private static <T> T zza(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = zzc(((ClassLoader)zzx.zzw(paramClassLoader)).loadClass(paramString));
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      throw new IllegalStateException("Unable to find dynamic class " + paramString);
    }
  }
  
  public static zzc zzaG(Context paramContext)
    throws GooglePlayServicesNotAvailableException
  {
    zzx.zzw(paramContext);
    if (zzaJG != null) {
      return zzaJG;
    }
    zzaH(paramContext);
    zzaJG = zzaI(paramContext);
    try
    {
      zzaJG.zzd(zze.zzy(getRemoteContext(paramContext).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
      return zzaJG;
    }
    catch (RemoteException paramContext)
    {
      throw new RuntimeRemoteException(paramContext);
    }
  }
  
  private static void zzaH(Context paramContext)
    throws GooglePlayServicesNotAvailableException
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext);
    switch (i)
    {
    default: 
      throw new GooglePlayServicesNotAvailableException(i);
    }
  }
  
  private static zzc zzaI(Context paramContext)
  {
    if (zzxV())
    {
      Log.i(zzy.class.getSimpleName(), "Making Creator statically");
      return (zzc)zzc(zzxW());
    }
    Log.i(zzy.class.getSimpleName(), "Making Creator dynamically");
    return zzc.zza.zzcl((IBinder)zza(getRemoteContext(paramContext).getClassLoader(), "com.google.android.gms.maps.internal.CreatorImpl"));
  }
  
  private static <T> T zzc(Class<?> paramClass)
  {
    try
    {
      Object localObject = paramClass.newInstance();
      return (T)localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new IllegalStateException("Unable to instantiate the dynamic class " + paramClass.getName());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new IllegalStateException("Unable to call the default constructor of " + paramClass.getName());
    }
  }
  
  public static boolean zzxV()
  {
    return false;
  }
  
  private static Class<?> zzxW()
  {
    try
    {
      Class localClass = Class.forName("com.google.android.gms.maps.internal.CreatorImpl");
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException(localClassNotFoundException);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\maps\internal\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */