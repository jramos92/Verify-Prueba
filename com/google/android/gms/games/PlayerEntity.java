package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.zzmo;

public final class PlayerEntity
  extends GamesDowngradeableSafeParcel
  implements Player
{
  public static final Parcelable.Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();
  private final String mName;
  private final int mVersionCode;
  private final String zzTa;
  private final String zzYf;
  private final String zzajf;
  private final String zzatF;
  private final String zzatG;
  private final long zzatZ;
  private final Uri zzatu;
  private final Uri zzatv;
  private final int zzaua;
  private final long zzaub;
  private final MostRecentGameInfoEntity zzauc;
  private final PlayerLevelInfo zzaud;
  private final boolean zzaue;
  private final boolean zzauf;
  private final String zzaug;
  
  PlayerEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, long paramLong1, int paramInt2, long paramLong2, String paramString3, String paramString4, String paramString5, MostRecentGameInfoEntity paramMostRecentGameInfoEntity, PlayerLevelInfo paramPlayerLevelInfo, boolean paramBoolean1, boolean paramBoolean2, String paramString6, String paramString7)
  {
    this.mVersionCode = paramInt1;
    this.zzYf = paramString1;
    this.zzTa = paramString2;
    this.zzatu = paramUri1;
    this.zzatF = paramString3;
    this.zzatv = paramUri2;
    this.zzatG = paramString4;
    this.zzatZ = paramLong1;
    this.zzaua = paramInt2;
    this.zzaub = paramLong2;
    this.zzajf = paramString5;
    this.zzaue = paramBoolean1;
    this.zzauc = paramMostRecentGameInfoEntity;
    this.zzaud = paramPlayerLevelInfo;
    this.zzauf = paramBoolean2;
    this.zzaug = paramString6;
    this.mName = paramString7;
  }
  
  public PlayerEntity(Player paramPlayer)
  {
    this(paramPlayer, true);
  }
  
  public PlayerEntity(Player paramPlayer, boolean paramBoolean)
  {
    this.mVersionCode = 12;
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = paramPlayer.getPlayerId();
      this.zzYf = ((String)localObject1);
      this.zzTa = paramPlayer.getDisplayName();
      this.zzatu = paramPlayer.getIconImageUri();
      this.zzatF = paramPlayer.getIconImageUrl();
      this.zzatv = paramPlayer.getHiResImageUri();
      this.zzatG = paramPlayer.getHiResImageUrl();
      this.zzatZ = paramPlayer.getRetrievedTimestamp();
      this.zzaua = paramPlayer.zztG();
      this.zzaub = paramPlayer.getLastPlayedWithTimestamp();
      this.zzajf = paramPlayer.getTitle();
      this.zzaue = paramPlayer.zztH();
      localObject1 = paramPlayer.zztI();
      if (localObject1 != null) {
        break label227;
      }
      localObject1 = localObject2;
      label143:
      this.zzauc = ((MostRecentGameInfoEntity)localObject1);
      this.zzaud = paramPlayer.getLevelInfo();
      this.zzauf = paramPlayer.zztF();
      this.zzaug = paramPlayer.zztE();
      this.mName = paramPlayer.getName();
      if (paramBoolean) {
        zzb.zzs(this.zzYf);
      }
      zzb.zzs(this.zzTa);
      if (this.zzatZ <= 0L) {
        break label239;
      }
    }
    label227:
    label239:
    for (paramBoolean = true;; paramBoolean = false)
    {
      zzb.zzZ(paramBoolean);
      return;
      localObject1 = null;
      break;
      localObject1 = new MostRecentGameInfoEntity((MostRecentGameInfo)localObject1);
      break label143;
    }
  }
  
  static boolean zza(Player paramPlayer, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Player)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramPlayer == paramObject);
      paramObject = (Player)paramObject;
      if ((!zzw.equal(((Player)paramObject).getPlayerId(), paramPlayer.getPlayerId())) || (!zzw.equal(((Player)paramObject).getDisplayName(), paramPlayer.getDisplayName())) || (!zzw.equal(Boolean.valueOf(((Player)paramObject).zztF()), Boolean.valueOf(paramPlayer.zztF()))) || (!zzw.equal(((Player)paramObject).getIconImageUri(), paramPlayer.getIconImageUri())) || (!zzw.equal(((Player)paramObject).getHiResImageUri(), paramPlayer.getHiResImageUri())) || (!zzw.equal(Long.valueOf(((Player)paramObject).getRetrievedTimestamp()), Long.valueOf(paramPlayer.getRetrievedTimestamp()))) || (!zzw.equal(((Player)paramObject).getTitle(), paramPlayer.getTitle())) || (!zzw.equal(((Player)paramObject).getLevelInfo(), paramPlayer.getLevelInfo())) || (!zzw.equal(((Player)paramObject).zztE(), paramPlayer.zztE()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((Player)paramObject).getName(), paramPlayer.getName()));
    return false;
  }
  
  static int zzb(Player paramPlayer)
  {
    return zzw.hashCode(new Object[] { paramPlayer.getPlayerId(), paramPlayer.getDisplayName(), Boolean.valueOf(paramPlayer.zztF()), paramPlayer.getIconImageUri(), paramPlayer.getHiResImageUri(), Long.valueOf(paramPlayer.getRetrievedTimestamp()), paramPlayer.getTitle(), paramPlayer.getLevelInfo(), paramPlayer.zztE(), paramPlayer.getName() });
  }
  
  static String zzc(Player paramPlayer)
  {
    return zzw.zzv(paramPlayer).zzg("PlayerId", paramPlayer.getPlayerId()).zzg("DisplayName", paramPlayer.getDisplayName()).zzg("HasDebugAccess", Boolean.valueOf(paramPlayer.zztF())).zzg("IconImageUri", paramPlayer.getIconImageUri()).zzg("IconImageUrl", paramPlayer.getIconImageUrl()).zzg("HiResImageUri", paramPlayer.getHiResImageUri()).zzg("HiResImageUrl", paramPlayer.getHiResImageUrl()).zzg("RetrievedTimestamp", Long.valueOf(paramPlayer.getRetrievedTimestamp())).zzg("Title", paramPlayer.getTitle()).zzg("LevelInfo", paramPlayer.getLevelInfo()).zzg("GamerTag", paramPlayer.zztE()).zzg("Name", paramPlayer.getName()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Player freeze()
  {
    return this;
  }
  
  public String getDisplayName()
  {
    return this.zzTa;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzTa, paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    return this.zzatv;
  }
  
  public String getHiResImageUrl()
  {
    return this.zzatG;
  }
  
  public Uri getIconImageUri()
  {
    return this.zzatu;
  }
  
  public String getIconImageUrl()
  {
    return this.zzatF;
  }
  
  public long getLastPlayedWithTimestamp()
  {
    return this.zzaub;
  }
  
  public PlayerLevelInfo getLevelInfo()
  {
    return this.zzaud;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getPlayerId()
  {
    return this.zzYf;
  }
  
  public long getRetrievedTimestamp()
  {
    return this.zzatZ;
  }
  
  public String getTitle()
  {
    return this.zzajf;
  }
  
  public void getTitle(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzajf, paramCharArrayBuffer);
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
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
    return zzb(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzc(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject2 = null;
    if (!zzoU())
    {
      PlayerEntityCreator.zza(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.zzYf);
    paramParcel.writeString(this.zzTa);
    if (this.zzatu == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.zzatv != null) {
        break label82;
      }
    }
    label82:
    for (Object localObject1 = localObject2;; localObject1 = this.zzatv.toString())
    {
      paramParcel.writeString((String)localObject1);
      paramParcel.writeLong(this.zzatZ);
      return;
      localObject1 = this.zzatu.toString();
      break;
    }
  }
  
  public String zztE()
  {
    return this.zzaug;
  }
  
  public boolean zztF()
  {
    return this.zzauf;
  }
  
  public int zztG()
  {
    return this.zzaua;
  }
  
  public boolean zztH()
  {
    return this.zzaue;
  }
  
  public MostRecentGameInfo zztI()
  {
    return this.zzauc;
  }
  
  static final class PlayerEntityCreatorCompat
    extends PlayerEntityCreator
  {
    public PlayerEntity zzdO(Parcel paramParcel)
    {
      if ((PlayerEntity.zzc(PlayerEntity.zztC())) || (PlayerEntity.zzcV(PlayerEntity.class.getCanonicalName()))) {
        return super.zzdO(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      Object localObject1 = paramParcel.readString();
      Object localObject2 = paramParcel.readString();
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject2 != null) {
          break label107;
        }
      }
      label107:
      for (localObject2 = null;; localObject2 = Uri.parse((String)localObject2))
      {
        return new PlayerEntity(12, str1, str2, (Uri)localObject1, (Uri)localObject2, paramParcel.readLong(), -1, -1L, null, null, null, null, null, true, false, paramParcel.readString(), paramParcel.readString());
        localObject1 = Uri.parse((String)localObject1);
        break;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\PlayerEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */