package com.google.android.gms.fitness;

import android.content.Intent;
import android.os.Build.VERSION;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zznm;
import com.google.android.gms.internal.zznm.zzb;
import com.google.android.gms.internal.zznn;
import com.google.android.gms.internal.zznn.zzb;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zzno.zzb;
import com.google.android.gms.internal.zznp;
import com.google.android.gms.internal.zznp.zza;
import com.google.android.gms.internal.zznq;
import com.google.android.gms.internal.zznq.zzb;
import com.google.android.gms.internal.zznr;
import com.google.android.gms.internal.zznr.zzb;
import com.google.android.gms.internal.zzns;
import com.google.android.gms.internal.zzns.zzb;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzon;
import com.google.android.gms.internal.zzoo;
import com.google.android.gms.internal.zzop;
import com.google.android.gms.internal.zzoq;
import com.google.android.gms.internal.zzor;
import com.google.android.gms.internal.zzos;
import com.google.android.gms.internal.zzot;
import com.google.android.gms.internal.zzov;
import java.util.concurrent.TimeUnit;

public class Fitness
{
  public static final String ACTION_TRACK = "vnd.google.fitness.TRACK";
  public static final String ACTION_VIEW = "vnd.google.fitness.VIEW";
  public static final String ACTION_VIEW_GOAL = "vnd.google.fitness.VIEW_GOAL";
  @Deprecated
  public static final Void API;
  public static final Api<Api.ApiOptions.NoOptions> BLE_API;
  public static final BleApi BleApi;
  public static final Api<Api.ApiOptions.NoOptions> CONFIG_API;
  public static final ConfigApi ConfigApi;
  public static final String EXTRA_END_TIME = "vnd.google.fitness.end_time";
  public static final String EXTRA_START_TIME = "vnd.google.fitness.start_time";
  public static final Api<Api.ApiOptions.NoOptions> HISTORY_API;
  public static final HistoryApi HistoryApi;
  public static final Api<Api.ApiOptions.NoOptions> RECORDING_API;
  public static final RecordingApi RecordingApi;
  public static final Scope SCOPE_ACTIVITY_READ;
  public static final Scope SCOPE_ACTIVITY_READ_WRITE;
  public static final Scope SCOPE_BODY_READ = new Scope("https://www.googleapis.com/auth/fitness.body.read");
  public static final Scope SCOPE_BODY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.body.write");
  public static final Scope SCOPE_LOCATION_READ;
  public static final Scope SCOPE_LOCATION_READ_WRITE;
  public static final Scope SCOPE_NUTRITION_READ = new Scope("https://www.googleapis.com/auth/fitness.nutrition.read");
  public static final Scope SCOPE_NUTRITION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.nutrition.write");
  public static final Api<Api.ApiOptions.NoOptions> SENSORS_API;
  public static final Api<Api.ApiOptions.NoOptions> SESSIONS_API;
  public static final SensorsApi SensorsApi;
  public static final SessionsApi SessionsApi;
  public static final Api<Api.ApiOptions.NoOptions> zzaiH;
  public static final Api.zzc<zznm> zzapC = new Api.zzc();
  public static final Api.zzc<zznn> zzapD = new Api.zzc();
  public static final Api.zzc<zzno> zzapE = new Api.zzc();
  public static final Api.zzc<zznp> zzapF = new Api.zzc();
  public static final Api.zzc<zznq> zzapG = new Api.zzc();
  public static final Api.zzc<zznr> zzapH = new Api.zzc();
  public static final Api.zzc<zzns> zzapI = new Api.zzc();
  public static final zzol zzapJ;
  
  static
  {
    API = null;
    SENSORS_API = new Api("Fitness.SENSORS_API", new zznr.zzb(), zzapH);
    SensorsApi = new zzos();
    RECORDING_API = new Api("Fitness.RECORDING_API", new zznq.zzb(), zzapG);
    RecordingApi = new zzor();
    SESSIONS_API = new Api("Fitness.SESSIONS_API", new zzns.zzb(), zzapI);
    SessionsApi = new zzot();
    HISTORY_API = new Api("Fitness.HISTORY_API", new zzno.zzb(), zzapE);
    HistoryApi = new zzop();
    CONFIG_API = new Api("Fitness.CONFIG_API", new zznn.zzb(), zzapD);
    ConfigApi = new zzoo();
    BLE_API = new Api("Fitness.BLE_API", new zznm.zzb(), zzapC);
    BleApi = zzse();
    zzaiH = new Api("Fitness.INTERNAL_API", new zznp.zza(), zzapF);
    zzapJ = new zzoq();
    SCOPE_ACTIVITY_READ = new Scope("https://www.googleapis.com/auth/fitness.activity.read");
    SCOPE_ACTIVITY_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.activity.write");
    SCOPE_LOCATION_READ = new Scope("https://www.googleapis.com/auth/fitness.location.read");
    SCOPE_LOCATION_READ_WRITE = new Scope("https://www.googleapis.com/auth/fitness.location.write");
  }
  
  public static long getEndTime(Intent paramIntent, TimeUnit paramTimeUnit)
  {
    long l = paramIntent.getLongExtra("vnd.google.fitness.end_time", -1L);
    if (l == -1L) {
      return -1L;
    }
    return paramTimeUnit.convert(l, TimeUnit.MILLISECONDS);
  }
  
  public static long getStartTime(Intent paramIntent, TimeUnit paramTimeUnit)
  {
    long l = paramIntent.getLongExtra("vnd.google.fitness.start_time", -1L);
    if (l == -1L) {
      return -1L;
    }
    return paramTimeUnit.convert(l, TimeUnit.MILLISECONDS);
  }
  
  private static BleApi zzse()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new zzon();
    }
    return new zzov();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\fitness\Fitness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */