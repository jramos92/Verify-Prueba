package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ParticipantRef
  extends zzc
  implements Participant
{
  private final PlayerRef zzaAI;
  
  public ParticipantRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    this.zzaAI = new PlayerRef(paramDataHolder, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return ParticipantEntity.zza(this, paramObject);
  }
  
  public Participant freeze()
  {
    return new ParticipantEntity(this);
  }
  
  public int getCapabilities()
  {
    return getInteger("capabilities");
  }
  
  public String getDisplayName()
  {
    if (zzcg("external_player_id")) {
      return getString("default_display_name");
    }
    return this.zzaAI.getDisplayName();
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (zzcg("external_player_id"))
    {
      zza("default_display_name", paramCharArrayBuffer);
      return;
    }
    this.zzaAI.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    if (zzcg("external_player_id")) {
      return zzcf("default_display_hi_res_image_uri");
    }
    return this.zzaAI.getHiResImageUri();
  }
  
  public String getHiResImageUrl()
  {
    if (zzcg("external_player_id")) {
      return getString("default_display_hi_res_image_url");
    }
    return this.zzaAI.getHiResImageUrl();
  }
  
  public Uri getIconImageUri()
  {
    if (zzcg("external_player_id")) {
      return zzcf("default_display_image_uri");
    }
    return this.zzaAI.getIconImageUri();
  }
  
  public String getIconImageUrl()
  {
    if (zzcg("external_player_id")) {
      return getString("default_display_image_url");
    }
    return this.zzaAI.getIconImageUrl();
  }
  
  public String getParticipantId()
  {
    return getString("external_participant_id");
  }
  
  public Player getPlayer()
  {
    if (zzcg("external_player_id")) {
      return null;
    }
    return this.zzaAI;
  }
  
  public ParticipantResult getResult()
  {
    if (zzcg("result_type")) {
      return null;
    }
    int i = getInteger("result_type");
    int j = getInteger("placing");
    return new ParticipantResult(getParticipantId(), i, j);
  }
  
  public int getStatus()
  {
    return getInteger("player_status");
  }
  
  public int hashCode()
  {
    return ParticipantEntity.zza(this);
  }
  
  public boolean isConnectedToRoom()
  {
    return getInteger("connected") > 0;
  }
  
  public String toString()
  {
    return ParticipantEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((ParticipantEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
  
  public String zzut()
  {
    return getString("client_address");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\multiplayer\ParticipantRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */