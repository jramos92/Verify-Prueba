package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzf;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.events.zzj;
import com.google.android.gms.drive.events.zzl;
import java.util.ArrayList;
import java.util.List;

public class zzae
  extends zzao.zza
{
  private final int zzaho;
  private final zzf zzalt;
  private final zza zzalu;
  private final List<Integer> zzalv = new ArrayList();
  
  public zzae(Looper paramLooper, Context paramContext, int paramInt, zzf paramzzf)
  {
    this.zzaho = paramInt;
    this.zzalt = paramzzf;
    this.zzalu = new zza(paramLooper, paramContext, null);
  }
  
  public void zzc(OnEventResponse paramOnEventResponse)
    throws RemoteException
  {
    paramOnEventResponse = paramOnEventResponse.zzrA();
    if (this.zzaho == paramOnEventResponse.getType()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzZ(bool);
      zzx.zzZ(this.zzalv.contains(Integer.valueOf(paramOnEventResponse.getType())));
      this.zzalu.zza(this.zzalt, paramOnEventResponse);
      return;
    }
  }
  
  public void zzcP(int paramInt)
  {
    this.zzalv.add(Integer.valueOf(paramInt));
  }
  
  public boolean zzcQ(int paramInt)
  {
    return this.zzalv.contains(Integer.valueOf(paramInt));
  }
  
  private static class zza
    extends Handler
  {
    private final Context mContext;
    
    private zza(Looper paramLooper, Context paramContext)
    {
      super();
      this.mContext = paramContext;
    }
    
    private static void zza(zzl paramzzl, QueryResultEventParcelable paramQueryResultEventParcelable)
    {
      DataHolder localDataHolder = paramQueryResultEventParcelable.zzrh();
      if (localDataHolder != null) {
        paramzzl.zza(new zzj() {});
      }
      if (paramQueryResultEventParcelable.zzri()) {
        paramzzl.zzcx(paramQueryResultEventParcelable.zzrj());
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        zzz.zze(this.mContext, "EventCallback", "Don't know how to handle this event");
        return;
      }
      Object localObject = (Pair)paramMessage.obj;
      paramMessage = (zzf)((Pair)localObject).first;
      localObject = (DriveEvent)((Pair)localObject).second;
      switch (((DriveEvent)localObject).getType())
      {
      default: 
        zzz.zzy("EventCallback", "Unexpected event: " + localObject);
        return;
      case 1: 
        ((ChangeListener)paramMessage).onChange((ChangeEvent)localObject);
        return;
      case 2: 
        ((CompletionListener)paramMessage).onCompletion((CompletionEvent)localObject);
        return;
      case 3: 
        zza((zzl)paramMessage, (QueryResultEventParcelable)localObject);
        return;
      case 4: 
        ((zzc)paramMessage).zza((ChangesAvailableEvent)localObject);
        return;
      }
      ((zzi)paramMessage).zza((ProgressEvent)localObject);
    }
    
    public void zza(zzf paramzzf, DriveEvent paramDriveEvent)
    {
      sendMessage(obtainMessage(1, new Pair(paramzzf, paramDriveEvent)));
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\drive\internal\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */