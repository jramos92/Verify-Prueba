package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class RoomConfig
{
  public static Builder builder(RoomUpdateListener paramRoomUpdateListener)
  {
    return new Builder(paramRoomUpdateListener, null);
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
  
  public abstract String getInvitationId();
  
  public abstract String[] getInvitedPlayerIds();
  
  public abstract RealTimeMessageReceivedListener getMessageReceivedListener();
  
  public abstract RoomStatusUpdateListener getRoomStatusUpdateListener();
  
  public abstract RoomUpdateListener getRoomUpdateListener();
  
  public abstract int getVariant();
  
  public static final class Builder
  {
    int zzaAD = -1;
    final RoomUpdateListener zzaAO;
    RoomStatusUpdateListener zzaAP;
    RealTimeMessageReceivedListener zzaAQ;
    String zzaAR = null;
    ArrayList<String> zzaAS = new ArrayList();
    Bundle zzaAT;
    
    private Builder(RoomUpdateListener paramRoomUpdateListener)
    {
      this.zzaAO = ((RoomUpdateListener)zzx.zzb(paramRoomUpdateListener, "Must provide a RoomUpdateListener"));
    }
    
    public Builder addPlayersToInvite(ArrayList<String> paramArrayList)
    {
      zzx.zzw(paramArrayList);
      this.zzaAS.addAll(paramArrayList);
      return this;
    }
    
    public Builder addPlayersToInvite(String... paramVarArgs)
    {
      zzx.zzw(paramVarArgs);
      this.zzaAS.addAll(Arrays.asList(paramVarArgs));
      return this;
    }
    
    public RoomConfig build()
    {
      return new RoomConfigImpl(this);
    }
    
    public Builder setAutoMatchCriteria(Bundle paramBundle)
    {
      this.zzaAT = paramBundle;
      return this;
    }
    
    public Builder setInvitationIdToAccept(String paramString)
    {
      zzx.zzw(paramString);
      this.zzaAR = paramString;
      return this;
    }
    
    public Builder setMessageReceivedListener(RealTimeMessageReceivedListener paramRealTimeMessageReceivedListener)
    {
      this.zzaAQ = paramRealTimeMessageReceivedListener;
      return this;
    }
    
    public Builder setRoomStatusUpdateListener(RoomStatusUpdateListener paramRoomStatusUpdateListener)
    {
      this.zzaAP = paramRoomStatusUpdateListener;
      return this;
    }
    
    public Builder setVariant(int paramInt)
    {
      if ((paramInt == -1) || (paramInt > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Variant must be a positive integer or Room.ROOM_VARIANT_ANY");
        this.zzaAD = paramInt;
        return this;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\multiplayer\realtime\RoomConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */