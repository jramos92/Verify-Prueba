package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzmo;

public final class SnapshotMetadataEntity
  implements SafeParcelable, SnapshotMetadata
{
  public static final Parcelable.Creator<SnapshotMetadataEntity> CREATOR = new SnapshotMetadataEntityCreator();
  private final int mVersionCode;
  private final GameEntity zzaAy;
  private final Uri zzaBK;
  private final PlayerEntity zzaBN;
  private final String zzaBO;
  private final long zzaBP;
  private final long zzaBQ;
  private final float zzaBR;
  private final String zzaBS;
  private final boolean zzaBT;
  private final long zzaBU;
  private final String zzaBV;
  private final String zzajf;
  private final String zzaqZ;
  private final String zzavx;
  
  SnapshotMetadataEntity(int paramInt, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, String paramString1, Uri paramUri, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, float paramFloat, String paramString5, boolean paramBoolean, long paramLong3, String paramString6)
  {
    this.mVersionCode = paramInt;
    this.zzaAy = paramGameEntity;
    this.zzaBN = paramPlayerEntity;
    this.zzavx = paramString1;
    this.zzaBK = paramUri;
    this.zzaBO = paramString2;
    this.zzaBR = paramFloat;
    this.zzajf = paramString3;
    this.zzaqZ = paramString4;
    this.zzaBP = paramLong1;
    this.zzaBQ = paramLong2;
    this.zzaBS = paramString5;
    this.zzaBT = paramBoolean;
    this.zzaBU = paramLong3;
    this.zzaBV = paramString6;
  }
  
  public SnapshotMetadataEntity(SnapshotMetadata paramSnapshotMetadata)
  {
    this.mVersionCode = 6;
    this.zzaAy = new GameEntity(paramSnapshotMetadata.getGame());
    this.zzaBN = new PlayerEntity(paramSnapshotMetadata.getOwner());
    this.zzavx = paramSnapshotMetadata.getSnapshotId();
    this.zzaBK = paramSnapshotMetadata.getCoverImageUri();
    this.zzaBO = paramSnapshotMetadata.getCoverImageUrl();
    this.zzaBR = paramSnapshotMetadata.getCoverImageAspectRatio();
    this.zzajf = paramSnapshotMetadata.getTitle();
    this.zzaqZ = paramSnapshotMetadata.getDescription();
    this.zzaBP = paramSnapshotMetadata.getLastModifiedTimestamp();
    this.zzaBQ = paramSnapshotMetadata.getPlayedTime();
    this.zzaBS = paramSnapshotMetadata.getUniqueName();
    this.zzaBT = paramSnapshotMetadata.hasChangePending();
    this.zzaBU = paramSnapshotMetadata.getProgressValue();
    this.zzaBV = paramSnapshotMetadata.getDeviceName();
  }
  
  static int zza(SnapshotMetadata paramSnapshotMetadata)
  {
    return zzw.hashCode(new Object[] { paramSnapshotMetadata.getGame(), paramSnapshotMetadata.getOwner(), paramSnapshotMetadata.getSnapshotId(), paramSnapshotMetadata.getCoverImageUri(), Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio()), paramSnapshotMetadata.getTitle(), paramSnapshotMetadata.getDescription(), Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(paramSnapshotMetadata.getPlayedTime()), paramSnapshotMetadata.getUniqueName(), Boolean.valueOf(paramSnapshotMetadata.hasChangePending()), Long.valueOf(paramSnapshotMetadata.getProgressValue()), paramSnapshotMetadata.getDeviceName() });
  }
  
  static boolean zza(SnapshotMetadata paramSnapshotMetadata, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof SnapshotMetadata)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramSnapshotMetadata == paramObject);
      paramObject = (SnapshotMetadata)paramObject;
      if ((!zzw.equal(((SnapshotMetadata)paramObject).getGame(), paramSnapshotMetadata.getGame())) || (!zzw.equal(((SnapshotMetadata)paramObject).getOwner(), paramSnapshotMetadata.getOwner())) || (!zzw.equal(((SnapshotMetadata)paramObject).getSnapshotId(), paramSnapshotMetadata.getSnapshotId())) || (!zzw.equal(((SnapshotMetadata)paramObject).getCoverImageUri(), paramSnapshotMetadata.getCoverImageUri())) || (!zzw.equal(Float.valueOf(((SnapshotMetadata)paramObject).getCoverImageAspectRatio()), Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio()))) || (!zzw.equal(((SnapshotMetadata)paramObject).getTitle(), paramSnapshotMetadata.getTitle())) || (!zzw.equal(((SnapshotMetadata)paramObject).getDescription(), paramSnapshotMetadata.getDescription())) || (!zzw.equal(Long.valueOf(((SnapshotMetadata)paramObject).getLastModifiedTimestamp()), Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp()))) || (!zzw.equal(Long.valueOf(((SnapshotMetadata)paramObject).getPlayedTime()), Long.valueOf(paramSnapshotMetadata.getPlayedTime()))) || (!zzw.equal(((SnapshotMetadata)paramObject).getUniqueName(), paramSnapshotMetadata.getUniqueName())) || (!zzw.equal(Boolean.valueOf(((SnapshotMetadata)paramObject).hasChangePending()), Boolean.valueOf(paramSnapshotMetadata.hasChangePending()))) || (!zzw.equal(Long.valueOf(((SnapshotMetadata)paramObject).getProgressValue()), Long.valueOf(paramSnapshotMetadata.getProgressValue())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((SnapshotMetadata)paramObject).getDeviceName(), paramSnapshotMetadata.getDeviceName()));
    return false;
  }
  
  static String zzb(SnapshotMetadata paramSnapshotMetadata)
  {
    return zzw.zzv(paramSnapshotMetadata).zzg("Game", paramSnapshotMetadata.getGame()).zzg("Owner", paramSnapshotMetadata.getOwner()).zzg("SnapshotId", paramSnapshotMetadata.getSnapshotId()).zzg("CoverImageUri", paramSnapshotMetadata.getCoverImageUri()).zzg("CoverImageUrl", paramSnapshotMetadata.getCoverImageUrl()).zzg("CoverImageAspectRatio", Float.valueOf(paramSnapshotMetadata.getCoverImageAspectRatio())).zzg("Description", paramSnapshotMetadata.getDescription()).zzg("LastModifiedTimestamp", Long.valueOf(paramSnapshotMetadata.getLastModifiedTimestamp())).zzg("PlayedTime", Long.valueOf(paramSnapshotMetadata.getPlayedTime())).zzg("UniqueName", paramSnapshotMetadata.getUniqueName()).zzg("ChangePending", Boolean.valueOf(paramSnapshotMetadata.hasChangePending())).zzg("ProgressValue", Long.valueOf(paramSnapshotMetadata.getProgressValue())).zzg("DeviceName", paramSnapshotMetadata.getDeviceName()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public SnapshotMetadata freeze()
  {
    return this;
  }
  
  public float getCoverImageAspectRatio()
  {
    return this.zzaBR;
  }
  
  public Uri getCoverImageUri()
  {
    return this.zzaBK;
  }
  
  public String getCoverImageUrl()
  {
    return this.zzaBO;
  }
  
  public String getDescription()
  {
    return this.zzaqZ;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzaqZ, paramCharArrayBuffer);
  }
  
  public String getDeviceName()
  {
    return this.zzaBV;
  }
  
  public Game getGame()
  {
    return this.zzaAy;
  }
  
  public long getLastModifiedTimestamp()
  {
    return this.zzaBP;
  }
  
  public Player getOwner()
  {
    return this.zzaBN;
  }
  
  public long getPlayedTime()
  {
    return this.zzaBQ;
  }
  
  public long getProgressValue()
  {
    return this.zzaBU;
  }
  
  public String getSnapshotId()
  {
    return this.zzavx;
  }
  
  public String getTitle()
  {
    return this.zzajf;
  }
  
  public String getUniqueName()
  {
    return this.zzaBS;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public boolean hasChangePending()
  {
    return this.zzaBT;
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
    SnapshotMetadataEntityCreator.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\snapshot\SnapshotMetadataEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */