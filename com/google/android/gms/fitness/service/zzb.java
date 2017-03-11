package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzj;
import java.util.Iterator;
import java.util.List;

class zzb
  implements SensorEventDispatcher
{
  private final zzj zzasF;
  
  zzb(zzj paramzzj)
  {
    this.zzasF = ((zzj)zzx.zzw(paramzzj));
  }
  
  public void publish(DataPoint paramDataPoint)
    throws RemoteException
  {
    paramDataPoint.zzsn();
    this.zzasF.zzc(paramDataPoint);
  }
  
  public void publish(List<DataPoint> paramList)
    throws RemoteException
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      publish((DataPoint)paramList.next());
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\service\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */