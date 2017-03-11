package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;

public final class ZInvitationCluster
  implements SafeParcelable, Invitation
{
  public static final InvitationClusterCreator CREATOR = new InvitationClusterCreator();
  private final int mVersionCode;
  private final ArrayList<InvitationEntity> zzazj;
  
  ZInvitationCluster(int paramInt, ArrayList<InvitationEntity> paramArrayList)
  {
    this.mVersionCode = paramInt;
    this.zzazj = paramArrayList;
    zzvp();
  }
  
  private void zzvp()
  {
    if (!this.zzazj.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      zzb.zzZ(bool);
      Invitation localInvitation1 = (Invitation)this.zzazj.get(0);
      int j = this.zzazj.size();
      int i = 1;
      while (i < j)
      {
        Invitation localInvitation2 = (Invitation)this.zzazj.get(i);
        zzb.zza(localInvitation1.getInviter().equals(localInvitation2.getInviter()), "All the invitations must be from the same inviter");
        i += 1;
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ZInvitationCluster)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (ZInvitationCluster)paramObject;
    if (((ZInvitationCluster)paramObject).zzazj.size() != this.zzazj.size()) {
      return false;
    }
    int j = this.zzazj.size();
    int i = 0;
    while (i < j)
    {
      if (!((Invitation)this.zzazj.get(i)).equals((Invitation)((ZInvitationCluster)paramObject).zzazj.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Invitation freeze()
  {
    return this;
  }
  
  public int getAvailableAutoMatchSlots()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public long getCreationTimestamp()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public Game getGame()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public String getInvitationId()
  {
    return ((InvitationEntity)this.zzazj.get(0)).getInvitationId();
  }
  
  public int getInvitationType()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public Participant getInviter()
  {
    return ((InvitationEntity)this.zzazj.get(0)).getInviter();
  }
  
  public ArrayList<Participant> getParticipants()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getVariant()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(this.zzazj.toArray());
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    InvitationClusterCreator.zza(this, paramParcel, paramInt);
  }
  
  public ArrayList<Invitation> zzvq()
  {
    return new ArrayList(this.zzazj);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\multiplayer\ZInvitationCluster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */