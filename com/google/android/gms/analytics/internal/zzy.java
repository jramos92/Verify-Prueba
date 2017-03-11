package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlr;

public final class zzy
{
  public static zza<String> zzOA = zza.zzn("analytics.compression_strategy.k", zzo.zzNQ.name());
  public static zza<Integer> zzOB = zza.zze("analytics.max_hits_per_request.k", 20);
  public static zza<Integer> zzOC = zza.zze("analytics.max_hit_length.k", 8192);
  public static zza<Integer> zzOD = zza.zze("analytics.max_post_length.k", 8192);
  public static zza<Integer> zzOE = zza.zze("analytics.max_batch_post_length", 8192);
  public static zza<String> zzOF = zza.zzn("analytics.fallback_responses.k", "404,502");
  public static zza<Integer> zzOG = zza.zze("analytics.batch_retry_interval.seconds.k", 3600);
  public static zza<Long> zzOH = zza.zzc("analytics.service_monitor_interval", 86400000L);
  public static zza<Integer> zzOI = zza.zze("analytics.http_connection.connect_timeout_millis", 60000);
  public static zza<Integer> zzOJ = zza.zze("analytics.http_connection.read_timeout_millis", 61000);
  public static zza<Long> zzOK = zza.zzc("analytics.campaigns.time_limit", 86400000L);
  public static zza<String> zzOL = zza.zzn("analytics.first_party_experiment_id", "");
  public static zza<Integer> zzOM = zza.zze("analytics.first_party_experiment_variant", 0);
  public static zza<Boolean> zzON = zza.zzd("analytics.test.disable_receiver", false);
  public static zza<Long> zzOO = zza.zza("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
  public static zza<Long> zzOP = zza.zzc("analytics.service_client.connect_timeout_millis", 5000L);
  public static zza<Long> zzOQ = zza.zzc("analytics.service_client.second_connect_delay_millis", 5000L);
  public static zza<Long> zzOR = zza.zzc("analytics.service_client.unexpected_reconnect_millis", 60000L);
  public static zza<Long> zzOS = zza.zzc("analytics.service_client.reconnect_throttle_millis", 1800000L);
  public static zza<Long> zzOT = zza.zzc("analytics.monitoring.sample_period_millis", 86400000L);
  public static zza<Long> zzOU = zza.zzc("analytics.initialization_warning_threshold", 5000L);
  public static zza<Boolean> zzOe = zza.zzd("analytics.service_enabled", false);
  public static zza<Boolean> zzOf = zza.zzd("analytics.service_client_enabled", true);
  public static zza<String> zzOg = zza.zzd("analytics.log_tag", "GAv4", "GAv4-SVC");
  public static zza<Long> zzOh = zza.zzc("analytics.max_tokens", 60L);
  public static zza<Float> zzOi = zza.zza("analytics.tokens_per_sec", 0.5F);
  public static zza<Integer> zzOj = zza.zza("analytics.max_stored_hits", 2000, 20000);
  public static zza<Integer> zzOk = zza.zze("analytics.max_stored_hits_per_app", 2000);
  public static zza<Integer> zzOl = zza.zze("analytics.max_stored_properties_per_app", 100);
  public static zza<Long> zzOm = zza.zza("analytics.local_dispatch_millis", 1800000L, 120000L);
  public static zza<Long> zzOn = zza.zza("analytics.initial_local_dispatch_millis", 5000L, 5000L);
  public static zza<Long> zzOo = zza.zzc("analytics.min_local_dispatch_millis", 120000L);
  public static zza<Long> zzOp = zza.zzc("analytics.max_local_dispatch_millis", 7200000L);
  public static zza<Long> zzOq = zza.zzc("analytics.dispatch_alarm_millis", 7200000L);
  public static zza<Long> zzOr = zza.zzc("analytics.max_dispatch_alarm_millis", 32400000L);
  public static zza<Integer> zzOs = zza.zze("analytics.max_hits_per_dispatch", 20);
  public static zza<Integer> zzOt = zza.zze("analytics.max_hits_per_batch", 20);
  public static zza<String> zzOu = zza.zzn("analytics.insecure_host", "http://www.google-analytics.com");
  public static zza<String> zzOv = zza.zzn("analytics.secure_host", "https://ssl.google-analytics.com");
  public static zza<String> zzOw = zza.zzn("analytics.simple_endpoint", "/collect");
  public static zza<String> zzOx = zza.zzn("analytics.batching_endpoint", "/batch");
  public static zza<Integer> zzOy = zza.zze("analytics.max_get_length", 2036);
  public static zza<String> zzOz = zza.zzd("analytics.batching_strategy.k", zzm.zzNJ.name(), zzm.zzNJ.name());
  
  public static final class zza<V>
  {
    private final V zzOV;
    private final zzlr<V> zzOW;
    private V zzOX;
    
    private zza(zzlr<V> paramzzlr, V paramV)
    {
      zzx.zzw(paramzzlr);
      this.zzOW = paramzzlr;
      this.zzOV = paramV;
    }
    
    static zza<Float> zza(String paramString, float paramFloat)
    {
      return zza(paramString, paramFloat, paramFloat);
    }
    
    static zza<Float> zza(String paramString, float paramFloat1, float paramFloat2)
    {
      return new zza(zzlr.zza(paramString, Float.valueOf(paramFloat2)), Float.valueOf(paramFloat1));
    }
    
    static zza<Integer> zza(String paramString, int paramInt1, int paramInt2)
    {
      return new zza(zzlr.zza(paramString, Integer.valueOf(paramInt2)), Integer.valueOf(paramInt1));
    }
    
    static zza<Long> zza(String paramString, long paramLong1, long paramLong2)
    {
      return new zza(zzlr.zza(paramString, Long.valueOf(paramLong2)), Long.valueOf(paramLong1));
    }
    
    static zza<Boolean> zza(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      return new zza(zzlr.zzg(paramString, paramBoolean2), Boolean.valueOf(paramBoolean1));
    }
    
    static zza<Long> zzc(String paramString, long paramLong)
    {
      return zza(paramString, paramLong, paramLong);
    }
    
    static zza<String> zzd(String paramString1, String paramString2, String paramString3)
    {
      return new zza(zzlr.zzu(paramString1, paramString3), paramString2);
    }
    
    static zza<Boolean> zzd(String paramString, boolean paramBoolean)
    {
      return zza(paramString, paramBoolean, paramBoolean);
    }
    
    static zza<Integer> zze(String paramString, int paramInt)
    {
      return zza(paramString, paramInt, paramInt);
    }
    
    static zza<String> zzn(String paramString1, String paramString2)
    {
      return zzd(paramString1, paramString2, paramString2);
    }
    
    public V get()
    {
      if (this.zzOX != null) {
        return (V)this.zzOX;
      }
      if ((zzd.zzaeK) && (zzlr.isInitialized())) {
        return (V)this.zzOW.zzop();
      }
      return (V)this.zzOV;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\analytics\internal\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */