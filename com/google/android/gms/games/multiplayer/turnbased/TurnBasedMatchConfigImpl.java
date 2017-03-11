package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import java.util.ArrayList;

public final class TurnBasedMatchConfigImpl
  extends TurnBasedMatchConfig
{
  private final int zzaAD;
  private final Bundle zzaAT;
  private final String[] zzaAU;
  private final int zzaBc;
  
  TurnBasedMatchConfigImpl(TurnBasedMatchConfig.Builder paramBuilder)
  {
    this.zzaAD = paramBuilder.zzaAD;
    this.zzaBc = paramBuilder.zzaBc;
    this.zzaAT = paramBuilder.zzaAT;
    int i = paramBuilder.zzaAS.size();
    this.zzaAU = ((String[])paramBuilder.zzaAS.toArray(new String[i]));
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.zzaAT;
  }
  
  public String[] getInvitedPlayerIds()
  {
    return this.zzaAU;
  }
  
  public int getVariant()
  {
    return this.zzaAD;
  }
  
  public int zzvN()
  {
    return this.zzaBc;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\multiplayer\turnbased\TurnBasedMatchConfigImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */