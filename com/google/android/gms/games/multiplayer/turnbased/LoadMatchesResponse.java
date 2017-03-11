package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse
{
  private final InvitationBuffer zzaAY;
  private final TurnBasedMatchBuffer zzaAZ;
  private final TurnBasedMatchBuffer zzaBa;
  private final TurnBasedMatchBuffer zzaBb;
  
  public LoadMatchesResponse(Bundle paramBundle)
  {
    DataHolder localDataHolder = zza(paramBundle, 0);
    if (localDataHolder != null)
    {
      this.zzaAY = new InvitationBuffer(localDataHolder);
      localDataHolder = zza(paramBundle, 1);
      if (localDataHolder == null) {
        break label101;
      }
      this.zzaAZ = new TurnBasedMatchBuffer(localDataHolder);
      label48:
      localDataHolder = zza(paramBundle, 2);
      if (localDataHolder == null) {
        break label109;
      }
    }
    label101:
    label109:
    for (this.zzaBa = new TurnBasedMatchBuffer(localDataHolder);; this.zzaBa = null)
    {
      paramBundle = zza(paramBundle, 3);
      if (paramBundle == null) {
        break label117;
      }
      this.zzaBb = new TurnBasedMatchBuffer(paramBundle);
      return;
      this.zzaAY = null;
      break;
      this.zzaAZ = null;
      break label48;
    }
    label117:
    this.zzaBb = null;
  }
  
  private static DataHolder zza(Bundle paramBundle, int paramInt)
  {
    String str = TurnBasedMatchTurnStatus.zzfZ(paramInt);
    if (!paramBundle.containsKey(str)) {
      return null;
    }
    return (DataHolder)paramBundle.getParcelable(str);
  }
  
  @Deprecated
  public void close()
  {
    release();
  }
  
  public TurnBasedMatchBuffer getCompletedMatches()
  {
    return this.zzaBb;
  }
  
  public InvitationBuffer getInvitations()
  {
    return this.zzaAY;
  }
  
  public TurnBasedMatchBuffer getMyTurnMatches()
  {
    return this.zzaAZ;
  }
  
  public TurnBasedMatchBuffer getTheirTurnMatches()
  {
    return this.zzaBa;
  }
  
  public boolean hasData()
  {
    if ((this.zzaAY != null) && (this.zzaAY.getCount() > 0)) {}
    while (((this.zzaAZ != null) && (this.zzaAZ.getCount() > 0)) || ((this.zzaBa != null) && (this.zzaBa.getCount() > 0)) || ((this.zzaBb != null) && (this.zzaBb.getCount() > 0))) {
      return true;
    }
    return false;
  }
  
  public void release()
  {
    if (this.zzaAY != null) {
      this.zzaAY.release();
    }
    if (this.zzaAZ != null) {
      this.zzaAZ.release();
    }
    if (this.zzaBa != null) {
      this.zzaBa.release();
    }
    if (this.zzaBb != null) {
      this.zzaBb.release();
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\multiplayer\turnbased\LoadMatchesResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */