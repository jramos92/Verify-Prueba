package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public final class zzee
{
  public final List<zzed> zzyW;
  public final long zzyX;
  public final List<String> zzyY;
  public final List<String> zzyZ;
  public final List<String> zzza;
  public final String zzzb;
  public final long zzzc;
  public final String zzzd;
  public final int zzze;
  public int zzzf;
  public int zzzg;
  
  public zzee(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString);
    if (zzb.zzN(2)) {
      zzb.v("Mediation Response JSON: " + paramString.toString(2));
    }
    JSONArray localJSONArray = paramString.getJSONArray("ad_networks");
    ArrayList localArrayList = new ArrayList(localJSONArray.length());
    int j = -1;
    int i = 0;
    while (i < localJSONArray.length())
    {
      zzed localzzed = new zzed(localJSONArray.getJSONObject(i));
      localArrayList.add(localzzed);
      int k = j;
      if (j < 0)
      {
        k = j;
        if (zza(localzzed)) {
          k = i;
        }
      }
      i += 1;
      j = k;
    }
    this.zzzf = j;
    this.zzzg = localJSONArray.length();
    this.zzyW = Collections.unmodifiableList(localArrayList);
    this.zzzb = paramString.getString("qdata");
    paramString = paramString.optJSONObject("settings");
    if (paramString != null)
    {
      this.zzyX = paramString.optLong("ad_network_timeout_millis", -1L);
      this.zzyY = zzp.zzbH().zza(paramString, "click_urls");
      this.zzyZ = zzp.zzbH().zza(paramString, "imp_urls");
      this.zzza = zzp.zzbH().zza(paramString, "nofill_urls");
      long l = paramString.optLong("refresh", -1L);
      if (l > 0L) {}
      for (l *= 1000L;; l = -1L)
      {
        this.zzzc = l;
        paramString = paramString.optJSONArray("rewards");
        if ((paramString != null) && (paramString.length() != 0)) {
          break;
        }
        this.zzzd = null;
        this.zzze = 0;
        return;
      }
      this.zzzd = paramString.getJSONObject(0).optString("rb_type");
      this.zzze = paramString.getJSONObject(0).optInt("rb_amount");
      return;
    }
    this.zzyX = -1L;
    this.zzyY = null;
    this.zzyZ = null;
    this.zzza = null;
    this.zzzc = -1L;
    this.zzzd = null;
    this.zzze = 0;
  }
  
  private boolean zza(zzed paramzzed)
  {
    paramzzed = paramzzed.zzyO.iterator();
    while (paramzzed.hasNext()) {
      if (((String)paramzzed.next()).equals("com.google.ads.mediation.admob.AdMobAdapter")) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */