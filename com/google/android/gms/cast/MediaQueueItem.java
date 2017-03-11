package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzmu;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaQueueItem
{
  public static final double DEFAULT_PLAYBACK_DURATION = Double.POSITIVE_INFINITY;
  public static final int INVALID_ITEM_ID = 0;
  private JSONObject zzWc;
  private MediaInfo zzWl;
  private int zzWm = 0;
  private boolean zzWn = true;
  private double zzWo;
  private double zzWp = Double.POSITIVE_INFINITY;
  private double zzWq;
  private long[] zzWr;
  
  private MediaQueueItem(MediaInfo paramMediaInfo)
    throws IllegalArgumentException
  {
    if (paramMediaInfo == null) {
      throw new IllegalArgumentException("media cannot be null.");
    }
    this.zzWl = paramMediaInfo;
  }
  
  private MediaQueueItem(MediaQueueItem paramMediaQueueItem)
    throws IllegalArgumentException
  {
    this.zzWl = paramMediaQueueItem.getMedia();
    if (this.zzWl == null) {
      throw new IllegalArgumentException("media cannot be null.");
    }
    this.zzWm = paramMediaQueueItem.getItemId();
    this.zzWn = paramMediaQueueItem.getAutoplay();
    this.zzWo = paramMediaQueueItem.getStartTime();
    this.zzWp = paramMediaQueueItem.getPlaybackDuration();
    this.zzWq = paramMediaQueueItem.getPreloadTime();
    this.zzWr = paramMediaQueueItem.getActiveTrackIds();
    this.zzWc = paramMediaQueueItem.getCustomData();
  }
  
  MediaQueueItem(JSONObject paramJSONObject)
    throws JSONException
  {
    zzg(paramJSONObject);
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
        } while (!(paramObject instanceof MediaQueueItem));
        paramObject = (MediaQueueItem)paramObject;
        if (this.zzWc != null) {
          break;
        }
        i = 1;
        if (((MediaQueueItem)paramObject).zzWc != null) {
          break label190;
        }
        j = 1;
        bool1 = bool3;
      } while (i != j);
      if ((this.zzWc == null) || (((MediaQueueItem)paramObject).zzWc == null)) {
        break;
      }
      bool1 = bool3;
    } while (!zzmu.zzd(this.zzWc, ((MediaQueueItem)paramObject).zzWc));
    if ((zzf.zza(this.zzWl, ((MediaQueueItem)paramObject).zzWl)) && (this.zzWm == ((MediaQueueItem)paramObject).zzWm) && (this.zzWn == ((MediaQueueItem)paramObject).zzWn) && (this.zzWo == ((MediaQueueItem)paramObject).zzWo) && (this.zzWp == ((MediaQueueItem)paramObject).zzWp) && (this.zzWq == ((MediaQueueItem)paramObject).zzWq) && (zzf.zza(this.zzWr, ((MediaQueueItem)paramObject).zzWr))) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      return bool1;
      i = 0;
      break;
      label190:
      j = 0;
      break label51;
    }
  }
  
  public long[] getActiveTrackIds()
  {
    return this.zzWr;
  }
  
  public boolean getAutoplay()
  {
    return this.zzWn;
  }
  
  public JSONObject getCustomData()
  {
    return this.zzWc;
  }
  
  public int getItemId()
  {
    return this.zzWm;
  }
  
  public MediaInfo getMedia()
  {
    return this.zzWl;
  }
  
  public double getPlaybackDuration()
  {
    return this.zzWp;
  }
  
  public double getPreloadTime()
  {
    return this.zzWq;
  }
  
  public double getStartTime()
  {
    return this.zzWo;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzWl, Integer.valueOf(this.zzWm), Boolean.valueOf(this.zzWn), Double.valueOf(this.zzWo), Double.valueOf(this.zzWp), Double.valueOf(this.zzWq), this.zzWr, String.valueOf(this.zzWc) });
  }
  
  void setCustomData(JSONObject paramJSONObject)
  {
    this.zzWc = paramJSONObject;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("media", this.zzWl.toJson());
      if (this.zzWm != 0) {
        localJSONObject.put("itemId", this.zzWm);
      }
      localJSONObject.put("autoplay", this.zzWn);
      localJSONObject.put("startTime", this.zzWo);
      if (this.zzWp != Double.POSITIVE_INFINITY) {
        localJSONObject.put("playbackDuration", this.zzWp);
      }
      localJSONObject.put("preloadTime", this.zzWq);
      if (this.zzWr != null)
      {
        JSONArray localJSONArray = new JSONArray();
        long[] arrayOfLong = this.zzWr;
        int j = arrayOfLong.length;
        int i = 0;
        while (i < j)
        {
          localJSONArray.put(arrayOfLong[i]);
          i += 1;
        }
        localJSONObject.put("activeTrackIds", localJSONArray);
      }
      if (this.zzWc != null) {
        localJSONObject.put("customData", this.zzWc);
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  void zzU(boolean paramBoolean)
  {
    this.zzWn = paramBoolean;
  }
  
  void zza(long[] paramArrayOfLong)
  {
    this.zzWr = paramArrayOfLong;
  }
  
  void zzaR(int paramInt)
  {
    this.zzWm = paramInt;
  }
  
  void zzc(double paramDouble)
    throws IllegalArgumentException
  {
    if ((Double.isNaN(paramDouble)) || (paramDouble < 0.0D)) {
      throw new IllegalArgumentException("startTime cannot be negative or NaN.");
    }
    this.zzWo = paramDouble;
  }
  
  void zzd(double paramDouble)
    throws IllegalArgumentException
  {
    if (Double.isNaN(paramDouble)) {
      throw new IllegalArgumentException("playbackDuration cannot be NaN.");
    }
    this.zzWp = paramDouble;
  }
  
  void zze(double paramDouble)
    throws IllegalArgumentException
  {
    if ((Double.isNaN(paramDouble)) || (paramDouble < 0.0D)) {
      throw new IllegalArgumentException("preloadTime cannot be negative or NaN.");
    }
    this.zzWq = paramDouble;
  }
  
  public boolean zzg(JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject.has("media")) {
      this.zzWl = new MediaInfo(paramJSONObject.getJSONObject("media"));
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      int i;
      if (paramJSONObject.has("itemId"))
      {
        i = paramJSONObject.getInt("itemId");
        bool1 = bool2;
        if (this.zzWm != i)
        {
          this.zzWm = i;
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (paramJSONObject.has("autoplay"))
      {
        boolean bool3 = paramJSONObject.getBoolean("autoplay");
        bool2 = bool1;
        if (this.zzWn != bool3)
        {
          this.zzWn = bool3;
          bool2 = true;
        }
      }
      bool1 = bool2;
      double d;
      if (paramJSONObject.has("startTime"))
      {
        d = paramJSONObject.getDouble("startTime");
        bool1 = bool2;
        if (Math.abs(d - this.zzWo) > 1.0E-7D)
        {
          this.zzWo = d;
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (paramJSONObject.has("playbackDuration"))
      {
        d = paramJSONObject.getDouble("playbackDuration");
        bool2 = bool1;
        if (Math.abs(d - this.zzWp) > 1.0E-7D)
        {
          this.zzWp = d;
          bool2 = true;
        }
      }
      bool1 = bool2;
      if (paramJSONObject.has("preloadTime"))
      {
        d = paramJSONObject.getDouble("preloadTime");
        bool1 = bool2;
        if (Math.abs(d - this.zzWq) > 1.0E-7D)
        {
          this.zzWq = d;
          bool1 = true;
        }
      }
      int j;
      long[] arrayOfLong;
      if (paramJSONObject.has("activeTrackIds"))
      {
        JSONArray localJSONArray = paramJSONObject.getJSONArray("activeTrackIds");
        j = localJSONArray.length();
        arrayOfLong = new long[j];
        i = 0;
        while (i < j)
        {
          arrayOfLong[i] = localJSONArray.getLong(i);
          i += 1;
        }
        if (this.zzWr == null) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          this.zzWr = arrayOfLong;
          bool1 = true;
        }
        if (paramJSONObject.has("customData"))
        {
          this.zzWc = paramJSONObject.getJSONObject("customData");
          return true;
          if (this.zzWr.length != j)
          {
            i = 1;
          }
          else
          {
            i = 0;
            for (;;)
            {
              if (i >= j) {
                break label425;
              }
              if (this.zzWr[i] != arrayOfLong[i])
              {
                i = 1;
                break;
              }
              i += 1;
            }
          }
        }
        else
        {
          return bool1;
          label425:
          i = 0;
          continue;
          i = 0;
          arrayOfLong = null;
        }
      }
    }
  }
  
  void zzmx()
    throws IllegalArgumentException
  {
    if (this.zzWl == null) {
      throw new IllegalArgumentException("media cannot be null.");
    }
    if ((Double.isNaN(this.zzWo)) || (this.zzWo < 0.0D)) {
      throw new IllegalArgumentException("startTime cannot be negative or NaN.");
    }
    if (Double.isNaN(this.zzWp)) {
      throw new IllegalArgumentException("playbackDuration cannot be NaN.");
    }
    if ((Double.isNaN(this.zzWq)) || (this.zzWq < 0.0D)) {
      throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
    }
  }
  
  public static class Builder
  {
    private final MediaQueueItem zzWs;
    
    public Builder(MediaInfo paramMediaInfo)
      throws IllegalArgumentException
    {
      this.zzWs = new MediaQueueItem(paramMediaInfo, null);
    }
    
    public Builder(MediaQueueItem paramMediaQueueItem)
      throws IllegalArgumentException
    {
      this.zzWs = new MediaQueueItem(paramMediaQueueItem, null);
    }
    
    public Builder(JSONObject paramJSONObject)
      throws JSONException
    {
      this.zzWs = new MediaQueueItem(paramJSONObject);
    }
    
    public MediaQueueItem build()
    {
      this.zzWs.zzmx();
      return this.zzWs;
    }
    
    public Builder clearItemId()
    {
      this.zzWs.zzaR(0);
      return this;
    }
    
    public Builder setActiveTrackIds(long[] paramArrayOfLong)
    {
      this.zzWs.zza(paramArrayOfLong);
      return this;
    }
    
    public Builder setAutoplay(boolean paramBoolean)
    {
      this.zzWs.zzU(paramBoolean);
      return this;
    }
    
    public Builder setCustomData(JSONObject paramJSONObject)
    {
      this.zzWs.setCustomData(paramJSONObject);
      return this;
    }
    
    public Builder setPlaybackDuration(double paramDouble)
    {
      this.zzWs.zzd(paramDouble);
      return this;
    }
    
    public Builder setPreloadTime(double paramDouble)
      throws IllegalArgumentException
    {
      this.zzWs.zze(paramDouble);
      return this;
    }
    
    public Builder setStartTime(double paramDouble)
      throws IllegalArgumentException
    {
      this.zzWs.zzc(paramDouble);
      return this;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\MediaQueueItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */