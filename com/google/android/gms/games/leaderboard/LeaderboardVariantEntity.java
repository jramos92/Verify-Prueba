package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;

public final class LeaderboardVariantEntity
  implements LeaderboardVariant
{
  private final int zzaAl;
  private final int zzaAm;
  private final boolean zzaAn;
  private final long zzaAo;
  private final String zzaAp;
  private final long zzaAq;
  private final String zzaAr;
  private final String zzaAs;
  private final long zzaAt;
  private final String zzaAu;
  private final String zzaAv;
  private final String zzaAw;
  
  public LeaderboardVariantEntity(LeaderboardVariant paramLeaderboardVariant)
  {
    this.zzaAl = paramLeaderboardVariant.getTimeSpan();
    this.zzaAm = paramLeaderboardVariant.getCollection();
    this.zzaAn = paramLeaderboardVariant.hasPlayerInfo();
    this.zzaAo = paramLeaderboardVariant.getRawPlayerScore();
    this.zzaAp = paramLeaderboardVariant.getDisplayPlayerScore();
    this.zzaAq = paramLeaderboardVariant.getPlayerRank();
    this.zzaAr = paramLeaderboardVariant.getDisplayPlayerRank();
    this.zzaAs = paramLeaderboardVariant.getPlayerScoreTag();
    this.zzaAt = paramLeaderboardVariant.getNumScores();
    this.zzaAu = paramLeaderboardVariant.zzvJ();
    this.zzaAv = paramLeaderboardVariant.zzvK();
    this.zzaAw = paramLeaderboardVariant.zzvL();
  }
  
  static int zza(LeaderboardVariant paramLeaderboardVariant)
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(paramLeaderboardVariant.getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getCollection()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()), paramLeaderboardVariant.getDisplayPlayerScore(), Long.valueOf(paramLeaderboardVariant.getPlayerRank()), paramLeaderboardVariant.getDisplayPlayerRank(), Long.valueOf(paramLeaderboardVariant.getNumScores()), paramLeaderboardVariant.zzvJ(), paramLeaderboardVariant.zzvL(), paramLeaderboardVariant.zzvK() });
  }
  
  static boolean zza(LeaderboardVariant paramLeaderboardVariant, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof LeaderboardVariant)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramLeaderboardVariant == paramObject);
      paramObject = (LeaderboardVariant)paramObject;
      if ((!zzw.equal(Integer.valueOf(((LeaderboardVariant)paramObject).getTimeSpan()), Integer.valueOf(paramLeaderboardVariant.getTimeSpan()))) || (!zzw.equal(Integer.valueOf(((LeaderboardVariant)paramObject).getCollection()), Integer.valueOf(paramLeaderboardVariant.getCollection()))) || (!zzw.equal(Boolean.valueOf(((LeaderboardVariant)paramObject).hasPlayerInfo()), Boolean.valueOf(paramLeaderboardVariant.hasPlayerInfo()))) || (!zzw.equal(Long.valueOf(((LeaderboardVariant)paramObject).getRawPlayerScore()), Long.valueOf(paramLeaderboardVariant.getRawPlayerScore()))) || (!zzw.equal(((LeaderboardVariant)paramObject).getDisplayPlayerScore(), paramLeaderboardVariant.getDisplayPlayerScore())) || (!zzw.equal(Long.valueOf(((LeaderboardVariant)paramObject).getPlayerRank()), Long.valueOf(paramLeaderboardVariant.getPlayerRank()))) || (!zzw.equal(((LeaderboardVariant)paramObject).getDisplayPlayerRank(), paramLeaderboardVariant.getDisplayPlayerRank())) || (!zzw.equal(Long.valueOf(((LeaderboardVariant)paramObject).getNumScores()), Long.valueOf(paramLeaderboardVariant.getNumScores()))) || (!zzw.equal(((LeaderboardVariant)paramObject).zzvJ(), paramLeaderboardVariant.zzvJ())) || (!zzw.equal(((LeaderboardVariant)paramObject).zzvL(), paramLeaderboardVariant.zzvL()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((LeaderboardVariant)paramObject).zzvK(), paramLeaderboardVariant.zzvK()));
    return false;
  }
  
  static String zzb(LeaderboardVariant paramLeaderboardVariant)
  {
    zzw.zza localzza = zzw.zzv(paramLeaderboardVariant).zzg("TimeSpan", TimeSpan.zzfZ(paramLeaderboardVariant.getTimeSpan())).zzg("Collection", LeaderboardCollection.zzfZ(paramLeaderboardVariant.getCollection()));
    if (paramLeaderboardVariant.hasPlayerInfo())
    {
      localObject = Long.valueOf(paramLeaderboardVariant.getRawPlayerScore());
      localzza = localzza.zzg("RawPlayerScore", localObject);
      if (!paramLeaderboardVariant.hasPlayerInfo()) {
        break label191;
      }
      localObject = paramLeaderboardVariant.getDisplayPlayerScore();
      label76:
      localzza = localzza.zzg("DisplayPlayerScore", localObject);
      if (!paramLeaderboardVariant.hasPlayerInfo()) {
        break label197;
      }
      localObject = Long.valueOf(paramLeaderboardVariant.getPlayerRank());
      label103:
      localzza = localzza.zzg("PlayerRank", localObject);
      if (!paramLeaderboardVariant.hasPlayerInfo()) {
        break label203;
      }
    }
    label191:
    label197:
    label203:
    for (Object localObject = paramLeaderboardVariant.getDisplayPlayerRank();; localObject = "none")
    {
      return localzza.zzg("DisplayPlayerRank", localObject).zzg("NumScores", Long.valueOf(paramLeaderboardVariant.getNumScores())).zzg("TopPageNextToken", paramLeaderboardVariant.zzvJ()).zzg("WindowPageNextToken", paramLeaderboardVariant.zzvL()).zzg("WindowPagePrevToken", paramLeaderboardVariant.zzvK()).toString();
      localObject = "none";
      break;
      localObject = "none";
      break label76;
      localObject = "none";
      break label103;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public int getCollection()
  {
    return this.zzaAm;
  }
  
  public String getDisplayPlayerRank()
  {
    return this.zzaAr;
  }
  
  public String getDisplayPlayerScore()
  {
    return this.zzaAp;
  }
  
  public long getNumScores()
  {
    return this.zzaAt;
  }
  
  public long getPlayerRank()
  {
    return this.zzaAq;
  }
  
  public String getPlayerScoreTag()
  {
    return this.zzaAs;
  }
  
  public long getRawPlayerScore()
  {
    return this.zzaAo;
  }
  
  public int getTimeSpan()
  {
    return this.zzaAl;
  }
  
  public boolean hasPlayerInfo()
  {
    return this.zzaAn;
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
  
  public String zzvJ()
  {
    return this.zzaAu;
  }
  
  public String zzvK()
  {
    return this.zzaAv;
  }
  
  public String zzvL()
  {
    return this.zzaAw;
  }
  
  public LeaderboardVariant zzvM()
  {
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\leaderboard\LeaderboardVariantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */