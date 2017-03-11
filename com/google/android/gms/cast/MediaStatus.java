package com.google.android.gms.cast;

import android.util.SparseArray;
import com.google.android.gms.cast.internal.zzf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus
{
  public static final long COMMAND_PAUSE = 1L;
  public static final long COMMAND_SEEK = 2L;
  public static final long COMMAND_SET_VOLUME = 4L;
  public static final long COMMAND_SKIP_BACKWARD = 32L;
  public static final long COMMAND_SKIP_FORWARD = 16L;
  public static final long COMMAND_TOGGLE_MUTE = 8L;
  public static final int IDLE_REASON_CANCELED = 2;
  public static final int IDLE_REASON_ERROR = 4;
  public static final int IDLE_REASON_FINISHED = 1;
  public static final int IDLE_REASON_INTERRUPTED = 3;
  public static final int IDLE_REASON_NONE = 0;
  public static final int PLAYER_STATE_BUFFERING = 4;
  public static final int PLAYER_STATE_IDLE = 1;
  public static final int PLAYER_STATE_PAUSED = 3;
  public static final int PLAYER_STATE_PLAYING = 2;
  public static final int PLAYER_STATE_UNKNOWN = 0;
  public static final int REPEAT_MODE_REPEAT_ALL = 1;
  public static final int REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE = 3;
  public static final int REPEAT_MODE_REPEAT_OFF = 0;
  public static final int REPEAT_MODE_REPEAT_SINGLE = 2;
  private double zzWA;
  private boolean zzWB;
  private int zzWC = 0;
  private int zzWD = 0;
  private final zza zzWE = new zza();
  private JSONObject zzWc;
  private MediaInfo zzWd;
  private long[] zzWr;
  private int zzWt = 0;
  private long zzWu;
  private double zzWv;
  private int zzWw;
  private int zzWx;
  private long zzWy;
  private long zzWz;
  
  public MediaStatus(JSONObject paramJSONObject)
    throws JSONException
  {
    zza(paramJSONObject, 0);
  }
  
  private boolean zzh(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 1) && (paramInt2 == 0);
  }
  
  public long[] getActiveTrackIds()
  {
    return this.zzWr;
  }
  
  public int getCurrentItemId()
  {
    return this.zzWt;
  }
  
  public JSONObject getCustomData()
  {
    return this.zzWc;
  }
  
  public int getIdleReason()
  {
    return this.zzWx;
  }
  
  public int getLoadingItemId()
  {
    return this.zzWC;
  }
  
  public MediaInfo getMediaInfo()
  {
    return this.zzWd;
  }
  
  public double getPlaybackRate()
  {
    return this.zzWv;
  }
  
  public int getPlayerState()
  {
    return this.zzWw;
  }
  
  public int getPreloadedItemId()
  {
    return this.zzWD;
  }
  
  public MediaQueueItem getQueueItem(int paramInt)
  {
    return this.zzWE.zzaT(paramInt);
  }
  
  public MediaQueueItem getQueueItemById(int paramInt)
  {
    return this.zzWE.zzaS(paramInt);
  }
  
  public int getQueueItemCount()
  {
    return this.zzWE.getItemCount();
  }
  
  public List<MediaQueueItem> getQueueItems()
  {
    return this.zzWE.zzmz();
  }
  
  public int getQueueRepeatMode()
  {
    return this.zzWE.getRepeatMode();
  }
  
  public long getStreamPosition()
  {
    return this.zzWy;
  }
  
  public double getStreamVolume()
  {
    return this.zzWA;
  }
  
  public boolean isMediaCommandSupported(long paramLong)
  {
    return (this.zzWz & paramLong) != 0L;
  }
  
  public boolean isMute()
  {
    return this.zzWB;
  }
  
  public int zza(JSONObject paramJSONObject, int paramInt)
    throws JSONException
  {
    int i1 = 2;
    int n = 1;
    long l = paramJSONObject.getLong("mediaSessionId");
    if (l != this.zzWu) {
      this.zzWu = l;
    }
    for (int j = 1;; j = 0)
    {
      int k = j;
      Object localObject;
      int i;
      if (paramJSONObject.has("playerState"))
      {
        localObject = paramJSONObject.getString("playerState");
        if (!((String)localObject).equals("IDLE")) {
          break label461;
        }
        i = 1;
      }
      for (;;)
      {
        int m = j;
        if (i != this.zzWw)
        {
          this.zzWw = i;
          m = j | 0x2;
        }
        k = m;
        if (i == 1)
        {
          k = m;
          if (paramJSONObject.has("idleReason"))
          {
            localObject = paramJSONObject.getString("idleReason");
            if (!((String)localObject).equals("CANCELLED")) {
              break label509;
            }
            i = i1;
          }
        }
        for (;;)
        {
          label137:
          k = m;
          if (i != this.zzWx)
          {
            this.zzWx = i;
            k = m | 0x2;
          }
          i = k;
          double d;
          if (paramJSONObject.has("playbackRate"))
          {
            d = paramJSONObject.getDouble("playbackRate");
            i = k;
            if (this.zzWv != d)
            {
              this.zzWv = d;
              i = k | 0x2;
            }
          }
          k = i;
          if (paramJSONObject.has("currentTime"))
          {
            k = i;
            if ((paramInt & 0x2) == 0)
            {
              l = zzf.zzg(paramJSONObject.getDouble("currentTime"));
              k = i;
              if (l != this.zzWy)
              {
                this.zzWy = l;
                k = i | 0x2;
              }
            }
          }
          j = k;
          if (paramJSONObject.has("supportedMediaCommands"))
          {
            l = paramJSONObject.getLong("supportedMediaCommands");
            j = k;
            if (l != this.zzWz)
            {
              this.zzWz = l;
              j = k | 0x2;
            }
          }
          i = j;
          if (paramJSONObject.has("volume"))
          {
            i = j;
            if ((paramInt & 0x1) == 0)
            {
              localObject = paramJSONObject.getJSONObject("volume");
              d = ((JSONObject)localObject).getDouble("level");
              paramInt = j;
              if (d != this.zzWA)
              {
                this.zzWA = d;
                paramInt = j | 0x2;
              }
              boolean bool = ((JSONObject)localObject).getBoolean("muted");
              i = paramInt;
              if (bool != this.zzWB)
              {
                this.zzWB = bool;
                i = paramInt | 0x2;
              }
            }
          }
          if (paramJSONObject.has("activeTrackIds"))
          {
            JSONArray localJSONArray = paramJSONObject.getJSONArray("activeTrackIds");
            k = localJSONArray.length();
            localObject = new long[k];
            paramInt = 0;
            for (;;)
            {
              if (paramInt < k)
              {
                localObject[paramInt] = localJSONArray.getLong(paramInt);
                paramInt += 1;
                continue;
                label461:
                if (((String)localObject).equals("PLAYING"))
                {
                  i = 2;
                  break;
                }
                if (((String)localObject).equals("PAUSED"))
                {
                  i = 3;
                  break;
                }
                if (!((String)localObject).equals("BUFFERING")) {
                  break label961;
                }
                i = 4;
                break;
                label509:
                if (((String)localObject).equals("INTERRUPTED"))
                {
                  i = 3;
                  break label137;
                }
                if (((String)localObject).equals("FINISHED"))
                {
                  i = 1;
                  break label137;
                }
                if (!((String)localObject).equals("ERROR")) {
                  break label955;
                }
                i = 4;
                break label137;
              }
            }
            if (this.zzWr == null) {
              paramInt = n;
            }
          }
          for (;;)
          {
            if (paramInt != 0) {
              this.zzWr = ((long[])localObject);
            }
            j = paramInt;
            for (;;)
            {
              label580:
              paramInt = i;
              if (j != 0)
              {
                this.zzWr = ((long[])localObject);
                paramInt = i | 0x2;
              }
              i = paramInt;
              if (paramJSONObject.has("customData"))
              {
                this.zzWc = paramJSONObject.getJSONObject("customData");
                i = paramInt | 0x2;
              }
              paramInt = i;
              if (paramJSONObject.has("media"))
              {
                localObject = paramJSONObject.getJSONObject("media");
                this.zzWd = new MediaInfo((JSONObject)localObject);
                i |= 0x2;
                paramInt = i;
                if (((JSONObject)localObject).has("metadata")) {
                  paramInt = i | 0x4;
                }
              }
              i = paramInt;
              if (paramJSONObject.has("currentItemId"))
              {
                j = paramJSONObject.getInt("currentItemId");
                i = paramInt;
                if (this.zzWt != j)
                {
                  this.zzWt = j;
                  i = paramInt | 0x2;
                }
              }
              j = paramJSONObject.optInt("preloadedItemId", 0);
              paramInt = i;
              if (this.zzWD != j)
              {
                this.zzWD = j;
                paramInt = i | 0x10;
              }
              j = paramJSONObject.optInt("loadingItemId", 0);
              i = paramInt;
              if (this.zzWC != j)
              {
                this.zzWC = j;
                i = paramInt | 0x2;
              }
              if (!zzh(this.zzWw, this.zzWC))
              {
                paramInt = i;
                if (zza.zza(this.zzWE, paramJSONObject)) {
                  paramInt = i | 0x8;
                }
              }
              do
              {
                return paramInt;
                paramInt = n;
                if (this.zzWr.length != k) {
                  break;
                }
                j = 0;
                for (;;)
                {
                  if (j >= k) {
                    break label950;
                  }
                  paramInt = n;
                  if (this.zzWr[j] != localObject[j]) {
                    break;
                  }
                  j += 1;
                }
                if (this.zzWr == null) {
                  break label941;
                }
                j = 1;
                localObject = null;
                break label580;
                this.zzWt = 0;
                this.zzWC = 0;
                this.zzWD = 0;
                paramInt = i;
              } while (this.zzWE.getItemCount() <= 0);
              zza.zza(this.zzWE);
              return i | 0x8;
              label941:
              localObject = null;
              j = 0;
            }
            label950:
            paramInt = 0;
          }
          label955:
          i = 0;
        }
        label961:
        i = 0;
      }
    }
  }
  
  public long zzmy()
  {
    return this.zzWu;
  }
  
  private class zza
  {
    private int zzWF = 0;
    private List<MediaQueueItem> zzWG = new ArrayList();
    private SparseArray<Integer> zzWH = new SparseArray();
    
    zza() {}
    
    private void clear()
    {
      this.zzWF = 0;
      this.zzWG.clear();
      this.zzWH.clear();
    }
    
    private void zza(MediaQueueItem[] paramArrayOfMediaQueueItem)
    {
      this.zzWG.clear();
      this.zzWH.clear();
      int i = 0;
      while (i < paramArrayOfMediaQueueItem.length)
      {
        MediaQueueItem localMediaQueueItem = paramArrayOfMediaQueueItem[i];
        this.zzWG.add(localMediaQueueItem);
        this.zzWH.put(localMediaQueueItem.getItemId(), Integer.valueOf(i));
        i += 1;
      }
    }
    
    private Integer zzaU(int paramInt)
    {
      return (Integer)this.zzWH.get(paramInt);
    }
    
    private boolean zzg(JSONObject paramJSONObject)
      throws JSONException
    {
      int j = 2;
      boolean bool2 = true;
      Object localObject;
      int i;
      if (paramJSONObject.has("repeatMode"))
      {
        int k = this.zzWF;
        localObject = paramJSONObject.getString("repeatMode");
        i = -1;
        switch (((String)localObject).hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            j = k;
          case 2: 
            label111:
            if (this.zzWF != j) {
              this.zzWF = j;
            }
            break;
          }
          break;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        if (paramJSONObject.has("items"))
        {
          paramJSONObject = paramJSONObject.getJSONArray("items");
          j = paramJSONObject.length();
          localObject = new SparseArray();
          i = 0;
          for (;;)
          {
            if (i < j)
            {
              ((SparseArray)localObject).put(i, Integer.valueOf(paramJSONObject.getJSONObject(i).getInt("itemId")));
              i += 1;
              continue;
              if (!((String)localObject).equals("REPEAT_OFF")) {
                break;
              }
              i = 0;
              break;
              if (!((String)localObject).equals("REPEAT_ALL")) {
                break;
              }
              i = 1;
              break;
              if (!((String)localObject).equals("REPEAT_SINGLE")) {
                break;
              }
              i = 2;
              break;
              if (!((String)localObject).equals("REPEAT_ALL_AND_SHUFFLE")) {
                break;
              }
              i = 3;
              break;
              j = 0;
              break label111;
              j = 1;
              break label111;
              j = 3;
              break label111;
            }
          }
          MediaQueueItem[] arrayOfMediaQueueItem = new MediaQueueItem[j];
          i = 0;
          Integer localInteger;
          JSONObject localJSONObject;
          boolean bool3;
          if (i < j)
          {
            localInteger = (Integer)((SparseArray)localObject).get(i);
            localJSONObject = paramJSONObject.getJSONObject(i);
            MediaQueueItem localMediaQueueItem = zzaS(localInteger.intValue());
            if (localMediaQueueItem != null)
            {
              bool3 = localMediaQueueItem.zzg(localJSONObject);
              arrayOfMediaQueueItem[i] = localMediaQueueItem;
              if (i == zzaU(localInteger.intValue()).intValue()) {
                break label453;
              }
              bool1 = true;
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if (localInteger.intValue() == MediaStatus.zza(MediaStatus.this))
            {
              arrayOfMediaQueueItem[i] = new MediaQueueItem.Builder(MediaStatus.zzb(MediaStatus.this)).build();
              arrayOfMediaQueueItem[i].zzg(localJSONObject);
              bool1 = true;
            }
            else
            {
              arrayOfMediaQueueItem[i] = new MediaQueueItem(localJSONObject);
              bool1 = true;
              continue;
              if (this.zzWG.size() != j) {
                bool1 = bool2;
              }
              for (;;)
              {
                zza(arrayOfMediaQueueItem);
                return bool1;
              }
              label453:
              bool1 |= bool3;
            }
          }
        }
        return bool1;
      }
    }
    
    public int getItemCount()
    {
      return this.zzWG.size();
    }
    
    public int getRepeatMode()
    {
      return this.zzWF;
    }
    
    public MediaQueueItem zzaS(int paramInt)
    {
      Integer localInteger = (Integer)this.zzWH.get(paramInt);
      if (localInteger == null) {
        return null;
      }
      return (MediaQueueItem)this.zzWG.get(localInteger.intValue());
    }
    
    public MediaQueueItem zzaT(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= this.zzWG.size())) {
        return null;
      }
      return (MediaQueueItem)this.zzWG.get(paramInt);
    }
    
    public List<MediaQueueItem> zzmz()
    {
      return Collections.unmodifiableList(this.zzWG);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\MediaStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */