package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzmo;
import java.util.ArrayList;

public final class LeaderboardEntity
  implements Leaderboard
{
  private final String zzTa;
  private final String zzatF;
  private final Uri zzatu;
  private final String zzazT;
  private final int zzazU;
  private final ArrayList<LeaderboardVariantEntity> zzazV;
  private final Game zzazW;
  
  public LeaderboardEntity(Leaderboard paramLeaderboard)
  {
    this.zzazT = paramLeaderboard.getLeaderboardId();
    this.zzTa = paramLeaderboard.getDisplayName();
    this.zzatu = paramLeaderboard.getIconImageUri();
    this.zzatF = paramLeaderboard.getIconImageUrl();
    this.zzazU = paramLeaderboard.getScoreOrder();
    Object localObject = paramLeaderboard.getGame();
    if (localObject == null) {}
    for (localObject = null;; localObject = new GameEntity((Game)localObject))
    {
      this.zzazW = ((Game)localObject);
      paramLeaderboard = paramLeaderboard.getVariants();
      int j = paramLeaderboard.size();
      this.zzazV = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        this.zzazV.add((LeaderboardVariantEntity)((LeaderboardVariant)paramLeaderboard.get(i)).freeze());
        i += 1;
      }
    }
  }
  
  static int zza(Leaderboard paramLeaderboard)
  {
    return zzw.hashCode(new Object[] { paramLeaderboard.getLeaderboardId(), paramLeaderboard.getDisplayName(), paramLeaderboard.getIconImageUri(), Integer.valueOf(paramLeaderboard.getScoreOrder()), paramLeaderboard.getVariants() });
  }
  
  static boolean zza(Leaderboard paramLeaderboard, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Leaderboard)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramLeaderboard == paramObject);
      paramObject = (Leaderboard)paramObject;
      if ((!zzw.equal(((Leaderboard)paramObject).getLeaderboardId(), paramLeaderboard.getLeaderboardId())) || (!zzw.equal(((Leaderboard)paramObject).getDisplayName(), paramLeaderboard.getDisplayName())) || (!zzw.equal(((Leaderboard)paramObject).getIconImageUri(), paramLeaderboard.getIconImageUri())) || (!zzw.equal(Integer.valueOf(((Leaderboard)paramObject).getScoreOrder()), Integer.valueOf(paramLeaderboard.getScoreOrder())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((Leaderboard)paramObject).getVariants(), paramLeaderboard.getVariants()));
    return false;
  }
  
  static String zzb(Leaderboard paramLeaderboard)
  {
    return zzw.zzv(paramLeaderboard).zzg("LeaderboardId", paramLeaderboard.getLeaderboardId()).zzg("DisplayName", paramLeaderboard.getDisplayName()).zzg("IconImageUri", paramLeaderboard.getIconImageUri()).zzg("IconImageUrl", paramLeaderboard.getIconImageUrl()).zzg("ScoreOrder", Integer.valueOf(paramLeaderboard.getScoreOrder())).zzg("Variants", paramLeaderboard.getVariants()).toString();
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public String getDisplayName()
  {
    return this.zzTa;
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzTa, paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.zzazW;
  }
  
  public Uri getIconImageUri()
  {
    return this.zzatu;
  }
  
  public String getIconImageUrl()
  {
    return this.zzatF;
  }
  
  public String getLeaderboardId()
  {
    return this.zzazT;
  }
  
  public int getScoreOrder()
  {
    return this.zzazU;
  }
  
  public ArrayList<LeaderboardVariant> getVariants()
  {
    return new ArrayList(this.zzazV);
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
  
  public Leaderboard zzvG()
  {
    return this;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\leaderboard\LeaderboardEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */