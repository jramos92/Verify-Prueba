package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzmo;

public final class GameEntity
  extends GamesDowngradeableSafeParcel
  implements Game
{
  public static final Parcelable.Creator<GameEntity> CREATOR = new GameEntityCreatorCompat();
  private final int mVersionCode;
  private final boolean zzBa;
  private final String zzTa;
  private final String zzUM;
  private final String zzaqZ;
  private final int zzatA;
  private final int zzatB;
  private final int zzatC;
  private final boolean zzatD;
  private final boolean zzatE;
  private final String zzatF;
  private final String zzatG;
  private final String zzatH;
  private final boolean zzatI;
  private final boolean zzatJ;
  private final String zzatK;
  private final boolean zzatL;
  private final String zzatr;
  private final String zzats;
  private final String zzatt;
  private final Uri zzatu;
  private final Uri zzatv;
  private final Uri zzatw;
  private final boolean zzatx;
  private final boolean zzaty;
  private final String zzatz;
  
  GameEntity(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Uri paramUri1, Uri paramUri2, Uri paramUri3, boolean paramBoolean1, boolean paramBoolean2, String paramString7, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean3, boolean paramBoolean4, String paramString8, String paramString9, String paramString10, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, String paramString11, boolean paramBoolean8)
  {
    this.mVersionCode = paramInt1;
    this.zzUM = paramString1;
    this.zzTa = paramString2;
    this.zzatr = paramString3;
    this.zzats = paramString4;
    this.zzaqZ = paramString5;
    this.zzatt = paramString6;
    this.zzatu = paramUri1;
    this.zzatF = paramString8;
    this.zzatv = paramUri2;
    this.zzatG = paramString9;
    this.zzatw = paramUri3;
    this.zzatH = paramString10;
    this.zzatx = paramBoolean1;
    this.zzaty = paramBoolean2;
    this.zzatz = paramString7;
    this.zzatA = paramInt2;
    this.zzatB = paramInt3;
    this.zzatC = paramInt4;
    this.zzatD = paramBoolean3;
    this.zzatE = paramBoolean4;
    this.zzBa = paramBoolean5;
    this.zzatI = paramBoolean6;
    this.zzatJ = paramBoolean7;
    this.zzatK = paramString11;
    this.zzatL = paramBoolean8;
  }
  
  public GameEntity(Game paramGame)
  {
    this.mVersionCode = 7;
    this.zzUM = paramGame.getApplicationId();
    this.zzatr = paramGame.getPrimaryCategory();
    this.zzats = paramGame.getSecondaryCategory();
    this.zzaqZ = paramGame.getDescription();
    this.zzatt = paramGame.getDeveloperName();
    this.zzTa = paramGame.getDisplayName();
    this.zzatu = paramGame.getIconImageUri();
    this.zzatF = paramGame.getIconImageUrl();
    this.zzatv = paramGame.getHiResImageUri();
    this.zzatG = paramGame.getHiResImageUrl();
    this.zzatw = paramGame.getFeaturedImageUri();
    this.zzatH = paramGame.getFeaturedImageUrl();
    this.zzatx = paramGame.zztx();
    this.zzaty = paramGame.zztz();
    this.zzatz = paramGame.zztA();
    this.zzatA = paramGame.zztB();
    this.zzatB = paramGame.getAchievementTotalCount();
    this.zzatC = paramGame.getLeaderboardCount();
    this.zzatD = paramGame.isRealTimeMultiplayerEnabled();
    this.zzatE = paramGame.isTurnBasedMultiplayerEnabled();
    this.zzBa = paramGame.isMuted();
    this.zzatI = paramGame.zzty();
    this.zzatJ = paramGame.areSnapshotsEnabled();
    this.zzatK = paramGame.getThemeColor();
    this.zzatL = paramGame.hasGamepadSupport();
  }
  
  static int zza(Game paramGame)
  {
    return zzw.hashCode(new Object[] { paramGame.getApplicationId(), paramGame.getDisplayName(), paramGame.getPrimaryCategory(), paramGame.getSecondaryCategory(), paramGame.getDescription(), paramGame.getDeveloperName(), paramGame.getIconImageUri(), paramGame.getHiResImageUri(), paramGame.getFeaturedImageUri(), Boolean.valueOf(paramGame.zztx()), Boolean.valueOf(paramGame.zztz()), paramGame.zztA(), Integer.valueOf(paramGame.zztB()), Integer.valueOf(paramGame.getAchievementTotalCount()), Integer.valueOf(paramGame.getLeaderboardCount()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(paramGame.isMuted()), Boolean.valueOf(paramGame.zzty()), Boolean.valueOf(paramGame.areSnapshotsEnabled()), paramGame.getThemeColor(), Boolean.valueOf(paramGame.hasGamepadSupport()) });
  }
  
  static boolean zza(Game paramGame, Object paramObject)
  {
    boolean bool2 = true;
    if (!(paramObject instanceof Game)) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (paramGame == paramObject);
    paramObject = (Game)paramObject;
    boolean bool3;
    if ((zzw.equal(((Game)paramObject).getApplicationId(), paramGame.getApplicationId())) && (zzw.equal(((Game)paramObject).getDisplayName(), paramGame.getDisplayName())) && (zzw.equal(((Game)paramObject).getPrimaryCategory(), paramGame.getPrimaryCategory())) && (zzw.equal(((Game)paramObject).getSecondaryCategory(), paramGame.getSecondaryCategory())) && (zzw.equal(((Game)paramObject).getDescription(), paramGame.getDescription())) && (zzw.equal(((Game)paramObject).getDeveloperName(), paramGame.getDeveloperName())) && (zzw.equal(((Game)paramObject).getIconImageUri(), paramGame.getIconImageUri())) && (zzw.equal(((Game)paramObject).getHiResImageUri(), paramGame.getHiResImageUri())) && (zzw.equal(((Game)paramObject).getFeaturedImageUri(), paramGame.getFeaturedImageUri())) && (zzw.equal(Boolean.valueOf(((Game)paramObject).zztx()), Boolean.valueOf(paramGame.zztx()))) && (zzw.equal(Boolean.valueOf(((Game)paramObject).zztz()), Boolean.valueOf(paramGame.zztz()))) && (zzw.equal(((Game)paramObject).zztA(), paramGame.zztA())) && (zzw.equal(Integer.valueOf(((Game)paramObject).zztB()), Integer.valueOf(paramGame.zztB()))) && (zzw.equal(Integer.valueOf(((Game)paramObject).getAchievementTotalCount()), Integer.valueOf(paramGame.getAchievementTotalCount()))) && (zzw.equal(Integer.valueOf(((Game)paramObject).getLeaderboardCount()), Integer.valueOf(paramGame.getLeaderboardCount()))) && (zzw.equal(Boolean.valueOf(((Game)paramObject).isRealTimeMultiplayerEnabled()), Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled()))))
    {
      bool3 = ((Game)paramObject).isTurnBasedMultiplayerEnabled();
      if ((!paramGame.isTurnBasedMultiplayerEnabled()) || (!zzw.equal(Boolean.valueOf(((Game)paramObject).isMuted()), Boolean.valueOf(paramGame.isMuted()))) || (!zzw.equal(Boolean.valueOf(((Game)paramObject).zzty()), Boolean.valueOf(paramGame.zzty())))) {
        break label501;
      }
    }
    label501:
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((zzw.equal(Boolean.valueOf(bool3), Boolean.valueOf(bool1))) && (zzw.equal(Boolean.valueOf(((Game)paramObject).areSnapshotsEnabled()), Boolean.valueOf(paramGame.areSnapshotsEnabled()))) && (zzw.equal(((Game)paramObject).getThemeColor(), paramGame.getThemeColor())))
      {
        bool1 = bool2;
        if (zzw.equal(Boolean.valueOf(((Game)paramObject).hasGamepadSupport()), Boolean.valueOf(paramGame.hasGamepadSupport()))) {
          break;
        }
      }
      return false;
    }
  }
  
  static String zzb(Game paramGame)
  {
    return zzw.zzv(paramGame).zzg("ApplicationId", paramGame.getApplicationId()).zzg("DisplayName", paramGame.getDisplayName()).zzg("PrimaryCategory", paramGame.getPrimaryCategory()).zzg("SecondaryCategory", paramGame.getSecondaryCategory()).zzg("Description", paramGame.getDescription()).zzg("DeveloperName", paramGame.getDeveloperName()).zzg("IconImageUri", paramGame.getIconImageUri()).zzg("IconImageUrl", paramGame.getIconImageUrl()).zzg("HiResImageUri", paramGame.getHiResImageUri()).zzg("HiResImageUrl", paramGame.getHiResImageUrl()).zzg("FeaturedImageUri", paramGame.getFeaturedImageUri()).zzg("FeaturedImageUrl", paramGame.getFeaturedImageUrl()).zzg("PlayEnabledGame", Boolean.valueOf(paramGame.zztx())).zzg("InstanceInstalled", Boolean.valueOf(paramGame.zztz())).zzg("InstancePackageName", paramGame.zztA()).zzg("AchievementTotalCount", Integer.valueOf(paramGame.getAchievementTotalCount())).zzg("LeaderboardCount", Integer.valueOf(paramGame.getLeaderboardCount())).zzg("RealTimeMultiplayerEnabled", Boolean.valueOf(paramGame.isRealTimeMultiplayerEnabled())).zzg("TurnBasedMultiplayerEnabled", Boolean.valueOf(paramGame.isTurnBasedMultiplayerEnabled())).zzg("AreSnapshotsEnabled", Boolean.valueOf(paramGame.areSnapshotsEnabled())).zzg("ThemeColor", paramGame.getThemeColor()).zzg("HasGamepadSupport", Boolean.valueOf(paramGame.hasGamepadSupport())).toString();
  }
  
  public boolean areSnapshotsEnabled()
  {
    return this.zzatJ;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Game freeze()
  {
    return this;
  }
  
  public int getAchievementTotalCount()
  {
    return this.zzatB;
  }
  
  public String getApplicationId()
  {
    return this.zzUM;
  }
  
  public String getDescription()
  {
    return this.zzaqZ;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzaqZ, paramCharArrayBuffer);
  }
  
  public String getDeveloperName()
  {
    return this.zzatt;
  }
  
  public void getDeveloperName(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzatt, paramCharArrayBuffer);
  }
  
  public String getDisplayName()
  {
    return this.zzTa;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzTa, paramCharArrayBuffer);
  }
  
  public Uri getFeaturedImageUri()
  {
    return this.zzatw;
  }
  
  public String getFeaturedImageUrl()
  {
    return this.zzatH;
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
  
  public int getLeaderboardCount()
  {
    return this.zzatC;
  }
  
  public String getPrimaryCategory()
  {
    return this.zzatr;
  }
  
  public String getSecondaryCategory()
  {
    return this.zzats;
  }
  
  public String getThemeColor()
  {
    return this.zzatK;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean hasGamepadSupport()
  {
    return this.zzatL;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isMuted()
  {
    return this.zzBa;
  }
  
  public boolean isRealTimeMultiplayerEnabled()
  {
    return this.zzatD;
  }
  
  public boolean isTurnBasedMultiplayerEnabled()
  {
    return this.zzatE;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    Object localObject2 = null;
    if (!zzoU())
    {
      GameEntityCreator.zza(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.zzUM);
    paramParcel.writeString(this.zzTa);
    paramParcel.writeString(this.zzatr);
    paramParcel.writeString(this.zzats);
    paramParcel.writeString(this.zzaqZ);
    paramParcel.writeString(this.zzatt);
    Object localObject1;
    if (this.zzatu == null)
    {
      localObject1 = null;
      paramParcel.writeString((String)localObject1);
      if (this.zzatv != null) {
        break label189;
      }
      localObject1 = null;
      label93:
      paramParcel.writeString((String)localObject1);
      if (this.zzatw != null) {
        break label201;
      }
      localObject1 = localObject2;
      label110:
      paramParcel.writeString((String)localObject1);
      if (!this.zzatx) {
        break label213;
      }
      paramInt = 1;
      label125:
      paramParcel.writeInt(paramInt);
      if (!this.zzaty) {
        break label218;
      }
    }
    label189:
    label201:
    label213:
    label218:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.zzatz);
      paramParcel.writeInt(this.zzatA);
      paramParcel.writeInt(this.zzatB);
      paramParcel.writeInt(this.zzatC);
      return;
      localObject1 = this.zzatu.toString();
      break;
      localObject1 = this.zzatv.toString();
      break label93;
      localObject1 = this.zzatw.toString();
      break label110;
      paramInt = 0;
      break label125;
    }
  }
  
  public String zztA()
  {
    return this.zzatz;
  }
  
  public int zztB()
  {
    return this.zzatA;
  }
  
  public boolean zztx()
  {
    return this.zzatx;
  }
  
  public boolean zzty()
  {
    return this.zzatI;
  }
  
  public boolean zztz()
  {
    return this.zzaty;
  }
  
  static final class GameEntityCreatorCompat
    extends GameEntityCreator
  {
    public GameEntity zzdN(Parcel paramParcel)
    {
      if ((GameEntity.zzc(GameEntity.zztC())) || (GameEntity.zzcV(GameEntity.class.getCanonicalName()))) {
        return super.zzdN(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      String str3 = paramParcel.readString();
      String str4 = paramParcel.readString();
      String str5 = paramParcel.readString();
      String str6 = paramParcel.readString();
      Object localObject1 = paramParcel.readString();
      Object localObject2;
      label90:
      Object localObject3;
      label104:
      boolean bool1;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = paramParcel.readString();
        if (localObject2 != null) {
          break label188;
        }
        localObject2 = null;
        localObject3 = paramParcel.readString();
        if (localObject3 != null) {
          break label198;
        }
        localObject3 = null;
        if (paramParcel.readInt() <= 0) {
          break label208;
        }
        bool1 = true;
        label113:
        if (paramParcel.readInt() <= 0) {
          break label213;
        }
      }
      label188:
      label198:
      label208:
      label213:
      for (boolean bool2 = true;; bool2 = false)
      {
        return new GameEntity(7, str1, str2, str3, str4, str5, str6, (Uri)localObject1, (Uri)localObject2, (Uri)localObject3, bool1, bool2, paramParcel.readString(), paramParcel.readInt(), paramParcel.readInt(), paramParcel.readInt(), false, false, null, null, null, false, false, false, null, false);
        localObject1 = Uri.parse((String)localObject1);
        break;
        localObject2 = Uri.parse((String)localObject2);
        break label90;
        localObject3 = Uri.parse((String)localObject3);
        break label104;
        bool1 = false;
        break label113;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\GameEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */