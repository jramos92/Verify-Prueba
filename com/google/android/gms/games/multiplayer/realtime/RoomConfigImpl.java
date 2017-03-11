package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;

public final class RoomConfigImpl
  extends RoomConfig
{
  private final int zzaAD;
  private final RoomUpdateListener zzaAO;
  private final RoomStatusUpdateListener zzaAP;
  private final RealTimeMessageReceivedListener zzaAQ;
  private final Bundle zzaAT;
  private final String[] zzaAU;
  private final String zzavC;
  
  RoomConfigImpl(RoomConfig.Builder paramBuilder)
  {
    this.zzaAO = paramBuilder.zzaAO;
    this.zzaAP = paramBuilder.zzaAP;
    this.zzaAQ = paramBuilder.zzaAQ;
    this.zzavC = paramBuilder.zzaAR;
    this.zzaAD = paramBuilder.zzaAD;
    this.zzaAT = paramBuilder.zzaAT;
    int i = paramBuilder.zzaAS.size();
    this.zzaAU = ((String[])paramBuilder.zzaAS.toArray(new String[i]));
    zzx.zzb(this.zzaAQ, "Must specify a message listener");
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.zzaAT;
  }
  
  public String getInvitationId()
  {
    return this.zzavC;
  }
  
  public String[] getInvitedPlayerIds()
  {
    return this.zzaAU;
  }
  
  public RealTimeMessageReceivedListener getMessageReceivedListener()
  {
    return this.zzaAQ;
  }
  
  public RoomStatusUpdateListener getRoomStatusUpdateListener()
  {
    return this.zzaAP;
  }
  
  public RoomUpdateListener getRoomUpdateListener()
  {
    return this.zzaAO;
  }
  
  public int getVariant()
  {
    return this.zzaAD;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\multiplayer\realtime\RoomConfigImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */