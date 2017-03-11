package com.google.android.gms.fitness;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.concurrent.TimeUnit;

public abstract interface HistoryApi
{
  public abstract PendingResult<Status> deleteData(GoogleApiClient paramGoogleApiClient, DataDeleteRequest paramDataDeleteRequest);
  
  public abstract PendingResult<Status> insertData(GoogleApiClient paramGoogleApiClient, DataSet paramDataSet);
  
  public abstract PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient paramGoogleApiClient, DataType paramDataType);
  
  public abstract PendingResult<DataReadResult> readData(GoogleApiClient paramGoogleApiClient, DataReadRequest paramDataReadRequest);
  
  public static class ViewIntentBuilder
  {
    private final Context mContext;
    private long zzNY;
    private final DataType zzapL;
    private DataSource zzapM;
    private long zzapN;
    private String zzapO;
    
    public ViewIntentBuilder(Context paramContext, DataType paramDataType)
    {
      this.mContext = paramContext;
      this.zzapL = paramDataType;
    }
    
    private Intent zzj(Intent paramIntent)
    {
      if (this.zzapO == null) {}
      Intent localIntent;
      ResolveInfo localResolveInfo;
      do
      {
        return paramIntent;
        localIntent = new Intent(paramIntent).setPackage(this.zzapO);
        localResolveInfo = this.mContext.getPackageManager().resolveActivity(localIntent, 0);
      } while (localResolveInfo == null);
      paramIntent = localResolveInfo.activityInfo.name;
      localIntent.setComponent(new ComponentName(this.zzapO, paramIntent));
      return localIntent;
    }
    
    public Intent build()
    {
      boolean bool2 = true;
      if (this.zzNY > 0L)
      {
        bool1 = true;
        zzx.zza(bool1, "Start time must be set");
        if (this.zzapN <= this.zzNY) {
          break label107;
        }
      }
      label107:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zza(bool1, "End time must be set and after start time");
        Intent localIntent = new Intent("vnd.google.fitness.VIEW");
        localIntent.setType(DataType.getMimeType(this.zzapM.getDataType()));
        localIntent.putExtra("vnd.google.fitness.start_time", this.zzNY);
        localIntent.putExtra("vnd.google.fitness.end_time", this.zzapN);
        zzc.zza(this.zzapM, localIntent, "vnd.google.fitness.data_source");
        return zzj(localIntent);
        bool1 = false;
        break;
      }
    }
    
    public ViewIntentBuilder setDataSource(DataSource paramDataSource)
    {
      zzx.zzb(paramDataSource.getDataType().equals(this.zzapL), "Data source %s is not for the data type %s", new Object[] { paramDataSource, this.zzapL });
      this.zzapM = paramDataSource;
      return this;
    }
    
    public ViewIntentBuilder setPreferredApplication(String paramString)
    {
      this.zzapO = paramString;
      return this;
    }
    
    public ViewIntentBuilder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      this.zzNY = paramTimeUnit.toMillis(paramLong1);
      this.zzapN = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\HistoryApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */