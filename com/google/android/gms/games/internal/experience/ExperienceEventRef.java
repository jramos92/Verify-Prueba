package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.GameRef;

public final class ExperienceEventRef
  extends zzc
  implements ExperienceEvent
{
  private final GameRef zzazi;
  
  public ExperienceEventRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    if (zzcg("external_game_id"))
    {
      this.zzazi = null;
      return;
    }
    this.zzazi = new GameRef(this.zzabq, this.zzadl);
  }
  
  public String getIconImageUrl()
  {
    return getString("icon_url");
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\internal\experience\ExperienceEventRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */