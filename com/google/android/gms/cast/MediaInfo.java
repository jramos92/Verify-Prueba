package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo
{
  public static final int STREAM_TYPE_BUFFERED = 1;
  public static final int STREAM_TYPE_INVALID = -1;
  public static final int STREAM_TYPE_LIVE = 2;
  public static final int STREAM_TYPE_NONE = 0;
  public static final long UNKNOWN_DURATION = -1L;
  private final String zzVV;
  private int zzVW;
  private String zzVX;
  private MediaMetadata zzVY;
  private long zzVZ;
  private List<MediaTrack> zzWa;
  private TextTrackStyle zzWb;
  private JSONObject zzWc;
  
  MediaInfo(String paramString)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("content ID cannot be null or empty");
    }
    this.zzVV = paramString;
    this.zzVW = -1;
    this.zzVZ = -1L;
  }
  
  MediaInfo(JSONObject paramJSONObject)
    throws JSONException
  {
    this.zzVV = paramJSONObject.getString("contentId");
    Object localObject1 = paramJSONObject.getString("streamType");
    if ("NONE".equals(localObject1)) {
      this.zzVW = 0;
    }
    Object localObject2;
    for (;;)
    {
      this.zzVX = paramJSONObject.getString("contentType");
      if (paramJSONObject.has("metadata"))
      {
        localObject1 = paramJSONObject.getJSONObject("metadata");
        this.zzVY = new MediaMetadata(((JSONObject)localObject1).getInt("metadataType"));
        this.zzVY.zzf((JSONObject)localObject1);
      }
      this.zzVZ = -1L;
      if ((paramJSONObject.has("duration")) && (!paramJSONObject.isNull("duration")))
      {
        double d = paramJSONObject.optDouble("duration", 0.0D);
        if ((!Double.isNaN(d)) && (!Double.isInfinite(d))) {
          this.zzVZ = zzf.zzg(d);
        }
      }
      if (!paramJSONObject.has("tracks")) {
        break;
      }
      this.zzWa = new ArrayList();
      localObject1 = paramJSONObject.getJSONArray("tracks");
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = new MediaTrack(((JSONArray)localObject1).getJSONObject(i));
        this.zzWa.add(localObject2);
        i += 1;
      }
      if ("BUFFERED".equals(localObject1)) {
        this.zzVW = 1;
      } else if ("LIVE".equals(localObject1)) {
        this.zzVW = 2;
      } else {
        this.zzVW = -1;
      }
    }
    this.zzWa = null;
    if (paramJSONObject.has("textTrackStyle"))
    {
      localObject1 = paramJSONObject.getJSONObject("textTrackStyle");
      localObject2 = new TextTrackStyle();
      ((TextTrackStyle)localObject2).zzf((JSONObject)localObject1);
    }
    for (this.zzWb = ((TextTrackStyle)localObject2);; this.zzWb = null)
    {
      this.zzWc = paramJSONObject.optJSONObject("customData");
      return;
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
        } while (!(paramObject instanceof MediaInfo));
        paramObject = (MediaInfo)paramObject;
        if (this.zzWc != null) {
          break;
        }
        i = 1;
        if (((MediaInfo)paramObject).zzWc != null) {
          break label169;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.zzWc == null) || (((MediaInfo)paramObject).zzWc == null)) {
        break;
      }
      bool1 = bool3;
    } while (!zzmu.zzd(this.zzWc, ((MediaInfo)paramObject).zzWc));
    if ((zzf.zza(this.zzVV, ((MediaInfo)paramObject).zzVV)) && (this.zzVW == ((MediaInfo)paramObject).zzVW) && (zzf.zza(this.zzVX, ((MediaInfo)paramObject).zzVX)) && (zzf.zza(this.zzVY, ((MediaInfo)paramObject).zzVY)) && (this.zzVZ == ((MediaInfo)paramObject).zzVZ)) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      i = 0;
      break;
      label169:
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
  
  public List<MediaTrack> getMediaTracks()
  {
    return this.zzWa;
  }
  
  public MediaMetadata getMetadata()
  {
    return this.zzVY;
  }
  
  public long getStreamDuration()
  {
    return this.zzVZ;
  }
  
  public int getStreamType()
  {
    return this.zzVW;
  }
  
  public TextTrackStyle getTextTrackStyle()
  {
    return this.zzWb;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzVV, Integer.valueOf(this.zzVW), this.zzVX, this.zzVY, Long.valueOf(this.zzVZ), String.valueOf(this.zzWc) });
  }
  
  void setContentType(String paramString)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    this.zzVX = paramString;
  }
  
  void setCustomData(JSONObject paramJSONObject)
  {
    this.zzWc = paramJSONObject;
  }
  
  void setStreamType(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt < -1) || (paramInt > 2)) {
      throw new IllegalArgumentException("invalid stream type");
    }
    this.zzVW = paramInt;
  }
  
  public void setTextTrackStyle(TextTrackStyle paramTextTrackStyle)
  {
    this.zzWb = paramTextTrackStyle;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("contentId", this.zzVV);
        switch (this.zzVW)
        {
        default: 
          localJSONObject.put("streamType", localObject);
          if (this.zzVX != null) {
            localJSONObject.put("contentType", this.zzVX);
          }
          if (this.zzVY != null) {
            localJSONObject.put("metadata", this.zzVY.toJson());
          }
          if (this.zzVZ <= -1L)
          {
            localJSONObject.put("duration", JSONObject.NULL);
            if (this.zzWa == null) {
              continue;
            }
            localObject = new JSONArray();
            Iterator localIterator = this.zzWa.iterator();
            if (localIterator.hasNext())
            {
              ((JSONArray)localObject).put(((MediaTrack)localIterator.next()).toJson());
              continue;
            }
          }
          else
          {
            localJSONObject.put("duration", zzf.zzA(this.zzVZ));
            continue;
          }
          localJSONObject.put("tracks", localObject);
          if (this.zzWb != null) {
            localJSONObject.put("textTrackStyle", this.zzWb.toJson());
          }
          if (this.zzWc == null) {
            break label239;
          }
          localJSONObject.put("customData", this.zzWc);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException) {}
      Object localObject = "NONE";
      continue;
      label239:
      return localJSONObject;
      String str = "BUFFERED";
      continue;
      str = "LIVE";
    }
  }
  
  void zza(MediaMetadata paramMediaMetadata)
  {
    this.zzVY = paramMediaMetadata;
  }
  
  void zzmx()
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(this.zzVV)) {
      throw new IllegalArgumentException("content ID cannot be null or empty");
    }
    if (TextUtils.isEmpty(this.zzVX)) {
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    if (this.zzVW == -1) {
      throw new IllegalArgumentException("a valid stream type must be specified");
    }
  }
  
  void zzq(List<MediaTrack> paramList)
  {
    this.zzWa = paramList;
  }
  
  void zzx(long paramLong)
    throws IllegalArgumentException
  {
    if ((paramLong < 0L) && (paramLong != -1L)) {
      throw new IllegalArgumentException("Invalid stream duration");
    }
    this.zzVZ = paramLong;
  }
  
  public static class Builder
  {
    private final MediaInfo zzWd;
    
    public Builder(String paramString)
      throws IllegalArgumentException
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("Content ID cannot be empty");
      }
      this.zzWd = new MediaInfo(paramString);
    }
    
    public MediaInfo build()
      throws IllegalArgumentException
    {
      this.zzWd.zzmx();
      return this.zzWd;
    }
    
    public Builder setContentType(String paramString)
      throws IllegalArgumentException
    {
      this.zzWd.setContentType(paramString);
      return this;
    }
    
    public Builder setCustomData(JSONObject paramJSONObject)
    {
      this.zzWd.setCustomData(paramJSONObject);
      return this;
    }
    
    public Builder setMediaTracks(List<MediaTrack> paramList)
    {
      this.zzWd.zzq(paramList);
      return this;
    }
    
    public Builder setMetadata(MediaMetadata paramMediaMetadata)
    {
      this.zzWd.zza(paramMediaMetadata);
      return this;
    }
    
    public Builder setStreamDuration(long paramLong)
      throws IllegalArgumentException
    {
      this.zzWd.zzx(paramLong);
      return this;
    }
    
    public Builder setStreamType(int paramInt)
      throws IllegalArgumentException
    {
      this.zzWd.setStreamType(paramInt);
      return this;
    }
    
    public Builder setTextTrackStyle(TextTrackStyle paramTextTrackStyle)
    {
      this.zzWd.setTextTrackStyle(paramTextTrackStyle);
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\MediaInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */