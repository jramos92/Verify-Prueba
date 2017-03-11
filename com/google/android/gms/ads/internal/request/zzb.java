package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzaj;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzee;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzmn;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzb
  extends zzhz
  implements zzc.zza
{
  private final Context mContext;
  AdResponseParcel zzDf;
  private Runnable zzDg;
  private final Object zzDh = new Object();
  private final zza.zza zzEe;
  private final AdRequestInfoParcel.zza zzEf;
  zzhz zzEg;
  private final zzan zzwL;
  zzee zzzA;
  private AdRequestInfoParcel zzzz;
  
  public zzb(Context paramContext, AdRequestInfoParcel.zza paramzza, zzan paramzzan, zza.zza paramzza1)
  {
    this.zzEe = paramzza1;
    this.mContext = paramContext;
    this.zzEf = paramzza;
    this.zzwL = paramzzan;
  }
  
  private void zzc(int paramInt, String paramString)
  {
    if ((paramInt == 3) || (paramInt == -1))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaG(paramString);
      if (this.zzDf != null) {
        break label84;
      }
    }
    label84:
    for (this.zzDf = new AdResponseParcel(paramInt);; this.zzDf = new AdResponseParcel(paramInt, this.zzDf.zzzc))
    {
      paramString = new zzhs.zza(this.zzzz, this.zzDf, this.zzzA, null, paramInt, -1L, this.zzDf.zzEO, null);
      this.zzEe.zza(paramString);
      return;
      com.google.android.gms.ads.internal.util.client.zzb.zzaH(paramString);
      break;
    }
  }
  
  public void onStop()
  {
    synchronized (this.zzDh)
    {
      if (this.zzEg != null) {
        this.zzEg.cancel();
      }
      return;
    }
  }
  
  zzhz zzb(AdRequestInfoParcel paramAdRequestInfoParcel)
  {
    return zzc.zza(this.mContext, paramAdRequestInfoParcel, this);
  }
  
  public void zzb(AdResponseParcel arg1)
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("Received ad response.");
    this.zzDf = ???;
    long l = zzp.zzbz().elapsedRealtime();
    synchronized (this.zzDh)
    {
      this.zzEg = null;
      try
      {
        if ((this.zzDf.errorCode != -2) && (this.zzDf.errorCode != -3)) {
          throw new zza("There was a problem getting an ad response. ErrorCode: " + this.zzDf.errorCode, this.zzDf.errorCode);
        }
      }
      catch (zza ???)
      {
        zzc(???.getErrorCode(), ???.getMessage());
        zzid.zzIE.removeCallbacks(this.zzDg);
        return;
      }
    }
    zzfG();
    if (this.zzzz.zzqn.zztg != null) {}
    for (??? = zzc(this.zzzz);; ??? = null)
    {
      zzw(this.zzDf.zzEU);
      if (!TextUtils.isEmpty(this.zzDf.zzES)) {}
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(this.zzDf.zzES);
          ??? = new zzhs.zza(this.zzzz, this.zzDf, this.zzzA, ???, -2, l, this.zzDf.zzEO, localJSONObject);
          this.zzEe.zza(???);
          zzid.zzIE.removeCallbacks(this.zzDg);
          return;
        }
        catch (Exception localException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzb("Error parsing the JSON for Active View.", localException);
        }
        Object localObject2 = null;
      }
    }
  }
  
  public void zzbn()
  {
    com.google.android.gms.ads.internal.util.client.zzb.zzaF("AdLoaderBackgroundTask started.");
    ??? = this.zzwL.zzab().zzb(this.mContext);
    this.zzDg = new Runnable()
    {
      public void run()
      {
        synchronized (zzb.zza(zzb.this))
        {
          if (zzb.this.zzEg == null) {
            return;
          }
          zzb.this.onStop();
          zzb.zza(zzb.this, 2, "Timed out waiting for ad response.");
          return;
        }
      }
    };
    zzid.zzIE.postDelayed(this.zzDg, ((Long)zzby.zzvv.get()).longValue());
    long l = zzp.zzbz().elapsedRealtime();
    this.zzzz = new AdRequestInfoParcel(this.zzEf, (String)???, l);
    synchronized (this.zzDh)
    {
      this.zzEg = zzb(this.zzzz);
      if (this.zzEg == null)
      {
        zzc(0, "Could not start the ad request service.");
        zzid.zzIE.removeCallbacks(this.zzDg);
      }
      return;
    }
  }
  
  protected AdSizeParcel zzc(AdRequestInfoParcel paramAdRequestInfoParcel)
    throws zzb.zza
  {
    if (this.zzDf.zzEN == null) {
      throw new zza("The ad response must specify one of the supported ad sizes.", 0);
    }
    Object localObject = this.zzDf.zzEN.split("x");
    if (localObject.length != 2) {
      throw new zza("Invalid ad size format from the ad response: " + this.zzDf.zzEN, 0);
    }
    for (;;)
    {
      int i;
      AdSizeParcel localAdSizeParcel;
      try
      {
        int m = Integer.parseInt(localObject[0]);
        int n = Integer.parseInt(localObject[1]);
        localObject = paramAdRequestInfoParcel.zzqn.zztg;
        int i1 = localObject.length;
        i = 0;
        if (i >= i1) {
          break;
        }
        localAdSizeParcel = localObject[i];
        float f = this.mContext.getResources().getDisplayMetrics().density;
        if (localAdSizeParcel.width == -1)
        {
          j = (int)(localAdSizeParcel.widthPixels / f);
          if (localAdSizeParcel.height != -2) {
            break label257;
          }
          k = (int)(localAdSizeParcel.heightPixels / f);
          if ((m != j) || (n != k)) {
            break label267;
          }
          return new AdSizeParcel(localAdSizeParcel, paramAdRequestInfoParcel.zzqn.zztg);
        }
      }
      catch (NumberFormatException paramAdRequestInfoParcel)
      {
        throw new zza("Invalid ad size number from the ad response: " + this.zzDf.zzEN, 0);
      }
      int j = localAdSizeParcel.width;
      continue;
      label257:
      int k = localAdSizeParcel.height;
      continue;
      label267:
      i += 1;
    }
    throw new zza("The ad size from the ad response was not one of the requested sizes: " + this.zzDf.zzEN, 0);
  }
  
  protected void zzfG()
    throws zzb.zza
  {
    if (this.zzDf.errorCode == -3) {}
    do
    {
      return;
      if (TextUtils.isEmpty(this.zzDf.body)) {
        throw new zza("No fill from ad server.", 3);
      }
      zzp.zzby().zza(this.mContext, this.zzDf.zzEv);
    } while (!this.zzDf.zzEK);
    try
    {
      this.zzzA = new zzee(this.zzDf.body);
      return;
    }
    catch (JSONException localJSONException)
    {
      throw new zza("Could not parse mediation config: " + this.zzDf.body, 0);
    }
  }
  
  protected void zzw(boolean paramBoolean)
  {
    zzp.zzby().zzA(paramBoolean);
    zzbk localzzbk = zzp.zzby().zzE(this.mContext);
    if ((localzzbk != null) && (!localzzbk.isAlive()))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaF("start fetching content...");
      localzzbk.zzct();
    }
  }
  
  @zzgr
  static final class zza
    extends Exception
  {
    private final int zzDv;
    
    public zza(String paramString, int paramInt)
    {
      super();
      this.zzDv = paramInt;
    }
    
    public int getErrorCode()
    {
      return this.zzDv;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\ads\internal\request\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */