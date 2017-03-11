package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.List;

public class zzop
  implements HistoryApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, final DataSet paramDataSet, final boolean paramBoolean)
  {
    zzx.zzb(paramDataSet, "Must set the data set");
    if (!paramDataSet.getDataPoints().isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Cannot use an empty data set");
      zzx.zzb(paramDataSet.getDataSource().zzsr(), "Must set the app package name for the data source");
      paramGoogleApiClient.zza(new zzno.zzc(paramGoogleApiClient)
      {
        protected void zza(zzno paramAnonymouszzno)
          throws RemoteException
        {
          zzou localzzou = new zzou(this);
          ((zznz)paramAnonymouszzno.zzpc()).zza(new DataInsertRequest(paramDataSet, localzzou, paramBoolean));
        }
      });
    }
  }
  
  public PendingResult<Status> deleteData(GoogleApiClient paramGoogleApiClient, final DataDeleteRequest paramDataDeleteRequest)
  {
    paramGoogleApiClient.zza(new zzno.zzc(paramGoogleApiClient)
    {
      protected void zza(zzno paramAnonymouszzno)
        throws RemoteException
      {
        zzou localzzou = new zzou(this);
        ((zznz)paramAnonymouszzno.zzpc()).zza(new DataDeleteRequest(paramDataDeleteRequest, localzzou));
      }
    });
  }
  
  public PendingResult<Status> insertData(GoogleApiClient paramGoogleApiClient, DataSet paramDataSet)
  {
    return zza(paramGoogleApiClient, paramDataSet, false);
  }
  
  public PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient paramGoogleApiClient, final DataType paramDataType)
  {
    paramGoogleApiClient.zza(new zzno.zza(paramGoogleApiClient)
    {
      protected DailyTotalResult zzK(Status paramAnonymousStatus)
      {
        return DailyTotalResult.zza(paramAnonymousStatus, paramDataType);
      }
      
      protected void zza(zzno paramAnonymouszzno)
        throws RemoteException
      {
        DailyTotalRequest localDailyTotalRequest = new DailyTotalRequest(new zznt.zza()
        {
          public void zza(DailyTotalResult paramAnonymous2DailyTotalResult)
            throws RemoteException
          {
            zzop.4.this.zzb(paramAnonymous2DailyTotalResult);
          }
        }, paramDataType);
        ((zznz)paramAnonymouszzno.zzpc()).zza(localDailyTotalRequest);
      }
    });
  }
  
  public PendingResult<DataReadResult> readData(GoogleApiClient paramGoogleApiClient, final DataReadRequest paramDataReadRequest)
  {
    paramGoogleApiClient.zza(new zzno.zza(paramGoogleApiClient)
    {
      protected DataReadResult zzJ(Status paramAnonymousStatus)
      {
        return DataReadResult.zza(paramAnonymousStatus, paramDataReadRequest);
      }
      
      protected void zza(zzno paramAnonymouszzno)
        throws RemoteException
      {
        zzop.zza localzza = new zzop.zza(this, null);
        ((zznz)paramAnonymouszzno.zzpc()).zza(new DataReadRequest(paramDataReadRequest, localzza));
      }
    });
  }
  
  private static class zza
    extends zznu.zza
  {
    private final zzlb.zzb<DataReadResult> zzagy;
    private int zzarA = 0;
    private DataReadResult zzarB = null;
    
    private zza(zzlb.zzb<DataReadResult> paramzzb)
    {
      this.zzagy = paramzzb;
    }
    
    /* Error */
    public void zza(DataReadResult paramDataReadResult)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 34
      //   4: ldc 36
      //   6: invokestatic 42	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
      //   9: pop
      //   10: aload_0
      //   11: getfield 23	com/google/android/gms/internal/zzop$zza:zzarB	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   14: ifnonnull +48 -> 62
      //   17: aload_0
      //   18: aload_1
      //   19: putfield 23	com/google/android/gms/internal/zzop$zza:zzarB	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   22: aload_0
      //   23: aload_0
      //   24: getfield 21	com/google/android/gms/internal/zzop$zza:zzarA	I
      //   27: iconst_1
      //   28: iadd
      //   29: putfield 21	com/google/android/gms/internal/zzop$zza:zzarA	I
      //   32: aload_0
      //   33: getfield 21	com/google/android/gms/internal/zzop$zza:zzarA	I
      //   36: aload_0
      //   37: getfield 23	com/google/android/gms/internal/zzop$zza:zzarB	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   40: invokevirtual 48	com/google/android/gms/fitness/result/DataReadResult:zztn	()I
      //   43: if_icmpne +16 -> 59
      //   46: aload_0
      //   47: getfield 25	com/google/android/gms/internal/zzop$zza:zzagy	Lcom/google/android/gms/internal/zzlb$zzb;
      //   50: aload_0
      //   51: getfield 23	com/google/android/gms/internal/zzop$zza:zzarB	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   54: invokeinterface 54 2 0
      //   59: aload_0
      //   60: monitorexit
      //   61: return
      //   62: aload_0
      //   63: getfield 23	com/google/android/gms/internal/zzop$zza:zzarB	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   66: aload_1
      //   67: invokevirtual 57	com/google/android/gms/fitness/result/DataReadResult:zzb	(Lcom/google/android/gms/fitness/result/DataReadResult;)V
      //   70: goto -48 -> 22
      //   73: astore_1
      //   74: aload_0
      //   75: monitorexit
      //   76: aload_1
      //   77: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	zza
      //   0	78	1	paramDataReadResult	DataReadResult
      // Exception table:
      //   from	to	target	type
      //   2	22	73	finally
      //   22	59	73	finally
      //   59	61	73	finally
      //   62	70	73	finally
      //   74	76	73	finally
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */