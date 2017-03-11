package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzmo;

public final class EventEntity
  implements SafeParcelable, Event
{
  public static final EventEntityCreator CREATOR = new EventEntityCreator();
  private final String mName;
  private final int mVersionCode;
  private final String zzaqZ;
  private final String zzatF;
  private final Uri zzatu;
  private final PlayerEntity zzaux;
  private final String zzavb;
  private final long zzavc;
  private final String zzavd;
  private final boolean zzave;
  
  EventEntity(int paramInt, String paramString1, String paramString2, String paramString3, Uri paramUri, String paramString4, Player paramPlayer, long paramLong, String paramString5, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzavb = paramString1;
    this.mName = paramString2;
    this.zzaqZ = paramString3;
    this.zzatu = paramUri;
    this.zzatF = paramString4;
    this.zzaux = new PlayerEntity(paramPlayer);
    this.zzavc = paramLong;
    this.zzavd = paramString5;
    this.zzave = paramBoolean;
  }
  
  public EventEntity(Event paramEvent)
  {
    this.mVersionCode = 1;
    this.zzavb = paramEvent.getEventId();
    this.mName = paramEvent.getName();
    this.zzaqZ = paramEvent.getDescription();
    this.zzatu = paramEvent.getIconImageUri();
    this.zzatF = paramEvent.getIconImageUrl();
    this.zzaux = ((PlayerEntity)paramEvent.getPlayer().freeze());
    this.zzavc = paramEvent.getValue();
    this.zzavd = paramEvent.getFormattedValue();
    this.zzave = paramEvent.isVisible();
  }
  
  static int zza(Event paramEvent)
  {
    return zzw.hashCode(new Object[] { paramEvent.getEventId(), paramEvent.getName(), paramEvent.getDescription(), paramEvent.getIconImageUri(), paramEvent.getIconImageUrl(), paramEvent.getPlayer(), Long.valueOf(paramEvent.getValue()), paramEvent.getFormattedValue(), Boolean.valueOf(paramEvent.isVisible()) });
  }
  
  static boolean zza(Event paramEvent, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Event)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramEvent == paramObject);
      paramObject = (Event)paramObject;
      if ((!zzw.equal(((Event)paramObject).getEventId(), paramEvent.getEventId())) || (!zzw.equal(((Event)paramObject).getName(), paramEvent.getName())) || (!zzw.equal(((Event)paramObject).getDescription(), paramEvent.getDescription())) || (!zzw.equal(((Event)paramObject).getIconImageUri(), paramEvent.getIconImageUri())) || (!zzw.equal(((Event)paramObject).getIconImageUrl(), paramEvent.getIconImageUrl())) || (!zzw.equal(((Event)paramObject).getPlayer(), paramEvent.getPlayer())) || (!zzw.equal(Long.valueOf(((Event)paramObject).getValue()), Long.valueOf(paramEvent.getValue()))) || (!zzw.equal(((Event)paramObject).getFormattedValue(), paramEvent.getFormattedValue()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(Boolean.valueOf(((Event)paramObject).isVisible()), Boolean.valueOf(paramEvent.isVisible())));
    return false;
  }
  
  static String zzb(Event paramEvent)
  {
    return zzw.zzv(paramEvent).zzg("Id", paramEvent.getEventId()).zzg("Name", paramEvent.getName()).zzg("Description", paramEvent.getDescription()).zzg("IconImageUri", paramEvent.getIconImageUri()).zzg("IconImageUrl", paramEvent.getIconImageUrl()).zzg("Player", paramEvent.getPlayer()).zzg("Value", Long.valueOf(paramEvent.getValue())).zzg("FormattedValue", paramEvent.getFormattedValue()).zzg("isVisible", Boolean.valueOf(paramEvent.isVisible())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Event freeze()
  {
    return this;
  }
  
  public String getDescription()
  {
    return this.zzaqZ;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzaqZ, paramCharArrayBuffer);
  }
  
  public String getEventId()
  {
    return this.zzavb;
  }
  
  public String getFormattedValue()
  {
    return this.zzavd;
  }
  
  public void getFormattedValue(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.zzavd, paramCharArrayBuffer);
  }
  
  public Uri getIconImageUri()
  {
    return this.zzatu;
  }
  
  public String getIconImageUrl()
  {
    return this.zzatF;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    zzmo.zzb(this.mName, paramCharArrayBuffer);
  }
  
  public Player getPlayer()
  {
    return this.zzaux;
  }
  
  public long getValue()
  {
    return this.zzavc;
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
  
  public boolean isVisible()
  {
    return this.zzave;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    EventEntityCreator.zza(this, paramParcel, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\event\EventEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */