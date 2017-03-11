package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzmo;

public final class ParticipantEntity
  extends GamesDowngradeableSafeParcel
  implements Participant
{
  public static final Parcelable.Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
  private final int mVersionCode;
  private final String zzTa;
  private final int zzVl;
  private final boolean zzaAG;
  private final ParticipantResult zzaAH;
  private final String zzatF;
  private final String zzatG;
  private final Uri zzatu;
  private final Uri zzatv;
  private final PlayerEntity zzaux;
  private final String zzavf;
  private final String zzawg;
  private final int zzys;
  
  ParticipantEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, int paramInt2, String paramString3, boolean paramBoolean, PlayerEntity paramPlayerEntity, int paramInt3, ParticipantResult paramParticipantResult, String paramString4, String paramString5)
  {
    this.mVersionCode = paramInt1;
    this.zzawg = paramString1;
    this.zzTa = paramString2;
    this.zzatu = paramUri1;
    this.zzatv = paramUri2;
    this.zzys = paramInt2;
    this.zzavf = paramString3;
    this.zzaAG = paramBoolean;
    this.zzaux = paramPlayerEntity;
    this.zzVl = paramInt3;
    this.zzaAH = paramParticipantResult;
    this.zzatF = paramString4;
    this.zzatG = paramString5;
  }
  
  public ParticipantEntity(Participant paramParticipant)
  {
    this.mVersionCode = 3;
    this.zzawg = paramParticipant.getParticipantId();
    this.zzTa = paramParticipant.getDisplayName();
    this.zzatu = paramParticipant.getIconImageUri();
    this.zzatv = paramParticipant.getHiResImageUri();
    this.zzys = paramParticipant.getStatus();
    this.zzavf = paramParticipant.zzut();
    this.zzaAG = paramParticipant.isConnectedToRoom();
    Object localObject = paramParticipant.getPlayer();
    if (localObject == null) {}
    for (localObject = null;; localObject = new PlayerEntity((Player)localObject))
    {
      this.zzaux = ((PlayerEntity)localObject);
      this.zzVl = paramParticipant.getCapabilities();
      this.zzaAH = paramParticipant.getResult();
      this.zzatF = paramParticipant.getIconImageUrl();
      this.zzatG = paramParticipant.getHiResImageUrl();
      return;
    }
  }
  
  static int zza(Participant paramParticipant)
  {
    return zzw.hashCode(new Object[] { paramParticipant.getPlayer(), Integer.valueOf(paramParticipant.getStatus()), paramParticipant.zzut(), Boolean.valueOf(paramParticipant.isConnectedToRoom()), paramParticipant.getDisplayName(), paramParticipant.getIconImageUri(), paramParticipant.getHiResImageUri(), Integer.valueOf(paramParticipant.getCapabilities()), paramParticipant.getResult(), paramParticipant.getParticipantId() });
  }
  
  static boolean zza(Participant paramParticipant, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Participant)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramParticipant == paramObject);
      paramObject = (Participant)paramObject;
      if ((!zzw.equal(((Participant)paramObject).getPlayer(), paramParticipant.getPlayer())) || (!zzw.equal(Integer.valueOf(((Participant)paramObject).getStatus()), Integer.valueOf(paramParticipant.getStatus()))) || (!zzw.equal(((Participant)paramObject).zzut(), paramParticipant.zzut())) || (!zzw.equal(Boolean.valueOf(((Participant)paramObject).isConnectedToRoom()), Boolean.valueOf(paramParticipant.isConnectedToRoom()))) || (!zzw.equal(((Participant)paramObject).getDisplayName(), paramParticipant.getDisplayName())) || (!zzw.equal(((Participant)paramObject).getIconImageUri(), paramParticipant.getIconImageUri())) || (!zzw.equal(((Participant)paramObject).getHiResImageUri(), paramParticipant.getHiResImageUri())) || (!zzw.equal(Integer.valueOf(((Participant)paramObject).getCapabilities()), Integer.valueOf(paramParticipant.getCapabilities()))) || (!zzw.equal(((Participant)paramObject).getResult(), paramParticipant.getResult()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((Participant)paramObject).getParticipantId(), paramParticipant.getParticipantId()));
    return false;
  }
  
  static String zzb(Participant paramParticipant)
  {
    return zzw.zzv(paramParticipant).zzg("ParticipantId", paramParticipant.getParticipantId()).zzg("Player", paramParticipant.getPlayer()).zzg("Status", Integer.valueOf(paramParticipant.getStatus())).zzg("ClientAddress", paramParticipant.zzut()).zzg("ConnectedToRoom", Boolean.valueOf(paramParticipant.isConnectedToRoom())).zzg("DisplayName", paramParticipant.getDisplayName()).zzg("IconImage", paramParticipant.getIconImageUri()).zzg("IconImageUrl", paramParticipant.getIconImageUrl()).zzg("HiResImage", paramParticipant.getHiResImageUri()).zzg("HiResImageUrl", paramParticipant.getHiResImageUrl()).zzg("Capabilities", Integer.valueOf(paramParticipant.getCapabilities())).zzg("Result", paramParticipant.getResult()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Participant freeze()
  {
    return this;
  }
  
  public int getCapabilities()
  {
    return this.zzVl;
  }
  
  public String getDisplayName()
  {
    if (this.zzaux == null) {
      return this.zzTa;
    }
    return this.zzaux.getDisplayName();
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.zzaux == null)
    {
      zzmo.zzb(this.zzTa, paramCharArrayBuffer);
      return;
    }
    this.zzaux.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    if (this.zzaux == null) {
      return this.zzatv;
    }
    return this.zzaux.getHiResImageUri();
  }
  
  public String getHiResImageUrl()
  {
    if (this.zzaux == null) {
      return this.zzatG;
    }
    return this.zzaux.getHiResImageUrl();
  }
  
  public Uri getIconImageUri()
  {
    if (this.zzaux == null) {
      return this.zzatu;
    }
    return this.zzaux.getIconImageUri();
  }
  
  public String getIconImageUrl()
  {
    if (this.zzaux == null) {
      return this.zzatF;
    }
    return this.zzaux.getIconImageUrl();
  }
  
  public String getParticipantId()
  {
    return this.zzawg;
  }
  
  public Player getPlayer()
  {
    return this.zzaux;
  }
  
  public ParticipantResult getResult()
  {
    return this.zzaAH;
  }
  
  public int getStatus()
  {
    return this.zzys;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isConnectedToRoom()
  {
    return this.zzaAG;
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
    Object localObject2 = null;
    int j = 0;
    if (!zzoU())
    {
      ParticipantEntityCreator.zza(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.zzawg);
    paramParcel.writeString(this.zzTa);
    Object localObject1;
    if (this.zzatu == null)
    {
      localObject1 = null;
      label46:
      paramParcel.writeString((String)localObject1);
      if (this.zzatv != null) {
        break label143;
      }
      localObject1 = localObject2;
      label63:
      paramParcel.writeString((String)localObject1);
      paramParcel.writeInt(this.zzys);
      paramParcel.writeString(this.zzavf);
      if (!this.zzaAG) {
        break label155;
      }
      i = 1;
      label94:
      paramParcel.writeInt(i);
      if (this.zzaux != null) {
        break label160;
      }
    }
    label143:
    label155:
    label160:
    for (int i = j;; i = 1)
    {
      paramParcel.writeInt(i);
      if (this.zzaux == null) {
        break;
      }
      this.zzaux.writeToParcel(paramParcel, paramInt);
      return;
      localObject1 = this.zzatu.toString();
      break label46;
      localObject1 = this.zzatv.toString();
      break label63;
      i = 0;
      break label94;
    }
  }
  
  public String zzut()
  {
    return this.zzavf;
  }
  
  static final class ParticipantEntityCreatorCompat
    extends ParticipantEntityCreator
  {
    public ParticipantEntity zzef(Parcel paramParcel)
    {
      int i = 1;
      if ((ParticipantEntity.zzc(ParticipantEntity.zztC())) || (ParticipantEntity.zzcV(ParticipantEntity.class.getCanonicalName()))) {
        return super.zzef(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      Object localObject1 = paramParcel.readString();
      Object localObject2;
      label68:
      int j;
      String str3;
      boolean bool;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = paramParcel.readString();
        if (localObject2 != null) {
          break label151;
        }
        localObject2 = null;
        j = paramParcel.readInt();
        str3 = paramParcel.readString();
        if (paramParcel.readInt() <= 0) {
          break label161;
        }
        bool = true;
        label89:
        if (paramParcel.readInt() <= 0) {
          break label167;
        }
        label96:
        if (i == 0) {
          break label172;
        }
      }
      label151:
      label161:
      label167:
      label172:
      for (paramParcel = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(paramParcel);; paramParcel = null)
      {
        return new ParticipantEntity(3, str1, str2, (Uri)localObject1, (Uri)localObject2, j, str3, bool, paramParcel, 7, null, null, null);
        localObject1 = Uri.parse((String)localObject1);
        break;
        localObject2 = Uri.parse((String)localObject2);
        break label68;
        bool = false;
        break label89;
        i = 0;
        break label96;
      }
    }
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\multiplayer\ParticipantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */