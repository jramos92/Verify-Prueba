package com.google.android.gms.wearable;

import java.io.IOException;

public class ChannelIOException
  extends IOException
{
  private final int zzbeU;
  private final int zzbeV;
  
  public ChannelIOException(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString);
    this.zzbeU = paramInt1;
    this.zzbeV = paramInt2;
  }
  
  public int getAppSpecificErrorCode()
  {
    return this.zzbeV;
  }
  
  public int getCloseReason()
  {
    return this.zzbeU;
  }
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\google\android\gms\wearable\ChannelIOException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */