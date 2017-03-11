package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;
import java.util.List;

public final class QuestRef
  extends zzc
  implements Quest
{
  private final int zzauX;
  private final Game zzazW;
  
  QuestRef(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.zzazW = new GameRef(paramDataHolder, paramInt1);
    this.zzauX = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return QuestEntity.zza(this, paramObject);
  }
  
  public Quest freeze()
  {
    return new QuestEntity(this);
  }
  
  public long getAcceptedTimestamp()
  {
    return getLong("accepted_ts");
  }
  
  public Uri getBannerImageUri()
  {
    return zzcf("quest_banner_image_uri");
  }
  
  public String getBannerImageUrl()
  {
    return getString("quest_banner_image_url");
  }
  
  public Milestone getCurrentMilestone()
  {
    return (Milestone)zzvP().get(0);
  }
  
  public String getDescription()
  {
    return getString("quest_description");
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zza("quest_description", paramCharArrayBuffer);
  }
  
  public long getEndTimestamp()
  {
    return getLong("quest_end_ts");
  }
  
  public Game getGame()
  {
    return this.zzazW;
  }
  
  public Uri getIconImageUri()
  {
    return zzcf("quest_icon_image_uri");
  }
  
  public String getIconImageUrl()
  {
    return getString("quest_icon_image_url");
  }
  
  public long getLastUpdatedTimestamp()
  {
    return getLong("quest_last_updated_ts");
  }
  
  public String getName()
  {
    return getString("quest_name");
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    zza("quest_name", paramCharArrayBuffer);
  }
  
  public String getQuestId()
  {
    return getString("external_quest_id");
  }
  
  public long getStartTimestamp()
  {
    return getLong("quest_start_ts");
  }
  
  public int getState()
  {
    return getInteger("quest_state");
  }
  
  public int getType()
  {
    return getInteger("quest_type");
  }
  
  public int hashCode()
  {
    return QuestEntity.zza(this);
  }
  
  public boolean isEndingSoon()
  {
    return zzvQ() <= System.currentTimeMillis() + 1800000L;
  }
  
  public String toString()
  {
    return QuestEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((QuestEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
  
  public List<Milestone> zzvP()
  {
    ArrayList localArrayList = new ArrayList(this.zzauX);
    int i = 0;
    while (i < this.zzauX)
    {
      localArrayList.add(new MilestoneRef(this.zzabq, this.zzadl + i));
      i += 1;
    }
    return localArrayList;
  }
  
  public long zzvQ()
  {
    return getLong("notification_ts");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\quest\QuestRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */