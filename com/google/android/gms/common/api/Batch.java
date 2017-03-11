package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzlc;
import java.util.ArrayList;
import java.util.List;

public final class Batch
  extends zzlc<BatchResult>
{
  private boolean zzaaA;
  private final PendingResult<?>[] zzaaB;
  private int zzaay;
  private boolean zzaaz;
  private final Object zzpd = new Object();
  
  private Batch(List<PendingResult<?>> paramList, GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
    this.zzaay = paramList.size();
    this.zzaaB = new PendingResult[this.zzaay];
    int i = 0;
    while (i < paramList.size())
    {
      paramGoogleApiClient = (PendingResult)paramList.get(i);
      this.zzaaB[i] = paramGoogleApiClient;
      paramGoogleApiClient.zza(new PendingResult.zza()
      {
        public void zzt(Status paramAnonymousStatus)
        {
          for (;;)
          {
            synchronized (Batch.zza(Batch.this))
            {
              if (Batch.this.isCanceled()) {
                return;
              }
              if (paramAnonymousStatus.isCanceled())
              {
                Batch.zza(Batch.this, true);
                Batch.zzb(Batch.this);
                if (Batch.zzc(Batch.this) == 0)
                {
                  if (!Batch.zzd(Batch.this)) {
                    break;
                  }
                  Batch.zze(Batch.this);
                }
                return;
              }
            }
            if (!paramAnonymousStatus.isSuccess()) {
              Batch.zzb(Batch.this, true);
            }
          }
          if (Batch.zzf(Batch.this)) {}
          for (paramAnonymousStatus = new Status(13);; paramAnonymousStatus = Status.zzabb)
          {
            Batch.this.zzb(new BatchResult(paramAnonymousStatus, Batch.zzg(Batch.this)));
            break;
          }
        }
      });
      i += 1;
    }
  }
  
  public void cancel()
  {
    super.cancel();
    PendingResult[] arrayOfPendingResult = this.zzaaB;
    int j = arrayOfPendingResult.length;
    int i = 0;
    while (i < j)
    {
      arrayOfPendingResult[i].cancel();
      i += 1;
    }
  }
  
  public BatchResult createFailedResult(Status paramStatus)
  {
    return new BatchResult(paramStatus, this.zzaaB);
  }
  
  public static final class Builder
  {
    private GoogleApiClient zzVs;
    private List<PendingResult<?>> zzaaD = new ArrayList();
    
    public Builder(GoogleApiClient paramGoogleApiClient)
    {
      this.zzVs = paramGoogleApiClient;
    }
    
    public <R extends Result> BatchResultToken<R> add(PendingResult<R> paramPendingResult)
    {
      BatchResultToken localBatchResultToken = new BatchResultToken(this.zzaaD.size());
      this.zzaaD.add(paramPendingResult);
      return localBatchResultToken;
    }
    
    public Batch build()
    {
      return new Batch(this.zzaaD, this.zzVs, null);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\common\api\Batch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */