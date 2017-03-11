package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class RoomBuffer
  extends zzf<Room>
{
  public RoomBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected String zzoy()
  {
    return "external_match_id";
  }
  
  protected Room zzp(int paramInt1, int paramInt2)
  {
    return new RoomRef(this.zzabq, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\multiplayer\realtime\RoomBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */