package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class ParticipantBuffer
  extends AbstractDataBuffer<Participant>
{
  public Participant get(int paramInt)
  {
    return new ParticipantRef(this.zzabq, paramInt);
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\games\multiplayer\ParticipantBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */