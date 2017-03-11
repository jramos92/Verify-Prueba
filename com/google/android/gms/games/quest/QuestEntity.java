package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzmo;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity
  implements SafeParcelable, Quest
{
  public static final Parcelable.Creator<QuestEntity> CREATOR = new QuestEntityCreator();
  private final String mName;
  private final int mState;
  private final int mVersionCode;
  private final int zzWJ;
  private final GameEntity zzaAy;
  private final String zzaBq;
  private final long zzaBr;
  private final Uri zzaBs;
  private final String zzaBt;
  private final long zzaBu;
  private final Uri zzaBv;
  private final String zzaBw;
  private final long zzaBx;
  private final long zzaBy;
  private final ArrayList<MilestoneEntity> zzaBz;
  private final String zzaqZ;
  private final long zzauA;
  
  QuestEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, long paramLong1, Uri paramUri1, String paramString2, String paramString3, long paramLong2, long paramLong3, Uri paramUri2, String paramString4, String paramString5, long paramLong4, long paramLong5, int paramInt2, int paramInt3, ArrayList<MilestoneEntity> paramArrayList)
  {
    this.mVersionCode = paramInt1;
    this.zzaAy = paramGameEntity;
    this.zzaBq = paramString1;
    this.zzaBr = paramLong1;
    this.zzaBs = paramUri1;
    this.zzaBt = paramString2;
    this.zzaqZ = paramString3;
    this.zzaBu = paramLong2;
    this.zzauA = paramLong3;
    this.zzaBv = paramUri2;
    this.zzaBw = paramString4;
    this.mName = paramString5;
    this.zzaBx = paramLong4;
    this.zzaBy = paramLong5;
    this.mState = paramInt2;
    this.zzWJ = paramInt3;
    this.zzaBz = paramArrayList;
  }
  
  public QuestEntity(Quest paramQuest)
  {
    this.mVersionCode = 2;
    this.zzaAy = new GameEntity(paramQuest.getGame());
    this.zzaBq = paramQuest.getQuestId();
    this.zzaBr = paramQuest.getAcceptedTimestamp();
    this.zzaqZ = paramQuest.getDescription();
    this.zzaBs = paramQuest.getBannerImageUri();
    this.zzaBt = paramQuest.getBannerImageUrl();
    this.zzaBu = paramQuest.getEndTimestamp();
    this.zzaBv = paramQuest.getIconImageUri();
    this.zzaBw = paramQuest.getIconImageUrl();
    this.zzauA = paramQuest.getLastUpdatedTimestamp();
    this.mName = paramQuest.getName();
    this.zzaBx = paramQuest.zzvQ();
    this.zzaBy = paramQuest.getStartTimestamp();
    this.mState = paramQuest.getState();
    this.zzWJ = paramQuest.getType();
    paramQuest = paramQuest.zzvP();
    int j = paramQuest.size();
    this.zzaBz = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      this.zzaBz.add((MilestoneEntity)((Milestone)paramQuest.get(i)).freeze());
      i += 1;
    }
  }
  
  static int zza(Quest paramQuest)
  {
    return zzw.hashCode(new Object[] { paramQuest.getGame(), paramQuest.getQuestId(), Long.valueOf(paramQuest.getAcceptedTimestamp()), paramQuest.getBannerImageUri(), paramQuest.getDescription(), Long.valueOf(paramQuest.getEndTimestamp()), paramQuest.getIconImageUri(), Long.valueOf(paramQuest.getLastUpdatedTimestamp()), paramQuest.zzvP(), paramQuest.getName(), Long.valueOf(paramQuest.zzvQ()), Long.valueOf(paramQuest.getStartTimestamp()), Integer.valueOf(paramQuest.getState()) });
  }
  
  static boolean zza(Quest paramQuest, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Quest)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramQuest == paramObject);
      paramObject = (Quest)paramObject;
      if ((!zzw.equal(((Quest)paramObject).getGame(), paramQuest.getGame())) || (!zzw.equal(((Quest)paramObject).getQuestId(), paramQuest.getQuestId())) || (!zzw.equal(Long.valueOf(((Quest)paramObject).getAcceptedTimestamp()), Long.valueOf(paramQuest.getAcceptedTimestamp()))) || (!zzw.equal(((Quest)paramObject).getBannerImageUri(), paramQuest.getBannerImageUri())) || (!zzw.equal(((Quest)paramObject).getDescription(), paramQuest.getDescription())) || (!zzw.equal(Long.valueOf(((Quest)paramObject).getEndTimestamp()), Long.valueOf(paramQuest.getEndTimestamp()))) || (!zzw.equal(((Quest)paramObject).getIconImageUri(), paramQuest.getIconImageUri())) || (!zzw.equal(Long.valueOf(((Quest)paramObject).getLastUpdatedTimestamp()), Long.valueOf(paramQuest.getLastUpdatedTimestamp()))) || (!zzw.equal(((Quest)paramObject).zzvP(), paramQuest.zzvP())) || (!zzw.equal(((Quest)paramObject).getName(), paramQuest.getName())) || (!zzw.equal(Long.valueOf(((Quest)paramObject).zzvQ()), Long.valueOf(paramQuest.zzvQ()))) || (!zzw.equal(Long.valueOf(((Quest)paramObject).getStartTimestamp()), Long.valueOf(paramQuest.getStartTimestamp())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(Integer.valueOf(((Quest)paramObject).getState()), Integer.valueOf(paramQuest.getState())));
    return false;
  }
  
  static String zzb(Quest paramQuest)
  {
    return zzw.zzv(paramQuest).zzg("Game", paramQuest.getGame()).zzg("QuestId", paramQuest.getQuestId()).zzg("AcceptedTimestamp", Long.valueOf(paramQuest.getAcceptedTimestamp())).zzg("BannerImageUri", paramQuest.getBannerImageUri()).zzg("BannerImageUrl", paramQuest.getBannerImageUrl()).zzg("Description", paramQuest.getDescription()).zzg("EndTimestamp", Long.valueOf(paramQuest.getEndTimestamp())).zzg("IconImageUri", paramQuest.getIconImageUri()).zzg("IconImageUrl", paramQuest.getIconImageUrl()).zzg("LastUpdatedTimestamp", Long.valueOf(paramQuest.getLastUpdatedTimestamp())).zzg("Milestones", paramQuest.zzvP()).zzg("Name", paramQuest.getName()).zzg("NotifyTimestamp", Long.valueOf(paramQuest.zzvQ())).zzg("StartTimestamp", Long.valueOf(paramQuest.getStartTimestamp())).zzg("State", Integer.valueOf(paramQuest.getState())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Quest freeze()
  {
    return this;
  }
  
  public long getAcceptedTimestamp()
  {
    return this.zzaBr;
  }
  
  public Uri getBannerImageUri()
  {
    return this.zzaBs;
  }
  
  public String getBannerImageUrl()
  {
    return this.zzaBt;
  }
  
  public Milestone getCurrentMilestone()
  {
    return (Milestone)zzvP().get(0);
  }
  
  public String getDescription()
  {
    return this.zzaqZ;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzaqZ, paramCharArrayBuffer);
  }
  
  public long getEndTimestamp()
  {
    return this.zzaBu;
  }
  
  public Game getGame()
  {
    return this.zzaAy;
  }
  
  public Uri getIconImageUri()
  {
    return this.zzaBv;
  }
  
  public String getIconImageUrl()
  {
    return this.zzaBw;
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
  
  public String getQuestId()
  {
    return this.zzaBq;
  }
  
  public long getStartTimestamp()
  {
    return this.zzaBy;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public int getType()
  {
    return this.zzWJ;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isEndingSoon()
  {
    return this.zzaBx <= System.currentTimeMillis() + 1800000L;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    QuestEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public List<Milestone> zzvP()
  {
    return new ArrayList(this.zzaBz);
  }
  
  public long zzvQ()
  {
    return this.zzaBx;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\quest\QuestEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */