package com.squareup.okhttp;

import java.io.IOException;
import java.net.Proxy;

public abstract interface Authenticator
{
  public abstract Request authenticate(Proxy paramProxy, Response paramResponse)
    throws IOException;
  
  public abstract Request authenticateProxy(Proxy paramProxy, Response paramResponse)
    throws IOException;
}


/* Location:              C:\Users\julian\Downloads\Veryfit 2 0_vV2.0.28_apkpure.com-dex2jar.jar!\com\squareup\okhttp\Authenticator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */