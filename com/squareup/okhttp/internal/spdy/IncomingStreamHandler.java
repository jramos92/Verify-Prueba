package com.squareup.okhttp.internal.spdy;

import java.io.IOException;

public abstract interface IncomingStreamHandler
{
  public static final IncomingStreamHandler REFUSE_INCOMING_STREAMS = new IncomingStreamHandler()
  {
    public void receive(SpdyStream paramAnonymousSpdyStream)
      throws IOException
    {
      paramAnonymousSpdyStream.close(ErrorCode.REFUSED_STREAM);
    }
  };
  
  public abstract void receive(SpdyStream paramSpdyStream)
    throws IOException;
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\squareup\okhttp\internal\spdy\IncomingStreamHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */