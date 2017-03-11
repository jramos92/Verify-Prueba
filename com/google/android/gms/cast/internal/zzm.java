package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzm
  extends zzc
{
  private static final String NAMESPACE = zzf.zzbN("com.google.cast.media");
  private final List<zzp> zzXI = new ArrayList();
  private final zzp zzZA = new zzp(86400000L);
  private final zzp zzZB = new zzp(86400000L);
  private final zzp zzZC = new zzp(86400000L);
  private final zzp zzZD = new zzp(86400000L);
  private final zzp zzZE = new zzp(86400000L);
  private final zzp zzZF = new zzp(86400000L);
  private long zzZq;
  private MediaStatus zzZr;
  private final zzp zzZs = new zzp(86400000L);
  private final zzp zzZt = new zzp(86400000L);
  private final zzp zzZu = new zzp(86400000L);
  private final zzp zzZv = new zzp(86400000L);
  private final zzp zzZw = new zzp(86400000L);
  private final zzp zzZx = new zzp(86400000L);
  private final zzp zzZy = new zzp(86400000L);
  private final zzp zzZz = new zzp(86400000L);
  
  public zzm(String paramString)
  {
    super(NAMESPACE, "MediaControlChannel", paramString, 1000L);
    this.zzXI.add(this.zzZs);
    this.zzXI.add(this.zzZt);
    this.zzXI.add(this.zzZu);
    this.zzXI.add(this.zzZv);
    this.zzXI.add(this.zzZw);
    this.zzXI.add(this.zzZx);
    this.zzXI.add(this.zzZy);
    this.zzXI.add(this.zzZz);
    this.zzXI.add(this.zzZA);
    this.zzXI.add(this.zzZB);
    this.zzXI.add(this.zzZC);
    this.zzXI.add(this.zzZD);
    this.zzXI.add(this.zzZE);
    this.zzXI.add(this.zzZF);
    zzni();
  }
  
  private void zza(long paramLong, JSONObject paramJSONObject)
    throws JSONException
  {
    int k = 1;
    boolean bool = this.zzZs.zzB(paramLong);
    int j;
    if ((this.zzZw.zznk()) && (!this.zzZw.zzB(paramLong)))
    {
      i = 1;
      if (this.zzZx.zznk())
      {
        j = k;
        if (!this.zzZx.zzB(paramLong)) {}
      }
      else
      {
        if ((!this.zzZy.zznk()) || (this.zzZy.zzB(paramLong))) {
          break label259;
        }
        j = k;
      }
      label87:
      if (i == 0) {
        break label281;
      }
    }
    label259:
    label281:
    for (int i = 2;; i = 0)
    {
      k = i;
      if (j != 0) {
        k = i | 0x1;
      }
      if ((bool) || (this.zzZr == null))
      {
        this.zzZr = new MediaStatus(paramJSONObject);
        this.zzZq = SystemClock.elapsedRealtime();
      }
      for (i = 31;; i = this.zzZr.zza(paramJSONObject, k))
      {
        if ((i & 0x1) != 0)
        {
          this.zzZq = SystemClock.elapsedRealtime();
          onStatusUpdated();
        }
        if ((i & 0x2) != 0)
        {
          this.zzZq = SystemClock.elapsedRealtime();
          onStatusUpdated();
        }
        if ((i & 0x4) != 0) {
          onMetadataUpdated();
        }
        if ((i & 0x8) != 0) {
          onQueueStatusUpdated();
        }
        if ((i & 0x10) != 0) {
          onPreloadStatusUpdated();
        }
        paramJSONObject = this.zzXI.iterator();
        while (paramJSONObject.hasNext()) {
          ((zzp)paramJSONObject.next()).zzc(paramLong, 0);
        }
        i = 0;
        break;
        j = 0;
        break label87;
      }
      return;
    }
  }
  
  private void zzni()
  {
    this.zzZq = 0L;
    this.zzZr = null;
    Iterator localIterator = this.zzXI.iterator();
    while (localIterator.hasNext()) {
      ((zzp)localIterator.next()).clear();
    }
  }
  
  public long getApproximateStreamPosition()
  {
    MediaInfo localMediaInfo = getMediaInfo();
    if (localMediaInfo == null) {}
    while (this.zzZq == 0L) {
      return 0L;
    }
    double d = this.zzZr.getPlaybackRate();
    long l3 = this.zzZr.getStreamPosition();
    int i = this.zzZr.getPlayerState();
    if ((d == 0.0D) || (i != 2)) {
      return l3;
    }
    long l1 = SystemClock.elapsedRealtime() - this.zzZq;
    if (l1 < 0L) {
      l1 = 0L;
    }
    for (;;)
    {
      if (l1 == 0L) {
        return l3;
      }
      long l2 = localMediaInfo.getStreamDuration();
      l1 = l3 + (l1 * d);
      if ((l2 > 0L) && (l1 > l2)) {
        l1 = l2;
      }
      for (;;)
      {
        return l1;
        if (l1 < 0L) {
          l1 = 0L;
        }
      }
    }
  }
  
  public MediaInfo getMediaInfo()
  {
    if (this.zzZr == null) {
      return null;
    }
    return this.zzZr.getMediaInfo();
  }
  
  public MediaStatus getMediaStatus()
  {
    return this.zzZr;
  }
  
  public long getStreamDuration()
  {
    MediaInfo localMediaInfo = getMediaInfo();
    if (localMediaInfo != null) {
      return localMediaInfo.getStreamDuration();
    }
    return 0L;
  }
  
  protected void onMetadataUpdated() {}
  
  protected void onPreloadStatusUpdated() {}
  
  protected void onQueueStatusUpdated() {}
  
  protected void onStatusUpdated() {}
  
  public long zza(zzo paramzzo)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZz.zza(l, paramzzo);
    zzV(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "GET_STATUS");
      if (this.zzZr != null) {
        localJSONObject.put("mediaSessionId", this.zzZr.zzmy());
      }
      zza(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException paramzzo)
    {
      for (;;) {}
    }
  }
  
  public long zza(zzo paramzzo, double paramDouble, JSONObject paramJSONObject)
    throws IOException, IllegalStateException, IllegalArgumentException
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZx.zza(l, paramzzo);
    zzV(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "SET_VOLUME");
      localJSONObject.put("mediaSessionId", zzmy());
      paramzzo = new JSONObject();
      paramzzo.put("level", paramDouble);
      localJSONObject.put("volume", paramzzo);
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramzzo)
    {
      for (;;) {}
    }
    zza(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long zza(zzo paramzzo, int paramInt1, long paramLong, MediaQueueItem[] paramArrayOfMediaQueueItem, int paramInt2, Integer paramInteger, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    if ((paramLong != -1L) && (paramLong < 0L)) {
      throw new IllegalArgumentException("playPosition cannot be negative: " + paramLong);
    }
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZD.zza(l, paramzzo);
    zzV(true);
    for (;;)
    {
      try
      {
        localJSONObject.put("requestId", l);
        localJSONObject.put("type", "QUEUE_UPDATE");
        localJSONObject.put("mediaSessionId", zzmy());
        if (paramInt1 != 0) {
          localJSONObject.put("currentItemId", paramInt1);
        }
        if (paramInt2 != 0) {
          localJSONObject.put("jump", paramInt2);
        }
        if ((paramArrayOfMediaQueueItem != null) && (paramArrayOfMediaQueueItem.length > 0))
        {
          paramzzo = new JSONArray();
          paramInt1 = 0;
          if (paramInt1 < paramArrayOfMediaQueueItem.length)
          {
            paramzzo.put(paramInt1, paramArrayOfMediaQueueItem[paramInt1].toJson());
            paramInt1 += 1;
            continue;
          }
          localJSONObject.put("items", paramzzo);
        }
        if (paramInteger != null) {}
        switch (paramInteger.intValue())
        {
        case 0: 
          if (paramLong != -1L) {
            localJSONObject.put("currentTime", zzf.zzA(paramLong));
          }
          if (paramJSONObject != null) {
            localJSONObject.put("customData", paramJSONObject);
          }
          break;
        }
      }
      catch (JSONException paramzzo)
      {
        continue;
      }
      zza(localJSONObject.toString(), l, null);
      return l;
      localJSONObject.put("repeatMode", "REPEAT_OFF");
      continue;
      localJSONObject.put("repeatMode", "REPEAT_ALL");
      continue;
      localJSONObject.put("repeatMode", "REPEAT_SINGLE");
      continue;
      localJSONObject.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
    }
  }
  
  public long zza(zzo paramzzo, long paramLong, int paramInt, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZw.zza(l, paramzzo);
    zzV(true);
    for (;;)
    {
      try
      {
        localJSONObject.put("requestId", l);
        localJSONObject.put("type", "SEEK");
        localJSONObject.put("mediaSessionId", zzmy());
        localJSONObject.put("currentTime", zzf.zzA(paramLong));
        if (paramInt != 1) {
          continue;
        }
        localJSONObject.put("resumeState", "PLAYBACK_START");
        if (paramJSONObject != null) {
          localJSONObject.put("customData", paramJSONObject);
        }
      }
      catch (JSONException paramzzo)
      {
        continue;
      }
      zza(localJSONObject.toString(), l, null);
      return l;
      if (paramInt == 2) {
        localJSONObject.put("resumeState", "PLAYBACK_PAUSE");
      }
    }
  }
  
  public long zza(zzo paramzzo, MediaInfo paramMediaInfo, boolean paramBoolean, long paramLong, long[] paramArrayOfLong, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZs.zza(l, paramzzo);
    zzV(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "LOAD");
      localJSONObject.put("media", paramMediaInfo.toJson());
      localJSONObject.put("autoplay", paramBoolean);
      localJSONObject.put("currentTime", zzf.zzA(paramLong));
      if (paramArrayOfLong != null)
      {
        paramzzo = new JSONArray();
        int i = 0;
        while (i < paramArrayOfLong.length)
        {
          paramzzo.put(i, paramArrayOfLong[i]);
          i += 1;
        }
        localJSONObject.put("activeTrackIds", paramzzo);
      }
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramzzo)
    {
      for (;;) {}
    }
    zza(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long zza(zzo paramzzo, TextTrackStyle paramTextTrackStyle)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZB.zza(l, paramzzo);
    zzV(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "EDIT_TRACKS_INFO");
      if (paramTextTrackStyle != null) {
        localJSONObject.put("textTrackStyle", paramTextTrackStyle.toJson());
      }
      localJSONObject.put("mediaSessionId", zzmy());
    }
    catch (JSONException paramzzo)
    {
      for (;;) {}
    }
    zza(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long zza(zzo paramzzo, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZt.zza(l, paramzzo);
    zzV(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "PAUSE");
      localJSONObject.put("mediaSessionId", zzmy());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramzzo)
    {
      for (;;) {}
    }
    zza(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long zza(zzo paramzzo, boolean paramBoolean, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZy.zza(l, paramzzo);
    zzV(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "SET_VOLUME");
      localJSONObject.put("mediaSessionId", zzmy());
      paramzzo = new JSONObject();
      paramzzo.put("muted", paramBoolean);
      localJSONObject.put("volume", paramzzo);
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramzzo)
    {
      for (;;) {}
    }
    zza(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long zza(zzo paramzzo, int[] paramArrayOfInt, int paramInt, JSONObject paramJSONObject)
    throws IOException, IllegalStateException, IllegalArgumentException
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      throw new IllegalArgumentException("itemIdsToReorder must not be null or empty.");
    }
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZF.zza(l, paramzzo);
    zzV(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "QUEUE_REORDER");
      localJSONObject.put("mediaSessionId", zzmy());
      paramzzo = new JSONArray();
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        paramzzo.put(i, paramArrayOfInt[i]);
        i += 1;
      }
      localJSONObject.put("itemIds", paramzzo);
      if (paramInt != 0) {
        localJSONObject.put("insertBefore", paramInt);
      }
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramzzo)
    {
      for (;;) {}
    }
    zza(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long zza(zzo paramzzo, int[] paramArrayOfInt, JSONObject paramJSONObject)
    throws IOException, IllegalStateException, IllegalArgumentException
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length == 0)) {
      throw new IllegalArgumentException("itemIdsToRemove must not be null or empty.");
    }
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZE.zza(l, paramzzo);
    zzV(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "QUEUE_REMOVE");
      localJSONObject.put("mediaSessionId", zzmy());
      paramzzo = new JSONArray();
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        paramzzo.put(i, paramArrayOfInt[i]);
        i += 1;
      }
      localJSONObject.put("itemIds", paramzzo);
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramzzo)
    {
      for (;;) {}
    }
    zza(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long zza(zzo paramzzo, long[] paramArrayOfLong)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZA.zza(l, paramzzo);
    zzV(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "EDIT_TRACKS_INFO");
      localJSONObject.put("mediaSessionId", zzmy());
      paramzzo = new JSONArray();
      int i = 0;
      while (i < paramArrayOfLong.length)
      {
        paramzzo.put(i, paramArrayOfLong[i]);
        i += 1;
      }
      localJSONObject.put("activeTrackIds", paramzzo);
    }
    catch (JSONException paramzzo)
    {
      for (;;) {}
    }
    zza(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long zza(zzo paramzzo, MediaQueueItem[] paramArrayOfMediaQueueItem, int paramInt1, int paramInt2, int paramInt3, long paramLong, JSONObject paramJSONObject)
    throws IOException, IllegalStateException, IllegalStateException
  {
    if ((paramArrayOfMediaQueueItem == null) || (paramArrayOfMediaQueueItem.length == 0)) {
      throw new IllegalArgumentException("itemsToInsert must not be null or empty.");
    }
    if ((paramInt2 != 0) && (paramInt3 != -1)) {
      throw new IllegalArgumentException("can not set both currentItemId and currentItemIndexInItemsToInsert");
    }
    if ((paramInt3 != -1) && ((paramInt3 < 0) || (paramInt3 >= paramArrayOfMediaQueueItem.length))) {
      throw new IllegalArgumentException(String.format("currentItemIndexInItemsToInsert %d out of range [0, %d).", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramArrayOfMediaQueueItem.length) }));
    }
    if ((paramLong != -1L) && (paramLong < 0L)) {
      throw new IllegalArgumentException("playPosition can not be negative: " + paramLong);
    }
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZC.zza(l, paramzzo);
    zzV(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "QUEUE_INSERT");
      localJSONObject.put("mediaSessionId", zzmy());
      paramzzo = new JSONArray();
      int i = 0;
      while (i < paramArrayOfMediaQueueItem.length)
      {
        paramzzo.put(i, paramArrayOfMediaQueueItem[i].toJson());
        i += 1;
      }
      localJSONObject.put("items", paramzzo);
      if (paramInt1 != 0) {
        localJSONObject.put("insertBefore", paramInt1);
      }
      if (paramInt2 != 0) {
        localJSONObject.put("currentItemId", paramInt2);
      }
      if (paramInt3 != -1) {
        localJSONObject.put("currentItemIndex", paramInt3);
      }
      if (paramLong != -1L) {
        localJSONObject.put("currentTime", zzf.zzA(paramLong));
      }
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramzzo)
    {
      for (;;) {}
    }
    zza(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long zza(zzo paramzzo, MediaQueueItem[] paramArrayOfMediaQueueItem, int paramInt1, int paramInt2, long paramLong, JSONObject paramJSONObject)
    throws IOException, IllegalArgumentException
  {
    if ((paramArrayOfMediaQueueItem == null) || (paramArrayOfMediaQueueItem.length == 0)) {
      throw new IllegalArgumentException("items must not be null or empty.");
    }
    if ((paramInt1 < 0) || (paramInt1 >= paramArrayOfMediaQueueItem.length)) {
      throw new IllegalArgumentException("Invalid startIndex: " + paramInt1);
    }
    if ((paramLong != -1L) && (paramLong < 0L)) {
      throw new IllegalArgumentException("playPosition can not be negative: " + paramLong);
    }
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZs.zza(l, paramzzo);
    zzV(true);
    for (;;)
    {
      try
      {
        localJSONObject.put("requestId", l);
        localJSONObject.put("type", "QUEUE_LOAD");
        paramzzo = new JSONArray();
        int i = 0;
        if (i < paramArrayOfMediaQueueItem.length)
        {
          paramzzo.put(i, paramArrayOfMediaQueueItem[i].toJson());
          i += 1;
          continue;
        }
        localJSONObject.put("items", paramzzo);
        switch (paramInt2)
        {
        case 0: 
          throw new IllegalArgumentException("Invalid repeat mode: " + paramInt2);
        }
      }
      catch (JSONException paramzzo)
      {
        zza(localJSONObject.toString(), l, null);
        return l;
      }
      localJSONObject.put("repeatMode", "REPEAT_OFF");
      for (;;)
      {
        localJSONObject.put("startIndex", paramInt1);
        if (paramLong != -1L) {
          localJSONObject.put("currentTime", zzf.zzA(paramLong));
        }
        if (paramJSONObject == null) {
          break;
        }
        localJSONObject.put("customData", paramJSONObject);
        break;
        localJSONObject.put("repeatMode", "REPEAT_ALL");
        continue;
        localJSONObject.put("repeatMode", "REPEAT_SINGLE");
        continue;
        localJSONObject.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
      }
    }
  }
  
  public long zzb(zzo paramzzo, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZv.zza(l, paramzzo);
    zzV(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "STOP");
      localJSONObject.put("mediaSessionId", zzmy());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramzzo)
    {
      for (;;) {}
    }
    zza(localJSONObject.toString(), l, null);
    return l;
  }
  
  public void zzb(long paramLong, int paramInt)
  {
    Iterator localIterator = this.zzXI.iterator();
    while (localIterator.hasNext()) {
      ((zzp)localIterator.next()).zzc(paramLong, paramInt);
    }
  }
  
  public final void zzbK(String paramString)
  {
    this.zzYC.zzb("message received: %s", new Object[] { paramString });
    Object localObject2;
    long l;
    try
    {
      Object localObject1 = new JSONObject(paramString);
      localObject2 = ((JSONObject)localObject1).getString("type");
      l = ((JSONObject)localObject1).optLong("requestId", -1L);
      if (((String)localObject2).equals("MEDIA_STATUS"))
      {
        localObject1 = ((JSONObject)localObject1).getJSONArray("status");
        if (((JSONArray)localObject1).length() > 0)
        {
          zza(l, ((JSONArray)localObject1).getJSONObject(0));
          return;
        }
        this.zzZr = null;
        onStatusUpdated();
        onMetadataUpdated();
        onQueueStatusUpdated();
        onPreloadStatusUpdated();
        this.zzZz.zzc(l, 0);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      this.zzYC.zzf("Message is malformed (%s); ignoring: %s", new Object[] { localJSONException.getMessage(), paramString });
      return;
    }
    JSONObject localJSONObject;
    if (((String)localObject2).equals("INVALID_PLAYER_STATE"))
    {
      this.zzYC.zzf("received unexpected error: Invalid Player State.", new Object[0]);
      localJSONObject = localJSONException.optJSONObject("customData");
      localObject2 = this.zzXI.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((zzp)((Iterator)localObject2).next()).zzc(l, 2100, localJSONObject);
      }
    }
    if (((String)localObject2).equals("LOAD_FAILED"))
    {
      localJSONObject = localJSONObject.optJSONObject("customData");
      this.zzZs.zzc(l, 2100, localJSONObject);
      return;
    }
    if (((String)localObject2).equals("LOAD_CANCELLED"))
    {
      localJSONObject = localJSONObject.optJSONObject("customData");
      this.zzZs.zzc(l, 2101, localJSONObject);
      return;
    }
    if (((String)localObject2).equals("INVALID_REQUEST"))
    {
      this.zzYC.zzf("received unexpected error: Invalid Request.", new Object[0]);
      localJSONObject = localJSONObject.optJSONObject("customData");
      localObject2 = this.zzXI.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((zzp)((Iterator)localObject2).next()).zzc(l, 2100, localJSONObject);
      }
    }
  }
  
  public long zzc(zzo paramzzo, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = zzmQ();
    this.zzZu.zza(l, paramzzo);
    zzV(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "PLAY");
      localJSONObject.put("mediaSessionId", zzmy());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException paramzzo)
    {
      for (;;) {}
    }
    zza(localJSONObject.toString(), l, null);
    return l;
  }
  
  public void zzmP()
  {
    super.zzmP();
    zzni();
  }
  
  public long zzmy()
    throws IllegalStateException
  {
    if (this.zzZr == null) {
      throw new IllegalStateException("No current media session");
    }
    return this.zzZr.zzmy();
  }
  
  protected boolean zzz(long paramLong)
  {
    ??? = this.zzXI.iterator();
    while (((Iterator)???).hasNext()) {
      ((zzp)((Iterator)???).next()).zzd(paramLong, 2102);
    }
    for (;;)
    {
      synchronized (zzp.zzZJ)
      {
        Iterator localIterator = this.zzXI.iterator();
        if (localIterator.hasNext())
        {
          if (!((zzp)localIterator.next()).zznk()) {
            continue;
          }
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\cast\internal\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */