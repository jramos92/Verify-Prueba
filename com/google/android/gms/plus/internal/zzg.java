package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.plus.PlusOneDummyView;

public final class zzg
  extends com.google.android.gms.dynamic.zzg<zzc>
{
  private static final zzg zzaSw = new zzg();
  
  private zzg()
  {
    super("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl");
  }
  
  public static View zza(Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (paramString == null) {
      try
      {
        throw new NullPointerException();
      }
      catch (Exception paramString)
      {
        return new PlusOneDummyView(paramContext, paramInt1);
      }
    }
    paramString = (View)zze.zzp(((zzc)zzaSw.zzas(paramContext)).zza(zze.zzy(paramContext), paramInt1, paramInt2, paramString, paramInt3));
    return paramString;
  }
  
  protected zzc zzdF(IBinder paramIBinder)
  {
    return zzc.zza.zzdC(paramIBinder);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\plus\internal\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */