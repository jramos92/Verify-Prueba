package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public final class zzed
{
  public final String zzyM;
  public final String zzyN;
  public final List<String> zzyO;
  public final String zzyP;
  public final String zzyQ;
  public final List<String> zzyR;
  public final List<String> zzyS;
  public final String zzyT;
  public final List<String> zzyU;
  public final List<String> zzyV;
  
  public zzed(JSONObject paramJSONObject)
    throws JSONException
  {
    this.zzyN = paramJSONObject.getString("id");
    Object localObject1 = paramJSONObject.getJSONArray("adapters");
    ArrayList localArrayList = new ArrayList(((JSONArray)localObject1).length());
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      localArrayList.add(((JSONArray)localObject1).getString(i));
      i += 1;
    }
    this.zzyO = Collections.unmodifiableList(localArrayList);
    this.zzyP = paramJSONObject.optString("allocation_id", null);
    this.zzyR = zzp.zzbH().zza(paramJSONObject, "clickurl");
    this.zzyS = zzp.zzbH().zza(paramJSONObject, "imp_urls");
    this.zzyU = zzp.zzbH().zza(paramJSONObject, "video_start_urls");
    this.zzyV = zzp.zzbH().zza(paramJSONObject, "video_complete_urls");
    localObject1 = paramJSONObject.optJSONObject("ad");
    if (localObject1 != null)
    {
      localObject1 = ((JSONObject)localObject1).toString();
      this.zzyM = ((String)localObject1);
      localObject1 = paramJSONObject.optJSONObject("data");
      if (localObject1 == null) {
        break label206;
      }
    }
    label206:
    for (paramJSONObject = ((JSONObject)localObject1).toString();; paramJSONObject = null)
    {
      this.zzyT = paramJSONObject;
      paramJSONObject = (JSONObject)localObject2;
      if (localObject1 != null) {
        paramJSONObject = ((JSONObject)localObject1).optString("class_name");
      }
      this.zzyQ = paramJSONObject;
      return;
      localObject1 = null;
      break;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\internal\zzed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */