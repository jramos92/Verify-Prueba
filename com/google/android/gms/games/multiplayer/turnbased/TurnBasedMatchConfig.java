package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;

public abstract class TurnBasedMatchConfig
{
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static Bundle createAutoMatchCriteria(int paramInt1, int paramInt2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("min_automatch_players", paramInt1);
    localBundle.putInt("max_automatch_players", paramInt2);
    localBundle.putLong("exclusive_bit_mask", paramLong);
    return localBundle;
  }
  
  public abstract Bundle getAutoMatchCriteria();
  
  public abstract String[] getInvitedPlayerIds();
  
  public abstract int getVariant();
  
  public abstract int zzvN();
  
  public static final class Builder
  {
    int zzaAD = -1;
    ArrayList<String> zzaAS = new ArrayList();
    Bundle zzaAT = null;
    int zzaBc = 2;
    
    public Builder addInvitedPlayer(String paramString)
    {
      zzx.zzw(paramString);
      this.zzaAS.add(paramString);
      return this;
    }
    
    public Builder addInvitedPlayers(ArrayList<String> paramArrayList)
    {
      zzx.zzw(paramArrayList);
      this.zzaAS.addAll(paramArrayList);
      return this;
    }
    
    public TurnBasedMatchConfig build()
    {
      return new TurnBasedMatchConfigImpl(this);
    }
    
    public Builder setAutoMatchCriteria(Bundle paramBundle)
    {
      this.zzaAT = paramBundle;
      return this;
    }
    
    public Builder setVariant(int paramInt)
    {
      if ((paramInt == -1) || (paramInt > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
        this.zzaAD = paramInt;
        return this;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\multiplayer\turnbased\TurnBasedMatchConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */