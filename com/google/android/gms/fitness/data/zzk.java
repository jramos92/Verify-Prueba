package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

public class zzk
  extends zzj.zza
{
  private final OnDataPointListener zzaqP;
  
  private zzk(OnDataPointListener paramOnDataPointListener)
  {
    this.zzaqP = ((OnDataPointListener)zzx.zzw(paramOnDataPointListener));
  }
  
  public void zzc(DataPoint paramDataPoint)
    throws RemoteException
  {
    this.zzaqP.onDataPoint(paramDataPoint);
  }
  
  public static class zza
  {
    private static final zza zzaqQ = new zza();
    private final Map<OnDataPointListener, zzk> zzaqR = new HashMap();
    
    public static zza zzsx()
    {
      return zzaqQ;
    }
    
    public zzk zza(OnDataPointListener paramOnDataPointListener)
    {
      synchronized (this.zzaqR)
      {
        zzk localzzk2 = (zzk)this.zzaqR.get(paramOnDataPointListener);
        zzk localzzk1 = localzzk2;
        if (localzzk2 == null)
        {
          localzzk1 = new zzk(paramOnDataPointListener, null);
          this.zzaqR.put(paramOnDataPointListener, localzzk1);
        }
        return localzzk1;
      }
    }
    
    public zzk zzb(OnDataPointListener paramOnDataPointListener)
    {
      synchronized (this.zzaqR)
      {
        paramOnDataPointListener = (zzk)this.zzaqR.get(paramOnDataPointListener);
        return paramOnDataPointListener;
      }
    }
    
    public zzk zzc(OnDataPointListener paramOnDataPointListener)
    {
      synchronized (this.zzaqR)
      {
        zzk localzzk = (zzk)this.zzaqR.remove(paramOnDataPointListener);
        if (localzzk != null) {
          return localzzk;
        }
        paramOnDataPointListener = new zzk(paramOnDataPointListener, null);
        return paramOnDataPointListener;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\data\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */