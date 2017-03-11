package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.zzrs;
import com.google.android.gms.internal.zzrs.zza;
import com.google.android.gms.internal.zzse;
import java.util.List;

public class PutDataMapRequest
{
  private final DataMap zzbfb;
  private final PutDataRequest zzbfc;
  
  private PutDataMapRequest(PutDataRequest paramPutDataRequest, DataMap paramDataMap)
  {
    this.zzbfc = paramPutDataRequest;
    this.zzbfb = new DataMap();
    if (paramDataMap != null) {
      this.zzbfb.putAll(paramDataMap);
    }
  }
  
  public static PutDataMapRequest create(String paramString)
  {
    return new PutDataMapRequest(PutDataRequest.create(paramString), null);
  }
  
  public static PutDataMapRequest createFromDataMapItem(DataMapItem paramDataMapItem)
  {
    return new PutDataMapRequest(PutDataRequest.zzo(paramDataMapItem.getUri()), paramDataMapItem.getDataMap());
  }
  
  public static PutDataMapRequest createWithAutoAppendedId(String paramString)
  {
    return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(paramString), null);
  }
  
  public PutDataRequest asPutDataRequest()
  {
    zzrs.zza localzza = zzrs.zza(this.zzbfb);
    this.zzbfc.setData(zzse.zzf(localzza.zzbhz));
    int j = localzza.zzbhA.size();
    int i = 0;
    while (i < j)
    {
      String str = Integer.toString(i);
      Asset localAsset = (Asset)localzza.zzbhA.get(i);
      if (str == null) {
        throw new IllegalStateException("asset key cannot be null: " + localAsset);
      }
      if (localAsset == null) {
        throw new IllegalStateException("asset cannot be null: key=" + str);
      }
      if (Log.isLoggable("DataMap", 3)) {
        Log.d("DataMap", "asPutDataRequest: adding asset: " + str + " " + localAsset);
      }
      this.zzbfc.putAsset(str, localAsset);
      i += 1;
    }
    return this.zzbfc;
  }
  
  public DataMap getDataMap()
  {
    return this.zzbfb;
  }
  
  public Uri getUri()
  {
    return this.zzbfc.getUri();
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\PutDataMapRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */