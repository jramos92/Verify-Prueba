package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

public final class LeaderboardRef
  extends zzc
  implements Leaderboard
{
  private final int zzauX;
  private final Game zzazW;
  
  LeaderboardRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.zzauX = paramInt2;
    this.zzazW = new GameRef(paramDataHolder, paramInt1);
  }
  
  public boolean equals(Object paramObject)
  {
    return LeaderboardEntity.zza(this, paramObject);
  }
  
  public String getDisplayName()
  {
    return getString("name");
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    zza("name", paramCharArrayBuffer);
  }
  
  public Game getGame()
  {
    return this.zzazW;
  }
  
  public Uri getIconImageUri()
  {
    return zzcf("board_icon_image_uri");
  }
  
  public String getIconImageUrl()
  {
    return getString("board_icon_image_url");
  }
  
  public String getLeaderboardId()
  {
    return getString("external_leaderboard_id");
  }
  
  public int getScoreOrder()
  {
    return getInteger("score_order");
  }
  
  public ArrayList<LeaderboardVariant> getVariants()
  {
    ArrayList localArrayList = new ArrayList(this.zzauX);
    int i = 0;
    while (i < this.zzauX)
    {
      localArrayList.add(new LeaderboardVariantRef(this.zzabq, this.zzadl + i));
      i += 1;
    }
    return localArrayList;
  }
  
  public int hashCode()
  {
    return LeaderboardEntity.zza(this);
  }
  
  public String toString()
  {
    return LeaderboardEntity.zzb(this);
  }
  
  public Leaderboard zzvG()
  {
    return new LeaderboardEntity(this);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\leaderboard\LeaderboardRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */