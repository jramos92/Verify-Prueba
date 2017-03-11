package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;

public final class InvitationEntity
  extends GamesDowngradeableSafeParcel
  implements Invitation
{
  public static final Parcelable.Creator<InvitationEntity> CREATOR = new InvitationEntityCreatorCompat();
  private final int mVersionCode;
  private final int zzaAA;
  private final ParticipantEntity zzaAB;
  private final ArrayList<ParticipantEntity> zzaAC;
  private final int zzaAD;
  private final int zzaAE;
  private final GameEntity zzaAy;
  private final long zzaAz;
  private final String zzavC;
  
  InvitationEntity(int paramInt1, GameEntity paramGameEntity, String paramString, long paramLong, int paramInt2, ParticipantEntity paramParticipantEntity, ArrayList<ParticipantEntity> paramArrayList, int paramInt3, int paramInt4)
  {
    this.mVersionCode = paramInt1;
    this.zzaAy = paramGameEntity;
    this.zzavC = paramString;
    this.zzaAz = paramLong;
    this.zzaAA = paramInt2;
    this.zzaAB = paramParticipantEntity;
    this.zzaAC = paramArrayList;
    this.zzaAD = paramInt3;
    this.zzaAE = paramInt4;
  }
  
  InvitationEntity(Invitation paramInvitation)
  {
    this.mVersionCode = 2;
    this.zzaAy = new GameEntity(paramInvitation.getGame());
    this.zzavC = paramInvitation.getInvitationId();
    this.zzaAz = paramInvitation.getCreationTimestamp();
    this.zzaAA = paramInvitation.getInvitationType();
    this.zzaAD = paramInvitation.getVariant();
    this.zzaAE = paramInvitation.getAvailableAutoMatchSlots();
    String str = paramInvitation.getInviter().getParticipantId();
    Participant localParticipant = null;
    ArrayList localArrayList = paramInvitation.getParticipants();
    int j = localArrayList.size();
    this.zzaAC = new ArrayList(j);
    int i = 0;
    paramInvitation = localParticipant;
    while (i < j)
    {
      localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(str)) {
        paramInvitation = localParticipant;
      }
      this.zzaAC.add((ParticipantEntity)localParticipant.freeze());
      i += 1;
    }
    zzx.zzb(paramInvitation, "Must have a valid inviter!");
    this.zzaAB = ((ParticipantEntity)paramInvitation.freeze());
  }
  
  static int zza(Invitation paramInvitation)
  {
    return zzw.hashCode(new Object[] { paramInvitation.getGame(), paramInvitation.getInvitationId(), Long.valueOf(paramInvitation.getCreationTimestamp()), Integer.valueOf(paramInvitation.getInvitationType()), paramInvitation.getInviter(), paramInvitation.getParticipants(), Integer.valueOf(paramInvitation.getVariant()), Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots()) });
  }
  
  static boolean zza(Invitation paramInvitation, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Invitation)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramInvitation == paramObject);
      paramObject = (Invitation)paramObject;
      if ((!zzw.equal(((Invitation)paramObject).getGame(), paramInvitation.getGame())) || (!zzw.equal(((Invitation)paramObject).getInvitationId(), paramInvitation.getInvitationId())) || (!zzw.equal(Long.valueOf(((Invitation)paramObject).getCreationTimestamp()), Long.valueOf(paramInvitation.getCreationTimestamp()))) || (!zzw.equal(Integer.valueOf(((Invitation)paramObject).getInvitationType()), Integer.valueOf(paramInvitation.getInvitationType()))) || (!zzw.equal(((Invitation)paramObject).getInviter(), paramInvitation.getInviter())) || (!zzw.equal(((Invitation)paramObject).getParticipants(), paramInvitation.getParticipants())) || (!zzw.equal(Integer.valueOf(((Invitation)paramObject).getVariant()), Integer.valueOf(paramInvitation.getVariant())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(Integer.valueOf(((Invitation)paramObject).getAvailableAutoMatchSlots()), Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())));
    return false;
  }
  
  static String zzb(Invitation paramInvitation)
  {
    return zzw.zzv(paramInvitation).zzg("Game", paramInvitation.getGame()).zzg("InvitationId", paramInvitation.getInvitationId()).zzg("CreationTimestamp", Long.valueOf(paramInvitation.getCreationTimestamp())).zzg("InvitationType", Integer.valueOf(paramInvitation.getInvitationType())).zzg("Inviter", paramInvitation.getInviter()).zzg("Participants", paramInvitation.getParticipants()).zzg("Variant", Integer.valueOf(paramInvitation.getVariant())).zzg("AvailableAutoMatchSlots", Integer.valueOf(paramInvitation.getAvailableAutoMatchSlots())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Invitation freeze()
  {
    return this;
  }
  
  public int getAvailableAutoMatchSlots()
  {
    return this.zzaAE;
  }
  
  public long getCreationTimestamp()
  {
    return this.zzaAz;
  }
  
  public Game getGame()
  {
    return this.zzaAy;
  }
  
  public String getInvitationId()
  {
    return this.zzavC;
  }
  
  public int getInvitationType()
  {
    return this.zzaAA;
  }
  
  public Participant getInviter()
  {
    return this.zzaAB;
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return new ArrayList(this.zzaAC);
  }
  
  public int getVariant()
  {
    return this.zzaAD;
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
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!zzoU()) {
      InvitationEntityCreator.zza(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      this.zzaAy.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.zzavC);
      paramParcel.writeLong(this.zzaAz);
      paramParcel.writeInt(this.zzaAA);
      this.zzaAB.writeToParcel(paramParcel, paramInt);
      int j = this.zzaAC.size();
      paramParcel.writeInt(j);
      int i = 0;
      while (i < j)
      {
        ((ParticipantEntity)this.zzaAC.get(i)).writeToParcel(paramParcel, paramInt);
        i += 1;
      }
    }
  }
  
  static final class InvitationEntityCreatorCompat
    extends InvitationEntityCreator
  {
    public InvitationEntity zzee(Parcel paramParcel)
    {
      if ((InvitationEntity.zzc(InvitationEntity.zztC())) || (InvitationEntity.zzcV(InvitationEntity.class.getCanonicalName()))) {
        return super.zzee(paramParcel);
      }
      GameEntity localGameEntity = (GameEntity)GameEntity.CREATOR.createFromParcel(paramParcel);
      String str = paramParcel.readString();
      long l = paramParcel.readLong();
      int j = paramParcel.readInt();
      ParticipantEntity localParticipantEntity = (ParticipantEntity)ParticipantEntity.CREATOR.createFromParcel(paramParcel);
      int k = paramParcel.readInt();
      ArrayList localArrayList = new ArrayList(k);
      int i = 0;
      while (i < k)
      {
        localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
        i += 1;
      }
      return new InvitationEntity(2, localGameEntity, str, l, j, localParticipantEntity, localArrayList, -1, 0);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\multiplayer\InvitationEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */