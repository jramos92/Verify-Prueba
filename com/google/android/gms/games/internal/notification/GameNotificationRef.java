package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class GameNotificationRef
  extends zzc
  implements GameNotification
{
  GameNotificationRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public long getId()
  {
    return getLong("_id");
  }
  
  public String getText()
  {
    return getString("text");
  }
  
  public String getTitle()
  {
    return getString("title");
  }
  
  public int getType()
  {
    return getInteger("type");
  }
  
  public String toString()
  {
    return zzw.zzv(this).zzg("Id", Long.valueOf(getId())).zzg("NotificationId", zzvr()).zzg("Type", Integer.valueOf(getType())).zzg("Title", getTitle()).zzg("Ticker", zzvs()).zzg("Text", getText()).zzg("CoalescedText", zzvt()).zzg("isAcknowledged", Boolean.valueOf(zzvu())).zzg("isSilent", Boolean.valueOf(zzvv())).toString();
  }
  
  public String zzvr()
  {
    return getString("notification_id");
  }
  
  public String zzvs()
  {
    return getString("ticker");
  }
  
  public String zzvt()
  {
    return getString("coalesced_text");
  }
  
  public boolean zzvu()
  {
    return getInteger("acknowledged") > 0;
  }
  
  public boolean zzvv()
  {
    return getInteger("alert_level") == 0;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\notification\GameNotificationRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */