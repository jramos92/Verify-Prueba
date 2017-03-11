package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.zzmo;
import java.util.ArrayList;

public final class TurnBasedMatchEntity
  implements SafeParcelable, TurnBasedMatch
{
  public static final Parcelable.Creator<TurnBasedMatchEntity> CREATOR = new TurnBasedMatchEntityCreator();
  private final int mVersion;
  private final int mVersionCode;
  private final ArrayList<ParticipantEntity> zzaAC;
  private final int zzaAD;
  private final Bundle zzaAT;
  private final String zzaAV;
  private final GameEntity zzaAy;
  private final long zzaAz;
  private final String zzaBd;
  private final String zzaBe;
  private final int zzaBf;
  private final byte[] zzaBg;
  private final String zzaBh;
  private final byte[] zzaBi;
  private final int zzaBj;
  private final int zzaBk;
  private final boolean zzaBl;
  private final String zzaBm;
  private final String zzaqZ;
  private final long zzauA;
  private final String zzavX;
  
  TurnBasedMatchEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2, String paramString4, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte1, ArrayList<ParticipantEntity> paramArrayList, String paramString5, byte[] paramArrayOfByte2, int paramInt5, Bundle paramBundle, int paramInt6, boolean paramBoolean, String paramString6, String paramString7)
  {
    this.mVersionCode = paramInt1;
    this.zzaAy = paramGameEntity;
    this.zzavX = paramString1;
    this.zzaAV = paramString2;
    this.zzaAz = paramLong1;
    this.zzaBd = paramString3;
    this.zzauA = paramLong2;
    this.zzaBe = paramString4;
    this.zzaBf = paramInt2;
    this.zzaBk = paramInt6;
    this.zzaAD = paramInt3;
    this.mVersion = paramInt4;
    this.zzaBg = paramArrayOfByte1;
    this.zzaAC = paramArrayList;
    this.zzaBh = paramString5;
    this.zzaBi = paramArrayOfByte2;
    this.zzaBj = paramInt5;
    this.zzaAT = paramBundle;
    this.zzaBl = paramBoolean;
    this.zzaqZ = paramString6;
    this.zzaBm = paramString7;
  }
  
  public TurnBasedMatchEntity(TurnBasedMatch paramTurnBasedMatch)
  {
    this.mVersionCode = 2;
    this.zzaAy = new GameEntity(paramTurnBasedMatch.getGame());
    this.zzavX = paramTurnBasedMatch.getMatchId();
    this.zzaAV = paramTurnBasedMatch.getCreatorId();
    this.zzaAz = paramTurnBasedMatch.getCreationTimestamp();
    this.zzaBd = paramTurnBasedMatch.getLastUpdaterId();
    this.zzauA = paramTurnBasedMatch.getLastUpdatedTimestamp();
    this.zzaBe = paramTurnBasedMatch.getPendingParticipantId();
    this.zzaBf = paramTurnBasedMatch.getStatus();
    this.zzaBk = paramTurnBasedMatch.getTurnStatus();
    this.zzaAD = paramTurnBasedMatch.getVariant();
    this.mVersion = paramTurnBasedMatch.getVersion();
    this.zzaBh = paramTurnBasedMatch.getRematchId();
    this.zzaBj = paramTurnBasedMatch.getMatchNumber();
    this.zzaAT = paramTurnBasedMatch.getAutoMatchCriteria();
    this.zzaBl = paramTurnBasedMatch.isLocallyModified();
    this.zzaqZ = paramTurnBasedMatch.getDescription();
    this.zzaBm = paramTurnBasedMatch.getDescriptionParticipantId();
    byte[] arrayOfByte = paramTurnBasedMatch.getData();
    if (arrayOfByte == null)
    {
      this.zzaBg = null;
      arrayOfByte = paramTurnBasedMatch.getPreviousMatchData();
      if (arrayOfByte != null) {
        break label313;
      }
      this.zzaBi = null;
    }
    for (;;)
    {
      paramTurnBasedMatch = paramTurnBasedMatch.getParticipants();
      int j = paramTurnBasedMatch.size();
      this.zzaAC = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        this.zzaAC.add((ParticipantEntity)((Participant)paramTurnBasedMatch.get(i)).freeze());
        i += 1;
      }
      this.zzaBg = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, this.zzaBg, 0, arrayOfByte.length);
      break;
      label313:
      this.zzaBi = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, this.zzaBi, 0, arrayOfByte.length);
    }
  }
  
  static int zza(TurnBasedMatch paramTurnBasedMatch)
  {
    return zzw.hashCode(new Object[] { paramTurnBasedMatch.getGame(), paramTurnBasedMatch.getMatchId(), paramTurnBasedMatch.getCreatorId(), Long.valueOf(paramTurnBasedMatch.getCreationTimestamp()), paramTurnBasedMatch.getLastUpdaterId(), Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp()), paramTurnBasedMatch.getPendingParticipantId(), Integer.valueOf(paramTurnBasedMatch.getStatus()), Integer.valueOf(paramTurnBasedMatch.getTurnStatus()), paramTurnBasedMatch.getDescription(), Integer.valueOf(paramTurnBasedMatch.getVariant()), Integer.valueOf(paramTurnBasedMatch.getVersion()), paramTurnBasedMatch.getParticipants(), paramTurnBasedMatch.getRematchId(), Integer.valueOf(paramTurnBasedMatch.getMatchNumber()), paramTurnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(paramTurnBasedMatch.isLocallyModified()) });
  }
  
  static int zza(TurnBasedMatch paramTurnBasedMatch, String paramString)
  {
    ArrayList localArrayList = paramTurnBasedMatch.getParticipants();
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Participant localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(paramString)) {
        return localParticipant.getStatus();
      }
      i += 1;
    }
    throw new IllegalStateException("Participant " + paramString + " is not in match " + paramTurnBasedMatch.getMatchId());
  }
  
  static boolean zza(TurnBasedMatch paramTurnBasedMatch, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof TurnBasedMatch)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramTurnBasedMatch == paramObject);
      paramObject = (TurnBasedMatch)paramObject;
      if ((!zzw.equal(((TurnBasedMatch)paramObject).getGame(), paramTurnBasedMatch.getGame())) || (!zzw.equal(((TurnBasedMatch)paramObject).getMatchId(), paramTurnBasedMatch.getMatchId())) || (!zzw.equal(((TurnBasedMatch)paramObject).getCreatorId(), paramTurnBasedMatch.getCreatorId())) || (!zzw.equal(Long.valueOf(((TurnBasedMatch)paramObject).getCreationTimestamp()), Long.valueOf(paramTurnBasedMatch.getCreationTimestamp()))) || (!zzw.equal(((TurnBasedMatch)paramObject).getLastUpdaterId(), paramTurnBasedMatch.getLastUpdaterId())) || (!zzw.equal(Long.valueOf(((TurnBasedMatch)paramObject).getLastUpdatedTimestamp()), Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp()))) || (!zzw.equal(((TurnBasedMatch)paramObject).getPendingParticipantId(), paramTurnBasedMatch.getPendingParticipantId())) || (!zzw.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getStatus()), Integer.valueOf(paramTurnBasedMatch.getStatus()))) || (!zzw.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getTurnStatus()), Integer.valueOf(paramTurnBasedMatch.getTurnStatus()))) || (!zzw.equal(((TurnBasedMatch)paramObject).getDescription(), paramTurnBasedMatch.getDescription())) || (!zzw.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getVariant()), Integer.valueOf(paramTurnBasedMatch.getVariant()))) || (!zzw.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getVersion()), Integer.valueOf(paramTurnBasedMatch.getVersion()))) || (!zzw.equal(((TurnBasedMatch)paramObject).getParticipants(), paramTurnBasedMatch.getParticipants())) || (!zzw.equal(((TurnBasedMatch)paramObject).getRematchId(), paramTurnBasedMatch.getRematchId())) || (!zzw.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getMatchNumber()), Integer.valueOf(paramTurnBasedMatch.getMatchNumber()))) || (!zzw.equal(((TurnBasedMatch)paramObject).getAutoMatchCriteria(), paramTurnBasedMatch.getAutoMatchCriteria())) || (!zzw.equal(Integer.valueOf(((TurnBasedMatch)paramObject).getAvailableAutoMatchSlots()), Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(Boolean.valueOf(((TurnBasedMatch)paramObject).isLocallyModified()), Boolean.valueOf(paramTurnBasedMatch.isLocallyModified())));
    return false;
  }
  
  static String zzb(TurnBasedMatch paramTurnBasedMatch)
  {
    return zzw.zzv(paramTurnBasedMatch).zzg("Game", paramTurnBasedMatch.getGame()).zzg("MatchId", paramTurnBasedMatch.getMatchId()).zzg("CreatorId", paramTurnBasedMatch.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(paramTurnBasedMatch.getCreationTimestamp())).zzg("LastUpdaterId", paramTurnBasedMatch.getLastUpdaterId()).zzg("LastUpdatedTimestamp", Long.valueOf(paramTurnBasedMatch.getLastUpdatedTimestamp())).zzg("PendingParticipantId", paramTurnBasedMatch.getPendingParticipantId()).zzg("MatchStatus", Integer.valueOf(paramTurnBasedMatch.getStatus())).zzg("TurnStatus", Integer.valueOf(paramTurnBasedMatch.getTurnStatus())).zzg("Description", paramTurnBasedMatch.getDescription()).zzg("Variant", Integer.valueOf(paramTurnBasedMatch.getVariant())).zzg("Data", paramTurnBasedMatch.getData()).zzg("Version", Integer.valueOf(paramTurnBasedMatch.getVersion())).zzg("Participants", paramTurnBasedMatch.getParticipants()).zzg("RematchId", paramTurnBasedMatch.getRematchId()).zzg("PreviousData", paramTurnBasedMatch.getPreviousMatchData()).zzg("MatchNumber", Integer.valueOf(paramTurnBasedMatch.getMatchNumber())).zzg("AutoMatchCriteria", paramTurnBasedMatch.getAutoMatchCriteria()).zzg("AvailableAutoMatchSlots", Integer.valueOf(paramTurnBasedMatch.getAvailableAutoMatchSlots())).zzg("LocallyModified", Boolean.valueOf(paramTurnBasedMatch.isLocallyModified())).zzg("DescriptionParticipantId", paramTurnBasedMatch.getDescriptionParticipantId()).toString();
  }
  
  static String zzb(TurnBasedMatch paramTurnBasedMatch, String paramString)
  {
    paramTurnBasedMatch = paramTurnBasedMatch.getParticipants();
    int j = paramTurnBasedMatch.size();
    int i = 0;
    while (i < j)
    {
      Participant localParticipant = (Participant)paramTurnBasedMatch.get(i);
      Player localPlayer = localParticipant.getPlayer();
      if ((localPlayer != null) && (localPlayer.getPlayerId().equals(paramString))) {
        return localParticipant.getParticipantId();
      }
      i += 1;
    }
    return null;
  }
  
  static Participant zzc(TurnBasedMatch paramTurnBasedMatch, String paramString)
  {
    ArrayList localArrayList = paramTurnBasedMatch.getParticipants();
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Participant localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(paramString)) {
        return localParticipant;
      }
      i += 1;
    }
    throw new IllegalStateException("Participant " + paramString + " is not in match " + paramTurnBasedMatch.getMatchId());
  }
  
  static ArrayList<String> zzc(TurnBasedMatch paramTurnBasedMatch)
  {
    paramTurnBasedMatch = paramTurnBasedMatch.getParticipants();
    int j = paramTurnBasedMatch.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(((Participant)paramTurnBasedMatch.get(i)).getParticipantId());
      i += 1;
    }
    return localArrayList;
  }
  
  public boolean canRematch()
  {
    return (this.zzaBf == 2) && (this.zzaBh == null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public TurnBasedMatch freeze()
  {
    return this;
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.zzaAT;
  }
  
  public int getAvailableAutoMatchSlots()
  {
    if (this.zzaAT == null) {
      return 0;
    }
    return this.zzaAT.getInt("max_automatch_players");
  }
  
  public long getCreationTimestamp()
  {
    return this.zzaAz;
  }
  
  public String getCreatorId()
  {
    return this.zzaAV;
  }
  
  public byte[] getData()
  {
    return this.zzaBg;
  }
  
  public String getDescription()
  {
    return this.zzaqZ;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzaqZ, paramCharArrayBuffer);
  }
  
  public Participant getDescriptionParticipant()
  {
    String str = getDescriptionParticipantId();
    if (str == null) {
      return null;
    }
    return getParticipant(str);
  }
  
  public String getDescriptionParticipantId()
  {
    return this.zzaBm;
  }
  
  public Game getGame()
  {
    return this.zzaAy;
  }
  
  public long getLastUpdatedTimestamp()
  {
    return this.zzauA;
  }
  
  public String getLastUpdaterId()
  {
    return this.zzaBd;
  }
  
  public String getMatchId()
  {
    return this.zzavX;
  }
  
  public int getMatchNumber()
  {
    return this.zzaBj;
  }
  
  public Participant getParticipant(String paramString)
  {
    return zzc(this, paramString);
  }
  
  public String getParticipantId(String paramString)
  {
    return zzb(this, paramString);
  }
  
  public ArrayList<String> getParticipantIds()
  {
    return zzc(this);
  }
  
  public int getParticipantStatus(String paramString)
  {
    return zza(this, paramString);
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return new ArrayList(this.zzaAC);
  }
  
  public String getPendingParticipantId()
  {
    return this.zzaBe;
  }
  
  public byte[] getPreviousMatchData()
  {
    return this.zzaBi;
  }
  
  public String getRematchId()
  {
    return this.zzaBh;
  }
  
  public int getStatus()
  {
    return this.zzaBf;
  }
  
  public int getTurnStatus()
  {
    return this.zzaBk;
  }
  
  public int getVariant()
  {
    return this.zzaAD;
  }
  
  public int getVersion()
  {
    return this.mVersion;
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
  
  public boolean isLocallyModified()
  {
    return this.zzaBl;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    TurnBasedMatchEntityCreator.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\multiplayer\turnbased\TurnBasedMatchEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */