package com.squareup.okhttp.internal;

import java.net.InetAddress;
import java.net.UnknownHostException;

public abstract interface Network
{
  public static final Network DEFAULT = new Network()
  {
    public InetAddress[] resolveInetAddresses(String paramAnonymousString)
      throws UnknownHostException
    {
      if (paramAnonymousString == null) {
        throw new UnknownHostException("host == null");
      }
      return InetAddress.getAllByName(paramAnonymousString);
    }
  };
  
  public abstract InetAddress[] resolveInetAddresses(String paramString)
    throws UnknownHostException;
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\squareup\okhttp\internal\Network.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */