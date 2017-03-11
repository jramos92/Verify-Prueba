package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.zzmo;
import java.util.ArrayList;

public final class RoomEntity
  extends GamesDowngradeableSafeParcel
  implements Room
{
  public static final Parcelable.Creator<RoomEntity> CREATOR = new RoomEntityCreatorCompat();
  private final int mVersionCode;
  private final ArrayList<ParticipantEntity> zzaAC;
  private final int zzaAD;
  private final Bundle zzaAT;
  private final String zzaAV;
  private final int zzaAW;
  private final int zzaAX;
  private final long zzaAz;
  private final String zzaqZ;
  private final String zzavE;
  
  RoomEntity(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, int paramInt3, Bundle paramBundle, ArrayList<ParticipantEntity> paramArrayList, int paramInt4)
  {
    this.mVersionCode = paramInt1;
    this.zzavE = paramString1;
    this.zzaAV = paramString2;
    this.zzaAz = paramLong;
    this.zzaAW = paramInt2;
    this.zzaqZ = paramString3;
    this.zzaAD = paramInt3;
    this.zzaAT = paramBundle;
    this.zzaAC = paramArrayList;
    this.zzaAX = paramInt4;
  }
  
  public RoomEntity(Room paramRoom)
  {
    this.mVersionCode = 2;
    this.zzavE = paramRoom.getRoomId();
    this.zzaAV = paramRoom.getCreatorId();
    this.zzaAz = paramRoom.getCreationTimestamp();
    this.zzaAW = paramRoom.getStatus();
    this.zzaqZ = paramRoom.getDescription();
    this.zzaAD = paramRoom.getVariant();
    this.zzaAT = paramRoom.getAutoMatchCriteria();
    ArrayList localArrayList = paramRoom.getParticipants();
    int j = localArrayList.size();
    this.zzaAC = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      this.zzaAC.add((ParticipantEntity)((Participant)localArrayList.get(i)).freeze());
      i += 1;
    }
    this.zzaAX = paramRoom.getAutoMatchWaitEstimateSeconds();
  }
  
  static int zza(Room paramRoom)
  {
    return zzw.hashCode(new Object[] { paramRoom.getRoomId(), paramRoom.getCreatorId(), Long.valueOf(paramRoom.getCreationTimestamp()), Integer.valueOf(paramRoom.getStatus()), paramRoom.getDescription(), Integer.valueOf(paramRoom.getVariant()), paramRoom.getAutoMatchCriteria(), paramRoom.getParticipants(), Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds()) });
  }
  
  static int zza(Room paramRoom, String paramString)
  {
    ArrayList localArrayList = paramRoom.getParticipants();
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
    throw new IllegalStateException("Participant " + paramString + " is not in room " + paramRoom.getRoomId());
  }
  
  static boolean zza(Room paramRoom, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Room)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramRoom == paramObject);
      paramObject = (Room)paramObject;
      if ((!zzw.equal(((Room)paramObject).getRoomId(), paramRoom.getRoomId())) || (!zzw.equal(((Room)paramObject).getCreatorId(), paramRoom.getCreatorId())) || (!zzw.equal(Long.valueOf(((Room)paramObject).getCreationTimestamp()), Long.valueOf(paramRoom.getCreationTimestamp()))) || (!zzw.equal(Integer.valueOf(((Room)paramObject).getStatus()), Integer.valueOf(paramRoom.getStatus()))) || (!zzw.equal(((Room)paramObject).getDescription(), paramRoom.getDescription())) || (!zzw.equal(Integer.valueOf(((Room)paramObject).getVariant()), Integer.valueOf(paramRoom.getVariant()))) || (!zzw.equal(((Room)paramObject).getAutoMatchCriteria(), paramRoom.getAutoMatchCriteria())) || (!zzw.equal(((Room)paramObject).getParticipants(), paramRoom.getParticipants()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(Integer.valueOf(((Room)paramObject).getAutoMatchWaitEstimateSeconds()), Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds())));
    return false;
  }
  
  static String zzb(Room paramRoom)
  {
    return zzw.zzv(paramRoom).zzg("RoomId", paramRoom.getRoomId()).zzg("CreatorId", paramRoom.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(paramRoom.getCreationTimestamp())).zzg("RoomStatus", Integer.valueOf(paramRoom.getStatus())).zzg("Description", paramRoom.getDescription()).zzg("Variant", Integer.valueOf(paramRoom.getVariant())).zzg("AutoMatchCriteria", paramRoom.getAutoMatchCriteria()).zzg("Participants", paramRoom.getParticipants()).zzg("AutoMatchWaitEstimateSeconds", Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds())).toString();
  }
  
  static String zzb(Room paramRoom, String paramString)
  {
    paramRoom = paramRoom.getParticipants();
    int j = paramRoom.size();
    int i = 0;
    while (i < j)
    {
      Participant localParticipant = (Participant)paramRoom.get(i);
      Player localPlayer = localParticipant.getPlayer();
      if ((localPlayer != null) && (localPlayer.getPlayerId().equals(paramString))) {
        return localParticipant.getParticipantId();
      }
      i += 1;
    }
    return null;
  }
  
  static Participant zzc(Room paramRoom, String paramString)
  {
    ArrayList localArrayList = paramRoom.getParticipants();
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
    throw new IllegalStateException("Participant " + paramString + " is not in match " + paramRoom.getRoomId());
  }
  
  static ArrayList<String> zzc(Room paramRoom)
  {
    paramRoom = paramRoom.getParticipants();
    int j = paramRoom.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(((Participant)paramRoom.get(i)).getParticipantId());
      i += 1;
    }
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Room freeze()
  {
    return this;
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.zzaAT;
  }
  
  public int getAutoMatchWaitEstimateSeconds()
  {
    return this.zzaAX;
  }
  
  public long getCreationTimestamp()
  {
    return this.zzaAz;
  }
  
  public String getCreatorId()
  {
    return this.zzaAV;
  }
  
  public String getDescription()
  {
    return this.zzaqZ;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzaqZ, paramCharArrayBuffer);
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
  
  public String getRoomId()
  {
    return this.zzavE;
  }
  
  public int getStatus()
  {
    return this.zzaAW;
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
      RoomEntityCreator.zza(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      paramParcel.writeString(this.zzavE);
      paramParcel.writeString(this.zzaAV);
      paramParcel.writeLong(this.zzaAz);
      paramParcel.writeInt(this.zzaAW);
      paramParcel.writeString(this.zzaqZ);
      paramParcel.writeInt(this.zzaAD);
      paramParcel.writeBundle(this.zzaAT);
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
  
  static final class RoomEntityCreatorCompat
    extends RoomEntityCreator
  {
    public RoomEntity zzei(Parcel paramParcel)
    {
      if ((RoomEntity.zzc(RoomEntity.zztC())) || (RoomEntity.zzcV(RoomEntity.class.getCanonicalName()))) {
        return super.zzei(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      long l = paramParcel.readLong();
      int j = paramParcel.readInt();
      String str3 = paramParcel.readString();
      int k = paramParcel.readInt();
      Bundle localBundle = paramParcel.readBundle();
      int m = paramParcel.readInt();
      ArrayList localArrayList = new ArrayList(m);
      int i = 0;
      while (i < m)
      {
        localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
        i += 1;
      }
      return new RoomEntity(2, str1, str2, l, j, str3, k, localBundle, localArrayList, -1);
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\multiplayer\realtime\RoomEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */