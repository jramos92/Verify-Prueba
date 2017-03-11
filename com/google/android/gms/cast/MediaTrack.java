package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack
{
  public static final int SUBTYPE_CAPTIONS = 2;
  public static final int SUBTYPE_CHAPTERS = 4;
  public static final int SUBTYPE_DESCRIPTIONS = 3;
  public static final int SUBTYPE_METADATA = 5;
  public static final int SUBTYPE_NONE = 0;
  public static final int SUBTYPE_SUBTITLES = 1;
  public static final int SUBTYPE_UNKNOWN = -1;
  public static final int TYPE_AUDIO = 2;
  public static final int TYPE_TEXT = 1;
  public static final int TYPE_UNKNOWN = 0;
  public static final int TYPE_VIDEO = 3;
  private String mName;
  private long zzRr;
  private String zzVT;
  private String zzVV;
  private String zzVX;
  private int zzWJ;
  private int zzWK;
  private JSONObject zzWc;
  
  MediaTrack(long paramLong, int paramInt)
    throws IllegalArgumentException
  {
    clear();
    this.zzRr = paramLong;
    if ((paramInt <= 0) || (paramInt > 3)) {
      throw new IllegalArgumentException("invalid type " + paramInt);
    }
    this.zzWJ = paramInt;
  }
  
  MediaTrack(JSONObject paramJSONObject)
    throws JSONException
  {
    zzf(paramJSONObject);
  }
  
  private void clear()
  {
    this.zzRr = 0L;
    this.zzWJ = 0;
    this.zzVV = null;
    this.mName = null;
    this.zzVT = null;
    this.zzWK = -1;
    this.zzWc = null;
  }
  
  private void zzf(JSONObject paramJSONObject)
    throws JSONException
  {
    clear();
    this.zzRr = paramJSONObject.getLong("trackId");
    String str = paramJSONObject.getString("type");
    if ("TEXT".equals(str))
    {
      this.zzWJ = 1;
      this.zzVV = paramJSONObject.optString("trackContentId", null);
      this.zzVX = paramJSONObject.optString("trackContentType", null);
      this.mName = paramJSONObject.optString("name", null);
      this.zzVT = paramJSONObject.optString("language", null);
      if (!paramJSONObject.has("subtype")) {
        break label276;
      }
      str = paramJSONObject.getString("subtype");
      if (!"SUBTITLES".equals(str)) {
        break label181;
      }
      this.zzWK = 1;
    }
    for (;;)
    {
      this.zzWc = paramJSONObject.optJSONObject("customData");
      return;
      if ("AUDIO".equals(str))
      {
        this.zzWJ = 2;
        break;
      }
      if ("VIDEO".equals(str))
      {
        this.zzWJ = 3;
        break;
      }
      throw new JSONException("invalid type: " + str);
      label181:
      if ("CAPTIONS".equals(str))
      {
        this.zzWK = 2;
      }
      else if ("DESCRIPTIONS".equals(str))
      {
        this.zzWK = 3;
      }
      else if ("CHAPTERS".equals(str))
      {
        this.zzWK = 4;
      }
      else if ("METADATA".equals(str))
      {
        this.zzWK = 5;
      }
      else
      {
        throw new JSONException("invalid subtype: " + str);
        label276:
        this.zzWK = 0;
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    if (this == paramObject) {
      bool1 = true;
    }
    int i;
    int j;
    label51:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool3;
        } while (!(paramObject instanceof MediaTrack));
        paramObject = (MediaTrack)paramObject;
        if (this.zzWc != null) {
          break;
        }
        i = 1;
        if (((MediaTrack)paramObject).zzWc != null) {
          break label194;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.zzWc == null) || (((MediaTrack)paramObject).zzWc == null)) {
        break;
      }
      bool1 = bool3;
    } while (!zzmu.zzd(this.zzWc, ((MediaTrack)paramObject).zzWc));
    if ((this.zzRr == ((MediaTrack)paramObject).zzRr) && (this.zzWJ == ((MediaTrack)paramObject).zzWJ) && (zzf.zza(this.zzVV, ((MediaTrack)paramObject).zzVV)) && (zzf.zza(this.zzVX, ((MediaTrack)paramObject).zzVX)) && (zzf.zza(this.mName, ((MediaTrack)paramObject).mName)) && (zzf.zza(this.zzVT, ((MediaTrack)paramObject).zzVT)) && (this.zzWK == ((MediaTrack)paramObject).zzWK)) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      i = 0;
      break;
      label194:
      j = 0;
      break label51;
    }
  }
  
  public String getContentId()
  {
    return this.zzVV;
  }
  
  public String getContentType()
  {
    return this.zzVX;
  }
  
  public JSONObject getCustomData()
  {
    return this.zzWc;
  }
  
  public long getId()
  {
    return this.zzRr;
  }
  
  public String getLanguage()
  {
    return this.zzVT;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getSubtype()
  {
    return this.zzWK;
  }
  
  public int getType()
  {
    return this.zzWJ;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzRr), Integer.valueOf(this.zzWJ), this.zzVV, this.zzVX, this.mName, this.zzVT, Integer.valueOf(this.zzWK), this.zzWc });
  }
  
  public void setContentId(String paramString)
  {
    this.zzVV = paramString;
  }
  
  public void setContentType(String paramString)
  {
    this.zzVX = paramString;
  }
  
  void setCustomData(JSONObject paramJSONObject)
  {
    this.zzWc = paramJSONObject;
  }
  
  void setLanguage(String paramString)
  {
    this.zzVT = paramString;
  }
  
  void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("trackId", this.zzRr);
      switch (this.zzWJ)
      {
      case 1: 
        if (this.zzVV != null) {
          localJSONObject.put("trackContentId", this.zzVV);
        }
        if (this.zzVX != null) {
          localJSONObject.put("trackContentType", this.zzVX);
        }
        if (this.mName != null) {
          localJSONObject.put("name", this.mName);
        }
        if (!TextUtils.isEmpty(this.zzVT)) {
          localJSONObject.put("language", this.zzVT);
        }
        switch (this.zzWK)
        {
        }
        break;
      }
      for (;;)
      {
        if (this.zzWc == null) {
          break label282;
        }
        localJSONObject.put("customData", this.zzWc);
        return localJSONObject;
        localJSONObject.put("type", "TEXT");
        break;
        localJSONObject.put("type", "AUDIO");
        break;
        localJSONObject.put("type", "VIDEO");
        break;
        localJSONObject.put("subtype", "SUBTITLES");
        continue;
        localJSONObject.put("subtype", "CAPTIONS");
        continue;
        localJSONObject.put("subtype", "DESCRIPTIONS");
        continue;
        localJSONObject.put("subtype", "CHAPTERS");
        continue;
        localJSONObject.put("subtype", "METADATA");
        continue;
        break;
      }
      label282:
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  void zzaV(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt <= -1) || (paramInt > 5)) {
      throw new IllegalArgumentException("invalid subtype " + paramInt);
    }
    if ((paramInt != 0) && (this.zzWJ != 1)) {
      throw new IllegalArgumentException("subtypes are only valid for text tracks");
    }
    this.zzWK = paramInt;
  }
  
  public static class Builder
  {
    private final MediaTrack zzWL;
    
    public Builder(long paramLong, int paramInt)
      throws IllegalArgumentException
    {
      this.zzWL = new MediaTrack(paramLong, paramInt);
    }
    
    public MediaTrack build()
    {
      return this.zzWL;
    }
    
    public Builder setContentId(String paramString)
    {
      this.zzWL.setContentId(paramString);
      return this;
    }
    
    public Builder setContentType(String paramString)
    {
      this.zzWL.setContentType(paramString);
      return this;
    }
    
    public Builder setCustomData(JSONObject paramJSONObject)
    {
      this.zzWL.setCustomData(paramJSONObject);
      return this;
    }
    
    public Builder setLanguage(String paramString)
    {
      this.zzWL.setLanguage(paramString);
      return this;
    }
    
    public Builder setLanguage(Locale paramLocale)
    {
      this.zzWL.setLanguage(zzf.zzb(paramLocale));
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.zzWL.setName(paramString);
      return this;
    }
    
    public Builder setSubtype(int paramInt)
      throws IllegalArgumentException
    {
      this.zzWL.zzaV(paramInt);
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\MediaTrack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */