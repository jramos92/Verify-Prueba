package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlr;

public final class zzk
{
  public static zza<Integer> zzaMA = zza.zzA("measurement.upload.retry_count", 6);
  public static zza<Long> zzaMB = zza.zzf("measurement.upload.retry_time", 2419200000L);
  public static zza<Long> zzaMC = zza.zzf("measurement.service_client.idle_disconnect_millis", 5000L);
  public static zza<Boolean> zzaMn = zza.zzi("measurement.service_enabled", false);
  public static zza<Boolean> zzaMo = zza.zzi("measurement.service_client_enabled", true);
  public static zza<String> zzaMp = zza.zzj("measurement.log_tag", "GMPM", "GMPM-SVC");
  public static zza<Long> zzaMq = zza.zzf("measurement.ad_id_cache_time", 10000L);
  public static zza<Long> zzaMr = zza.zzf("measurement.monitoring.sample_period_millis", 86400000L);
  public static zza<Integer> zzaMs = zza.zzA("measurement.upload.max_bundles", 100);
  public static zza<Integer> zzaMt = zza.zzA("measurement.upload.max_batch_size", 65536);
  public static zza<String> zzaMu = zza.zzJ("measurement.upload.url", "https://app-measurement.com/a");
  public static zza<Long> zzaMv = zza.zzf("measurement.upload.backoff_period", 43200000L);
  public static zza<Long> zzaMw = zza.zzf("measurement.upload.interval", 3600000L);
  public static zza<Long> zzaMx = zza.zzf("measurement.upload.stale_data_deletion_interval", 86400000L);
  public static zza<Long> zzaMy = zza.zzf("measurement.upload.initial_upload_delay_time", 15000L);
  public static zza<Long> zzaMz = zza.zzf("measurement.upload.retry_time", 1800000L);
  
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
    
    static zza<Integer> zzA(String paramString, int paramInt)
    {
      return zzo(paramString, paramInt, paramInt);
    }
    
    static zza<String> zzJ(String paramString1, String paramString2)
    {
      return zzj(paramString1, paramString2, paramString2);
    }
    
    static zza<Long> zzb(String paramString, long paramLong1, long paramLong2)
    {
      return new zza(zzlr.zza(paramString, Long.valueOf(paramLong2)), Long.valueOf(paramLong1));
    }
    
    static zza<Boolean> zzb(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      return new zza(zzlr.zzg(paramString, paramBoolean2), Boolean.valueOf(paramBoolean1));
    }
    
    static zza<Long> zzf(String paramString, long paramLong)
    {
      return zzb(paramString, paramLong, paramLong);
    }
    
    static zza<Boolean> zzi(String paramString, boolean paramBoolean)
    {
      return zzb(paramString, paramBoolean, paramBoolean);
    }
    
    static zza<String> zzj(String paramString1, String paramString2, String paramString3)
    {
      return new zza(zzlr.zzu(paramString1, paramString3), paramString2);
    }
    
    static zza<Integer> zzo(String paramString, int paramInt1, int paramInt2)
    {
      return new zza(zzlr.zza(paramString, Integer.valueOf(paramInt2)), Integer.valueOf(paramInt1));
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


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\measurement\internal\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */