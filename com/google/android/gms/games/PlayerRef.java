package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef
  extends zzc
  implements Player
{
  private final PlayerLevelInfo zzaud;
  private final PlayerColumnNames zzauo;
  private final MostRecentGameInfoRef zzaup;
  
  public PlayerRef(DataHolder paramDataHolder, int paramInt)
  {
    this(paramDataHolder, paramInt, null);
  }
  
  public PlayerRef(DataHolder paramDataHolder, int paramInt, String paramString)
  {
    super(paramDataHolder, paramInt);
    this.zzauo = new PlayerColumnNames(paramString);
    this.zzaup = new MostRecentGameInfoRef(paramDataHolder, paramInt, this.zzauo);
    int i;
    if (zztJ())
    {
      paramInt = getInteger(this.zzauo.zzazA);
      i = getInteger(this.zzauo.zzazD);
      paramString = new PlayerLevel(paramInt, getLong(this.zzauo.zzazB), getLong(this.zzauo.zzazC));
      if (paramInt == i) {
        break label178;
      }
    }
    label178:
    for (paramDataHolder = new PlayerLevel(i, getLong(this.zzauo.zzazC), getLong(this.zzauo.zzazE));; paramDataHolder = paramString)
    {
      this.zzaud = new PlayerLevelInfo(getLong(this.zzauo.zzazz), getLong(this.zzauo.zzazF), paramString, paramDataHolder);
      return;
      this.zzaud = null;
      return;
    }
  }
  
  private boolean zztJ()
  {
    if (zzcg(this.zzauo.zzazz)) {}
    while (getLong(this.zzauo.zzazz) == -1L) {
      return false;
    }
    return true;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return PlayerEntity.zza(this, paramObject);
  }
  
  public Player freeze()
  {
    return new PlayerEntity(this);
  }
  
  public String getDisplayName()
  {
    return getString(this.zzauo.zzazr);
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    zza(this.zzauo.zzazr, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return zzcf(this.zzauo.zzazu);
  }
  
  public String getHiResImageUrl()
  {
    return getString(this.zzauo.zzazv);
  }
  
  public Uri getIconImageUri()
  {
    return zzcf(this.zzauo.zzazs);
  }
  
  public String getIconImageUrl()
  {
    return getString(this.zzauo.zzazt);
  }
  
  public long getLastPlayedWithTimestamp()
  {
    if ((!zzce(this.zzauo.zzazy)) || (zzcg(this.zzauo.zzazy))) {
      return -1L;
    }
    return getLong(this.zzauo.zzazy);
  }
  
  public PlayerLevelInfo getLevelInfo()
  {
    return this.zzaud;
  }
  
  public String getName()
  {
    return getString(this.zzauo.name);
  }
  
  public String getPlayerId()
  {
    return getString(this.zzauo.zzazq);
  }
  
  public long getRetrievedTimestamp()
  {
    return getLong(this.zzauo.zzazw);
  }
  
  public String getTitle()
  {
    return getString(this.zzauo.title);
  }
  
  public void getTitle(CharArrayBuffer paramCharArrayBuffer)
  {
    zza(this.zzauo.title, paramCharArrayBuffer);
  }
  
  public boolean hasHiResImage()
  {
    return getHiResImageUri() != null;
  }
  
  public boolean hasIconImage()
  {
    return getIconImageUri() != null;
  }
  
  public int hashCode()
  {
    return PlayerEntity.zzb(this);
  }
  
  public String toString()
  {
    return PlayerEntity.zzc(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((PlayerEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
  
  public String zztE()
  {
    return getString(this.zzauo.zzazP);
  }
  
  public boolean zztF()
  {
    return getBoolean(this.zzauo.zzazO);
  }
  
  public int zztG()
  {
    return getInteger(this.zzauo.zzazx);
  }
  
  public boolean zztH()
  {
    return getBoolean(this.zzauo.zzazH);
  }
  
  public MostRecentGameInfo zztI()
  {
    if (zzcg(this.zzauo.zzazI)) {
      return null;
    }
    return this.zzaup;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\PlayerRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */