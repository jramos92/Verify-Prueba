package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzmo;

public final class AchievementEntity
  implements SafeParcelable, Achievement
{
  public static final Parcelable.Creator<AchievementEntity> CREATOR = new AchievementEntityCreator();
  private final String mName;
  private final int mState;
  private final int mVersionCode;
  private final int zzWJ;
  private final String zzaqZ;
  private final long zzauA;
  private final long zzauB;
  private final String zzauq;
  private final Uri zzaur;
  private final String zzaus;
  private final Uri zzaut;
  private final String zzauu;
  private final int zzauv;
  private final String zzauw;
  private final PlayerEntity zzaux;
  private final int zzauy;
  private final String zzauz;
  
  AchievementEntity(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, Uri paramUri1, String paramString4, Uri paramUri2, String paramString5, int paramInt3, String paramString6, PlayerEntity paramPlayerEntity, int paramInt4, int paramInt5, String paramString7, long paramLong1, long paramLong2)
  {
    this.mVersionCode = paramInt1;
    this.zzauq = paramString1;
    this.zzWJ = paramInt2;
    this.mName = paramString2;
    this.zzaqZ = paramString3;
    this.zzaur = paramUri1;
    this.zzaus = paramString4;
    this.zzaut = paramUri2;
    this.zzauu = paramString5;
    this.zzauv = paramInt3;
    this.zzauw = paramString6;
    this.zzaux = paramPlayerEntity;
    this.mState = paramInt4;
    this.zzauy = paramInt5;
    this.zzauz = paramString7;
    this.zzauA = paramLong1;
    this.zzauB = paramLong2;
  }
  
  public AchievementEntity(Achievement paramAchievement)
  {
    this.mVersionCode = 1;
    this.zzauq = paramAchievement.getAchievementId();
    this.zzWJ = paramAchievement.getType();
    this.mName = paramAchievement.getName();
    this.zzaqZ = paramAchievement.getDescription();
    this.zzaur = paramAchievement.getUnlockedImageUri();
    this.zzaus = paramAchievement.getUnlockedImageUrl();
    this.zzaut = paramAchievement.getRevealedImageUri();
    this.zzauu = paramAchievement.getRevealedImageUrl();
    this.zzaux = ((PlayerEntity)paramAchievement.getPlayer().freeze());
    this.mState = paramAchievement.getState();
    this.zzauA = paramAchievement.getLastUpdatedTimestamp();
    this.zzauB = paramAchievement.getXpValue();
    if (paramAchievement.getType() == 1)
    {
      this.zzauv = paramAchievement.getTotalSteps();
      this.zzauw = paramAchievement.getFormattedTotalSteps();
      this.zzauy = paramAchievement.getCurrentSteps();
    }
    for (this.zzauz = paramAchievement.getFormattedCurrentSteps();; this.zzauz = null)
    {
      zzb.zzs(this.zzauq);
      zzb.zzs(this.zzaqZ);
      return;
      this.zzauv = 0;
      this.zzauw = null;
      this.zzauy = 0;
    }
  }
  
  static int zza(Achievement paramAchievement)
  {
    int j;
    int i;
    if (paramAchievement.getType() == 1)
    {
      j = paramAchievement.getCurrentSteps();
      i = paramAchievement.getTotalSteps();
    }
    for (;;)
    {
      return zzw.hashCode(new Object[] { paramAchievement.getAchievementId(), paramAchievement.getName(), Integer.valueOf(paramAchievement.getType()), paramAchievement.getDescription(), Long.valueOf(paramAchievement.getXpValue()), Integer.valueOf(paramAchievement.getState()), Long.valueOf(paramAchievement.getLastUpdatedTimestamp()), paramAchievement.getPlayer(), Integer.valueOf(j), Integer.valueOf(i) });
      i = 0;
      j = 0;
    }
  }
  
  static boolean zza(Achievement paramAchievement, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool2;
    if (!(paramObject instanceof Achievement)) {
      bool2 = false;
    }
    do
    {
      return bool2;
      bool2 = bool3;
    } while (paramAchievement == paramObject);
    paramObject = (Achievement)paramObject;
    boolean bool1;
    if (paramAchievement.getType() == 1)
    {
      bool2 = zzw.equal(Integer.valueOf(((Achievement)paramObject).getCurrentSteps()), Integer.valueOf(paramAchievement.getCurrentSteps()));
      bool1 = zzw.equal(Integer.valueOf(((Achievement)paramObject).getTotalSteps()), Integer.valueOf(paramAchievement.getTotalSteps()));
    }
    for (;;)
    {
      if ((zzw.equal(((Achievement)paramObject).getAchievementId(), paramAchievement.getAchievementId())) && (zzw.equal(((Achievement)paramObject).getName(), paramAchievement.getName())) && (zzw.equal(Integer.valueOf(((Achievement)paramObject).getType()), Integer.valueOf(paramAchievement.getType()))) && (zzw.equal(((Achievement)paramObject).getDescription(), paramAchievement.getDescription())) && (zzw.equal(Long.valueOf(((Achievement)paramObject).getXpValue()), Long.valueOf(paramAchievement.getXpValue()))) && (zzw.equal(Integer.valueOf(((Achievement)paramObject).getState()), Integer.valueOf(paramAchievement.getState()))) && (zzw.equal(Long.valueOf(((Achievement)paramObject).getLastUpdatedTimestamp()), Long.valueOf(paramAchievement.getLastUpdatedTimestamp()))) && (zzw.equal(((Achievement)paramObject).getPlayer(), paramAchievement.getPlayer())) && (bool2))
      {
        bool2 = bool3;
        if (bool1) {
          break;
        }
      }
      return false;
      bool1 = true;
      bool2 = true;
    }
  }
  
  static String zzb(Achievement paramAchievement)
  {
    zzw.zza localzza = zzw.zzv(paramAchievement).zzg("Id", paramAchievement.getAchievementId()).zzg("Type", Integer.valueOf(paramAchievement.getType())).zzg("Name", paramAchievement.getName()).zzg("Description", paramAchievement.getDescription()).zzg("Player", paramAchievement.getPlayer()).zzg("State", Integer.valueOf(paramAchievement.getState()));
    if (paramAchievement.getType() == 1)
    {
      localzza.zzg("CurrentSteps", Integer.valueOf(paramAchievement.getCurrentSteps()));
      localzza.zzg("TotalSteps", Integer.valueOf(paramAchievement.getTotalSteps()));
    }
    return localzza.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Achievement freeze()
  {
    return this;
  }
  
  public String getAchievementId()
  {
    return this.zzauq;
  }
  
  public int getCurrentSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzZ(bool);
      return zztM();
      bool = false;
    }
  }
  
  public String getDescription()
  {
    return this.zzaqZ;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzaqZ, paramCharArrayBuffer);
  }
  
  public String getFormattedCurrentSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzZ(bool);
      return zztN();
      bool = false;
    }
  }
  
  public void getFormattedCurrentSteps(CharArrayBuffer paramCharArrayBuffer)
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzZ(bool);
      zzmo.zzb(this.zzauz, paramCharArrayBuffer);
      return;
      bool = false;
    }
  }
  
  public String getFormattedTotalSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzZ(bool);
      return zztL();
      bool = false;
    }
  }
  
  public void getFormattedTotalSteps(CharArrayBuffer paramCharArrayBuffer)
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzZ(bool);
      zzmo.zzb(this.zzauw, paramCharArrayBuffer);
      return;
      bool = false;
    }
  }
  
  public long getLastUpdatedTimestamp()
  {
    return this.zzauA;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.mName, paramCharArrayBuffer);
  }
  
  public Player getPlayer()
  {
    return this.zzaux;
  }
  
  public Uri getRevealedImageUri()
  {
    return this.zzaut;
  }
  
  public String getRevealedImageUrl()
  {
    return this.zzauu;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public int getTotalSteps()
  {
    boolean bool = true;
    if (getType() == 1) {}
    for (;;)
    {
      zzb.zzZ(bool);
      return zztK();
      bool = false;
    }
  }
  
  public int getType()
  {
    return this.zzWJ;
  }
  
  public Uri getUnlockedImageUri()
  {
    return this.zzaur;
  }
  
  public String getUnlockedImageUrl()
  {
    return this.zzaus;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public long getXpValue()
  {
    return this.zzauB;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AchievementEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public int zztK()
  {
    return this.zzauv;
  }
  
  public String zztL()
  {
    return this.zzauw;
  }
  
  public int zztM()
  {
    return this.zzauy;
  }
  
  public String zztN()
  {
    return this.zzauz;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\achievement\AchievementEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */